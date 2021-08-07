package ProjetoLabirinto;

/**
* Esta classe consiste em metodos para armazenar e recuperar caminhos especificos dentro do labirinto.
*/

public class Caminho {
    
    private int linha, coluna; 
    
    public void setLinha(int linha) {
        this.linha = linha;
    }
    
    public void setColuna(int coluna) {
        this.coluna = coluna;
    }
    
    public int getLinha() {
        return this.linha;
    }
    
    public int getColuna() {
        return this.coluna;
    }
    
    public Caminho(int l, int c) throws Exception {
        this.linha = l;
        this.coluna = c;
    }
    
    public String toString() {
        return "(" + this.linha + "," + this.coluna + ")";
    }
}
