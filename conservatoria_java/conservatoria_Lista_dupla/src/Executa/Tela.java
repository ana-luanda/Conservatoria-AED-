package arranca;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import listaLigada.ListaLigada;
import classes.Registro;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JDesktopPane;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tela extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	ListaLigada a = new ListaLigada();

	public Tela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("CONSERVATORIA");
		setExtendedState(JFrame.MAXIMIZED_BOTH);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel painelCentro = new JPanel();
		contentPane.add(painelCentro, BorderLayout.CENTER);
		painelCentro.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		painelCentro.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		JDesktopPane desktopPane = new JDesktopPane();
		panel.add(desktopPane);

		JPanel painelSul = new JPanel();
		contentPane.add(painelSul, BorderLayout.SOUTH);

		JLabel lblNewLabel = new JLabel("@2017-Grupo III");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		painelSul.add(lblNewLabel);

		JMenuBar menuBar = new JMenuBar();
		// panel_2.add(menuBar);

		JMenu inserir = new JMenu("Registo de Nascimento |");
		menuBar.add(inserir);

		JMenuItem menuInserirInicio = new JMenuItem("Criar novo registro");
		menuInserirInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				NovoRegistro i = new NovoRegistro(a);
				a = i.getLi();
				desktopPane.add(i);
				i.setVisible(true);

			}
		});
		inserir.add(menuInserirInicio);

		// JMenuItem menuInserirPosicao = new JMenuItem("Em uma posicao");
		// menuInserirPosicao.addActionListener(new ActionListener() {
		// public void actionPerformed(ActionEvent arg0) {
		// InserirPosicao i = new InserirPosicao();
		// desktopPane.add(i);
		// i.setVisible(true);
		// }
		// });
		// inserir.add(menuInserirPosicao);
		//
		// JMenuItem menuInserirFim = new JMenuItem("No Fim");
		// menuInserirFim.addActionListener(new ActionListener() {
		// public void actionPerformed(ActionEvent arg0) {
		// InserirFim i = new InserirFim();
		// desktopPane.add(i);
		// i.setVisible(true);
		// }
		// });
		// inserir.add(menuInserirFim);

		JMenu busca = new JMenu("| Busca de Registo |");
		menuBar.add(busca);

		JMenuItem menuBuscaCod = new JMenuItem("Pelo código");
		JMenuItem menuBuscaApelido = new JMenuItem("Pelo Apelido");
		JMenuItem menuBuscaNomeCompleto = new JMenuItem("Pelo Nome Completo");

		busca.add(menuBuscaCod);
		busca.addSeparator();
		busca.add(menuBuscaApelido);
		busca.addSeparator();
		busca.add(menuBuscaNomeCompleto);

		menuBuscaCod.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(a.tamanho() != 0){

					try{
						String codig = JOptionPane.showInputDialog("Insira o codigo");
						boolean encontrou = false;

						for (int i = 0; i < a.tamanho(); i++) {
							if (((Registro) a.pega(i)).getCodigo().equals(codig)) {
								System.out.println("\nBusca Codigo");
								System.out.println(((Registro) a.pega(i)).toString());
								BuscaCod bc = new BuscaCod(((Registro) a.pega(i)));
								desktopPane.add(bc);
								bc.setVisible(true);
								encontrou = true;
								
								break;
							}

						}
						if(encontrou == false){
							JOptionPane.showMessageDialog(null, "Não encontrou");
						}
					}catch(NullPointerException erro){
						
						
					}
				}else{
					JOptionPane.showMessageDialog(null, "Estrutura Vazia");
				}
			}
		});

		menuBuscaApelido.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(a.tamanho() != 0){
					try{
						Boolean encontrou = false;
						String apelido = JOptionPane.showInputDialog("Insira o apelido").trim();
						ListaLigada apelidos = new ListaLigada();
						for (int i = 0; i < a.tamanho(); i++) {
							if (((Registro) a.pega(i)).getApelido().equals(apelido)) {
								System.out.println("\nBusca Apelido");
								System.out.println(((Registro) a.pega(i)).toString());
								apelidos.adicionaFim(((Registro) a.pega(i)));
								encontrou  = true;
								
							}

						}
						if(encontrou == true){

							BuscaApelido ba = new BuscaApelido(apelidos);
							desktopPane.add(ba);
							ba.setVisible(true);
						}else{
							JOptionPane.showMessageDialog(null, "Não encontrou");
						}
					}catch(NullPointerException erro){
						
					}
				}else{
					JOptionPane.showMessageDialog(null, "Estrutura Vazia");
				}
			}
		});

		menuBuscaNomeCompleto.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(a.tamanho() != 0){
					try{
						String nome_completo = JOptionPane.showInputDialog("Insira o nome completo").trim();
						System.out.println(nome_completo.toString());
						boolean encontrou = false;
						ListaLigada nomes_completos = new ListaLigada();

						String[] nomes = nome_completo.split(" ");

						if (nome_completo.equals("") || nomes.length == 1) {
							JOptionPane.showMessageDialog(null, "Por favor, insira o nome completo");
							menuBuscaNomeCompleto.doClick();

						}
						if (nomes.length == 2) {
							for (int i = 0; i < a.tamanho(); i++) {
								if (nomes[0].equals(((Registro) a.pega(i)).getNome())
										&& nomes[1].equals(((Registro) a.pega(i)).getApelido()) && (((Registro) a.pega(i)).getOutrosNomes().equals(null) || ((Registro) a.pega(i)).getOutrosNomes().trim().equals(""))  ) {
									System.out.println("\nBusca pelo nome completo");
									System.out.println(((Registro) a.pega(i)).toString());
									nomes_completos.adicionaFim(((Registro) a.pega(i)));
									encontrou= true;
								}
							}

						} else {

							String outrosNomes = "";

							for (int j = 1; j < nomes.length - 1; j++) {

								outrosNomes = outrosNomes.concat(nomes[j]);

							}
							for (int i = 0; i < a.tamanho(); i++) {
								if (nomes[0].equals(((Registro) a.pega(i)).getNome())
										&& nomes[nomes.length - 1].equals(((Registro) a.pega(i)).getApelido())
										&& outrosNomes.equals(((Registro) a.pega(i)).getOutrosNomes())) {
									System.out.println("\nBusca pelo nome completo");
									System.out.println(((Registro) a.pega(i)).toString());
									nomes_completos.adicionaFim(((Registro) a.pega(i)));
									encontrou = true;
								}
							}

						}
						if(encontrou == false){
							
							JOptionPane.showMessageDialog(null, "Não encontrou");
						}else{
							BuscaNomeCompleto bnc = new BuscaNomeCompleto(nomes_completos);
							desktopPane.add(bnc);
							bnc.setVisible(true);
						}
						
					}catch(NullPointerException erro){
						
					}
				}else{
					JOptionPane.showMessageDialog(null, "Estrutura Vazia");
				}

			}
		});

		JMenu actualizar = new JMenu("| Alteração de um registo |");
		menuBar.add(actualizar);

		JMenuItem menuNome = new JMenuItem("Busca pelo código");
		menuNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(a.tamanho() != 0){
					boolean op = true;
					try{
						String codig = JOptionPane.showInputDialog("Insira o codigo:");
						boolean encontrou = false;

						for (int i = 0; i < a.tamanho(); i++) {
							if (((Registro) a.pega(i)).getCodigo().equals(codig)) {
								ActualizarRegistro o = new ActualizarRegistro(i, a);

								setListaNova(o.getLi());
								desktopPane.add(o);
								o.setVisible(true);
								System.out.println(a.toString());
								encontrou = true;
								op = false;
								break;
							}

						}
						
						if(encontrou == false){
							if( op == false){
								JOptionPane.showMessageDialog(null, "Não Encontrou");
							}
						}
						
					}catch(NullPointerException erro){
						
					}
				}else{
					JOptionPane.showMessageDialog(null, "Estrutura Vazia");
				}
			}
		});
		actualizar.add(menuNome);

		JMenu remover = new JMenu("| Eliminiação de um registo|");
		menuBar.add(remover);

		JMenuItem menuRemoverPosicao = new JMenuItem("Numa dada posição");
		remover.add(menuRemoverPosicao);
		menuRemoverPosicao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(a.tamanho() != 0){
					a.removePosicao(Integer.parseInt(JOptionPane.showInputDialog("Insira a posicao")));
					System.out.println(a.toString());

					JOptionPane.showMessageDialog(null, "Eliminou com sucesso");
				}else{
					JOptionPane.showMessageDialog(null, "Estrutura Vazia");
				}
				

			}
		});

		JMenuItem menuRemoverComCod = new JMenuItem("Com certo código");
		remover.add(menuRemoverComCod);
		menuRemoverComCod.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(a.tamanho() != 0){
					try{
						String codig = JOptionPane.showInputDialog("Insira o codigo");
						boolean encontrou = false;

						for (int i = 0; i < a.tamanho(); i++) {
							if (((Registro) a.pega(i)).getCodigo().equals(codig)) {
								a.removePosicao(i);
								System.out.println(a.toString());

								JOptionPane.showMessageDialog(null, "Removeu na Posicao desejada");
								encontrou = true;
								break;
							}

						}
						if(encontrou == false){
							JOptionPane.showMessageDialog(null, "Nao encontrou");
							
						}
						
					}catch(NullPointerException erro){
						
					}
				}else{
					JOptionPane.showMessageDialog(null, "Estrutura Vazia");
				}

			}
		});

		JMenu imprimir = new JMenu("| Imprimir |");
		menuBar.add(imprimir);

		JMenuItem menuImprimirTodos = new JMenuItem("Todos os registos");
		imprimir.add(menuImprimirTodos);
		menuImprimirTodos.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(a.tamanho() != 0){
					Imprimir imp = new Imprimir(a);
					desktopPane.add(imp);
					imp.setVisible(true);
					System.out.println(a.toString());
				}else{
					JOptionPane.showMessageDialog(null, "Estrutra Vazia");
				}

			}
		});

		JMenuItem menuImprimirNomes = new JMenuItem("registos ordenados por idade");
		imprimir.add(menuImprimirNomes);

		menuImprimirNomes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(a.tamanho() != 0){
					ImprimirOrdenadosIdade impi = new ImprimirOrdenadosIdade(a);
					desktopPane.add(impi);
					impi.setVisible(true);
				}else{
					JOptionPane.showMessageDialog(null, "Estrutra Vazia");
				}

			}
		});

		JMenuItem menuImprimirIdade = new JMenuItem("registos com o mesmo apelido");
		imprimir.add(menuImprimirIdade);
		menuImprimirIdade.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// a.imprimirMesmaIdade();
				if(a.tamanho() != 0){
					ImprimirMesmosApelidos impi = new ImprimirMesmosApelidos(a);
					desktopPane.add(impi);
					impi.setVisible(true);
				}else{
					JOptionPane.showMessageDialog(null, "Estrutra Vazia");
				}

			}
		});

		JMenu sair = new JMenu("Sair");
		menuBar.add(sair);

		JMenuItem menuSair = new JMenuItem("Sair");
		menuSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		sair.add(menuSair);
		setJMenuBar(menuBar);

		setVisible(true);
	}

	public void setListaNova(ListaLigada listaNova) {
		this.a = listaNova;
	}

	public ListaLigada getListaNova() {
		return a;
	}

}
