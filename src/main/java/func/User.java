package func;

import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

import static func.User.UserValidator.eMailContainsAtSign;
import static func.User.UserValidator.nameIsNotEmpty;
import static func.User.ValidationResult.invalid;
import static func.User.ValidationResult.valid;

public class User {
    public final String name;
    public final int age;
    public final String email;

    public User(String name, int age, String email){
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public static void main(String []  args) {

        UserValidator validation = nameIsNotEmpty().and(eMailContainsAtSign());

        User tom = new User("", 30, "cool@email.com");

        ValidationResult result = validation.apply(tom);
        result.getReason().ifPresent(System.out::println);

//        List<User> users = findAllUsers()
//                .stream().parallel()
//                .filter(nameIsNotEmpty().and(emailValid())::apply) // to Predicate
//                .collect(Collectors.toList());


    }

    interface UserValidator extends Function<User, ValidationResult> {

        static UserValidator nameIsNotEmpty() {
            return holds(user -> !user.name.trim().isEmpty(), "Name is empty.");
        }

        static UserValidator eMailContainsAtSign() {
            return holds(user -> user.email.contains("@"), "Missing @-sign.");
        }

        static UserValidator holds(Predicate<User> p, String message){
            return user -> p.test(user) ? valid() : invalid(message);
        }

        default UserValidator and(UserValidator other) {
            return user -> {
                final ValidationResult result = this.apply(user);
                return result.isValid() ? other.apply(user) : result;
            };
        }
    }

    interface ValidationResult {

        static ValidationResult valid(){
            return ValidationSupport.valid();
        }

        static ValidationResult invalid(String reason){
            return new Invalid(reason);
        }

        boolean isValid();

        Optional<String> getReason();

    }

    private final static class Invalid implements ValidationResult {

        private final String reason;

        Invalid(String reason){
            this.reason = reason;
        }

        public boolean isValid(){
            return false;
        }

        public Optional<String> getReason(){
            return Optional.of(reason);
        }

        // equals and hashCode on field reason
    }

    private static final class ValidationSupport {
        private static final ValidationResult valid = new ValidationResult(){
            public boolean isValid(){ return true; }
            public Optional<String> getReason(){ return Optional.empty(); }
        };

        static ValidationResult valid(){
            return valid;
        }
    }
}
