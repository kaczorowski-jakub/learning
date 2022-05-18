package com.os.udemy.ejb.test;

import java.util.List;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import com.os.udemy.ejb.beans.CategoryBeanRemote;
import com.os.udemy.ejb.entity.Category;
import com.os.udemy.ejb.entity.Categoryext;

public class CategoryBeanClient {
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
        CategoryBeanRemote lookup = (CategoryBeanRemote) context
                .lookup("bean/categoryBean#com.os.udemy.ejb.beans.CategoryBeanRemote");
        lookup.getAllCategories().forEach(System.out::println);

        System.out.println("\n----\nRead single - Horror");
        Category c = lookup.findByName("Horror");
        System.out.println(c.getName() + " - " + c.getCategoryId());

        System.out.println("\n----\nTake one");
        c = lookup.takeOne(2);
        System.out.println(c.getName() + " - " + c.getCategoryId());

        System.out.println("\n----\nTake native");
        List<Object> list = lookup.takeNative(1, 2, 3, 4, 5, 6);
        list.forEach(obj -> {
            Object[] data = (Object[]) obj;
            for (Object o : data) {
                System.out.print(o + " ");
            }
            System.out.println("");
        });
        
        System.out.println("\n----\nTake categoryext by Id");
        Categoryext ce = lookup.findById(2);
        System.out.println(ce);
        
        System.out.println("\n----\nTake category by tag");
        c = lookup.findByTag("tag10");
        System.out.println(c);
        
        System.out.println("\n----\nThird2join all");
        lookup.getAllThird2join().forEach(System.out::println);
        
        System.out.println("\n----\nThird2join by tag");
        lookup.getThird2joinByTag("tag10").forEach(System.out::println);
        
        System.out.println("\n----\nCreate category");
        lookup.createCategory(100, "TEST");
        
        System.out.println("\n----\nUpdate category");
        //lookup.updateCategoryext(1, "Tag1Updt");
        
        
    }
}
