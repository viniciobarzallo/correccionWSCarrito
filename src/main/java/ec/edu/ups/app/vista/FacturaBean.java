package ec.edu.ups.app.vista;

import ec.edu.ups.app.modelo.CabeceraDetalle;
import ec.edu.ups.app.modelo.Factura;
import ec.edu.ups.app.modelo.Producto;
import ec.edu.ups.app.on.GestionON;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

@ManagedBean
@ViewScoped
public class FacturaBean {

    @Inject
    private GestionON on;
    private CabeceraDetalle cabeceraDetalle;
    private List<CabeceraDetalle> listaDetalle;
    private List<CabeceraDetalle> listaDetalleId;
    private List<Factura> listaFactura;
    private String id;
    private CabeceraDetalle resultadoCabecera;
    private Factura resultadoFactura;
    private Producto resultadoProducto;
    private String valor;

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public CabeceraDetalle getResultadoCabecera() {
        return resultadoCabecera;
    }

    public void setResultadoCabecera(CabeceraDetalle resultadoCabecera) {
        this.resultadoCabecera = resultadoCabecera;
    }

    public Factura getResultadoFactura() {
        return resultadoFactura;
    }

    public void setResultadoFactura(Factura resultadoFactura) {
        this.resultadoFactura = resultadoFactura;
    }

    public Producto getResultadoProducto() {
        return resultadoProducto;
    }

    public void setResultadoProducto(Producto resultadoProducto) {
        this.resultadoProducto = resultadoProducto;
    }

    public List<Factura> getListaFactura() {
        return listaFactura;
    }

    public void setListaFactura(List<Factura> listaFactura) {
        this.listaFactura = listaFactura;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CabeceraDetalle getCabeceraDetalle() {
        return cabeceraDetalle;
    }

    public void setCabeceraDetalle(CabeceraDetalle cabeceraDetalle) {
        this.cabeceraDetalle = cabeceraDetalle;
    }

    public List<CabeceraDetalle> getListaDetalle() {
        return listaDetalle;
    }

    public void setListaDetalle(List<CabeceraDetalle> listaDetalle) {
        this.listaDetalle = listaDetalle;
    }

    public List<CabeceraDetalle> getListaDetalleId() {
        return listaDetalleId;
    }

    public void setListaDetalleId(List<CabeceraDetalle> listaDetalleId) {
        this.listaDetalleId = listaDetalleId;
    }

    @PostConstruct
    public void init() {
        //listTicket= on.listaTickets();
        listaDetalles();
        resultadoFactura = new Factura();
        resultadoCabecera = new CabeceraDetalle();
    }

    public void listaDetalles() {
        try {
            listaDetalle = on.listaDetalles();
            System.out.println("lista");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println("error lista");
        }
    }

    public void listaCabaceraLista() {

        try {
            listaDetalleId = on.listaDetalleId(valor);
            for (CabeceraDetalle cabeceraDetalle : listaDetalleId) {
                resultadoFactura.setId(cabeceraDetalle.getFactura().getId());
                resultadoFactura.setTotalCompra(cabeceraDetalle.getFactura().getTotalCompra());
                resultadoCabecera.setNombre(cabeceraDetalle.getNombre());
                resultadoCabecera.setCorreo(cabeceraDetalle.getCorreo());
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
