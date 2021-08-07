package ProjetoLabirinto;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Formatter;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PanelCriar extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private static Formatter saida;
	/**
	 * Create the panel.
	 */
	public PanelCriar() {

		setBounds(0, 0, 271, 278);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 227, 271, 51);
		add(panel);
		panel.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 11, 120, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Criar");
		btnNewButton.setBounds(150, 10, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
					String filename = textField.getText();
					try {
						BufferedWriter labArq = new BufferedWriter(new FileWriter(filename));
						saida = new Formatter(filename);
					} catch (IOException fileNotFoundException) {
						JOptionPane.showConfirmDialog(null, "Erro ao abrir o arquivo");
					}
			}
		});
		panel.add(btnNewButton);
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 11, 251, 205);
		add(panel_1);
		panel_1.setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 11, 109, 23);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Quantide de linhas");
		btnNewButton_1.setBounds(10, 43, 231, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String linhasQtd = textField_1.getText();

			}	
		});
		
		panel_1.add(btnNewButton_1);
		
		textField_2 = new JTextField();
		textField_2.setBounds(10, 75, 109, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("Adicionar dados");
		btnNewButton_2.setBounds(10, 106, 231, 23);
		panel_1.add(btnNewButton_2);
		
	
		
		
	}

}
