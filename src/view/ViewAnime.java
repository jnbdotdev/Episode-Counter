package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import connection.ConexaoBD;
import connection.ConnectionFactory;
import model.Anime;
import model.AnimeTableModel;
import model.AnimeTableModelS;
import model.AnimeTableModelT;
import model.NIT.AnimeNIT;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.text.MaskFormatter;
import javax.swing.border.LineBorder;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JToggleButton;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.JToolBar;
import javax.swing.JMenuBar;

@SuppressWarnings({ "serial", "unused" })
public class ViewAnime extends JFrame {

	ConexaoBD conecta = new ConexaoBD();
	
	private JPanel contentPane;
	private JTable table;
	private JTextField txtNome;

//==========================================================

	public String dtParaPesquisa(String data) {
			
		String dia = txtPesquisa.getText().substring(0,2);
		String mes = txtPesquisa.getText().substring(3,5);
		String ano = txtPesquisa.getText().substring(6);
		String dtPesquisa = ano+"-"+mes+"-"+dia;
		System.out.println(dtPesquisa);
			
		return dtPesquisa;
	}
//==========================================================
	

	public String dtProxEpParaMysql(String data) {
		
		String dia = txtDtProxEp.getText().substring(0,2);
		String mes = txtDtProxEp.getText().substring(3,5);
		String ano = txtDtProxEp.getText().substring(6);
		String dtProxEpToSQL = ano+"-"+mes+"-"+dia;
		System.out.println(dtProxEpToSQL);
		
		return dtProxEpToSQL;
	}
	public String dtUltEpParaMysql(String data) {
		
		String dia = txtDtUltEp.getText().substring(0,2);
		String mes = txtDtUltEp.getText().substring(3,5);
		String ano = txtDtUltEp.getText().substring(6);
		String dtUltEpParaMySQL = ano+"-"+mes+"-"+dia;
		System.out.println(dtUltEpParaMySQL);
		
		return dtUltEpParaMySQL;
	}
	public String dtLancParaMysql(String data) {
		
		String dia = txtDtLanc.getText().substring(0,2);
		String mes = txtDtLanc.getText().substring(3,5);
		String ano = txtDtLanc.getText().substring(6);
		String dtLancParaMySQL = ano+"-"+mes+"-"+dia;
		System.out.println(dtLancParaMySQL);
		
		return dtLancParaMySQL;
	}

//==========================================================

	public String dtProxEpdoMysql(String data) throws SQLException {
		
		String dia = conecta.rs.getString("dtproxep").substring(8,10);
		String mes = conecta.rs.getString("dtproxep").substring(5,7);
		String ano = conecta.rs.getString("dtproxep").substring(0,4);
		String dtProxEpdoMySQL = dia+"/"+mes+"/"+ano;
		
		return dtProxEpdoMySQL;
	}
	public String dtUltEpdoMysql(String data) throws SQLException {
	
	String dia = conecta.rs.getString("dtultep").substring(8,10);
	String mes = conecta.rs.getString("dtultep").substring(5,7);
	String ano = conecta.rs.getString("dtultep").substring(0,4);
	String dtUltEpdoMySQL = dia+"/"+mes+"/"+ano;
	
	return dtUltEpdoMySQL;
	}
	public String dtLancdoMysql(String data) throws SQLException {
	
	String dia = conecta.rs.getString("dtlancamento").substring(8,10);
	String mes = conecta.rs.getString("dtlancamento").substring(5,7);
	String ano = conecta.rs.getString("dtlancamento").substring(0,4);
	String dtLancdoMySQL = dia+"/"+mes+"/"+ano;
	
	return dtLancdoMySQL;
	}
//============================================================
	/**
	 * Launch the application.
	 */
	/*
	public void preencherTabela(String SQL) {
		ArrayList dados = new ArrayList();
		
		String[] Colunas = new String[] {"Nome", "Temporada", "Episodio"};
		
		ConnectionFactory.receberConexao();
		
		do {
			
		}while{
			
		}
	
	}
	*/
	
	
	public static void main(String[] args) {
		
		try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
        	System.err.println(ex);
        }
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewAnime frame = new ViewAnime();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/*public void readJTable() {
		AnimeTableModel model = (AnimeTableModel) table.getModel();
		
		AnimeNIT anit = new AnimeNIT();
		
		for(Anime a: anit.read()) {
			
			model.addRow(new Object[]{
			a.getNome(),
			a.getTemporada(),
			a.getEpisodio()
			});
	}
}*/
	/**
	 * Create the frame.
	 */
	
	private JTextField txtCod;
	private JTextField txtPesquisa;
	private JFormattedTextField txtDtProxEp;
	private JFormattedTextField txtDtLanc;
	private JFormattedTextField txtDtUltEp;
	
	private MaskFormatter setMascara(String mascara){
	    MaskFormatter mask = null;
	    try{
	        mask = new MaskFormatter(mascara);
	        mask.setPlaceholderCharacter('_');
	        }catch(java.text.ParseException ex){}
	    return mask;
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public ViewAnime() throws IOException{
		
		ButtonGroup buttonGroup1 = new ButtonGroup();
		ButtonGroup buttonGroup2 = new ButtonGroup();
		ButtonGroup buttonGroup3 = new ButtonGroup();
		
		setBackground(Color.BLACK);
		setTitle("Episode Counter 5.1");
		setIconImage(Toolkit.getDefaultToolkit().getImage(ViewAnime.class.getResource("/view/img/Logo Episode Counter 1x1.png")));
		setResizable(false);
		conecta.conexao();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1115, 643);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 123, 1079, 414);
		scrollPane.getViewport().setBackground(Color.GRAY);
		
		JButton btnBackProxEp = new JButton("");
		btnBackProxEp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				String dia = txtDtProxEp.getText().substring(0,2);
				String mes = txtDtProxEp.getText().substring(3,5);
				String ano = txtDtProxEp.getText().substring(6);
				int diaReal = Integer.parseInt(dia);
				int mesReal =  Integer.parseInt(mes);
				int anoReal =  Integer.parseInt(ano);
				int mes31 = 0;
				int mes30 = 0;
				int mes28 = 0;
				int mesFinal = 0;
				int anoFinal = anoReal;
				String diaF;
				String mesF;
				
				int diaFinal = diaReal - 7;
				
//				Verificador de meses
				if (mesReal == 1 | mesReal == 2 | mesReal == 4 | mesReal == 6 | mesReal == 8 | mesReal == 9 | mesReal == 10) {
					mes31 = mesReal;
					mesFinal = mes31;
				}else if(mesReal == 5 | mesReal == 7 | mesReal == 10 | mesReal == 12){
					mes30 = mesReal;
					mesFinal = mes30;
				}else if(mesReal == 3) {
						mes28 = mesReal;
						mesFinal = mes28;
				}
				/*if (mesReal == 2 | mesReal == 4 | mesReal == 6 | mesReal == 7 | mesReal == 9 | mesReal == 11 | mesReal == 12) {
					mes31 = mesReal;
					mesFinal = mes31;
				}else if(mesReal == 3 | mesReal == 5 | mesReal == 8 | mesReal == 10){
					mes30 = mesReal;
					mesFinal = mes30;
				}else if(mesReal == 1) {
						mes28 = mesReal;
						mesFinal = mes28;
				}*/
				
