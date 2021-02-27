/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.app.on;

import ec.edu.ups.app.dao.CabeceraDetalleDAO;
import ec.edu.ups.app.dao.FacturaDAO;
import ec.edu.ups.app.dao.ProductoDAO;
import ec.edu.ups.app.modelo.CabeceraDetalle;
import ec.edu.ups.app.modelo.Factura;
import ec.edu.ups.app.modelo.Producto;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author vinicio
 */
@Stateless
public class GestionON {

    @Inject
    private ProductoDAO daoProducto;

    @Inject
    private CabeceraDetalleDAO daoCabacera;

    @Inject
    private FacturaDAO daoFactura;

    public Producto buscarProducto(int codigoProducto) throws Exception {
        try {
            return daoProducto.buscarProducto(codigoProducto);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            throw new Exception("Error al registrar cliente");
        }

    }

    public void guardarProducto(Producto producto) {
        daoProducto.insertProducto(producto);
    }

    public void insertCabecera(CabeceraDetalle cabeceraDeatalle) {
        daoCabacera.insertCabecera(cabeceraDeatalle);
    }

    public void insertFactura(Factura factura) {
        daoFactura.insertFactura(factura);
    }

    public List<CabeceraDetalle> listaDetalles() throws Exception {
        return daoCabacera.listaDetalles();
    }

    public List<CabeceraDetalle> listaDetalleId(String cedula) throws Exception {
        return daoCabacera.listaDetalleId(cedula);
    }

}
