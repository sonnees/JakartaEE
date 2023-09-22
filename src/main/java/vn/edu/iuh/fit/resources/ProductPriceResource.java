package vn.edu.iuh.fit.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.models.Product;
import vn.edu.iuh.fit.models.ProductPrice;
import vn.edu.iuh.fit.models.ReqObject2Field;
import vn.edu.iuh.fit.models.ReqObject3Field;
import vn.edu.iuh.fit.services.ProductPriceSer;
import vn.edu.iuh.fit.services.ProductSer;

import java.net.URLDecoder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Path("/ProductPrice")
public class ProductPriceResource {
    @Inject
    private ProductPriceSer productPriceSer;
    @Inject
    private ProductSer productSer;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");

    @GET
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(@PathParam("id") long id){
        System.out.println("oke");
        List<ProductPrice> all = productPriceSer.getAll(id);
        return Response.ok(all).build();
    }

    /**
     * Lấy các ProductPrice có product_id = id và lấy từ x đến y.
     * @param id: product_id
     * @param x: là vị trí bắt đầu. x > 0 vì trong cơ sở dữ liệu dòng bắt đầu bằng 1
     * @param y: là vị trí kết thúc. y > x vì dòng đến không thể bé hơn dòng đi.
     * @return [dòng x, dòng y]
     */
    @GET
    @Path("/{id}/{x}/{y}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFromXToY(@PathParam("id") long id,@PathParam("x") int x,@PathParam("y") int y){
        if(x <= 0 || y<x)
            return Response.status(Response.Status.BAD_REQUEST).build();

        List<ProductPrice> fromXToY = productPriceSer.getFromXToY(id,x, y);
        if(fromXToY==null) return Response.status(Response.Status.NOT_FOUND).build();

        return Response.ok(fromXToY).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(ProductPrice productPrice){
        boolean add = productPriceSer.add(productPrice);
        if(add) return Response.status(Response.Status.BAD_REQUEST).build();

        return Response.ok(productPrice).build();
    }

    @POST()
    @Path("/add-list")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addList(List<ProductPrice> productPrices){
        List<ProductPrice> temp = new ArrayList<>();
        productPrices.forEach(p->{
            boolean add = productPriceSer.add(p);
            if(add) temp.add(p);
        });
        return Response.ok(temp).build();
    }

    @PUT
    @Path("/{product_id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateField(@PathParam("product_id") long product_id, ReqObject3Field reqObject3Field){
        LocalDateTime localDateTime = null;
        try {
            localDateTime = LocalDateTime.parse(reqObject3Field.getField_1(),formatter);
        }
        catch (Exception e){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        Product product = productSer.searchById(product_id);
        if(product==null) return Response.status(Response.Status.NOT_FOUND).build();
        ProductPrice id = new ProductPrice(localDateTime,product);
        boolean update = productPriceSer.updateField(id, reqObject3Field.getField_2(), reqObject3Field.getField_3());

        if(!update) return Response.status(Response.Status.NOT_FOUND).build();
        ProductPrice productPriceUpdate = productPriceSer.searchById(id);
        return Response.ok(productPriceUpdate).build();
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response del(ReqObject2Field reqObject2Field){
        LocalDateTime localDateTime = null;
        try {
            localDateTime = LocalDateTime.parse(reqObject2Field.getField_1(),formatter);
        }
        catch (Exception e){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        Product product = productSer.searchById(Integer.parseInt(reqObject2Field.getField_2()));
        if(product==null) return Response.status(Response.Status.NOT_FOUND).build();

        ProductPrice id = new ProductPrice(localDateTime,product);
        boolean del = productPriceSer.del(id);
        if(!del) return Response.status(Response.Status.NOT_FOUND).build();

        return  Response.ok(reqObject2Field).build();
    }

    @DELETE
    @Path("/delete-multiple")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response delMultiple(List<ReqObject2Field> list){
        List<ReqObject2Field> temp = new ArrayList<>();
        list.forEach(id->{
            Response del = del(id);
            if(del.getStatus()!=200) return;
            else temp.add(id);
        });

        return  Response.ok(temp).build();
    }
}
