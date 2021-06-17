//package resources;
//
//import javax.ws.rs.*;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//import java.util.ArrayList;
//import java.util.List;
//
//@Path("/owners/{person_Id}/pets/{pet_id}/image")
//public class ImageResource {
//
//
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response list(@PathParam("pet_id") Integer pet_id) {
//
//        List<ImagePOJO> images = new ArrayList<ImagePOJO>();
//        images.add(new ImagePOJO("123" , "Base64Code1"));
//
//
//        return Response.ok()
//                .entity(images)
//                .build();
//    }
//
//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response create(@PathParam("person_Id") Integer personId, @PathParam("pet_id") Integer pet_id , ImagePOJO image) {
//
//
//
//        return Response.status(Response.Status.CREATED)
//                .entity(image)
//                .build();
//    }
//
//
//
//
//
//
//
//
//
//}
