package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.logging.Logger;


public class DynamicInvocationHandler implements InvocationHandler {
    
    private static final Logger LOGGER = Logger.getLogger(DynamicInvocationHandler.class.getName()); 
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        LOGGER.info(method.getName());
        
        return 1;
    }

}
