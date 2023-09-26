package vn.edu.iuh.fit.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import models.Product;
import models.ReqObject2Field;
import models.ReqObject3Field;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;

public class ProductModel {
    ObjectMapper objectMapper = new ObjectMapper();
    public List<Product> getAll() throws URISyntaxException, IOException, InterruptedException {
        String uri = "http://localhost:8080/JakartaEE/api/Product";
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(new URI(uri))
                .GET().build();
        HttpClient httpClient = HttpClient.newHttpClient();

        HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());

        CollectionType collectionType = objectMapper.getTypeFactory().constructCollectionType(List.class, Product.class);

        return objectMapper.readValue(response.body(), collectionType);
    }

    public boolean add(Product product) throws URISyntaxException, IOException, InterruptedException {
        String uri = "http://localhost:8080/JakartaEE/api/Product";
        String s = objectMapper.writeValueAsString(product);
        System.out.println(s);
        HttpRequest.BodyPublisher bodyPublisher = HttpRequest.BodyPublishers.ofString(s);

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(new URI(uri))
                .POST(bodyPublisher)
                .header("Content-Type", "application/json")
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();
        HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        return response.body().equals("true");
    }

    public boolean delete(int id) throws URISyntaxException, IOException, InterruptedException {
        String uri = "http://localhost:8080/JakartaEE/api/Product/"+id;
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(new URI(uri))
                .DELETE().build();
        HttpClient httpClient = HttpClient.newHttpClient();

        HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        return response.body().equals("true");
    }

    public List<ReqObject2Field> analYearMonthDay(ReqObject3Field reqObject3Field) throws URISyntaxException, IOException, InterruptedException {
        String uri = "http://localhost:8080/JakartaEE/api/Orders/Anal-Year-Month-Day";

        String s = objectMapper.writeValueAsString(reqObject3Field);
        System.out.println(s);
        HttpRequest.BodyPublisher bodyPublisher = HttpRequest.BodyPublishers.ofString(s);

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(new URI(uri))
                .POST(bodyPublisher)
                .header("Content-Type", "application/json")
                .build();

        HttpClient httpClient = HttpClient.newHttpClient();

        HttpResponse<String> response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        CollectionType collectionType = objectMapper.getTypeFactory().constructCollectionType(List.class, ReqObject2Field.class);

        return objectMapper.readValue(response.body(), collectionType);
    }

}
