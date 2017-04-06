import java.util.*;

public class EightiesKids6 {

    public static void main(String [] args) {
        Robot robot1 = new Robot("Rocky", 200, 20, new String[] { "punch", "punch", "laser", "missile" });
        Robot robot2 = new Robot("Missile Bob", 100, 21, new String[] { "missile", "missile", "missile", "missile" });
        Map<String, Integer> tactics = new HashMap<>(3, 1f);
        tactics.put("punch", 20);
        tactics.put("laser", 30);
        tactics.put("missile", 35);
        System.out.println(fight(robot1, robot2, tactics));
    }

    public static String fight(Robot robot1, Robot robot2, Map<String, Integer> tactics) {

        Robot firstRobot = robot1;
        Robot secondRobot = robot2;
        if(robot2.getSpeed() > robot1.getSpeed()){
            firstRobot = robot2;
            secondRobot = robot1;
        }

        Map<String, Integer> robotsHealth = new HashMap<>(2);
        robotsHealth.put(robot1.getName(), robot1.getHealth());
        robotsHealth.put(robot2.getName(), robot2.getHealth());

        int maxMoves = robot1.getTactics().length+robot2.getTactics().length;

        String winnerName = "";
        for(int i=0; i < maxMoves; i++) {
            List<String> tacticsList = Arrays.asList(firstRobot.getTactics());
            if(tacticsList.size() > 0) {
                String hitName = "";
                String []  firstRobotTactics = firstRobot.getTactics();
                for(int j=0; j < firstRobotTactics.length;j++){
                    if(!firstRobotTactics[j].isEmpty()){
                        hitName = firstRobotTactics[j];
                        firstRobotTactics[j] = "";
                        break;
                    }
                }
                if (!hitName.isEmpty()) {
                    int secondHealth = robotsHealth.get(secondRobot.getName());
                    int newHealth = secondHealth - tactics.get(hitName);
                    robotsHealth.replace(secondRobot.getName(), newHealth);
                    if (newHealth <= 0) {
                        winnerName = firstRobot.getName();
                        break;
                    }
                }
            }
            Robot tmpRobot = firstRobot;
            firstRobot = secondRobot;
            secondRobot = tmpRobot;
        }

        return !winnerName.isEmpty() ? winnerName+" has won the fight.":"The fight was a draw.";
    }

    private static class Robot {

        private String name;
        private int health;
        private int speed;
        private String [] tactics;

        public Robot(String name, int health, int speed, String [] tactics) {
            this.name = name;
            this.health = health;
            this.speed = speed;
            this.tactics = tactics;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getHealth() {
            return health;
        }

        public void setHealth(int health) {
            this.health = health;
        }

        public int getSpeed() {
            return speed;
        }

        public void setSpeed(int speed) {
            this.speed = speed;
        }

        public String[] getTactics() {
            return tactics;
        }

        public void setTactics(String[] tactics) {
            this.tactics = tactics;
        }
    }


}
