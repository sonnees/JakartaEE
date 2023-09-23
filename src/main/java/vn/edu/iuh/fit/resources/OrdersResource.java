package vn.edu.iuh.fit.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.models.Orders;
import vn.edu.iuh.fit.models.ReqObject2Field;
import vn.edu.iuh.fit.models.ReqObject3Field;
import vn.edu.iuh.fit.services.OrdersSer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Path("/Orders")
public class OrdersResource {
    @Inject
    private OrdersSer ordersSer;
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        List<Orders> all = ordersSer.getAll();
        return Response.ok(all).build();
    }

    @GET
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByID(@PathParam("id") int id){
        Orders orders = ordersSer.searchById(id);
        if(orders==null)
            return Response.status(Response.Status.NOT_FOUND).build();

        return Response.ok(orders).build();
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
    @Path("/{x}-{y}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFromXToY(@PathParam("x") int x,@PathParam("y") int y){
        if(x <= 0 || y<x)
            return Response.status(Response.Status.BAD_REQUEST).build();

        List<Orders> fromXToY = ordersSer.getFromXToY(x, y);
        return Response.ok(fromXToY).build();
    }

    @GET
    @Path("/Anal-Year-Month-Day")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAnalYearMonthDay(ReqObject3Field reqObject3Field){
        Map<String, Integer> analYearMonthDay = ordersSer.getAnalYearMonthDay(reqObject3Field);
        if(analYearMonthDay==null)
            return Response.status(Response.Status.BAD_REQUEST).build();

        return Response.ok(analYearMonthDay).build();
    }

    @GET
    @Path("/Anal-Years-Months")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAnalYearMonthDays(LocalDateTime localDateTime){
        Map<String, Integer> analYearMonths = ordersSer.getAnalYearMonths(localDateTime);
        if(analYearMonths==null)
            return Response.status(Response.Status.BAD_REQUEST).build();

        return Response.ok(analYearMonths).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(Orders orders){
        boolean add = ordersSer.add(orders);
        if(!add) return Response.status(Response.Status.BAD_REQUEST).build();

        return Response.ok(orders).build();
    }

    @POST()
    @Path("/add-list")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addList(List<Orders> orders){
        orders.forEach(p->{
            boolean add = ordersSer.add(p);
        });
        return Response.ok(orders).build();
    }

    @PUT()
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") long id, Orders orders){
        Orders temp = ordersSer.searchById(id);
        if(temp == null) return Response.status(Response.Status.NOT_FOUND).build();
        boolean update = ordersSer.add(orders);
        if(!update) return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(orders).build();
    }

    @PUT()
    @Path("/{id}/update-field")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateField(@PathParam("id") long id, ReqObject2Field reqObject2Field){
        boolean update = ordersSer.updateField(id, reqObject2Field.getField_1(), reqObject2Field.getField_2());
        if(!update) return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(reqObject2Field).build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response del(@PathParam("id") long id){
        boolean del = ordersSer.del(id);
        if(!del) return Response.status(Response.Status.NOT_FOUND).build();

        return  Response.ok(id).build();
    }

    @DELETE
    @Path("/delete-multiple")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response delMultiple(List<Long> list){
        List<Long> listDel = new ArrayList<>();

        list.forEach(i->{
            Response del = del(i);
            if(del.getStatus()!=200) return;
            else listDel.add(i);
        });

        return  Response.ok(listDel).build();
    }
}


