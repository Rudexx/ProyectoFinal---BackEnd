package resources;


import edu.unbosque.ProyectoFinal_backend.jpa.entities.Owner;
import edu.unbosque.ProyectoFinal_backend.jpa.entities.Vet;
import edu.unbosque.ProyectoFinal_backend.jpa.services.OwnerService;
import edu.unbosque.ProyectoFinal_backend.jpa.services.VetService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("app/{username}/vets")
public class VetResource {

    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    public Response modify(@PathParam("username") String username,
                           @QueryParam("address") String address,
                           @QueryParam("neighbourhood") String neighbourhood) {

        VetService v = new VetService();


        Optional<Vet> vet = v.updateVet(username, address, neighbourhood);

        if(vet.isPresent()){
            return Response.ok()
                    .entity("updated!!!")
                    .build();
        }
        return Response.status(Response.Status.NOT_FOUND)
                .entity("Vet Doesn't exist!!!")
                .build();


    }



}