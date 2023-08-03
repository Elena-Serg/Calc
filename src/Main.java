import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(calc(input));
    }

    public static String calc(String input) throws Exception {
        String[] array = input.split(" ");

        if (!(array.length == 3)) {
            throw new Exception();
        }

        boolean isFirstRomanian = false;
        boolean isSecondRomanian = false;

        String[] romanianNumbers = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV",
                "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII",
                "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII",
                "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI",
                "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV",
                "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII",
                "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII",
                "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};

        for (int i = 0; i < 11; i++) {
            if (romanianNumbers[i].equals(array[0])) {
                array[0] = String.valueOf(i);
                isFirstRomanian = true;
            }
            if (romanianNumbers[i].equals(array[2])) {
                array[2] = String.valueOf(i);
                isSecondRomanian = true;
            }
        }
        if (isFirstRomanian ^ isSecondRomanian) {
            throw new Exception();
        }

        int a = Integer.parseInt(array[0]);
        int b = Integer.parseInt(array[2]);
        if ((a < 1 || b < 1) || (a > 10 || b > 10)) {
            throw new Exception();
        }
        int result;
        switch (array[1]) {
            case "+":
                result = a + b;
                break;
            case "-":
                result = a - b;
                break;
            case "*":
                result = a * b;
                break;
            case "/":
                result = a / b;
                break;
            default:
                throw new Exception();
        }
        if (isFirstRomanian && result <= 0) {
            throw new Exception();
        }

        if (isFirstRomanian) {
            return romanianNumbers[result];
        }

        return String.valueOf(result);
    }
}
