package proxy;

import java.lang.reflect.Proxy;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> proxyInstance = (Map<String, Integer>) Proxy.newProxyInstance(Main.class.getClassLoader(), new Class[] { Map.class }, new DynamicInvocationHandler());
        System.out.println(proxyInstance.put("A", 11));
    }
}
