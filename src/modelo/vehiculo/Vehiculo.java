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
        this.valorArriendoTotal = 0;
    }

    //para cargar vehiculos desde csv
    public Vehiculo(String patente, String marca, String modelo, boolean disponible, int diasArriendo, int valorArriendoDia, int valorArriendoTotal) {
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.disponible = disponible;
        this.diasArriendo = diasArriendo;
        this.valorArriendoDia = valorArriendoDia;
        this.valorArriendoTotal = valorArriendoTotal;
    }

    public String getPatente() {
        return patente;
    }
    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public boolean isDisponible() {
        return disponible;
    }
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public int getDiasArriendo() {
        return diasArriendo;
    }
    public void setDiasArriendo(int diasArriendo) {
        this.diasArriendo = diasArriendo;
    }

    public int getValorArriendoDia() {
        return valorArriendoDia;
    }
    public void setValorArriendoDia(int valorArriendoDia) {
        this.valorArriendoDia = valorArriendoDia;
    }

    public int getValorArriendoTotal() {
        return valorArriendoTotal;
    }
    public void setValorArriendoTotal(int valorArriendoTotal) { // O CalcularBoleta
        this.valorArriendoTotal = valorArriendoTotal;
    }

    public void MostrarInfoVehiculo(){
        System.out.println("Patente: " + this.patente);
        System.out.println("Marca: " + this.marca);
        System.out.println("Modelo: " + this.modelo);
        System.out.println("Disponible: " + this.disponible);
        System.out.println("Dias Arriendo: " + this.diasArriendo);
        System.out.println("Valor Arriendo Diario: " + this.valorArriendoDia);
        System.out.println("Valor Arriendo Total: " + this.valorArriendoTotal);
    }

}