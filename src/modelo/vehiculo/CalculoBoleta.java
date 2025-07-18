package modelo.vehiculo;

public interface CalculoBoleta {
    double ivaMultiplicador = 1.19;     //19%
    double descuentoCarga = 0.93;       //8%
    double descuentoPasajeros = 0.88;   //12%

    void calcularBoleta();
}