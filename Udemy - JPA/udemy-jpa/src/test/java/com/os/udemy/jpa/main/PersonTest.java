package com.os.udemy.jpa.main;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.os.udemy.jpa.person.Licence;
import com.os.udemy.jpa.person.LicenceRepository;
import com.os.udemy.jpa.person.Person;
import com.os.udemy.jpa.person.PersonRepository;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class PersonTest {

    @Autowired
    LicenceRepository repo;
    
    @Autowired
    PersonRepository repo2;

    @Test
    public void licenceCreate() {
        Person p = Person.builder().firstName("Allan").lastName("McCalahan").age(32).build();
        Licence l = Licence.builder().type("CAR").validFrom(LocalDate.now().minusYears(10))
                .validTo(LocalDate.now().plusYears(10)).person(p).build();
        repo.save(l);
    }
    
    @Test
    public void personCreate() {
        Person p = Person.builder().firstName("Barbara").lastName("Smith").age(32).build();
        Licence l = Licence.builder().type("JET").validFrom(LocalDate.now().minusYears(10))
                .validTo(LocalDate.now().plusYears(10)).build();
        p.setLicence(l);
        repo2.save(p);
    }
}
