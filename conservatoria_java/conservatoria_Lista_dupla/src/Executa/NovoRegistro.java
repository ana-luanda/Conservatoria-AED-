package arranca;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import classes.Registro;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import listaLigada.ListaLigada;
import java.awt.FlowLayout;
import javax.swing.JRadioButton;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class NovoRegistro extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ButtonGroup grupo;
	private JRadioButton radio_mas, radio_fem;
	private JComboBox<String> comboBox_raca, comboBox_corCabelos, comboBox_corOlhos, comboBox_formatNariz;
	ListaLigada a = new ListaLigada();

	private JTextField textField_cod;
	private JTextField textField_nome;
	private JTextField textField_apelido;
	private JTextField textField_outrosNomes;
	private JTextField textField_idade;
	private JTextField textField_bi_pai;
	private JTextField textField_bi_mae;
	private JTextField textField_nacionalidade;
	private JTextField textField_residencia;

	public NovoRegistro(ListaLigada ligados) {
		setBounds(100, 50, 450, 620);
		setClosable(true);
		setIconifiable(true);
		setResizable(false);
		setTitle("Novo registro");
		this.a = ligados;

		JLabel labelCod = new JLabel("Código:");
		JLabel labelNome = new JLabel("Nome:");
		JLabel labelApelido = new JLabel("Apelido:");
		JLabel labelOutros = new JLabel("Outros Nomes:");
		JLabel labelSexo = new JLabel("Sexo:");
		JLabel labelRaca = new JLabel("Raça:");
		JLabel labelIdade = new JLabel("Idade:");
		JLabel labelCorCabelo = new JLabel("Cor de Cabelo:");
		JLabel labelCorOlho = new JLabel("Cor do Olho:");
		JLabel labelFormatNariz = new JLabel("Format Nariz:");
		JLabel labelBIPai = new JLabel("BI do Pai:");
		JLabel labelBIMae = new JLabel("BI da Mãe:");
		JLabel labelNacionalidade = new JLabel("Nacionalidade:");
		JLabel labelResidencia = new JLabel("Residencia:");
		String[] raca = { "Negro", "Branco" };
		String[] corCabelo = { "Moreno", "Loiro", "Ruivo" };
		String[] corOlho = { "Castanho", "Verde", "Azul", "Cinza", "Preto" };
		String[] formatoNariz = { "Inclindado", "Empinado", "Achatado" };

		grupo = new ButtonGroup();
		radio_mas = new JRadioButton("Masculino");
		radio_fem = new JRadioButton("Feminino");
		comboBox_raca = new JComboBox<String>(raca);
		comboBox_corCabelos = new JComboBox<String>(corCabelo);
		comboBox_corOlhos = new JComboBox<String>(corOlho);
		comboBox_formatNariz = new JComboBox<String>(formatoNariz);

		textField_cod = new JTextField(10);
		textField_nome = new JTextField(10);
		textField_apelido = new JTextField(10);
		textField_outrosNomes = new JTextField(10);
		textField_idade = new JTextField(10);
		textField_bi_pai = new JTextField(10);
		textField_bi_mae = new JTextField(10);
		textField_nacionalidade = new JTextField(10);
		textField_residencia = new JTextField(10);

		grupo.add(radio_mas);
		grupo.add(radio_fem);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);

		JLabel label = new JLabel("Insira os dados");
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel.add(label);

		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.WEST);

		JPanel panel_5 = new JPanel();
		panel_5.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		panel_5.add(labelCod);
		panel_5.add(textField_cod);

		JPanel panel_6 = new JPanel();
		panel_6.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		panel_6.add(labelNome);
		panel_6.add(textField_nome);

		JPanel panel_7 = new JPanel();
		panel_7.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		panel_7.add(labelApelido);
		panel_7.add(textField_apelido);

		JPanel panel_8 = new JPanel();
		panel_8.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		panel_8.add(labelOutros);
		panel_8.add(textField_outrosNomes);

		JPanel panel_9 = new JPanel();
		panel_9.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		panel_9.add(labelSexo);
		panel_9.add(radio_mas);
		panel_9.add(radio_fem);

		JPanel panel_10 = new JPanel();
		panel_10.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		panel_10.add(labelRaca);
		panel_10.add(comboBox_raca);

		JPanel panel_11 = new JPanel();
		panel_11.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		panel_11.add(labelIdade);
		panel_11.add(textField_idade);

		JPanel panel_12 = new JPanel();
		panel_12.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		panel_12.add(labelCorCabelo);
		panel_12.add(comboBox_corCabelos);

		JPanel panel_13 = new JPanel();
		panel_13.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		panel_13.add(labelCorOlho);
		panel_13.add(comboBox_corOlhos);

		JPanel panel_14 = new JPanel();
		panel_14.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		panel_14.add(labelFormatNariz);
		panel_14.add(comboBox_formatNariz);

		JPanel panel_15 = new JPanel();
		panel_15.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		panel_15.add(labelBIPai);
		panel_15.add(textField_bi_pai);

		JPanel panel_16 = new JPanel();
		panel_16.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		panel_16.add(labelBIMae);
		panel_16.add(textField_bi_mae);

		JPanel panel_17 = new JPanel();
		panel_17.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		panel_17.add(labelNacionalidade);
		panel_17.add(textField_nacionalidade);

		JPanel panel_18 = new JPanel();
		panel_18.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		panel_18.add(labelResidencia);
		panel_18.add(textField_residencia);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
		panel_2.add(panel_5);
		panel_2.add(panel_6);
		panel_2.add(panel_7);
		panel_2.add(panel_8);
		panel_2.add(panel_9);
		panel_2.add(panel_10);
		panel_2.add(panel_11);
		panel_2.add(panel_12);
		panel_2.add(panel_13);
		panel_2.add(panel_14);
		panel_2.add(panel_15);
		panel_2.add(panel_16);
		panel_2.add(panel_17);
		panel_2.add(panel_18);

		JPanel panel_4 = new JPanel();
		panel_4.add(panel_2);

		panel_1.add(panel_4);

		
		JPanel panel_19 = new JPanel();
		getContentPane().add(panel_19, BorderLayout.SOUTH);
		
		JButton buttonInserir = new JButton("Inserir");
		panel_19.add(buttonInserir);
		

		buttonInserir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try{
					try {

						Boolean nome = textField_nome.getText().trim().equals("");
						Boolean apelido = textField_apelido.getText().trim().equals("");
						
						Boolean bi_pai = textField_bi_pai.getText().trim().equals("");
						Boolean bi_mae = textField_bi_mae.getText().trim().equals("");
						Boolean nacionalidade = textField_nacionalidade.getText().trim().equals("");
						Boolean residencia = textField_residencia.getText().trim().equals("");
						String sexo = "";
						if (radio_mas.isSelected())
							sexo = radio_mas.getText();
						else
							sexo = radio_fem.getText();
						Boolean se = sexo.equals("");
						
						
						if((nome || apelido || bi_pai || bi_mae || nacionalidade || residencia || se) == true){
							JOptionPane.showMessageDialog(null, "Complete os campos em falta");
						}else{
							String[] posicao = { "no inicio", "numa dada posicao", "no fim" };
							int idade = Integer.parseInt(textField_idade.getText().trim().trim());
							// JOptionPane.showInputDialog(p, "");
							System.out.println(comboBox_raca.getSelectedItem().toString());
							Object n = JOptionPane.showInternalInputDialog(panel, "", "", 1, null, posicao, 0);
							if (n.equals("no inicio")) {
								if (textField_outrosNomes.getText().trim().equals(null)
										|| textField_outrosNomes.getText().trim().equals("")) {
									a.adicionaInicio(new Registro(textField_cod.getText(), textField_nome.getText(),
											textField_apelido.getText(), "", Integer.parseInt(textField_idade.getText()), sexo,
											comboBox_raca.getSelectedItem().toString(),
											comboBox_corCabelos.getSelectedItem().toString(),
											comboBox_corOlhos.getSelectedItem().toString(),
											comboBox_formatNariz.getSelectedItem().toString(), textField_bi_pai.getText(),
											textField_bi_mae.getText(), textField_nacionalidade.getText(),
											textField_residencia.getText()));

								} else {

									a.adicionaInicio(new Registro(textField_cod.getText(), textField_nome.getText(),
											textField_apelido.getText(), textField_outrosNomes.getText(),
											Integer.parseInt(textField_idade.getText()), sexo,
											comboBox_raca.getSelectedItem().toString(),
											comboBox_corCabelos.getSelectedItem().toString(),
											comboBox_corOlhos.getSelectedItem().toString(),
											comboBox_formatNariz.getSelectedItem().toString(), textField_bi_pai.getText(),
											textField_bi_mae.getText(), textField_nacionalidade.getText(),
											textField_residencia.getText()));

								}

							} else {
								if (n.equals("numa dada posicao")) {
									if (textField_outrosNomes.getText().trim().equals(null)
											|| textField_outrosNomes.getText().trim().equals("")) {
										a.adicionaPosicao(Integer.parseInt(JOptionPane.showInputDialog("Insira a posicao: ")),
												new Registro(textField_cod.getText(), textField_nome.getText(),
														textField_apelido.getText(), "",
														Integer.parseInt(textField_idade.getText()), sexo,
														comboBox_raca.getSelectedItem().toString(),
														comboBox_corCabelos.getSelectedItem().toString(),
														comboBox_corOlhos.getSelectedItem().toString(),
														comboBox_formatNariz.getSelectedItem().toString(),
														textField_bi_pai.getText(), textField_bi_mae.getText(),
														textField_nacionalidade.getText(), textField_residencia.getText()));
									} else {

										a.adicionaPosicao(Integer.parseInt(JOptionPane.showInputDialog("Insira a posicao: ")),
												new Registro(textField_cod.getText(), textField_nome.getText(),
														textField_apelido.getText(), textField_outrosNomes.getText(),
														Integer.parseInt(textField_idade.getText()), sexo,
														comboBox_raca.getSelectedItem().toString(),
														comboBox_corCabelos.getSelectedItem().toString(),
														comboBox_corOlhos.getSelectedItem().toString(),
														comboBox_formatNariz.getSelectedItem().toString(),
														textField_bi_pai.getText(), textField_bi_mae.getText(),
														textField_nacionalidade.getText(), textField_residencia.getText()));

									}
								}

								else {
									if (textField_outrosNomes.getText().trim().equals(null)
											|| textField_outrosNomes.getText().trim().equals("")) {
										a.adicionaFim(new Registro(textField_cod.getText(), textField_nome.getText(),
												textField_apelido.getText(), "", Integer.parseInt(textField_idade.getText()),
												sexo, comboBox_raca.getSelectedItem().toString(),
												comboBox_corCabelos.getSelectedItem().toString(),
												comboBox_corOlhos.getSelectedItem().toString(),
												comboBox_formatNariz.getSelectedItem().toString(), textField_bi_pai.getText(),
												textField_bi_mae.getText(), textField_nacionalidade.getText(),
												textField_residencia.getText()));
									} else {
										a.adicionaFim(new Registro(textField_cod.getText(), textField_nome.getText(),
												textField_apelido.getText(), textField_outrosNomes.getText(),
												Integer.parseInt(textField_idade.getText()), sexo,
												comboBox_raca.getSelectedItem().toString(),
												comboBox_corCabelos.getSelectedItem().toString(),
												comboBox_corOlhos.getSelectedItem().toString(),
												comboBox_formatNariz.getSelectedItem().toString(), textField_bi_pai.getText(),
												textField_bi_mae.getText(), textField_nacionalidade.getText(),
												textField_residencia.getText()));
									}
								}

							}

							JOptionPane.showMessageDialog(null, "Adicionou com sucesso");
							System.out.println("Tamanho: " + a.tamanho());
							System.out.println(a.toString());
							textField_cod.setText("");
							textField_nome.setText("");
							textField_apelido.setText("");
							textField_outrosNomes.setText("");
							textField_idade.setText("");
							textField_bi_pai.setText("");
							textField_bi_mae.setText("");
							textField_nacionalidade.setText("");
							textField_residencia.setText("");

							setLi(a);
						}
					

					} catch (NumberFormatException erro) {
						JOptionPane.showMessageDialog(null, "Campo Idade Invalido, insira somente numero");
					}
				}catch(NullPointerException err){
					
				}

			}
		});

		setVisible(true);
	}

	public void setLi(ListaLigada l) {
		this.a = l;
	}

	public ListaLigada getLi() {
		return a;
	}
	// quando foi fundada
	// quantos funcionarios twm
	// posicao que ocupada
	// quem é

}
