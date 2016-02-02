/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl6_2;

import java.util.Scanner;

/**
 * Exercício 2 da PL6 (validado)
 * @summary Criar um gráfico de barras com o número de positivas e negativas de uma disciplina
 * @author Tiago Leite (115780)
 * @since 19/10/2015
 */
public class PL6_2 {
    static Scanner input = new Scanner(System.in);
    
    /**
     * Criar uma barra de um gráfico de barros
     * @param titulo Título da barra
     * @param numero Número de elementos
     * @return Barra do gráfico
     */
    public static String criarBarra(String titulo, int numero){
        String barra = "- " + titulo + ": ";
        while(numero > 0){
            barra = barra + "*";
            numero--;
        }
        return barra;
    }
    
    /**
     * Mostrar gráfico de barras
     * @param disciplina Nome da disciplina
     * @param positivas Número de positivas
     * @param negativas Número de negativas
     */
    public static void mostrarGrafico(String disciplina, int positivas, int negativas){
        System.out.println("Disciplina : " + disciplina);
        System.out.println(criarBarra("Positivas", positivas));
        System.out.println(criarBarra("Negativas", negativas));
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Inserir a disciplina");
        String disciplina = input.nextLine();
        
        System.out.println("Inserir o número de positivas");
        int positivas = input.nextInt();
        
        System.out.println("Inserir o número de negativas");
        int negativas = input.nextInt();
        
        mostrarGrafico(disciplina, positivas, negativas);
    }
    
}
