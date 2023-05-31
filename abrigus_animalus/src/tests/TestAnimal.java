/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tests;

import business.Animal;
import java.util.ArrayList;

/**
 *
 * @author efapp0122
 */
public class TestAnimal {
    public static void main(String[] args) {
        ArrayList<Animal> animais = new ArrayList<>();
        
        Animal a1 = new Animal("Tobias", "Pincha", "Cão", "7 anos");
        animais.add(a1);
        
        Animal a2 = new Animal("Bobi", "Rafeiro", "Cão", "11 anos");
        animais.add(a2);
        
        System.out.println(animais.toString());
    }
}
