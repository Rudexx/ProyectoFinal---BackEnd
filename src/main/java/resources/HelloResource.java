//package resources;
//
//import javax.ws.rs.*;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//
//@Path("/hello-world")
//public class HelloResource {
//
//    @GET
//    @Produces("text/plain")
//    public String hello() {
//        return "Hello, World!";
//    }
//
//    @GET
//    @Path("/{name}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response hello(@PathParam("name") String name) {
//        return Response.status(200)
//                .entity(new Notification("Hello, World! " + name))
//                .build();
//    }
//
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response hello(Employee employee) {
//        return Response.ok()
//                .entity(new Notification("Hello, " + employee.getRole() + " " + employee.getName()))
//                .build();
//    }
//
//}