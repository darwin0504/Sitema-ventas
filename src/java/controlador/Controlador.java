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
import java.util.ArrayList;
import java.util.List;
import modelo.Cliente;
import modelo.ClienteDAO;
import modelo.Empleado;
import modelo.EmpleadoDAO;
import modelo.GenerarSerie;
import modelo.Producto;
import modelo.ProductoDAO;
import modelo.Venta;
import modelo.VentaDAO;

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

    Venta v = new Venta();
    List<Venta> lista = new ArrayList<>();

    int item;
    int cod;
    String descripcion;
    double precio;
    int cantidad;
    double subTotal;
    double totalPagar;

    String numeroSerie;
    VentaDAO vDao = new VentaDAO();

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
                case "BuscarProducto":
                    int id = Integer.parseInt(request.getParameter("codigoProducto"));
                    p = pDao.listarId(id);

                    request.setAttribute("c", c);
                    request.setAttribute("prod", p);
                    request.setAttribute("lista", lista);
                    break;
                case "Agregar":
                    request.setAttribute("c", c);
                    totalPagar = 0.0;
                    item = item + 1;
                    cod = p.getId();
                    descripcion = request.getParameter("nombreProducto");
                    precio = Double.parseDouble(request.getParameter("precio"));
                    cantidad = Integer.parseInt(request.getParameter("cantidad"));
                    subTotal = precio * cantidad;

                    v = new Venta();
                    v.setItem(item);
                    v.setIdProducto(cod);
                    v.setDescripcion(descripcion);
                    v.setMonto(precio);
                    v.setCantidad(cantidad);
                    v.setSubTotal(subTotal);
                    lista.add(v);

                    for (int i = 0; i < lista.size(); i++) {
                        totalPagar = totalPagar + lista.get(i).getSubTotal();
                    }

                    request.setAttribute("totalPagar", totalPagar);
                    request.setAttribute("lista", lista);
                    break;
                case "GenerarVenta":
                    // Guardar
                    v.setIdCliente(c.getId());
                    v.setIdEmpleado(2);
                    v.setNumSerie(numeroSerie);
                    v.setFecha("2023-10-25");
                    v.setMonto(totalPagar);
                    v.setEstado("1");
                    vDao.guardarVenta(v);

                    // Guardar detalle
                    int idV = Integer.parseInt(vDao.idVenta());

                    for (int i = 0; i < lista.size(); i++) {
                        v = new Venta();
                        v.setId(idV);
                        v.setIdProducto(lista.get(i).getIdProducto());
                        v.setCantidad(lista.get(i).getCantidad());
                        v.setMonto(lista.get(i).getMonto());
                        vDao.guardarDetalleVenta(v);
                    }
                    break;
                default:
                    v = new Venta();
                    lista = new ArrayList<>();
                    item = 0;
                    totalPagar = 0.0;
                    numeroSerie = vDao.generarSerie();

                    if (numeroSerie == null) {
                        numeroSerie = "00000001";

                        request.setAttribute("numSerie", numeroSerie);
                    } else {
                        int incrementar = Integer.parseInt(numeroSerie);

                        GenerarSerie gS = new GenerarSerie();
                        numeroSerie = gS.numeroSerie(incrementar);

                        request.setAttribute("numSerie", numeroSerie);
                    }

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
