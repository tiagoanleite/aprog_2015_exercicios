package pl7_2;

import java.util.Scanner;
import java.util.Formatter;

/**
 * Exercício 2 da PL7
 * @author tiago Leite (1150780)
 * @since 01/11/2015
 */
public class PL7_2 {
    static Formatter out = new Formatter(System.out);
    static Scanner in = new Scanner(System.in);
    static final int NUM = 50;
    
    /**
     * Lista os funcionários com vencimentos inferiores à média
     * @param nome[] Vector String com o nome dos funcionários
     * @param venc[] Vector float com os vencimentos dos funcionários
     * @param nFunc número de funcionarios lidos
     */
    public static void listaInferiores(String nome[], float venc[], int nFunc) {
        int s=0;
               
        for (int i=0;i<nFunc;i++){
            s += venc[i];
        }
        
        if (nFunc != 0){
            float med = (float)s/nFunc;
            
            out.format("\n\nLista de funcionários com vencimento abaixo à média (%.2f)\n", med);
            
            for(int i = 0; i < nFunc; i++) {
                if (venc[i] < med){
                    out.format(" - %s (nº%2d) \n", nome[i], i+1);
                }
            }
        }else{ 
           out.format("\n\nImpossível listar. Não foram inseridos funcionários.");
    } 
}
    
    /**
     * Devolve a percentagem de funcionarios com vencimento inferior ao definido
     * @param venc Vector com os vencimentos
     * @param nFunc Número de funcionários no vector
     */
    public static void percentagemInferior(float venc[], int nFunc) {
        out.format("\n\nInsira o valor de comparação: ");
        
        float valVenc = in.nextFloat();
        int c = 0, i;
        
        if (nFunc == 0){
            out.format("Impossível calcular. Não foram inseridos funcionários.");
        }else{
            for (i=0; i < nFunc; i++){
                if (valVenc > venc[i]){
                  c++;  
                }
            }

            if (c == 0){
                out.format("Nao existem funcionários abaixo de %.2f", valVenc);
            }else{
                out.format("Percentagem de funcionários com vencimento inferior a %.2f: %d %%\n", valVenc, (int)((c*100)/i) );
            }
        }
        
    }
    
    public static void main(String[] args) {
        String nomes[] = new String[NUM];
        float venc[] = new float[NUM];
        int nFunc = 0;
        String inserido;
        
        out.format("Utilize 'tt' para terminar a leitura.\n");
        do {
            out.format("\nInsira o nome do funcionário nº %d? ", nFunc+1);
            inserido = in.nextLine();
            if(!inserido.equalsIgnoreCase("tt")){
                nomes[nFunc] = inserido;
                out.format("Vencimento do funcionário %s? ", nomes[nFunc], nFunc+1);
                venc[nFunc] = in.nextFloat();
                in.nextLine();
                nFunc++;
            }
        } while((!inserido.equalsIgnoreCase("tt")) && (nFunc < nomes.length));
        
        listaInferiores(nomes, venc, nFunc);
        percentagemInferior(venc, nFunc);
    }

}