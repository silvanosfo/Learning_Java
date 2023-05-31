
package business;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

/**
 *
 * @author ruiboticas
 * @version 1.0.0
 * 
 */
public class Turma {
    
    private static int contadorTurmas = 0;
    
    public static final int MAX_FORMANDOS = 0;
    
    private String identificacao;
    private Date dataInicio;
    private ArrayList<Formando> formandos = new ArrayList<>();

    public Turma(String identificacao) {
        this.identificacao = identificacao;
    }

    /**
     * 
     * @return 
     */
    public ArrayList<Formando> getFormandos() {
        return formandos;
    }
    
    /**
     * 
     * @param f 
     */
    public void adicionaFormando(Formando f){
        if(formandos.size() < MAX_FORMANDOS){
            formandos.add(f);
        }
    }
    
    public void removeFormando(Formando f){
        formandos.remove(f);
    }
    
    /**
     *
     * @param pos
     */
    public void removeFormando(int pos){
        if(pos > 0 && pos < formandos.size()){
            formandos.remove(pos);
        }
    }

    /**
     *
     * @return
     */
    public String getIdentificacao() {
        return identificacao;
    }

    /**
     *
     * @param identificacao
     */
    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    /**
     *
     * @return
     */
    public Date getDataInicio() {
        return dataInicio;
    }

    /**
     *
     * @param dataInicio
     */
    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.identificacao);
        hash = 17 * hash + Objects.hashCode(this.dataInicio);
        hash = 17 * hash + Objects.hashCode(this.formandos);
        return hash;
    }

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
        final Turma other = (Turma) obj;
        if (!Objects.equals(this.identificacao, other.identificacao)) {
            return false;
        }
        if (!Objects.equals(this.dataInicio, other.dataInicio)) {
            return false;
        }
        return Objects.equals(this.formandos, other.formandos);
    }

    @Override
    public String toString() {
        return "Turma{" + "identificacao=" + identificacao + ", dataInicio=" + dataInicio + ", formandos=" + formandos + '}';
    }
}