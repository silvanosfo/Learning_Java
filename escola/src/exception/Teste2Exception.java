
package exception;

/**
 *
 * @author ruiboticas
 */
public class Teste2Exception extends Exception {

    /**
     * Creates a new instance of <code>Teste2Exception</code> without detail
     * message.
     */
    public Teste2Exception() {
    }

    /**
     * Constructs an instance of <code>Teste2Exception</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public Teste2Exception(String msg) {
        super(msg);
    }
}
