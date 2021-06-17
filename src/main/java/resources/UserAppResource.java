package resources;

import edu.unbosque.ProyectoFinal_backend.jpa.services.OfficialService;
import edu.unbosque.ProyectoFinal_backend.jpa.services.OwnerService;
import edu.unbosque.ProyectoFinal_backend.jpa.services.UserAppService;
import edu.unbosque.ProyectoFinal_backend.jpa.services.VetService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/app")
public class UserAppResource {



    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response create(@QueryParam("username") String username
            , @QueryParam("password") String password ,
            @QueryParam("email") String email,
            @QueryParam("role") String role,
              @QueryParam("name") String name
            , @QueryParam("neighbourhood") String neighbourhood ,
             @QueryParam("address") String address) {

        if(role.equalsIgnoreCase("owner")) {


            UserAppService u = new UserAppService();

            if(u.getUsers(username).equals("")) {


                u.create(username, password, email, role);
//
                OwnerService o = new OwnerService();
                o.createOwner(name, address, neighbourhood, u.getUser(username, password));

                return Response.status(Response.Status.CREATED)
                        .entity("User created!!!")
                        .build();
            }else {
                return Response.status(Response.Status.NOT_ACCEPTABLE)
                        .entity("User Already Exists!!!")
                        .build();
            }


        }else if (role.equalsIgnoreCase("vet")) {
            UserAppService u2 = new UserAppService();


            if(u2.getUsers(username).equals("")) {
                u2.create(username, password, email, role);
//
                VetService v = new VetService();
                v.createVet(name, address, neighbourhood, u2.getUser(username, password));

                return Response.status(Response.Status.CREATED)
                        .entity("User created!!!")
                        .build();
            }else {
                return Response.status(Response.Status.NOT_ACCEPTABLE)
                        .entity("User Already Exists!!!")
                        .build();
            }

        }else if(role.equalsIgnoreCase("official")) {
            UserAppService u3 = new UserAppService();

            if(u3.getUsers(username).equals("")) {

                u3.create(username, password, email, role);
//
                OfficialService of = new OfficialService();
                of.createOfficial(name, u3.getUser(username, password));

                return Response.status(Response.Status.CREATED)
                        .entity("User created!!!")
                        .build();
            }else {
                return Response.status(Response.Status.NOT_ACCEPTABLE)
                        .entity("User Already Exists!!!")
                        .build();
            }
        }

                return Response.status(Response.Status.BAD_REQUEST)
                        .entity("Incorrect Parameters!!!")
                        .build();
        }


    }



