/*
Servlet que procesa los pedidos y los envia a la persistencia
 */
package Servlets;

import Logica.Pedido;
import Persistencia.Conexion;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Caro
 */
@WebServlet(name = "SvPedido", urlPatterns = {"/SvPedido"})
public class SvPedido extends HttpServlet {

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
        String nombreUsuario = request.getParameter("nombreUsuario");
        String inputEmail = request.getParameter("inputEmail");
        String inputLugarEntrega = request.getParameter("inputLugarEntrega");
        String inputLocalidad = request.getParameter("inputLocalidad");
        String inputProvincia = request.getParameter("inputProvincia");
        String inputCodPostal = request.getParameter("inputCodPostal");
        
        //los cargo en la sesion
        request.getSession().setAttribute("inputNombre", inputNombre);
        request.getSession().setAttribute("inputApellido", inputApellido);
        request.getSession().setAttribute("nombreUsuario", nombreUsuario);
        request.getSession().setAttribute("inputEmail", inputEmail);
        request.getSession().setAttribute("inputLugarEntrega", inputLugarEntrega);
        request.getSession().setAttribute("inputLocalidad", inputLocalidad);
        request.getSession().setAttribute("inputProvincia", inputProvincia);
        request.getSession().setAttribute("inputCodPostal", inputCodPostal);
        
        
        //creo una instancia de conexion para realizar la consulta a la base de datos
        Conexion conexion = new Conexion();
        Pedido pedido = new Pedido();
        boolean pedidoGuardado;
        
        pedido.setNombreCliente(inputNombre);
        pedido.setApellidoCliente(inputApellido);
        pedido.setNombreUsuario(nombreUsuario);
        pedido.setEmail(inputEmail);
        pedido.setLugarEntrega(inputLugarEntrega);
        pedido.setLocalidad(inputLocalidad);
        pedido.setProvincia(inputProvincia);
        pedido.setCodPostal(parseInt(inputCodPostal));
        
        pedidoGuardado = conexion.guardarPedido(pedido);
        
        if(pedidoGuardado){
            //el pedido pudo ser guardado
             response.sendRedirect("confirmacionPedido.html");
        }else{
            //el pedido no se pudo guardar
            response.sendRedirect("errorPedido.html");
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
