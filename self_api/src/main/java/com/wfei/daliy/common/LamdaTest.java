package com.wfei.daliy.common;

import javax.swing.*;
import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @author feiwen
 * @date 2018/6/6
 */
public class LamdaTest {

    public static void main(String[] args) {
//        List<String> list=new ArrayList<>();
//        list.add("a");
//        list.add("b");
//        list.add("c");
////        list.stream().forEach(p -> );
//        list.forEach((p) -> {
//            new StringBuffer(p).append("sss").toString();
//        });
//        new LamdaTest().streamFilter();
//          new LamdaTest().streamDistinct();
//        new LamdaTest().streamLimit();
//        new LamdaTest().streamMap();
//        new LamdaTest().streamSort();
//        new LamdaTest().streamCount();
//        new LamdaTest().streamMatch();
        new LamdaTest().streamForeach();
    }

    /**
     * 用lambda表达式实现runnable
     */
    public void ThreadLambda(){
        new Thread(() ->{
            System.out.println("hahha");
        }).start();
    }

    /**
     * 用lambda表达式进行事件处理
     */
    public void actionLambda(){
        JButton show=new JButton();
        show.addActionListener((e)-> System.out.println("sss"));
    }

    /**
     * 使用lambda表达式对列表进行循环
     */
    public void forEachLambda(){
        List list= Arrays.asList("a","b","c","d");
        Map<Integer,String> map=new HashMap<>();
        map.put(1,"aa");
        map.put(2,"bb");
//        list.forEach(a -> System.out.println(a));
        map.forEach((k, v) -> System.out.println(k + v));
    }

    /**
     * stream的filter功能
     */
    public void streamFilter(){
        List<Double> list=new ArrayList();
        list.add(0.1);
        list.add(0.2);
        list.add(0.4);
        List<Double> list1=list.stream().filter(o -> o > 0.3).collect(Collectors.toList());
        System.out.println(list1);
    }

    /**
     * staream的distinct的去重功能
     */
    public void streamDistinct(){
//        List<BigDecimal> list=new ArrayList<>();
//        list.add(new BigDecimal(1.0));
//        list.add(new BigDecimal(1.0));
//        list.add(new BigDecimal(1.0001));
//        List<String> list = new ArrayList<>();
//        list.add("a");
//        list.add("b");
//        list.add("a");
//        List<Integer> list=new ArrayList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(1);
        List<Double> list=new ArrayList<>();
        list.add(0.10001);
        list.add(0.2);
        list.add(0.10001);
        List<Double> list1=list.stream().distinct().collect(Collectors.toList());
        System.out.println(list1);
    }

    /**
     * stream的skip与limit功能
     */
    public void streamLimit(){
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1);
        List<Integer> list1=list.stream().skip(1).limit(1).collect(Collectors.toList());
        System.out.println(list1);
    }

    /**
     * stream的map方法
     * 接受一个函数作为参数，并且将该函数作用在每个元素上，并生成新的元素
     */
    public void streamMap() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1);
        List<Integer> list1 = list.stream().map(o -> o + 1).collect(Collectors.toList());
        System.out.println(list1);
    }

    /**
     * stream的sorted方法
     * 将集合的元素进行排序
     */
    public void streamSort(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1);
        List<Integer> list1=list.stream().sorted().collect(Collectors.toList());
        System.out.println(list1);
        List<Integer> list2=list.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println(list2);
        List<Student> theList=new ArrayList<>();
        theList.add(new Student("a",12));
        theList.add(new Student("b",14));
        theList.add(new Student("c",13));
        List<Student> theList1 = theList.stream().sorted(Comparator.comparing(Student::getAge).reversed()).collect(Collectors.toList());
        System.out.println(theList1);
    }
    public void streamMapSort(){
        Map<Integer, String> map = new TreeMap<>();
        map.put(1,"a");
        map.put(2,"b");
        map.put(5,"c");
        map.put(4,"d");

    }

    /**
     * stream的count方法
     * 查看集合的元素个数
     */
    public void streamCount(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1);
        System.out.println(list.stream().count());
    }

    /**
     * stream的match方法
     */
    public void streamMatch(){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1);
        System.out.println(list.stream().allMatch(o -> o - 1 == 0));
        System.out.println(list.stream().anyMatch(o -> o - 1 == 0));
    }

    /**
     * stream的foreach方法
     */
    public void streamForeach(){
        List<Double> list = new ArrayList<>();
        list.add(0.1);
        list.add(0.2);
        list.add(0.3);
        list.add(0.1);
        list.stream().forEach(s -> {
            Double p = BigDecimal.valueOf(s).add(BigDecimal.valueOf(0.1)).doubleValue();
            System.out.println(p);
        });
    }
    class Student{
        private String name;
        private Integer age;
        public Student(String name,Integer age){
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public Integer getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

}
