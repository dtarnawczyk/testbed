
import java.util.Comparator;
public class JavaComparator {

}

class Checker implements Comparator<Player> {

	@Override
	public int compare(Player playerOne, Player playerTwo) {
		if(playerOne.getScore() > playerTwo.getScore()){
			return 1;
		} else if(playerOne.getScore() < playerTwo.getScore()) {
			return -1;
		} else {
			return playerOne.getName().compareTo(playerTwo.getName());
		}
	}
	
}

class Player {
	private int score;
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private String name;
	
}