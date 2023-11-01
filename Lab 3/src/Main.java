import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Выберите значение функции: \n1) cos\n2) pow\n3) sqrt\n4) exp\n5) sin");
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        FunctionCalculator Calculator;

        if (n == 1) Calculator = FunctionCalculator.f1();
        else if (n == 2) Calculator = FunctionCalculator.f2();
        else if (n == 3) Calculator = FunctionCalculator.f3();
        else if (n == 4) Calculator = FunctionCalculator.f4();
        else if (n == 5) Calculator = FunctionCalculator.f5();
        else Calculator = FunctionCalculator.f1();

        Calculator.calculateAndPrint("f(x)", 0, 10, 1);
    }
}
