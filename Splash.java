import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JProgressBar;

public class Splash extends JFrame {

	private JFrame frame;
	private JProgressBar progressBar;
	private JLabel lblNewLabel;
	
    public static void main (String[] args) {
    	
    	Splash Mysplash = new Splash();
    	Mysplash.frame.setVisible(true);
    
    	 
		try {
			for(int i = 0; i <= 100 ; i++) {
				
				Thread.sleep(40);
				Mysplash.progressBar.setValue(i);
				Mysplash.lblNewLabel.setText(Integer.toString(i) + "%");
			}
			
			}catch(Exception e){
				
			}
			
			new Login().frame.setVisible(true);
			Mysplash.frame.setVisible(false);
			
		}
	

	
	public Splash() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 153, 204));
		panel.setBounds(0, 0, 886, 527);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		final JLabel lblNewLabel_1 = new JLabel("School Management System");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 50));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(57, 11, 829, 61);
		panel.add(lblNewLabel_1);
		
		lblNewLabel = new JLabel("%");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(428, 483, 68, 33);
		panel.add(lblNewLabel);
		
		progressBar = new JProgressBar();
		progressBar.setBounds(0, 526, 886, 37);
		frame.getContentPane().add(progressBar);
	}
}
