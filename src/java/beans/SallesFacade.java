/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Salles;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sakatiamy
 */
@Stateless
public class SallesFacade extends AbstractFacade<Salles> {
    @PersistenceContext(unitName = "CabinetSOAPPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SallesFacade() {
        super(Salles.class);
    }
    
}
