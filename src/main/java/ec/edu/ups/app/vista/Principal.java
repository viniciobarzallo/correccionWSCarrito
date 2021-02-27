/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.app.vista;

import ec.edu.ups.app.modelo.CabeceraDetalle;
import ec.edu.ups.app.modelo.Producto;
import ec.edu.ups.app.on.GestionON;
import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author vinicio
 */
@WebServlet("/producto")
public class Principal extends HttpServlet {

    @Inject
    private GestionON on;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.getWriter().println("<h1>Productos ingresados</h1>");
        try {
            Producto producto = new Producto();
            producto.setNombreProducto("Carne");
            producto.setPrecio(15);

            on.guardarProducto(producto);

            Producto producto2 = on.buscarProducto(1);
            System.out.println("Descripcioin" + producto2.getNombreProducto());

            CabeceraDetalle detalle = new CabeceraDetalle();
            detalle.setCedula("0104839451");
            detalle.setNombre("Vinicio");
            detalle.setCorreo("viniciobarzallo@hotmail.com");
            detalle.setCantidad(2);
            detalle.setTotal(producto2.getPrecio() * detalle.getCantidad());

            on.insertCabecera(detalle);

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
