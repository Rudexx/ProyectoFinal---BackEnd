package resources;

import edu.unbosque.ProyectoFinal_backend.jpa.services.OwnerService;
import edu.unbosque.ProyectoFinal_backend.jpa.services.PetService;
import resources.pojos.OwnerPOJO;
import resources.pojos.PetPOJO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.*;

@Path("app/{username}/list-owners")
public class OfficialResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    //@Logged

    public Response listOwners(@PathParam("username") String username){
        OwnerService o = new OwnerService();
        List<OwnerPOJO> list = o.listOwners();


        List<String> neighbourhoods = new ArrayList<String>();
        int number = 0;

        for (int i = 0; i <list.size() ; i++) {
            neighbourhoods.add(list.get(i).getNeighborhood());
        }

        Collections.sort(neighbourhoods);

        Map<String, Integer> counts = new HashMap<String, Integer>();

        for (String str : neighbourhoods) {
            if (counts.containsKey(str)) {
                counts.put(str, counts.get(str) + 1);
            } else {
                counts.put(str, 1);
            }
        }
        String resultado = "Owner by Neighbourhood\n";

        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            resultado = resultado + (entry.getKey() + " = " + entry.getValue()) + "\n";
        }

        return Response.status(Response.Status.OK)
                .entity(resultado)
                .build();
    }

    @GET
    @Path("/list-pets")
    @Produces(MediaType.APPLICATION_JSON)
    //@Logged

    public Response listPets(@PathParam("username") String username){
        PetService o = new PetService();
        List<PetPOJO> list = o.listPets();


        List<String> species = new ArrayList<String>();
        List<String> race = new ArrayList<String>();
        List<String> size = new ArrayList<String>();
        List<String> sex = new ArrayList<String>();
        Integer haveMicrochip = 0;
        Integer doNotHaveMicrochip = 0;


        for (int i = 0; i <list.size() ; i++) {
            species.add(list.get(i).getSpecies());
            race.add(list.get(i).getRace());
            size.add(list.get(i).getSize());
            sex.add(list.get(i).getSex());
            if(list.get(i).getMicrochip() != null){
                haveMicrochip++;
            }else{
                doNotHaveMicrochip++;
            }
        }

        Collections.sort(species);
        Collections.sort(race);
        Collections.sort(size);
        Collections.sort(sex);

        Map<String, Integer> counts = new HashMap<String, Integer>();

        for (String str : species) {
            if (counts.containsKey(str)) {
                counts.put(str, counts.get(str) + 1);
            } else {
                counts.put(str, 1);
            }
        }
        String resultado = "Pets By species\n";

        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            resultado = resultado + (entry.getKey() + " = " + entry.getValue()) + "\n";
        }

        Map<String, Integer> counts2 = new HashMap<String, Integer>();

        for (String str : race) {
            if (counts2.containsKey(str)) {
                counts2.put(str, counts2.get(str) + 1);
            } else {
                counts2.put(str, 1);
            }
        }
        resultado = resultado + "\n" + "Pets By Species\n";

        for (Map.Entry<String, Integer> entry : counts2.entrySet()) {
            resultado = resultado + (entry.getKey() + " = " + entry.getValue()) + "\n";
        }

        Map<String, Integer> counts3 = new HashMap<String, Integer>();

        for (String str : size) {
            if (counts3.containsKey(str)) {
                counts3.put(str, counts3.get(str) + 1);
            } else {
                counts3.put(str, 1);
            }
        }
        resultado = resultado + "\n" + "Pets By Size\n";

        for (Map.Entry<String, Integer> entry : counts3.entrySet()) {
            resultado = resultado + (entry.getKey() + " = " + entry.getValue()) + "\n";
        }

        Map<String, Integer> counts4 = new HashMap<String, Integer>();

        for (String str : sex) {
            if (counts4.containsKey(str)) {
                counts4.put(str, counts4.get(str) + 1);
            } else {
                counts4.put(str, 1);
            }
        }
        resultado = resultado + "\n" + "Pets By Sex\n";

        for (Map.Entry<String, Integer> entry : counts4.entrySet()) {
            resultado = resultado + (entry.getKey() + " = " + entry.getValue()) + "\n";
        }

        resultado = resultado + "\n" + "Pets that have microchip: " + haveMicrochip;
        resultado = resultado + "\n" + "Pets that do not have microchip: " + doNotHaveMicrochip;


        return Response.status(Response.Status.OK)
                .entity(resultado)
                .build();
    }




}
