package com;

import java.io.File;

/**
 * Created by Administrator on 14-4-4.
 */
public class TestSystem {
    public static void main(String[] args) throws Exception{
       // System.in.read();
        //System.err.println("err......");
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("user.name"));
        System.out.println(System.getProperty("path.seParator"));
        System.out.println(File.separator);
    }
}
