package pl7_5;

import java.util.Scanner;

/**
 * Exercício 5 da PL 7
 * @author Tiago Leite (1150780)
 * @since 26/10/2015
 */
public class PL7_5 {
    static Scanner in = new Scanner(System.in);
    
    /**
     * Lê uma sequência de nomes completos de pessoas terminada em "FIM"
     * @param v Vector a utilizar
     * @return Número de nomes lidos
     */
    public static int lerNomes(String[] v){
        // receber max
        int i = 0;
        String nome;
        
        System.out.println("Insira os nomes guardar:");
        nome = in.nextLine();
        // usar o length
        while(!nome.equalsIgnoreCase("fim") && i!=99){
           v[i] = nome;
           i++;
           nome = in.nextLine();
        }

        return i;
    }
    
    /**
     * Retorna o apelido de um determinado nome
     * @param n Nome completo
     * @return Apelido
     */
    public static String apelido(String n){
        String ap = n.substring(n.lastIndexOf(" ")+1);
        return ap;
    }
    
    /**
     * Mostrar no ecrã uma listagem do conteúdo de um vector de strings
     * @param v Vector a listar
     * @param n Número de elementos no vector
     * @param tit Título da lista
     */
    public static void mostrarListagem(String[] v, int n, String tit){
        System.out.println(tit);
        for(int i = 0; i < n; i++){
            System.out.println("- " + v[i]);
        }
    }
    
    /**
     * Preenche um vector com os nomes com apelidos começados por S de outro vector
     * @param v1 Vector a verificar
     * @param v2 Vector com o resultado
     * @param n Número de elementos do vector
     * @return Quantidade de nomes com apelidos começados por S
     */
    public static int preencherVetorApelidosS(String[] v1, String[] v2, int n){
        int resultado = 0;
        for(int i = 0; i < n; i++){
            if(apelido(v1[i]).charAt(0) == 's' || apelido(v1[i]).charAt(0) == 'S'){
                v2[resultado] = v1[i];
                resultado++;
            }
        }
        return resultado;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* No final a aplicação deve apresentar ao utilizador o seguinte:
         * Uma listagem de todos os nomes lidos;
         * Uma listagem apenas dos nomes com apelidos (último nome) começados por S;
         * A percentagem de nomes cujos apelidos começam por S. 
        */
        
        int numNomes= 0, numApelidos;
        String[] nomes = new String[100];
        String[] apelidos = new String[100];
        //trocar por const
        
        numNomes = lerNomes(nomes);
        // validar numero lido
        
        mostrarListagem(nomes, numNomes, "Lista de nomes inseridos");
        
        numApelidos = preencherVetorApelidosS(nomes, apelidos, numNomes);
        
        mostrarListagem(apelidos, numApelidos, "Lista de apelidos começados por S");
    }
    
}
