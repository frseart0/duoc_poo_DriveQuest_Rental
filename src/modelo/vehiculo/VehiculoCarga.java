package modelo.vehiculo;

public class VehiculoCarga extends Vehiculo {
    protected int cargaMaximaKg;

    //para vehiculo de carga nuevo
    public VehiculoCarga(String patente, String marca, String modelo){
        super(patente,marca,modelo);
        this.disponible = true;
        this.diasArriendo = 0;
        this.cargaMaximaKg = 0;
    }

    //para cargar vehiculos de carga desde db
    public VehiculoCarga(String patente, String marca, String modelo, boolean disponible, int diasArriendo, int cargaMaximaKg){
        super(patente,marca,modelo,disponible,diasArriendo);
        this.cargaMaximaKg = cargaMaximaKg;
    }
}
