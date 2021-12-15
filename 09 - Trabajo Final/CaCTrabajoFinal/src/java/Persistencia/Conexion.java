/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Logica.Pedido;
import Logica.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            try {
                Class.forName("com.mysql.cj.jdbc.Driver"); //carga el controlador de la bbdd
            } catch (ClassNotFoundException ex) {
                //Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("problema con la clase mysql driver");
            }
            conexion = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/","root","");
            s = conexion.createStatement();
            //si no esta creada, crea la base de datos:
            s.executeUpdate("CREATE DATABASE IF NOT EXISTS CacProyecto2021"); 
            
           // 
            
        } catch (SQLException ex) { //en caso de haber algun error con la conexion pasa por aca y muestra un error por consola con los codigos de error (estos son los errores que aparecen en rojo cuando se compila)
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
        
        //conexion a la base de datos
         try {
             conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/CacProyecto2021", "root", ""); //conecta con la bbdd 
         } catch (SQLException ex) {
             //Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
             System.out.println("No se pudo conectar con la base de datos");
         }
         
        crearTabla(); //llamo al metodo que crea la tabla en caso de que no este creada
    }
    
    public void crearTabla() {
        // creo el Statement para realizar la creacion de las tablas de usuario y de pedidos
        Statement s;
        try {
            s = conexion.createStatement();            
            s.executeUpdate("CREATE TABLE IF NOT EXISTS Usuario(id_usuario INT AUTO_INCREMENT, PRIMARY KEY(id_usuario), usuario VARCHAR(150), clave VARCHAR(50), nombreyapellido VARCHAR(80))");
            s.executeUpdate("CREATE TABLE IF NOT EXISTS Pedido(id_pedido INT AUTO_INCREMENT, PRIMARY KEY(id_pedido), nombreCliente VARCHAR(150), apellidoCliente VARCHAR(80), nombreUsuario VARCHAR(80), email VARCHAR(40), lugarEntrega VARCHAR(40), localidad VARCHAR(40), provincia VARCHAR(40), codPostal INT, formaPago VARCHAR(40), nombreTitTC VARCHAR(100),  numeroTarjeta VARCHAR(100), fechaVenc VARCHAR(10), codSeguridad INT )");
            s.close();
        } catch (SQLException ex) {
            //en caso de que la tabla este creada se genera la excepción y mostramos el aviso 
            // de que ya está creada por consola
            System.out.println("La tabla ya se encuentra creada");
        }

    }
    
    //permite guardar un pedido en la bbdd
    public boolean guardarPedido(Pedido pedido){
        boolean pedidoGuardado = false;
        String guardarPedido;
        Statement stmt;
        guardarPedido = "INSERT INTO Pedido (nombreCliente, apellidoCliente, nombreUsuario, email, lugarEntrega, localidad, provincia, codPostal, formaPago, nombreTitTC, numeroTarjeta, fechaVenc, codSeguridad) VALUES('"+ pedido.getNombreCliente()+"', '"+ pedido.getApellidoCliente() + "', '" + pedido.getNombreUsuario() + "', '" + pedido.getEmail()  + "', '" + pedido.getLugarEntrega() + "', '" + pedido.getLocalidad()  + "', '" + pedido.getProvincia()  + "', '" + pedido.getCodPostal()  + "', '" + pedido.getFormaPago()  + "', '" + pedido.getNombreTitularTC()  + "', '" + pedido.getNumeroTarjeta()  + "', '" + pedido.getFechaVenc()  + "', '" + pedido.getCodSeguridadTC() + "')";
        try {
            stmt = conexion.createStatement();
            stmt.executeUpdate(guardarPedido); //
            pedidoGuardado = true; 
         } catch (SQLException ex) {
             Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
              pedidoGuardado = false;
        }
       
        //definir metodo de guardado de pedido
        return pedidoGuardado;
        
    }
    
    
    //guarda el usuario en la base de datos
    public boolean guardarUsuario( String nombre, String apellido, String mail, String clave){
        Usuario usuario = new Usuario();
        boolean fueGuardado = false;
        //guardo los valores en una instancia de Usuario
        usuario.setNombreyapellido(nombre + " " + apellido);
        usuario.setUsuario(mail);
        usuario.setClave(clave);
        
        //consulto si ya se encuentra en la base de datos
        if(estaRegistrado(usuario)){// si el usuario se encuentra ya registrado devuelvo false
            fueGuardado = false;
        }else{
            Statement stmt;
            String agregarUsuario; 
            agregarUsuario = "INSERT INTO usuario (usuario, clave, nombreyapellido) VALUES('"+ usuario.getUsuario()+"', '"+usuario.getClave() + "', '" + usuario.getNombreyapellido() + "')";
               try {
                    stmt = conexion.createStatement();
                    String st_inserta = agregarUsuario;
                    stmt.executeUpdate(st_inserta); //
                    fueGuardado = true; //el usuario no estaba guardado, se guarda y se retorna true
                } catch (SQLException ex) { //muestra error por consola
                System.out.println("Los datos de " + usuario.getNombreyapellido() + " no han podido ser guardados");
                }
        } 
        return fueGuardado;
    }
    
    
    
    //verifica si el usuario se encuentra registrado en la base de datos
    private boolean estaRegistrado(Usuario usuario){
      boolean registradoONo = false;
      Statement stmt;
      String buscarUsuario; 
      ResultSet result = null; 
         
      //guardo la consulta en el string para pasarla a la bbdd
      buscarUsuario = "SELECT * FROM usuario WHERE usuario = '"+ usuario.getUsuario() + "'";
        
        try {
            stmt = conexion.createStatement();
            result = stmt.executeQuery(buscarUsuario); //recupero los datos de la bbdd
            
            
            if (result.next()){//verifico si la consulta trajo datos
                registradoONo = true;//el usuario esta registrado
                
            }
            else{
                registradoONo = false; //el usuario no esta registrado
            }
        } catch (SQLException ex) {
            System.out.println("No se pudo establecer conexión con la base de datos dentro del metodo esta Registrado");
        }
        return registradoONo; //devuelvo el valor que indica si el usuario esta o no
    }
    
    
     public boolean puedeLoguearse(Usuario usuario){
      boolean registradoONo = false;
      Statement stmt;
      String buscarUsuario; 
      ResultSet result = null; 
         
      //guardo la consulta en el string para pasarla a la bbdd
      buscarUsuario = "SELECT * FROM usuario WHERE usuario = '"+ usuario.getUsuario() +"' AND clave='" + usuario.getClave() + "'";
        
        try {
            stmt = conexion.createStatement();
            result = stmt.executeQuery(buscarUsuario); //recupero los datos de la bbdd
            
            
            if (result.next()){//verifico si la consulta trajo datos
                registradoONo = true;//el usuario esta registrado
                
            }
            else{
                registradoONo = false; //el usuario no esta registrado
                }
        } catch (SQLException ex) {
            System.out.println("No se puddo establecer conexión con la base de datos dentro del metodo estaRegistrado");
        }
        return registradoONo; //devuelvo el valor que indica si el usuario esta o no
    }

  
}


