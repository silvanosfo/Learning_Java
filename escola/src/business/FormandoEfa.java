
package business;

/**
 *
 * @author ruiboticas
 */
public class FormandoEfa extends Formando {

    private boolean presentePRA;

    public boolean isPresentePRA() {
        return presentePRA;
    }

    public void setPresentePRA(boolean presentePRA) {
        this.presentePRA = presentePRA;
    }

    @Override
    public boolean verificarAprovacao() {
        return super.verificarAprovacao() && isPresentePRA(); 
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + (this.presentePRA ? 1 : 0);
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
        final FormandoEfa other = (FormandoEfa) obj;
        return this.presentePRA == other.presentePRA;
    }

    @Override
    public String toString() {
        return "FormandoEfa{" + super.toString() + "presentePRA=" + presentePRA + '}';
    }
    
    
}
