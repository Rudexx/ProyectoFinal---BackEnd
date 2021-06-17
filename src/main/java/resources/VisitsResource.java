package resources;


import edu.unbosque.ProyectoFinal_backend.jpa.services.VisitService;
import resources.pojos.VisitPOJO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("app/{username}/vets/visits/{petId}")
public class VisitsResource {


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@PathParam("username") String username, @PathParam("petId") Integer petId,
                           @QueryParam("created_at") String created_at,
                           @QueryParam("type") String type,
                           @QueryParam("description") String description) {
        VisitService visit = new VisitService();
        visit.createVisit(username,petId,created_at,type, description);

        return Response.status(Response.Status.CREATED)
                .entity(visit)
                .build();
    }
    @GET
    @Path("/list-by-pet")
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(@PathParam("petId") int petId) {
        VisitService visit = new VisitService();
        List<VisitPOJO> list = visit.listVisitsByPet(petId);


        return Response.status(Response.Status.OK)
                .entity(list)
                .build();
    }
    @GET
    @Path("/list-by-vet")
    @Produces(MediaType.APPLICATION_JSON)
    public Response listbyvet(@PathParam("username") String username) {
        VisitService visit = new VisitService();
        List<VisitPOJO> list = visit.listVisitsByVet(username);

        return Response.status(Response.Status.CREATED)
                .entity(list)
                .build();
    }
}