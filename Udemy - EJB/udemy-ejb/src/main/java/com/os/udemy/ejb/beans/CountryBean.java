package com.os.udemy.ejb.beans;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.os.udemy.ejb.entity.Country;

/**
 * Session Bean implementation class CountryBean
 */
@Stateless(mappedName = "bean/countryBean")
@LocalBean
public class CountryBean implements CountryBeanRemote {

    /**
     * Default constructor. 
     */
    public CountryBean() {
        // TODO Auto-generated constructor stub
    }
    
    @PersistenceContext(unitName = "udemy-ejb")
    EntityManager em;
    
    @Override
    public List<Country> getAllCountries() {
        // TODO Auto-generated method stub
        return em.createNamedQuery("Country.findAll").getResultList();
    }
    
    @Override
    public void test() {
        System.out.println("TEST Country Bean");
    }

}
