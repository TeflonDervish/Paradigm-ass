public class Task4 {

    public static void main(String[] args) {
        try {
            double result = calculateLogarithm(-2);
            System.out.println("Logarithm result: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Функция вычисления логарифма с обработкой ошибки для отрицательных чисел
    public static double calculateLogarithm(double number) {
        if (number <= 0) {
            throw new IllegalArgumentException("Logarithm is undefined for non-positive numbers.");
        }

        return Math.log(number);
    }
}