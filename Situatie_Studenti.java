import java.awt.EventQueue;
import javax.swing.JScrollPane;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JLabel;
import java.awt.Font;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Situatie_Studenti {

	public static JFrame frame;
	private JTable table;
	private JTextField cod_student;
	private JTextField nume_student;
	private JTextField nota2;
	private JTextField medie;
	private JTextField nota1;
	private JTextField nota3;
	private JTextField nota4;
	private JTextField credite;
	 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Situatie_Studenti window = new Situatie_Studenti();
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
	public Situatie_Studenti() {
		initialize();
		SelectSituatie();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void SelectSituatie(){
		
		try {
			Login.con = DriverManager.getConnection("jdbc:derby:C:\\Users\\drops\\MyDB","angajat1","1234");
			Login.st = Login.con.createStatement();
			Login.rs = ((Statement) Login.st).executeQuery("SELECT * FROM ANGAJAT1.situatie_studenti");
			table.setModel(DbUtils.resultSetToTableModel(Login.rs));
		}catch(Exception e) {
			
			e.printStackTrace();
		}
				
		
	}
	
	private void initialize() {
		
		// creare frame
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(102, 153, 204));
		frame.getContentPane().setForeground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		//creare panel
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(201, 11, 775, 541);
		frame.getContentPane().add(panel);
		
		// creare tabel
		table = new JTable();
		 
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				// afisam in tabel informatiile din baza de date
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				int Myindex = table.getSelectedRow();
				cod_student.setText(model.getValueAt(Myindex,0).toString());
				nume_student.setText(model.getValueAt(Myindex,1).toString());
				nota1.setText(model.getValueAt(Myindex,3).toString());
				nota2.setText(model.getValueAt(Myindex,4).toString());
				nota3.setText(model.getValueAt(Myindex,5).toString());
				nota4.setText(model.getValueAt(Myindex,6).toString());
				medie.setText(model.getValueAt(Myindex,7).toString());
				credite.setText(model.getValueAt(Myindex,8).toString());
				
				
				
				
				
			}
		});
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
			},
			new String[] { // coloanele din tabel
				"ID STUDENT", "NUME", "NOTA1", "NOTA2", "NOTA3", "NOTA4", "Medie", "CREDITE", "DEPARTAMENT"
			}
		));
		
		table.setToolTipText("\r\n");
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBounds(42, 58, 702, 240);
		panel.add(table);
		
		// creare label-uri
		JLabel lblNewLabel_1 = new JLabel("Gestionare Situatie Studenti");
		lblNewLabel_1.setForeground(new Color(102, 153, 204));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(284, 11, 360, 36);
		panel.add(lblNewLabel_1);
		
		JLabel lblCodStud = new JLabel("Cod Student");
		lblCodStud.setForeground(new Color(102, 153, 204));
		lblCodStud.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCodStud.setBounds(42, 349, 99, 14);
		panel.add(lblCodStud);
		
		JLabel lblNume = new JLabel("Nume");
		lblNume.setForeground(new Color(102, 153, 204));
		lblNume.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNume.setBounds(42, 380, 89, 14);
		panel.add(lblNume);
		
		JLabel lblTelef = new JLabel("PIP");
		lblTelef.setForeground(new Color(102, 153, 204));
		lblTelef.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTelef.setBounds(42, 444, 68, 14);
		panel.add(lblTelef);
		
		JLabel dept = new JLabel("Departament");
		dept.setForeground(new Color(102, 153, 204));
		dept.setFont(new Font("Tahoma", Font.PLAIN, 15));
		dept.setBounds(43, 313, 98, 14);
		panel.add(dept);
		
		JLabel lblDepartament = new JLabel("MedieFinala");
		lblDepartament.setForeground(new Color(102, 153, 204));
		lblDepartament.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDepartament.setBounds(402, 414, 89, 14);
		panel.add(lblDepartament);
		
		JLabel Nota_1 = new JLabel("Robotica");
		Nota_1.setForeground(new Color(102, 153, 204));
		Nota_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Nota_1.setBounds(42, 414, 68, 14);
		panel.add(Nota_1);
		
		JLabel lblRc = new JLabel("RC");
		lblRc.setForeground(new Color(102, 153, 204));
		lblRc.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRc.setBounds(413, 344, 68, 14);
		panel.add(lblRc);
		
		 
		
		JLabel lblSh = new JLabel("SH");
		lblSh.setForeground(new Color(102, 153, 204));
		lblSh.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblSh.setBounds(413, 375, 68, 14);
		panel.add(lblSh);
		
		JLabel lblNrCredite = new JLabel("Nr Credite");
		lblNrCredite.setForeground(new Color(102, 153, 204));
		lblNrCredite.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNrCredite.setBounds(406, 447, 89, 14);
		panel.add(lblNrCredite);
		
		// creare casete text
		cod_student = new JTextField();
		cod_student.setColumns(10);
		cod_student.setBounds(139, 348, 235, 20);
		panel.add(cod_student);
		
		nume_student = new JTextField();
		nume_student.setColumns(10);
		nume_student.setBounds(139, 379, 235, 20);
		panel.add(nume_student);
		
		 		
		nota2 = new JTextField();
		nota2.setColumns(10);
		nota2.setBounds(138, 443, 235, 20);
		panel.add(nota2);
		
		 
		
		medie = new JTextField();
		medie.setColumns(10);
		medie.setBounds(509, 408, 235, 20);
		panel.add(medie);
		
		 
		
		nota1 = new JTextField();
		nota1.setColumns(10);
		nota1.setBounds(139, 410, 235, 20);
		panel.add(nota1);
		
		nota3 = new JTextField();
		nota3.setColumns(10);
		nota3.setBounds(509, 343, 235, 20);
		panel.add(nota3);
		
		nota4 = new JTextField();
		nota4.setColumns(10);
		nota4.setBounds(509, 374, 235, 20);
		panel.add(nota4);
		
		credite = new JTextField();
		credite.setColumns(10);
		credite.setBounds(507, 443, 239, 20);
		panel.add(credite);
		
		// creare caseta cu optiuni departamente
		 
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Robotica", "Calculatoare", "ISM", "Automatica"}));
		comboBox.setBounds(139, 309, 235, 28);
		panel.add(comboBox);
	
		
		JButton btnNewButton = new JButton("Adauga");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
