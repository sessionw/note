package dataStructure;

import org.springframework.lang.NonNull;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.List;
import java.util.RandomAccess;

/**
 * 基于数组的集合
 *
 * @author wangYaBin
 * @date 2021/6/22
 */
public class DataArrayList<E> extends AbstractList<E> implements List<E>, RandomAccess, Cloneable {

    /**
     * 初始容量10个
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 部分虚拟机在数组中保留了数据
     */
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    /**
     * 数据数组
     */
    private Object[] elementData;

    /**
     * 链表大小(包含数据)
     */
    private int size;

    /**
     * 一个空的数组
     */
    private static final Object[] EMPTY_ELEMENT_DATA = {};

    /**
     * 与 EMPTY_ELEMENT_DATA 区分开
     */
    private static final Object[] DEFAULT_CAPACITY_EMPTY_ELEMENT_DATA = {};

    public DataArrayList() {
        this.elementData = DEFAULT_CAPACITY_EMPTY_ELEMENT_DATA;
    }

    public DataArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.elementData = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.elementData = EMPTY_ELEMENT_DATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E get(int index) {
        rangeCheck(index);
        return elementData(index);
    }

    private void rangeCheck(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        }
    }

    private String outOfBoundsMsg(int index) {
        return "Index: " + index + ", Size: " + size;
    }


    @SuppressWarnings("unchecked")
    E elementData(int index) {
        return (E) elementData[index];
    }

    @Override
    public boolean add(E e) {
        ensureCapacityInternal(size + 1);
        elementData[size++] = e;
        return true;
    }


    private void ensureCapacityInternal(int minCapacity) {
        ensureExplicitCapacity(calculateCapacity(elementData, minCapacity));
    }

    private void ensureExplicitCapacity(int minCapacity) {
        modCount++;

        if (minCapacity - elementData.length > 0) {
            grow(minCapacity);
        }
    }

    private void grow(int minCapacity) {
        int oldCapacity = elementData.length;

        int newCapacity = oldCapacity + oldCapacity >> 1;

        if (newCapacity < minCapacity) {
            newCapacity = minCapacity;
        }

        if (newCapacity > MAX_ARRAY_SIZE) {
            newCapacity = hugeCapacity(minCapacity);
        }

        elementData = Arrays.copyOf(elementData, newCapacity);
    }

    private static int hugeCapacity(int minCapacity) {
        if (minCapacity < 0) {
            throw new OutOfMemoryError("Required array size too small");
        }

        return (minCapacity > MAX_ARRAY_SIZE) ? Integer.MAX_VALUE : MAX_ARRAY_SIZE;
    }

    private int calculateCapacity(Object[] elementData, int minCapacity) {
        if (elementData == DEFAULT_CAPACITY_EMPTY_ELEMENT_DATA) {
            return Math.max(DEFAULT_CAPACITY, minCapacity);
        }

        return minCapacity;
    }


    @Override
    public E remove(int index) {
        rangeCheck(index);

        modCount++;

        E oldValue = elementData(index);

        int numMoved = size - 1 - index;

        if (numMoved > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }

        // clear to let GC do its work
        elementData[--size] = null;

        return oldValue;
    }
}
