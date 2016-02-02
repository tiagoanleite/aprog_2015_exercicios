package pl7_6_new;

import java.util.Scanner;

/**
 * Exercício 6 da PL7 (2ª resolução)
 * @author Tiago Leite (1150780)
 * @since 03/11/2015
 */
public class PL7_6_new {
    static Scanner input = new Scanner(System.in);
    static final int TAM = 100;
    
    /**
     * Procura um nome no vector
     * @param vector Vector a percorrer
     * @param nome Nome a procurar
     * @return Posição do elemento ou -1 caso não exista
     */
    public static int procurarNome(String[] vector, String nome, int ele){
        for(int i = 0; i < ele; i++){
            if(vector[i].equals(nome)){
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Retorna o número de ocorrências de um nome no vector
     * @param vector Vector a percorrer
     * @param nome Nome a procurar
     * @return Número de ocorrências
     */
    public static int ocorrenciasNome(String[] vector, String nome){
        int c = 0;
        for(int i = 0; i < vector.length; i++){
            if(vector[i].equals(nome)){
                c++;
            }
        }
        return c;
    }
    
    /**
     * Insere um nome no vector na 1ª posição nula do vector encontrada
     * @param n Nome a inserir
     * @param v Vector a guardar
     * @param lidos Numero de elementos no vector
     * @return 1 se conseguir guardar, -1 se o vector estiver cheio ou o input for inválido
     */
    public static int inserirVisitante(String n, String[] v, int lidos){
        // Se o vector ainda não estiver cheio e houver nome a inserir
        if((lidos < v.length) && (n != null) && !(n.isEmpty())){
            if(lidos != 0){
                lidos--;
            }
            v[lidos] = n;
            return 1;
        }
        return -1;
    }
    
    /**
     * Lista todos os nomes no vector
     * @param v Vector a listar
     * @param lidos Número de elementos no vector
     */
    public static void listarVector(String[] v, int lidos){
        for(int i = 0; i < lidos; i++){
            System.out.println(v[i]);
        }
    }
    
    /**
     * Actualiza a primeira ocorrência de um nome no vector
     * @param antigo Nome a substituir
     * @param novo Nome a atribuir
     * @param v Vector a trabalhar
     * @return 0 em caso de sucesso, -1 caso não seja encontrado ou input inválido
     */
    public static int actualizarNome(String antigo, String novo, String[] v, int ele){
        int pos = procurarNome(v, antigo, ele);
        if(pos > -1){
            v[pos] = novo;
            return 0;
        }
        return -1;
    }
    
    /**
     * Elimina um nome do vector
     * @param n Nome a eliminar
     * @param v Vector a trabalhar
     * @param ele Elementos no vector
     * @return 0 em caso de sucesso, -1 caso o input seja inválido ou o visitante não exista
     */
    public static int eliminarVisitante(String n, String[] v, int ele){
        int pos = procurarNome(v, n);
        if (pos > -1){
            for(int i = pos; i < ele; i++){
                if(i < v.length-1){
                    v[i] = v[i+1];
                }
            }
            return 0;
        }
        return -1;
    }
    
    /**
     * Mostra todos os nomes começados por uma letra
     * @param letra Letra a pesquisar
     * @param v Vector a trabalhar
     * @param ele Número de elementos no vector
     */
    public static void listarComecadosPor(char letra, String[] v, int ele){
        for(int i = 0; i < ele; i++){
            if (v[i].charAt(0) == letra) {
                System.out.println(v[i]);
            }                
        }
    }
    
    /**
     * Lista todos os nomes repetidos no vector
     * @param v Vector a trabalhar
     */
    public static void listarNomesRepetidos(String[] v){
        int c = 0;
        //for (String original : v){
        for (int i = 0; i < v.length; i++){
            if(v[i] != null){
                for (int x = i; x < v.length; x++){
                    if ((v[x] != null) && (v[i].equals(v[x]))){
                        c++;
                    }
                }
            }
            // A cena é que desta forma os nomes repetidos vão aparecer mais que uma vez...
            
            if (c > 1){
                System.out.println("- " + v[i]);
            }
            
            c = 0;
        }
    }
    
    public static void listarNomesRepetidos(String[] v, int ele){
        String[] repetidos = new String[ele/2];
        int numRepetidos = 0;
        int ocorrencias;
        for(int i = 0; i < ele; i++){
            ocorrencias = ocorrenciasNome(v, v[i]);
            if(ocorrencias > 1){
                if(procurarNome(repetidos, v[i], numRepetidos) == -1){
                    repetidos[numRepetidos] = v[i];
                    numRepetidos ++;
                }
            }
        }
        
        // verificar se há repetidos
        listarVector(repetidos, numRepetidos);
    }
    
    /**
     * Escreve o menu no ecrã
     */
    public static void escreverMenu(){
        System.out.println(".: MENU :.");
        System.out.println("1 - Inserir visitante");
        System.out.println("2 - Listar todos os visitantes");
        System.out.println("3 - Actualizar um dado nome");
        System.out.println("4 - Listar os nomes começados por uma dada letra");
        System.out.println("5 - Listar nomes repetidos");
        System.out.println("6 - Eliminar visitante");
        System.out.println("0 - Sair");
        System.out.println("");
        System.out.print("Opção: ");
    }
    

    public static void main(String[] args) {
        String[] visitantes = new String[TAM];
        int num = 0;
        int op = -1;
        
        while(op != 0){
            escreverMenu();
            op = input.nextInt();
            input.nextLine(); // Limpa o buffer
            
            switch (op){
                case 1:
                    System.out.println("Insira o nome do visitante: ");
                    String teclado = input.nextLine();
                    if (inserirVisitante(teclado, visitantes, num) != -1){
                        System.out.println("Inserido com sucesso!");
                        System.out.println("");
                    }else{
                        System.out.println("Erro ao inserir.");
                        System.out.println("");
                    }
                    break;
                    
                case 2:
                    listarVector(visitantes, num);
                    break;
                    
                case 3:
                    System.out.println("Insira o nome a actualizar: ");
                    String teclado1 = input.next();
                    System.out.println("Insira o novo nome: ");
                    String teclado2 = input.next();
                    if (actualizarNome(teclado1, teclado2, visitantes) != -1){
                        System.out.println("Actualizado com sucesso!");
                        System.out.println("");
                    }else{
                        System.out.println("Erro ao actualizar");
                        System.out.println("");
                    }
                    break;
                    
                case 4:
                    System.out.println("Insira a letra:");
                    char letra = input.next().trim().charAt(0);
                    System.out.println("Nomes começados por " + letra);
                    listarComecadosPor(letra, visitantes, num);
                    System.out.println("");
                    break;
                    
                case 5:
                    listarNomesRepetidos(visitantes, num);
                    break;
                
                case 6:
                    System.out.println("Insira o visitante a remover: ");
                    teclado = input.next();
                    if (eliminarVisitante(teclado, visitantes, num) != -1){
                        num--;
                        System.out.println("Removido com sucesso");
                        System.out.println("");
                    }else{
                        System.out.println("Erro ao remover");
                        System.out.println("");
                    }
                    break;
                    
                case 0:
                    System.out.println("");
                    System.out.println("Terminou o programa");
                    break;
                    
                default:
                    System.out.println("");
                    System.out.println("Inseriu uma opção inválida");
                    System.out.println("");
            }
        }
    }
    
}

