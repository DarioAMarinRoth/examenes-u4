package entidades;

import enums.TipoVehiculo;

public class Vehiculo {
    TipoVehiculo tipo;

    public Vehiculo(TipoVehiculo tipo) {
        this.tipo = tipo;
    }

    public TipoVehiculo getTipo() {
        return tipo;
    }
}
