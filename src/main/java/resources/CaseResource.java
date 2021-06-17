package resources;


import edu.unbosque.ProyectoFinal_backend.jpa.services.CaseService;
import resources.pojos.PetCasePOJO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;


@Path("app/{username}/owners/pets/{petId}/petCase")
public class CaseResource {
    /**
     * Este metodo crea los casos de las mascotas
     * @param username Es el nombre de usuario que tiene la persona
     * @param petId Es la ID que tiene la mascota a la que se le hara el caso
     * @param created_at Es la fecha de creacion que tiene el caso
     * @param type Es el tipo de caso que se creo
     * @param description Es la descripcion exacta del caso
     * @return Se devuelve la respuesta del servidor sobre el exito al crear el caso
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@PathParam("username") String username, @PathParam("petId") Integer petId,
                           @QueryParam("created_at") String created_at,
                           @QueryParam("type") String type,
                           @QueryParam("description") String description) {

        CaseService c = new CaseService();
        c.createCase(username,  petId,  created_at,  type,  description);


        return Response.status(Response.Status.CREATED)
                .entity("D")
                .build();
    }

    /**
     * Este metodo busca al usuario y a la mascota para crear el caso
     * @param petId Es la ID que tiene la mascota que se desea viendo
     * @param username Es el Nombre de usuario que tiene la persona
     * @return Es la respuesta del servidor
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@PathParam("petId") int petId, @PathParam("username") String username) {

        CaseService c = new CaseService();
        List<PetCasePOJO> list = c.listCasesByPet(username);


        return Response.status(Response.Status.OK)
                .entity(list)
                .build();
    }



}