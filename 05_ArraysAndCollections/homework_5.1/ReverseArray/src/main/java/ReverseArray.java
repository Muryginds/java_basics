public class ReverseArray {

    public static String[] reverse (String[] strings) {
        for (int i = 0; i <= strings.length/2; i++) {
            int reverseElementNumber = strings.length - 1 - i;
            String temp = strings[i];
            strings[i] = strings[reverseElementNumber];
            strings[reverseElementNumber] = temp;
        }
        return strings;
    }
}