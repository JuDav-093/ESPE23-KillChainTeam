
package ec.edu.espe.evsustore.view;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author Andres Espin, KillChain, DCOO-ESPE
 */
public class InputHandler {
    private Scanner scanner;

    public InputHandler() {
        this.scanner = new Scanner(System.in);
    }

    public int nextInt() {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un número entero.");
                scanner.nextLine(); 
            }
        }
    }

    public double nextDouble() {
        while (true) {
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un número decimal.");
                scanner.nextLine(); 
            }
        }
    }

    public String next() {
        return scanner.next();
    }

    public String nextLine() {
        return scanner.nextLine();
    }
}
