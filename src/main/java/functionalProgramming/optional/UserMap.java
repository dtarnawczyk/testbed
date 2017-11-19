package functionalProgramming.optional;

import lombok.AllArgsConstructor;
import lombok.Value;

public class UserMap {

    public static void main(String[] args) {
        Map<String, Toon> toons = new Map<String, Toon>()
                .put("Mickey", new Toon("Myszka", "Miki", "mickey@disney.com"))
                .put("Mickey", new Toon("Myszka", "Mini"))
                .put("Mickey", new Toon("Kaczor", "Donal", "donald@disney.com"));

        Option<Toon> mickey = toons.get("Miki");
        Option<Toon> mini = toons.get("Mimo");
        Option<Toon> goofy = toons.get("Goofy");

        System.out.println(mickey.getOrThrow());
        System.out.println(mini.getOrThrow());
        System.out.println(goofy.getOrThrow());
    }

    @Value
    static class Toon {
        private String firstName;
        private String lastName;
        private Option<String> email;

        Toon(String firstName, String lastName){
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = Option.none();
        }

        Toon(String firstName, String lastName, String emailAddress){
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = Option.some(emailAddress);
        }
    }
}
