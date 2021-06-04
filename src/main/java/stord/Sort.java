package stord;

/**
 * @author wangYaBin
 * @date 2021/6/4
 */
public class Sort {
    /**
     * 选择排序
     */
    public static int[] selectSort(int[] arr, int size) {
        long start = System.currentTimeMillis();
        int temp;
        for (int i = 0; i < size - 1; i++) {

            int index = 0;
            for (int j = 0; j < size - i; j++) {
                if (arr[j] > arr[index]) {
                    index = j;
                }
            }

            temp = arr[index];
            arr[index] = arr[size - 1 - i];
            arr[size - 1 - i] = temp;
        }
        System.out.println("耗时：" + (System.currentTimeMillis() - start));
        return arr;
    }

    /**
     * 插入排序
     */
    public static int[] insertSort(int[] arr, int size) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
        System.out.println("耗时：" + (System.currentTimeMillis() - start));
        return arr;
    }
}
