package com.caogen.juc.threadlocal;

/**
 * @Author 康良玉
 * @Description 演示ThreadLocal用法2: 避免传递参数的麻烦(无需层层传递参数，把用户信息在当前线程内所有方法共享)
 * @Create 2023-03-30 12:19
 */
public class ThreadLocalNormalUsage04 {

    public static void main(String[] args) {
        new Service1().process();
    }

}


class Service1 {

    public void process() {
        User user = new User("caogen");
        UserContextHolder.holder.set(user);
        new Service2().process();
    }

}

class Service2 {
    public void process() {
        User user = UserContextHolder.holder.get();
        System.out.println("service2: " + user.name);
        new Service3().process();
    }
}

class Service3 {
    public void process() {
        User user = UserContextHolder.holder.get();
        System.out.println("service3: " + user.name);

        // 由于ThreadlocalMap的key是弱引用，value是强引用，所以用ThreadLocal有可能会出现内存泄露, 所以用完最好remove
        // 因为key可能被回收了，导致key是null, 但是value是强引用，所以对象一直存在,remove set 等方法会把key是null的value重置为null，这样就可以GC
        UserContextHolder.holder.remove();
    }
}

class UserContextHolder {
    public static ThreadLocal<User> holder = new ThreadLocal<>();
}

class User {
    String name;

    public User(String name) {
        this.name = name;
    }
}