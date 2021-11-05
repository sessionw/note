import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.jooq.lambda.tuple.Tuple2;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author wangYaBin
 * @date 2021/6/4
 */
public class Main {

    private static final double KILO_VALUE = 1000 * 100;

    /**
     * - 消费大于8888，以w为单位保留一位小数展示
     * - 例：1.8w
     */
    private static final double MYRIAD_VALUE = 10000 * 100;

    public static void main(String[] args) {
       System.out.println(DateFormatUtils.format(new Date(0),"yyyy-MM-dd"));
    }




}
