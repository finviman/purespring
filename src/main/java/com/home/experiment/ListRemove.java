package com.home.experiment;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by liyang on 1/9/18.
 * liyang70@meituan.com;
 */
public class ListRemove {

    public static void main(String[] args) {
        List<Integer> ten = new ArrayList<>();
        for(int i=0;i<10;i++) {
            ten.add(i);
        }

        final Iterator<Integer> iterator = ten.iterator();
        while (iterator.hasNext()) {
            final Integer next = iterator.next();
            if (next==6) {
                iterator.remove();
            }
        }
        //for (Integer indx : ten) {
        //    if (indx==6) {
        //        ten.remove(indx);
        //    }
        //}
        System.out.println(ten.get(5));
    }
}
