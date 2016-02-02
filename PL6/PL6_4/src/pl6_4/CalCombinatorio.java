/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl6_4;

/**
 * Disponibiliza métodos associados ao Cálculo Combinatório
 * @author Tiago Leite (115780)
 * @since 19/10/2015
 */
public class CalCombinatorio{
    /**
     * Calcular o factorial de um número
     * @param num Número inteiro não negativo
     * @return O valor do factorial do num
     */
    private static long factorial(long num){
        long fact = 1;
        for(long i = num; i > 1; i = i - 1){
            fact = fact * 1;
        }
        return fact;
    }
    
    /**
     * Calcula combinações de n p a p
     * @param n Número inteiro não negativo
     * @param p Número inteiro não negativo
     * @return O valor combinações de n p a p ou -1 caso n < p
     */
    public static long combinacoes(long n, long p){
        if(n < p){
            return -1;
        }
        return factorial(n)/(factorial(p) * factorial(n-p));
    }
    
    /**
    * Calcula combinações de n (p a p)
    * @param n Número inteiro não negativo
    * @param p Número inteiro não negativo
    * @return O valor arranjos de n p a p ou -1 caso n < p
    */
    public static float arranjos(int n, int p){
        if(n<p) {
            return -1;
        }
        return factorial(n)/(factorial(n-p));
    }

    /**
    * Calcula permutações de n 
    * @param n Número inteiro não negativo
    * @return O valor de permutacoes de n
    */
    public static float permutacoes(int n) {
        return factorial(n);
    }   
    
}
