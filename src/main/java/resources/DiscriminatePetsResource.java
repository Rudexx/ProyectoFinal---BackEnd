//package resources;
//
//import javax.ws.rs.GET;
//import javax.ws.rs.Path;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//import java.util.ArrayList;
//import java.util.List;
//
//@Path("owners/{ownerid}/pets/discriminate")
//public class DiscriminatePetsResource {
//
//    @GET
//    @Produces(MediaType.TEXT_PLAIN)
//    public Response count() {
//        OwnerPOJO persona = new OwnerPOJO();
//        PetPOJO pet1 = new PetPOJO(1,"Animalito1","Adolfo","Cat","DeBarrio","small","Macho", null,persona,32);
//        PetPOJO pet2 = new PetPOJO(2,null,"Patricia","Dog","Extranjero","Mediano","Female",null,persona,12);
//        PetPOJO pet3 = new PetPOJO(3,"Animalito3","Karen","Cat","Fino","Grande","Female",null,persona,42);
//        PetPOJO pet4 = new PetPOJO(4,null,"Pedro","Dog","DeBarrio","small","Macho",null,persona,35);
//        PetPOJO pet5 = new PetPOJO(5,"Animalito5","Joubert","Cat","Fino","Grande","Macho",null,persona,1005060603);
//        PetPOJO pet6 = new PetPOJO(6,"Animalito6","David","Dog","Extranjero","Grande","Macho",null,persona,54654);
//
//        List<PetPOJO> listamascotas = new ArrayList<>();
//
//        listamascotas.add(pet1);
//        listamascotas.add(pet2);
//        listamascotas.add(pet3);
//        listamascotas.add(pet4);
//        listamascotas.add(pet5);
//        listamascotas.add(pet6);
//
//
//        List<String> Listado = new ArrayList<String>();
//        int number = 0;
//        int gato = 0;
//        int perro = 0;
//        Listado.add("Existen " + listamascotas.size() + " animales");
//        for (int i = 0; i <listamascotas.size() ; i++) {
//            if(listamascotas.get(i).getSpecies().equals("Cat")){
//                gato++;
//            }else if(listamascotas.get(i).getSpecies().equals("Dog")){
//                perro++;
//            }
//        }
//        Listado.add(gato + " Gatos");
//        Listado.add(perro + " Perros");
//        int Fino = 0;
//        int Extranjero = 0;
//        int DeBarrio = 0;
//
//        for(int i = 0; i <listamascotas.size() ; i++) {
//            if (listamascotas.get(i).getRace().equals("DeBarrio")) {
//                DeBarrio++;
//            } else if (listamascotas.get(i).getRace().equals("Extranjero")) {
//                Extranjero++;
//            } else if (listamascotas.get(i).getRace().equals("Fino")) {
//                Fino++;
//            }
//        }
//        Listado.add(DeBarrio + " DeBarrio");
//        Listado.add(Extranjero + " Extranjeros");
//        Listado.add(Fino + " Finos");
//        int Grandes = 0;
//        int Medianos = 0;
//        int Pequeños = 0;
//        for(int i = 0; i <listamascotas.size() ; i++) {
//            if (listamascotas.get(i).getSize().equals("Grande")) {
//                Grandes++;
//            } else if (listamascotas.get(i).getSize().equalsIgnoreCase("Mediano")) {
//                Medianos++;
//            } else if (listamascotas.get(i).getSize().equals("small")) {
//                Pequeños++;
//            }
//        }
//        Listado.add(Grandes + " Grandes");
//        Listado.add(Medianos + " Medianos");
//        Listado.add(Pequeños + " Pequeños");
//        int Macho = 0;
//        int Hembra = 0;
//        for (int i = 0; i <listamascotas.size() ; i++) {
//            if(listamascotas.get(i).getSex().equals("Macho")){
//                Macho++;
//            }else if(listamascotas.get(i).getSex().equalsIgnoreCase("Female")){
//                Hembra++;
//            }
//        }
//        Listado.add(Macho + " Machos");
//        Listado.add(Hembra + " Hembras");
//        int TienenMicro = 0;
//        int Nomicro = 0;
//        for (int i = 0; i <listamascotas.size() ; i++) {
//            if(listamascotas.get(i).getMicrochip() == null){
//                Nomicro++;
//            }else{
//                TienenMicro++;
//            }
//        }
//        Listado.add(TienenMicro + " Tienen microchip");
//        Listado.add(Nomicro + " No tienen microchip");
//
////       Collections.sort(neighbourhoods);
////
////        Map<String, Integer> counts = new HashMap<String, Integer>();
////
////        for (String str : neighbourhoods) {
////            if (counts.containsKey(str)) {
////                counts.put(str, counts.get(str) + 1);
////            } else {
////                counts.put(str, 1);
////            }
////        }
////        String resultado = "Propietarios por localidad\n";
////
////        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
////            resultado = resultado + (entry.getKey() + " = " + entry.getValue()) + "\n";
////        }
//
//
//
//        return Response.status(Response.Status.OK).
//                entity(Listado.toString())
//                .build();
//    }
//
//
//}
