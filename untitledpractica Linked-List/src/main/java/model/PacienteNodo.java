package model;

import java.util.Calendar;
import java.text.SimpleDateFormat;


public class PacienteNodo implements Comparable<PacienteNodo> {
    int value;
    PacienteNodo next;
    private String codigo;
    private Calendar fechaNacimiento;
    private String nombre;
    private final String date;

    public PacienteNodo(String codigo, Calendar fechaNacimiento, String nombre) {
        this.codigo = codigo;
        this.fechaNacimiento = fechaNacimiento;
        this.nombre = nombre;
        next = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        date = dateFormat.format(fechaNacimiento.getTime());
    }




    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public PacienteNodo getNext() {
        return next;
    }

    public void setNext(PacienteNodo next) {
        this.next = next;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Calendar getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Calendar fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int compareTo(PacienteNodo otropacinete) {
        return this.fechaNacimiento.compareTo(otropacinete.getFechaNacimiento());
    }

    @Override
    public String toString() {
        return "PacienteNodo{" +
                ", codigo='" + codigo + '\'' +
                ", fechaNacimiento=" + date +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
