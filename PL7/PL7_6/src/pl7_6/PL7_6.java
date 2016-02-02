package pl7_6;

import java.util.Scanner;

/**
 * Exercício 6 da PL7
 * @author Tiago Leite (1150780)
 * @since 26/10/2015
 */
public class PL7_6 {
    static Scanner input = new Scanner(System.in);
    
    // Acrescenta o pesquisa
    
    /**
     * Insere um nome no vector na 1ª posição nula do vector encontrada
     * @param n Nome a inserir
     * @param v Vector a guardar
     * @return 0 se conseguir guardar, -1 se o vector estiver cheio ou o input for inválido
     */
    public static int inserirVisitante(String n, String[] v){
        if ((n != null) && !(n.isEmpty())){
            for(int i = 0; i < v.length; i++){
                if (v[i] == null){
                    v[i] = n;
                    return 0;
                }
            }
        }
        return -1;
    }
    
    /**
     * Lista todos os nomes no vector
     * @param v Vector a listar
     */
    public static void listarVisitantes(String[] v){
        System.out.println("Visitantes no sistema:");
        for(String nome : v){
            if (nome != null){
                System.out.println("- " + nome);
            }
        }
    }
    
    /**
     * Actualiza a primeira ocorrência de um nome no vector
     * @param antigo Nome a substituir
     * @param novo Nome a atribuir
     * @param v Vector a trabalhar
     * @return 0 em caso de sucesso, -1 caso não seja encontrado ou input inválido
     */
    public static int actualizarNome(String antigo, String novo, String[] v){
        if (((novo != null) && !(novo.isEmpty())) && ((antigo != null) && !(antigo.isEmpty()))){
            for(int i = 0; i < v.length; i++){
                if ((v[i] != null) && v[i].equals(antigo)){
                    v[i] = novo;
                    return 0;
                }

            }
        }
        return -1;
    }
    
    /**
     * Elimina um nome do vector
     * @param n Nome a eliminar
     * @param v Vector a trabalhar
     * @return 0 em caso de sucesso, -1 caso o input seja inválido ou o visitante não exista
     */
    public static int eliminarVisitante(String n, String[] v){
        if ((n != null) && !(n.isEmpty())){
            for(int i = 0; i < v.length; i++){
                if (v[i] != null){
                    if (v[i].equals(n)){
                        v[i] = null;
                        return 0;
                    }   
                }
            }
        }
        return -1;
    }
    
    /**
     * Mostra todos os nomes começados por uma letra
     * @param letra Letra a pesquisar
     * @param v Vector a trabalhar
     */
    public static void listarComecadosPor(char letra, String[] v){
        for (String valor : v) {
            if (valor != null){
                if (valor.charAt(0) == letra) {
                    System.out.println("- " + valor);
                }                
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
    
    
    /**
     * @param args thd linee comman arguments
     */
    public static void main(String[] args) {
        // Os visitantes são identificados pelo nome e o máximo é 100
        String[] visitantes = new String[100];
        int op = -1; String teclado1 = "", teclado2 = ""; char letra = ' ';
        
        while(op != 0){
            escreverMenu();
            op = input.nextInt();
            
            switch (op){
                case 1:
                    System.out.println("Insira o nome do visitante: ");
                    teclado1 = input.next();
                    if (inserirVisitante(teclado1, visitantes) != -1){
                        System.out.println("Inserido com sucesso!");
                        System.out.println("");
                    }else{
                        System.out.println("Erro ao inserir.");
                        System.out.println("");
                    }
                    break;
                    
                case 2:
                    listarVisitantes(visitantes);
                    break;
                    
                case 3:
                    System.out.println("Insira o nome a actualizar: ");
                    teclado1 = input.next();
                    System.out.println("Insira o novo nome: ");
                    teclado2 = input.next();
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
                    letra = input.next().trim().charAt(0);
                    listarComecadosPor(letra, visitantes);
                    break;
                    
                case 5:
                    listarNomesRepetidos(visitantes);
                    break;
                
                case 6:
                    System.out.println("Insira o visitante a remover: ");
                    teclado1 = input.next();
                    if (eliminarVisitante(teclado1, visitantes) != -1){
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
