import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;

public class Update_Admin {

	public static JFrame frame;
	private JTextField update_user;
	private JTextField update_pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update_Admin window = new Update_Admin();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Update_Admin() {
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	
		
		
		
	
	private void initialize() {
		
		//creare frame 
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(102, 204, 204));
		frame.setBounds(100, 100, 450, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//creare label-uri
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(176, 126, 86, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1_1.setBounds(176, 167, 69, 14);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel = new JLabel("UpdateAdmin");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(209, 23, 163, 31);
		frame.getContentPane().add(lblNewLabel);
		
		
		//creare casete text pt user si parola
		update_user = new JTextField();
		update_user.setBounds(287, 120, 96, 20);
		frame.getContentPane().add(update_user);
		update_user.setColumns(10);
		
		update_pass = new JTextField();
		update_pass.setColumns(10);
		update_pass.setBounds(287, 161, 96, 20);
		frame.getContentPane().add(update_pass);
		
		 
		
		JButton btnNewButton = new JButton(" Update");
		btnNewButton.addActionListener(new ActionListener() {
			// functie apelata in cazul in care utilizatorul doreste sa schimbe parola
			public void actionPerformed(ActionEvent e) {
				
				try {
					Login.con = DriverManager.getConnection("jdbc:derby:C:\\Users\\drops\\MyDB","angajat1","1234");

					String Query = "UPDATE adminTABLE SET USER_ADMIN='"+ update_user.getText()+"'"+ ", PASS_ADMIN='"+update_pass.getText()+ "'"+"WHERE ID_ADMIN=+1";
					Statement add = Login.con.createStatement();
				    
				     
 
				   
				    add.executeUpdate(Query);
				    
				    // mesaj in cazul in care parola a fost schimbata
					JOptionPane.showMessageDialog(null, "Parola a fost schimbata!"); 
					
					// ne duce inapoi pe pagina de login pt a ne loga cu noua parola
					new Login().frame.setVisible(true);
					Update_Admin.frame.setVisible(false);
					Login.con.close();
					
					
				}catch(SQLException f) {
					
					f.printStackTrace();
					
				}
				
				
				
			}
		});
		btnNewButton.setBounds(179, 280, 86, 40);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			
			// stergem continutul casetelor text
			public void actionPerformed(ActionEvent e) {
				
			
				update_user.setText("");
				update_pass.setText("");
			
			}
		});
		btnClear.setBounds(294, 280, 89, 40);
		frame.getContentPane().add(btnClear);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 144, 600);
		frame.getContentPane().add(panel);
	}
}
