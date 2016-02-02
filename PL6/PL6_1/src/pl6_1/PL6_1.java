/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl6_1;

import java.util.Scanner;

/**
 * Exercício 1 da PL6 (validado)
 * @summary Lê uma sequência de palavras até encontrar uma palíndromo e conta o número de palavras lidas que antecedem o palíndromo
 * @author Tiago Leite (115780)
 * @since 19/10/2015
 */
public class PL6_1 {
    static Scanner input = new Scanner(System.in);
    
    public static boolean metodo1(String pal){
        boolean resposta = true;
        pal = pal.toLowerCase();
        int tamanho = pal.length();
        for(int i=0; i<tamanho/2; i++){
            if(pal.charAt(i) != pal.charAt(tamanho-1-i)){
                resposta = false;
                break;
            }
        }
        return resposta;
    }
    
    public static boolean metodo2(String pal){
        int i, j;
        pal = pal.toLowerCase();
        i = 0;
        j = pal.length()-1;
        while(i<j && pal.charAt(i) == pal.charAt(j)){
            i++;
            j--;
        }
        return i>=j;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int contador = 0;
        System.out.println("Insira uma palavra");
        String palavra = input.nextLine();
        
        if(metodo2(palavra)){
            System.out.println("Não foram inseridas palavras antes do palíndromo.");
        }else{
            do{
                contador++;
                System.out.println("Insira uma palavra");
                palavra = input.nextLine();
            }while(!metodo2(palavra));
            System.out.println("Foram inseridas " + contador + " palavras antes do palíndromo.");
        }
    }
    
}
