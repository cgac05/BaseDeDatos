/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ca.db_a;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author guill
 */
public class dbConnect {
    public static Connection con;
    //Class.forName("");
    
     public static void conectar() {
        try {
            // URL de conexión con UCanAccess
            //String url = "jdbc:ucanaccess://db.accdb";
            String url = "jdbc:ucanaccess://" + dbConnect.class.getClassLoader().getResource("db.accdb").getPath();

            // Establecer la conexión
            con = DriverManager.getConnection(url);

            System.out.println("Conectado a la base de datos.");
        } catch (SQLException e) {
            System.err.println("Error de conexión: " + e.getMessage());
        }
    }

     public static void obtenerPrimerRegistro() {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM diseño LIMIT 1");

            if (rs.next()) {
                int id = rs.getInt(1);  // Suponiendo que la primera columna es un ID
                String nombre = rs.getString(2);  // Segunda columna (ajusta según tu tabla)
                System.out.println("Primer registro - ID: " + id + ", Nombre: " + nombre);
            } else {
                System.out.println("No hay registros en la tabla.");
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.err.println("Error en la consulta: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        conectar();
        obtenerPrimerRegistro();
    }
}
