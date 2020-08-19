package com.jiajia.study;

/**
 * @Author zjiajia
 * @Date 2020/8/18 9:38
 */
public class ArrayListTest {
    public static void main(String[] args) {
        // 测试 添加删除方法
//        test();
//        test1();
        test3();
    }

    /**
     * 测试 初步的添加删除方法
     */
    public static void test(){

        ArrayListInt arrayList = new ArrayListInt();
        arrayList.add(33);
        arrayList.add(-9);
        arrayList.add(0);
        arrayList.add(8888);
        arrayList.add(-789);

        arrayList.remove(arrayList.size() - 1);

        System.out.println(arrayList);
    }

    /**
     * 测试 往索引位置添加元素
     */
    public static void test1(){
        ArrayListInt arrayList = new ArrayListInt();
        arrayList.add(33);
        arrayList.add(-9);
        arrayList.add(0);
        arrayList.add(8888);
        arrayList.add(-789);

//        arrayList.add(0,1111);
        arrayList.add(arrayList.size(),1111);
        System.out.println(arrayList);
    }

    public static void test3(){
        ArrayList<Person> personArrayList = new ArrayList<Person>();
        personArrayList.add(new Person("玊玊",22));
        personArrayList.add(new Person("佳佳",22));

        System.out.println(personArrayList);

    }
}
