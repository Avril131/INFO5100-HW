import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.Duration;

public class homeworkSix {
    public static void main(String[] args) {

        
        System.out.println("Enter any word:");

        LocalDateTime startTime = LocalDateTime.now();
        
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        
        LocalDateTime endTime = LocalDateTime.now();
        Duration duration = Duration.between(startTime, endTime);
        double reactionTime = duration.toMillis() / 1000.0; // in seconds

        // calculate the length of the word
        int wordLength = word.length();
        
        // classify the word by length
        String wordType;
        if (wordLength <= 5) {
            wordType = "short";
        } else if (wordLength <= 10) {
            wordType = "medium";
        } else {
            wordType = "long";
        }
        
        // Output
        System.out.println("Your word is " + word);
        System.out.println("It is a " + wordType + " word");
        System.out.println("The length of the word is " + wordLength);
        System.out.println("Your reaction time is " + reactionTime + " seconds");
    }
}