/*
Permite el logueo de los usuarios. Consulta si el usuario esta en la base de datos para confirmar 
si puede loguearse en el sistema
 */
package Servlets;

import Logica.Usuario;
import Persistencia.Conexion;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Caro
 */
@WebServlet(name = "SvLogin", urlPatterns = {"/SvLogin"})
public class SvLogin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
        //traigo los datos del formulario
        String inputMail = request.getParameter("inputMail");
        String inputClave = request.getParameter("inputClave");
        
        //los cargo en la sesion
        request.getSession().setAttribute("inputMail", inputMail);
        request.getSession().setAttribute("inputClave", inputClave);
        
        //creo una instancia de conexion para realizar la consulta a la base de datos
        Conexion conexion = new Conexion();
        boolean logueo;
        Usuario usuario = new Usuario();
        
        usuario.setUsuario(inputMail);
        usuario.setClave(inputClave);
        
        
        logueo = conexion.puedeLoguearse(usuario);
        
        
        if(logueo){//si el usuario esta registrado redirecciona a pedido
            response.sendRedirect("pedido.html");
        }else{
            //si el usuario no esta registrado redirecciona a la pagina de error de logueo
            response.sendRedirect("errorLogueo.html");
        }
        
        
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
