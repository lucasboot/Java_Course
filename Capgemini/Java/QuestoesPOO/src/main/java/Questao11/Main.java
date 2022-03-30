/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Questao11;

/**
 *
 * @author varel
 */
public class Main {
     public static void main(String[] args) {
        IngressoVIP p1 = new IngressoVIP(100.0f, 150.0f);
         System.out.print("O valor do ingresso sem VIP é: "+p1.getValor() +"\nO valor do ingresso com VIP fica: ");
         p1.imprimirValor();
    }
}
