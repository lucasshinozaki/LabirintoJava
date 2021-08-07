package ProjetoLabirinto;

import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class PanelDelete extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public PanelDelete() {

		setBounds(0, 0, 271, 278);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 210, 271, 68);
		add(panel);
		panel.setLayout(null);
		
		JList list = new JList();
		File arquivos[];
		File arquivo = new File("C:\\Users\\lucas\\Desktop\\Faculdade\\JAVA\\ProjetoLPOO");
		arquivos = arquivo.listFiles();
		list.setBounds(10, 11, 251, 198);
		DefaultListModel DLM = new DefaultListModel();
			for(int i = 0; i<arquivos.length; i++) {
				DLM.addElement(arquivos[i].getName());
			}
		list.setModel(DLM);
		add(list);
		
		textField = new JTextField();
		textField.setBounds(10, 25, 119, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Delete txt");
		btnNewButton.setBounds(157, 24, 89, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String text = textField.getText();
				File file = new File(text);
				file.delete();
					
			}
		});
		panel.add(btnNewButton);
	}

}
