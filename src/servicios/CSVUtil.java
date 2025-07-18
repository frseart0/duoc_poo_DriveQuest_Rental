package servicios;

import modelo.vehiculo.VehiculoCarga;
import modelo.vehiculo.VehiculoPasajeros;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVUtil {
    public static ArrayList<VehiculoCarga> cargarVehiculosCarga(String archivo) {
        ArrayList<VehiculoCarga> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length >= 5) {
                    VehiculoCarga v = new VehiculoCarga(partes[0], partes[1], partes[2], Integer.parseInt(partes[3]), Integer.parseInt(partes[4]));
                    lista.add(v);
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error leyendo vehiculos de carga: " + e.getMessage());
        }
        return lista;
    }

    public static ArrayList<VehiculoPasajeros> cargarVehiculosPasajeros(String archivo) {
        ArrayList<VehiculoPasajeros> lista = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length >= 5) {
                    VehiculoPasajeros v = new VehiculoPasajeros(partes[0], partes[1], partes[2], Integer.parseInt(partes[3]), Integer.parseInt(partes[4]));
                    lista.add(v);
                }
            }
        } catch (IOException | NumberFormatException e) {
            System.err.println("Error leyendo vehiculos de pasajeros: " + e.getMessage());
        }
        return lista;
    }
}
