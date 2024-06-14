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

public class ImprimirOrdenadosIdade extends JInternalFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//Opcao decrescente ou crescente
	public ImprimirOrdenadosIdade(ListaLigada lista) {
//		setBounds(100, 100, 333, 117);
		setTitle("Imprimir Registos Ordenados Por Idade  ");
		setClosable(true);
		setIconifiable(true);
		setResizable(false);

		JPanel panel = new JPanel();
		// getContentPane().add(panel, BorderLayout.NORTH);

		JLabel label = new JLabel("REGISTOS ORDENADOS POR IDADE");
		getContentPane().add(panel, BorderLayout.PAGE_START);
		label.setFont(new Font("Tahoma", Font.BOLD, 13));
		panel.add(label);

		String[] columns = { "CODIGO", "NOME", "APELIDO", "OUTROS OS NOMES", "IDADE", "SEXO", "RACA", "COR DOS CABELOS",
				"COR DOS OLHOS", "FORMATO DO NARIZ", "B.I DO PAI", "B.I DA MAE", "NACIONALIDADE", "RESIDENCIA" };
		
		Registro []re = new Registro[lista.tamanho()];
		for(int i = 0; i < lista.tamanho();i++){
			re[i] = ((Registro) lista.pega(i));
		}
		
		for(int i = 0; i < re.length; i++){
			for(int j = i+1; j < re.length;j++){
				Registro k = null;
				if(((Registro)re[i]).getIdade() > ((Registro)re[j]).getIdade()){
					k = re[i];
					re[i] = re[j];
					re[j] = k;
					
				}
				
			}
		}
		
		
		ListaLigada nova_lista = new ListaLigada();
		for(int i = 0; i < re.length; i++){
			nova_lista.adicionaFim(re[i]);
		}
		

		Object [][]regista = new Object[lista.tamanho()][14];
//		
//		for(int i = 0; i < nova_lista.tamanho(); i++){
//			for(int j = i+1; j < nova_lista.tamanho(); j++){
//				Registro k = null;
//				int a = ((Integer)((Registro)nova_lista.pegaElemento(i)).getIdade());
//				System.out.println(a);
//				System.out.println("NUmero: "+a);
//				int b = ((Integer)((Registro)nova_lista.pegaElemento(j)).getIdade());
//				System.out.println(b);
//				System.out.println("NUmero: "+b);
//				if(a > b){
//					k = ((Registro) nova_lista.pegaElemento(i));
//					nova_lista.adicionaPosicao(i,((Registro) nova_lista.pegaElemento(j)) );
//					nova_lista.adicionaPosicao(j,k );
//				}
//				
//			}
//		}

		for(int i = 0; i < lista.tamanho(); i++){
			regista[i][0] = ((Registro) nova_lista.pega(i)).getCodigo();
			regista[i][1] = ((Registro) nova_lista.pega(i)).getNome();
			regista[i][2] = ((Registro) nova_lista.pega(i)).getApelido();
			regista[i][3] = ((Registro) nova_lista.pega(i)).getOutrosNomes();
			regista[i][4] = ((Registro) nova_lista.pega(i)).getIdade();
			regista[i][5] = ((Registro) nova_lista.pega(i)).getSexo();
			regista[i][6] = ((Registro) nova_lista.pega(i)).getRaca();
			regista[i][7] = ((Registro) nova_lista.pega(i)).getCorDosCabelos();
			regista[i][8] = ((Registro) nova_lista.pega(i)).getCorDosOlhos();
			regista[i][9] = ((Registro) nova_lista.pega(i)).getFormatoDoNariz();
			regista[i][10] = ((Registro) nova_lista.pega(i)).getBIdoPai();
			regista[i][11] = ((Registro) nova_lista.pega(i)).getBIdaMae();
			regista[i][12] = ((Registro) nova_lista.pega(i)).getNacionalidade();
			regista[i][13] = ((Registro) nova_lista.pega(i)).getResidencia();
			
		}

		JTable table = new JTable(regista, columns);
		table.setFillsViewportHeight(true);
		table.setEnabled(false);
		table.setToolTipText("REGISTROS");
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
