package resources;

import resources.pojos.OwnerPOJO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("owners")
public class OwnersResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response list(@DefaultValue("0") @QueryParam("id") int person_id,
                         @QueryParam("neighbourhood") String neighbourhood
            , @QueryParam("name") String name) {


        return Response.status(Response.Status.NOT_FOUND).
                entity("Owner Not Found")
                .build();
    }


}
