package modelo.vehiculo;

public class VehiculoPasajeros extends Vehiculo implements CalculoBoleta{
    protected int pasajerosMaximo;

    //para vehiculo de pasajeros nuevo
    public VehiculoPasajeros(String patente, String marca, String modelo, int valorArriendoDia, int pasajerosMaximo) {
        super(patente, marca, modelo, valorArriendoDia);
        this.disponible = true;
        this.diasArriendo = 0;
        this.pasajerosMaximo = pasajerosMaximo;
        this.valorArriendoTotal = 0;
    }

    //para cargar vehiculos de pasajeros desde csv
    public VehiculoPasajeros(String patente, String marca, String modelo, boolean disponible, int diasArriendo, int valorArriendoDia, int pasajerosMaximo, int  valorArriendoTotal) {
        super(patente, marca, modelo, disponible, diasArriendo, valorArriendoDia, valorArriendoTotal);
        this.pasajerosMaximo = pasajerosMaximo;
    }

    public void MostrarInfoVehiculo() {
        super.MostrarInfoVehiculo();
        System.out.println("Pasajeros Maximo: " + this.pasajerosMaximo);
    }

    public void calcularBoleta() {
        this.valorArriendoTotal = (int) (this.valorArriendoDia * this.diasArriendo * ivaMultiplicador * descuentoPasajeros);
    }

}
