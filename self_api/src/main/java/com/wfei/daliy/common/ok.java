package com.wfei.daliy.common;

import java.util.ArrayList;
import java.util.List;

/**
 * @author feiwen
 * @date 2018/5/22
 */
public class ok {
    public static void main(String[] args) {
        List<String> driverList=new ArrayList<>();
        driverList.add("1");
        driverList.add("2");
        driverList.add("3");
        List<String> subList=driverList.subList(0,1);
        driverList.add("s");
        System.out.println("ssssss");
        //遍历
//        System.out.println(subList);
        //增加
//        subList.add("s");
        //删除
//        subList.remove(0);
        //        for(String a:driverList){
//            System.out.println(a);
//        }

    }
}
