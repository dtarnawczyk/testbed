import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

import static junit.framework.TestCase.assertEquals;

public class DirectionReduction {

    public static String[] dirReduc(String[] arr) {

       /* Stack<String> northSouthStack = new Stack<>();
        Stack<String> eastWestStack = new Stack<>();

        for(String direction : arr) {

            if (direction.equals("EAST") || direction.equals("WEST")) {
                if(eastWestStack.isEmpty()){
                    eastWestStack.push(direction);
                } else {
                    String fromStack = eastWestStack.peek();
                    if((fromStack.equals("EAST") && direction.equals("WEST")) ||
                            (fromStack.equals("WEST") && direction.equals("EAST"))){
                        eastWestStack.pop();
                    }
                }
            } else if (direction.equals("NORTH") || direction.equals("SOUTH")) {

                if(northSouthStack.isEmpty()){
                    northSouthStack.push(direction);
                } else {
                    String fromStack = northSouthStack.peek();
                    if((fromStack.equals("NORTH") && direction.equals("SOUTH")) ||
                            (fromStack.equals("SOUTH") && direction.equals("NORTH"))){
                        northSouthStack.pop();
                    }
                }
            } else {
            }
        }
        int northSouthSize = northSouthStack.size();
        int eastWestSize = eastWestStack.size();*/
////////

        LinkedList<String> directions = new LinkedList<>();

        for(String direction : arr) {
            if(directions.isEmpty()) {
                directions.push(direction);
            } else {
                switch(direction) {
                    case "EAST": {
                        if(directions.getFirst().equals("WEST"))
                            directions.removeFirst();
                        else
                            directions.push("EAST");
                        break;
                    }
                    case "WEST": {
                        if(directions.getFirst().equals("EAST"))
                            directions.removeFirst();
                        else
                            directions.push("WEST");
                        break;
                    }
                    case "NORTH": {
                        if(directions.getFirst().equals("SOUTH"))
                            directions.removeFirst();
                        else
                            directions.push("NORTH");
                        break;
                    }
                    default: {
                        if(directions.getFirst().equals("NORTH"))
                            directions.removeFirst();
                        else
                            directions.push("SOUTH");
                        break;
                    }
                }
            }
        }
        Collections.reverse(directions);
        return directions.toArray(new String[directions.size()]);
    }

    @Test
    public void testSimpleDirReduc() throws Exception {
        assertEquals("\"NORTH\", \"SOUTH\", \"SOUTH\", \"EAST\", \"WEST\", \"NORTH\", \"WEST\"",
                Arrays.toString(new String[]{"WEST"}),
                Arrays.toString(DirectionReduction.dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"})));
        assertEquals("\"NORTH\", \"WEST\", \"SOUTH\", \"EAST\"",
             Arrays.toString(new String[]{"NORTH", "WEST", "SOUTH", "EAST"}),
             Arrays.toString(DirectionReduction.dirReduc(new String[]{"NORTH", "WEST", "SOUTH", "EAST"})));
        assertEquals("\"EAST\", \"EAST\", \"WEST\", \"NORTH\", \"WEST\", \"EAST\", \"EAST\", \"SOUTH\", \"NORTH\", \"WEST\"",
                Arrays.toString(new String[]{"EAST", "NORTH"}),
                Arrays.toString(DirectionReduction.dirReduc(new String[]{"EAST", "EAST", "WEST", "NORTH", "WEST", "EAST", "EAST", "SOUTH", "NORTH", "WEST"})));

    }
}
