package com.os.udemy.ejb.beans;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.os.udemy.ejb.entity.Category;
import com.os.udemy.ejb.entity.Categoryext;
import com.os.udemy.ejb.entity.Third2join;

/**
 * Session Bean implementation class CategoryBean
 */
@Stateless(mappedName = "bean/categoryBean")
@LocalBean
public class CategoryBean implements CategoryBeanRemote {

    /**
     * Default constructor.
     */
    public CategoryBean() {
        // TODO Auto-generated constructor stub
    }

    @PersistenceContext(unitName = "udemy-ejb")
    EntityManager em;

    @Override
    public List<Category> getAllCategories() {
        return em.createNamedQuery("Category.findAll").getResultList();
    }

    @Override
    public Category findByName(String name) {
        List<Category> resultList = em.createNamedQuery("Category.findByName").setParameter("name", name)
                .getResultList();
        return resultList.size() > 0 ? resultList.get(0) : null;
    }

    @Override
    public Category takeOne(int id) {
        List<Category> resultList = em.createQuery("select cat from Category cat where cat.categoryId=:id")
                .setParameter("id", id).getResultList();
        return resultList.size() > 0 ? resultList.get(0) : null;
    }

    @Override
    public List<Object> takeNative(Integer... id) {

        String ids = Arrays.asList(id).stream().reduce("", (partial,
                element) -> partial.isEmpty() ? Integer.toString(element) : partial + "," + Integer.toString(element),
                (a, b) -> a = b);

        return em.createNativeQuery("select * from category where category_id in (" + ids + ")").getResultList();
    }

    @Override
    public Categoryext findById(Integer seq) {
        List<Categoryext> resultList = em.createNamedQuery("Categoryext.findBySeq").setParameter("seq", seq)
                .getResultList();
        return resultList.size() > 0 ? resultList.get(0) : null;
    }

    @Override
    public Category findByTag(String tag) {
        List<Category> resultSet = em.createQuery(
                "select cat from Category cat, Categoryext cate where cat.categoryId=cate.categoryId and cate.tag=:tag")
                .setParameter("tag", tag).getResultList();
        return resultSet.size() > 0 ? resultSet.get(0) : null;
    }

    @Override
    public List<Third2join> getAllThird2join() {
        List<Third2join> resultList = em.createNamedQuery("Third2join.findAll").getResultList();
        return resultList;
    }

    @Override
    public List<Third2join> getThird2joinByTag(String tag) {
        List<Third2join> resultList = em.createQuery(
                "select t2j from Category cat, Categoryext cate, Third2join t2j where cat.categoryId=cate.categoryId and cate.seq=t2j.categoryextId and cate.tag=:tag")
                .setParameter("tag", tag).getResultList();
        return resultList;
    }

    @Override
    public void createCategory(int id, String name) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("udemy-ejb");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Category c = new Category();
        c.setCategoryId(id);
        c.setName(name);
        c.setLastUpdate(new Timestamp(System.currentTimeMillis()));
        em.persist(c);
        em.getTransaction().commit();
        em.close();
        emf.close();
    }

    @Override
    public void updateCategoryext(int id, String tag) {
        // approach #1
        String queryStr = "update Categoryext cate set cate.tag=:tag where cate.seq=:id";
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("udemy-ejb");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery(queryStr);
        query.setParameter("id", id);
        query.setParameter("tag", tag);
        int ret = query.executeUpdate();
        em.getTransaction().commit();
        System.out.println("Update categoryext: " + ret);

        // approach #2
//        Categoryext cext = (Categoryext) em.createQuery("select cate from Categoryext cate where cate.seq=:id")
//                .setParameter("id", id).getResultList().get(0);
//        cext.setTag(cext.getTag() + "abc");
//        em.merge(cext);
        em.close();
        emf.close();
    }

}
