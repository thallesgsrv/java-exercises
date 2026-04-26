import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String operacao = sc.nextLine();

        double numOne;
        double numTwo;
        double result;

        if (!operacao.equals("+") &&
            !operacao.equals("-") &&
            !operacao.equals("*") &&
            !operacao.equals("/")) {

            System.out.println("ENTRADA INVALIDA");
            return;
        }

        numOne = sc.nextDouble();
        numTwo = sc.nextDouble();

        switch (operacao) {
            case "+":
                result = numOne + numTwo;
                break;
            case "-":
                result = numOne - numTwo;
                break;
            case "*":
                result = numOne * numTwo;
                break;
            default:
                if (numTwo == 0) {
                    System.out.println("ERRO");
                    return;
                }
                result = numOne / numTwo;
        }

        System.out.println("RESULTADO: " + result);
    }
}
