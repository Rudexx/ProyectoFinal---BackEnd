package resources;

import edu.unbosque.ProyectoFinal_backend.jpa.entities.Owner;
import edu.unbosque.ProyectoFinal_backend.jpa.services.OwnerService;
import resources.pojos.OwnerPOJO;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;
import java.util.Optional;

@Path("app/{username}/owners")
public class OwnerResource {

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response modify(@PathParam("username") String username, @QueryParam("address") String address, @QueryParam("neighbourhood") String neighbourhood) {

        OwnerService o = new OwnerService();


        Optional<Owner> owner = o.updateOwner(username, address, neighbourhood);

        if(owner.isPresent()){
            return Response.ok()
                    .entity(owner)
                    .build();
        }
        return Response.status(Response.Status.NOT_FOUND)
                .entity("Owner Doesn't exist!!!")
                .build();

    }





}