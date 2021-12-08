/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Logica.Libro;
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
            s.executeUpdate("CREATE DATABASE IF NOT EXISTS CAC_Libros"); //si no esta creada, crea la base de datos
            s.close();
            conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/CAC_Libros", "root", ""); //conecta con la bbdd 
        } catch (SQLException ex) { //en caso de haber algun error con la conexion pasa por aca y muestra un error por consola con los codigos de error (estos son los errores que aparecen en rojo cuando se compila)
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } catch (ClassNotFoundException ex) { //otro mensaje de error que dice que no se pudo establecer la conexion
            System.out.println("No se pudo establecer la conexión con la base de datos");
        }
    }
    
     public void crearTabla() {
        // creo el Statement para realizar la creacion de la tabla
        Statement s;
        try {
            s = conexion.createStatement();
            //se crea una tabla nueva
            s.executeUpdate("CREATE TABLE IF NOT EXISTS Libro (id_libro INT AUTO_INCREMENT, PRIMARY KEY(id_libro), nombreLibro VARCHAR(150), autor VARCHAR(50), nroEjemplares INT, ejemplaresPrestados INT)");
            System.out.println("La tabla \"Libros\" ha sido creada correctamente");
        } catch (SQLException ex) {
            //en caso de que la tabla este creada se genera la excepción y mostramos el aviso 
            // de que ya está creada
            System.out.println("La tabla Libros ya se encuentra previamente creada");
        }

    }
     
    public void guardarLibro(Libro libro){
        
    }
}
