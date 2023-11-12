public class Main {
    public static void main(String [] args){
        // Задание 1
        ComplexNumber n1 = new ComplexNumber(0, 3);
        ComplexNumber n2 = new ComplexNumber(8, 0);
        ComplexNumber n3 = new ComplexNumber(0, 0);
        ComplexNumber n4 = new ComplexNumber(8, 4);
        ComplexNumber n5 = new ComplexNumber(3, -3);

        System.out.println(n1);
        System.out.println(n2);
        System.out.println(n3);
        System.out.println(n4);
        System.out.println(n5);

        System.out.println(n1.add(n2));

        // Задание 2
        String text = "кризис, криз, компьютер";
        TextManipulation manipulation = new TextManipulation();

        text = manipulation.countAndReplaceCrisis(text);
        text = manipulation.removeComputerWords(text);

        System.out.println(text);

        // Задание 3
        String text3 = "qwerty*qwerty#qwertyy";
        text3 = StringManipulation.SortString(text3);
        System.out.println("\nОтсортированная строка: " + text3);

    }
}
