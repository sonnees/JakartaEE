package vn.edu.iuh.fit.model;

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

public class OrdersModel {
    ObjectMapper objectMapper = new ObjectMapper();

}
