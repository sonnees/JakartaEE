package vn.edu.iuh.fit.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.models.ProductPrice;
import vn.edu.iuh.fit.services.ProductPriceSer;

import java.net.URLDecoder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Path("/ProductPrice")
public class ProductPriceResource {
    @Inject
    private ProductPriceSer productPriceSer;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
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
        productPrices.forEach(p->{
            boolean add = productPriceSer.add(p);
        });
        return Response.ok().build();
    }

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        List<ProductPrice> all = productPriceSer.getAll();
        return Response.ok(all).build();
    }

    /**
     * Lấy các Product từ x đến y.
     * Theo dòng trong cơ sở dữ liệu, không phải theo id
     *
     * @param x: là vị trí bắt đầu. x > 0 vì trong cơ sở dữ liệu dòng bắt đầu bằng 1
     * @param y: là vị trí kết thúc. y > x vì dòng đến không thể bé hơn dòng đi.
     * @return [dòng x, dòng y]
     */
    @GET
    @Path("/{x}/{y}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFromXToY(@PathParam("x") int x,@PathParam("y") int y){
        if(x <= 0 || y<x)
            return Response.status(Response.Status.BAD_REQUEST).build();

        List<ProductPrice> fromXToY = productPriceSer.getFromXToY(x, y);
        return Response.ok(fromXToY).build();
    }

    @GET
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByID(@PathParam("id") long id,@QueryParam("localDateTime") String strDate){
        LocalDateTime localDateTime = null;

        try {
            strDate = strDate.replace("%20", " ");
            localDateTime = LocalDateTime.parse(strDate,formatter);
        }
         catch (Exception e){
             return Response.status(Response.Status.BAD_REQUEST).build();
         }

        ProductPrice productPrice = productPriceSer.searchById(id,localDateTime);

        if(productPrice==null)
            return Response.status(Response.Status.NOT_FOUND).build();

        return Response.ok(productPrice).build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response del(@PathParam("id") long id,@QueryParam("localDateTime") String strDate){
        LocalDateTime localDateTime = null;
        try {
            localDateTime = LocalDateTime.parse(strDate,formatter);
        }
        catch (Exception e){
            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        boolean del = productPriceSer.del(id,localDateTime);
        if(!del) return Response.status(Response.Status.NOT_FOUND).build();

        return  Response.ok().build();
    }
}
