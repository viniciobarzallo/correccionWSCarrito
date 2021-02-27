/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.app.dao;

import ec.edu.ups.app.modelo.Producto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author vinicio
 */
@Stateless
public class ProductoDAO {

    @PersistenceContext
    private EntityManager em;

    public void insertProducto(Producto producto) {
        em.persist(producto);
    }

    public Producto buscarProducto(int codigoProducto) {
        return em.find(Producto.class, codigoProducto);
    }

}
