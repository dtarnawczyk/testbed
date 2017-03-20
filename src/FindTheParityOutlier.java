public class FindTheParityOutlier {
    public static void main(String [] args) {

        int [] tablicaParzystychLubNieparzystych = {160, 3, 1719, 19, 11, 13, -21};

        System.out.printf("%d", getParityOutlier(tablicaParzystychLubNieparzystych));

    }

    public static int getParityOutlier(int [] tablica) {
        int oddCounter = 0;
        int evenCounter = 0;
        for(int i=0; i < 3; i++) {
            int div = tablica[i] % 2;
            if(div != 0) {
                oddCounter += 1;
            } else {
                evenCounter += 1;
            }
        }
        int outlier = -1;
        if(oddCounter > evenCounter) {
            outlier = getOutlierInOdds(tablica);
        } else {
            outlier = getOutlierInEvens(tablica);
        }
        return outlier;
    }

    public static int getOutlierInOdds(int [] tablica) {
        for(int i=0; i < tablica.length; i++) {
            int div = tablica[i] % 2;
            if(div == 0) {
                return tablica[i];
            }
        }
        return -1;
    }

    public static int getOutlierInEvens(int [] tablica) {
        for(int i=0; i < tablica.length; i++) {
            int div = tablica[i] % 2;
            if(div != 0) {
                return tablica[i];
            }
        }
        return -1;
    }
}
