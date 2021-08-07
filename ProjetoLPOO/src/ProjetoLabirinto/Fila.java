package ProjetoLabirinto;

import java.lang.reflect.*;

/**
 * Esta classe consiste em metodos para armazenar dados em uma lista, na forma de Fila.
 */

public class Fila <X> implements Cloneable
{
    private ManipuladorLista<X> lista;

    private X meuCloneDeX (X x)
    {
        X ret=null;
        
        try
        {
            Class<?> classe = x.getClass();
            Class<?>[] tipoParametroFormal = null; // null pq clone tem 0 parametros
            Method metodo = classe.getMethod ("clone", tipoParametroFormal);
            Object[] parametroReal = null; // null pq clone tem 0 parametros
            ret = (X)metodo.invoke (x, parametroReal);
        }
        catch (Exception erro)
        {}

        return ret;
    }

    public Fila () throws Exception
    {
        this.lista = new ManipuladorLista<X> ();
    }

    public void guardeUmItem (X x) throws Exception
    {
        if (x == null)
            throw new Exception ("Item inválido!");
        
        X info = null;
        
        if (x instanceof Cloneable)
            info = this.meuCloneDeX(x);
        else
            info = x;
        
        this.lista.insiraNoFinal(info);
    }

    public X getUmItem () throws Exception
    {
        if (this.lista.vazia())
            throw new Exception ("Lista vazia!");
        
        X ret = null;
        X primeiro = this.lista.getPrimeiro();
        
        if (primeiro instanceof Cloneable)
            ret = this.meuCloneDeX(primeiro);
        else
            ret = primeiro;
        
        return ret;
    }

    public void jogueUmItemFora () throws Exception
    {        
       this.lista.removePrimeiro();
    }

    public boolean vazia ()
    {
        if (this.lista.vazia())
            return true;
        else
            return false;
    }

    public String toString ()
    {
        return this.lista.toString();
    }

    public boolean equals (Object obj)
    {
        return this.lista.equals(obj);
    }

    public int hashCode ()
    {
        return this.lista.hashCode();
    }

    public Fila (Fila<X> modelo) throws Exception
    {
        if (modelo==null)
            throw new Exception ("Modelo ausente");
        
        this.lista = modelo.lista;
    }

    public Object clone ()
    {
        Fila<X> ret=null;

        try
        {
            ret = new Fila<X> (this);
        }
        catch (Exception erro)
        {}

        return ret;
    }
}
