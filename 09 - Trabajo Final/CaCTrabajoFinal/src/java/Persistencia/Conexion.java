/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Caro
 */
public class Conexion {
     Connection conexion; 

    
    //constructor que crea la bbdd en caso de no estar creada y genera la conexion
    public Conexion() {
        try {
            Statement s; 
            Class.forName("com.mysql.cj.jdbc.Driver"); //carga el controlador de la bbdd
            
            conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","");
            s = conexion.createStatement();
            //si no esta creada, crea la base de datos:
            s.executeUpdate("CREATE DATABASE IF NOT EXISTS CacProyecto2021"); 
            //creo la tabla libros en caso de que no exista:
            s.executeUpdate("CREATE TABLE IF NOT EXISTS Usuario(id_usuario INT AUTO_INCREMENT, PRIMARY KEY(id_usuario), usuario VARCHAR(150), clave VARCHAR(50), nombreyapellido VARCHAR(80))");
            s.close();
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/CacProyecto2021", "root", ""); //conecta con la bbdd 
        } catch (SQLException ex) { //en caso de haber algun error con la conexion pasa por aca y muestra un error por consola con los codigos de error (estos son los errores que aparecen en rojo cuando se compila)
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } catch (ClassNotFoundException ex) { 
            System.out.println("No se pudo establecer la conexión con la base de datos");
        }
    }
    
}
