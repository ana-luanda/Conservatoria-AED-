package arranca;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class InterfaceGrafica extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton registrar, busca, eliminacacao, imprimir_todos;
	private TextArea mostrar;
	private JLabel mensagem;
	private JPanel p1, p2, p3, p4, p5;
	private JMenuBar menubr;
	private JMenu menu1, menu2;
	private JMenuItem sair;

	public InterfaceGrafica() {
		// TODO Auto-generated constructor stub

		menubr = new JMenuBar();
		menu1 = new JMenu("Opções");
		menu2 = new JMenu("Sobre");
		sair = new JMenuItem("Sair");
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p4 = new JPanel();
		p5 = new JPanel();
		registrar = new JButton("Registrar");
		busca = new JButton("Busca");
		eliminacacao = new JButton("Eliminação");
		imprimir_todos = new JButton("Imprimir Todos");
		mostrar = new TextArea("Mostrar", 9, 29, TextArea.SCROLLBARS_VERTICAL_ONLY);
		mensagem = new JLabel("CONSERVATORIA");

		this.setTitle("Trabalho Prático 1");
		this.setSize(380, 250);
		this.setLocation(80, 80);
		JFrame.setDefaultLookAndFeelDecorated(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		sair.setAccelerator(
				javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.ALT_MASK));

		sair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});

		menu1.add(sair);
		menubr.add(menu1);
		menubr.add(menu2);

		p1.setLayout(new FlowLayout(FlowLayout.CENTER));
		p1.add(mensagem);

		p2.setLayout(new BoxLayout(p2, BoxLayout.Y_AXIS));
		p2.add(registrar);
		p2.add(busca);
		p2.add(eliminacacao);
		p2.add(imprimir_todos);

		p3.setLayout(new BorderLayout());
		p3.add("Center", mostrar);

		p4.setLayout(new FlowLayout(FlowLayout.CENTER));
		p4.setBackground(Color.black);

		mostrar.setSize(2, MAXIMIZED_VERT);
		mostrar.setText("Mostrar");
		p5.setLayout(new FlowLayout(FlowLayout.RIGHT));
		p5.add(mostrar);

		this.setJMenuBar(menubr);
		this.setResizable(false);
		this.add(BorderLayout.NORTH, p1);
		this.add(BorderLayout.WEST, p2);
		this.add(BorderLayout.EAST, p5);
		this.add(BorderLayout.SOUTH, p4);
		this.setVisible(true);

	}

}
