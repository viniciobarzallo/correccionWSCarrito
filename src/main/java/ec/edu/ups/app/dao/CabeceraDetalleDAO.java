/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.app.dao;

import ec.edu.ups.app.modelo.CabeceraDetalle;
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
public class CabeceraDetalleDAO {

    @PersistenceContext
    private EntityManager em;

    public void insertCabecera(CabeceraDetalle cabeceraDeatalle) {
        em.persist(cabeceraDeatalle);
    }

    public List<CabeceraDetalle> listaDetalleId(String cedula) throws Exception {
        String jpql = "SELECT p FROM CabeceraDetalle p WHERE cedula LIKE :cedula";

        Query q = em.createQuery(jpql, CabeceraDetalle.class);
        q.setParameter("cedula", cedula);
        System.out.println("ejecuto listasolicitud");
        return q.getResultList();
    }

    public List<CabeceraDetalle> listaDetalles() throws Exception {
        String jpql = "SELECT p FROM CabeceraDetalle p";

        Query q = em.createQuery(jpql, CabeceraDetalle.class);
        // q.setParameter("filtro", filtro + "%");
        return q.getResultList();
    }

}
