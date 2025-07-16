package modelo.vehiculo;

public abstract class Vehiculo {
    protected String patente;
    protected String marca;
    protected String modelo;

    protected boolean disponible;
    protected int diasArriendo;

    //para vehiculo nuevo
    public Vehiculo(String patente, String marca, String modelo) {
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.disponible = true;
        this.diasArriendo = 0;
    }

    //para cargar vehiculos desde db
    public Vehiculo(String patente, String marca, String modelo, boolean disponible, int diasArriendo){
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.disponible = disponible;
        this.diasArriendo = diasArriendo;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

}