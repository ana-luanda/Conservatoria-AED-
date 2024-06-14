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

public class BuscaCod extends JInternalFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BuscaCod(Registro registro_cod) {
//		setBounds(100, 100, 333, 117);
		setTitle("BUSCA PELO CODIGO");
		setClosable(true);
		setIconifiable(true);
		setResizable(false);

		JPanel panel = new JPanel();
		// getContentPane().add(panel, BorderLayout.NORTH);

		JLabel label = new JLabel("BUSCA PELO CODIGO");
		getContentPane().add(panel, BorderLayout.PAGE_START);
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel.add(label);

		String[] columns = { "CODIGO", "NOME", "APELIDO", "OUTROS OS NOMES", "IDADE", "SEXO", "RACA", "COR DOS CABELOS",
				"COR DOS OLHOS", "FORMATO DO NARIZ", "B.I DO PAI", "B.I DA MAE", "NACIONALIDADE", "RESIDENCIA" };


		Object [][]regista = new Object[1][14];

		
		for(int i = 0; i < 1; i++){
			
			regista[i][0] = registro_cod.getCodigo();
			regista[i][1] = registro_cod.getNome();
			regista[i][2] = registro_cod.getApelido();
			regista[i][3] = registro_cod.getOutrosNomes();
			regista[i][4] = registro_cod.getIdade();
			regista[i][5] = registro_cod.getSexo();
			regista[i][6] = registro_cod.getRaca();
			regista[i][7] = registro_cod.getCorDosCabelos();
			regista[i][8] = registro_cod.getCorDosOlhos();
			regista[i][9] = registro_cod.getFormatoDoNariz();
			regista[i][10] = registro_cod.getBIdoPai();
			regista[i][11] = registro_cod.getBIdaMae();
			regista[i][12] = registro_cod.getNacionalidade();
			regista[i][13] = registro_cod.getResidencia();

			
			
		}

		JTable table = new JTable(regista, columns);
		table.setFillsViewportHeight(true);
		table.setEnabled(false);
		table.setToolTipText("BUSCA PELO CODIGO");
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
