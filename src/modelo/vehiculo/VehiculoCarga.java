package modelo.vehiculo;

public class VehiculoCarga extends Vehiculo {
    protected int cargaMaximaKg;

    public VehiculoCarga(String patente, String marca, String modelo){
        super(patente,marca,modelo);
        this.disponible = true;
        this.cargaMaximaKg = 0;
    }
}
