package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import java.awt.Font;

@SuppressWarnings("serial")
public class MainMenu extends JFrame {

	private JPanel contentPane;

	/**
	 * author: @jnbdotdev
	 * 12/2021
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
					MainMenu frame = new MainMenu();
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
	public MainMenu() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainMenu.class.getResource("/view/img/Logo Episode Counter 1x1.png")));
		setResizable(false);
		setTitle("Episode Counter 5.1");
		setAlwaysOnTop(true);
		setType(Type.POPUP);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 299);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAvancar = new JButton("");
		btnAvancar.setBackground(Color.DARK_GRAY);
		btnAvancar.setIcon(new ImageIcon(MainMenu.class.getResource("/view/img/btnAvancar.png")));
		btnAvancar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				MainMenu.this.dispose();
				try {
					ViewAnime viewanime = new ViewAnime();
					viewanime.setVisible(true);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			
			}
		});
		btnAvancar.setBounds(172, 167, 99, 33);
		contentPane.add(btnAvancar);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogo.setIcon(new ImageIcon(MainMenu.class.getResource("/view/img/Sem T\u00EDtulo-2.2.png")));
		lblLogo.setBounds(10, 0, 414, 156);
		contentPane.add(lblLogo);
		
		JButton btnManual = new JButton("");
		btnManual.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				MainMenu.this.dispose();
				Manual manuaL = new Manual();
				manuaL.setVisible(true);
			
			}
		});
		btnManual.setIcon(new ImageIcon(MainMenu.class.getResource("/view/img/btnManual.png")));
		btnManual.setBackground(Color.DARK_GRAY);
		btnManual.setBounds(172, 211, 99, 33);
		contentPane.add(btnManual);
		
		JLabel lblCreator = new JLabel("Creator: James");
		lblCreator.setFont(new Font("MV Boli", Font.PLAIN, 11));
		lblCreator.setBounds(325, 235, 99, 14);
		contentPane.add(lblCreator);
		
	}
}
