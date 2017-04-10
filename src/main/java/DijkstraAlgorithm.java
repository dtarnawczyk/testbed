import java.util.PriorityQueue;
import java.util.Queue;

public class DijkstraAlgorithm {

    public static void main(String[] args) {
        Queue<Neighbour> queue = new PriorityQueue<>();


        queue.add(new Neighbour("Warszawa", 300));
        queue.add(new Neighbour("Lódź", 200));
        queue.add(new Neighbour("Wrocław", 150));
        queue.add(new Neighbour("Katowice", 700));

        int route = 0;
        while (!queue.isEmpty()) {
            Neighbour n = queue.poll();
            System.out.println(n.getDistance());
            route += n.getDistance();
        }
        System.out.println(route);
        //System.out.println(queue.remove());

        // TODO: create graph...

    }

    private static class Neighbour implements Comparable<Neighbour>{

        private String name = "";
        private int distance =0;

        public Neighbour(String name, int distance){
            this.name = name;
            this.distance = distance;
        }

        public int getDistance(){
            return this.distance;
        }

        public void updateDistance(int distance){
            this.distance = distance;
        }

        @Override
        public int compareTo(Neighbour o) {
            if(this.getDistance() > o.getDistance()){
                return 1;
            } else if(this.getDistance() < o.getDistance()) {
                return -1;
            }
            return 0;
        }

        @Override
        public String toString() {
            return this.name;
        }
    }

}
