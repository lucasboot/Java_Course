
package Questao11;

/**
 *
 * @author varel
 */
public class IngressoVIP extends Ingresso {
    private String codigoIngresso;
    private float adicional;
    
    public IngressoVIP(float valor, float adicional){
        super(valor);
        this.adicional = adicional;
    }
    public void imprimirValor(){
        System.out.println(this.getValor() + this.adicional);
    }
}
