import java.util.Scanner;

public class Calc {
    static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Primo numero: ");
        float n1 = input.nextFloat();

        char op;
        while (true) {
            System.out.println("+ - * / (q Exit, c Clear)");
            op = input.next().charAt(0);
            if (op == 'c'){
                System.out.print("Primo numero: ");
                n1 = input.nextFloat();
                System.out.println("+ - * / (q Exit)");
                op = input.next().charAt(0);
            }
            if (op == 'q') break;
            System.out.print("Secondo numero: ");
            float n2 = input.nextFloat();

            if (op == '+') n1 += n2;
            else if (op == '-') n1 -= n2;
            else if (op == '*') n1 *= n2;
            else if (op == '/') n1 /= n2;

            System.out.println("R: " + n1);
        }
        input.close();
    }
}
