
public class StaticMethodChallenge {

    static class Stark {
        static void talk() {
            System.out.println("The winter is comming");
        }
    }

    static class Ned extends Stark {
        static void talk() {
            System.out.println("The only time man can be brave is when he is afraid");
        }
    }

    public static void main(String[] args) {
        Stark stark = new Ned();
        stark.talk();
    }
}
