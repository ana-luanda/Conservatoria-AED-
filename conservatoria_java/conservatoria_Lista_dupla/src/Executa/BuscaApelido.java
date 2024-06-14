package arranca;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.util.Enumeration;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import classes.Registro;
import listaLigada.ListaLigada;

public class BuscaApelido extends JInternalFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BuscaApelido(ListaLigada lista) {
//		setBounds(100, 100, 333, 117);
		setTitle("BUSCA PELO APELIDO");
		setClosable(true);
		setIconifiable(true);
		setResizable(false);

		JPanel panel = new JPanel();
		// getContentPane().add(panel, BorderLayout.NORTH);

		JLabel label = new JLabel("BUSCA PELO APELIDO");
		getContentPane().add(panel, BorderLayout.PAGE_START);
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel.add(label);

		String[] columns = { "CODIGO", "NOME", "APELIDO", "OUTROS OS NOMES", "IDADE", "SEXO", "RACA", "COR DOS CABELOS",
				"COR DOS OLHOS", "FORMATO DO NARIZ", "B.I DO PAI", "B.I DA MAE", "NACIONALIDADE", "RESIDENCIA" };


		Object [][]regista = new Object[lista.tamanho()][14];

		
		for(int i = 0; i < lista.tamanho(); i++){
			
			regista[i][0] = ((Registro) lista.pega(i)).getCodigo();
			regista[i][1] = ((Registro) lista.pega(i)).getNome();
			regista[i][2] = ((Registro) lista.pega(i)).getApelido();
			regista[i][3] = ((Registro) lista.pega(i)).getOutrosNomes();
			regista[i][4] = ((Registro) lista.pega(i)).getIdade();
			regista[i][5] = ((Registro) lista.pega(i)).getSexo();
			regista[i][6] = ((Registro) lista.pega(i)).getRaca();
			regista[i][7] = ((Registro) lista.pega(i)).getCorDosCabelos();
			regista[i][8] = ((Registro) lista.pega(i)).getCorDosOlhos();
			regista[i][9] = ((Registro) lista.pega(i)).getFormatoDoNariz();
			regista[i][10] = ((Registro) lista.pega(i)).getBIdoPai();
			regista[i][11] = ((Registro) lista.pega(i)).getBIdaMae();
			regista[i][12] = ((Registro) lista.pega(i)).getNacionalidade();
			regista[i][13] = ((Registro) lista.pega(i)).getResidencia();

			
			
		}

		JTable table = new JTable(regista, columns);
		table.setFillsViewportHeight(true);
		table.setEnabled(false);
		table.setToolTipText("BUSCA PELO APELIDO");
		table.setAlignmentY(CENTER_ALIGNMENT);
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setSize(550, 100);
		table.setFillsViewportHeight(true);
		int width = 0;
		TableColumnModel tcm = table.getColumnModel();
		Enumeration<TableColumn> e = tcm.getColumns();
		while(e.hasMoreElements()){
			TableColumn tc = (TableColumn) e.nextElement();
			width += tc.getPreferredWidth();
		}
		
		int height = table.getRowCount() * (table.getRowHeight() + 1);
		
		table.setPreferredScrollableViewportSize(new Dimension(width,height));

		
//		texto.setFont(new Font("Arial", Font.TRUETYPE_FONT, 24));

		JPanel panel_1 = new JPanel();
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.add(scrollPane);
		setSize(width, height+100);
		this.setVisible(true);
	}

}