				if (mesFinal == 1 && diaFinal < 1) {
					mesFinal = 12;
					diaFinal = diaFinal + 31;
					anoFinal = anoReal - 1;
				}
				if(mesFinal == mes31 && diaFinal < 1) {
					mesFinal = mesFinal - 1;
					diaFinal = diaFinal + 31;
				}else if(mesFinal == mes30 && diaFinal < 1) {
					mesFinal = mesFinal - 1;
					diaFinal = diaFinal + 30;
				}else if(mesFinal == mes28 && diaFinal < 1) {
					mesFinal = mesFinal - 1;
					diaFinal = diaFinal + 28;
				}
				
				diaF = ""+diaFinal;
				mesF = ""+mesFinal;
				if(diaFinal <= 9) {
					diaF = "0"+diaFinal;
					txtDtProxEp.setText(diaF+"/"+mesF+"/"+anoFinal);
				}
				if(mesFinal <= 9) {
					mesF = "0"+mesFinal;
					txtDtProxEp.setText(diaF+"/"+mesF+"/"+anoFinal);
				}else {
				txtDtProxEp.setText(diaF+"/"+mesF+"/"+anoFinal);
				}	
			
			}
		});
		
		JButton btnBackLanc = new JButton("");
		btnBackLanc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				String dia = txtDtLanc.getText().substring(0,2);
				String mes = txtDtLanc.getText().substring(3,5);
				String ano = txtDtLanc.getText().substring(6);
				int diaReal = Integer.parseInt(dia);
				int mesReal =  Integer.parseInt(mes);
				int anoReal =  Integer.parseInt(ano);
				int mes31 = 0;
				int mes30 = 0;
				int mes28 = 0;
				int mesFinal = 0;
				int anoFinal = anoReal;
				String diaF;
				String mesF;
				
				int diaFinal = diaReal - 7;
				
//				Verificador de meses
				if (mesReal == 1 | mesReal == 2 | mesReal == 4 | mesReal == 6 | mesReal == 8 | mesReal == 9 | mesReal == 10) {
					mes31 = mesReal;
					mesFinal = mes31;
				}else if(mesReal == 5 | mesReal == 7 | mesReal == 10 | mesReal == 12){
					mes30 = mesReal;
					mesFinal = mes30;
				}else if(mesReal == 3) {
						mes28 = mesReal;
						mesFinal = mes28;
				}
				/*if (mesReal == 2 | mesReal == 4 | mesReal == 6 | mesReal == 7 | mesReal == 9 | mesReal == 11 | mesReal == 12) {
					mes31 = mesReal;
					mesFinal = mes31;
				}else if(mesReal == 3 | mesReal == 5 | mesReal == 8 | mesReal == 10){
					mes30 = mesReal;
					mesFinal = mes30;
				}else if(mesReal == 1) {
						mes28 = mesReal;
						mesFinal = mes28;
				}*/
				
				if (mesFinal == 1 && diaFinal < 1) {
					mesFinal = 12;
					diaFinal = diaFinal + 31;
					anoFinal = anoReal - 1;
				}
				if(mesFinal == mes31 && diaFinal < 1) {
					mesFinal = mesFinal - 1;
					diaFinal = diaFinal + 31;
				}else if(mesFinal == mes30 && diaFinal < 1) {
					mesFinal = mesFinal - 1;
					diaFinal = diaFinal + 30;
				}else if(mesFinal == mes28 && diaFinal < 1) {
					mesFinal = mesFinal - 1;
					diaFinal = diaFinal + 28;
				}
				
				diaF = ""+diaFinal;
				mesF = ""+mesFinal;
				if(diaFinal <= 9) {
					diaF = "0"+diaFinal;
					txtDtLanc.setText(diaF+"/"+mesF+"/"+anoFinal);
				}
				if(mesFinal <= 9) {
					mesF = "0"+mesFinal;
					txtDtLanc.setText(diaF+"/"+mesF+"/"+anoFinal);
				}else {
				txtDtLanc.setText(diaF+"/"+mesF+"/"+anoFinal);
				}	
				
			}
		});
		btnBackLanc.setBounds(373, 76, 11, 28);
		contentPane.add(btnBackLanc);
		btnBackProxEp.setBounds(181, 76, 11, 28);
		contentPane.add(btnBackProxEp);
		
		JSpinner spnEpisode = new JSpinner();
		spnEpisode.setToolTipText("Epis\u00F3dio / Cap\u00EDtulo");
		spnEpisode.setBounds(118, 76, 53, 28);
		contentPane.add(spnEpisode);
		//////////////////////////////////////////////////
		
		JButton btnBackUltEp = new JButton("");
		btnBackUltEp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				String dia = txtDtUltEp.getText().substring(0,2);
				String mes = txtDtUltEp.getText().substring(3,5);
				String ano = txtDtUltEp.getText().substring(6);
				int diaReal = Integer.parseInt(dia);
				int mesReal =  Integer.parseInt(mes);
				int anoReal =  Integer.parseInt(ano);
				int mes31 = 0;
				int mes30 = 0;
				int mes28 = 0;
				int mesFinal = 0;
				int anoFinal = anoReal;
				String diaF;
				String mesF;
				
				int diaFinal = diaReal - 7;
				
