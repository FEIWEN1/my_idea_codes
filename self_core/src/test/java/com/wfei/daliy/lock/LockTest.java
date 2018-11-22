package com.wfei.daliy.lock;

import com.wfei.daliy.BaseTest;
import org.junit.Test;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author feiwen
 * @date 2018/11/21
 */
public class LockTest extends BaseTest {


    @Test
    public void LockTest() {
        ReentrantLock putMessageNormalLock = new ReentrantLock();
        new Thread(new LockThread(1, putMessageNormalLock)).start();
        new Thread(new LockThread(100, putMessageNormalLock)).start();
        try {
            Thread.sleep(Integer.MAX_VALUE);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("ccccccc");
    }

    public static void main(String[] args) {
        ReentrantLock putMessageNormalLock = new ReentrantLock();
        new Thread(new LockThread(1, putMessageNormalLock)).start();
        new Thread(new LockThread(100, putMessageNormalLock)).start();
//        putMessageNormalLock.lock();
        System.out.println("ccccccc");
    }

}

class LockThread implements Runnable {

    private Integer code;
    private  ReentrantLock reentrantLock;

    public LockThread(int i, ReentrantLock reentrantLock) {
        this.code = i;
        this.reentrantLock = reentrantLock;
    }

    @Override
    public void run() {
        if (code > 50) {
            lockResoureA();
        } else {
            lockResourceB();
        }
    }

    private void lockResoureA() {
        reentrantLock.lock();
        System.out.println("aaaaaa");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        reentrantLock.unlock();
    }

    private void lockResourceB() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        reentrantLock.lock();
        System.out.println("bbbbbbbbb");
        reentrantLock.unlock();
    }
}
