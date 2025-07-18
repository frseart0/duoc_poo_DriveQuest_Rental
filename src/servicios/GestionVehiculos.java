package servicios;

import modelo.vehiculo.VehiculoCarga;
import modelo.vehiculo.VehiculoPasajeros;

import java.io.*;
import java.util.ArrayList;

public class GestionVehiculos {
    private final ArrayList<VehiculoCarga> vehiculosCarga;
    private final ArrayList<VehiculoPasajeros> vehiculosPasajeros;

    public GestionVehiculos() {
        vehiculosCarga = new ArrayList<>();
        vehiculosPasajeros = new ArrayList<>();
    }

    public void cargarListaVehiculosCarga(String rutaArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea = br.readLine();
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;

                String[] datos = linea.split(",");
                if (datos.length >= 8) {
                    String patente = datos[0].trim();
                    String marca = datos[1].trim();
                    String modelo = datos[2].trim();
                    boolean disponible = Boolean.parseBoolean(datos[3].trim());
                    int diasArriendo = Integer.parseInt(datos[4].trim());
                    int valorArriendoDia = Integer.parseInt(datos[5].trim());
                    int valorArriendoTotal = Integer.parseInt(datos[6].trim());
                    int cargaMaximaKg = Integer.parseInt(datos[7].trim());

                    VehiculoCarga vehiculo = new VehiculoCarga(patente, marca, modelo, disponible,
                            diasArriendo, valorArriendoDia, cargaMaximaKg, valorArriendoTotal);
                    vehiculosCarga.add(vehiculo);
                }
            }
            System.out.println("Cargados " + vehiculosCarga.size() + " vehiculos de carga.");
        } catch (IOException e) {
            System.err.println("Error al cargar vehiculos de carga: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error en formato de datos: " + e.getMessage());
        }
    }

    public void cargarListaVehiculosPasajeros(String rutaArchivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea = br.readLine();
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty()) continue;

                String[] datos = linea.split(",");
                if (datos.length >= 8) {
                    String patente = datos[0].trim();
                    String marca = datos[1].trim();
                    String modelo = datos[2].trim();
                    boolean disponible = Boolean.parseBoolean(datos[3].trim());
                    int diasArriendo = Integer.parseInt(datos[4].trim());
                    int valorArriendoDia = Integer.parseInt(datos[5].trim());
                    int valorArriendoTotal = Integer.parseInt(datos[6].trim());
                    int pasajerosMaximo = Integer.parseInt(datos[7].trim());

                    VehiculoPasajeros vehiculo = new VehiculoPasajeros(patente, marca, modelo, disponible,
                            diasArriendo, valorArriendoDia, pasajerosMaximo, valorArriendoTotal);
                    vehiculosPasajeros.add(vehiculo);
                }
            }
            System.out.println("Cargados " + vehiculosPasajeros.size() + " vehiculos de pasajeros.");
        } catch (IOException e) {
            System.err.println("Error al cargar vehiculos de pasajeros: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Error en formato de datos: " + e.getMessage());
        }
    }

    public void agregarVehiculoCarga(VehiculoCarga vehiculo) {
        vehiculosCarga.add(vehiculo);
    }

    public void agregarVehiculoPasajeros(VehiculoPasajeros vehiculo) {
        vehiculosPasajeros.add(vehiculo);
    }

    public boolean agregarArriendo(String patente, int dias) {
        for (VehiculoCarga vehiculo : vehiculosCarga) {
            if (vehiculo.getPatente().equals(patente) && vehiculo.isDisponible()) {
                vehiculo.setDiasArriendo(dias);
                vehiculo.setDisponible(false);
                vehiculo.calcularBoleta();
                return true;
            }
        }

        for (VehiculoPasajeros vehiculo : vehiculosPasajeros) {
            if (vehiculo.getPatente().equals(patente) && vehiculo.isDisponible()) {
                vehiculo.setDiasArriendo(dias);
                vehiculo.setDisponible(false);
                vehiculo.calcularBoleta();
                return true;
            }
        }

        return false;
    }

    public void mostrarVehiculosCarga() {
        System.out.println("\n--- Vehiculos de Carga ---");
        if (vehiculosCarga.isEmpty()) {
            System.out.println("No hay vehiculos de carga registrados.");
            return;
        }

        for (VehiculoCarga vehiculo : vehiculosCarga) {
            vehiculo.MostrarInfoVehiculo();
            System.out.println("------------------------");
        }
    }

    public void mostrarVehiculosPasajeros() {
        System.out.println("\n--- Vehiculos de Pasajeros ---");
        if (vehiculosPasajeros.isEmpty()) {
            System.out.println("No hay vehiculos de pasajeros registrados.");
            return;
        }

        for (VehiculoPasajeros vehiculo : vehiculosPasajeros) {
            vehiculo.MostrarInfoVehiculo();
            System.out.println("------------------------");
        }
    }

    public void mostrarTodosLosVehiculos() {
        mostrarVehiculosCarga();
        mostrarVehiculosPasajeros();
    }

    public void calcularYMostrarBoleta(String patente) {
        for (VehiculoCarga vehiculo : vehiculosCarga) {
            if (vehiculo.getPatente().equals(patente)) {
                vehiculo.calcularBoleta();
                System.out.println("\n--- Boleta de Arriendo ---");
                vehiculo.MostrarInfoVehiculo();
                return;
            }
        }
        for (VehiculoPasajeros vehiculo : vehiculosPasajeros) {
            if (vehiculo.getPatente().equals(patente)) {
                vehiculo.calcularBoleta();
                System.out.println("\n--- Boleta de Arriendo ---");
                vehiculo.MostrarInfoVehiculo();
                return;
            }
        }

        System.out.println("Vehiculo con patente " + patente + " no encontrado.");
    }

    public void guardarDatos() {
        guardarVehiculosCarga();
        guardarVehiculosPasajeros();
    }

    private void guardarVehiculosCarga() {
        try (FileWriter writer = new FileWriter("src/colecciones/vehiculos_carga.csv")) {
            writer.write("patente,marca,modelo,disponible,dias arriendo,valor arriendo dia,valor total arriendo,carga maxima\n");
            for (VehiculoCarga vehiculo : vehiculosCarga) {
                writer.write(String.format("%s,%s,%s,%b,%d,%d,%d,%d\n",
                        vehiculo.getPatente(),
                        vehiculo.getMarca(),
                        vehiculo.getModelo(),
                        vehiculo.isDisponible(),
                        vehiculo.getDiasArriendo(),
                        vehiculo.getValorArriendoDia(),
                        vehiculo.getValorArriendoTotal(),
                        vehiculo.getCargaMaximaKg()
                ));
            }
        } catch (IOException e) {
            System.err.println("Error al guardar vehiculos de carga: " + e.getMessage());
        }
    }

    private void guardarVehiculosPasajeros() {
        try (FileWriter writer = new FileWriter("src/colecciones/vehiculos_pasajeros.csv")) {
            writer.write("patente,marca,modelo,disponible,dias arriendo,valor arriendo dia,valor total arriendo,pasajeros maximo\n");
            for (VehiculoPasajeros vehiculo : vehiculosPasajeros) {
                writer.write(String.format("%s,%s,%s,%b,%d,%d,%d,%d\n",
                        vehiculo.getPatente(),
                        vehiculo.getMarca(),
                        vehiculo.getModelo(),
                        vehiculo.isDisponible(),
                        vehiculo.getDiasArriendo(),
                        vehiculo.getValorArriendoDia(),
                        vehiculo.getValorArriendoTotal(),
                        vehiculo.getPasajerosMaximo()
                ));
            }
        } catch (IOException e) {
            System.err.println("Error al guardar vehiculos de pasajeros: " + e.getMessage());
        }
    }
}