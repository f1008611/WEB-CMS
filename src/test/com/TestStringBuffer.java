package com;

/**
 * Created by Administrator on 14-4-4.
 */
public class TestStringBuffer {
    public static void main(String[] args) {
        StringBuffer stringBuffer=new StringBuffer("aaaaaa");
        stringBuffer.append("test");
        stringBuffer.insert(2,"bbbb你好好好好好好好好好好好好好好好好好好好好b");
        stringBuffer.reverse();
        stringBuffer.trimToSize();
        String str=stringBuffer.toString();
        System.out.println(str);
    }
}
