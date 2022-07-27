/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package taller14;

/**
 *
 * @author josed
 */
public class Trabajador {

    private String cedula;
    private String nombre;
    private String correo;
    private double sueldo;
    private String mes;

    public Trabajador(String n, String c, String r, double sue, String m) {
        cedula = c;
        nombre = n;
        correo = r;
        sueldo = sue;
        mes = m;

    }

    public String obtenerCedula() {
        return cedula;
    }

    public void establecerCedula(String c) {
        cedula = c;
    }

    public String obtenerNombre() {
        return nombre;
    }

    public void establecerNombre(String n) {
        nombre = n;
    }

    public String obtenerCorreo() {
        return correo;
    }

    public void establecerCorreo(String c) {
        correo = c;
    }

    public double obtenerSueldo() {
        return sueldo;
    }

    public void establecerSueldo(double s) {
        sueldo = s;
    }

    public String obtenerMes() {
        return mes;
    }

    public void establecerMes(String m) {
        mes = m;
    }

    @Override
    public String toString() {
        String data = String.format(""
                + "Nombre: %s\n"
                + "Cedula: %s\n"
                + "Correo: %s\n"
                + "Sueldo: %.2f\n"
                + "Mes   : %s\n",
                nombre,
                cedula,
                correo,
                sueldo,
                mes);
        return data;
    }
}
