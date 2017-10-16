package functionalProgramming.flowControl;

import com.sun.org.apache.regexp.internal.RE;
import functionalProgramming.functionalInterface.Function;

import java.util.regex.Pattern;

public class EmailValidator {

    static Pattern emailPattern = Pattern.compile("^[a-z0=9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$");

    static Function<String, Result<String>> emailChecker = s -> {
        if(s == null){
            return Result.failure("nie może być NULL!");
        } else if(s.isEmpty()){
            return Result.failure("nie może być pusty");
        }else if(emailPattern.matcher(s).matches()){
            return Result.success(s);
        } else {
            return Result.failure("niepoprawny");
        }
    };

    static Effect<String> success = s -> System.out.println("Sukces!");
    static Effect<String> failure  = s -> System.out.println("Błąd!");

    public static void main(String[] args) {
        emailChecker.apply("jakisadres@dupa.com").bind(success, failure);
        emailChecker.apply(null).bind(success, failure);
        emailChecker.apply("").bind(success, failure);
        emailChecker.apply("dupa#@sdfsdf.fdsg").bind(success, failure);
    }
}
