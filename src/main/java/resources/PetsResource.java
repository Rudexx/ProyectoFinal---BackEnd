package resources;

import edu.unbosque.ProyectoFinal_backend.jpa.entities.Pet;
import edu.unbosque.ProyectoFinal_backend.jpa.services.PetService;
import resources.pojos.PetPOJO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Path("app/{username}/owners/pets")
public class PetsResource {


    @PUT
    @Produces(MediaType.TEXT_PLAIN)
    public Response create(@PathParam("username") String username,
                         @QueryParam("microchip") String microchip,
                         @QueryParam("name") String name ,
                         @QueryParam("specie") String specie,
                         @QueryParam("race") String race,
                         @QueryParam("size") String size,
                         @QueryParam("sex") String sex,
                            @QueryParam("picture") String picture){

        PetService ps = new PetService();
        Optional<PetPOJO> p = ps.createPet(username, microchip, specie,  race, size,  sex,  picture,  name );


        if(p.isPresent()){
            return Response.status(Response.Status.CREATED).
                    entity("Pet was created Successfully")
                    .build();
        }
        return Response.status(Response.Status.NOT_FOUND).
                entity("Owner doesn't exist")
                .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(@PathParam("username") String username){

        PetService ps = new PetService();

            List<PetPOJO> list = ps.listPetsByUsername(username);





        return Response.status(Response.Status.OK).
                entity(list)
                .build();
    }

//    @POST
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response create(@PathParam("person_Id") Integer personId, PetPOJO p) {
//
//        p.setPet_id(3);
//
//        return Response.status(Response.Status.CREATED)
//                .entity(p)
//                .build();
//    }









}
