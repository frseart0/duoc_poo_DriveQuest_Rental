package interfaz_usuario;

import servicios.GestionVehiculos;
import modelo.vehiculo.VehiculoCarga;
import modelo.vehiculo.VehiculoPasajeros;
import java.util.Scanner;

public class Interfaz {
    private boolean runApp;
    private final GestionVehiculos gestionVehiculos;
    private final Scanner scanner;

    public Interfaz(GestionVehiculos gestionVehiculos) {
        this.runApp = true;
        this.gestionVehiculos = gestionVehiculos;
        this.scanner = new Scanner(System.in);
    }

    public void menuPrincipal() {
        int seleccion;
        while (runApp) {
            System.out.println("\n=== Sistema Gestion DriveQuestRental ===");
            System.out.println("Elegir Opcion:");
            System.out.println("1. Ver lista vehiculos");
            System.out.println("2. Agregar vehiculo");
            System.out.println("3. Agregar arriendo de vehiculo");
            System.out.println("4. Calcular boleta");
            System.out.println("5. Guardar datos");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");

            try {
                seleccion = scanner.nextInt();
                scanner.nextLine();

                switch (seleccion) {
                    case 1:
                        verListarVehiculos();
                        break;
                    case 2:
                        agregarVehiculo();
                        break;
                    case 3:
                        agregarArriendoVehiculo();
                        break;
                    case 4:
                        calcularBoleta();
                        break;
                    case 5:
                        gestionVehiculos.guardarDatos();
                        System.out.println("Datos guardados exitosamente.");
                        break;
                    case 0:
                        runApp = false;
                        System.out.println("Saliendo del sistema...");
                        break;
                    default:
                        System.out.println("Opcion invalida. Intente nuevamente.");
                }
            } catch (Exception e) {
                System.out.println("Error: Ingrese un numero valido.");
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    public void verListarVehiculos() {
        System.out.println("\n=== Lista de Vehiculos ===");
        System.out.println("1. Vehiculos de Carga");
        System.out.println("2. Vehiculos de Pasajeros");
        System.out.println("3. Todos los vehiculos");
        System.out.print("Seleccione una opcion: ");

        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1:
                gestionVehiculos.mostrarVehiculosCarga();
                break;
            case 2:
                gestionVehiculos.mostrarVehiculosPasajeros();
                break;
            case 3:
                gestionVehiculos.mostrarTodosLosVehiculos();
                break;
            default:
                System.out.println("Opcion invalida.");
        }
    }

    public void agregarVehiculo() {
        System.out.println("\n=== Agregar Vehiculo ===");
        System.out.println("1. Vehiculo de Carga");
        System.out.println("2. Vehiculo de Pasajeros");
        System.out.print("Seleccione tipo de vehiculo: ");

        int tipo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese patente: ");
        String patente = scanner.nextLine();

        System.out.print("Ingrese marca: ");
        String marca = scanner.nextLine();

        System.out.print("Ingrese modelo: ");
        String modelo = scanner.nextLine();

        System.out.print("Ingrese valor arriendo por dia: ");
        int valorArriendo = scanner.nextInt();
        scanner.nextLine();

        if (tipo == 1) {
            System.out.print("Ingrese carga maxima (kg): ");
            int cargaMaxima = scanner.nextInt();
            scanner.nextLine();

            VehiculoCarga vehiculo = new VehiculoCarga(patente, marca, modelo, valorArriendo, cargaMaxima);
            gestionVehiculos.agregarVehiculoCarga(vehiculo);
            System.out.println("Vehiculo de carga agregado exitosamente.");
        } else if (tipo == 2) {
            System.out.print("Ingrese numero maximo de pasajeros: ");
            int pasajerosMaximo = scanner.nextInt();
            scanner.nextLine();

            VehiculoPasajeros vehiculo = new VehiculoPasajeros(patente, marca, modelo, valorArriendo, pasajerosMaximo);
            gestionVehiculos.agregarVehiculoPasajeros(vehiculo);
            System.out.println("Vehiculo de pasajeros agregado exitosamente.");
        } else {
            System.out.println("Tipo de vehiculo invalido.");
        }
    }

    public void agregarArriendoVehiculo() {
        System.out.println("\n=== Agregar Arriendo ===");
        System.out.print("Ingrese patente del vehiculo: ");
        String patente = scanner.nextLine();

        System.out.print("Ingrese numero de dias de arriendo: ");
        int dias = scanner.nextInt();
        scanner.nextLine();

        boolean resultado = gestionVehiculos.agregarArriendo(patente, dias);
        if (resultado) {
            System.out.println("Arriendo agregado exitosamente.");
        } else {
            System.out.println("No se pudo agregar el arriendo. Verifique que el vehiculo exista y este disponible.");
        }
    }

    public void calcularBoleta() {
        System.out.println("\n=== Calcular Boleta ===");
        System.out.print("Ingrese patente del vehiculo: ");
        String patente = scanner.nextLine();

        gestionVehiculos.calcularYMostrarBoleta(patente);
    }
}