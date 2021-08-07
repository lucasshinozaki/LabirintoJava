package ProjetoLabirinto;

import java.lang.reflect.*;
/**
 * Esta classe consiste em metodos para armazenar dados em uma lista, na forma de Pilha.
 */

public class Pilha<X> {
    
    private ManipuladorLista<X> lista;
    
    /**
     * Metodo para clonar dados para armazenar ou retornar.
     */
    private X meuCloneDeX (X x)
    {
        X ret=null;
        
        try
        {
            Class<?> classe = x.getClass();
            Class<?>[] tipoParametroFormal = null;
            Method metodo = classe.getMethod ("clone", tipoParametroFormal);
            Object[] parametroReal = null;
            ret = (X)metodo.invoke (x, parametroReal);
        }
        catch (Exception erro)
        {}

        return ret;
    }
            
    public Pilha() throws Exception 
    {
        this.lista = new ManipuladorLista<X> ();
    }

    public void guardeUmItem (X x) throws Exception
    {
        if (x == null)
            throw new Exception ("Item invalido!");
        
        X info = null;
        
        if (x instanceof Cloneable)
            info = this.meuCloneDeX(x);
        else
            info = x;
        
        this.lista.insiraNoTopo(info);
    }

    public X getUmItem () throws Exception
    {
        if (lista.vazia())
            throw new Exception ("Lista vazia !");
        X ret = null;
        X primeiro = this.lista.getUltimo();
        
        if (primeiro instanceof Cloneable)
            ret = this.meuCloneDeX(primeiro);
        else
            ret = primeiro;
        
        return ret;
    }
    
    public void jogueUmItemFora () throws Exception
    {
        this.lista.removeUltimo();
    }
    
    public boolean vazia ()
    {
        if (this.lista.vazia())
            return true;
        else
            return false;
    }
    
    public String toString()
    {
        return this.lista.toString();
    }
    
    public int hashCode()
    {
        return this.lista.hashCode();
    }
    
    public boolean equals(Object obj)
    {
        return this.lista.equals(obj);
    }
    
    public Pilha (Pilha<X> modelo) throws Exception
    {
        if (modelo==null)
            throw new Exception ("Modelo ausente");
        
        this.lista = modelo.lista;
    }

    public Object clone ()
    {
        Pilha<X> ret=null;

        try
        {
            ret = new Pilha<X> (this);
        }
        catch (Exception erro)
        {}

        return ret;
    }
    
}
