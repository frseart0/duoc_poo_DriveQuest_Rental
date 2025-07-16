package modelo.vehiculo;

public abstract class Vehiculo {
    protected String patente;
    protected String marca;
    protected String modelo;

    protected boolean disponible;
    protected int diasArriendo;
    protected int valorArriendoDia;
    protected int valorArriendoTotal;

    //para vehiculo nuevo
    public Vehiculo(String patente, String marca, String modelo,int valorArriendoDia) {
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.disponible = true;
        this.diasArriendo = 0;
        this.valorArriendoDia = valorArriendoDia;
    }

    //para cargar vehiculos desde db
    public Vehiculo(String patente, String marca, String modelo, boolean disponible, int diasArriendo, int valorArriendoDia) {
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.disponible = disponible;
        this.diasArriendo = diasArriendo;
        this.valorArriendoDia = valorArriendoDia;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

}