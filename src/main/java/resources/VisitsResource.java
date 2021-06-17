package resources;


import edu.unbosque.ProyectoFinal_backend.jpa.services.VisitService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;


@Path("/vets/{username}/visits/{petId}")
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
}