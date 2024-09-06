package ui;
import model.Controller;
import java.util.Scanner;

public class Main {
    private Scanner reader = new Scanner(System.in);
    private Controller controller = new Controller();

    public static void main(String[] args) {
        Main main = new Main();
        main.menu();
    }

    public void menu() {
        int opc = 0;
        do{
            System.out.println("------------------------------");
            System.out.println("1. crear persona \n" +
                    "2. Eliminar persona \n" +
                    "3. contar pacientes \n" +
                    "4. buscar el paciente mas joven \n" +
                    "5. buscar un paciente con un codigo \n" +
                    "6. salir \n");
            opc = reader.nextInt();
            switch (opc){
                case 1:
                    crearPaciente();
                    break;
                case 2:
                    eliminarPaciente();
                    break;
                case 3:
                    numeroDePacientes();
                    break;
                case 4:
                    pacienteMasJoven();
                    break;
                case 5:
                    buscarPaciente();
                    break;
                case 6:
                    System.out.println("bye");
            }
        }while(opc != 6);
    }


    public void crearPaciente(){
        System.out.println("Ingrese el codigo del paciente ");
        String codigo = reader.next();
        System.out.println("Ingrese la fecha de nacimiento del paciente ");
        System.out.println("Ingrese el ano de nacimiento del paciente ");
        int year = reader.nextInt();
        System.out.println("Ingrese el mes de nacimiento del paciente ");
        int month = reader.nextInt();
        System.out.println("Ingrese el dia de nacimiento del paciente ");
        int day = reader.nextInt();
        System.out.println("Ingrese el nombre del paciente ");
        String nombre = reader.next();
        String result = controller.convertToCalendar(codigo,year,month -1,day,nombre);
        System.out.println(result);
    }

    public void eliminarPaciente(){
        System.out.println("Ingrese el codigo del paciente ");
        String codigo = reader.next();
        String result = controller.eliminarPacientes(codigo);
        System.out.println(result);
    }

    public void numeroDePacientes(){
        System.out.println(controller.contarPacientes());
    }

    public void pacienteMasJoven(){
        System.out.println(controller.encontrarJoven());
    }

    public void buscarPaciente(){
        System.out.println("Ingrese el codigo del paciente ");
        String codigo = reader.next();
        System.out.println(controller.busquedaPaciente(codigo));
    }






}
