package util;
import java.util.InputMismatchException;
import java.util.Scanner;

public class InterfaceUsuario {
    Scanner scanner = new Scanner(System.in);

    public double pedirValorimovel() {
        while (true) {
            System.out.println("Digite o valor do imovel:");
            try {
                double valor = scanner.nextDouble();
                if (valor > 0) return valor;
                System.out.println("ERRO: O valor deve ser positivo.");
            } catch (InputMismatchException e) {
                System.out.println("ERRO: Digite um número válido.");
                scanner.next();
            }
        }
    }

    public int pedirPrazoFinanciamento() {
        while (true) {
            System.out.println("Prazo em anos (2 a 80): ");
            try {
                int prazo = scanner.nextInt();
                if (prazo >= 2 && prazo <= 80) return prazo;
                System.out.println("ERRO: Prazo deve ser entre 2 e 80 anos.");
            } catch (InputMismatchException e) {
                System.out.println("ERRO: Digite um número inteiro.");
                scanner.next();
            }
        }
    }

    public double pedirTaxaJuros() {
        while (true) {
            System.out.println("Taxa de Juros Anual (%): ");
            try {
                double taxa = scanner.nextDouble();
                if (taxa > 0 && taxa <= 100) return taxa;
                System.out.println("ERRO: Taxa inválida.");
            } catch (InputMismatchException e) {
                System.out.println("ERRO: Digite um número válido.");
                scanner.next();
            }
        }
    }

    public double pedirAreaContruida() {
        System.out.println("Área Construída (m²):");
        return scanner.nextDouble();
    }
    
    public double pedirAreaTerreno() {
        System.out.println("Área Terreno (m²):");
        return scanner.nextDouble();
    }
}