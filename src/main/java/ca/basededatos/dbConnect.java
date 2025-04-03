/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.basededatos;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author guill
 */
public class dbConnect {
    public static Connection con;
    //Class.forName("");
    
    public static void conectar(){
        try{
        Class.forName("net.uanaccess.jdbc.UcanaccessDriver");
        con = DriverManager.getConnection("/jdbc.ucanaccess/db.accdb");
        }catch (Exception e){
            System.out.println("error");
        }
        System.out.println("conectado");
    }
    public static void main(String[] args) {
        conectar();
    }
}
