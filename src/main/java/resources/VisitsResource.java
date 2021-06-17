//package resources;
//
//
//import javax.ws.rs.*;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//import java.util.ArrayList;
//import java.util.List;
//
//
//@Path("/vets/{username}/visits")
//public class VisitsResource {
//
//
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response create(@PathParam("username") String username, VisitPOJO visit) {
//        List<VisitPOJO> visits = new ArrayList<VisitPOJO>();
//        visits.add(visit);
//
//        return Response.status(Response.Status.CREATED)
//                .entity(visit)
//                .build();
//    }
//}