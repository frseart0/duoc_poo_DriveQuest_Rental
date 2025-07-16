package modelo.vehiculo;

public class VehiculoCarga extends Vehiculo{
    protected int cargaMaximaKg;

    //para vehiculo de carga nuevo
    public VehiculoCarga(String patente, String marca, String modelo, int valorArriendoDia, int cargaMaximaKg) {
        super(patente, marca, modelo, valorArriendoDia);
        this.disponible = true;
        this.diasArriendo = 0;
        this.cargaMaximaKg = cargaMaximaKg;
    }

    //para cargar vehiculos de carga desde db
    public VehiculoCarga(String patente, String marca, String modelo, boolean disponible, int diasArriendo, int valorArriendoDia, int cargaMaximaKg) {
        super(patente, marca, modelo, disponible, diasArriendo, valorArriendoDia);
        this.cargaMaximaKg = cargaMaximaKg;
    }

}
