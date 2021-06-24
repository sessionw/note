package dataStructure;


import java.util.Arrays;

/**
 * @author wangYaBin
 * @date 2021/6/4
 */
public class IntegerHeap {
    private final int[] dataArray;
    private final int max;


    /**
     * 堆中已存储数量
     */
    private static int CURRENT_COUNT = 0;

    /**
     * 最大长度
     */
    private static final int MAX_ARRAY_SIZE = Integer.MAX_VALUE - 8;

    public IntegerHeap() {
        this(new int[MAX_ARRAY_SIZE], MAX_ARRAY_SIZE - 1);
    }

    public IntegerHeap(int size) {
        this(new int[size + 1], size);
    }

    private IntegerHeap(int[] dataArray, int max) {
        this.dataArray = dataArray;
        this.max = max;
    }

    public void add(int e) {
        if (CURRENT_COUNT >= max) {
            throw new ArrayIndexOutOfBoundsException();
        }

        CURRENT_COUNT++;

        dataArray[CURRENT_COUNT] = e;

        int index = CURRENT_COUNT;

        while ((index / 2) > 0 && dataArray[index] > dataArray[index / 2]) {
            swap(dataArray, index, index / 2);
            index = index / 2;
        }
    }

    private void swap(int[] dataArray, int index, int i) {

    }
}
