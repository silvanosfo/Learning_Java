
package business;

/**
 *
 * @author ruiboticas
 */
public class FormandoJD extends Formando {
    private int notaTrabalho;

    public int getNotaTrabalho() {
        return notaTrabalho;
    }

    public void setNotaTrabalho(int notaTrabalho) {
        this.notaTrabalho = notaTrabalho;
    }
    

    
    
    public boolean verificarAprovacao(){
        return super.verificarAprovacao() && getNotaTrabalho() > 9.99;
    }


    

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.notaTrabalho;
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
        final FormandoJD other = (FormandoJD) obj;
        return this.notaTrabalho == other.notaTrabalho;
    }

    @Override
    public String toString() {
        return "FormandoJD{" + "notaTrabalho=" + notaTrabalho + '}';
    }

}
