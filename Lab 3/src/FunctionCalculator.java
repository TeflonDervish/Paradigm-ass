import java.util.function.Function;

public class FunctionCalculator implements Function<Double, Double> {

    private final Function<Double, Double> function;

    public FunctionCalculator(Function<Double, Double> function) {
        this.function = function;
    }

    @Override
    public Double apply(Double x) {
        return function.apply(x);
    }

    // Добавим несколько функций
    public static FunctionCalculator f1() {
        return new FunctionCalculator(Math::cos);
    }

    public static FunctionCalculator f2() {
        return new FunctionCalculator(x -> Math.pow(x, 2));
    }

    public static FunctionCalculator f3() {
        return new FunctionCalculator(Math::sqrt);
    }

    public static FunctionCalculator f4() {
        return new FunctionCalculator(x -> Math.exp(x));
    }

    public static FunctionCalculator f5() {
        return new FunctionCalculator(x -> Math.sin(x));
    }

    public void calculateAndPrint(String functionName, double start, double end, double step) {
        System.out.println("Вычисление значения функции " + functionName + " на интервале [" + start + ", " + end + "] с шагом " + step + ":");

        for (double x = start; x <= end; x += step) {
            double result = apply(x);
            System.out.println("f(" + x + ") = " + result);
        }
    }
}
