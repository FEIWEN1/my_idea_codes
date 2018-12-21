package com.wfei.daliy.singleton;

/**
 * 双重校验单例模式
 * @author feiwen
 * @date 2018/12/19
 */
public class DclSingleton {

    /**
     * 保证变量的可见性
     */
    private static volatile DclSingleton dclSingleton = null;

    private DclSingleton() {
    }

    public static DclSingleton getInstance() {
        if (dclSingleton == null) {
            synchronized (DclSingleton.class) {
                if (dclSingleton == null) {
                    dclSingleton = new DclSingleton();
                }
            }
        }
        return dclSingleton;
    }
}
