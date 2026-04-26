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


@WebServlet("/teste")
public class FetchAPI extends HttpServlet{

//    @Override
//    public void init(ServletConfig config) throws ServletException{
//        super.init(config);
//
//        try{
//           ApodData data = FetchApi();
//           getServletContext().setAttribute("apiData", data);
//        }catch (InterruptedException | IOException exception){
//            System.out.println(exception.getMessage());
//        }
//
//    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException{
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException{

        try{
            String date = request.getParameter("dateUser");
            ApodData data = FetchApi(date);
            request.setAttribute("apiData", data);
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }catch (InterruptedException | IOException exception){
            System.out.println(exception.getMessage());
        }

    }

    private ApodData FetchApi(URI uri) throws IOException, InterruptedException {
        ObjectMapper mapper = new ObjectMapper();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest req = HttpRequest.newBuilder().uri(uri).build();

        HttpResponse<String> res = client.send(req , HttpResponse.BodyHandlers.ofString());

        return mapper.readValue(res.body(), ApodData.class);

    }

    private ApodData FetchApi() throws IOException, InterruptedException {
        String url = "https://api.nasa.gov/planetary/apod?api_key=pTnwkhJ6s9EHoJJCMsIcf7jr5bLtXaZVKgObZqxz";
        URI uri = URI.create(url);
        return FetchApi(uri);
    }

    private ApodData FetchApi(String dateUser) throws IOException, InterruptedException{
        String url = "https://api.nasa.gov/planetary/apod?api_key=pTnwkhJ6s9EHoJJCMsIcf7jr5bLtXaZVKgObZqxz&date="+dateUser;
        URI uri = URI.create(url);
        System.out.println(url);
        return FetchApi(uri);
    }
}

