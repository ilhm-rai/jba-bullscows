import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        int number = scanner.nextInt();
        int hundreds = number / 100;
        int tens = ((number / 10) % 10) * 10;
        int unit = (number % 10) * 100;
        System.out.println(unit + tens + hundreds);
    }
}
