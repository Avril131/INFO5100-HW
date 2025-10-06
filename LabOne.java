import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LabOne {

    public static int[] getMax(int[] array1, int[] array2) {
        int[] max = array1.length > array2.length ? array1 : array2;
        for (int i = 0; i < max.length; i++) {
            if (array1[i] > array2[i]) {
                max[i] = array1[i];
            } else {
                max[i] = array2[i];
            }
        }
        return max;
    }

    public static void printArray(int[] array, String prefix) {
        System.out.print(prefix+ " = { ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            if (i < array.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(" }");
    }

    public static void printStringList(List<String> list, String prefix) {
        System.out.print(prefix + " = { ");
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if (i < list.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.println(" }");
    }

    private static String switchFirstAndLast(String name) {
        if (name == null || name.isEmpty()) {
            return name;
        }
        if (name.length() == 1) {
            return name.toUpperCase();
        }
        String first = name.substring(0, 1);
        String last = name.substring(name.length() - 1);
        String middle = name.substring(1, name.length() - 1);

        String newName = last.toUpperCase() + middle.toLowerCase() + first.toLowerCase();
        return newName;
    }
    
    public static void main(String[] args) {

        // part1
        System.out.println("---------Part 1---------");
        int[] x = {2, 6, 3, 7, 5};
        printArray(x, "Array x");

        int[] y = {2, 7, 8, 1, 3};
        printArray(y, "Array y");

        int[] z = getMax(x, y);
        printArray(z, "Array z = x + y");

        System.out.println();

        // part2
        System.out.println("---------Part 2---------");
        List<String> names = new ArrayList<>(Arrays.asList("Anne", "John", "Jessica", "Alex"));
        printStringList(names, "Names");

        List<String> switched = new ArrayList<>();
        for (String name : names) {
            switched.add(switchFirstAndLast(name));
        }
        printStringList(switched, "Names (switched)");
    }
}
