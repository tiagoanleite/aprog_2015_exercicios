package pl8_1;

import java.util.Scanner;
import java.util.Formatter;

/**
 * Exercício 1 da PL8
 * @author Tiago Leite (1150780)
 * @since 02/11/2015
 * 
 * @todo Perceber porque é que isto deixou de funcionar
 */
public class PL8_1 {
    
    static Scanner in = new Scanner(System.in);
    static Formatter out = new Formatter(System.out);
    
    /**
     * Lê o tamanho do vector
     * @return n Número de elementos
     */
    public static int lerTamanho() {
        int n = 0;
        while(n <= 0) {
            out.format("Insira o número de elementos a armazenar: ");
            n = in.nextInt();
        }
        return n;
    }
    
    /**
     * Popula um vector com números inteiros
     * @param vec Vector a popular
     * @return c Número de elementos lidos
     */
    public static int lerVector(int[] vec) {
        int c = 0;
        for(int i = 0; i < vec.length; i++) {
            out.format("Insira um número inteiro: ");
            vec[i] = in.nextInt();
            c++;
        }
        return c;
    }
    
    /**
     * Lê quanto maiores é para mostrar
     * @return Número de maiores a mostrar
     */
    public static int limiteMaiores() {
        int n = 0;
        while(n <= 0){
            out.format("Insira o número de maiores a mostrar: ");
            n = in.nextInt();
        }
        return n;
    }
    
    /**
     * Mostra os N primeiros elementos não repetidos do vector 
     * @param vec Vector a trabalhar
     * @param lim Elementos a mostrar
     */
    public static void mostrarPrimeiros(int[] vec, int lim) {
        if (lim > vec.length) {
            out.format("Impossível mostrar mais elementos que os existentes no vector.\n");
        }else{
            //int c = 0;
            for (int i = 0; (i < vec.length) /*&& (c < lim)*/; i++) {
                // if (i == 0) {
                    out.format("%d\n", vec[i]); // c++;
                //}else if (vec[i] != vec[i-1]) {
                //    out.format("%d\n", vec[i]); c++;
                //}
            }
        }
    }
    
    /**
     * Ordena o vector por ordem decrescente
     * @param vec Vector a ordenar
     */
    public static void ordenarVector(int[] vec) {
        int temp;
        for (int i = 0; i < vec.length-1; i++) {
            for (int j = i+1; j < vec.length; j++) {
                if (vec[i] < vec[j]) {
                    temp = vec[j];
                    vec[j] = vec[i];
                    vec[i] = temp;
                }
            }
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int tam = lerTamanho();
        int[] vec = new int[tam];
        lerVector(vec);
        ordenarVector(vec); 
        int lim = limiteMaiores();
        mostrarPrimeiros(vec, lim);
    }
    
}
