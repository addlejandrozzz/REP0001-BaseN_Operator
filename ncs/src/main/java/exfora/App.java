package exfora;

import java.util.Scanner;

import exfora.model.util.Base;
import exfora.model.util.NumberGuardian;

public class App {
    public static void main(String[] args) {

        // Variables
        Scanner sc = new Scanner(System.in);
        Base bases[] = Base.values();
        String option = """
                What do you want to do?
                1 - Convert a number
                0 - Exit
                """;
        String baseStr = """
                \n1 - """ + bases[0] + """
                \n2 - """ + bases[1] + """
                \n3 - """ + bases[2] + """
                \n4 - """ + bases[3] + """
                \n0 - Exit
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
                System.out.println("Converted number: " + NumberGuardian.passNumber(bases[in], bases[out], number));
                System.out.println("####################");
            }
        } while (entry != 0);
        sc.close();
    }
}
