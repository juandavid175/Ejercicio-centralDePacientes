package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Controller {

    private PacienteNodo head;
    private PacienteNodo tail;

    public void newNodo(){
        head = null;
        tail = null;
    }

    public String convertToCalendar(String codigo, int year, int month, int day, String nombre){
        String cadena = "";
        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day);
        cadena = agregarPaciente(codigo,calendar,nombre);
        return cadena;
    }

    public String agregarPaciente(String codigo, Calendar fechaDeNacimiento, String nombre){
        String msg = "";
        PacienteNodo current = head;
        while(current != null){
            if(codigo.equals(current.getCodigo())){
                return msg = "El codigo de la Paciente Ya existe";
            }
            current = current.getNext();
        }
        PacienteNodo nuevo = new PacienteNodo(codigo,fechaDeNacimiento,nombre);

            if(head == null){
                head = nuevo;
                tail = nuevo;
                msg = "el paciente se ha agregado correctamente";
            }else{
                tail.setNext(nuevo);
                tail = nuevo;
                msg = "el paciente se ha agregado correctamente";
            }
        return msg;
    }

    public String busquedaPaciente(String codigo){
        PacienteNodo current = head;
        while(current != null){
            if(current.getCodigo().equals(codigo)){
                return current.toString();
            }
            current = current.next;
        }
        return null;
    }

    public String eliminarPacientes(String codigo){
        String msg = "";
        PacienteNodo current = head;
        PacienteNodo temp = null;
        while(current != null){
            temp = current;
            if(current.getCodigo().equals(codigo)){
                current = current.getNext();
                temp.setNext(current.getNext());
                return null;
            }
            current = current.getNext();
        }
        return msg = "eliminando el paciente";
    }

    public int contarPacientes(){
        int contador = 0;
        PacienteNodo current = head;
        while(current != null){
            contador++;
            current = current.getNext();
        }
        return contador;
    }


    public String encontrarJoven(){
        PacienteNodo current = head;
        PacienteNodo ordenado = null;
        while (current != null){
            PacienteNodo temp = current.getNext(); // en que casilla estamos cuando estamos parados en el arreglo
            ordenado = byCompareTo(ordenado,current);
            current = temp;
        }
        head = ordenado;
        return "el paciente mas joven es: " + head.getNombre();
    }

    public PacienteNodo byCompareTo(PacienteNodo paciente1, PacienteNodo paciente2){
        if(paciente1 == null || paciente1.compareTo(paciente2) < 0){ //en la clase se hizo mayor que cero pero estaba mal
            paciente1 = paciente2;
            return paciente1;
        }else{
            PacienteNodo current = paciente1;
            while(current.getNext() != null && current.getNext().compareTo(paciente2) > 0){
                current = current.getNext();
            }
            paciente2.setNext(current.getNext());
            current.setNext(paciente2);
        }
        return paciente1;
    }


}
