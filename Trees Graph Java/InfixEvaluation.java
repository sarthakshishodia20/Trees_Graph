import java.util.Stack;

public class InfixEvaluation {
    public static void main(String[] args) {
        String str = "8-5+3*4/6";
        Stack<Integer> val = new Stack<>();
        Stack<Character> op = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isDigit(ch)) {
                val.push(ch - '0');
            } else {
                while (!op.isEmpty() && precedence(op.peek()) >= precedence(ch)) {
                    applyOperation(val, op);
                }
                op.push(ch);
            }
        }
        while (!op.isEmpty()) {
            applyOperation(val, op);
        }
        System.out.println(val.peek());
    }

    private static int precedence(char op) {
        if (op == '+' || op == '-') {
            return 1;
        } else if (op == '*' || op == '/') {
            return 2;
        }
        return 0;
    }

    private static void applyOperation(Stack<Integer> val, Stack<Character> op) {
        char operator = op.pop();
        int v2 = val.pop();
        int v1 = val.pop();
        switch (operator) {
            case '+':
                val.push(v1 + v2);
                break;
            case '-':
                val.push(v1 - v2);
                break;
            case '*':
                val.push(v1 * v2);
                break;
            case '/':
                val.push(v1 / v2);
                break;
        }
    }
}
