import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.sql.Statement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login extends JFrame {

	public static JFrame frame;
	public static String Query;
	private JTextField user_id;
	private JPasswordField passwordField;
	public static Connection con = null;  
	public static Statement st = null;
	public static ResultSet rs = null;
	public static String username = "angajat1";
	public static String username1;  
	public static String password = "1234";
	public static String password1;
	
	 
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) throws ClassNotFoundException {
		
		   
         
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				 
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		//Creare frame
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//Creare panel
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 153, 204));
		panel.setBounds(0, 0, 350, 600);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		//Creare label-uri
		JLabel lblNewLabel_4 = new JLabel("WELCOME !");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 37));
		lblNewLabel_4.setBounds(69, 269, 217, 75);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setForeground(new Color(102, 153, 204));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(475, 11, 80, 32);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(413, 205, 80, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(413, 235, 80, 13);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		//Creare casete text pt user si parola
		user_id = new JTextField();
		user_id.setBounds(514, 203, 96, 20);
		frame.getContentPane().add(user_id);
		user_id.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(514, 233, 96, 20);
		frame.getContentPane().add(passwordField);
		
		 
		// Creare comboBox pt logare in baza de date
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(new Color(102, 153, 204));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 18));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Director", "Profesor"}));
		comboBox.setBounds(514, 160, 96, 32);
		frame.getContentPane().add(comboBox);
		
		
		
		//Creare buton
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				// Verificam daca utilizatorul doreste sa se logheze ca profesor
				if(comboBox.getSelectedItem().toString().equals("Profesor")){
				
					//verificam daca userul si parola introdusa de utilizator se regaseste in baza de date
				 Query = "SELECT DEPARTAMENT FROM angajat1.angajatiTABLE WHERE USERNAME='"+user_id.getText() + "' and PAROLA = '" +passwordField.getText() + "'";
				 
			
				try {
					
					// ne logam in baza de date	
					con = DriverManager.getConnection("jdbc:derby:C:\\Users\\drops\\MyDB","angajat1","1234");
					st = con.createStatement();
					rs = st.executeQuery(Query);
					 
					 
					
					if(rs.next()) {
						
						// daca userul si parola sunt corecte ne deschide fereastra pt gestionarea situatiei studentilor
						
						Situatie_Studenti window = new Situatie_Studenti();
						Situatie_Studenti.frame.setVisible(true);
						Login.frame.setVisible(false);
						
						
					}
					else {
						// daca userul si parola sunt gresite ne genereaza o fereastra cu urmatorul mesaj
						JOptionPane.showMessageDialog(null, "Username sau parola gresita!");
					}
					
					
					
				} catch (Exception a){
					
					a.printStackTrace();
					
				}	
				}else {
					//Verificam daca utilizatorul vrea sa se logheze ca Director
					
					//verificam daca userul si parola introduse se regasesc in baza de date
					String Query = "SELECT* FROM angajat1.adminTABLE WHERE USER_ADMIN='"+user_id.getText() + "' and PASS_ADMIN = '" +passwordField.getText() + "'";
					 
					
					try {
						
						// ne conectam la baza de date 	
						con = DriverManager.getConnection("jdbc:derby:C:\\Users\\drops\\MyDB","angajat1","1234");
						st = con.createStatement();
						rs = st.executeQuery(Query);
						
						if(rs.next()) {
							// daca userul si parola sunt corecte ne genereaza o noua fereastra pt gestionarea angajatilor 
							Angajati window = new Angajati();
							Angajati.frame.setVisible(true);
							Login.frame.setVisible(false);
							
						}
						else {
							// altfel ne genereaza o fereastra cu urmatorul mesaj
							JOptionPane.showMessageDialog(null, "Username sau parola gresita!");
						}
						
						
						
					} catch (Exception a){
						
						a.printStackTrace();
						
					}	
					
					
					
					
					
					
					
					
					
					
				}
				
			}
		});
		btnNewButton.setBounds(404, 312, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CLEAR");
		btnNewButton_1.addActionListener(new ActionListener() {
			// Stergem continutul casetelor text
			public void actionPerformed(ActionEvent e) {
				
				user_id.setText("");
				passwordField.setText("");
			}
		});
		btnNewButton_1.setBounds(521, 312, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("Ai uitat parola? Reseteaza-o!");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override 
			public void mouseClicked(MouseEvent e) { // functie apelata in care utilizatorul(doar adminul(directorul)  ) doreste sa schimbe parola
				
				new Update_Admin().frame.setVisible(true); // genereaza fereastra update_admin
				Login.frame.setVisible(false);
			}
		});
		lblNewLabel_2.setForeground(new Color(51, 51, 204));
		lblNewLabel_2.setBounds(413, 346, 175, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		 
	}
}
