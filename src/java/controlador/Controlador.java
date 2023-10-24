/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import modelo.Cliente;
import modelo.ClienteDAO;
import modelo.Empleado;
import modelo.EmpleadoDAO;
import modelo.Producto;
import modelo.ProductoDAO;

/**
 *
 * @author Darwi
 */
public class Controlador extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    Empleado em = new Empleado();
    EmpleadoDAO eDao = new EmpleadoDAO();
    Cliente c = new Cliente();
    ClienteDAO cDao = new ClienteDAO();
    Producto p = new Producto();
    ProductoDAO pDao = new ProductoDAO();

    int ide;
    int idc;
    int idp;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String menu = request.getParameter("menu");
        String accion = request.getParameter("accion");

        if (menu.equals("principal")) {
            request.getRequestDispatcher("principal.jsp").forward(request, response);
        }

        if (menu.equals("empleado")) {
            switch (accion) {
                case "Listar":
                    List lista = eDao.listar();
                    request.setAttribute("empleado", lista);
                    break;
                case "Agregar":
                    String dni = request.getParameter("txtDni");
                    String nom = request.getParameter("txtNombres");
                    String tel = request.getParameter("txtTel");
                    String estado = request.getParameter("txtEstado");
                    String user = request.getParameter("txtUsuario");

                    em.setDni(dni);
                    em.setNom(nom);
                    em.setTel(tel);
                    em.setEstado(estado);
                    em.setUser(user);
                    eDao.agregar(em);

                    request.getRequestDispatcher("Controlador?menu=empleado&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    ide = Integer.parseInt(request.getParameter("id"));
                    Empleado e = eDao.listarId(ide);
                    request.setAttribute("getEmpleado", e);
                    request.getRequestDispatcher("Controlador?menu=empleado&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String dniA = request.getParameter("txtDni");
                    String nomA = request.getParameter("txtNombres");
                    String telA = request.getParameter("txtTel");
                    String estadoA = request.getParameter("txtEstado");
                    String userA = request.getParameter("txtUsuario");

                    em.setDni(dniA);
                    em.setNom(nomA);
                    em.setTel(telA);
                    em.setEstado(estadoA);
                    em.setUser(userA);
                    em.setId(ide);

                    eDao.actualizar(em);
                    request.getRequestDispatcher("Controlador?menu=empleado&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    ide = Integer.parseInt(request.getParameter("id"));
                    eDao.eliminar(ide);
                    request.getRequestDispatcher("Controlador?menu=empleado&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }

            request.getRequestDispatcher("empleado.jsp").forward(request, response);
        }

        if (menu.equals("clientes")) {
            request.getRequestDispatcher("clientes.jsp").forward(request, response);
        }

        if (menu.equals("productos")) {
            request.getRequestDispatcher("productos.jsp").forward(request, response);
        }

        if (menu.equals("registrarVenta")) {
            switch (accion) {
                case "BuscarCliente":
                    String dni = request.getParameter("codigoCliente");
                    c.setDni(dni);
                    c = cDao.buscar(dni);
                    request.setAttribute("c", c);
                    break;
                default:
                    request.getRequestDispatcher("registrarVenta.jsp").forward(request, response);
            }
            request.getRequestDispatcher("registrarVenta.jsp").forward(request, response);
        }
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
