import java.util.ArrayList;

public class HomeworkFive {
    public static void main(String[] args) {
        // System.out.println("Hello, World!");

        String str = "Oakland";
        // find the length of the string
        System.out.println(str.length());
        // find a character with index 2 in the string.
        System.out.println(str.charAt(2));
        // extract a substring “land” from str
        System.out.println(str.substring(3, 7));
        // convert all letters in str to capital letters “OAKLAND”.
        System.out.println(str.toUpperCase());

        int[] abc = {1, 3, 5, 2, 5};
        // find the length of the array
        System.out.println(abc.length);
        // find the last member of the array.
        System.out.println(abc[abc.length - 1]);

        // Create an ArrayList that consists of the following strings: 
        // “Austin”, “Houston”, “Oakland”, “Paris”, “San Francisco”, “Seattle”.
        ArrayList<String> cities = new ArrayList<String>();
        cities.add("Austin");
        cities.add("Houston");
        cities.add("Oakland");
        cities.add("Paris");
        cities.add("San Francisco");
        cities.add("Seattle");
        System.out.println("Original ArrayList: " + cities);
        // Remove “Paris’ from the ArrayList.
        cities.remove("Paris");
        System.out.println("ArrayList after removing Paris: " + cities);
    }
}