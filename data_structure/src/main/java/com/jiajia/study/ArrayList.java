package com.jiajia.study;



import java.util.Arrays;


/**
 * @Author zjiajia
 * @Date 2020/8/17 16:08
 */
public class ArrayList<E>  {
    /**
     * 元素的数量
     */
    private int size;
    /**
     * 所有的元素
     */
    private E[] elements;
    /**
     * 默认初始化容量大小
     */
    private static final int DEFAULT_CAPACIFY = 10;
    /**
     * 元素不存在 索引
     */
    private static final int ELELMENT_NOT_FOUND = -1;


    public ArrayList(int capacity){
        // 如果传入的容量小于 默认给的容量，就以默认容量为准
        capacity = (capacity < DEFAULT_CAPACIFY) ? DEFAULT_CAPACIFY : capacity;
        elements = (E[]) new Object[capacity];
    }

    public ArrayList(){
        this(DEFAULT_CAPACIFY);
    }

    /**
     * 元素的数量
     * @return
     */
    public int size(){
        return size;
    }

    /**
     * 是否为空
     * @return
     */
    public boolean isEmpty(){
        return size == 0;
    }

    /**
     * 是否包含某个元素
     * @param element
     * @return
     */
    public boolean contains(E element){
        return indexOf(element) == ELELMENT_NOT_FOUND;
    }

    /**
     * 添加一个元素到 最后面
     * @param element 添加的元素
     */
    public void add(E element){
          /*  elements[size] = element;
            size++;*/
          // 用已有方法处理
        add(size,element);
    }

    /**
     * 返回index位置的元素
     * @param index
     * @return
     */
    public E get(int index){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("数组索引越界：index：" + index + ",size:" + size);
        }
        return  elements[index];
    }

    /**
     * 设置index 位置的元素
     * @param index
     * @param element
     * @return
     */
    public E set(int index,E element){
        if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("数组索引越界：index：" + index + ",size:" + size);
        }
        E old = elements[index];
        elements[index] = element;
        return old;
    }

    /**
     * 往index 处添加元素
     * @param index     索引位置
     * @param element   添加的元素
     */
    public void add(int index,E element){

       /* if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("数组索引越界：index：" + index + ",size:" + size);
        }
*/      rangeCheckOfAdd(index);
        ensureCapacity(size + 1);

        for (int i = size; i > index + 1; i--) {
            elements[i] = elements[i-1];
        }
        elements[index] = element;
        size++;
    }



    /**
     * 删除index处的元素
     * @param index
     * @return
     */
    public E remove(int index){
        /*if(index < 0 || index >= size){
            throw new IndexOutOfBoundsException("数组索引越界：index：" + index + ",size:" + size);
        }
*/
        rangeCheck(index);
        E old = elements[index];
        for (int i = index-1; i <= size - 1; i++) {
            elements[i-1] = elements[i];
        }
        size--;
        elements[size] = null;
        return old;
    }

    /**
     * 查看元素的位置
     * @param element
     * @return
     */
    public int indexOf(E element){
        for (int i = 0; i < size; i++) {
            if(elements[i] .equals(element) ){
                return i;
            }
        }
        return ELELMENT_NOT_FOUND;
    }

    /**
     * 清除所有的元素
     */
    public void clear(){
        // 清除  数组中存放的 对象的内存
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }

    @Override
    public String toString() {
        return "ArrayList{" +
                "size=" + size +
                ", elements=" + Arrays.toString(elements) +
                '}';
    }


    /**
     * 确保容量，容量不够的时候，就对数组扩容，每次扩容为原来的1.5倍
     * @param capacity
     */
    private void ensureCapacity(int capacity) {
        int oldCapacity = elements.length;
        if(capacity <= oldCapacity){
            return ;
        }
        // 扩容为原来的 1.5 倍
        int newCapacity = oldCapacity + oldCapacity >> 1 ;
        E[] newElements = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }

    /**
     * 索引 检查
     * @param index 索引值
     */
    private void rangeCheck(int index){
        if(index < 0 || index >= size){
            outOfRange(index);
        }
    }

    /**
     * 添加的索引检查
     * @param index 索引值
     */
    private void rangeCheckOfAdd(int index){
        if(index < 0 || index > size){
            outOfRange(index);
        }
    }

    /**
     * 抛出索引异常
     * @param index  索引值
     */
    public void outOfRange(int index){
        throw new IndexOutOfBoundsException("数组索引越界：index：" + index + ",size:" + size);
    }
}
