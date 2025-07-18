package app;

import interfaz_usuario.Interfaz;
import servicios.GestionVehiculos;

public class Main {
    public static void main(String[] args) {
        GestionVehiculos gestionVehiculos = new GestionVehiculos();

        gestionVehiculos.cargarListaVehiculosCarga("src/colecciones/vehiculos_carga.csv");
        gestionVehiculos.cargarListaVehiculosPasajeros("src/colecciones/vehiculos_pasajeros.csv");

        Interfaz interfaz = new Interfaz(gestionVehiculos);
        interfaz.menuPrincipal();
    }
}