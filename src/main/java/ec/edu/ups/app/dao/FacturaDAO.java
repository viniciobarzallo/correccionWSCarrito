/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.app.dao;

import ec.edu.ups.app.modelo.Factura;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author vinicio
 */
@Stateless
public class FacturaDAO {

    @PersistenceContext
    private EntityManager em;

    public void insertFactura(Factura factura) {
        em.persist(factura);
    }

    public List<Factura> listaFacturaId(String id) throws Exception {
        String jpql = "SELECT p FROM Factura p WHERE id LIKE :id";

        Query q = em.createQuery(jpql, Factura.class);
        q.setParameter("id", id);
        System.out.println("ejecuto listasolicitud");
        return q.getResultList();
    }

}
