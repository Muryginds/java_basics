public class TwoDimensionalArray {
    public static final char SYMBOL_X = 'X';
    public static final char SYMBOL_SPACE = ' ';

    public static char[][] getTwoDimensionalArray(int size) {

        char[][] array = new char[size][size];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i == j) {
                    array[i][i] = SYMBOL_X;
                }
                else if (array.length - i - 1 == j){
                    array[i][j] = SYMBOL_X;
                }
                else {
                    array[i][j] = SYMBOL_SPACE;
                }
            }
            System.out.println(array[i]);
        }
        return array;
    }
}