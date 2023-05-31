
package presentation.console;

import business.Escola;
import java.util.ArrayList;
import lib.Console;

/**
 *
 * @author ruiboticas
 * @version 1.0.0
 */
public class StartupAppConsoleMode {
    
    public static void pause(){
        Console.readString("\n\n !! PRESSIONE Enter PARA CONTINUAR !! \n\n");
    }
    
    
    public static void main(String[] args) {
        
        Escola escola = new Escola("","");

        // --- Preenchimento dos dados da escola -------------------------------
        escola.setNome(Console.readString("Introduza o nome da escola: "));
        escola.setLocalizacao(Console.readString("Introduza a morada da escola: "));
        escola.setTelefone(Console.readString("Introduza o numero de telefone"));
        
               
        
        int opcao = 0;

        // --- INTERATIVO ------------------------------------------------------
        do{
            // --- MENU --------------------------------------------------------
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            System.out.println("1. Ver dados escola");
            System.out.println("------ TURMAS --------------------------- ");
            System.out.println("2. Criar Turma");
            System.out.println("3. Remover Turma");
            System.out.println("4. Consultar Detalhes de Turma");
            System.out.println("------ FORMANDOS ------------------------ ");
            System.out.println("5. Adicionar Formando");
            System.out.println("6. Remover Formando");
            System.out.println("0. Sair");
            System.out.println("----------------------------------------- ");
            
            
            opcao = Console.readInt("[ESCOLHA OPCAO]# ");
            switch(opcao){
                case 1:
                        System.out.println("=== Escola: " + escola.getNome());
                        System.out.println("=== Localizacao: " + escola.getNome());
                        System.out.println("=== Contacto: " + escola.getNome());
                        System.out.println("--- TURMAS -------------------------");
                        System.out.println(escola.getTurmas());
                        break;
                
                case 2:
                        break;
                
                case 0:
                        System.out.println("Volte sempre");
                        pause();
                        break;
                default:
                        System.out.println("Opcao Invalida!!!!!");
                        pause();
            }
        }while(opcao != 0);
    }
}