// functie apelata in cazul in care utilizatorul doreste sa adauge informatii legate de situatia studentului
				
					try {
					 
						// citim notele din casetele text si calculam media lor 
						double nota_1=0,nota_2=0,nota_3=0,nota_4=0,medie_1;
						nota_1 = Double.valueOf(nota1.getText());
						nota_2 = Double.valueOf(nota2.getText());
						nota_3 = Double.valueOf(nota3.getText());
						nota_4 = Double.valueOf(nota4.getText());
						medie_1 = (nota_1 + nota_2 + nota_3 + nota_4)/4;
					 
					
					//  adaugam informatiile introduse in casetele text in baza de date
					PreparedStatement add = Login.con.prepareStatement("INSERT INTO  situatie_studenti  VALUES ( ?, ?, ?, ?, ? ,?,?,?,?)");
				    
				    add.setInt(1,Integer.valueOf(cod_student.getText()));
				    add.setString(2,nume_student.getText());
				    add.setString(3,comboBox.getSelectedItem().toString());
				    add.setDouble(4,Double.valueOf(nota1.getText()));
				    add.setDouble(5,Double.valueOf(nota2.getText()));
				    add.setDouble(6,Double.valueOf(nota3.getText()));
				    add.setDouble(7,Double.valueOf(nota4.getText()));
				    add.setDouble(8,Double.valueOf(medie_1));
				    add.setInt(9,Integer.valueOf(credite.getText()));
				    
				    
				     
				   
				    int row = add.executeUpdate();
				    
				    // mesaj 
				    JOptionPane.showMessageDialog(null, "Student adaugat cu succes!");
				   Login.con.close();
				    SelectSituatie();
				    
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
	// functie apelata in cazul in care utilizatorul doreste sa elimine un student din baza de date
				try {
					
					// ne conectam in baza de date si facem o interogare de tipul delete from
					Login.con = DriverManager.getConnection("jdbc:derby:C:\\Users\\drops\\MyDB","angajat1","1234");
					String SId = cod_student.getText();
					String Query = "DELETE FROM situatie_studenti where ID_STUDENT="+SId;
					Statement add = Login.con.createStatement();
					add.executeUpdate(Query);
					SelectSituatie();
					JOptionPane.showMessageDialog(null, "Student eliminat cu succes!");
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
			// fct apelata in cazul in care utilizatorul doreste sa actualizeze informatiile legate de un student 
				try {
					Login.con = DriverManager.getConnection("jdbc:derby:C:\\Users\\drops\\MyDB","angajat1","1234");
 
					String Query = "UPDATE situatie_studenti SET NUME_STUDENT='"+ nume_student.getText()+"'"+ ", NOTA1="+nota1.getText()+"" + ",NOTA2="+ nota2.getText()+"" + ", DEPARTAMENT='"+comboBox.getSelectedItem().toString()+"'"+"WHERE ID_STUDENT="+cod_student.getText();
					Statement add = Login.con.createStatement();
				    
				     
 
				   
				    add.executeUpdate(Query);
					JOptionPane.showMessageDialog(null, "Situatie student actualizata cu succes!");
					SelectSituatie();
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
				
				//stergem continutul casetelor text
				
				cod_student.setText("");
			    nume_student.setText("");
			    nota1.setText("");
			    nota2.setText("");
			    nota3.setText("");
			    nota4.setText("");
			    medie.setText("");
			    credite.setText("");
				
				
				
				
			}
		});
		btnClear.setBounds(627, 495, 117, 35);
		panel.add(btnClear);
		
		 
	}
}
