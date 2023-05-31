
package business;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author ruiboticas
 * @version 1.0
 */
public class Escola {
    
    public final int MAX_TURMAS;
    
    private String nome;
    private String localizacao;
    private String telefone;
    private ArrayList<Turma> turmas = new ArrayList<>();

    public Escola(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
        this.MAX_TURMAS = 4;
    }

    public Escola(String nome, String telefone, final int MAX_TURMAS) {
        this.nome = nome;
        this.telefone = telefone;
        this.MAX_TURMAS = MAX_TURMAS;
    }
    
    /**
     * 
     * @return
     */
    public String getNome() {
        return nome;
    }

    /**
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     *
     * @return
     */
    public String getLocalizacao() {
        return localizacao;
    }

    /**
     *
     * @param localizacao
     */
    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    /**
     *
     * @return
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     *
     * @param telefone
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    /**
     *
     * @return
     */
    public ArrayList<Turma> getTurmas() {
        return turmas;
    }

    /**
     *
     * @param t
     */
    public void adicionarTurma(Turma t){
        turmas.add(t);
    }
    
    /**
     *
     * @param t
     */
    public void removerTurma(Turma t){
        turmas.remove(t);
    }
    
    /**
     *
     * @param i
     */
    public void removerTurma(int i){
        turmas.remove(i);
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.nome);
        hash = 43 * hash + Objects.hashCode(this.localizacao);
        hash = 43 * hash + Objects.hashCode(this.telefone);
        hash = 43 * hash + Objects.hashCode(this.turmas);
        return hash;
    }

    /**
     *
     * @param obj
     * @return
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
        final Escola other = (Escola) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.localizacao, other.localizacao)) {
            return false;
        }
        if (!Objects.equals(this.telefone, other.telefone)) {
            return false;
        }
        return Objects.equals(this.turmas, other.turmas);
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Escola{" + "nome=" + nome + ", localizacao=" + localizacao + ", telefone=" + telefone + ", turmas=" + turmas + '}';
    }
    
    
}
