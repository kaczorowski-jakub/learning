package com.os.udemy.ejb.beans;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.transaction.UserTransaction;

/**
 * Session Bean implementation class BeanManagedBean
 * 
 * Transaction is applied to data source and DB only
 * It has nothing to do with the beans
 */
@Stateless(mappedName = "bean/beanManagedBean")
@LocalBean
@TransactionManagement(TransactionManagementType.BEAN)
public class BeanManagedBean implements BeanManagedBeanRemote {
    
    String val;
    
    /**
     * Default constructor.
     */
    public BeanManagedBean() {
        // TODO Auto-generated constructor stub
    }
    
    @Resource
    UserTransaction userTransaction;
    
    @Override
    @TransactionAttribute(TransactionAttributeType.NEVER)
    public void testNever() throws Exception {
        System.out.println("TEST which is NEVER in transaction");
        this.val = "TEST_NEVER";

    }

    @Override
    @TransactionAttribute(TransactionAttributeType.MANDATORY)
    public void testMandatory() throws Exception {
        System.out.println("ABCD" + "val");
    }

}
