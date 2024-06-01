import java.io.File;
import java.io.FileNotFoundException;
// import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
public class Word_count {
    public static void main(String[] args) {
        String path = "text.txt";
        StringBuilder text = new StringBuilder();

        try(Scanner scanner = new Scanner(new File(path))){
            while(scanner.hasNextLine()){
                text.append(scanner.nextLine()).append(" ");
            }
        }
        catch (FileNotFoundException e){
            System.out.println("File not found");
            return;

        }
        String[] words = text.toString().toLowerCase().split("\\W+");

        Map<String, Integer> wc = new TreeMap<>();
        for(String word : words){
            if(!word.isEmpty()){
                wc.put(word, wc.getOrDefault(word,0)+1);
            }
        }
        wc.forEach((key,value) -> System.out.println(key + ": " + value));
    }

    
}
