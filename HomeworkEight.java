public class HomeworkEight {

    // get the inversed array of the input array
    public static String[] getInversed(String[] words) {
        String[] inversed = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            inversed[i] = getBackward(words[words.length - 1 - i]);
        }
        return inversed;
    }

    // get the backward string of the input string
    public static String getBackward(String str) {
        String backward = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            if (i == str.length() - 1) {
                backward += str.substring(i, i+1).toUpperCase();
            } else {
                backward += str.substring(i, i+1).toLowerCase();
            }
        }
        return backward;
    }


    public static void main(String[] args) {
        // output
        String[] words = {"Anne", "John", "Alex", "Jessica"};
        String[] inversed = getInversed(words);
        for (int i = 0; i < inversed.length; i++) {
            System.out.print(inversed[i] + " ");
        }

        System.out.println();

        String[] words2 = {"Sun", "Mercury", "Venus", "Earth", "Mars", "Jupiter"};
        String[] inversed2 = getInversed(words2);
        for (int i = 0; i < inversed2.length; i++) {
            System.out.print(inversed2[i] + " ");
        }

    }
}
