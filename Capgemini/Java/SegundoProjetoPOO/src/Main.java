import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa(70.0f, 1.70f);
        System.out.println("IMC = " + p1.calcularIMC());

        Scanner leitor = new Scanner(System.in);
        System.out.println("Digite o peso: ");
        p1.setPeso(leitor.nextFloat());
        System.out.println("Digite a altura: ");
        p1.setAltura(leitor.nextFloat());
        
        System.out.println("IMC = " + p1.calcularIMC());
        
    }
    
}
