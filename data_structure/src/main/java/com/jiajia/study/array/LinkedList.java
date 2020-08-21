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

        @Override
        public String toString() {
            return "Node{" +
                    "element=" + element +
                    ", next=" + next +
                    '}';
        }
    }

    @Override
    public void clear() {
        size = 0 ;
        first = null;
    }

    @Override
    public E get(int index) {
        return node(index).element;
    }

    @Override
    public E set(int index, E element) {

        Node<E> node = node(index);
        E oldElement = node.element;
        node.element = element;
        return oldElement;
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        // 头节点 特殊处理
        if(index == 0){
            first = new Node<E>(element,first);
        }else{
            Node<E> preNode = node(index - 1);
            Node<E> node = new Node<>(element,preNode.next);
            preNode.next = node;
        }
        size++ ;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        Node<E> oldNode = first;
        // 头节点特殊处理
        if(index == 0){
            first = first.next;
        }{
            Node<E> node = node(index - 1);
            oldNode = node.next;
            node.next = node.next.next;

        }
        size--;
        return oldNode.element;
    }

    @Override
    public int indexOf(E element) {
        Node<E> node = first;
        if(element == null){
            for (int i = 0; i < size; i++) {
                if(node.element == null){
                    return i;
                }
                node = node.next;
            }
        }else {
            for (int i = 0; i < size; i++) {
                if (node.element == element){
                    return i;
                }
                node =node.next;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    /**
     * 获取index位置的节点对象
     * @param index  索引位置
     * @return  索引位置的节点对象
     */
    private Node<E> node(int index){

        rangeCheck(index);
        Node<E> node = first;
        for (int i = 0; i < index; i++) {
            node = node.next;
        }
        return node;
    }

    @Override
    public String toString() {
        return "LinkedList{" +
                "first=" + first +
                ", size=" + size +
                '}';
    }
}
