package com;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Administrator on 14-4-14.
 */
public class TestSetContains {
    public static void main(String[] args) {
        Set<String> sets=new HashSet<String>();
        sets.add("fgsss");
        sets.add("123");
        sets.add("d56");
        sets.add("e8eee");

        if (!sets.contains("d56")) {
            System.out.println(sets.contains("d56")+"true");
        }else{
            System.out.println(sets.contains("d56")+"false");
        }




    }
}
