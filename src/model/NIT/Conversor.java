package model.NIT;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class Conversor extends JFrame {

	private JPanel contentPane;
	private JTextField txtTexto1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Conversor frame = new Conversor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Conversor() {
		setAlwaysOnTop(true);
		setResizable(false);
		setTitle("Convert.io");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 395, 443);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 141, 359, 251);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		scrollPane.setViewportView(textArea);
		
		txtTexto1 = new JTextField();
		txtTexto1.setBounds(10, 36, 269, 28);
		contentPane.add(txtTexto1);
		txtTexto1.setColumns(10);
		
		JButton btnColar = new JButton("Colar");
		btnColar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				txtTexto1.setText("");
				txtTexto1.paste();
			
			}
		});
		btnColar.setBounds(289, 36, 80, 28);
		contentPane.add(btnColar);
		
		JButton btnCopiar = new JButton("Copiar");
		btnCopiar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				textArea.selectAll();
				textArea.copy();
			
			}
		});
		btnCopiar.setBounds(289, 102, 80, 28);
		contentPane.add(btnCopiar);
		
		JLabel lblNewLabel = new JLabel("Texto para Converter");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(10, 11, 153, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblTextoConvertido = new JLabel("Texto Convertido");
		lblTextoConvertido.setHorizontalAlignment(SwingConstants.LEFT);
		lblTextoConvertido.setBounds(10, 116, 153, 14);
		contentPane.add(lblTextoConvertido);
		
		JButton btnToSQL = new JButton("ToSQL");
		btnToSQL.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				String texto1 = txtTexto1.getText();
				String t1 = texto1.substring(0,4);
				String t2 = texto1.substring(4,6);
				String t3 = texto1.substring(6,8);
				
				String tFinal = t1 +"-"+ t2 +"-"+ t3;
				
				textArea.append("UPDATE anime SET dtlancamento='"+tFinal+"'" + " WHERE codigo=;\n");
			
			}
		});
		btnToSQL.setBounds(11, 83, 89, 23);
		contentPane.add(btnToSQL);

	}
}
