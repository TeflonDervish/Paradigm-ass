
public class TextManipulation {


    public String countAndReplaceCrisis(String text) {
        int count = text.split("кризис", -1).length - 1;

        text = text.replaceAll("(?i)кризис", "проблема");
        System.out.println("\nКоличество слов кризис: " + count);
        return text;
    }

    public String removeComputerWords(String text) {
        return text.replaceAll("компьютер", "");
    }
}
