package log4jsample;

import org.apache.log4j.Logger;

public class MyClass1 {
    
    private final static Logger logger = Logger.getLogger(MyClass1.class.getName()); 
    
   void logSomethin() {
       logger.info("MyClass1");
   }
}
