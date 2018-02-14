/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xorneural;




/**
 *
 * @author 
 * Anderson Miyada RA 525626
 * Jorge Takano Júnior RA529745
 */
public class XorNeural {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
             
        int n = 3;
        double eta = 0.2;
        
        Perceptron p1 = new Perceptron(n);
        Perceptron p2 = new Perceptron(n);
        Perceptron pSaida = new Perceptron(n);
        
        //Matriz de entrada X1, X2
        int pd[][] =    { {0,0}, 
                          {0,1},
                          {1,0},
                          {1,1} 
                        };
        
        //Vetor com resultado desejado
        int djp1[] = {0,0,1,0};
        int djp2[] = {0,1,0,0};
        int dj[] = {0,1,1,1};   
        
        p1.treinar(pd,djp1,eta);
        p2.treinar(pd,djp2,eta);
        pSaida.treinar(pd,dj,eta);
        
        System.out.println("");
        
        // Resultado
        System.out.println("Resultado p1");
        System.out.println("0 xor 0 = " +p1.y(new int[] {0,0}));
        System.out.println("0 xor 1 = " +p1.y(new int[] {0,1}));
        System.out.println("1 xor 0 = " +p1.y(new int[] {1,0}));
        System.out.println("1 xor 1 = " +p1.y(new int[] {1,1}));
        System.out.println("");       
        System.out.println("Resultado p2");
        System.out.println("0 xor 0 = " +p2.y(new int[] {0,0}));
        System.out.println("0 xor 1 = " +p2.y(new int[] {0,1}));
        System.out.println("1 xor 0 = " +p2.y(new int[] {1,0}));
        System.out.println("1 xor 1 = " +p2.y(new int[] {1,1}));
        System.out.println("");        
        System.out.println("Resultado pSaida");
        System.out.println("0 xor 0 = " +pSaida.y(new int[] {0,0}));
        System.out.println("0 xor 1 = " +pSaida.y(new int[] {0,1}));
        System.out.println("1 xor 0 = " +pSaida.y(new int[] {1,0}));
        System.out.println("1 xor 1 = " +pSaida.y(new int[] {1,1}));
        
        }
}