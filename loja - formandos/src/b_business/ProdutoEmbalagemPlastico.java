
package b_business;

import excecoes.TaxaIvaInvalidaException;
import excecoes.ValorInvalidoException;

/**
 *
 * @author silvano
 */
public class ProdutoEmbalagemPlastico extends Produto {
    
    private float taxaSuplementarSemIva = 0.0f;

    public ProdutoEmbalagemPlastico(String designacao) {
        super(designacao);
    }

    public ProdutoEmbalagemPlastico(String designacao, float preco, int taxaIva, float taxaSuplementar) throws TaxaIvaInvalidaException, ValorInvalidoException {
        super(designacao, preco, taxaIva);
        this.taxaSuplementarSemIva=taxaSuplementar;
    }

    public float getTaxaSuplementarSemIva() {
        return taxaSuplementarSemIva;
    }

    public void setTaxaSuplementarSemIva(float taxaSuplementarSemIva) {
        this.taxaSuplementarSemIva = taxaSuplementarSemIva;
    }

    @Override
    public float getPrecoSemIva() {
        return super.getPrecoSemIva() + taxaSuplementarSemIva;
    }
    

    @Override
    public String toString(){
        return "\n\tProduto Embalagem Plastico:" + super.toString() +
                "\n\tTaxa suplementar embalagem: " + getTaxaSuplementarSemIva();        
    }    
}
