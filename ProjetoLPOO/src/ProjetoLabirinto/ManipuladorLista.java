package ProjetoLabirinto;

import java.lang.reflect.*;
/**
 * Esta classe consiste em metodos para armazenar dados em nos, na forma de lista desordenada.
 */

public class ManipuladorLista<X> {
    private class No
    {
        private X  info;
        private No prox;

        public No (X i, No p)
        {
            this.info = i;
            this.prox = p;
        }

        public X getInfo ()
        {
            return this.info;
        }

        public No getProx ()
        {
            return this.prox;
        }

        public void setInfo (X i)
        {
            this.info = i;
        }

        public void setProx (No p)
        {
            this.prox = p;
        }
    }
    
    private No prim;
    private No ulti;

    public ManipuladorLista() 
    {
        this.prim = null;
        this.ulti = null;
    }
    
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
    
    public boolean vazia() 
    {
        if (this.prim == null)
            return true;
        else
            return false;
    }
    
    public void insiraNoTopo(X i) throws Exception 
    {
        if (i==null)
           throw new Exception ("Informacao ausente !");
        
        if (this.prim == null) 
        {
            this.prim = new No(i, null);
            this.ulti = this.prim;
            return;
        }
        
        No novo = new No(i, this.ulti);
        this.ulti = novo;
    }
    
    public void insiraNoFinal(X i) throws Exception 
    {
        if (this.prim == null) {
            this.prim = new No(i, null);
            this.ulti = this.prim;
            return;
        }
        
        if (this.prim.getProx() == null)
        {
            this.ulti = new No(i, null);
            this.prim.setProx(this.ulti);            
            return;
        }
      
        this.ulti.setProx(new No (i, null));
        this.ulti = this.ulti.getProx();
    }
    
    public void removePrimeiro()  throws Exception
    {
        if (this.prim == null)    
            throw new Exception ("Lista vazia !");
        
        this.prim = this.prim.getProx();

    }
    
    public void removeUltimo() throws Exception
    {
        if (this.ulti == null)
            throw new Exception ("Lista vazia !");
        
        this.ulti = this.ulti.getProx();
    }
    
    public X getPrimeiro()
    {
        return this.prim.info;
    }
    
    public X getUltimo()
    {
        return this.ulti.info;
    }
    
    public boolean equals (Object obj)
    {
        if (this==obj)
            return true;

        if (obj==null)
            return false;

        if (this.getClass()!=obj.getClass())
            return false;

        ManipuladorLista<X> lis=(ManipuladorLista<X>)obj;

        No atualThis=this.prim, atualLis=lis.prim;

        while (atualThis!=null && atualLis!=null)
        {
                if (!atualThis.getInfo().equals(atualLis.getInfo()))
                        return false;

                atualThis=atualThis.getProx();
                atualLis =atualLis .getProx();
        }

        if (atualThis!=null)
                return false;

        return atualLis == null;
    }

    public int hashCode ()
    {
        int ret=666;

        No atual=this.prim;
        while (atual!=null)
        {
            ret = ret*7 + atual.getInfo().hashCode();
            atual= atual.getProx();
        }

        return ret;
    }
    
    public String toString ()
    {
        String ret="";

        No atual=this.prim;
        while (atual!=null)
        {
            ret += atual.getInfo()+" ";
            atual= atual.getProx();
        }

        return ret;
    }
}
