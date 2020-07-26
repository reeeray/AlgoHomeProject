package patterns.structural.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * User : Shein G.A.{@reeeray}
 * Date : 21.07.2020
 **/
public class SecurityProxy implements InvocationHandler {

    private Object obj;

    private SecurityProxy(final Object object) {
        this.obj = object;
    }

    public static Object newInstance(final Object object) {
        return java.lang.reflect.Proxy.newProxyInstance(object.getClass().getClassLoader(),
                object.getClass().getInterfaces(), new SecurityProxy(object));
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        try {
            if (method.getName().contains("post")) {
                throw new IllegalAccessException("Posts are currently not allowed");
            }
            result = method.invoke(obj, args);
        } catch (final InvocationTargetException e) {
            e.printStackTrace();
        } catch (final Exception e) {
            throw new RuntimeException("Unexpected invocation exception: " + e.getMessage());
        }

        return result;
    }
}
