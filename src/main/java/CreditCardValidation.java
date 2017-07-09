import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class CreditCardValidation {

    public static boolean validate(String input) {

        // 1. Od ostatniego znaku, podwajamy co drugą cyfrę
        // 2. Jeżeli jakaś z podwojonych cyfr jest wieksza niż 9 to odejmujemy od to zastepujemy ją sumą jej cyfr
        // 3. Sumujemy wszystkie cyfry

        int [] intsList = Arrays.stream(input.split("")).mapToInt(Integer::new).toArray();
        int sumOfAll = 0;
        int counter = 1;
        for(int i = intsList.length-1; i >= 0; i--){
            int n = intsList[i];
            if(counter % 2 == 0) {
                n *= 2;
                if(n > 9){
                    int sum = 0;
                    int tooBigNumber = n;
                    while (tooBigNumber > 0) {
                        sum += tooBigNumber % 10;
                        tooBigNumber = tooBigNumber / 10;
                    }
                    n = sum;
                }
            }
            counter+=1;
            sumOfAll += n;
        }

        // 4. Jesli mod 10 tej sumy da 0, wtedy to jest poprawna liczba, w przeciwnym razie nie.
        return sumOfAll % 10 == 0;
    }

    @Test
    public void test891(){
        assertEquals(false, CreditCardValidation.validate("891"));
    }
}
