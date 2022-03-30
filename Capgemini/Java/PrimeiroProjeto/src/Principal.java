import java.util.Scanner;

public class Principal {

    /** tudo dentro desse pode virar comentário de documentação
     */
    public static void main(String[] args) {
        System.out.println("Ola mundo");
        Scanner leitor = new Scanner(System.in);
       float numero = leitor.nextFloat();
       if(numero > 100 && numero < 200){
           System.out.println("O numero "+numero+" está dentro do intervalo");
       } else{
           System.out.println("O numero "+numero+" está fora do intervalo");
       }
        
    }
    
}
