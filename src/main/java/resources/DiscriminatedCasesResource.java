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
//@Path("/owners/{personId}/pets/{petId}/case/discriminated")
//public class  DiscriminatedCasesResource{
//    @GET
//    @Produces(MediaType.APPLICATION_JSON)
//    public Response discriminated(@PathParam("personId") Integer personId, @PathParam("petId") Integer petId) {
//
//
//        CasePOJO case1 = new CasePOJO(1,"1-Mayo-2010","Robo","Robo a mano armada",petId);
//        CasePOJO case2 = new CasePOJO(2,"2-Mayo-2001","Perdida","Perdida por descuido",petId);
//        CasePOJO case3 = new CasePOJO(3,"3-Mayo-2018","Perdida","Perdida en el parque",petId);
//        CasePOJO case4 = new CasePOJO(4,"4-Mayo-2012","Robo","Robo de casa",petId);
//        CasePOJO case5 = new CasePOJO(5,"5-Mayo-2017","Fallecio","Accidente de transito",petId);
//        CasePOJO case6 = new CasePOJO(6,"4-Mayo-2006","Fallecio","Riña entre perros",petId);
//
//        List<CasePOJO> list = new ArrayList<CasePOJO>();
//        list.add(case1);
//        list.add(case2);
//        list.add(case3);
//        list.add(case4);
//        list.add(case5);
//        list.add(case6);
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
//        Map<String, Integer> counts = new HashMap<String, Integer>();
//
//        for (String str : type) {
//            if (counts.containsKey(str)) {
//                counts.put(str, counts.get(str) + 1);
//            } else {
//                counts.put(str, 1);
//            }
//        }
//        String resultado = "Numero de casos por tipo\n";
//
//        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
//            resultado = resultado + (entry.getKey() + " = " + entry.getValue()) + "\n";
//        }
//
//
//
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
