package app;

import servicios.GestionVehiculos;

public class Main {
    public static void main(String[] args) {
        GestionVehiculos gestionVehiculos = new GestionVehiculos();

        gestionVehiculos.CargarListaVehiculosCarga("src/colecciones/vehiculos_carga.csv");
        gestionVehiculos.CargarListaVehiculosPasajeros("src/colecciones/vehiculos_pasajeros.csv");

    }
}