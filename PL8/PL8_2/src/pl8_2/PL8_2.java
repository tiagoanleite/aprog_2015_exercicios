package pl8_2;

import java.util.Scanner;
import java.util.Formatter;

/**
 * Exercício 2 da PL8
 * @author Tiago Leite (1150780)
 * @since 08/11/2015
 */
public class PL8_2 {
    
    static Scanner in = new Scanner(System.in);
    static Formatter out = new Formatter(System.out);
    
    /**
     * Mostra a matriz no ecrã
     * @param mat Matriz a mostrar
     */
    public static void mostrarMatriz(int[][] mat){
        // m.length = número de linhas
        for (int l = 0; l < mat.length; l++) {
            // m[linha].length = número de colunas da linha
            for (int c = 0; c < mat[l].length; c++) {
                out.format("%d ", mat[l][c]);
            }
            out.format("\n");
        }
    }
    
    /**
     * Calcula a média de uma coluna
     * @param m Matriz a trabalhar
     * @param c Coluna a calcular
     * @return Média dos elementos da coluna
     */
    public static double mediaColuna(int[][] m, int c) {
        double med = 0;
        // m.length = número de linhas
        for (int i = 0; i < m.length; i++) {
            med += m[i][c];
        }
        med /= (double)m.length;
        return med;
    }
    
    /**
     * Calcula a média de uma matriz
     * @param mat Matriz a trabalhar
     * @return Média dos elementos da matriz
     */
    public static double mediaGlobal(int[][] mat){
        double med = 0;
        int ele = 0;
        // m.length = número de linhas
        for (int l = 0; l < mat.length; l++) {
            // m[linha].length = número de colunas da linha
            for (int c = 0; c < mat[l].length; c++) {
                med += mat[l][c];
                ele++;
            }
        }
        med /= (double)ele;
        return med;
    }
    
    /**
     * Mostra a matriz no ecrã de forma transposta
     * @param mat Matriz a mostrar
     */
    public static void mostrarTransposta(int[][] mat){
        // m[0].length = número de colunas 1ª linha
        for(int c = 0; c < mat[0].length; c++){
            // m.length = número de linhas
            for (int l = 0; l < mat.length; l++) {
                // Transposto de m[0][1] é m[1][0]
                out.format("%d ", mat[l][c]);
            }
            out.format("\n");
        }
    }
    

    /**
     * Alínea A)
     * Cria uma matriz de 5 x 4 e mostra o maior de cada linha
     */
    public static void main(String[] args) {
        int x;
        int m[][] = {{1,4,2,1},{9,7,2,2},{1,7,3,5},{2,5,0,3},{4,7,2,1}};
        out.format("Maiores elementos de cada linha\n");
        for (int i=0; i < m.length; i++) {
            x = m[i][0];
            for (int j=1; j < m[i].length; j++)
                if (m[i][j] > x)
                    x= m[i][j];
            System.out.println(x);
        }
        
        // m[0].length = número de colunas 1ª linha
        for (int c = 0; c < m[0].length; c++) {
            out.format("Média da %dª coluna = %.2f\n", c+1, mediaColuna(m, c));
        }
        
        out.format("Média global = %.2f\n", mediaGlobal(m));
        
        out.format("Matriz original\n");
        mostrarMatriz(m);
        
        out.format("Matriz transposta\n");
        mostrarTransposta(m);
    }
    
}
