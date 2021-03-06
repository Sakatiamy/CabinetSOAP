/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Consultations;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sakatiamy
 */
@Stateless
public class ConsultationsFacade extends AbstractFacade<Consultations> {
    @PersistenceContext(unitName = "CabinetSOAPPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConsultationsFacade() {
        super(Consultations.class);
    }
    
}
