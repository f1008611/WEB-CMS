package com;

/**
 * Created by Administrator on 14-4-4.
 */
public class TestMemory {
    public static void main(String[] args) {
        Runtime r=Runtime.getRuntime();
        System.out.println("totalMemory="+r.totalMemory());
        r.gc();
        System.out.println("totalMemory="+r.totalMemory());
    }
}
