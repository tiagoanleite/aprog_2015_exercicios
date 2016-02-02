package pl7_3;

import java.util.Formatter;
import java.util.Scanner;

/**
 * Exercício 3 da PL7
 * @author Tiago Leite (1150780)
 * @since 01/11/2015
 */
public class PL7_3 {

    static Formatter out = new Formatter(System.out);
    static Scanner in = new Scanner(System.in);
    static final int NUM = 100;
    
    /**
     * Lê uma sequência de nomes terminada com a palavra FIM para um vector e retorna o número lido
     * @param vec Vector para guardar os nomes
     * @return i número de nomes inseridos
     */
    private static int lerNomes(String[] vec, int n) { //rEceber a quantidade que já tem
        int c = 0;
        String nome;
        in.nextLine(); in.nextLine(); // Limpar o buffer
        
        // Verifica se o vector ainda tem espaço
        if(n < vec.length){
            System.out.println("Insira um nome: ");
            nome = in.nextLine();
            while(!nome.equals("FIM") && (n < vec.length)){
                if(nome.isEmpty()){ // Verifica se o utilizador não carregou só o enter
                    System.out.println("Não inseriu nenhum nome. ");
                }else{
                    vec[n] = nome;
                    n++; // Acrescenta o nome lido ao contador do vector
                    c++; // Acrescenta uma leitura ao contador do método
                }
                System.out.println("Insira um nome: ");
                nome = in.nextLine();
            }  
        }
        
        return c;
    }
    
    /**
     * Apresenta os primeiros n elementos de vec
     * @param vec Vector a listar
     * @param n Número de elementos no vector
     */
    private static void listar(String[] vec, int n) {
        for(int i=0; i < n; i++) {
            System.out.println(vec[i]);
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
        int n = 0; // Número de nomes guardados
        String nomes[] = new String[NUM];
        String m = "1 - Ler Nomes\n2 - Listagem\n3 - Eliminar nome\n4 - Terminar\n\nEscolha uma Opção:";
        
        char op;
        do {
            System.out.println(m);
            op=in.nextLine().charAt(0); 
            
            switch (op) {
                case '1':
                    n += lerNomes(nomes, n);
                    break;
                case '2':
                    if(n != 0){
                        System.out.println("Lista de nomes:\n");
                        listar(nomes, n);
                    } else {
                        System.out.println("Não foram inseridos nomes.");
                    }
                    break;
                case '3':
                    System.out.println("Nome: ");
                    String nome = in.nextLine();
                    // Verifica se o utilizador inseriu um nome
                    if(nome == null || nome.isEmpty()){
                        System.out.println("Não foi inserido um nome.");
                    }else{
                      int temp = enigma(nomes, nome, n);
                      if(temp == n){
                          // Se o número de posições retornado for igual ao inicial
                          System.out.println("O nome não foi encontrado.");
                      }else{
                          // Se o número de posições retornado for diferente ao inicial
                          System.out.println("Eliminado com sucesso!");
                          n = temp;
                      }
                      
                    }
                    
                    break;
                case '4':
                    break;
                default:
                    System.out.println("Opção Inválida.");
            } 
            
        } while(op!='4');
    }
    
}