package com;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Administrator on 14-4-4.
 */
public class TestIterator{
    public static void main(String[] args) {
        List list=new ArrayList();

        list.add("dd");
        list.add("fsd");
        list.add("dfsa");
        list.add("fds");
        list.add("ssssff");

        Iterator item=list.iterator();

        while (item.hasNext()){
            System.out.println((String)item.next());
        }
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        for(Iterator it=list.iterator();it.hasNext();){
            System.out.println((String)it.next());
        }


        HashSet set=new HashSet();
        set.add("fff");
        set.add("sd");
        set.add("fds");
        set.add("eew");
        set.add("ggg");

       /* for(int i=0;i<set.size();i++){
            System.out.println(set.get());
        }*/


    }
}
