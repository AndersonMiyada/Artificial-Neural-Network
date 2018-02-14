/*
 *Bacharelado em Ciência da Computação 7ºS
 *Anderson Miyada RA: 525626
 *Jorge Takano Júnior RA: 529745
 *
 */
package andneural;

/**
 *
 * @author anderson
 */
public class AndNeural {

   
    
    public static void main(String args[])
    {
        //double pesos[] = {-0.5, 0.4, 0.1}; // Pesos W0,W1,W2
        
        int n = 2;
        
        AndNeural p = new AndNeural(n);
        
        int pd[][] =    { {0,0}, //Matriz de entrada X1, X2
                          {0,1},
                          {1,0},
                          {1,1} };
        
        int dj[] = {0,0,0,1};   //Vetor com resultado desejado
        
        p.treinar(pd, dj, 0.2);
        
        // Resultado
        System.out.println("0 e 0 = " +p.y(new int[] {0,0}));
        System.out.println("0 e 1 = " +p.y(new int[] {0,1}));
        System.out.println("1 e 0 = " +p.y(new int[] {1,0}));
        System.out.println("1 e 1 = " +p.y(new int[] {1,1}));
        
        }
    
    double pesos[];
    
    public double[] inicializaPesos (int p)
    {
        pesos = new double[p];
                
        for(int i=0; i< p; i++)
        {
            //Inserindo números aleatórios positivos e nagativos exceto o 0
            if((i%2) == 0)
            pesos[i] = (double)(-1 + Math.random() * 0);
                else
                    pesos[i] = (double)-(-1 + Math.random() * 0);
        }
        
        return pesos;
    }
    
    
    
   
    public AndNeural(int n)
    {
        pesos = new double[n+1];
    }
  /*
    public void andNeural(double pesos[])
    {
        pesos = new double[pesos.length];
        
        for(int i=0; i<pesos.length; i++)
            this.pesos[i] = pesos[i];
    }*/
    
    public int y(int x[])
    {    
        return (soma(x) >= 0) ? 1 : 0; // " ? "-> se / " : " -> senão
    }
    
    public double soma(int x[])
    {
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
            
            for(int i=0; i<padroes.length;i++)
            {
                int saida = y(padroes[i]);
                int erro = dj[i]-saida;
                
                if(erro!=0)
                {
                    temerro = true;
                    
                    // Atualiza o peso W0.
                    pesos[0] += eta * erro; 
               
                    for(int j=0; j < pesos.length-1; j++)
                    {
                        // Atualiza o peso W1 e W2.
                        pesos[j+1] += eta * erro * padroes[i][j]; 
                        //System.out.printf("%d",count++);
                    }
                    
                }
                //System.out.println("saiu do erro");
            }
            
        }//System.out.println("treinado");
    }
}


