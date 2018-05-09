package Siguria;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class One_Time_Pad extends JFrame {

	private JPanel contentPane;
	private JTextField txtplain;
	private JTextField key1;
	private JTextField txtcipher;
	private JTextField txtdecript;
	private JTextField key2;
	private JTextField txtdecript2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					One_Time_Pad frame = new One_Time_Pad();
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
	public One_Time_Pad() {
		setTitle("ONE TIME PAD ALGORITHM");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\DELL\\Desktop\\key1.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 726, 489);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtplain = new JTextField();
		txtplain.setFont(new Font("Courier New", Font.BOLD, 14));
		txtplain.setBounds(225, 45, 249, 20);
		contentPane.add(txtplain);
		txtplain.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Key");
		lblNewLabel_1.setFont(new Font("Courier New", Font.BOLD, 15));
		lblNewLabel_1.setBounds(225, 76, 46, 14);
		contentPane.add(lblNewLabel_1);
		
		key1 = new JTextField();
		key1.setFont(new Font("Courier New", Font.BOLD, 14));
		key1.setBounds(225, 94, 249, 20);
		contentPane.add(key1);
		key1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Ciphertext");
		lblNewLabel_2.setFont(new Font("Courier New", Font.BOLD, 15));
		lblNewLabel_2.setBounds(225, 129, 90, 14);
		contentPane.add(lblNewLabel_2);
		
		txtcipher = new JTextField();
		txtcipher.setFont(new Font("Courier New", Font.BOLD, 14));
		txtcipher.setBounds(225, 152, 249, 20);
		contentPane.add(txtcipher);
		txtcipher.setColumns(10);
		
		JButton btnEncript = new JButton("Encript");
		btnEncript.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				txtcipher.setText(enkripto(txtplain.getText(),key1.getText()));
			}
			
			public String enkripto(String plainteksti ,String qelsi)
			{
				String rezultati="";
				
				if(plainteksti.length()!=qelsi.length())
				{
					JOptionPane.showMessageDialog(null, "Plaintext and key must have the same length!");
					key1.requestFocus();
				}
				else {
					
					for(int i=0;i<plainteksti.length();i++)
					{
						rezultati+=(char)(plainteksti.charAt(i)^qelsi.charAt(i));
					}
				}
				
				return rezultati;
			}
		});
		btnEncript.setFont(new Font("Courier New", Font.BOLD, 15));
		btnEncript.setBounds(372, 179, 102, 23);
		contentPane.add(btnEncript);
		
		JLabel lblPlaintext = new JLabel("Plaintext");
		lblPlaintext.setFont(new Font("Courier New", Font.BOLD, 15));
		lblPlaintext.setBounds(225, 25, 90, 14);
		contentPane.add(lblPlaintext);
		
		JLabel lblDecripttext = new JLabel("Decripttext");
		lblDecripttext.setFont(new Font("Courier New", Font.BOLD, 15));
		lblDecripttext.setBounds(10, 266, 122, 14);
		contentPane.add(lblDecripttext);
		
		txtdecript = new JTextField();
		txtdecript.setFont(new Font("Courier New", Font.BOLD, 14));
		txtdecript.setBounds(10, 285, 249, 20);
		contentPane.add(txtdecript);
		txtdecript.setColumns(10);
		
		JButton btnDecript1 = new JButton("Decript");
		btnDecript1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				txtdecript.setText(dekripto(txtcipher.getText(),key1.getText()));
			}
			public String dekripto(String cipherteksti ,String qelsi)
			{
				String rezultati="";
				
				if(cipherteksti.length()!=qelsi.length())
				{
					JOptionPane.showMessageDialog(null, "Ciphertext and key must have the same length!");
					key1.requestFocus();
				}
				else {
					
					for(int i=0;i<cipherteksti.length();i++)
					{
						rezultati+=(char)(cipherteksti.charAt(i)^qelsi.charAt(i));
					}
				}
				
				return rezultati;
			}
		});
		btnDecript1.setFont(new Font("Courier New", Font.BOLD, 15));
		btnDecript1.setBounds(150, 311, 109, 23);
		contentPane.add(btnDecript1);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Man in the middle", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(353, 246, 284, 149);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblKey = new JLabel("\"Key\"");
		lblKey.setFont(new Font("Courier New", Font.BOLD, 15));
		lblKey.setBounds(10, 21, 46, 14);
		panel.add(lblKey);
		
		key2 = new JTextField();
		key2.setFont(new Font("Courier New", Font.BOLD, 14));
		key2.setBounds(10, 38, 249, 20);
		panel.add(key2);
		key2.setColumns(10);
		
		JLabel lbldecritptext = new JLabel("\"Decritpttext\"");
		lbldecritptext.setFont(new Font("Courier New", Font.BOLD, 15));
		lbldecritptext.setBounds(10, 67, 154, 14);
		panel.add(lbldecritptext);
		
		txtdecript2 = new JTextField();
		txtdecript2.setFont(new Font("Courier New", Font.BOLD, 14));
		txtdecript2.setBounds(10, 85, 249, 20);
		panel.add(txtdecript2);
		txtdecript2.setColumns(10);
		
		JButton btnDecript2 = new JButton("\"Decript\"");
		btnDecript2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				txtdecript2.setText(dekripto2(txtcipher.getText(),key2.getText()));
			}
			public String dekripto2(String cipherteksti ,String qelsi)
			{
				String rezultati="";
				
				if(cipherteksti.length()!=qelsi.length())
				{
					JOptionPane.showMessageDialog(null, "Ciphertext and key must have the same length!");
					key2.requestFocus();
				}
				else {
					
					for(int i=0;i<cipherteksti.length();i++)
					{
						rezultati+=(char)(cipherteksti.charAt(i)^qelsi.charAt(i));
					}
				}
				
				return rezultati;
			}
		});
		btnDecript2.setFont(new Font("Courier New", Font.BOLD, 15));
		btnDecript2.setBounds(133, 115, 126, 23);
		panel.add(btnDecript2);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				txtplain.setText("");
				txtcipher.setText("");
				txtdecript.setText("");
				txtdecript2.setText("");
				key1.setText("");
				key2.setText("");
				txtplain.requestFocus();
			}
		});
		btnClear.setFont(new Font("Courier New", Font.BOLD, 15));
		btnClear.setBounds(601, 416, 109, 23);
		contentPane.add(btnClear);
	}
}
