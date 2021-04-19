import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import java.sql.*; 

import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Angajati extends JFrame {

	public static JFrame frame;
	private JTable table;
	private JTextField cod_angajat;
	private JTextField nume_angajat;
	private JTextField parola_angajat;
	private JTextField departament_angajat;
	private JTextField username_angajat;
	private JTextField salariu_angajat;


   
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		   	
		
		 
		
		EventQueue.invokeLater(new Runnable() {
		
			public void run() {
				
				try {
					
					Angajati window = new Angajati();
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
	public Angajati() {
		initialize();
		SelectAngajat();
		
		 
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	public void SelectAngajat() {
		
		try {
			Login.con = DriverManager.getConnection("jdbc:derby:C:\\Users\\drops\\MyDB","angajat1","1234");
			Login.st = Login.con.createStatement();
			Login.rs = ((Statement) Login.st).executeQuery("SELECT * FROM ANGAJAT1.angajatiTABLE");
			table.setModel(DbUtils.resultSetToTableModel(Login.rs));
		}catch(Exception e) {
			
			e.printStackTrace();
		}
	}
	private void initialize() {
		
		// creare frame 
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(102, 153, 204));
		frame.setBounds(100, 100, 1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		// creare panel
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(188, 11, 775, 541);
		frame.getContentPane().add(panel);
		
		// creare tabel 
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// afisam in tabel informatiile din baza de date
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				int Myindex = table.getSelectedRow();
				cod_angajat.setText(model.getValueAt(Myindex,0).toString());
				nume_angajat.setText(model.getValueAt(Myindex,1).toString());
				username_angajat.setText(model.getValueAt(Myindex,2).toString());
				parola_angajat.setText(model.getValueAt(Myindex,3).toString());
				departament_angajat.setText(model.getValueAt(Myindex,4).toString());
				salariu_angajat.setText(model.getValueAt(Myindex,6).toString());
				
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] { // coloanele tabelului
				"COD VANZATOR", "NUME", "USERNAME", "PAROLA", "Departament", "SEX", "SALARIU"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				true, true, true, true, false, false, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		table.setToolTipText("\r\n");
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBounds(42, 58, 702, 240);
		panel.add(table);
		
		// creare label-uri 
		JLabel lblNewLabel_1 = new JLabel("Gestionare Angajati");
		lblNewLabel_1.setForeground(new Color(102, 153, 204));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(275, 11, 309, 36);
		panel.add(lblNewLabel_1);
		
		JLabel lblCodVanzator = new JLabel("Cod Angajat");
		lblCodVanzator.setForeground(new Color(102, 153, 204));
		lblCodVanzator.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCodVanzator.setBounds(42, 385, 99, 14);
		panel.add(lblCodVanzator);
		
		JLabel lblNume = new JLabel("Nume");
		lblNume.setForeground(new Color(102, 153, 204));
		lblNume.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNume.setBounds(42, 416, 89, 14);
		panel.add(lblNume);
		
		JLabel lblParola = new JLabel("Parola");
		lblParola.setForeground(new Color(102, 153, 204));
		lblParola.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblParola.setBounds(423, 420, 68, 14);
		panel.add(lblParola);
		
		JLabel lblSex = new JLabel("Sex");
		lblSex.setForeground(new Color(102, 153, 204));
		lblSex.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSex.setBounds(43, 313, 57, 14);
		panel.add(lblSex);
		
		JComboBox sex_angajat = new JComboBox();
		sex_angajat.setModel(new DefaultComboBoxModel(new String[] {"MASCULIN ", "FEMININ"}));
		sex_angajat.setFont(new Font("Tahoma", Font.PLAIN, 15));
		sex_angajat.setBounds(151, 309, 235, 22);
		panel.add(sex_angajat);
		
		JLabel lblDepartament = new JLabel("Departament");
		lblDepartament.setForeground(new Color(102, 153, 204));
		lblDepartament.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDepartament.setBounds(402, 450, 89, 14);
		panel.add(lblDepartament);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(new Color(102, 153, 204));
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsername.setBounds(423, 390, 68, 14);
		panel.add(lblUsername);
		
		JLabel lblSalariu = new JLabel("Salariu");
		lblSalariu.setForeground(new Color(102, 153, 204));
		lblSalariu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSalariu.setBounds(44, 452, 68, 14);
		panel.add(lblSalariu);
		
		// creare casete text
		cod_angajat = new JTextField();
		cod_angajat.setColumns(10);
		cod_angajat.setBounds(139, 384, 235, 20);
		panel.add(cod_angajat);
		
		nume_angajat = new JTextField();
		nume_angajat.setColumns(10);
		nume_angajat.setBounds(139, 415, 235, 20);
		panel.add(nume_angajat);
		
		parola_angajat = new JTextField();
		parola_angajat.setColumns(10);
		parola_angajat.setBounds(509, 414, 235, 20);
		panel.add(parola_angajat);
		
		departament_angajat = new JTextField();
		departament_angajat.setColumns(10);
		departament_angajat.setBounds(509, 444, 235, 20);
		panel.add(departament_angajat);
		
			
		username_angajat = new JTextField();
		username_angajat.setColumns(10);
		username_angajat.setBounds(509, 384, 235, 20);
		panel.add(username_angajat);
		
			
		salariu_angajat = new JTextField();
		salariu_angajat.setColumns(10);
		salariu_angajat.setBounds(139, 446, 235, 20);
		panel.add(salariu_angajat);
		
				
		JButton btnNewButton = new JButton("Adauga");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
// if(username_angajat.getText() || parola_angajat.getText().isEmpty() ||	departament_angajat.getText() || salariu_angajat.getText().isEmpty()  ) {
//	 				
//	JOptionPane.showMessageDialog(null, "Completati toate campurile!");		
//	
//			}
				 	
				try {
				 
	// fct apelata in cazul in care utilizatorul (directorul ) doreste sa adauge noi angajati in baza de date
				
				
				PreparedStatement add = Login.con.prepareStatement("INSERT INTO  angajatiTABLE  VALUES ( ?, ?, ?, ?, ? , ? , ?)");
			    
			    add.setInt(1,Integer.valueOf(cod_angajat.getText()));
			    add.setString(2,nume_angajat.getText());
			    add.setString(3,username_angajat.getText());
			    add.setString(4,parola_angajat.getText());
			    add.setString(5,departament_angajat.getText());
			    add.setString(6,sex_angajat.getSelectedItem().toString());
			    add.setInt(7,Integer.valueOf(salariu_angajat.getText()));
			   
			    int row = add.executeUpdate();
			    
			    JOptionPane.showMessageDialog(null, "Angajat adaugat cu succes!");
			   Login.con.close();
			    SelectAngajat();
			    
			    }catch (Exception b) {
			    	b.printStackTrace();
			    	
			    }
			}
			});
		
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(42, 495, 117, 35);
		panel.add(btnNewButton);
		
		JButton btnSterge = new JButton("Elimina");
		btnSterge.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					
	// fct apelata in cazul in care utilizatorul doreste sa elimine un angajat din baza de date
					
				Login.con = DriverManager.getConnection("jdbc:derby:C:\\Users\\drops\\MyDB","angajat1","1234");
				String SId = cod_angajat.getText();
				String Query = "DELETE FROM angajatiTABLE where ID_ANGAJAT="+SId;
				Statement add = Login.con.createStatement();
				add.executeUpdate(Query);
				SelectAngajat();
				JOptionPane.showMessageDialog(null, "Angajat eliminat cu succes!");
				Login.con.close();
				}catch(Exception f) {
					f.printStackTrace();
				}
				
			}
		});
		btnSterge.setBounds(230, 495, 117, 35);
		panel.add(btnSterge);
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		// fct apelata in cazul in care utilizatorul doreste sa actualizeze informatii din baza de date		
				try {
					Login.con = DriverManager.getConnection("jdbc:derby:C:\\Users\\drops\\MyDB","angajat1","1234");

					String Query = "UPDATE angajatiTABLE SET NUME_ANGAJAT='"+ nume_angajat.getText()+"'"+ ", USERNAME ='"+username_angajat.getText()+"'"+ ", PAROLA='"+parola_angajat.getText()+"'"+ ", DEPARTAMENT='"+departament_angajat.getText()+"'"+", SEX='"+sex_angajat.getSelectedItem().toString()+"'"+" WHERE ID_ANGAJAT="+cod_angajat.getText();
					Statement add = Login.con.createStatement();
				    
				     
 
				   
				    add.executeUpdate(Query);
					JOptionPane.showMessageDialog(null, "Date angajat editate cu succes!");
					SelectAngajat();
					Login.con.close();
					
					
				}catch(SQLException f) {
					
					f.printStackTrace();
					
				}
				
				
			}
		});
		btnEdit.setBounds(434, 495, 117, 35);
		panel.add(btnEdit);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			// stergem continutul casetelor text
			cod_angajat.setText("");
			nume_angajat.setText("");
			username_angajat.setText("");
			parola_angajat.setText("");
			departament_angajat.setText("");
			salariu_angajat.setText("");
			
			
				
			}
		});
		btnClear.setBounds(627, 495, 117, 35);
		panel.add(btnClear);
		
		JLabel lblNewLabel_1_1 = new JLabel("STUDENTI");
		lblNewLabel_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// fct apelata pt redirectionarea utilizatorului catre pagina pt gestionarea studentilor
				
				new Studenti().frame.setVisible(true);
				Angajati.frame.setVisible(false);
				
				
			}
		});
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(55, 68, 123, 36);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel(" Logout");
		lblNewLabel_1_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			//fct apelata pt redirectionarea utilizatorului pe pagina de login	
				try {
				Login.con.close();
				}catch(Exception l) {
					l.printStackTrace();
				}
				new Login().frame.setVisible(true);
				Angajati.frame.setVisible(false);
			}
		});
		lblNewLabel_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1_1_2.setBounds(21, 504, 144, 36);
		frame.getContentPane().add(lblNewLabel_1_1_2);
		
	 
		
		 
		
	 
		
		 
		
		 
	}
}
