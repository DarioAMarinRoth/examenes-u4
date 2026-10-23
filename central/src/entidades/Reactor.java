package entidades;

import enums.EstadoReactor;

import java.time.Duration;
import java.time.Instant;

public class Reactor {

    private static int contadorReactores;
    private final int IDENTIFICADOR;
    private final int POTENCIA;
    private EstadoReactor estado;
    private Instant horaInicio;
    private Duration tiempoEncendido;

    public Reactor(int potencia) {
        if (potencia <= 0) {
            throw new IllegalArgumentException("La potencia del reactor debe ser un valor positivo");
        }
        this.POTENCIA = potencia;
        estado = EstadoReactor.APAGADO;
        tiempoEncendido = Duration.ofSeconds(0);
        IDENTIFICADOR = contadorReactores;
        contadorReactores++;
    }

    public int obtenerPotencia() {
        return POTENCIA;
    }

    public void encender() {
        if (estado != EstadoReactor.APAGADO) {
            return;
        }
        horaInicio = Instant.now();
        estado = EstadoReactor.ENCENDIDO;
    }

    public void refrigerarReactor() {
        if (estado != EstadoReactor.APAGADO) {
            throw new IllegalStateException("El reactor debe estar apagado para poder refrigerarse.");
        }
        tiempoEncendido = Duration.ofSeconds(0);
    }

    public void apagar() {
        if (estado == EstadoReactor.APAGADO) {
            return;
        }
        estado = EstadoReactor.APAGADO;
        ajustarTiempo();
        horaInicio = null;
    }

    public EstadoReactor obtenerEstado() {
        final Duration PERIODO_DE_MANTENIMIENTO = Duration.ofSeconds(10);

        if (estado != EstadoReactor.ENCENDIDO) {
            return estado;
        }
        ajustarTiempo();
        if (tiempoEncendido.compareTo(PERIODO_DE_MANTENIMIENTO) > 0) {
            estado = EstadoReactor.CRITICO;
        }
        return estado;
    }

    public void verDetalles() {
        IO.println("REACTOR N° " + IDENTIFICADOR);
        IO.println("ESTADO: " + obtenerEstado());
        ajustarTiempo();
        IO.println("TIEMPO SIN MANTENIMIENTO: " + tiempoEncendido.toSeconds() + " HS");
        IO.println("_______________________________________________________");
    }


    private void ajustarTiempo() {
        long prescaler = 3;
        if (horaInicio != null) {
            Duration aux = Duration.between(horaInicio, Instant.now());
            tiempoEncendido = tiempoEncendido.plus(aux.dividedBy(prescaler));
        }
    }

}
