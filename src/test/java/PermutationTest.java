import com.lucifiere.algorithm.Permutation;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class PermutationTest {

    @Test
    public void testPermutation() {
        List<Integer> list = Tester.nums(3, 10);
        System.out.println("input -----> " + list);
        List<List<Integer>> allList = Permutation.permute(list);
        allList.forEach(System.out::println);
    }

    @Test
    public void testObjSize() {
        List<Obj> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            Obj obj = new Obj(RandomUtils.nextInt(1, 1000), RandomUtils.nextLong(1, 1000L), RandomStringUtils.random(3), RandomStringUtils.random(5), RandomStringUtils.random(3));
            list.add(obj);
        }
        System.out.println("S");
    }

}
