package servicios;

import modelo.vehiculo.VehiculoCarga;
import modelo.vehiculo.VehiculoPasajeros;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class GestionVehiculos {
    ArrayList<VehiculoCarga> vehiculosCarga;
    ArrayList<VehiculoPasajeros> vehiculosPasajeros;

    public GestionVehiculos() {
        vehiculosCarga = new ArrayList<>();
        vehiculosPasajeros = new ArrayList<>();
    }

    public void CargarListaVehiculosCarga(String rutaArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                String patente = datos[0];
                String marca = datos[1];
                String modelo = datos[2];
                boolean disponible = Boolean.parseBoolean(datos[3]);
                int diasArriendo = Integer.parseInt(datos[4]);
                int valorArriendoDia = Integer.parseInt(datos[5]);
                int cargaMaximaKg = Integer.parseInt(datos[6]);
                int valorArriendoTotal = Integer.parseInt(datos[7]);

                VehiculoCarga vehiculo = new VehiculoCarga(patente, marca, modelo, disponible, diasArriendo, valorArriendoDia, cargaMaximaKg, valorArriendoTotal);
                vehiculosCarga.add(vehiculo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void CargarListaVehiculosPasajeros(String rutaArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                String patente = datos[0];
                String marca = datos[1];
                String modelo = datos[2];
                boolean disponible = Boolean.parseBoolean(datos[3]);
                int diasArriendo = Integer.parseInt(datos[4]);
                int valorArriendoDia = Integer.parseInt(datos[5]);
                int pasajerosMaximo = Integer.parseInt(datos[6]);
                int valorArriendoTotal = Integer.parseInt(datos[7]);

                VehiculoPasajeros vehiculo = new VehiculoPasajeros(patente, marca, modelo, disponible, diasArriendo, valorArriendoDia, pasajerosMaximo, valorArriendoTotal);
                vehiculosPasajeros.add(vehiculo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
