package entidades;

import enums.TipoVehiculo;

import java.time.Duration;
import java.time.Instant;

public class Espacio {

    private static int espaciosCreados;
    private final int NUMERO_ESPACIO;
    private boolean ocupado;
    private Vehiculo vehiculoEstacionado;
    Instant horaLlegada;

    public Espacio() {
        espaciosCreados++;
        NUMERO_ESPACIO = espaciosCreados;
    }

    public void estacionarVehiculo(Vehiculo vehiculo) {
        if (vehiculo == null) {
            throw new IllegalArgumentException("El vehículo no puede ser nulo");
        }
        vehiculoEstacionado = vehiculo;
        ocupado = true;
        horaLlegada = Instant.now();
    }

    public void liberarEspacio() {
        if (!ocupado) {
            IO.println("El espacio ya estaba vacío");
            return;
        }

        vehiculoEstacionado = null;
        ocupado = false;
    }

    public int obtenerNumeroEspacio() {
        return NUMERO_ESPACIO;
    }

    public boolean estaOcupado() {
        return ocupado;
    }

    public TipoVehiculo obtenerTipoVehiculo() {
        if (!ocupado) {
            throw new NullPointerException("No hay un vehículo estacionado");
        }
        return vehiculoEstacionado.getTipo();
    }

    public int obtenerTiempoEstacionado() {
        return (int) Duration.between(horaLlegada, Instant.now()).toSeconds();
    }


}
