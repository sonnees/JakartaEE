package vn.edu.iuh.fit.resources;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import vn.edu.iuh.fit.models.Employee;
import vn.edu.iuh.fit.models.Product;
import vn.edu.iuh.fit.models.ReqObject2Field;
import vn.edu.iuh.fit.services.EmployeeSer;
import vn.edu.iuh.fit.services.ProductSer;

import java.util.ArrayList;
import java.util.List;

@Path("/Employee")
public class EmployeeResource {
    @Inject
    private EmployeeSer employeeSer;
    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        List<Employee> all = employeeSer.getAll();
        return Response.ok(all).build();
    }

    @GET
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getByID(@PathParam("id") int id){
        Employee employee = employeeSer.searchById(id);
        if(employee==null)
            return Response.status(Response.Status.NOT_FOUND).build();

        return Response.ok(employee).build();
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

        List<Employee> fromXToY = employeeSer.getFromXToY(x, y);
        return Response.ok(fromXToY).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(Employee employee){
        boolean add = employeeSer.add(employee);
        if(!add) return Response.status(Response.Status.BAD_REQUEST).build();

        return Response.ok(employee).build();
    }

    @POST()
    @Path("/add-list")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addList(List<Employee> employees){
        employees.forEach(p->{
            boolean add = employeeSer.add(p);
        });
        return Response.ok(employees).build();
    }

    @PUT()
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response update(@PathParam("id") long id, Employee employee){
        Employee temp = employeeSer.searchById(id);
        if(temp == null) return Response.status(Response.Status.NOT_FOUND).build();
        boolean update = employeeSer.add(employee);
        if(!update) return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(employee).build();
    }

    @PUT()
    @Path("/{id}/update-field")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateField(@PathParam("id") long id, ReqObject2Field reqObject2Field){
        boolean update = employeeSer.updateField(id, reqObject2Field.getField_1(), reqObject2Field.getField_2());
        if(!update) return Response.status(Response.Status.NOT_FOUND).build();
        return Response.ok(reqObject2Field).build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response del(@PathParam("id") long id){
        boolean del = employeeSer.del(id);
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
