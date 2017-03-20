import java.util.ArrayList;
import java.util.List;

public class NodeCount {

    public static void main(String [] args){

        List<Integer> freeCPUs = new ArrayList<Integer>();
        freeCPUs.add(20);
//        freeCPUs.add(9);

        System.out.println(solution(freeCPUs, 20));
    }

    static int solution(List<Integer> freeCPUs, int maxCores){
        int nodeCounter = 0;
        int cpuSum = 0;
        boolean match = false;
        for(int cpu : freeCPUs){
            cpuSum += cpu;
            nodeCounter += 1;
            if (cpuSum >= maxCores) {
                match = true;
                break;
            }
        }
        return match ? nodeCounter : 0;
    }
}
