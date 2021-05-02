package common;

import java.util.concurrent.atomic.AtomicInteger;

// 按序打印
class Foo {

    public Foo() {

    }

    AtomicInteger one = new AtomicInteger(0);
    AtomicInteger two = new AtomicInteger(0);

    public void first(Runnable printFirst) throws InterruptedException {

        printFirst.run();
        one.compareAndSet(0, 1);
    }

    public void second(Runnable printSecond) throws InterruptedException {

        while (one.get() != 1) {

        }
        printSecond.run();
        two.compareAndSet(0, 1);
    }

    public void third(Runnable printThird) throws InterruptedException {
        while (two.get() != 1) {

        }
        printThird.run();
    }
}