/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package testes;

import lib.Console;

/**
 *
 * @author efapp0122
 */
public class TesteInputOutput {
    public static void main(String[] args) {
        
        int[] num = {0,0,0,0,0,0,0,0,0,0};
        int aux;
        
        for (int i = 0; i < 10; i++) {
            num[i] = Console.readInt("Introduza uma frase");
        }
        
        for (int i = 0; i < 10; i++) {
            for (int j = i + 1; j < 10; j++) {

                if (num[i] > num[j]) {
                aux = num[i];
                num[i] = num[j];
                num[j] = aux;
                }
            }
        }
        
        for (int i = 0; i < 10; i++) {
            System.out.println(num[i]);
        } 
    }
}
