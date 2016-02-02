package pl7_4;

import java.util.Scanner;
import java.util.Formatter;

/**
 * Exercício 4 da PL7
 * @author Tiago Leite (1150780)
 * @since 26/10/2015
 */
public class PL7_4 {
    static Scanner in = new Scanner(System.in);
    static Formatter out = new Formatter(System.out);
    
    /**
     * Lê elementos para o vector
     * @param vec Vector a receber valores
     * @param n Número de elementos
     */
    private static void lerVector(int[] vec,int n){
        for(int i=0; i<n; i++) {
            out.format("Qual o número na posição nº %d? ",i+1);
            vec[i] = in.nextInt();
        }
    } 
    
    /**
     * Interte a ordem dos elementos do vector
     * @param vec vector a inverter
     * @param n número de elementos
     */
    private static void inverterVector(int[] vec, int n) {
        int aux;
        
        for(int i=0; i<n/2; i++) {
            aux = vec[i];
            vec[i] = vec[n-(i+1)];
            vec[n-(i+1)] = aux;
        }
    }
       
    /**
     * Roda para a direita os valores de um vector
     * @param vec vector a ser rodado
     * @param n número de elementos
     */
    private static void rodarVector(int[] vec, int n) {
        int aux = vec[n-1];
        
        for(int i=n-1;i>0; i--) {
            vec[i]=vec[i-1];
        }
        
        vec[0]=aux;
    }
    
    /**
     * Escreve menu e lê a opção escolhida
     * @return opção seleccionada (char)
     */
    private static char menu() {
        out.format("1. Leitura de Números\n2. Inversão do Vector\n3. Apresentar Vector Invertido\n4. Rotação Vector Invertido\n5. Apresentação Vector Invertido\n6. Terminar\n\nInsira a Opção: ");
        char opt = in.next().charAt(0);
        return opt;
    }
    
    /**
     * Mostra os elementos do vector
     * @param v vector a apresentar
     * @param n número de elementos
     */
    private static void mostrarVector(int[] v, int n) {
        for(int i=0; i<n; i++) {
            out.format("%d", v[i]);
        }
        out.format("\n\n");
    }
    
    public static void main(String[] args) {
        int[] vec = new int[100];
        
        char opcao;
        int n = 0;
        boolean invertido = false, rodado = false;
        
        do {
            opcao = menu();
            switch(opcao) {
                case '1':
                    int f=0;
                    out.format("Introduza a quantidade de números a ler: ");
                    do {
                        if(f==1) {
                            out.format("O Número inserido não é suportado pela Aplicação.\nIntroduza novamente a quantidade de números a ler: ");
                        }
                        n = in.nextInt(); 
                        f=1;
                    } while(n<0 || n>100);
                    lerVector(vec,n);
                    break;
                case '2':
                    if(n!=0) {
                        inverterVector(vec,n);
                        invertido=true;
                        rodado=false;
                    } else {
                        out.format("Não inseriu elementos no vector.\nExecute a opção 1 da aplicação para poder continuar.\n");
                    }
                    break;
                case '3':
                    if(invertido) {
                        mostrarVector(vec,n);
                    } else {
                        out.format("Não inverteu o vector.\nExecute a opção 2 da aplicação para poder continuar.\n");
                    }
                    break;
                case '4':
                    if(invertido) {
                        rodarVector(vec,n);
                        rodado=true;
                        invertido=false;
                    } else {
                        out.format("Não inverteu os elementos do vector.\nVerifique esta situação.\n");
                    }
                    break;
                case '5':
                    if(rodado) {
                        mostrarVector(vec, n);
                    } else {
                        out.format("Não rodou os elementos do vector.\nVerifique esta situação.\n");
                    }
                    break;
                case '6':
                    break;
                default:
                    out.format("A opção inserida não é válida.\n");
                    break;
            }
        
        } while(opcao!='6');
    }
    
}
