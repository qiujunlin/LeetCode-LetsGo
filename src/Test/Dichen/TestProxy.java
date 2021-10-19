package Test.Dichen;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class TestProxy {

    public static void main(String[] args) throws Exception {
//        Class  proxyClass=Proxy.getProxyClass(Car.class.getClassLoader(),Car.class);
//        Constructor constructor = proxyClass.getConstructor(InvocationHandler.class);
//        Car  car = (Car) constructor.newInstance(new InvocationHandler() {
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                CarImpl car1 =  new CarImpl();
//                car1.run();
//                return null;
//            }
//        });
//        car.run();
        CarImpl car = new CarImpl();
        Car o =(Car)Proxy.newProxyInstance(CarImpl.class.getClassLoader(), CarImpl.class.getInterfaces(),new CarProxy(car));
        o.run();



    }
}
class CarProxy  implements InvocationHandler{
    Object object;
    public CarProxy(Object o ) {
        this.object = o;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("jdk动态代理调用前");
        method.invoke(object,args);
        System.out.println("jdk动态代理调用后");
        return null;
    }
}
