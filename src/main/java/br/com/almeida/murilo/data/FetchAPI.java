package br.com.almeida.murilo.data;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.cdimascio.dotenv.Dotenv;


@WebServlet("/teste")
public class FetchAPI extends HttpServlet{

    private String apodKey;
    
   @Override
   public void init() throws ServletException{
        super.init();

        Dotenv dotenv = Dotenv.load();

        this.apodKey  = dotenv.get("APOD_KEY");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException{

        try{

            if(request.getParameterMap().size() > 1){
                String typeOp = request.getParameter("tipoOperacao");
                String date = request.getParameter("dateNow");
                ApodData data = fetchApi(date, typeOp);
                request.setAttribute("apiData", data);
                request.getRequestDispatcher("apod.jsp").forward(request, response);
            }else {
                String date = request.getParameter("dateUser");
                ApodData data = fetchApi(date);
                request.setAttribute("apiData", data);
                request.getRequestDispatcher("apod.jsp").forward(request, response);
            }

        }catch (InterruptedException | IOException exception){
            System.out.println(exception.getMessage());
        }
    }

    private ApodData fetchApi(URI uri) throws IOException, InterruptedException {
        ObjectMapper mapper = new ObjectMapper();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest req = HttpRequest.newBuilder().uri(uri).build();

        HttpResponse<String> res = client.send(req , HttpResponse.BodyHandlers.ofString());

        return mapper.readValue(res.body(), ApodData.class);

    }

    private ApodData fetchApi(String dateUser) throws IOException, InterruptedException{
       StringBuilder str = new StringBuilder(dateUser);
        str.insert(2, "/").insert(5, "/");
        String dateUserFormatted = str.toString();

        LocalDate receivedDate = LocalDate.parse(dateUserFormatted, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String newDate = receivedDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));

        String url = "https://api.nasa.gov/planetary/apod?api_key="+apodKey+"&date="+newDate;
        URI uri = URI.create(url);
        System.out.println(url);
        return fetchApi(uri);
    }

    private ApodData fetchApi(String dateNow, String tipoOperacao) throws IOException, InterruptedException{
        LocalDate oldDateRaw = LocalDate.parse(dateNow);

       if (tipoOperacao.equals("+")) {
           String updatedDate = oldDateRaw.plusDays(1).toString();

           String url = "https://api.nasa.gov/planetary/apod?api_key="+apodKey+"&date="+updatedDate;
           URI uri = URI.create(url);
           return fetchApi(uri);
       }else{
            String updatedDate = oldDateRaw.minusDays(1).toString();

            String url = "https://api.nasa.gov/planetary/apod?api_key="+apodKey+"&date="+updatedDate;
            URI uri = URI.create(url);
            return fetchApi(uri);
        }
    }

}

