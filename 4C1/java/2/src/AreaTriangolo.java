import java.util.Scanner;

public class AreaTriangolo {
    static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Base: ");
        int base = input.nextInt();

        System.out.print("Altezza: ");
        int altezza = input.nextInt();

        System.out.println("Area: " + base*altezza/2);

        input.close();
    }
}
