package modelo.vehiculo;

public class VehiculoCarga extends Vehiculo implements CalculoBoleta{
    protected int cargaMaximaKg;

    //para vehiculo de carga nuevo
    public VehiculoCarga(String patente, String marca, String modelo, int valorArriendoDia, int cargaMaximaKg) {
        super(patente, marca, modelo, valorArriendoDia);
        this.disponible = true;
        this.diasArriendo = 0;
        this.cargaMaximaKg = cargaMaximaKg;
        this.valorArriendoTotal = 0;
    }

    //para cargar vehiculos de carga desde csv
    public VehiculoCarga(String patente, String marca, String modelo, boolean disponible, int diasArriendo, int valorArriendoDia, int cargaMaximaKg, int valorArriendoTotal) {
        super(patente, marca, modelo, disponible, diasArriendo, valorArriendoDia, valorArriendoTotal);
        this.cargaMaximaKg = cargaMaximaKg;
    }

    public void MostrarInfoVehiculo() {
        super.MostrarInfoVehiculo();
        System.out.println("Carga Maxima Kilogramos: " + this.cargaMaximaKg);
    }

    public void calcularBoleta() {
        this.valorArriendoTotal = (int) (this.valorArriendoDia * this.diasArriendo * ivaMultiplicador * descuentoCarga);
    }

}
