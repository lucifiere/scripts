import com.google.common.collect.Lists;
import org.apache.commons.lang3.RandomUtils;

import java.util.List;

public class Tester {

    static List<Integer> nums(int length) {
        return nums(length, Integer.MAX_VALUE);
    }

    static List<Integer> nums(int length, int max) {
        List<Integer> list = Lists.newArrayListWithCapacity(length);
        for (int i = 0; i < length; i++) {
            list.add(RandomUtils.nextInt(0, max));
        }
        return list;
    }

}
