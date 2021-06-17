//package resources;
//
//
//import javax.ws.rs.GET;
//import javax.ws.rs.Path;
//import javax.ws.rs.PathParam;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//import java.util.*;
//
//
//@Path("/vets/{vetId}/{petId}/visits/show_visits")
//public class  showVisitsResource{
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response Show_cases(@PathParam("vetId") Integer vetId,@PathParam("petId") Integer petId){
//
//
//        VisitPOJO Visitas1 = new VisitPOJO(1,"1-Mayo-2010","Esterilizacion","Primera esterilización",vetId,petId);
//        VisitPOJO Visitas2 = new VisitPOJO(2,"2-Mayo-2001","vacunación","Segunda Vacuna",7,petId);
//        VisitPOJO Visitas3 = new VisitPOJO(3,"3-Mayo-2018","implantación de microchip","Implatancion, por perdida",vetId,petId);
//        VisitPOJO Visitas4 = new VisitPOJO(4,"4-Mayo-2012","Esterilizacion","Segunda esterilización",8,petId);
//        VisitPOJO Visitas5 = new VisitPOJO(5,"5-Mayo-2017","Urgencia y control","Corte grave",vetId,petId);
//        VisitPOJO Visitas6 = new VisitPOJO(6,"4-Mayo-2006","vacunación","Vacuna contra la rabia",5,petId);
//
//        List<VisitPOJO> list = new ArrayList<VisitPOJO>();
//        list.add(Visitas1);
//        list.add(Visitas2);
//        list.add(Visitas3);
//        list.add(Visitas4);
//        list.add(Visitas5);
//        list.add(Visitas6);
//
//
//        List<String> type = new ArrayList<String>();
//
//
//        for (int i = 0; i <list.size() ; i++) {
//            type.add(list.get(i).getType());
//        }
//
//        Collections.sort(type);
//
//        Map<String, Integer> counts2 = new HashMap<String, Integer>();
//
//        for (String str : type) {
//            if (counts2.containsKey(str)) {
//                counts2.put(str, counts2.get(str) + 1);
//            } else {
//                counts2.put(str, 1);
//            }
//        }
//        String resultado = "Numero visitas por tipo\n";
//
//        for (Map.Entry<String, Integer> entry : counts2.entrySet()) {
//            resultado = resultado + (entry.getKey() + " = " + entry.getValue()) + "\n";
//        }
//        List<String> vets = new ArrayList<String>();
//
//
//        for (int i = 0; i <list.size() ; i++) {
//            vets.add(String.valueOf((list.get(i).getVet_Id())));
//        }
//
//        Collections.sort(vets);
//
//        Map<String, Integer> counts = new HashMap<String, Integer>();
//
//        for (String str : vets) {
//            if (counts.containsKey(str)) {
//                counts.put(str, counts.get(str) + 1);
//            } else {
//                counts.put(str, 1);
//            }
//        }
//        String resultado2 = "Numero de visitas por veterinario\n";
//
//        for (Map.Entry<String, Integer> entry2 : counts.entrySet()) {
//            resultado2 = resultado2 + ("Id Veterinario: "  + entry2.getKey() + " = " + entry2.getValue()) + "\n";
//        }
//            resultado = resultado + "\n" + resultado2;
//        return Response.status(Response.Status.OK).
//                entity(resultado)
//                .build();
//
//
//    }
//
//
//
//
//
//}
