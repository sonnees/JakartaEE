package vn.edu.iuh.fit.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.models.ProductPrice;
import vn.edu.iuh.fit.services.ProductPriceSer;

import java.util.List;

@Path("/ProductPrice")
public class ProductPriceResource {
    private ProductPriceSer productPriceSer;

    public ProductPriceResource() {
        productPriceSer = new ProductPriceSer();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addProductPrice(ProductPrice productPrice){
        productPriceSer.addProductPrice(productPrice);
        return Response.ok(productPrice).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<ProductPrice> getAll(){
        return productPriceSer.getAll();
    }
}
