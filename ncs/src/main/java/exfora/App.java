package exfora;

import java.util.Scanner;

import exfora.model.util.Base;
import exfora.model.util.NumberGuardian;
import exfora.model.util.Operation;

public class App {
    public static void main(String[] args) {

        // Variables
        Scanner sc = new Scanner(System.in);
        Base bases[] = Base.values();
        String option = """
                What do you want to do?
                1 - Convert a number
                2 - BaseN Operations
                0 - Exit
                """;
        String baseStr = """
                \n1 - """ + bases[0] + """
                \n2 - """ + bases[1] + """
                \n3 - """ + bases[2] + """
                \n4 - """ + bases[3] + """
                """;
        int entry = -1;
        do {
            System.out.println("\n" + option);
            entry = sc.nextInt();
            if (entry == 1) {
                System.out.println("####################");
                System.out.println(baseStr);
                System.out.println("Enter the init base: ");
                int in = sc.nextInt() - 1;
                System.out.println("Enter the final base: ");
                int out = sc.nextInt() - 1;
                System.out.println("Enter the number: ");
                sc.nextLine();
                String number = sc.nextLine();
                // Output
                System.out.println("Converted number: " + NumberGuardian.passConverse(bases[in], bases[out], number));
                System.out.println("####################");
            }
            if (entry == 2){
                System.out.println("####################");
                System.out.println(baseStr);
                System.out.println("Enter the base: ");
                int in = sc.nextInt() - 1;
                System.out.println("Enter the first number: ");
                sc.nextLine();
                String x = sc.nextLine();
                System.out.println("Enter the second number: ");
                String y = sc.nextLine();
                System.out.println("----------");
                System.out.println("1 - Plus");
                System.out.println("2 - Minus");
                System.out.println("3 - Multiply");
                System.out.println("4 - Divide");
                System.out.println("0 - Exit");
                int op = sc.nextInt();
                Operation operation = Operation.values()[op-1];
                switch (op) {
                    case 1 -> System.out.println("Result: " + NumberGuardian.passOperation(bases[in], x, y, operation));
                    case 2 -> System.out.println("Result: " + NumberGuardian.passOperation(bases[in], x, y, operation));
                    case 3 -> System.out.println("Result: " + NumberGuardian.passOperation(bases[in], x, y, operation));
                    case 4 -> System.out.println("Result: " + NumberGuardian.passOperation(bases[in], x, y, operation));
                    case 0 -> System.out.println("Exiting...");
                    default -> System.out.println("Invalid option");
                }
                System.out.println("####################");
            }
        } while (entry != 0);
        sc.close();
    }
}
