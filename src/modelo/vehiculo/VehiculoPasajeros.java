package modelo.vehiculo;

public class VehiculoPasajeros extends Vehiculo {
    protected int pasajerosMaximo;

    //para vehiculo de pasajeros nuevo
    public VehiculoPasajeros(String patente, String marca, String modelo, int valorArriendoDia, int pasajerosMaximo) {
        super(patente, marca, modelo, valorArriendoDia);
        this.disponible = true;
        this.diasArriendo = 0;
        this.pasajerosMaximo = pasajerosMaximo;
    }

    //para cargar vehiculos de pasajeros desde db
    public VehiculoPasajeros(String patente, String marca, String modelo, boolean disponible, int diasArriendo, int valorArriendoDia, int pasajerosMaximo) {
        super(patente, marca, modelo, disponible, diasArriendo, valorArriendoDia);
        this.pasajerosMaximo = pasajerosMaximo;
    }
}
