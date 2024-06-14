package arranca;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import classes.Registro;
import listaLigada.ListaLigada;

public class ActualizarRegistro extends JInternalFrame {

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

	public ActualizarRegistro(int posic, ListaLigada lista) {
		this.a = lista;
		setBounds(100, 50, 450, 620);
		setClosable(true);
		setIconifiable(true);
		setResizable(false);
		setTitle("Atualizar Registro");

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
		textField_cod.setText(((Registro) a.pega(posic)).getCodigo());
		textField_cod.setEditable(false);
		panel_5.add(textField_cod);

		JPanel panel_6 = new JPanel();
		panel_6.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		panel_6.add(labelNome);
		textField_nome.setText(((Registro) a.pega(posic)).getNome());
		panel_6.add(textField_nome);

		JPanel panel_7 = new JPanel();
		panel_7.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		panel_7.add(labelApelido);
		textField_apelido.setText(((Registro) a.pega(posic)).getApelido());
		panel_7.add(textField_apelido);

		JPanel panel_8 = new JPanel();
		panel_8.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		panel_8.add(labelOutros);
		textField_outrosNomes.setText(((Registro) a.pega(posic)).getOutrosNomes());
		panel_8.add(textField_outrosNomes);

		JPanel panel_9 = new JPanel();
		panel_9.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		panel_9.add(labelSexo);
		panel_9.add(radio_mas);
		panel_9.add(radio_fem);
		if (((Registro) a.pega(posic)).getSexo().equals("Masculino")) {
			radio_mas.setSelected(true);
			radio_fem.setSelected(false);
			radio_mas.setEnabled(false);
			radio_fem.setEnabled(false);
		} else {
			radio_fem.setSelected(true);
			radio_mas.setSelected(false);
			radio_mas.setEnabled(false);
			radio_fem.setEnabled(false);
		}

		JPanel panel_10 = new JPanel();
		panel_10.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		panel_10.add(labelRaca);
		panel_10.add(comboBox_raca);
		comboBox_raca.setSelectedItem(((Registro) a.pega(posic)).getRaca());
		comboBox_raca.setEditable(false);
		comboBox_raca.setEnabled(false);
		

		JPanel panel_11 = new JPanel();
		panel_11.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		panel_11.add(labelIdade);
		textField_idade.setText(Integer.toString(((Registro) a.pega(posic)).getIdade()));
		panel_11.add(textField_idade);

		JPanel panel_12 = new JPanel();
		panel_12.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		panel_12.add(labelCorCabelo);
		comboBox_corCabelos.setSelectedItem(((Registro) a.pega(posic)).getCorDosCabelos());
		panel_12.add(comboBox_corCabelos);

		JPanel panel_13 = new JPanel();
		panel_13.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		panel_13.add(labelCorOlho);
		comboBox_corOlhos.setSelectedItem(((Registro) a.pega(posic)).getCorDosOlhos());
		panel_13.add(comboBox_corOlhos);

		JPanel panel_14 = new JPanel();
		panel_14.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		panel_14.add(labelFormatNariz);
		comboBox_formatNariz.setSelectedItem(((Registro) a.pega(posic)).getFormatoDoNariz());
		panel_14.add(comboBox_formatNariz);

		JPanel panel_15 = new JPanel();
		panel_15.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		panel_15.add(labelBIPai);
		textField_bi_pai.setText(((Registro) a.pega(posic)).getBIdoPai());
		panel_15.add(textField_bi_pai);
		textField_bi_pai.setEditable(false);
		

		JPanel panel_16 = new JPanel();
		panel_16.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		panel_16.add(labelBIMae);
		textField_bi_mae.setText(((Registro) a.pega(posic)).getBIdaMae());
		panel_16.add(textField_bi_mae);
		textField_bi_mae.setEditable(false);

		JPanel panel_17 = new JPanel();
		panel_17.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		panel_17.add(labelNacionalidade);
		textField_nacionalidade.setText(((Registro) a.pega(posic)).getNacionalidade());
		panel_17.add(textField_nacionalidade);
		textField_nacionalidade.setEditable(false);

		JPanel panel_18 = new JPanel();
		panel_18.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		panel_18.add(labelResidencia);
		textField_residencia.setText(((Registro) a.pega(posic)).getResidencia());
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
		//
		JButton buttonAtualizar = new JButton("Atualizar");
		panel_19.add(buttonAtualizar);
		buttonAtualizar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try{
					String nome = textField_nome.getText().trim();
					String apelido = textField_apelido.getText().trim(); 
					int idade = Integer.parseInt(textField_idade.getText().trim());
					String bi_pai = textField_bi_pai.getText().trim();
					String bi_mae = textField_bi_mae.getText().trim();
					String nacionalidade = textField_nacionalidade.getText().trim();
					String residencia = textField_residencia.getText().trim();
					String sexo = "";
					if (radio_mas.isSelected())
						sexo = radio_mas.getText();
					else
						sexo = radio_fem.getText();
					setLi(lista);
					a.removePosicao(posic);
					a.adicionaPosicao(posic, new Registro(textField_cod.getText(), textField_nome.getText(),
							textField_apelido.getText(), textField_outrosNomes.getText(),
							Integer.parseInt(textField_idade.getText()), sexo, comboBox_raca.getSelectedItem().toString(),
							comboBox_corCabelos.getSelectedItem().toString(),
							comboBox_corOlhos.getSelectedItem().toString(),
							comboBox_formatNariz.getSelectedItem().toString(), textField_bi_pai.getText(),
							textField_bi_mae.getText(), textField_nacionalidade.getText(), textField_residencia.getText()));
					setLi(a);

					JOptionPane.showMessageDialog(null, "Atualizou com sucesso");
					
				}catch(NumberFormatException erro){
					JOptionPane.showMessageDialog(null, "Campo Idade Invalido, insira somente numero");
				}

			}
		});
		//

		setVisible(true);
	}

	public void setLi(ListaLigada l) {
		this.a = l;
	}

	public ListaLigada getLi() {
		return a;
	}

}
