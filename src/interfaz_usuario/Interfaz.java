package interfaz_usuario;

public class Interfaz {
    private boolean runApp;

    public Interfaz() {
        this.runApp = true;
    }

    public void MenuPrincipal(){
        int seleccion;
        while(runApp){
            System.out.println("Sistema Gestion DriveQuestRental");
            System.out.println("Elegir Opcion");
            System.out.println("1. Ver lista vehiculos ");
            System.out.println("2. Agregar vehiculo");
            System.out.println("3. Agregar arriendo de vehiculo");
            System.out.println("4. Salir");
        }
    }

    public void VerlistarVehiculos(){

    }

    public void AgregarVehiculo(){

    }

    public void AgregarArriendo(){

    }

}
