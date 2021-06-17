//package resources;
//
//
//import javax.ws.rs.GET;
//import javax.ws.rs.Path;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//import java.util.*;
//
//@Path("owners/neighbourhoods")
//public class CountByNeighbourhoodResource {
//
//
//
//    @GET
//    @Produces(MediaType.TEXT_PLAIN)
//    public Response count() {
//
//        List<OwnerPOJO> list = new ArrayList<OwnerPOJO>();
//
//        OwnerPOJO owner1 = new OwnerPOJO(1, "David",
//                "Diagonal 200 3950", "Bogotá", new ArrayList<String>());
//
//        OwnerPOJO owner2 = new OwnerPOJO(2, "Jose",
//                "Diagonal 223 3950", "Bogotá", new ArrayList<String>());
//
//        OwnerPOJO owner3 = new OwnerPOJO(3, "Daniel",
//                "Diagonal 217 3950", "Bogotá", new ArrayList<String>());
//
//        OwnerPOJO owner4 = new OwnerPOJO(4, "Pedro",
//                "Diagonal 236 3950", "Cali", new ArrayList<String>());
//
//        OwnerPOJO owner5 = new OwnerPOJO(5, "Daniela",
//                "Diagonal 214 3950", "Cali", new ArrayList<String>());
//
//        OwnerPOJO owner6 = new OwnerPOJO(6, "Amy",
//                "Diagonal 211 3950", "Cundinamarca", new ArrayList<String>());
//
//        OwnerPOJO owner7 = new OwnerPOJO(7, "Roxanna",
//                "Diagonal 500 3950", "Tunja", new ArrayList<String>());
//
//        OwnerPOJO owner8 = new OwnerPOJO(8, "Carol",
//                "Diagonal 300 3950", "Tunja", new ArrayList<String>());
//
//        OwnerPOJO owner9 = new OwnerPOJO(9, "Liliana",
//                "Diagonal 227 3950", "Tunja", new ArrayList<String>());
//
//        OwnerPOJO owner10 = new OwnerPOJO(10, "Mariana",
//                "Diagonal 227 3950", "Tunja", new ArrayList<String>());
//
//        list.add(owner1);
//        list.add(owner2);
//        list.add(owner3);
//        list.add(owner4);
//        list.add(owner5);
//        list.add(owner6);
//        list.add(owner7);
//        list.add(owner8);
//        list.add(owner9);
//        list.add(owner10);
//
//
//        List<String> neighbourhoods = new ArrayList<String>();
//        int number = 0;
//
//        for (int i = 0; i <list.size() ; i++) {
//         neighbourhoods.add(list.get(i).getNeighborhood());
//        }
//
//        Collections.sort(neighbourhoods);
//
//        Map<String, Integer> counts = new HashMap<String, Integer>();
//
//        for (String str : neighbourhoods) {
//            if (counts.containsKey(str)) {
//                counts.put(str, counts.get(str) + 1);
//            } else {
//                counts.put(str, 1);
//            }
//        }
//        String resultado = "Propietarios por localidad\n";
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
//    }
//}
//
