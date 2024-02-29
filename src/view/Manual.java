package view;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Window.Type;
import java.awt.Toolkit;

@SuppressWarnings({ "serial", "unused" })
public class Manual extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
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
					Manual frame = new Manual();
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
	public Manual() {
		setTitle("Episode Counter 5.1");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Manual.class.getResource("/view/Logo Episode Counter 1x1.png")));
		setResizable(false);
		setType(Type.POPUP);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 360, 247);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				Manual.this.dispose();
				MainMenu mainMenu = new MainMenu();
				mainMenu.setVisible(true);
			
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(Manual.class.getResource("/view/backlittle.png")));
		btnNewButton_1.setToolTipText("Back");
		btnNewButton_1.setBackground(Color.DARK_GRAY);
		btnNewButton_1.setBounds(10, 11, 41, 40);
		contentPane.add(btnNewButton_1);
		
		JLabel lblImg = new JLabel("");
		lblImg.setHorizontalAlignment(SwingConstants.CENTER);
		lblImg.setIcon(new ImageIcon(Manual.class.getResource("/view/po.png")));
		lblImg.setBounds(61, 11, 273, 40);
		contentPane.add(lblImg);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				JOptionPane.showMessageDialog(null, "Para ser redirecionado à tela principal do programa \n você deve apertar em 'Avançar' no menu principal");
			
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setIcon(new ImageIcon(Manual.class.getResource("/view/btnAvancarM.png")));
		btnNewButton.setBounds(10, 87, 110, 49);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Bot\u00E3o Avan\u00E7ar:");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("MV Boli", Font.BOLD, 14));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(10, 62, 110, 19);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				JOptionPane.showMessageDialog(null, "Para voltar à tela anterior você deve pressionar o botão 'Voltar'");
			
			}
		});
		btnNewButton_2.setIcon(new ImageIcon(Manual.class.getResource("/view/backlittleM.png")));
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setBounds(224, 87, 110, 49);
		contentPane.add(btnNewButton_2);
		
		JLabel lblBotoVoltar = new JLabel("Bot\u00E3o Voltar:");
		lblBotoVoltar.setHorizontalAlignment(SwingConstants.CENTER);
		lblBotoVoltar.setForeground(Color.WHITE);
		lblBotoVoltar.setFont(new Font("MV Boli", Font.BOLD, 14));
		lblBotoVoltar.setBounds(224, 62, 110, 19);
		contentPane.add(lblBotoVoltar);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
			URI uri;
			try {
				uri = new URI ("https://www.mediafire.com/file/bdyj15fe312u3y1/Manual_Episode_Counter.pdf/file");
				java.awt.Desktop.getDesktop().browse(uri);
			} catch (URISyntaxException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
				
			}
		});
		btnNewButton_3.setIcon(new ImageIcon(Manual.class.getResource("/view/btnManualPDF.png")));
		btnNewButton_3.setBackground(Color.DARK_GRAY);
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setFont(new Font("MV Boli", Font.BOLD, 14));
		btnNewButton_3.setBounds(97, 149, 157, 49);
		contentPane.add(btnNewButton_3);
	}
}
