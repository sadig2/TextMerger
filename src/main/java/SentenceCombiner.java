import sun.nio.cs.UTF_32;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

public class SentenceCombiner {

    private File file1;
    private File file2;
    private String readFile1;
    private String readFile2;


    private String merged;


    public SentenceCombiner(File file1,File file2){
        this.file1 = file1;
        this.file2 = file2;
   }


  public void readFiles()throws IOException{
        try(FileInputStream fileInputStream1 = new FileInputStream(file1);
            FileInputStream fileInputStream2 = new FileInputStream(file2)
        ){
            BufferedReader bufferedReader1 = new BufferedReader(new InputStreamReader(fileInputStream1, StandardCharsets.UTF_8));
            BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(fileInputStream2,StandardCharsets.UTF_8));

            StringBuilder stringBuilder1 = new StringBuilder();
            StringBuilder stringBuilder2 = new StringBuilder();


            String temp1 = bufferedReader1.readLine();
            while (temp1!=null){
                stringBuilder1.append(temp1);
                temp1=bufferedReader1.readLine();
            }
            String temp2 = bufferedReader2.readLine();
            while (temp2!=null){
                stringBuilder2.append(temp2);
                temp2=bufferedReader2.readLine();
            }

            readFile1 = stringBuilder1.toString();


            readFile2 = stringBuilder2.toString();

        }
   }


public  void createArrays(){
        String[]  kniga1 = readFile1.split("(?<=\\w{6}\\.\\s)|(?<=\\w{6}\\?\\s)");
        String[] kniga2 = readFile2.split( "(?<=\\w{6}\\.\\s)|(?<=\\w{6}\\?\\s)");
    System.out.println(kniga1.length);
    System.out.println(kniga2.length);

        StringBuilder resultBook = new StringBuilder();

        int min = kniga1.length>kniga2.length ? kniga2.length : kniga1.length;
        for (int i =0; i<min;i++ ){
            resultBook.append(kniga1[i]);
            resultBook.append(kniga2[i]);
        }
        merged = resultBook.toString();

}

public void outputFile()throws  IOException{
        try(
        FileOutputStream fileOutputStream = new FileOutputStream("output.txt");
        PrintWriter printWriter = new PrintWriter(fileOutputStream);

        ){
            printWriter.write(merged);


        }
}
    }




