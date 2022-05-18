package com.os.udemy.ejb.test;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import com.os.udemy.ejb.beans.BeanManagedBeanRemote;

public class BeanManagedBeanClient {
    static InitialContext getInitialContext() throws Exception {
        Properties properties = new Properties();
        properties.put(Context.INITIAL_CONTEXT_FACTORY, "weblogic.jndi.WLInitialContextFactory");
        properties.put(Context.PROVIDER_URL, "t3://localhost:7001");
        properties.put(Context.SECURITY_PRINCIPAL, "weblogic");
        properties.put(Context.SECURITY_CREDENTIALS, "qbaosk20");
        return new InitialContext(properties);
    }
    
    public static void main(String[] args) throws Exception {
        Context context = getInitialContext();
        BeanManagedBeanRemote lookup = (BeanManagedBeanRemote) context.lookup("bean/beanManagedBean#com.os.udemy.ejb.beans.BeanManagedBeanRemote");
        lookup.testNever();
        lookup.testMandatory();
    }
}
