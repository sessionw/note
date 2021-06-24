package dataStructure;

import java.util.*;

/**
 * 基于链表的集合
 *
 * @author wangYaBin
 * @date 2021/6/22
 */
public class DataLinkedList<E> extends AbstractSequentialList<E> implements List<E>, Cloneable {

    /**
     * 节点数据
     */
    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }

        public E getItem() {
            return item;
        }

        public Node<E> getNext() {
            return next;
        }

        public Node<E> getPrev() {
            return prev;
        }
    }

    /**
     * 头节点
     */
    private Node<E> first;

    /**
     * 尾节点
     */
    private Node<E> last;


    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

}
