package pl.mjedynak.service;

import com.google.common.reflect.AbstractInvocationHandler;
import com.google.common.reflect.Reflection;

import java.lang.reflect.Method;

public class LazyInitWithProxyServiceFactory {

    public static Service createService() {
        return Reflection.newProxy(Service.class, new LazyInitInvocationHandler());
    }

    private static class LazyInitInvocationHandler extends AbstractInvocationHandler {
        private Service service;

        @Override
        protected Object handleInvocation(Object proxy, Method method, Object[] args) throws Throwable {
            return method.invoke(service(), args);
        }

        private Service service() {
            if (service == null) {
                service = new DefaultService();
            }
            return service;
        }
    }
}
