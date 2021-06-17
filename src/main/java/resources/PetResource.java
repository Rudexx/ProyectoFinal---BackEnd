package resources;

import edu.unbosque.ProyectoFinal_backend.jpa.services.PetService;
import resources.pojos.PetPOJO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("app/{username}/owners/pets/{id}")
public class PetResource {

    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    public Response modify(@PathParam("username") String username, @PathParam("id") Integer id,
                           @QueryParam("microchip") String microchip,
                           @QueryParam("name") String name ,
                           @QueryParam("specie") String specie,
                           @QueryParam("race") String race,
                           @QueryParam("size") String size,
                           @QueryParam("sex") String sex,
                           @QueryParam("picture") String picture) {

        PetService ps = new PetService();
        Optional<PetPOJO> p = ps.updatePet(username, id, microchip, specie,  race, size,  sex,  picture,  name);



        return Response.ok()
                .entity("Pet was updated")
                .build();
    }


}