
package Questao11;

/**
 *
 * @author varel
 */
public class Ingresso {
    private float valor;
    
    public Ingresso (float valor){
        this.valor = valor;
    }
    public void imprimirValor(){
        System.out.println(this.valor);
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    
}
