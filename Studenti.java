import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Studenti {

	public static JFrame frame;
	private JTable table;
	private JTextField cod_student;
	private JTextField nume_student;
	private JTextField telefon_student;
	private JTextField departament_student;
	private JTextField domiciliu_student;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Studenti window = new Studenti();
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
	public Studenti() {
		initialize();
		SelectStudent();
	}

	/**
	 * Initialize the contents of the frame.
	 */
   public void SelectStudent() {
		
		try {
			Login.con = DriverManager.getConnection("jdbc:derby:C:\\Users\\drops\\MyDB","angajat1","1234");
			Login.st = Login.con.createStatement();
			Login.rs = ((Statement) Login.st).executeQuery("SELECT * FROM ANGAJAT1.studentiTABLE");
			table.setModel(DbUtils.resultSetToTableModel(Login.rs));
		}catch(Exception e) {
			
			e.printStackTrace();
		}
	}
	
	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(102, 153, 204));
		frame.setBounds(100, 100, 1000, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(201, 11, 775, 541);
		frame.getContentPane().add(panel);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				DefaultTableModel model = (DefaultTableModel)table.getModel();
				int Myindex = table.getSelectedRow();
				cod_student.setText(model.getValueAt(Myindex,0).toString());
				nume_student.setText(model.getValueAt(Myindex,1).toString());
				domiciliu_student.setText(model.getValueAt(Myindex,2).toString());
				telefon_student.setText(model.getValueAt(Myindex,3).toString());
				departament_student.setText(model.getValueAt(Myindex,4).toString());
				
				 
				
				
				
				
				
			}
		});
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"ID_Stud", "Nume_Stud", "Domiciliu", "Telefon", "Departament"
			}
		));
		table.setToolTipText("\r\n");
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setBounds(42, 58, 702, 240);
		panel.add(table);
		
		JLabel lblNewLabel_1 = new JLabel("Gestionare Studenti");
		lblNewLabel_1.setForeground(new Color(102, 153, 204));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(284, 11, 309, 36);
		panel.add(lblNewLabel_1);
		
		JLabel lblCodStud = new JLabel("Cod Student");
		lblCodStud.setForeground(new Color(102, 153, 204));
		lblCodStud.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCodStud.setBounds(42, 385, 99, 14);
		panel.add(lblCodStud);
		
		cod_student = new JTextField();
		cod_student.setColumns(10);
		cod_student.setBounds(139, 384, 235, 20);
		panel.add(cod_student);
		
		nume_student = new JTextField();
		nume_student.setColumns(10);
		nume_student.setBounds(139, 415, 235, 20);
		panel.add(nume_student);
		
		JLabel lblNume = new JLabel("Nume");
		lblNume.setForeground(new Color(102, 153, 204));
		lblNume.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNume.setBounds(42, 416, 89, 14);
		panel.add(lblNume);
		
		JLabel lblTelef = new JLabel("Telefon");
		lblTelef.setForeground(new Color(102, 153, 204));
		lblTelef.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTelef.setBounds(423, 391, 68, 14);
		panel.add(lblTelef);
		
		telefon_student = new JTextField();
		telefon_student.setColumns(10);
		telefon_student.setBounds(509, 385, 235, 20);
		panel.add(telefon_student);
		
		JLabel Sex = new JLabel("Sex");
		Sex.setForeground(new Color(102, 153, 204));
		Sex.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Sex.setBounds(43, 313, 47, 14);
		panel.add(Sex);
		
		JComboBox sex_stud = new JComboBox();
		sex_stud.setModel(new DefaultComboBoxModel(new String[] {"MASCULIN", "FEMININ"}));
		sex_stud.setFont(new Font("Tahoma", Font.PLAIN, 15));
		sex_stud.setBounds(83, 309, 235, 22);
		panel.add(sex_stud);
		
		departament_student = new JTextField();
		departament_student.setColumns(10);
		departament_student.setBounds(509, 444, 235, 20);
		panel.add(departament_student);
		
		JLabel lblDepartament = new JLabel("Departament");
		lblDepartament.setForeground(new Color(102, 153, 204));
		lblDepartament.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDepartament.setBounds(402, 450, 89, 14);
		panel.add(lblDepartament);
		
		domiciliu_student = new JTextField();
		domiciliu_student.setColumns(10);
		domiciliu_student.setBounds(139, 446, 235, 20);
		panel.add(domiciliu_student);
		
		JLabel lblAdresa = new JLabel("Domiciliu");
		lblAdresa.setForeground(new Color(102, 153, 204));
		lblAdresa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAdresa.setBounds(42, 450, 68, 14);
		panel.add(lblAdresa);
		
		JButton btnNewButton = new JButton("Adauga");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					 
					 
					
					
					PreparedStatement add = Login.con.prepareStatement("INSERT INTO  studentiTABLE  VALUES ( ?, ?, ?, ?, ? , ?)");
				    
				    add.setInt(1,Integer.valueOf(cod_student.getText()));
				    add.setString(2,nume_student.getText());
				    add.setString(3,domiciliu_student.getText());
				    add.setString(4,telefon_student.getText());
				    add.setString(5,departament_student.getText());
				    add.setString(6,sex_stud.getSelectedItem().toString());
				     
				   
				    int row = add.executeUpdate();
				    
				    JOptionPane.showMessageDialog(null, "Student adaugat cu succes!");
				   Login.con.close();
				    SelectStudent();
				    
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
					
					Login.con = DriverManager.getConnection("jdbc:derby:C:\\Users\\drops\\MyDB","angajat1","1234");
					String SId = cod_student.getText();
					String Query = "DELETE FROM studentiTABLE where ID_STUDENT="+SId;
					Statement add = Login.con.createStatement();
					add.executeUpdate(Query);
					SelectStudent();
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
				
				
				try {
					Login.con = DriverManager.getConnection("jdbc:derby:C:\\Users\\drops\\MyDB","angajat1","1234");

					String Query = "UPDATE studentiTABLE SET NUME_STUDENT='"+ nume_student.getText()+"'"+  ", TELEFON_STUDENT='"+telefon_student.getText()+"'"+  ", DEPARTAMENT_STUDENT='"+departament_student.getText()+"'"+", SEX_STUDENT='"+sex_stud.getSelectedItem().toString()+"'"+  ", DOMICILIU_STUDENT='"+domiciliu_student.getText()+"'" + " WHERE ID_STUDENT="+cod_student.getText();
					Statement add = Login.con.createStatement();
				    
				     
 
				   
				    add.executeUpdate(Query);
					JOptionPane.showMessageDialog(null, "Date student editate cu succes!");
					SelectStudent();
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
				
				
				cod_student.setText("");
				nume_student.setText("");
				departament_student.setText("");
				domiciliu_student.setText("");
				telefon_student.setText("");
				
			}
		});
		btnClear.setBounds(627, 495, 117, 35);
		panel.add(btnClear);
		
		JLabel lblNewLabel = new JLabel("ANGAJATI");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				new Angajati().frame.setVisible(true);
				Studenti.frame.setVisible(false);
				
			}
		});
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(63, 61, 128, 26);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Logout");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					Login.con.close();
					}catch(Exception l) {
						l.printStackTrace();
					}
					new Login().frame.setVisible(true);
					Studenti.frame.setVisible(false);
			}
		});
		
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(23, 519, 100, 33);
		frame.getContentPane().add(lblNewLabel_2);
	}
}
