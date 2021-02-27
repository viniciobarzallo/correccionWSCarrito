/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.app.servicios;

import ec.edu.ups.app.modelo.CabeceraDetalle;
import ec.edu.ups.app.modelo.Factura;
import ec.edu.ups.app.modelo.Producto;
import ec.edu.ups.app.on.GestionON;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

/**
 *
 * @author vinicio
 */
@Path("/carrito")
public class ServicioREST {

    @Inject
    private GestionON on;

    @GET
    @Path("/producto")
    @Produces("application/json")
    public Producto getCategoriaId(@QueryParam("id") int id) {
        Respuesta resp = new Respuesta();
        Producto cat = null;
        try {
            cat = on.buscarProducto(id);
            resp.setCodigo(1);
            resp.setMensaje("Producto encontrado");
        } catch (Exception ex) {
            resp.setCodigo(-1);
            resp.setMensaje("El producto no existe");
        }
        System.out.println(cat);
        return cat;
    }

    @POST
    @Path("/factura")
    @Produces("application/json")
    @Consumes("application/json")
    public Respuesta saveCategoria(Parametros parametros) {
        Respuesta resp = new Respuesta();
        CabeceraDetalle cab;
        Factura factura = new Factura();
      
        List<Detalles> lista = parametros.getListaDetalles();
        List<CabeceraDetalle> listacab = new ArrayList<CabeceraDetalle>();
        double aux = 0;

        try {

            for (Detalles detalles : lista) {

                cab = new CabeceraDetalle();
                cab.setCedula(parametros.getCedula());
                cab.setNombre(parametros.getNombre());
                cab.setCorreo(parametros.getCorreo());
                cab.setCantidad(detalles.getCantidad());

                Producto producto = on.buscarProducto(detalles.getCodigoProducto());
                aux = aux + (detalles.getCantidad() * producto.getPrecio());

                cab.setTotal(detalles.getCantidad() * producto.getPrecio());
                cab.setFactura(factura);
                cab.setProducto(producto);
                listacab.add(cab);
                
            }
            factura.setTotalCompra(aux);
            factura.setListaDestalles(listacab);
            on.insertFactura(factura);

            resp.setCodigo(1);
            resp.setMensaje("Ingreso correcto de cabecera");
        } catch (Exception e) {
            resp.setCodigo(-1);
            resp.setMensaje("Error al ingresar cabecera");
        }
        return resp;
    }

}
