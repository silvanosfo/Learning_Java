
package business;

import java.util.Objects;

/**
 *
 * @author ruiboticas
 * @version 1.0
 * 
 */
public class Formando {
    
    private static int contadorFormandos = 0;

    
    // === VARIAVEIS DE INSTANCIA =====================================
    private int numero;
    private String nome;
    private int idade;
    private String morada;
    private int nota;

    public Formando() {
        this.numero = 0;
        this.nome = "";
        this.idade = 0;
        this.morada = "";
    }
    
    public Formando(int numero, String nome, int idade, String morada) {
        this.numero = numero;
        this.nome = nome;
        this.idade = idade;
        this.morada = morada;
    }

    
    // === MÉTODOS DE INSTANCIA =======================================

    /**
     * <html> Metodo de acesso ao membro que <br>define o número do formando <code> </code> </html>
     * @return develve o numero do formando
     */

    public int getNumero() {
        return numero;
    }

    /**
     *
     * @param numero
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    /**
     *
     * @return
     */
    public String getNome() {
        return nome;
    }

    /**
     * Metodo que altera o valor do membro nome
     * @param nome novo nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     *
     * @return
     */
    public int getIdade() {
        return idade;
    }

    /**
     *
     * @param idade
     */
    public void setIdade(int idade) {
        this.idade = idade;
    }

    /**
     *
     * @return
     */
    public String getMorada() {
        return morada;
    }

    /**
     *
     * @param morada
     */
    public void setMorada(String morada) {
        this.morada = morada;
    }

    /**
     *
     * @return
     */
    public int getNota() {
        return nota;
    }

    /**
     *
     * @param nota
     */
    public void setNota(int nota) {
        if(nota >= 0 && nota < 20){
            this.nota = nota;
        }
    }
    
    public boolean verificarAprovacao(){
        return nota > 9.99;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + this.numero;
        hash = 97 * hash + Objects.hashCode(this.nome);
        hash = 97 * hash + this.idade;
        hash = 97 * hash + Objects.hashCode(this.morada);
        hash = 97 * hash + this.nota;
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
        final Formando other = (Formando) obj;
        if (this.numero != other.numero) {
            return false;
        }
        if (this.idade != other.idade) {
            return false;
        }
        if (this.nota != other.nota) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return Objects.equals(this.morada, other.morada);
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return "Formando{" + "numero=" + numero + ", nome=" + nome + ", idade=" + idade + ", morada=" + morada + ", nota=" + nota + '}';
    }
}
