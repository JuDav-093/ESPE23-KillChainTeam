
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



    public double nextDouble() {
        while (true) {
            try {
                double num = scanner.nextDouble();
                if(num < 0) {
                    throw new IllegalArgumentException();
                }
                return num;
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un número decimal.");
                scanner.nextLine(); 
            } catch (IllegalArgumentException e) {
                System.out.println("No se aceptan números negativos. Por favor, ingrese un número positivo.");
            }
        }
    }

    public int nextInt(){
        while (true) {
            try {
                int num = scanner.nextInt();
                if(num < 0) {
                    throw new IllegalArgumentException();
                }
                return num;
            } catch (InputMismatchException e) {
                System.out.println("Por favor, ingrese un número entero.");
                scanner.nextLine(); 
            } catch (IllegalArgumentException e) {
                System.out.println("No se aceptan números negativos. Por favor, ingrese un número positivo.");
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
