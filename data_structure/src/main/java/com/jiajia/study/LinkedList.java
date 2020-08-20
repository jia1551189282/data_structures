package com.jiajia.study;

/**
 * @Author zjiajia
 * @Date 2020/8/20 13:58
 * 链表
 */

public class LinkedList<E> {
    /**
     * 链表的大小
     */
    private int size;
    /**
     * 头节点
     */
    private Node<E> first;

    /**
     * 节点
     * 用内部类的方式 来定义节点
     * @param <E>
     */
    private static class  Node<E>{
        E element;
        Node<E> next;
        public Node(E element,Node<E> next){
            this.element = element;
            this.next = next;
        }
    }
}
