/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.app.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author vinicio
 */
@Entity
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigoProducto;
    private String nombreProducto;
    private double precio;

    @JsonIgnore
    @OneToMany(mappedBy = "producto", fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    private List<CabeceraDetalle> listaCabecera;

    public int getCodigoProducto() {
        return codigoProducto;
    }

    public void setCodigoProducto(int codigoProducto) {
        this.codigoProducto = codigoProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public List<CabeceraDetalle> getListaCabecera() {
        return listaCabecera;
    }

    public void setListaCabecera(List<CabeceraDetalle> listaCabecera) {
        this.listaCabecera = listaCabecera;
    }

    @Override
    public String toString() {
        return "Producto [codigoProducto=" + codigoProducto + ", nombreProducto=" + nombreProducto + ", precio="
                + precio + ", listaCabecera=" + listaCabecera + "]";
    }

}
