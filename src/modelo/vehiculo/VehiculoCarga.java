package modelo.vehiculo;

public class VehiculoCarga extends Vehiculo implements CalculoBoleta {
    protected int cargaMaximaKg;

    public VehiculoCarga(String patente, String marca, String modelo, int valorArriendoDia, int cargaMaximaKg) {
        super(patente, marca, modelo, valorArriendoDia);
        this.cargaMaximaKg = cargaMaximaKg;
    }

    public VehiculoCarga(String patente, String marca, String modelo, boolean disponible, int diasArriendo,
                         int valorArriendoDia, int cargaMaximaKg, int valorArriendoTotal) {
        super(patente, marca, modelo, disponible, diasArriendo, valorArriendoDia, valorArriendoTotal);
        this.cargaMaximaKg = cargaMaximaKg;
    }

    public int getCargaMaximaKg() {
        return cargaMaximaKg;
    }

    public void setCargaMaximaKg(int cargaMaximaKg) {
        this.cargaMaximaKg = cargaMaximaKg;
    }

    @Override
    public void MostrarInfoVehiculo() {
        super.MostrarInfoVehiculo();
        System.out.println("Carga Maxima (kg): " + this.cargaMaximaKg);
    }

    @Override
    public void calcularBoleta() {
        this.valorArriendoTotal = (int) (this.valorArriendoDia * this.diasArriendo * ivaMultiplicador * descuentoCarga);
    }
}