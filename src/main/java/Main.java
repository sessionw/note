import dataStructure.DataArrayList;
import org.apache.commons.lang3.RandomUtils;

import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author wangYaBin
 * @date 2021/6/4
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {

        final ArrayList<Object> objects = new ArrayList<>();

        int[] a = {1, 231, 123, 23, 21, 432, 12313};
        Arrays.sort( a,3, 5);
        for (int i : a) {
            System.out.println(i);
        }

    }

}
