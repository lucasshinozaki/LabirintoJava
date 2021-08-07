package ProjetoLabirinto;

import java.io.*;
import java.util.Scanner;

public class Main
{
	private static final Scanner s = new Scanner(System.in);
	private static Labirinto labirinto;
	private static CriarArquivoTxt criar_arq;
	
	
    public static void main(String[] args) throws Exception {

    	while(true) {
    		menu();
    		int opt = s.nextInt();
    		if(opt == 1) {
    			labirinto = escolha();
   
    			if(labirinto != null) {
    				labirinto.draw();
    			}
    		} else if(opt == 2 && labirinto != null) {
    			resolver();
    		} else if(opt == 3) {
    			criar_arq.abrirArquivo();
    			criar_arq.adicionarDados();
    			criar_arq.fecharArquivo();
    		} else if(opt == 4) {
    			labirinto = nova_escolha();
    			if(labirinto != null) {
    				labirinto.draw();
    			}
    		}else if(opt == 5) {
    			delete();
    		}
    		else if(opt == 0) {
    			break;
    		} else {
    			System.out.println("Opcao invalida. Tente Novamente");
  
    		}
    		System.out.println();
    	}
    	s.close();
    	System.out.println("Encerrado!");
    }
    	
     
    public static void menu() {
    	System.out.println("|-------------------------------------------------------|");
        System.out.println("|         PROGRAMA DE RESOLUÇÃO DE LABIRINTO            |");
        System.out.println("| Menu:                                                 |");
        System.out.println("| 1 - Escolha um labirinto txt                          |");
        System.out.println("| 2 - Resolver labirinto txt                            |");
        System.out.println("| 3 - Criar um novo labirinto txt                       |");
        System.out.println("| 4 - Escolher um labirinto txt criado                  |");
        System.out.println("| 5 - Apague um labirinto                               |");
        System.out.println("| 0 - Sair do programa                                  |");
        System.out.println("|                                                       |");
        System.out.println("|-------------------------------------------------------|");
        System.out.println("");
    }
    
    public static void delete() {
    	File arquivos[];
    	File arquivo = new File("C:\\Users\\lucas\\Desktop\\Faculdade\\JAVA\\ProjetoLPOO");
        arquivos = arquivo.listFiles();
        for(int i = 0; i < arquivos.length; i++){
            System.out.println(arquivos[i].getName());
        }
        System.out.print("Escolha um dos labirintos acima: ");
        s.nextLine();
        File file = new File(s.nextLine());
        file.delete();
        
    }
    public static Labirinto escolha() {
    	 try {
    	String nome = "";
    	File arquivos[];
    	File arquivo = new File("C:\\Users\\lucas\\Desktop\\Faculdade\\JAVA\\ProjetoLPOO\\src\\LabirintosTxt");
        arquivos = arquivo.listFiles();

        for(int i = 0; i < arquivos.length; i++){
            System.out.println(arquivos[i].getName());
        }

        System.out.println();
        s.nextLine();
        System.out.print("Escolha um dos labirintos acima: ");
        String file = s.nextLine();

        for(int i = 0; i < arquivos.length; i++){
            if (arquivos[i].getName().equals(file)) {
                file = arquivos[i].getAbsolutePath();
                nome = arquivos[i].getName();
            }
        }

			labirinto = new Labirinto(file);
		} catch (Exception e) {
			System.out.println("O arquivo nao foi encontrado1!!");
			
		}
        System.out.println();
        
        return labirinto;
        
    }
    
    public static Labirinto nova_escolha() {
   	 try {
   	String nome = "";
   	File arquivos[];
       File arquivo = new File("C:\\Users\\lucas\\Desktop\\Faculdade\\JAVA\\ProjetoLPOO");
       arquivos = arquivo.listFiles();
      
       for(int i = 0; i < arquivos.length; i++){
           System.out.println(arquivos[i].getName());
       }

       System.out.println();
       s.nextLine();
       System.out.print("Escolha um dos labirintos acima: ");
       String file = s.nextLine();

       for(int i = 0; i < arquivos.length; i++){
           if (arquivos[i].getName().equals(file)) {
               file = arquivos[i].getAbsolutePath();
               nome = arquivos[i].getName();
           }
       }
			labirinto = new Labirinto(file);
		} catch (Exception e) {
			System.out.println("O arquivo nao foi encontrado1!!");
	
		}
       System.out.println();
       
       return labirinto;
       
   }
    
    public static void resolver() {
    	  try {
    		  labirinto.resolveLabirinto();
    		  labirinto.draw();
		      System.out.println("O programa foi resolvido !!");
			
    	  } catch (Exception e) {
    		  System.out.println("O programa nao pode ser resolvido !!");
    
    	  }
    }
 }
    