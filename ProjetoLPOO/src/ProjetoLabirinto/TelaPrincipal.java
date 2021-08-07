package ProjetoLabirinto;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import javax.swing.JLabel;

public class TelaPrincipal {

	private JFrame frame;
	private PanelEscolha panelEscolha;
	private PanelCriar panelCriar;
	private PanelEscolhaCriar panelEscolhaCriar;
	private PanelDelete panelDelete;
	private static Labirinto labirinto;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal window = new TelaPrincipal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public TelaPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.getContentPane().setLayout(null);
		
		panelEscolha = new PanelEscolha();
		panelCriar = new PanelCriar();
		panelEscolhaCriar = new PanelEscolhaCriar();
		panelDelete = new PanelDelete();

		
		JPanel paneMenu = new JPanel();
		paneMenu.setBounds(0, 0, 159, 300);
		frame.getContentPane().add(paneMenu);
		paneMenu.setLayout(null);
		
		JPanel paneEscolha = new JPanel();
		paneEscolha.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelEscolha);
			}
		
		});
		paneEscolha.setBackground(Color.LIGHT_GRAY);
		paneEscolha.setBounds(10, 11, 149, 35);
		paneMenu.add(paneEscolha);
		
		JLabel lblNewLabel = new JLabel("Escolha um labirinto txt ");
		paneEscolha.add(lblNewLabel);
		
		JPanel paneCriar = new JPanel();
		paneCriar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelCriar);
			}
		
		});
		paneCriar.setBackground(Color.LIGHT_GRAY);
		paneCriar.setBounds(10, 49, 149, 35);
		paneMenu.add(paneCriar);
		
		JLabel lblNewLabel_1 = new JLabel("Criar um novo labirinto txt");
		paneCriar.add(lblNewLabel_1);
		
		JPanel paneEscolhaCriar = new JPanel();
		paneEscolhaCriar.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelEscolhaCriar);
			}
		
		});
		paneEscolhaCriar.setBackground(Color.LIGHT_GRAY);
		paneEscolhaCriar.setBounds(10, 88, 149, 35);
		paneMenu.add(paneEscolhaCriar);
		
		JLabel lblNewLabel_2 = new JLabel("Escolha novo labirinto");
		paneEscolhaCriar.add(lblNewLabel_2);
		
		JPanel paneDelete = new JPanel();
		paneDelete.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				menuClicked(panelDelete);
			}
		
		});
		paneDelete.setBackground(Color.LIGHT_GRAY);
		paneDelete.setBounds(10, 127, 149, 35);
		paneMenu.add(paneDelete);
		
		JLabel lblNewLabel_3 = new JLabel("Apague um labirinto");
		paneDelete.add(lblNewLabel_3);
		
		
		JPanel paneSair = new JPanel();
		paneSair.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		
		});
		paneSair.setBackground(Color.LIGHT_GRAY);
		paneSair.setBounds(10, 254, 149, 35);
		paneMenu.add(paneSair);
		
		JLabel lblNewLabel_5 = new JLabel("Sair do programa");
		paneSair.add(lblNewLabel_5);
		
		
		JPanel paneMainContent = new JPanel();
		paneMainContent.setBounds(169, 11, 271, 278);
		frame.getContentPane().add(paneMainContent);
		paneMainContent.setLayout(null);
	
		paneMainContent.add(panelEscolha);
		paneMainContent.add(panelCriar);
		paneMainContent.add(panelEscolhaCriar);
		paneMainContent.add(panelDelete);
		
		menuClicked(panelEscolha);
	
	}
	
	public void menuClicked(JPanel panel) {
		panelEscolha.setVisible(false);
		panelCriar.setVisible(false);
		panelEscolhaCriar.setVisible(false);
		panelDelete.setVisible(false);
		
		panel.setVisible(true);
	}	
	
	
}
