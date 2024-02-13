public class BalancedBrackets {
    public static void main(String[] args) {
        String input = "(){][]}[";
        boolean isBalanced = isBalancedBrackets(input);

        if (isBalanced) {
            System.out.println("Brackets are balanced.");
        } else {
            System.out.println("Brackets are not balanced.");
        }
    }

    public static boolean isBalancedBrackets(String input) {
        int openSquareBrackets = 0;
        int openCurlyBraces = 0;
        int openParentheses = 0;

        for (int i = 0; i < input.length(); i++) {
            char bracket = input.charAt(i);

            if (bracket == '[') {
                openSquareBrackets++;
            } else if (bracket == '{') {
                openCurlyBraces++;
            } else if (bracket == '(') {
                openParentheses++;
            } else if (bracket == ']') {
                openSquareBrackets--;
            } else if (bracket == '}') {
                openCurlyBraces--;
            } else if (bracket == ')') {
                openParentheses--;
            }

            if (openSquareBrackets < 0 || openCurlyBraces < 0 || openParentheses < 0) {
                return false;
            }
        }

        return openSquareBrackets == 0 && openCurlyBraces == 0 && openParentheses == 0;
    }
}
