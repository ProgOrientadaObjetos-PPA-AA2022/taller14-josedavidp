/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Paquete01;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author josed
 */
public class Enlace {

    private Connection conn;

    public void establecerConexion() {

        try {
            // db parameters  
            String url = "jdbc:sqlite:bd/base001.bd";
            // create a connection to the database  
            conn = DriverManager.getConnection(url);
            // System.out.println(conn.isClosed());
            // System.out.println("Connection to SQLite has been established.");  

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public Connection obtenerConexion() {
        return conn;
    }

    public void insertarCalificaciones(Calificaciones calificaciones) {

        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = String.format("INSERT INTO estudiante (nombre, "
                    + "apellido, calificacion1, calificacion2, calificacion3) "
                    + "values ('%s', '%s', '.2f', '.2f', '.2f', '.2f')",
                    calificaciones.obtenerNombre(),
                    calificaciones.obtenerApellido(),
                    calificaciones.obtenerCal1(),
                    calificaciones.obtenerCal2(),
                    calificaciones.obtenerCal3(),
                    calificaciones.obtenerPromedio());
            statement.executeUpdate(data);
            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception: insertarCalificaciones");
            System.out.println(e.getMessage());

        }
    }

    public ArrayList<Calificaciones> obtenerDataCalificaciones() {
        ArrayList<Calificaciones> lista = new ArrayList<>();
        try {
            establecerConexion();
            Statement statement = obtenerConexion().createStatement();
            String data = "Select * from estudiante;";

            ResultSet rs = statement.executeQuery(data);
            while (rs.next()) {
                Calificaciones misCalificaciones = new Calificaciones(
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getDouble("estudiante1"),
                        rs.getDouble("estudiante2"),
                        rs.getDouble("estudiante3"));
                lista.add(misCalificaciones);
            }

            obtenerConexion().close();
        } catch (SQLException e) {
            System.out.println("Exception: insertarCalificaciones");
            System.out.println(e.getMessage());

        }
        return lista;
    }
}
