package com.datastructure.designpattern.creational;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class SingletonEarly {

    //    static variable to hold the single instance of the class. Early Instantiation.
    private static SingletonEarly instanceEarly = new SingletonEarly();

    //   static variable to hold the single instance of the class. For Early instantiation (As the Application is up, it will create the instance.)
    private SingletonEarly() {
        System.out.println("Singleton instance created");
    }

    //    static method to get the single instance of the class. it's called lazy instantiation.
    public static SingletonEarly getInstanceEarly() {
        System.out.println("fetching instance");
        return instanceEarly;
    }
}

class SingletonLazy {

    //    static variable to hold the single instance of the class. Lazy Instantiation.
    private static SingletonLazy instance;

    //    private constructor to prevent instantiation.
    private SingletonLazy() {
        System.out.println("Singleton instance created");
    }

    //    static method to get the single instance of the class. it's called lazy instantiation. Once the Application runs and deployed the "instance" is still empty until and unless the first call happened to getInstance(). After the 1st call again if it is called it will use the same instance.
    public static SingletonLazy getInstance() {
        if (instance == null) {
            System.out.println("Creating first instance");
            instance = new SingletonLazy();
        }
        System.out.println("fetching instance");
        return instance;
    }
}

// prevent from multithreading
class SingletonThreadSafety {

    //    static variable to hold the single instance of the class. Lazy Instantiation.
    private static volatile SingletonThreadSafety instance = null;

    //    private constructor to prevent instantiation.
    private SingletonThreadSafety() {
        System.out.println("Singleton instance created");
    }

    //    use "synchronized" for locking.
    public static SingletonThreadSafety getInstance() {
        if (instance == null) {     // optimisation
            synchronized (SingletonThreadSafety.class) {    // t1, t2
                if (instance == null) {      // double checking
                    System.out.println("Creating first instance");
                    instance = new SingletonThreadSafety();
                }
            }
        }
        System.out.println("fetching instance");
        return instance;
    }
}


class MyClone implements Cloneable {
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

// Prevent from Cloning
class SingletonCloning extends MyClone {

    //    static variable to hold the single instance of the class. Lazy Instantiation.
    private static volatile SingletonCloning instance = null;

    //    private constructor to prevent instantiation.
    private SingletonCloning() {
        System.out.println("Singleton instance created");
    }

    //    prevent singleton from cloning
    @Override
    protected Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    //    use "synchronized" for locking.
    public static SingletonCloning getInstance() {
        if (instance == null) {     // optimisation
            synchronized (SingletonCloning.class) {    // t1, t2
                if (instance == null) {      // double checking
                    System.out.println("Creating first instance");
                    instance = new SingletonCloning();
                }
            }
        }
        System.out.println("fetching instance");
        return instance;
    }
}


// Prevent from reflection
class SingletonReflection {

    //    static variable to hold the single instance of the class. Lazy Instantiation.
    private static SingletonReflection instance = null;

    //    private constructor to prevent instantiation.
    private SingletonReflection() {
        if(instance != null){
            throw new IllegalStateException("Objects can't be created using reflection");
        }
        System.out.println("Singleton instance created");
    }

    //    use "synchronized" for locking.
    public static SingletonReflection getInstance() {
        if (instance == null) {     // optimisation
            synchronized (SingletonReflection.class) {    // t1, t2
                if (instance == null) {      // double checking
                    System.out.println("Creating first instance");
                    instance = new SingletonReflection();
                }
            }
        }
        System.out.println("fetching instance");
        return instance;
    }
}


// main
public class SingletonPattern {
    public static void main(String[] args) throws CloneNotSupportedException, InvocationTargetException, InstantiationException, IllegalAccessException {

        // Early Instantiation
//        SingletonEarly s1 = SingletonEarly.getInstanceEarly();
//        SingletonEarly s2 = SingletonEarly.getInstanceEarly();
//        System.out.println("Are both instances same ?  -> " + (s1 == s2));

        // Lazy Instantiation
//        SingletonLazy s1 = SingletonLazy.getInstance();
//        SingletonLazy s2 = SingletonLazy.getInstance();
//        System.out.println("Are both instances same ?  -> " + (s1 == s2));


        // we can break Singleton by multithreading. So prevent this we use "synchronised" keyword.
//        ExecutorService executor = Executors.newFixedThreadPool(2);
//        for (int i = 0; i < 15; i++) {
//            executor.execute(() -> SingletonThreadSafety.getInstance());
//        }

        // Prevent Cloning
//        SingletonCloning s1 = SingletonCloning.getInstance();
//        SingletonCloning s2 = (SingletonCloning) s1.clone();
//
//        System.out.println(s1.hashCode());
//        System.out.println(s2.hashCode());


        // prevent reflection
        SingletonReflection s1 = SingletonReflection.getInstance(); // 1 obj is created

        SingletonReflection reflectionInstance = null;
        java.lang.reflect.Constructor<?>[] constructors = SingletonReflection.class.getDeclaredConstructors();
        for(Constructor<?> constructor : constructors) {
            constructor.setAccessible(true);
            reflectionInstance = (SingletonReflection) constructor.newInstance();
        }

        System.out.println(reflectionInstance.hashCode());
        System.out.println(s1.hashCode());


    }
}
