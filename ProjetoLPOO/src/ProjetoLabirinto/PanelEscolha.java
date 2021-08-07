package ProjetoLabirinto;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.FileFilter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.text.Caret;


import javax.swing.JTextPane;
import javax.swing.JTable;

public class PanelEscolha extends JPanel {
	private static JTextField txtEscolhaUmTxt;
	private static Labirinto labirinto;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public PanelEscolha() {
		
		setBounds(0, 0, 271, 278);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 235, 227, 32);
		add(panel);
		
	
		JList list = new JList();
		File arquivos[];
		File arquivo = new File("C:\\Users\\lucas\\Desktop\\Faculdade\\JAVA\\ProjetoLPOO\\src\\LabirintosTxt");
		arquivos = arquivo.listFiles();
		list.setBounds(10, 11, 251, 213);
		DefaultListModel DLM = new DefaultListModel();
			for(int i = 0; i < arquivos.length; i++) {
			DLM.addElement(arquivos[i].getName());
		}
			list.setModel(DLM);
		add(list);
		
		txtEscolhaUmTxt = new JTextField();
		txtEscolhaUmTxt.setColumns(10);
		txtEscolhaUmTxt.setHorizontalAlignment(SwingConstants.LEFT);
		panel.add(txtEscolhaUmTxt);
				
		JButton btnNewButton = new JButton("Resolver");
		btnNewButton.setHorizontalAlignment(SwingConstants.RIGHT);
		btnNewButton.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				labirinto = escolha();
				try {
					labirinto.resolveLabirinto();
					labirinto.draw();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		panel.add(btnNewButton);
		
	}
	public static Labirinto escolha() {
		File arquivos[];
		File arquivo = new File("C:\\Users\\lucas\\Desktop\\Faculdade\\JAVA\\ProjetoLPOO\\src\\LabirintosTxt");
		arquivos = arquivo.listFiles();
		try {
			String file = txtEscolhaUmTxt.getText();
			
			for(int i = 0; i < arquivos.length; i++){
	            if (arquivos[i].getName().equals(file)) {
	                file = arquivos[i].getAbsolutePath();
	            }
	        }
			labirinto = new Labirinto(file);
			labirinto.draw();
			} catch (Exception E) {
				JOptionPane.showConfirmDialog(null, "O arquivo não foi encontrado");
				
			}
       
       return labirinto;
       
   }
}
