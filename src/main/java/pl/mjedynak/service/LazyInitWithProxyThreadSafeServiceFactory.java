package pl.mjedynak.service;

import com.google.common.reflect.AbstractInvocationHandler;
import com.google.common.reflect.Reflection;
import org.apache.commons.lang3.concurrent.LazyInitializer;

import java.lang.reflect.Method;

public class LazyInitWithProxyThreadSafeServiceFactory {

    public static Service createService() {
        return Reflection.newProxy(Service.class, new ThreadSafeLazyInitInvocationHandler());
    }

    private static class ThreadSafeLazyInitInvocationHandler extends AbstractInvocationHandler {
        private static final LazyInitializer<Service> initializer = new LazyInitializer<Service>() {
            @Override
            protected Service initialize() {
                return new DefaultService();
            }
        };

        @Override
        protected Object handleInvocation(Object proxy, Method method, Object[] args) throws Throwable {
            return method.invoke(initializer.get(), args);
        }
    }
}
