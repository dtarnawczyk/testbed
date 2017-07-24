package patterns.behavioral.iterator;

public class IteratorDemo {

    public static void main(String[] args) {
        NameRepo namesRepository = new NameRepo();

        for(Iterator<Number> iter = namesRepository.getIterator(); iter.hasNext();){
            String name = (String)iter.next();
            System.out.println("Name : " + name);
        }
    }
}
