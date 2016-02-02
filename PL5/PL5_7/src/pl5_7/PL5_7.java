/**
 * Exercício 7 da PL5 (validado)
 * @author Tiago Leite (115780)
 * @since 20/10/2015
 */
package pl5_7;
import java.util.Scanner;

/**
 *
 * @author tiago
 */
public class PL5_7 {
    static Scanner input = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int a, b, aux, num, c, d, e;
        
        System.out.println("Insira o primeiro número");
        a = input.nextInt();
        
        System.out.println("Insira o segundo número");
        b = input.nextInt();
        
        if(a > b){
            aux = a;
            a = b;
            b = aux;
        }
        
        e = 0;
        
        System.out.println("Insira o limite");
        d = input.nextInt();
        
        for(c = 1; c <= d; c++){
            do{
                System.out.println("Insira um número");
                num = input.nextInt();
            }while(num < 0);
            
            if(((num % a)==0) && ((b % num)==0)){
                e++;
            }
        }
        
        System.out.println("Foram encontrados " + e + " números múltiplos de " + a + " e dividores de " + b);
    }
    
}
