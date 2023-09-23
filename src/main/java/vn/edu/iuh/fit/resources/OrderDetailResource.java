package vn.edu.iuh.fit.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.models.*;
import vn.edu.iuh.fit.services.OrderDetailSer;
import vn.edu.iuh.fit.services.OrdersSer;
import vn.edu.iuh.fit.services.ProductPriceSer;
import vn.edu.iuh.fit.services.ProductSer;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Path("/OrderDetail")
public class OrderDetailResource {
    @Inject
    private OrderDetailSer orderDetailSer;
    @Inject
    private ProductSer productSer;
    @Inject
    private OrdersSer ordersSer;

    @GET
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(@PathParam("id") long id){
        List<OrderDetail> all = orderDetailSer.getAll(id);
        return Response.ok(all).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(OrderDetail orderDetail){
        boolean add = orderDetailSer.add(orderDetail);
        if(add) return Response.status(Response.Status.BAD_REQUEST).build();

        return Response.ok(orderDetail).build();
    }

    @POST()
    @Path("/add-list")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addList(List<OrderDetail> productPrices){
        List<OrderDetail> temp = new ArrayList<>();
        productPrices.forEach(p->{
            boolean add = orderDetailSer.add(p);
            if(add) temp.add(p);
        });
        return Response.ok(temp).build();
    }

    @DELETE
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response del(ReqObject2Field reqObject2Field){
        Orders orders = ordersSer.searchById(Long.parseLong(reqObject2Field.getField_1()));
        if(orders==null) return Response.status(Response.Status.NOT_FOUND).build();

        Product product = productSer.searchById(Long.parseLong(reqObject2Field.getField_2()));
        if(product==null) return Response.status(Response.Status.NOT_FOUND).build();

        OrderDetail orderDetail = new OrderDetail(orders,product);

        boolean del = orderDetailSer.del(orderDetail);
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
