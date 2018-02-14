/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xorneural;

import java.util.Random;


/**
 *
 * @author 
 * Anderson Miyada RA 525626
 * Jorge Takano Júnior RA529745
 */
public class Perceptron {

   double pesos[];
   int inter_saida;
    
   //Construtor OK!
    public Perceptron(int n)
    {
      pesos = new double[n];
       //pesos = new double[] {-0.3, 0.2, 0.0};
        
     Random r = new Random();
     
        for(int i=0; i< pesos.length; i++)
        {
            //Inserindo números aleatórios positivos e nagativos exceto o 0
            if((i%2) == 0)
            {
            pesos[i] = r.nextDouble();
            }
                else
                   pesos[i] = -(r.nextDouble());
            
        }
      
    }
    
    //Método y OK!
    public int y(int x[])
    {    //System.out.println("Entrou Y" );
        
        return (soma(x) >= 0 ? 1 : 0);  
         
    }
    
    //Método soma OK!
    public double soma(int x[])
    {
        //System.out.println("Entrou soma" );
        //Armazena o valor do peso0 cuja entrada é sempre 1. 
        double u = pesos[0];
        
        for(int i=1; i < pesos.length; i++)
            {
               
                u += x[i-1] * pesos[i];                
            }
        
        return u;
    }
    
    public void treinar(int padroes[][], int dj[], double eta)
    {
        boolean temerro=true;
        int count =0;
        
        while(temerro)
        {
            temerro = false;
            //System.out.println("tem erro");
            for(int i=0; i<padroes.length;i++)
            {
                int saida = y(padroes[i]);
                int erro = dj[i]-saida;
                
                if(erro!=0)
                {
                    temerro = true;
                    //System.out.println("atualiza peso");
                    // Atualiza o peso W0.
                    pesos[0] += eta * erro; 
               
                    for(int j=0; j < pesos.length-1; j++)
                    {
                        // Atualiza o peso W1 e W2.
                        pesos[j+1] += eta * erro * padroes[i][j]; 
                        //System.out.println("contador"+ j);
                    }
                    
                }
                //System.out.println("saiu do erro");
            }
            
        }//System.out.println("treinado");
    }//End Treinar
        
}//End Class