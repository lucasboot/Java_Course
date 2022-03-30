
import java.util.Date;


public class Vendedor extends Funcionario {

    private int totalItensVendidos;
    private float comissaoPorItem;

    
    public Vendedor(){
        super();
    }
    public float calcularSalario(){
        return (super.getSalario() + this.totalItensVendidos*this.comissaoPorItem);
    }
}
