//package resources;
//
//
//import javax.ws.rs.Consumes;
//import javax.ws.rs.POST;
//import javax.ws.rs.Path;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//import java.util.ArrayList;
//import java.util.List;
//
//
//@Path("/vets")
//public class VetsResource {
//
//
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response create(VetPOJO vet) {
//        List<VetPOJO> vets = new ArrayList<VetPOJO>();
//        vets.add(vet);
//
//        return Response.status(Response.Status.CREATED)
//                .entity(vets)
//                .build();
//    }
//
//
//
//
//}
