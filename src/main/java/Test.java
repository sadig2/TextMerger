import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Test {


    public static void main(String[] args) {



        String ff = "dfgfd dfg?sd fd. d. .fsdfs";

        String[] a = ff.split("(?<=\\w{2}\\.)");

        for (String s : a){

            System.out.println(s);
        }


    }
}