import java.util.Arrays;

public class AbsDistincs {

    public static void main(String[] args) {

        int  [] input = {-5, -3, -1, 0, 3, 6};
        System.out.println(solution(input));
    }

    public static int solution(int [] input) {
        return (int) Arrays.stream(input).map(i -> Math.abs(i)).boxed().distinct().count();
    }

}
