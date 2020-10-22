package test3;

import java.awt.Desktop;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.Scanner;

public class MyGui {

	private JFrame frame;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JTextField textFieldName;
	private JTextField textFieldPrice;
	private JLabel lblNewLabel_3;
	private JTextField textFieldIncome;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JTextField textFieldAddress;
	private JButton btnCheckButton;
	private JButton btnNewButton_2;
	private JTextArea textInspectAppraisal;
	private JButton btnAppraisal;
	private JButton btnApprove;
	private JButton btnNewButton_5;
	private JTextArea textAreaApprove;
	private JButton btnHelp;
	
	String clientName, address, price, income;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		MyGui window = new MyGui();
//		window.initialize();
	}

	/**
	 * Create the application.
	 */
	public MyGui() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 663, 558);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 652, 528);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		lblNewLabel_1 = new JLabel("Home Loan Application");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_1.setBounds(180, 33, 429, 59);
		panel_2.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("Applicant Name");
		lblNewLabel_2.setBounds(36, 122, 101, 14);
		panel_2.add(lblNewLabel_2);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(134, 119, 153, 20);
		panel_2.add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldPrice = new JTextField();
		textFieldPrice.setColumns(10);
		textFieldPrice.setBounds(134, 150, 153, 20);
		panel_2.add(textFieldPrice);
		
		lblNewLabel_3 = new JLabel("Offered Price");
		lblNewLabel_3.setBounds(36, 150, 86, 14);
		panel_2.add(lblNewLabel_3);
		
		textFieldIncome = new JTextField();
		textFieldIncome.setColumns(10);
		textFieldIncome.setBounds(456, 150, 153, 20);
		panel_2.add(textFieldIncome);
		
		lblNewLabel_4 = new JLabel("Gross Annual Income");
		lblNewLabel_4.setBounds(315, 153, 131, 14);
		panel_2.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Property Address");
		lblNewLabel_5.setBounds(315, 125, 131, 14);
		panel_2.add(lblNewLabel_5);
		
		textFieldAddress = new JTextField();
		textFieldAddress.setColumns(10);
		textFieldAddress.setBounds(456, 122, 153, 20);
		panel_2.add(textFieldAddress);
		
		JTextArea textAreaCredit = new JTextArea();
		textAreaCredit.setBounds(36, 232, 573, 63);
		panel_2.add(textAreaCredit);
		
		btnNewButton_2 = new JButton("House Inspect");
		btnNewButton_2.setBounds(36, 313, 119, 23);
		panel_2.add(btnNewButton_2);
		
		textInspectAppraisal = new JTextArea();
		textInspectAppraisal.setBounds(36, 345, 573, 49);
		panel_2.add(textInspectAppraisal);
		
		btnAppraisal = new JButton("Appraisal");
		btnAppraisal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Input datapicker = new Input();
				datapicker.datapicker();

				//String strOutput = "Applicant Name: " + clientName + "\nPrice: " + price + "\nAddress: " + address + "\nIncome: " + income;
				//textAreaCredit.setText(strOutput);
				
				System.out.println("Data entrred! Processing...");
			     
			     try {
					@SuppressWarnings("resource")
					Socket jsocket = new Socket("127.0.0.1", 9999);
					
				
					PrintWriter writer = new PrintWriter(jsocket.getOutputStream(), true);
					System.out.println("Sending a message sent to the server");
					
					writer.println("Applicant Name: " + clientName + "\nPrice: " + price + "\nAddress: " + address + "\nIncome: " + income);
					
					BufferedReader reader = new BufferedReader(new InputStreamReader(jsocket.getInputStream()));
					String from_server = reader.readLine();
					
					System.out.println("Recived a message from the server: "+ from_server);
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println(e);
					e.printStackTrace();
				}
			}
		});
		btnAppraisal.setBounds(168, 313, 119, 23);
		panel_2.add(btnAppraisal);
		
		btnApprove = new JButton("Approve");
		btnApprove.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File myfile = new File("filename.txt");
				String fileText = "";
				Scanner sc = null;
				try {
					sc = new Scanner (myfile);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				while (sc.hasNextLine() ) {
					fileText= fileText + sc.nextLine() + "\n";
				}
				System.out.println(fileText);
			}
		});
		btnApprove.setBounds(36, 415, 119, 23);
		panel_2.add(btnApprove);
		
		btnNewButton_5 = new JButton("Decline");
		btnNewButton_5.setBounds(168, 415, 119, 23);
		panel_2.add(btnNewButton_5);
		
		textAreaApprove = new JTextArea();
		textAreaApprove.setBounds(36, 447, 573, 49);
		panel_2.add(textAreaApprove);
		
		btnHelp = new JButton("Help");
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
                    Desktop d = Desktop.getDesktop();
                    URI URL = new URI("http://suniconnect.sunitafe.edu.au");
                    d.browse(URL);
                  } catch (Exception e0) {
                    e0.printStackTrace();
                  }
			}
		});
		btnHelp.setBounds(297, 415, 119, 23);
		panel_2.add(btnHelp);
		
		
		
		btnCheckButton = new JButton("Check Credit");
		btnCheckButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				

			}
		});
		
		btnCheckButton.setBounds(36, 200, 119, 23);
		panel_2.add(btnCheckButton);
		
		frame.setVisible(true);
	}
	
	class Input {
		void datapicker() {
			clientName = textFieldName.getText();
			address = textFieldAddress.getText();
			price = textFieldPrice.getText();
			income = textFieldIncome.getText();
		}
	}
}
