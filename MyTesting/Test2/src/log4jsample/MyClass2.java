package log4jsample;

import org.apache.log4j.Logger;

public class MyClass2 {
    
    private final static Logger logger = Logger.getLogger(MyClass2.class.getName()); 
    
   void logSomethin() {
       logger.debug("This will not be looged test");
       logger.info("MyClass2");
   }
}
