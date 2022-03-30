
/**
 *
 * @author varel
 */
public class Pessoa {
    //Atributos
    private float peso;
    private float altura;
    //Método(s) contrutor(es)
    public Pessoa(float peso, float altura){
        this.peso = peso;
        this.altura = altura;
        
    }
    //Metodos
    public float calcularIMC(){
        float imc = peso/(altura*altura);
        return imc;
    }
    public void setPeso(float peso){
        this.peso = peso;
    }
    public void setAltura(float altura){
        this.altura = altura;
    }
}
