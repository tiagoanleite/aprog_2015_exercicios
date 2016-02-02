package pl7_3;

import java.util.Formatter;
import java.util.Scanner;

/**
 * 
 * @author leite
 */
public class PL7_3 {

    static Formatter out = new Formatter(System.out);
    static Scanner in = new Scanner(System.in);
    
    /**
     * Lê uma sequência de nomes terminada com a palavra FIM para um vector e retorna o número lido
     * @param vec Vector para guardar os nomes
     * @return i número de nomes inseridos
     */
    private static int lerNomes(String[] vec) {
        int c = 0;
        String nome;
        in.nextLine(); in.nextLine(); // Limpar o buffer
        System.out.println("Insira um nome:");
        nome = in.nextLine();
        while(!nome.equals("FIM")){
            vec[c] = nome;
            c++;
            System.out.println("Insira mais um nome:");
            nome = in.nextLine();
        }
        return c;
    }
    
    /**
     * Apresenta os primeiros n elementos de vec
     * @param vec Vector a listar
     */
    private static void listar(String[] vec, int n) {
        System.out.println("Lista de nomes:\n");
        for(int i=0; i < n; i++) {
            System.out.println("- " + vec[i]);
        }
    }
    
    /**
     * Elimina a primeira posição caso encontre o nome passado por parâmetro
     * @param nomes vector de nomes
     * @param nome nome para comparar
     * @param n numero de elementos do vector
     * @return
     */
    private static int enigma(String[] nomes, String nome, int n) {
        int i=0;
        
        //Incrementa i enquanto o nome inserido não constar no vector e o i for menor q o nrElementos
        while((i < n) && (!nomes[i].equalsIgnoreCase(nome))) {
            i++;
        }
        
        // Retorna o número de posições
        if(i == n) {
            return n;
        } else {
            // Elimina o espaço em branco no meio do vector
            for (int j=i; j< n-1; j++) {
                nomes[j]=nomes[j+1];
            }
            // Retorna o novo número de posições
            return --n;
        }
        
    }
    
    public static void main(String[] args) {
        int n=0;
        String nomes[] = new String[100];
        String m="1 - Ler Nomes\n2 - Listagem\n3 - Eliminar nome\n4 - Terminar\n\nEscolha uma Opção:";
        
        char op;
        do {
            System.out.println(m);
            op=in.nextLine().charAt(0); 
            
            switch (op) {
                case '1':
                    n = lerNomes(nomes);
                    break;
                case '2':
                    if(n!=0) {
                        listar(nomes,n);
                    } else {
                        System.out.println("Não foram inseridos nomes.");
                    }
                    break;
                case '3':
                    System.out.println("Nome: ");
                    String nome = in.nextLine();
                    n=enigma(nomes,nome,n);
                    break;
                case '4':
                    break;
                default:
                    System.out.println("Opção Inválida.");
            } 
            
        } while(op!='4');
    }
    
}
