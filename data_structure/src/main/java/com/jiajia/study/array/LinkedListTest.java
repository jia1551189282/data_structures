package com.jiajia.study.array;

/**
 * @author zjiajia
 * @date 2020/8/20 16:17
 */
public class LinkedListTest {

    public static void main(String[] args) {
        test();
    }

    public static void test(){
        List<Integer> list = new LinkedList<>();
        list.add(20);
        list.add(0,2);
        list.add(30);
        list.add(list.size(),555);

        list.remove(1);
        System.out.println(list);
    }
}
