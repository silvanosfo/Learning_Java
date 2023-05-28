
package b_business;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author silvano
 */
public class Loja {
    private String designacao;
    private final ArrayList<Encomenda> encomendas;

    /**
     * Construtor
     * @param designacao nova designacao
     */
    public Loja(String designacao) {
        this.designacao = designacao;
        this.encomendas = new ArrayList<>();
    }

    /**
     * Metodo de acesso a membro que devolve a designacao da Loja
     * @return designacao da Loja
     */
    public String getDesignacao() {
        return designacao;
    }

    /**
     * Metodo que altera o valor do membro designacao
     * @param designacao nova designacao
     */
    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    /**
     * Metodo de acesso a membro que devolve lista de encomendas
     * @return encomendas
     */
    public ArrayList<Encomenda> getEncomendas() {
        return encomendas;
    }

    /**
     * Metodo que adiciona encomendas
     * @param e encomenda a adicionar
     */
    public void adicionaEncomenda(Encomenda e){
        encomendas.add(e);
    }
    
    /**
     * Metodo que remove encomendas
     * @param i index de encomenda a remover
     */
    public void removeEncomenda(int i){
        encomendas.remove(i);
    }

    /**
     * Metodo que devolve caracteristicas da loja
     * @return caracteristicas
     */
    @Override
    public String toString() {
        return "\nLoja designacao: "+ designacao + 
               "\nEncomendas: " + encomendas;
    }

    /**
     * Metodo que retorna um numero inteiro gerado por algoritmo hash
     * @return hash numero
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.designacao);
        hash = 97 * hash + Objects.hashCode(this.encomendas);
        return hash;
    }

    /**
     * Metodo que compara igualidade entre instancias
     * @param obj instancia a comparar
     * @return true or false
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Loja other = (Loja) obj;
        if (!Objects.equals(this.designacao, other.designacao)) {
            return false;
        }
        return Objects.equals(this.encomendas, other.encomendas);
    }
}