//				Verificador de meses
				if (mesReal == 1 | mesReal == 2 | mesReal == 4 | mesReal == 6 | mesReal == 8 | mesReal == 9 | mesReal == 10) {
					mes31 = mesReal;
					mesFinal = mes31;
				}else if(mesReal == 5 | mesReal == 7 | mesReal == 10 | mesReal == 12){
					mes30 = mesReal;
					mesFinal = mes30;
				}else if(mesReal == 3) {
						mes28 = mesReal;
						mesFinal = mes28;
				}
				/*if (mesReal == 2 | mesReal == 4 | mesReal == 6 | mesReal == 7 | mesReal == 9 | mesReal == 11 | mesReal == 12) {
					mes31 = mesReal;
					mesFinal = mes31;
				}else if(mesReal == 3 | mesReal == 5 | mesReal == 8 | mesReal == 10){
					mes30 = mesReal;
					mesFinal = mes30;
				}else if(mesReal == 1) {
						mes28 = mesReal;
						mesFinal = mes28;
				}*/
				
				if (mesFinal == 1 && diaFinal < 1) {
					mesFinal = 12;
					diaFinal = diaFinal + 31;
					anoFinal = anoReal - 1;
				}
				if(mesFinal == mes31 && diaFinal < 1) {
					mesFinal = mesFinal - 1;
					diaFinal = diaFinal + 31;
				}else if(mesFinal == mes30 && diaFinal < 1) {
					mesFinal = mesFinal - 1;
					diaFinal = diaFinal + 30;
				}else if(mesFinal == mes28 && diaFinal < 1) {
					mesFinal = mesFinal - 1;
					diaFinal = diaFinal + 28;
				}
				
				diaF = ""+diaFinal;
				mesF = ""+mesFinal;
				if(diaFinal <= 9) {
					diaF = "0"+diaFinal;
					txtDtUltEp.setText(diaF+"/"+mesF+"/"+anoFinal);
				}
				if(mesFinal <= 9) {
					mesF = "0"+mesFinal;
					txtDtUltEp.setText(diaF+"/"+mesF+"/"+anoFinal);
				}else {
				txtDtUltEp.setText(diaF+"/"+mesF+"/"+anoFinal);
				}	
				
			}
		});
		btnBackUltEp.setBounds(277, 76, 11, 28);
		contentPane.add(btnBackUltEp);
		
		txtNome = new JTextField();
		txtNome.setToolTipText("Nome do Conte\u00FAdo");
		txtNome.setBounds(73, 37, 386, 28);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				ViewAnime.this.dispose();
				MainMenu mainMenu = new MainMenu();
				mainMenu.setVisible(true);
			
			}
		});
		btnNewButton.setIcon(new ImageIcon(ViewAnime.class.getResource("/view/img/backlittle.png")));
		btnNewButton.setToolTipText("Voltar");
		btnNewButton.setBackground(Color.LIGHT_GRAY);
		btnNewButton.setBounds(10, 76, 35, 28);
		contentPane.add(btnNewButton);
		
		JButton btnNextProxEp = new JButton("");
		btnNextProxEp.setFont(new Font("Tahoma", Font.PLAIN, 9));
		btnNextProxEp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				String dia = txtDtProxEp.getText().substring(0,2);
				String mes = txtDtProxEp.getText().substring(3,5);
				String ano = txtDtProxEp.getText().substring(6);
				int diaReal = Integer.parseInt(dia);
				int mesReal =  Integer.parseInt(mes);
				int anoReal =  Integer.parseInt(ano);
				int mes31 = 0;
				int mes30 = 0;
				int mes28 = 0;
				int mesFinal = 0;
				int anoFinal = anoReal;
				String diaF;
				String mesF;
				
				int diaFinal = diaReal + 7;
				
				if (mesReal == 1 | mesReal == 3 | mesReal == 5 | mesReal == 7 | mesReal == 8 | mesReal == 10 | mesReal == 12) {
					mes31 = mesReal;
					mesFinal = mes31;
				}else if(mesReal == 4 | mesReal == 6 | mesReal == 9 | mesReal == 11){
					mes30 = mesReal;
					mesFinal = mes30;
				}else if(mesReal == 2) {
						mes28 = mesReal;
						mesFinal = mes28;
				}
				if (mesFinal == 12 && diaFinal > 31) {
					mesFinal = 1;
					diaFinal = diaFinal - 31;
					anoFinal = anoReal + 1;
				}
				if(mesFinal == mes31 && diaFinal > 31) {
					mesFinal = mesFinal + 1;
					diaFinal = diaFinal - 31;
				}else if(mesFinal == mes30 && diaFinal > 30) {
					mesFinal = mesFinal + 1;
					diaFinal = diaFinal - 30;
				}else if(mesFinal == mes28 && diaFinal > 28) {
					mesFinal = mesFinal + 1;
					diaFinal = diaFinal - 28;
				}
				
				diaF = ""+diaFinal;
				mesF = ""+mesFinal;
				if(diaFinal <= 9) {
					diaF = "0"+diaFinal;
					txtDtProxEp.setText(diaF+"/"+mesF+"/"+anoFinal);
				}
				if(mesFinal <= 9) {
					mesF = "0"+mesFinal;
					txtDtProxEp.setText(diaF+"/"+mesF+"/"+anoFinal);
				}else {
					txtDtProxEp.setText(diaF+"/"+mesF+"/"+anoFinal);
				}	
			
			}
		});
		btnNextProxEp.setBounds(256, 76, 11, 28);
		contentPane.add(btnNextProxEp);
		
		txtDtProxEp = new JFormattedTextField((setMascara("**/**/****")));
		txtDtProxEp.setHorizontalAlignment(SwingConstants.CENTER);
		txtDtProxEp.setToolTipText("Pr\u00F3ximo Epis\u00F3dio");
		txtDtProxEp.setBounds(181, 76, 86, 28);
		contentPane.add(txtDtProxEp);
		txtDtProxEp.setColumns(10);
		
		JButton btnNextLanc = new JButton("");
		btnNextLanc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				String dia = txtDtLanc.getText().substring(0,2);
				String mes = txtDtLanc.getText().substring(3,5);
				String ano = txtDtLanc.getText().substring(6);
				int diaReal = Integer.parseInt(dia);
				int mesReal =  Integer.parseInt(mes);
				int anoReal =  Integer.parseInt(ano);
				int mes31 = 0;
				int mes30 = 0;
				int mes28 = 0;
				int mesFinal = 0;
				int anoFinal = anoReal;
				String diaF;
				String mesF;
				
				int diaFinal = diaReal + 7;
				
				if (mesReal == 1 | mesReal == 3 | mesReal == 5 | mesReal == 7 | mesReal == 8 | mesReal == 10 | mesReal == 12) {
						mes31 = mesReal;
						mesFinal = mes31;
				}else if(mesReal == 4 | mesReal == 6 | mesReal == 9 | mesReal == 11){
						mes30 = mesReal;
						mesFinal = mes30;
				}else if(mesReal == 2) {
						mes28 = mesReal;
						mesFinal = mes28;
				}
				if (mesFinal == 12 && diaFinal > 31) {
					mesFinal = 1;
					diaFinal = diaFinal - 31;
					anoFinal = anoReal + 1;
				}
				if(mesFinal == mes31 && diaFinal > 31) {
					mesFinal = mesFinal + 1;
					diaFinal = diaFinal - 31;
				}else if(mesFinal == mes30 && diaFinal > 30) {
					mesFinal = mesFinal + 1;
					diaFinal = diaFinal - 30;
				}else if(mesFinal == mes28 && diaFinal > 28) {
					mesFinal = mesFinal + 1;
					diaFinal = diaFinal - 28;
				}
				
				diaF = ""+diaFinal;
				mesF = ""+mesFinal;
				if(diaFinal <= 9) {
					diaF = "0"+diaFinal;
					txtDtLanc.setText(diaF+"/"+mesF+"/"+anoFinal);
				}
				if(mesFinal <= 9) {
					mesF = "0"+mesFinal;
					txtDtLanc.setText(diaF+"/"+mesF+"/"+anoFinal);
				}else {
				txtDtLanc.setText(diaF+"/"+mesF+"/"+anoFinal);
				}	
			
			}
		});
		btnNextLanc.setBounds(448, 76, 11, 28);
		contentPane.add(btnNextLanc);
		
		

		
	//	table.setModel(tableModel);
		
		txtCod = new JTextField();
		txtCod.setToolTipText("C\u00F3digo");
		txtCod.setEditable(false);
		txtCod.setBounds(10, 37, 53, 28);
		contentPane.add(txtCod);
		txtCod.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Nome do Conte\u00FAdo");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(73, 12, 386, 14);
		contentPane.add(lblNewLabel);
		
		txtDtLanc = new JFormattedTextField((setMascara("**/**/****")));
		txtDtLanc.setHorizontalAlignment(SwingConstants.CENTER);
		txtDtLanc.setToolTipText("Data do Lan\u00E7amento");
		txtDtLanc.setBounds(373, 76, 86, 28);
		contentPane.add(txtDtLanc);
		txtDtLanc.setColumns(10);
		
		JLabel lblCd = new JLabel("C�d.");
		lblCd.setHorizontalAlignment(SwingConstants.CENTER);
		lblCd.setForeground(Color.WHITE);
		lblCd.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblCd.setBounds(10, 12, 53, 14);
		contentPane.add(lblCd);
		
		JButton btnNextUltEp = new JButton("");
		btnNextUltEp.addMouseListener(new MouseAdapter() {

			@Override
			public void mouseClicked(MouseEvent e) {
//			
				String dia = txtDtUltEp.getText().substring(0,2);
				String mes = txtDtUltEp.getText().substring(3,5);
				String ano = txtDtUltEp.getText().substring(6);
				int diaReal = Integer.parseInt(dia);
				int mesReal =  Integer.parseInt(mes);
				int anoReal =  Integer.parseInt(ano);
				int mes31 = 0;
				int mes30 = 0;
				int mes28 = 0;
				int mesFinal = 0;
				int anoFinal = anoReal;
				String diaF;
				String mesF;
				
				int diaFinal = diaReal + 7;
				
				if (mesReal == 1 | mesReal == 3 | mesReal == 5 | mesReal == 7 | mesReal == 8 | mesReal == 10 | mesReal == 12) {
					mes31 = mesReal;
					mesFinal = mes31;
				}else if(mesReal == 4 | mesReal == 6 | mesReal == 9 | mesReal == 11){
					mes30 = mesReal;
					mesFinal = mes30;
				}else if(mesReal == 2) {
						mes28 = mesReal;
						mesFinal = mes28;
				}
				if (mesFinal == 12 && diaFinal > 31) {
					mesFinal = 1;
					diaFinal = diaFinal - 31;
					anoFinal = anoReal + 1;
				}
				if(mesFinal == mes31 && diaFinal > 31) {
					mesFinal = mesFinal + 1;
					diaFinal = diaFinal - 31;
				}else if(mesFinal == mes30 && diaFinal > 30) {
					mesFinal = mesFinal + 1;
					diaFinal = diaFinal - 30;
				}else if(mesFinal == mes28 && diaFinal > 28) {
					mesFinal = mesFinal + 1;
					diaFinal = diaFinal - 28;
				}
				
				diaF = ""+diaFinal;
				mesF = ""+mesFinal;
				if(diaFinal <= 9) {
					diaF = "0"+diaFinal;
					txtDtUltEp.setText(diaF+"/"+mesF+"/"+anoFinal);
				}
				if(mesFinal <= 9) {
					mesF = "0"+mesFinal;
					txtDtUltEp.setText(diaF+"/"+mesF+"/"+anoFinal);
				}else {
				txtDtUltEp.setText(diaF+"/"+mesF+"/"+anoFinal);
				}				
			}
		});
		btnNextUltEp.setBounds(352, 76, 11, 28);
		contentPane.add(btnNextUltEp);
		
		JSpinner spnTemp = new JSpinner();
		spnTemp.setToolTipText("Temporada / Saga / Volume / Parte");
		spnTemp.setBounds(55, 76, 53, 28);
		contentPane.add(spnTemp);
		
		txtDtUltEp = new JFormattedTextField((setMascara("**/**/****")));
		txtDtUltEp.setHorizontalAlignment(SwingConstants.CENTER);
		txtDtUltEp.setToolTipText("\u00DAltimo Epis\u00F3dio");
		txtDtUltEp.setBounds(277, 76, 86, 28);
		contentPane.add(txtDtUltEp);
		txtDtUltEp.setColumns(10);
		
		JRadioButton rdbtnEmBreve = new JRadioButton("Em Breve");
		rdbtnEmBreve.setForeground(Color.WHITE);
		rdbtnEmBreve.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnEmBreve.setBounds(847, 16, 113, 23);
		contentPane.add(rdbtnEmBreve);
		
		JRadioButton rdbtnLanc = new JRadioButton("Em Lan\u00E7amento");
		rdbtnLanc.setForeground(Color.WHITE);
		rdbtnLanc.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnLanc.setBounds(732, 16, 113, 23);
		contentPane.add(rdbtnLanc);
		
		JRadioButton rdbtnFinal = new JRadioButton("Finalizado");
		rdbtnFinal.setForeground(Color.WHITE);
		rdbtnFinal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnFinal.setBounds(962, 16, 113, 23);
		contentPane.add(rdbtnFinal);
		
		buttonGroup1.add(rdbtnEmBreve);
		buttonGroup1.add(rdbtnLanc);
		buttonGroup1.add(rdbtnFinal);

		////////////////////////////////////////////////
		
		
		JRadioButton rdbtnInte = new JRadioButton("Interrompido");
		rdbtnInte.setForeground(Color.WHITE);
		rdbtnInte.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnInte.setBounds(847, 51, 113, 23);
		contentPane.add(rdbtnInte);
		
		JRadioButton rdbtnAssis = new JRadioButton("Assistindo");
		rdbtnAssis.setForeground(Color.WHITE);
		rdbtnAssis.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnAssis.setBounds(732, 51, 113, 23);
		contentPane.add(rdbtnAssis);
		
		JRadioButton rdbtnFinal2 = new JRadioButton("Finalizado");
		rdbtnFinal2.setForeground(Color.WHITE);
		rdbtnFinal2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		rdbtnFinal2.setBounds(962, 51, 113, 23);
		contentPane.add(rdbtnFinal2);
		
		buttonGroup2.add(rdbtnInte);
		buttonGroup2.add(rdbtnAssis);
		buttonGroup2.add(rdbtnFinal2);
		////////////////////////////////////////////////
		

		JCheckBox checkbxManga = new JCheckBox("Mang\u00E1/Livro");
		checkbxManga.setForeground(Color.WHITE);
		checkbxManga.setFont(new Font("Tahoma", Font.PLAIN, 12));
		checkbxManga.setBounds(732, 85, 113, 23);
		contentPane.add(checkbxManga);
		
		JCheckBox checkbxAnime = new JCheckBox("Anime/S\u00E9rie");
		checkbxAnime.setForeground(Color.WHITE);
		checkbxAnime.setFont(new Font("Tahoma", Font.PLAIN, 12));
		checkbxAnime.setBounds(847, 85, 113, 23);
		contentPane.add(checkbxAnime);
		
		JCheckBox checkbxFilme = new JCheckBox("Filme");
		checkbxFilme.setForeground(Color.WHITE);
		checkbxFilme.setFont(new Font("Tahoma", Font.PLAIN, 12));
		checkbxFilme.setBounds(962, 85, 113, 23);
		contentPane.add(checkbxFilme);
		
		buttonGroup3.add(checkbxManga);
		buttonGroup3.add(checkbxAnime);
		buttonGroup3.add(checkbxFilme);
		
		JComboBox cbxPesquisa = new JComboBox();
		cbxPesquisa.setModel(new DefaultComboBoxModel(new String[] {"Nome", "C\u00F3digo", "Temporada", "Cap\u00EDtulo", "Pr\u00F3x. Cap\u00EDtulo", "\u00DAlt. Cap\u00EDtulo", "Lan\u00E7amento", "Status do Anime", "Status Pessoal", "Tipo"}));
		cbxPesquisa.setBounds(687, 557, 144, 28);
		contentPane.add(cbxPesquisa);
		contentPane.add(scrollPane);
		
		
		table = new JTable();
		table.setForeground(Color.BLACK);
		table.setGridColor(Color.WHITE);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		
				int indice = table.getSelectedRow();
				
				String indice7 = table.getValueAt(indice, 7).toString();
				String indice8 = table.getValueAt(indice, 8).toString();
				String indice9 = table.getValueAt(indice, 9).toString();
				
				txtCod.setText(table.getValueAt(indice, 0).toString());
				txtNome.setText(table.getValueAt(indice, 1).toString());
				spnTemp.setValue(table.getValueAt(indice, 2));
				spnEpisode.setValue(table.getValueAt(indice, 3));
				txtDtProxEp.setText(table.getValueAt(indice, 4).toString());
				txtDtUltEp.setText(table.getValueAt(indice, 5).toString());
				txtDtLanc.setText(table.getValueAt(indice, 6).toString());
								
				if(indice7.equals("Em Lan�amento")){
					rdbtnLanc.setSelected(true);
				}else if(indice7.equals("Em Breve")){
					rdbtnEmBreve.setSelected(true);
				}else if(indice7.equals("Finalizado")){
					rdbtnFinal.setSelected(true);
				}
				if(indice8.equals("Interrompido")){
					rdbtnInte.setSelected(true);
				}else if(indice8.equals("Assistindo")){
					rdbtnAssis.setSelected(true);
				}else if(indice8.equals("Finalizado")){
					rdbtnFinal2.setSelected(true);
				}
				if(indice9.equals("Anime/S�rie")){
					checkbxAnime.setSelected(true);
				}else if(indice9.equals("Mang�/Livro")){
					checkbxManga.setSelected(true);
				}else if(indice9.equals("Filme")){
					checkbxFilme.setSelected(true);
				}
				
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnAlterar = new JButton("");
		btnAlterar.setIcon(new ImageIcon(ViewAnime.class.getResource("/view/img/alteraricon.png")));
		btnAlterar.setToolTipText("Alterar");
		btnAlterar.setBackground(Color.DARK_GRAY);
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				int resposta = JOptionPane.showConfirmDialog(null, "Deseja realmente alterar?", "Confirmar Altera��o", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if(resposta == 0) {				
				Anime anime01 = new Anime();
				
				anime01.setNome(txtNome.getText());
				anime01.setTemporada((int) spnTemp.getValue());
				anime01.setEpisodio((int) spnEpisode.getValue());
				anime01.setDtProxEp(dtProxEpParaMysql(null));
				anime01.setDtUltEp(dtUltEpParaMysql(null));
				anime01.setDtLanc(dtLancParaMysql(null));
				
				//=======================================
				if(rdbtnLanc.isSelected()) {
					anime01.setStatusAnime("Em Lan�amento");
				}
				if(rdbtnEmBreve.isSelected()) {
					anime01.setStatusAnime("Em Breve");
				}
				if(rdbtnFinal.isSelected()) {
					anime01.setStatusAnime("Finalizado");
				}
				//=======================================
				if(rdbtnAssis.isSelected()) {
					anime01.setStatusPessoal("Assistindo");
				}
				if(rdbtnInte.isSelected()) {
					anime01.setStatusPessoal("Interrompido");
				}
				if(rdbtnFinal2.isSelected()) {
					anime01.setStatusPessoal("Finalizado");
				}
				//=======================================
				if(checkbxManga.isSelected()) {
					anime01.setTipo("Mang�/Livro");
				}
				if(checkbxAnime.isSelected()) {
					anime01.setTipo("Anime/S�rie");
				}
				if(checkbxFilme.isSelected()) {
					anime01.setTipo("Filme");
				}
				
				anime01.setCodigo(Integer.parseInt(txtCod.getText()));
				AnimeNIT animeNIT = new AnimeNIT();
				animeNIT.alterar(anime01);
				
				preencherTabela("select * from anime");
				}
			}
		});
		
		
		
		btnAlterar.setBounds(989, 548, 45, 45);
		contentPane.add(btnAlterar);
		
		JButton btnExcluir = new JButton("");
		btnExcluir.setIcon(new ImageIcon(ViewAnime.class.getResource("/view/img/excluiricon2.png")));
		btnExcluir.setBackground(Color.DARK_GRAY);
		btnExcluir.setToolTipText("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int resposta = JOptionPane.showConfirmDialog(null, "Deseja excluir permanentemente?", "Confirmar Exclus�o", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if(resposta == 0) {
				AnimeNIT animeNIT= new AnimeNIT();
				animeNIT.excluirPorCodigo(Integer.parseInt(txtCod.getText()));
				}
				//tableModel.removeRow(table.getSelectedRow());
				/*if(table.getSelectedRow() != -1) {
					conecta.executaSQL("DELETE FROM animes WHERE codigo='"+txtNome.getText()+"'");
					
					
				}*/
				preencherTabela("select * from anime");
			}
		});
		btnExcluir.setBounds(1044, 548, 45, 45);
		contentPane.add(btnExcluir);
		
		JButton btnSalvar = new JButton("");
		btnSalvar.setIcon(new ImageIcon(ViewAnime.class.getResource("/view/img/saveicon.png")));
		btnSalvar.setToolTipText("Salvar");
		btnSalvar.setBackground(Color.DARK_GRAY);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				buttonGroup1.getSelection();
				buttonGroup2.getSelection();
				buttonGroup3.getSelection();
				
				
				
				Anime a = new Anime();
				AnimeNIT nit = new AnimeNIT();

				a.setNome(txtNome.getText());
				a.setTemporada((int) spnTemp.getValue());
				a.setEpisodio((int) spnEpisode.getValue());
				a.setDtProxEp(dtProxEpParaMysql(null));
				a.setDtUltEp(dtUltEpParaMysql(null));
				a.setDtLanc(dtLancParaMysql(null));
				//=======================================
				if(rdbtnLanc.isSelected()) {
					a.setStatusAnime("Em Lançamento");
				}
				if(rdbtnEmBreve.isSelected()) {
					a.setStatusAnime("Em Breve");
				}
				if(rdbtnFinal.isSelected()) {
					a.setStatusAnime("Finalizado");
				}
				//=======================================
				if(rdbtnAssis.isSelected()) {
					a.setStatusPessoal("Assistindo");
				}
				if(rdbtnInte.isSelected()) {
					a.setStatusPessoal("Interrompido");
				}
				if(rdbtnFinal2.isSelected()) {
					a.setStatusPessoal("Finalizado");
				}
				//=======================================
				if(checkbxManga.isSelected()) {
					a.setTipo("Mangá/Livro");
				}
				if(checkbxAnime.isSelected()) {
					a.setTipo("Anime/Série");
				}
				if(checkbxFilme.isSelected()) {
					a.setTipo("Filme");
				}
				
				nit.create(a);
				//tableModel.addRow(a);
				preencherTabela("select * from anime");
			}
		});
		btnSalvar.setBounds(879, 548, 45, 45);
		contentPane.add(btnSalvar);
		
		JButton btnAtualizar = new JButton("");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				preencherTabela("select * from anime");
				txtCod.setText("");
				txtNome.setText("");
				spnEpisode.setValue(0);
				spnTemp.setValue(0);
				txtDtProxEp.setText("__/__/____");
				txtDtUltEp.setText("__/__/____");
				txtDtLanc.setText("__/__/____");
				buttonGroup1.clearSelection();
				buttonGroup2.clearSelection();
				buttonGroup3.clearSelection();
			
			}
		});
		btnAtualizar.setIcon(new ImageIcon(ViewAnime.class.getResource("/view/img/atualizaricon.png")));
		btnAtualizar.setToolTipText("Atualizar Tabela");
		btnAtualizar.setBackground(Color.DARK_GRAY);
		btnAtualizar.setBounds(934, 548, 45, 45);
		contentPane.add(btnAtualizar);
		
		String itemS = cbxPesquisa.getSelectedItem().toString();
		txtPesquisa = new JTextField();
		txtPesquisa.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			
				if(e.getKeyCode() == KeyEvent.VK_ENTER ){	
					String itemS = cbxPesquisa.getSelectedItem().toString();
					if(itemS == "Nome") {
					preencherTabela("select * from anime where nome like '%"+txtPesquisa.getText()+"%'");
					}else if(itemS == "C�digo") {
					preencherTabela("select * from anime where codigo like '%"+txtPesquisa.getText()+"%'");
					}else if(itemS == "Temporada") {
					preencherTabela("select * from anime where temporada like '%"+txtPesquisa.getText()+"%'");
					}else if(itemS == "Cap�tulo") {
					preencherTabela("select * from anime where episodio like '%"+txtPesquisa.getText()+"%'");
					}else if(itemS == "Pr�x. Cap�tulo") {
					preencherTabela("select * from anime where dtproxep like '%"+dtParaPesquisa(null)+"%'");
					}else if(itemS == "�lt. Cap�tulo") {
					preencherTabela("select * from anime where dtproxep like '%"+dtParaPesquisa(null)+"%'");
					}else if(itemS == "Lan�amento") {
					preencherTabela("select * from anime where dtlancamento like '%"+dtParaPesquisa(null)+"%'");
					}else if(itemS == "Status do Anime") {
					preencherTabela("select * from anime where status_anime like '%"+txtPesquisa.getText()+"%'");
					}else if(itemS == "Status Pessoal") {
					preencherTabela("select * from anime where status_pessoal like '%"+txtPesquisa.getText()+"%'");
					}else if(itemS == "Tipo") {
					preencherTabela("select * from anime where tipo like '%"+txtPesquisa.getText()+"%'");
					}
					
				}
			
			}
		});
		txtPesquisa.setBounds(113, 557, 718, 28);
		contentPane.add(txtPesquisa);
		txtPesquisa.setColumns(10);
		
		
		JButton btnPesquisar = new JButton("");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				String itemS = cbxPesquisa.getSelectedItem().toString();
				if(itemS == "Nome") {
				preencherTabela("select * from anime where nome like '%"+txtPesquisa.getText()+"%'");
				}else if(itemS == "C�digo") {
				preencherTabela("select * from anime where codigo like '%"+txtPesquisa.getText()+"%'");
				}else if(itemS == "Temporada") {
				preencherTabela("select * from anime where temporada like '%"+txtPesquisa.getText()+"%'");
				}else if(itemS == "Cap�tulo") {
				preencherTabela("select * from anime where episodio like '%"+txtPesquisa.getText()+"%'");
				}else if(itemS == "Pr�x. Cap�tulo") {
				preencherTabela("select * from anime where dtproxep like '%"+dtParaPesquisa(null)+"%'");
				}else if(itemS == "�lt. Cap�tulo") {
				preencherTabela("select * from anime where dtultep like '%"+dtParaPesquisa(null)+"%'");
				}else if(itemS == "Lan�amento") {
				preencherTabela("select * from anime where dtlancamento like '%"+dtParaPesquisa(null)+"%'");
				}else if(itemS == "Status do Anime") {
				preencherTabela("select * from anime where status_anime like '%"+txtPesquisa.getText()+"%'");
				}else if(itemS == "Status Pessoal") {
				preencherTabela("select * from anime where status_pessoal like '%"+txtPesquisa.getText()+"%'");
				}else if(itemS == "Tipo") {
				preencherTabela("select * from anime where tipo like '%"+txtPesquisa.getText()+"%'");
				}
				/*
			for(int i=0;i<table.getRowCount();i++)
				
				try {
					String pesquisa = "select * from animes where nome like '"+ textField.getText()+"%'";
					conecta.executaSQL(pesquisa);
					if(conecta.rs.first()) {
						
						
						
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				*/
			}
		});
		
		
		
		btnPesquisar.setBackground(Color.WHITE);
		btnPesquisar.setIcon(new ImageIcon(ViewAnime.class.getResource("/view/img/loupe.png")));
		btnPesquisar.setBounds(841, 557, 28, 28);
		contentPane.add(btnPesquisar);
		
		JLabel lblPesquisa = new JLabel("Pesquisar:");
		lblPesquisa.setForeground(Color.WHITE);
		lblPesquisa.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPesquisa.setBounds(10, 557, 93, 28);
		contentPane.add(lblPesquisa);
		
		JLabel lblStatusDoAnime = new JLabel("Status do Anime:");
		lblStatusDoAnime.setHorizontalAlignment(SwingConstants.LEFT);
		lblStatusDoAnime.setForeground(Color.WHITE);
		lblStatusDoAnime.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblStatusDoAnime.setBounds(602, 20, 124, 14);
		contentPane.add(lblStatusDoAnime);
		
		JLabel lblStatusPessoal = new JLabel("Status Pessoal:");
		lblStatusPessoal.setHorizontalAlignment(SwingConstants.LEFT);
		lblStatusPessoal.setForeground(Color.WHITE);
		lblStatusPessoal.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblStatusPessoal.setBounds(602, 55, 124, 14);
		contentPane.add(lblStatusPessoal);
		
		JLabel lblTipoDeContedo = new JLabel("Tipo de Conte\u00FAdo:");
		lblTipoDeContedo.setHorizontalAlignment(SwingConstants.LEFT);
		lblTipoDeContedo.setForeground(Color.WHITE);
		lblTipoDeContedo.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTipoDeContedo.setBounds(602, 90, 124, 14);
		contentPane.add(lblTipoDeContedo);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(593, 12, 496, 32);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(593, 46, 496, 32);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.GRAY);
		panel_2.setBounds(593, 80, 496, 32);
		contentPane.add(panel_2);
		
		JLabel lblFiltro = new JLabel("Filtro");
		lblFiltro.setHorizontalAlignment(SwingConstants.CENTER);
		lblFiltro.setForeground(Color.WHITE);
		lblFiltro.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFiltro.setBounds(470, 11, 113, 14);
		contentPane.add(lblFiltro);
		
		JButton btnNewButton_1 = new JButton("Anime");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String[] jOptions = {"Em Lan�amento\n", "Em Breve\n", "Finalizado\n", "Remover Filtro"};
				int x = JOptionPane.showOptionDialog(null,
											"Selecione o Filtro:",
											"Filtro", 
											JOptionPane.DEFAULT_OPTION,
											JOptionPane.INFORMATION_MESSAGE,
											null,
											jOptions, jOptions[0]);
				
				if(x == 0) {
					preencherTabela("select * from anime where status_anime like '%Em Lan�amento%'");
				}else if(x == 1) {
					preencherTabela("select * from anime where status_anime like '%Em Breve%'");
				}else if(x == 2) {
					preencherTabela("select * from anime where status_anime like '%Finalizado%'");
				}else if(x == 3) {
					preencherTabela("select * from anime");
					txtCod.setText("");
					txtNome.setText("");
					spnEpisode.setValue(0);
					spnTemp.setValue(0);
					txtDtProxEp.setText("__/__/____");
					txtDtUltEp.setText("__/__/____");
					txtDtLanc.setText("__/__/____");
					buttonGroup1.clearSelection();
					buttonGroup2.clearSelection();
					buttonGroup3.clearSelection();
				}
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(480, 30, 93, 24);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_1_1 = new JButton("Pessoal");
		btnNewButton_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				String[] jOptions = {"Assistindo\n", "Interrompido\n", "Finalizado\n","Remover Filtro"};
				int y = JOptionPane.showOptionDialog(null,
											"Selecione o Filtro:",
											"Filtro", 
											JOptionPane.DEFAULT_OPTION,
											JOptionPane.INFORMATION_MESSAGE,
											null,
											jOptions, jOptions[0]);
				
				if(y == 0) {
					preencherTabela("select * from anime where status_pessoal like '%Assistindo%'");
				}else if(y == 1) {
					preencherTabela("select * from anime where status_pessoal like '%Interrompido%'");
				}else if(y == 2) {
					preencherTabela("select * from anime where status_pessoal like '%Finalizado%'");
				}else if(y == 3) {
					preencherTabela("select * from anime");
					txtCod.setText("");
					txtNome.setText("");
					spnEpisode.setValue(0);
					spnTemp.setValue(0);
					txtDtProxEp.setText("__/__/____");
					txtDtUltEp.setText("__/__/____");
					txtDtLanc.setText("__/__/____");
					buttonGroup1.clearSelection();
					buttonGroup2.clearSelection();
					buttonGroup3.clearSelection();
				}
			
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1_1.setForeground(Color.BLACK);
		btnNewButton_1_1.setBackground(Color.WHITE);
		btnNewButton_1_1.setBounds(480, 57, 93, 24);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("Tipo");
		btnNewButton_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				String[] jOptions = {"Mangá/Livro\n", "Anime/Série\n", "Filme\n","Remover Filtro"};
				int z = JOptionPane.showOptionDialog(null,
											"Selecione o Filtro:",
											"Filtro", 
											JOptionPane.DEFAULT_OPTION,
											JOptionPane.INFORMATION_MESSAGE,
											null,
											jOptions, jOptions[0]);
				
				if(z == 0) {
					preencherTabela("select * from anime where tipo like '%Mangá/Livro%'");
				}else if(z == 1) {
					preencherTabela("select * from anime where tipo like '%Anime/Série%'");
				}else if(z == 2) {
					preencherTabela("select * from anime where tipo like '%Filme%'");
				}else if(z == 3) {
					preencherTabela("select * from anime");
					txtCod.setText("");
					txtNome.setText("");
					spnEpisode.setValue(0);
					spnTemp.setValue(0);
					txtDtProxEp.setText("__/__/____");
					txtDtUltEp.setText("__/__/____");
					txtDtLanc.setText("__/__/____");
					buttonGroup1.clearSelection();
					buttonGroup2.clearSelection();
					buttonGroup3.clearSelection();
				}
				
			}
		});
		btnNewButton_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1_1_1.setForeground(Color.BLACK);
		btnNewButton_1_1_1.setBackground(Color.WHITE);
		btnNewButton_1_1_1.setBounds(480, 84, 93, 24);
		contentPane.add(btnNewButton_1_1_1);
		
		preencherTabela("select * from anime");
	}
	@SuppressWarnings({ "unchecked", "static-access" })
	public void	preencherTabela(String Sql){
		@SuppressWarnings("rawtypes")
		ArrayList dados = new ArrayList();
		String[] colunas = new String[] {"Codigo", "Nome", "Temporada", "Capitulo", "Próximo Cap.", "Último Cap.", "Lançamento" ,"St. Anime", "St. Pessoal", "Tipo"};
		
		conecta.executaSQL(Sql);
		try {
			if(conecta.rs.next() == true) {
			try {
				conecta.rs.first();
				do {
					dados.add(new Object[] {
							conecta.rs.getInt("codigo"),
							conecta.rs.getString("nome"),
							conecta.rs.getInt("temporada"),
							conecta.rs.getInt("episodio"),
							dtProxEpdoMysql(conecta.rs.getString("dtproxep")),
							dtUltEpdoMysql(conecta.rs.getString("dtultep")),
							dtLancdoMysql(conecta.rs.getString("dtlancamento")),
							conecta.rs.getString("status_anime"),
							conecta.rs.getString("status_pessoal"),
							conecta.rs.getString("tipo")});
				}while(conecta.rs.next());
			} catch (SQLException e) {
				e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Erro ao preencher a tabela");
			}
}
		} catch (HeadlessException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AnimeTableModelS tableModel = new AnimeTableModelS(dados, colunas);
		
		table.setModel(tableModel);
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(0).setResizable(true);
	
		table.getColumnModel().getColumn(1).setPreferredWidth(346);
		table.getColumnModel().getColumn(1).setResizable(true);
		
		table.getColumnModel().getColumn(2).setPreferredWidth(76);
		table.getColumnModel().getColumn(2).setResizable(true);
		
		table.getColumnModel().getColumn(3).setPreferredWidth(60);
		table.getColumnModel().getColumn(3).setResizable(true);
		
		table.getColumnModel().getColumn(4).setPreferredWidth(85);
		table.getColumnModel().getColumn(4).setResizable(true);
		
		table.getColumnModel().getColumn(5).setPreferredWidth(85);
		table.getColumnModel().getColumn(5).setResizable(true);
		
		table.getColumnModel().getColumn(6).setPreferredWidth(85);
		table.getColumnModel().getColumn(6).setResizable(true);
		
		table.getColumnModel().getColumn(7).setPreferredWidth(90);
		table.getColumnModel().getColumn(7).setResizable(true);
		
		table.getColumnModel().getColumn(8).setPreferredWidth(90);
		table.getColumnModel().getColumn(8).setResizable(true);
		
		table.getColumnModel().getColumn(9).setPreferredWidth(90);
		table.getColumnModel().getColumn(9).setResizable(true);
		
		table.getTableHeader().setReorderingAllowed(false);

		table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	
		JTableHeader tableHeader = table.getTableHeader();
		//tableHeader.addMouseListener(new AcoesCabecalhoColuna());
		tableHeader.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				JTable table = ((JTableHeader) evt.getSource()).getTable();
				TableColumnModel tableColumnModel = table.getColumnModel();
				int colunaCabecalho = tableColumnModel.getColumnIndexAtX(evt.getX());
//				JOptionPane.showMessageDialog(null, "cabe�alho: "+colunaCabecalho);
				if (colunaCabecalho == 0) {
					preencherTabela("select * from anime order by codigo asc");
					if(colunaCabecalho == 0 && evt.getClickCount() == 2) {
						preencherTabela2("select * from anime order by codigo desc");
					}
				}else if (colunaCabecalho == 1) {
					preencherTabela("select * from anime order by nome asc");
					if(colunaCabecalho == 1 && evt.getClickCount() == 2) {
						preencherTabela2("select * from anime order by nome desc");
					}
				}else if (colunaCabecalho == 2) {
					preencherTabela("select * from anime order by temporada asc");
					if(colunaCabecalho == 2 && evt.getClickCount() == 2) {
						preencherTabela2("select * from anime order by temporada desc");
					}
				}else if (colunaCabecalho == 3) {
					preencherTabela("select * from anime order by episodio");
					if(colunaCabecalho == 3 && evt.getClickCount() == 2) {
						preencherTabela2("select * from anime order by episodio desc");
					}
				}else if (colunaCabecalho == 4) {
					preencherTabela("select * from anime order by dtproxep");
					if(colunaCabecalho == 4 && evt.getClickCount() == 2) {
						preencherTabela2("select * from anime order by dtproxep desc");
					}
				}else if (colunaCabecalho == 5) {
					preencherTabela("select * from anime order by dtultep");
					if(colunaCabecalho == 5 && evt.getClickCount() == 2) {
						preencherTabela2("select * from anime order by dtultep desc");
					}
				}else if (colunaCabecalho == 6) {
					preencherTabela("select * from anime order by dtlancamento");
					if(colunaCabecalho == 6 && evt.getClickCount() == 2) {
						preencherTabela2("select * from anime order by dtlancamento desc");
					}
				}else if (colunaCabecalho == 7) {
					preencherTabela("select * from anime order by status_anime");
					if(colunaCabecalho == 7 && evt.getClickCount() == 2) {
						preencherTabela2("select * from anime order by status_anime desc");
					}
				}else if (colunaCabecalho == 8) {
					preencherTabela("select * from anime order by status_pessoal");
					if(colunaCabecalho == 8 && evt.getClickCount() == 2) {
						preencherTabela2("select * from anime order by status_pessoal desc");
					}
				}else if (colunaCabecalho == 9) {
					preencherTabela("select * from anime order by tipo");
					if(colunaCabecalho == 9 && evt.getClickCount() == 2) {
						preencherTabela2("select * from anime order by tipo desc");
					}
				}
			}
		});
		
  }
	@SuppressWarnings({ "unchecked", "static-access" })
	public void	preencherTabela2(String Sql){
		@SuppressWarnings("rawtypes")
		ArrayList dados = new ArrayList();
		String[] colunas = new String[] {"Codigo", "Nome", "Temporada", "Capitulo", "Próximo Cap.", "Último Cap.", "Lançamento", "St. Anime", "St. Pessoal", "Tipo"};
		
		conecta.executaSQL(Sql);
		try {
			while(conecta.rs.next()) {
			
				do {
					dados.add(new Object[] {
							conecta.rs.getInt("codigo"),
							conecta.rs.getString("nome"),
							conecta.rs.getInt("temporada"),
							conecta.rs.getInt("episodio"),
							dtProxEpdoMysql(conecta.rs.getString("dtproxep")),
							dtUltEpdoMysql(conecta.rs.getString("dtultep")),
							dtLancdoMysql(conecta.rs.getString("dtlancamento")),
							conecta.rs.getString("status_anime"),
							conecta.rs.getString("status_pessoal"),
							conecta.rs.getString("tipo")});
				}while(conecta.rs.next());
			
}
		} catch (HeadlessException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro ao preencher a tabela");
		}
		AnimeTableModelS tableModel = new AnimeTableModelS(dados, colunas);
		
		table.setModel(tableModel);
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(0).setResizable(true);
	
		table.getColumnModel().getColumn(1).setPreferredWidth(346);
		table.getColumnModel().getColumn(1).setResizable(true);
		
		table.getColumnModel().getColumn(2).setPreferredWidth(76);
		table.getColumnModel().getColumn(2).setResizable(true);
		
		table.getColumnModel().getColumn(3).setPreferredWidth(60);
		table.getColumnModel().getColumn(3).setResizable(true);
		
		table.getColumnModel().getColumn(4).setPreferredWidth(85);
		table.getColumnModel().getColumn(4).setResizable(true);
		
		table.getColumnModel().getColumn(5).setPreferredWidth(85);
		table.getColumnModel().getColumn(5).setResizable(true);
		
		table.getColumnModel().getColumn(6).setPreferredWidth(85);
		table.getColumnModel().getColumn(6).setResizable(true);
		
		table.getColumnModel().getColumn(7).setPreferredWidth(90);
		table.getColumnModel().getColumn(7).setResizable(true);
		
		table.getColumnModel().getColumn(8).setPreferredWidth(90);
		table.getColumnModel().getColumn(8).setResizable(true);
		
		table.getColumnModel().getColumn(9).setPreferredWidth(90);
		table.getColumnModel().getColumn(9).setResizable(true);
		table.getTableHeader().setReorderingAllowed(false);

		table.setAutoResizeMode(table.AUTO_RESIZE_OFF);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	
		JTableHeader tableHeader = table.getTableHeader();
		//tableHeader.addMouseListener(new AcoesCabecalhoColuna());
		
  }
}

