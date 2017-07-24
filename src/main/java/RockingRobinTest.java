import org.junit.Test;

import java.util.*;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;

class RockingRobin implements Iterator<Integer> {

    private int index = 0;
    private List<Integer> innerCollection = new ArrayList<>();

    public RockingRobin(Collection<Iterator<Integer>> collections) {
        int elementsLeftCounter = 1;
        while (elementsLeftCounter > 0) {
            elementsLeftCounter = 0;
            for(Iterator<Integer> iterators : collections){
                if(iterators.hasNext()) {
                    innerCollection.add(iterators.next());
                    if(iterators.hasNext()) elementsLeftCounter++;
                }
            }
        }
    }

    @Override
    public boolean hasNext() {
        return index < innerCollection.size();
    }

    @Override
    public Integer next() {
        if(index >= innerCollection.size())
            throw new NoSuchElementException();
        Integer n = innerCollection.get(index);
        index += 1;
        return n;
    }
}

public class RockingRobinTest {

    @Test
    public void testRoundRobinIteration() throws Exception {
        Collection<Integer> one = Collections.singleton(1);
        Collection<Integer> two = Arrays.asList(2, 3);
        Collection<Integer> three = Arrays.asList(4, 5, 6);
        RockingRobin robin = new RockingRobin(Arrays.asList(one.iterator(), two.iterator(), three.iterator()));

        List<Integer> progression = new ArrayList<>(Arrays.asList(1, 2, 4, 3, 5, 6));

        while (robin.hasNext()) {
            Integer i = robin.next();

            if (i != null && i.equals(progression.get(0))) {
                progression.remove(0);
            } else {
                fail("incorrect progression over the elements!");
            }
        }

        assertEquals("should have iterated over all elements:", 0, progression.size());

    }
}
