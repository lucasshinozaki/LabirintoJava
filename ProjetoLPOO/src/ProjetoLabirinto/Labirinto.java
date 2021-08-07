package ProjetoLabirinto;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Esta classe consiste em metodos para instanciar um labirinto, verificar se sao validos, e resolve-los.
 */

public class Labirinto {
    
    private char[][] labirinto = new char[0][0];
    private int linhasQtd, colunasQtd = 0;
    private Fila<Caminho> fila;
    private Pilha<Caminho> caminho;
    private Pilha<Fila<Caminho>> possibilidades;
    private Caminho atual;

    public char[][] getLabirinto()
    {
        return this.labirinto;
    }
    
    public int getLinhasQtd()
    {
        return this.linhasQtd;
    }
    
    public int getColunasQtd()
    {
        return this.colunasQtd;
    }
    
    public Labirinto(String localArqv) throws Exception
    {
       this.montaLabirinto(localArqv);
       caminho = new Pilha<Caminho> ();
       possibilidades = new Pilha<Fila<Caminho>> ();
    }
    
    private void setCaminho(Caminho pos) 
    {
        this.labirinto[pos.getLinha()][pos.getColuna()] = 'o';
        System.out.printf("(%d, %d)\n",pos.getLinha(), pos.getColuna());
    }
    
    public void delete(String arq) {	
    		File file = new File(arq);
    		file.delete();
    	
    }
    
    private void montaLabirinto(String localLabirinto) throws Exception
    {
    	
        if (localLabirinto == null || localLabirinto.equals(""))
            throw new Exception ("Local do labirinto nulo!");
        
        BufferedReader entrada = new BufferedReader (new FileReader (localLabirinto));
       
        while (entrada.ready())
        {
            String linha = entrada.readLine();
            
            while(this.colunasQtd < linha.length())
                this.colunasQtd++;
            
            this.linhasQtd++;
        }

        this.labirinto = new char[this.linhasQtd][this.colunasQtd];  
        
        entrada = new BufferedReader (new FileReader (localLabirinto));
        int l = 0;
        
        while (entrada.ready())
        {
            String linha = entrada.readLine();

            for (int i=0; i<linha.length(); i++) 
            {
                this.labirinto[l][i] = linha.charAt(i);
                
                if (linha.charAt(i) == 'E')
                {
                    atual = new Caminho (l,i);
                
                if (!this.validaEntradaESaida(atual)) 
                	throw new Exception ("Labirinto invalido ! A entrada nao esta¡ numa posicao valida!");
  
                }
            }
            l++;
        }
        entrada.close();
    }
    
    public void draw() {
		for (char[] line: labirinto) {
			for (char symbol: line) {
				System.out.print(symbol);
			}
			System.out.println();
		}
	}
    
    public boolean validaEntradaESaida(Caminho at)
    {
        boolean ret = true;

        if (at.getColuna() > 0 && at.getColuna() < this.colunasQtd)
            if (at.getLinha() > 0 && at.getLinha() < this.colunasQtd)
                ret = false;
        
        return ret;
    }
    
    private boolean procuraSaida() throws Exception
    {        
        for (int linha=0; linha<this.linhasQtd; linha++) {
            for (int coluna=0; coluna<this.colunasQtd; coluna++ ) 
            {
                if (labirinto[linha][coluna] == 'S')
                    return true;
            }
        }
        return false;
    }
    
    private void procuraAdjacentes() throws Exception 
    {
        fila = new Fila<Caminho> ();
        
        if (atual.getColuna()+1 < this.colunasQtd)
            if (this.labirinto[atual.getLinha()][atual.getColuna()+1] == ' '  || this.labirinto[atual.getLinha()][atual.getColuna()+1] == 'S')
               fila.guardeUmItem(new Caminho(atual.getLinha(), atual.getColuna()+1));
        
        if (atual.getColuna()-1 >= 0)
            if (this.labirinto[atual.getLinha()][atual.getColuna()-1] == ' '  || this.labirinto[atual.getLinha()][atual.getColuna()-1] == 'S')
                fila.guardeUmItem(new Caminho(atual.getLinha(), atual.getColuna()-1));
        
        if (atual.getLinha()+1 < this.linhasQtd)
            if (this.labirinto[atual.getLinha()+1][atual.getColuna()] == ' '  || this.labirinto[atual.getLinha()+1][atual.getColuna()] == 'S')
                fila.guardeUmItem(new Caminho(atual.getLinha()+1, atual.getColuna()));       
        
        if (atual.getLinha()-1 >= 0)
            if (this.labirinto[atual.getLinha()-1][atual.getColuna()] == ' ' || this.labirinto[atual.getLinha()-1][atual.getColuna()] == 'S')
                fila.guardeUmItem(new Caminho(atual.getLinha()-1, atual.getColuna())); 
    }
    
    private void preencheCaminho () throws Exception
    {
        //Modo progressivo
        for(;;)
        {
            this.procuraAdjacentes();

            while (fila.vazia())
            {
                //Modo Regressivo
                atual = caminho.getUmItem();
                caminho.jogueUmItemFora();

                this.procuraAdjacentes();
                
                this.labirinto[atual.getLinha()][atual.getColuna()] = '/'; 

                if (!possibilidades.getUmItem().vazia())
                    fila.guardeUmItem(possibilidades.getUmItem().getUmItem());
                
                possibilidades.jogueUmItemFora();
            }     

            if (fila.vazia())
            throw new Exception ("Nao existe solucao para este labirinto!");
            
            atual = fila.getUmItem();
            fila.jogueUmItemFora();

            if (labirinto[atual.getLinha()][atual.getColuna()] == ' ')
                this.setCaminho(atual);

            caminho.guardeUmItem(atual);
            possibilidades.guardeUmItem(fila);
            
            if (labirinto[atual.getLinha()][atual.getColuna()] == 'S') 
                return;
        }
    }
    
    public void resolveLabirinto () throws Exception
    {
        if (!this.procuraSaida()) {
        	 throw new Exception ("O labirinto nao possui saida valida!");
   
        }else {
        	 this.preencheCaminho();
        }
           
       
    }

	

    
}

