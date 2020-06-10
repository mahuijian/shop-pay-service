package com.mhj.utils;

/**
 * @author mahuijian
 * @date 2019-09-02 15:39
 */
public class IdWorkerUtil {
    private static IdWorker idWorker;

    // 雪花算法静态块，只加载一次
    static {
        idWorker = new IdWorker(1, 1);
    }

    public static Long nextId() {
        return idWorker.nextId();
    }


    public static void main(String[] args) {
        System.out.println(IdWorkerUtil.nextId());
    }
}
