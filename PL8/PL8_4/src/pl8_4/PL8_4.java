package pl8_4;

import java.util.Scanner;
import java.util.Formatter;

/**
 * Exercício 4 da PL 8
 * @author Tiago Leite
 * @since 08/11/2015
 */
public class PL8_4 {
    
    static Scanner in = new Scanner(System.in);
    static Formatter out = new Formatter(System.out);
    
    /**
     * Lê um numero inteiro maior que zero
     * @return Número inteiro maior que zero inserido pelo utilizador
     */
    public static int lerMaiorZero() {
        int n = in.nextInt();
        while (n < 0) {
            // Neste caso posso escrever aqui?
            out.format("Insira um número inteiro maior que zero: ");
            n = in.nextInt();
        }
        return n;
    }
    
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
     * Mostra a matriz no ecrã ignorando linhas a 0
     * @param mat Matriz a mostrar
     */
    public static void mostrarTabelaOcorrencia(int[][] mat, int num){
            // m[linha].length = número de colunas da linha
            for (int c = 0; c < num; c++) {
                out.format("%d ", mat[0][c]);           
            }
            out.format("\n");
            
            // m[linha].length = número de colunas da linha
            for (int c = 0; c < num; c++) {
                out.format("%d ", mat[1][c]);               
            }
            out.format("\n");
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
    
    /**
     * Retorna o número de ocorrências de um número na matriz
     * @param mat Matriz a percorrer
     * @param num Número a procurar a procurar
     * @return Número de ocorrências
     */
    public static int numeroOcorrenciasMatriz(int[][] mat, int num) {
        int cont = 0;
        // m.length = número de linhas
        for (int l = 0; l < mat.length; l++) {
            // m[linha].length = número de colunas da linha
            for (int c = 0; c < mat[l].length; c++) {
                if (mat[l][c] == num) {
                    cont++;
                }
            }
        }
        return cont;
    }
    
    /**
     * Retorna o número de ocorrências de um número no vector
     * @param vec Vector a percorrer
     * @param num Número a procurar a procurar
     * @return Número de ocorrências
     */
    public static int numeroOcorrenciasVector(int[] vec, int num) {
        int cont = 0;
        for (int i = 0; i < vec.length; i++) {
            if (vec[i] == num){
                cont++;
            }
        }
        return cont;
    }
    
    /**
     * Cria uma tabela de ocorrências a partir de uma matriz
     * @param mat Matriz a analizar
     * @param res Matriz onde guardar a tabela
     * @return Número de ocorrências
     */
    public static int tabelaOcorrencias(int[][] mat, int[][] res) {
        int ele = 0;
        // m.length = número de linhas
        for (int l = 0; l < mat.length; l++) {
            // m[linha].length = número de colunas da linha
            for (int c = 0; c < mat[l].length; c++) {
                // out.format("Elemento a ser procurado %d \n", mat[l][c]);
                // out.format("Número de ocorrências na tabela %d \n", numeroOcorrenciasVector(res[0], mat[l][c]));
                if(numeroOcorrenciasVector(res[0], mat[l][c]) == 0){
                    // out.format("Vai ocupar a posição %d \n", ele);
                    res[0][ele] = mat[l][c];
                    res[1][ele] = numeroOcorrenciasMatriz(mat, mat[l][c]);
                    ele++;
                }
            }
            
        }
        return ele;
    }
    
    /**
     * Ordena a tabela de ocorrências
     * @param res Matriz da tabela de ocorrências
     */
    public static void ordenarTabelaOcorrencias(int[][] res, int num) {
        int temp;
        for (int i = 0; i < num-1; i++) {
            for (int j = i+1; j < num; j++) {
                if (res[1][i] < res[1][j]) {
                    // Faz a troca do cabeçalho
                    temp = res[0][j];
                    res[0][j] = res[0][i];
                    res[0][i] = temp;
                    
                    // Faz a troca das ocorrências
                    temp = res[1][j];
                    res[1][j] = res[1][i];
                    res[1][i] = temp;
                }
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
        out.format("Insira o número de linhas: ");
        int l = lerMaiorZero();
        
        out.format("Insira o número de colunas: ");
        int c = lerMaiorZero();
        
        int mat[][] = new int[l][c];
        int res[][] = new int[2][l*c];
        
        lerMatriz(mat);
        
        out.format("\n.: Matriz inserida :.\n");
        mostrarMatriz(mat);
        
        int nOco = tabelaOcorrencias(mat, res);
        out.format("\n.: Tabela de ocorrências :.\n");
        mostrarTabelaOcorrencia(res, nOco);
        
        ordenarTabelaOcorrencias(res, nOco);
        out.format("\n.: Tabela de ocorrências ordenada :.\n");
        mostrarTabelaOcorrencia(res, nOco);
    }
    
}
