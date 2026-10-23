//package app;
//
//import entidades.Espacio;
//import entidades.Estacionamiento;
//import entidades.Vehiculo;
//import enums.TipoVehiculo;
//
//import java.util.ArrayList;
//
//public class Main {
//    static void main() {
//        final int CANTIDAD_ESPACIOS = 2;
//        ArrayList<Espacio> espacios = new ArrayList<>();
//        for (int i = 0; i < CANTIDAD_ESPACIOS; i++) {
//            espacios.add(new Espacio());
//        }
//
//        final int TARIFA_MOTO = 5;
//        final int TARIFA_AUTO = 10;
//        Estacionamiento estacionamiento = new Estacionamiento(TARIFA_MOTO, TARIFA_AUTO, espacios);
//
//        int exit = 3;
//        int comando;
//        do {
//            imprimirMenu();
//            comando = Integer.parseInt(IO.readln());
//            switch (comando) {
//                case 1:
//                    estacionarVehiculo(estacionamiento);
//                    break;
//                case 2:
//                    liberarEstacionamiento(estacionamiento);
//                    break;
//                case 3:
//                    break;
//                default:
//                    IO.println("Opción no valida.");
//            }
//        } while (comando != exit);
//
//    }
//
//
//    static void imprimirMenu() {
//        IO.println();
//        IO.println("--------------------------------------------");
//        IO.println("                  OPCIONES                  ");
//        IO.println("[1] Estacionar vehículo");
//        IO.println("[2] Liberar estacionamiento");
//        IO.println("[3] Salir");
//        IO.println();
//        IO.println("--------------------------------------------");
//    }
//
//    static void estacionarVehiculo(Estacionamiento estacionamiento) {
//        IO.println("¿Qué tipo de vehículo desea estacionar?");
//        boolean success = false;
//        switch (Integer.parseInt(IO.readln("Ingrese 1 para autos o 2 para motos: "))) {
//            case 1:
//                success = estacionamiento.estacionarVehiculo(new Vehiculo(TipoVehiculo.VEHICULO_ESTANDAR));
//                break;
//            case 2:
//                success = estacionamiento.estacionarVehiculo(new Vehiculo(TipoVehiculo.MOTO));
//                break;
//            default:
//                IO.println("Opción no válida");
//                return;
//        }
//        if (success) {
//            IO.println("Su vehículo se estacionó exitosamente");
//        } else {
//            IO.println("No hay lugar disponible en el estacionamiento para estacioar su vehículo.");
//        }
//    }
//
//    static void liberarEstacionamiento(Estacionamiento estacionamiento) {
//        int numero = Integer.parseInt(IO.readln("¿Que espacio desea liberar? "));
//        int costo = estacionamiento.costoAcumulado(numero);
//        estacionamiento.liberarEspacio(numero);
//        IO.println("Estacionamiento liberado con éxito. Debe abonar $" + costo);
//    }
//}
