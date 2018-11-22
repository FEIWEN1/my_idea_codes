package com.wfei.daliy.test;

import com.wfei.daliy.BaseTest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @author feiwen
 * @date 2018/8/16
 */
public class MyLamdaTestTest extends BaseTest {

    @Test
    public void streamTest() throws Exception {
//        mapOpertion();
//        filterOpertion();
//        sortedOperation();
        peekOperation();
    }

    /**
     * input Stream 的每一个元素，映射成 output Stream 的另外一个元素。
     */
    private void mapOperation() {
        List<String> list = new ArrayList<>(4);
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        List<String> li = list.stream().map(String::toLowerCase).collect(Collectors.toList());
        System.out.println(li);
    }

    /**
     * 将符合条件的元素选出来
     */
    private void filterOperation(){
        List<String> list = new ArrayList<>(4);
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        List<String> li = list.stream().filter(l -> l.equals("A")).collect(Collectors.toList());
        System.out.println(li);
    }

    /**
     * 将元素排序
     */
    private void sortedOperation(){
        List<String> list = new ArrayList<>(4);
        list.add("B");
        list.add("A");
        list.add("C");
        list.add("D");
        List<String> li=list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(li);
    }

    /**
     * 对每个元素执行操作并返回一个新的stream
     */
    private void peekOperation(){
        List<String> list = new ArrayList<>(4);
        list.add("B");
        list.add("A");
        list.add("C");
        list.add("D");
        list.stream().peek(e -> System.out.println(e)).collect(Collectors.toList());
    }

    /**
     * foreach循环
     */
    private void foreachOperation(){
        List<String> list = new ArrayList<>(4);
        list.add("B");
        list.add("A");
        list.add("C");
        list.add("D");
        list.forEach(e -> System.out.println(e));
    }

}