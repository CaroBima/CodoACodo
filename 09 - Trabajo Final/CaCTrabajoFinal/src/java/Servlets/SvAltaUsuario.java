/*
Permite cargar un usuario en la base de datos
 */
package Servlets;

import Persistencia.Conexion;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Caro
 */
@WebServlet(name = "SvAltaUsuario", urlPatterns = {"/SvAltaUsuario"})
public class SvAltaUsuario extends HttpServlet {

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
        String inputNombre = request.getParameter("inputNombre");
        String inputApellido = request.getParameter("inputApellido");
        String inputMail = request.getParameter("inputMail");
        String inputClave = request.getParameter("inputClave");
        
        //traigo la sesion y asigno  los atributos para mostrarlos en la pagina de confirmacion de registro
        
        request.getSession().setAttribute("inputNombre", inputNombre);
        request.getSession().setAttribute("inputApellido", inputApellido);
        request.getSession().setAttribute("inputMail", inputMail);
        request.getSession().setAttribute("inputClave",inputClave);
        
        
        Conexion conexion = new Conexion();
        boolean guardado;
        //envio el cargo nuevo al metodo que une la logica con la persistencia
        guardado = conexion.guardarUsuario(inputNombre, inputApellido, inputMail, inputClave);
        
        if(guardado){
            //si se pudo guardar redirecciono a la pagina de confirmacion
            response.sendRedirect("confirmacionRegistro.jsp");
        }else{
            //informo que el usuario ya ha sido previamente guardado
             response.sendRedirect("errorRegistro.jsp");
            
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
