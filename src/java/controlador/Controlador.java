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
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
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
                    List listar = eDao.listar();
                    request.setAttribute("empleado", listar);
                    break;
                case "Agregar":
                    String dni = request.getParameter("txtDni");
                    String nom = request.getParameter("txtNombres");
                    String tel = request.getParameter("txtTel");
                    String estado = request.getParameter("txtEstado");
                    String user = request.getParameter("txtUsuario");
                    String clave = request.getParameter("txtPass");
                    String hashedClave = asegurarClave(clave);

                    em.setDni(dni);
                    em.setNom(nom);
                    em.setTel(tel);
                    em.setEstado(estado);
                    em.setUser(user);
                    em.setClave(hashedClave);
                    eDao.agregar(em);

                    request.getRequestDispatcher("Controlador?menu=empleado&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    ide = Integer.parseInt(request.getParameter("id"));
                    Empleado e = eDao.listarId(ide);
                    request.setAttribute("getEmpleado", e);
                    request.setAttribute("isEditing", true);

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
            switch (accion) {
                case "Listar":
                    List listar = cDao.listar();
                    request.setAttribute("cliente", listar);
                    break;
                case "Agregar":
                    String dni = request.getParameter("txtDni");
                    String nom = request.getParameter("txtNombres");
                    String direc = request.getParameter("txtDireccion");
                    String estado = request.getParameter("txtEstado");

                    c.setDni(dni);
                    c.setNom(nom);
                    c.setDireccion(direc);
                    c.setEstado(estado);
                    cDao.agregar(c);

                    request.getRequestDispatcher("Controlador?menu=clientes&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    idc = Integer.parseInt(request.getParameter("id"));
                    Cliente cl = cDao.listarId(idc);
                    request.setAttribute("getCliente", cl);
                    request.getRequestDispatcher("Controlador?menu=clientes&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String dniA = request.getParameter("txtDni");
                    String nomA = request.getParameter("txtNombres");
                    String direcA = request.getParameter("txtDireccion");
                    String estadoA = request.getParameter("txtEstado");

                    c.setDni(dniA);
                    c.setNom(nomA);
                    c.setDireccion(direcA);
                    c.setEstado(estadoA);
                    c.setId(idc);

                    cDao.actualizar(c);
                    request.getRequestDispatcher("Controlador?menu=clientes&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    idc = Integer.parseInt(request.getParameter("id"));
                    cDao.eliminar(idc);
                    request.getRequestDispatcher("Controlador?menu=clientes&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }

            request.getRequestDispatcher("clientes.jsp").forward(request, response);
        }

        if (menu.equals("productos")) {
            switch (accion) {
                case "Listar":
                    List listar = pDao.listar();
                    request.setAttribute("producto", listar);
                    break;
                case "Agregar":
                    String nom = request.getParameter("txtNombres");
                    Double precio = Double.parseDouble(request.getParameter("txtPrecio"));
                    int stock = Integer.parseInt(request.getParameter("txtStock"));
                    String estado = request.getParameter("txtEstado");

                    p.setNom(nom);
                    p.setPrecio(precio);
                    p.setStock(stock);
                    p.setEstado(estado);
                    pDao.agregar(p);

                    request.getRequestDispatcher("Controlador?menu=productos&accion=Listar").forward(request, response);
                    break;
                case "Editar":
                    idp = Integer.parseInt(request.getParameter("id"));

                    Producto prd = pDao.listarId(idp);
                    request.setAttribute("getProducto", prd);
                    request.getRequestDispatcher("Controlador?menu=productos&accion=Listar").forward(request, response);
                    break;
                case "Actualizar":
                    String nomA = request.getParameter("txtNombres");
                    Double precioA = Double.parseDouble(request.getParameter("txtPrecio"));
                    int stockA = Integer.parseInt(request.getParameter("txtStock"));
                    String estadoA = request.getParameter("txtEstado");

                    p.setNom(nomA);
                    p.setPrecio(precioA);
                    p.setStock(stockA);
                    p.setEstado(estadoA);
                    p.setId(idp);

                    pDao.actualizar(p);
                    request.getRequestDispatcher("Controlador?menu=productos&accion=Listar").forward(request, response);
                    break;
                case "Eliminar":
                    idp = Integer.parseInt(request.getParameter("id"));
                    pDao.eliminar(idp);
                    request.getRequestDispatcher("Controlador?menu=productos&accion=Listar").forward(request, response);
                    break;
                default:
                    throw new AssertionError();
            }

            request.getRequestDispatcher("productos.jsp").forward(request, response);
        }

        if (menu.equals("registrarVenta")) {
            switch (accion) {
                case "BuscarCliente":
                    request.setAttribute("numSerie", numeroSerie);
                    String dni = request.getParameter("codigoCliente");
                    c.setDni(dni);
                    c = cDao.buscar(dni);

                    request.setAttribute("c", c);
                    break;
                case "BuscarProducto":
                    request.setAttribute("numSerie", numeroSerie);
                    int id = Integer.parseInt(request.getParameter("codigoProducto"));
                    p = pDao.listarId(id);

                    request.setAttribute("c", c);
                    request.setAttribute("prod", p);
                    request.setAttribute("lista", lista);
                    break;
                case "Agregar":
                    request.setAttribute("numSerie", numeroSerie);
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
                    // Actualizar stock
                    for (int i = 0; i < lista.size(); i++) {
                        Producto pr = new Producto();

                        int cantidadProd = lista.get(i).getCantidad();
                        int idProducto = lista.get(i).getIdProducto();

                        ProductoDAO prDao = new ProductoDAO();
                        pr = prDao.buscar(idProducto);

                        int sac = pr.getStock() - cantidadProd;
                        prDao.actualizarStock(idProducto, sac);
                    }

                    // Guardar
                    v.setIdCliente(c.getId());
                    v.setIdEmpleado(2);
                    v.setNumSerie(numeroSerie);
                    v.setFecha("2023-10-31");
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

                    int incrementarNumSerie = Integer.parseInt(numeroSerie);

                    GenerarSerie generarS = new GenerarSerie();
                    numeroSerie = generarS.numeroSerie(incrementarNumSerie);
                    System.out.println(numeroSerie);
                    request.setAttribute("numSerie", numeroSerie);
                    break;
                case "Cancelar":
                    request.setAttribute("numSerie", numeroSerie);
                    lista.clear();
                    totalPagar = 0.0;
                    break;
                case "Eliminar":
                    request.setAttribute("numSerie", numeroSerie);
                    int idProducto = Integer.parseInt(request.getParameter("idProducto"));

                    for (int i = 0; i < lista.size(); i++) {
                        if (lista.get(i).getIdProducto() == idProducto) {
                            double valorProductoEliminar = lista.get(i).getSubTotal();
                            totalPagar -= valorProductoEliminar;
                            lista.remove(i);
                            break;
                        }
                    }

                    request.setAttribute("totalPagar", totalPagar);
                    request.setAttribute("lista", lista);
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

    public String asegurarClave(String textoClave) {
        String claveSha = null;

        try {
            MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
            sha256.update(textoClave.getBytes("UTF-8"));
            claveSha = String.format("%064x", new BigInteger(1, sha256.digest()));

        } catch (NoSuchAlgorithmException ex) {
            System.out.println("Error Validar asegurarClave:  " + ex.getMessage());
        } catch (UnsupportedEncodingException ex) {
            System.out.println("Error Validar asegurarClave update clave:  " + ex.getMessage());
        }

        return claveSha;
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
