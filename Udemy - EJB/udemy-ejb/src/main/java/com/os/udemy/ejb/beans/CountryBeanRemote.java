package com.os.udemy.ejb.beans;

import java.util.List;

import javax.ejb.Remote;

import com.os.udemy.ejb.entity.Country;

@Remote
public interface CountryBeanRemote {
    
    List<Country> getAllCountries();
    void test();
    
}
