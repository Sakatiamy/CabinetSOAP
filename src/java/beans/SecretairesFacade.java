/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import entities.Secretaires;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sakatiamy
 */
@Stateless
public class SecretairesFacade extends AbstractFacade<Secretaires> {
    @PersistenceContext(unitName = "CabinetSOAPPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SecretairesFacade() {
        super(Secretaires.class);
    }
    
}
