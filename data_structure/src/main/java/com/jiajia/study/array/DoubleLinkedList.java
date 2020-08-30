package com.jiajia.study.array;

/**
 * @author zjiajia
 * @date 2020/8/30 14:53
 *
 * 双向链表
 *
 */



public class DoubleLinkedList<E> extends AbstractList<E>{


    /**
     * 头节点
     */
    private Node<E> first;
    /**
     * 尾结点
     */
    private Node<E> last;

    /**
     * 节点
     * 用内部类的方式 来定义节点
     * @param <E>
     */
    private static class  Node<E>{
        E element;
        /**
         * 下一个节点
         */
        Node<E> next;
        /**
         * 下一个节点
         */
        Node<E> pre;
        public Node(Node<E> pre,E element, Node<E> next){
            this.element = element;
            this.next = next;
            this.pre =pre;
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
        last = null;
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
        Node<E> node = node(index);
        Node<E> pre = node.pre;
        Node<E> next = node.next;

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
        // 如果索引小于size 的一般，从前面找
        if(index > (size >> 1 )){
            Node<E> node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        }else{
            //如果索引大于size的一半，从后面往前面找
            Node<E> node = last;
            for (int i = size - 1; i > index; i--) {
                node = node.pre;
            }
            return node;
        }


    }

    @Override
    public String toString() {
        return "LinkedList{" +
                "first=" + first +
                ", size=" + size +
                '}';
    }
}
