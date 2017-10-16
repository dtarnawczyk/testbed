import java.util.concurrent.ThreadLocalRandom;

public class SimpleTimeTestProgram {

    static int blackhole;

    public static void main(String[] args) {

        int[] nums = randomInts(5_000);

        for(int i=0; i < 100; ++i) {
            long start = System.nanoTime();

            blackhole = sum(nums);

            long end = System.nanoTime();

            System.out.printf(">>>>> %d\t%d%n", i, end - start);
        }
    }

    private static int sum(int[] nums) {
        int sum = 0;
        for(int i:nums){
            sum += i;
        }
        return sum;
    }

    private static int[] randomInts(int size) {
        ThreadLocalRandom random = ThreadLocalRandom.current();
        int [] nums = new int[size];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt();
        }
        return nums;
    }


}
