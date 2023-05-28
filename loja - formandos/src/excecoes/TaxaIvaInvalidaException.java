/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package excecoes;

/**
 *
 * @author efapp0122
 */
public class TaxaIvaInvalidaException extends Exception{

    /**
     * Creates a new instance of <code>TaxaIvaInvalidaException</code> without
     * detail message.
     */
    public TaxaIvaInvalidaException() {
    }

    /**
     * Constructs an instance of <code>TaxaIvaInvalidaException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public TaxaIvaInvalidaException(String msg) {
        super(msg);
    }
}
