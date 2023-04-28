package visual_28042023_windowbuilder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import javax.swing.JLayeredPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Ventana extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ventana frame = new Ventana();
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
	public Ventana() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 544, 406);
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(26, 26, 270, 276);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(58, 22, 169, 75);
		panel.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Conectar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					//registrar el conector
					Class.forName("com.mysql.cj.jdbc.Driver");
					//Hacer el conector
					String cadena="jdbc:mysql://localhost/test";
					Connection conn=DriverManager.getConnection(cadena,"root","");
					//lblNewLabel.setText(conn.toString());
					
					//Consulta
					PreparedStatement ps =conn.prepareStatement("select * from clientes");
					ResultSet rs=ps.executeQuery();
					//lblNewLabel.setText(conn.toString());
					StringBuilder sb=new StringBuilder();
					while(rs.next()) {
						sb.append(rs.getString(2));
					}
					lblNewLabel.setText(sb.toString());
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
 catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
				
			}// cierra el metodo
		});
		btnNewButton.setBounds(96, 126, 89, 23);
		panel.add(btnNewButton);
	}
}
