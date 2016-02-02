/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl6_4;

import java.util.Scanner;
import pl6_4.CalCombinatorio;

/**
 * Exercício 4 da PL6 (validado)
 * @summary Aplica os métodos da classe CalCombinatorio
 * @author Tiago Leite (115780)
 * @since 19/10/2015
 */

public class PL6_4 {
    static Scanner input = new Scanner(System.in);
    
    /**
    * Classe de testes CalCombinatorio 
    * @summary Apresenta todos os cálculos efectuados pelos modulos acrescentados à classe CalcCombinatório
    * @param n Número inteiro não negativo
    * @param p Número inteiro não negativo
    */
    public static void TesteCalCombinatorio(int n, int p){
        if((n > 0) && (p >= n)){
            System.out.println("Permutações = " + CalCombinatorio.permutacoes(n));

            if(CalCombinatorio.arranjos(n,p)!=-1) {
                System.out.println("Arranjos = " + CalCombinatorio.arranjos(n,p));
            }else{
                System.out.println("Impossível calcular arranjo");
            }

            if(CalCombinatorio.combinacoes(n,p)!=-1) {
               System.out.println("Combinações = " + CalCombinatorio.combinacoes(n,p));
            }else{
                System.out.println("Impossível calcular combinação");
            }
        }else{
            System.out.println("Valores inválidos");
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        System.out.println("Insira n");
        int n = input.nextInt();
        
        System.out.println("Insira p");
        int p = input.nextInt();
        
        TesteCalCombinatorio(n, p);
    }
    
}
