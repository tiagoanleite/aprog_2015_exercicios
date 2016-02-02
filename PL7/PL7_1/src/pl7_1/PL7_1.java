package pl7_1;

import java.util.Scanner;

/**
 * Exercício 1 da PL7
 * @author Tiago Leite (1150780)
 * @since 26/10/2015
 */
public class PL7_1 {
    
    /**
     * Procurar o valor mínimo existente no vector
     * @param vector Vector a procurar
     * @return Valor mínimo
     */
    public static int valorMinimo(int[] vector){
        int minimo = vector[0];
        
        for(int i = 1; i < vector.length; i++){
            if (vector[i] < minimo){
                minimo = vector[i];
            }
        }
        
        return minimo;
    }
    
    /**
     * Escreve as posições do vector com um certo valor
     * @param vector Vector a procurar
     * @param valor Valor a escrever
     */
    public static void escreverPosicoes(int[] vector, int valor){
        for(int i = 0; i < vector.length; i++){
            if (vector[i] == valor){
                System.out.println(i);
            }
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        
        int i, s=0, c=0;
        
        // Cria um vector de 10 inteiros
        int[] v = new int[10];
        
        // Popula o array com inteiros
        System.out.println("Insira 10 números inteiros");
        for(i = 0; i < v.length; i++){
            v[i]=ler.nextInt();
        }  
        
        // Para cada posição do vector
        for(i = 0; i < v.length; i++){
            // Faz a soma dos pares e conta o nº de pares
            if (v[i] % 2 == 0){
                s = s + v[i];
                c++;
            }
        }
        
        // Se existirem pares faz a média
        if(c!=0){
            System.out.println("Média dos valores pares: " + ((double)s)/c); 
        }
        else{
            System.out.println("Operação impossível de realizar");
        }
        
        // Escreve as posições com o valor mínimo
        System.out.println("O valor mínimo inserido é " + valorMinimo(v));
        
        // Escreve as posições
        System.out.println("O valor mínimo pode ser encontrado nas seguintes posições:");
        escreverPosicoes(v, valorMinimo(v));
        
    }
    
}
