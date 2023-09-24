package vn.edu.iuh.fit.BackEnd.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.BackEnd.models.Customer;
import vn.edu.iuh.fit.BackEnd.models.Product;
import vn.edu.iuh.fit.BackEnd.models.ReqObject2Field;
import vn.edu.iuh.fit.BackEnd.services.CustomerSer;
import vn.edu.iuh.fit.BackEnd.services.ProductSer;

import java.util.ArrayList;
import java.util.List;

@Path("/Customer")
public class CustomerResource {
    @Inject
    private CustomerSer customerSer;
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        List<Customer> all = customerSer.getAll();
        return Response.ok(all).build();
    }

    @GET
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByID(@PathParam("id") int id){
        Customer customer = customerSer.searchById(id);
        if(customer==null)
            return Response.status(Response.Status.NOT_FOUND).build();

        return Response.ok(customer).build();
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

        List<Customer> fromXToY = customerSer.getFromXToY(x, y);
        return Response.ok(fromXToY).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(Customer customer){
        boolean add = customerSer.add(customer);
        if(!add) return Response.status(Response.Status.BAD_REQUEST).build();

        return Response.ok(customer).build();
    }

    @POST()
    @Path("/add-list")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addList(List<Customer> customers){
        customers.forEach(p->{
            boolean add = customerSer.add(p);
        });
        return Response.ok(customers).build();
    }

    @PUT()
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") long id, Customer customer){
        Customer temp = customerSer.searchById(id);
        if(temp == null) return Response.status(Response.Status.NOT_FOUND).build();
        boolean update = customerSer.add(customer);
        if(!update) return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(customer).build();
    }

    @PUT()
    @Path("/{id}/update-field")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateField(@PathParam("id") long id, ReqObject2Field reqObject2Field){
        boolean update = customerSer.updateField(id, reqObject2Field.getField_1(), reqObject2Field.getField_2());
        if(!update) return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(reqObject2Field).build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response del(@PathParam("id") long id){
        boolean del = customerSer.del(id);
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
