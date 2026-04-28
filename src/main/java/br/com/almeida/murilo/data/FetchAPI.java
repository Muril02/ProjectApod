package br.com.almeida.murilo.data;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.cdimascio.dotenv.Dotenv;


@WebServlet("/teste")
public class FetchAPI extends HttpServlet{

    private String apodKey;
    
   @Override
   public void init() throws ServletException{
        super.init();

        Dotenv dotenv = Dotenv.configure()
        .directory("./src/main/resources")
        .load();

        this.apodKey  = dotenv.get("APOD_KEY");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException{

        try{
            String date = request.getParameter("dateUser");
            ApodData data = fetchApi(date);
            request.setAttribute("apiData", data);
            request.getRequestDispatcher("index.jsp").forward(request, response);
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

    private ApodData fetchApi() throws IOException, InterruptedException {
        String url = "https://api.nasa.gov/planetary/apod?api_key="+ApodKey;
        URI uri = URI.create(url);
        return fetchApi(uri);
    }

    private ApodData fetchApi(String dateUser) throws IOException, InterruptedException{
        String url = "https://api.nasa.gov/planetary/apod?api_key="+ApodKey+"&date="+dateUser;
        URI uri = URI.create(url);
        System.out.println(url);
        return fetchApi(uri);
    }
}

