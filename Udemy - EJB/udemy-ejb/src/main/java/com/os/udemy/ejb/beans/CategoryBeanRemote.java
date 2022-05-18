package com.os.udemy.ejb.beans;

import java.util.List;

import javax.ejb.Remote;

import com.os.udemy.ejb.entity.Category;
import com.os.udemy.ejb.entity.Categoryext;
import com.os.udemy.ejb.entity.Third2join;

@Remote
public interface CategoryBeanRemote {
    
    List<Category> getAllCategories();
    Category findByName(String name);
    Category takeOne(int id);
    List<Object> takeNative(Integer... id);
    Categoryext findById(Integer seq);
    Category findByTag(String tag);
    List<Third2join> getAllThird2join();
    List<Third2join> getThird2joinByTag(String tag);
    void updateCategoryext(int id, String name); 
    void createCategory(int id, String name);
}
