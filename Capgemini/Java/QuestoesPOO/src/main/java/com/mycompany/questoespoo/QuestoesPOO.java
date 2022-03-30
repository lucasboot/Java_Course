
package com.mycompany.questoespoo;

public class QuestoesPOO {

    public static void main(String[] args) {
        ContaCorrente c1 = new ContaCorrente("1234", "Alberto");
        c1.deposito(1000.0f);
        c1.saque(250.0f);
        System.out.println(c1.getSaldo());
    }
}
