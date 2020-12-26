public class Main {

    public static void main(String[] args) {
        String safe = searchAndReplaceDiamonds("Номер кредитной карты <4008> <1234> <5678> 8912", "***");
        System.out.println(safe);
    }

    public static String searchAndReplaceDiamonds(String text, String placeholder) {

        if (text.contains("<") & text.contains(">")) {

            String secretText = text.substring(text.indexOf("<"), text.indexOf(">")+1);

            String result = text.replace(secretText, placeholder);
            String checkSearchAgain = searchAndReplaceDiamonds(result, placeholder);
            if (checkSearchAgain.equals(result)) {
                return result;
            }
            else {
                return checkSearchAgain;
            }
        }

        return text;
    }
}