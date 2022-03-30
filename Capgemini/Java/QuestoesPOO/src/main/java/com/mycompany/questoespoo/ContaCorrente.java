
package com.mycompany.questoespoo;

public class ContaCorrente {
    private String numeroConta;
    private String nome;
    private float saldo;
    
    public ContaCorrente(){
        this.saldo = 0;
    }
    public ContaCorrente(String numeroConta, String nome){
        this.numeroConta = numeroConta;
        this.nome = nome;
    }
    
     public ContaCorrente(String numeroConta, String nome, float saldo){
        this.numeroConta = numeroConta;
        this.nome = nome;
        this.saldo = saldo;
    }
    public void alterarNome(String nome){
        this.nome = nome;
    }
    public void deposito(float valor){
        this.saldo+=valor;
    }
    public void saque(float valor){
        this.saldo-=valor;
    }

    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }
    
}
