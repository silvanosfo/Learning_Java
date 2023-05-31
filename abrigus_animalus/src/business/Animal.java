/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package business;

/**
 *
 * @author efapp0122
 */
public class Animal {
    private String nome = "";
    private static int contador = 0;
    private String raca = "";
    private String especie = "";
    private String idade = "";
    private int id;
    
    public Animal (String nomeInicial, String racaInicial, String especieInicial, String idadeInicial) {
        nome = nomeInicial;
        raca = racaInicial;
        especie = especieInicial;
        idade = idadeInicial;
        incrementaId();
        id = contador;
    }

    public String getNome() {
        return nome;
    }

    public int getId(Animal obj) {
        return id;
    }
    
    private void incrementaId() {
        contador++;
    }

    public String getRaca() {
        return raca;
    }

    public String getEspecie() {
        return especie;
    }

    public String getIdade() {
        return idade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        String str = 
        "\n\tNome: " + nome + 
        "\n\tId: " + id + 
        "\n\tRaça: " + raca +
        "\n\tEspecie: " + especie +
        "\n\tIdade: " + idade + "\n";
        return str;
    }
}
