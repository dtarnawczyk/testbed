import java.io.File;
import java.util.Arrays;

public class BookJava8Chapter3 {

    public static void main(String [] args) {

        File file = new File("src/main/java");
        System.out.println(file.getAbsolutePath());
        String [] filenames = file.list((File fiterDir, String fileName) -> {
            return fiterDir.getName().equals("java") && fileName.endsWith("java");
        });
        File [] dirs = file.listFiles((File fileDir, String filter) -> {
            return fileDir.isDirectory();
        });

        Arrays.sort(dirs);

        Arrays.stream(filenames).forEach(System.out::println);

    }


}
