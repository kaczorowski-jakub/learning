package com.os.udemy.jpa.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.os.udemy.jpa.image.Image;
import com.os.udemy.jpa.image.ImageRepository;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ImageTest {
    
    @Autowired
    ImageRepository repo;
    
    @Test
    public void saveFile() throws IOException {
        Image i = new Image();
        i.setId(1);
        i.setName("test1");
        
        File file = new File("D:\\Eclipse 201906\\workspace\\udemy-jpa\\src\\test\\resources\\1.jpg");
        try (FileInputStream is = new FileInputStream(file)) {
            i.setData(is.readAllBytes());
            repo.save(i);
        } catch (Exception e) {
            System.out.println("JCH - NIE POSZLO - ODCZYT");
        }
    }
    
    @Test
    public void loadFile() {
        Image i = repo.findById(1).get();
        File file = new File("D:\\Eclipse 201906\\workspace\\udemy-jpa\\src\\test\\resources\\1-1.jpg");
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(i.getData());
        } catch (Exception e) {
            System.out.println("JCH - NIE POSZLO - ZAPIS");
        }
        
    }
    
}
