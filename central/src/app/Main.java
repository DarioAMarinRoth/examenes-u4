package app;

import entidades.CentralNuclear;
import entidades.Reactor;

import java.util.ArrayList;

public class Main {
    static void main() {

        final int CANTIDAD__REACTORES = 5;
        final int POTENCIA_REACTORES = 10;
        ArrayList<Reactor> reactores = new ArrayList<>();

        for (int i = 0; i < CANTIDAD__REACTORES; i++) {
            reactores.add(new Reactor(POTENCIA_REACTORES));
        }

        CentralNuclear centralNuclear = new CentralNuclear(reactores);
        centralNuclear.setDemandaEnergetica(45);

        final int SALIR = 7;
        int comando;
        do {
            imprimirMenu();
            comando = Integer.parseInt(IO.readln());

            switch (comando) {
                case 1:
                    centralNuclear.mostrarResumen();
                    break;
                case 2:
                    comando = Integer.parseInt(IO.readln("Ingrese el número de reactor que desea encender: "));
                    centralNuclear.encenderReactor(comando);
                    IO.println();
                    break;
                case 3:
                    for (int i = 0; i < CANTIDAD__REACTORES; i++) {
                        centralNuclear.encenderReactor(i);
                    }
                    break;
                case 4:
                    comando = Integer.parseInt(IO.readln("Ingrese la nueva demanda energética: "));
                    centralNuclear.setDemandaEnergetica(comando);
                    break;
                case 5:
                    centralNuclear.hacerMantenimiento();
                    break;
                case 6:
                    comando = Integer.parseInt(IO.readln("Ingrese el número de reactor que desea apagar: "));
                    centralNuclear.apagarReactor(comando);
                case 7:
                    break;
                default:
                    IO.println("Valor no válido");
            }

        } while (comando != SALIR);

    }

    static void imprimirMenu() {
        IO.println();
        IO.println();
        IO.println("------------------------------------------------------");
        IO.println("                       OPCIONES                       ");
        IO.println("Presione:");
        IO.println("[1]: consultar el estado de la central");
        IO.println("[2]: encender un reactor específico");
        IO.println("[3]: encender todos los reactores");
        IO.println("[4]: ajustar la demanda energética");
        IO.println("[5]: realizar mantenimiento");
        IO.println("[6]: apagar un reactor específico");
        IO.println("[7]: salir");
        IO.println("------------------------------------------------------");
        IO.println();
        IO.println();
    }
}
