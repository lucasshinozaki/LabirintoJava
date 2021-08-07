package ProjetoLabirinto;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.SecurityException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CriarArquivoTxt {
	private static Formatter saida;
	private static final Scanner sc = new Scanner(System.in);
	

	public static void abrirArquivo() throws IOException {
		
		System.out.print("Nome do arquivo (com extensao): ");
		String filename = sc.nextLine(); 
		BufferedWriter labArq = new BufferedWriter(new FileWriter(filename));

		
		if (filename.endsWith(".txt")) {
			System.out.println("Arquivo criado com sucesso");
		} else {
			System.out.println("Arquivo com extensao invalida. O arquivo deve possuir extensao .txt");
			System.exit(1);
		}

		try {
			saida = new Formatter(filename);
		} catch(SecurityException securityException) {
			System.out.println("Não é possivel escrever no arquivo. Finalizado");
			System.exit(1);
		} catch(FileNotFoundException fileNotFoundException){
			System.out.println("Erro ao abrir o arquivo. Finalizado");
			System.exit(1);
		}
	}
	
	public static void adicionarDados() {
		System.out.println("Entre com a quantidade de linhas:");
		
		int linhasQtd = sc.nextInt();
		linhasQtd ++;
		while(linhasQtd != 0) {
			System.out.printf("%d : ", linhasQtd);
			try {
				saida.format("%s  %n",sc.nextLine());
			} catch(FormatterClosedException formatterClosedEXception) {
				System.out.println("Erro ao escrever no arquivo. Finalizado");
				break;
			} catch(NoSuchElementException elementException) {
				System.out.println("Entrada invalida. tente novamente");
				sc.nextLine();
			}
			linhasQtd--;
		}
		fecharArquivo();
	}
	
	
	
	public static void fecharArquivo() {
		if(saida != null)
			saida.close();
	}
}
