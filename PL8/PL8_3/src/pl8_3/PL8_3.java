package pl8_3;

import java.util.Scanner;
import java.util.Formatter;

/**
 * Exercício 2 da PL8
 * @author Tiago Leite (1150780)
 * @since 04/11/2015
 */
public class PL8_3 {
    
    static Formatter out = new Formatter(System.out);
    static Scanner in = new Scanner(System.in);
    
    /**
     * Lê um numero inteiro maior que zero
     * @return Número inteiro maior que zero inserido pelo utilizador
     */
    public static int lerMaiorZero(){
        int n = in.nextInt();
        while (n < 0) {
            // Neste caso posso escrever aqui?
            out.format("Insira um número inteiro maior que zero: ");
            n = in.nextInt();
        }
        return n;
    }
    
    
    /**
     * Verificar se é a matriz é quadrada
     * @param m Matriz a analizar
     * @return Verdadeiro ou falso
     */
    public static boolean verificarQuadrado(int[][] m) {
        return m.length == m[0].length;
    }
    
    
    /**
     * Retorna a soma de uma coluna da matriz
     * @param m Matriz a analizar
     * @param c Número de coluna a somar
     * @return Resultado da soma
     */
    public static int somaColuna(int[][] m, int c) {
        int s = 0;
        // m.length = número de linhas
        for (int i = 0; i < m.length; i++) {
            s += m[i][c];
        }
        return s;
    }
    
    
    /**
     * Retorna a soma de uma linha da matriz
     * @param m Matriz a analizar
     * @param l Número da coluna a somar
     * @return Resultado da soma
     */
    public static int somaLinha(int[][] m, int l) {
        int s = 0;
        // m[linha].length = número de colunas da linha
        for (int i = 0; i < m[l].length; i++) {
            s += m[l][i];
        }
        return s;
    }
    
    
    /**
     * Retorna o valor da soma da diagonal principal da matriz quadrada
     * @param m Matriz a analizar
     * @return Resultado da soma
     */
    public static int somaPrincipal(int[][] m) {
        int s = 0;
        for (int i = 0; i < m.length; i++) {
            s += m[i][i];
        }
        return s;
    }
    
    
    /**
     * Retorna o valor da soma da diagonal secundária da matriz quadrada
     * @param m Matriz a analizar
     * @return Resultado da soma
     */
    public static int somaSecundaria(int[][] m) {
        int s = 0;
        for (int i = 0; i < m.length; i++) {
            s += m[m.length-i-1][i];
        }
        return s;
    }
    
    /**
     * Preenche uma matriz
     * @param mat Matriz a preencher
     */
    public static void lerMatriz(int[][] mat){
        // m.length = número de linhas
        for (int l = 0; l < mat.length; l++) {
            // m[linha].length = número de colunas da linha
            for (int c = 0; c < mat[l].length; c++) {
                out.format("Insira o elemento (%d,%d): ", l, c);
                mat[l][c] = in.nextInt();
            }
        }
    }
    
    public static boolean verificarMagia(int[][] m) {
            
        // Verifica o resultado da primeira linha
        int valor = somaLinha(m, 0);

        // Verificar o resultado do resto das linhas
        for (int x = 1; x < m.length; x++) {
            if (valor != somaLinha(m, x)) {
                return false;
            }
        }
        
        // Se as linhas forem todas iguais
        // Verifica o resultado da primeira coluna
        if (somaColuna(m, 0) == valor) {
            for (int x = 1; x < m[0].length; x++) {
                if (valor != somaColuna(m, x)) {
                    return false;

                }
            }
        }else
            return false;
        }
    
        if ((valor != somaPrincipal(m)) || (valor != somaSecundaria(m))) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        out.format("Insira o número de linhas: ");
        int l = lerMaiorZero();
        
        out.format("Insira o número de colunas: ");
        int c = lerMaiorZero();
        
        int[][] m = new int[l][c];
        
        if (verificarQuadrado(m)) {
            lerMatriz(m);
            
            if (verificarMagia(m)) {
                out.format("A matriz inserida é um quadrado mágico.");
            }else{
                out.format("A matriz inserida não é um quadrado mágico.");
            }
            
            
        }else {
            out.format("A matriz criada não é quadrada.");
        }
        
    }
    
}
