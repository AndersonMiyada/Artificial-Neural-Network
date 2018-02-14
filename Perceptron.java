/*
 *Bacharelado em Ciência da Computação 7ºS
 *Anderson Miyada RA: 525626
 *Jorge Takano Júnior RA: 529745
 */
package alfabeto;

/**
 *
 * @author anderson
 */
public class Perceptron {
    
    double pesos[];
    
    //**** Cria um neurônio Perceptron e inicializa os pesos *****
    public Perceptron(int n)
    {
        //pesos = new double[n+1];
        int a = n+1;
        
        pesos = new double[a];
         
        // Insere pesos aleatórios
        for(int i=0; i< a; i++)
        {
            //Inserindo números aleatórios positivos e nagativos exceto o 0
            if((i%2) == 0)
            pesos[i] = (double)(-1 + Math.random() * 0);
                else
                    pesos[i] = (double)-(-1 + Math.random() * 0);
        }
    }
        
    //****** Funão de saida do neurônio *******
    public int y(int x[])
    {    
        return (soma(x) >= 0) ? 1 : 0; // " ? "-> se / " : " -> senão
    }
    
    //****** Funão de somatório dos pesos de entrada  *******
    public double soma(int x[])
    {
        double u = pesos[0];
               
        for(int i=1; i < pesos.length; i++)
            {
                u += x[i-1] * pesos[i];                
            }
       
        return u;
    }
    
    //****** Funão de treinamento do neurônio  *******
    public void treinar(int padroes[][], int dj[][], double eta, int posvetsaida)
    {
        boolean temerro=true;
        int pos = posvetsaida;
        //int count =0;
        int erro;
        
        while(temerro)
        {
            temerro = false;
            
            for(int i=0; i<padroes.length;i++)
            {
                //Verifica o erro de acordo com a saida y (0 ou 1)
                //com a posição respectiva desejada da matriz dj
                int saida = y(padroes[i]);
                erro = dj[i][pos]- saida;
                
                if(erro!=0)
                {
                    temerro = true;
                    
                    // Atualiza o peso W0.
                    pesos[0] += eta * erro; 
               
                    for(int j=0; j < pesos.length-1; j++)
                    {
                        // Atualiza o peso W1 ... W25.
                        pesos[j+1] += eta * erro * padroes[i][j]; 
                        //System.out.printf("%d\n",count++);
                    }
                    
                }
                
            }
            
        }
    }
}
