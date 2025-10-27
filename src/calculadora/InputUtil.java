package calculadora;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputUtil {
    private Scanner scanner;

    public InputUtil(Scanner scanner) {
        this.scanner = scanner;
    }

    public int lerOpcao(String prompt) {
        System.out.print(prompt);
        while (true) {
            try {
                int opcao = scanner.nextInt();
                scanner.nextLine(); 
                return opcao;
            } catch (InputMismatchException e) {
                System.err.println("Erro: Por favor, digite um número inteiro.");
                scanner.nextLine();
                System.out.print(prompt);
            }
        }
    }

    public double lerNumero(String prompt) {
        System.out.print(prompt);
        while (true) {
            try {
                double num = scanner.nextDouble();
                scanner.nextLine(); 
                return num;
            } catch (InputMismatchException e) {
                System.err.println("Erro: Por favor, digite um número válido (ex: 10 ou 10,5).");
                scanner.nextLine(); 
                System.out.print(prompt);
            }
        }
    }
    
    public void fechar() {
        scanner.close();
    }
}