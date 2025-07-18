package modelo.vehiculo;

public class VehiculoPasajeros extends Vehiculo implements CalculoBoleta {
    protected int pasajerosMaximo;

    public VehiculoPasajeros(String patente, String marca, String modelo, int valorArriendoDia, int pasajerosMaximo) {
        super(patente, marca, modelo, valorArriendoDia);
        this.pasajerosMaximo = pasajerosMaximo;
    }

    public VehiculoPasajeros(String patente, String marca, String modelo, boolean disponible, int diasArriendo,
                             int valorArriendoDia, int pasajerosMaximo, int valorArriendoTotal) {
        super(patente, marca, modelo, disponible, diasArriendo, valorArriendoDia, valorArriendoTotal);
        this.pasajerosMaximo = pasajerosMaximo;
    }

    public int getPasajerosMaximo() {
        return pasajerosMaximo;
    }

    public void setPasajerosMaximo(int pasajerosMaximo) {
        this.pasajerosMaximo = pasajerosMaximo;
    }

    @Override
    public void MostrarInfoVehiculo() {
        super.MostrarInfoVehiculo();
        System.out.println("Pasajeros Maximo: " + this.pasajerosMaximo);
    }

    @Override
    public void calcularBoleta() {
        this.valorArriendoTotal = (int) (this.valorArriendoDia * this.diasArriendo * ivaMultiplicador * descuentoPasajeros);
    }
}