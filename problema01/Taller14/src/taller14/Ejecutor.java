/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package taller14;

import java.util.Scanner;
import java.sql.SQLException;
import java.util.Locale;

/**
 *
 * @author josed
 */
public class Ejecutor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        // TODO code application logic here

        boolean bandera = true;
        Enlace c = new Enlace();
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        do {

            System.out.println("Ingrese el nombre del trabajador");
            String nombre = sc.nextLine();
            System.out.println("Ingrese la cedula del trabajador");
            String cedula = sc.nextLine();
            System.out.println("Ingrese el correo del trabajador");
            String correo = sc.nextLine();
            System.out.println("Ingrese el sueldo del trabajador");
            double sueldo = sc.nextDouble();
            sc.nextLine();
            System.out.println("Ingrese el mes del sueldo del trabajador");
            String mes = sc.nextLine();

            Trabajador t = new Trabajador(nombre, cedula, correo, sueldo, mes);
            c.insertarTrabajador(t);

            System.out.println("Si desea seguir ingresando datos escriba si,"
                    + " caso contrario escriba no");
            String condicion = sc.nextLine();

            if (condicion.equals("no")) {
                bandera = false;
            }

        } while (bandera);

        for (int i = 0; i < c.obtenerDataTrabajador().size(); i++) {
            System.out.printf("%s", c.obtenerDataTrabajador().get(i));
        }

    }
}
