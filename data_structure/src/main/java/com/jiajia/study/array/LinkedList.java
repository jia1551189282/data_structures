package com.jiajia.study.array;

/**
 * @author zjiajia
 * @date 2020/8/20 15:22
 */
public class LinkedList<E> extends AbstractList<E> {

    /**
     * 链表的大小
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
        public Node(E element, Node<E> next){
            this.element = element;
            this.next = next;
        }
    }

    @Override
    public void clear() {

    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(E element) {
        return 0;
    }
}
