public class Kata {

    public static void main(String [] args) {
        System.out.println(declareWinner(new Fighter("Lew", 10, 2),
                new Fighter("Harry", 5, 4), "Lew")); // Lew
        System.out.println(declareWinner(new Fighter("Lew", 10, 2),
                new Fighter("Harry", 5, 4), "Harry")); //Harry
        System.out.println(declareWinner(new Fighter("Harald", 20, 5),
                new Fighter("Harry", 5, 4), "Harry")); // Harald
        System.out.println(declareWinner(new Fighter("Harald", 20, 5),
                new Fighter("Harry", 5, 4), "Harald")); //Herald
        System.out.println(declareWinner(new Fighter("Jerry", 30, 3),
                new Fighter("Harald", 20, 5), "Jerry")); // Herald
        System.out.println(declareWinner(new Fighter("Jerry", 30, 3),
                new Fighter("Harald", 20, 5), "Harald")); // Herald

    }

    public static String declareWinner(Fighter fighter1, Fighter fighter2, String firstAttacker) {
        String firstsName = firstAttacker;
        Fighter first;
        Fighter second;
        if(firstsName.equals(fighter1.name)) {
            first = fighter1;
            second = fighter2;
        } else {
            first = fighter2;
            second = fighter1;
        }
        int damage = 0;
        while(first.health > 0 || second.health >0) {
            damage = first.damagePerAttack;
            second.health -= damage;
            Fighter temp = second;
            second = first;
            first = temp;
        }

        return first.health <= 0 ? first.name : second.name;
    }
}
