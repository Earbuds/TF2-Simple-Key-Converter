package com.earbuds.tf2keyconverter;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Screen extends JFrame {

	private static final long serialVersionUID = 1L;
	
	JPanel contentPane;
	
	private JTextField keysInRefined;
	private JTextField budsInKeys;
	private JTextField keysInUSD;
	private JTextField amountOfKeys;
	
	public static float keysInRef, earbudsInKeys, keysInMoney, keys;
	
	public static float refInKeys, keysInEarbuds, moneyInKeys;
	private JTextField refinedInKeys;
	private JLabel lblAmountOfRefined;
	private JTextField keysInBuds;
	private JLabel lblAmountOfBuds;
	private JTextField USDInKeys;
	private JLabel lblUsdInKeys;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Screen frame = new Screen();
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
	public Screen() {
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		}catch (Exception exception) {
			exception.printStackTrace();
		}
		
		setResizable(false);
		setTitle("TF2 Key Converter v1");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 400);
		
		setLocationRelativeTo(null);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPriceOfKeys = new JLabel("Price of Keys in Refined");
		lblPriceOfKeys.setHorizontalAlignment(SwingConstants.CENTER);
		lblPriceOfKeys.setBounds(73, 41, 154, 14);
		contentPane.add(lblPriceOfKeys);
		
		keysInRefined = new JTextField();
		keysInRefined.setText("8.66");
		keysInRefined.setBounds(102, 66, 99, 20);
		contentPane.add(keysInRefined);
		keysInRefined.setColumns(10);
		
		JLabel lblPriceOfBuds = new JLabel("Price of Buds in Keys");
		lblPriceOfBuds.setHorizontalAlignment(SwingConstants.CENTER);
		lblPriceOfBuds.setBounds(234, 41, 129, 14);
		contentPane.add(lblPriceOfBuds);
		
		budsInKeys = new JTextField();
		budsInKeys.setText("16.5");
		budsInKeys.setBounds(248, 66, 99, 20);
		contentPane.add(budsInKeys);
		budsInKeys.setColumns(10);
		
		JLabel lblPriceOfKeys_1 = new JLabel("Price of Keys in USD");
		lblPriceOfKeys_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPriceOfKeys_1.setBounds(381, 41, 122, 14);
		contentPane.add(lblPriceOfKeys_1);
		
		keysInUSD = new JTextField();
		keysInUSD.setText("2.12");
		keysInUSD.setBounds(391, 66, 99, 20);
		contentPane.add(keysInUSD);
		keysInUSD.setColumns(10);
		
		JButton calculateButton = new JButton("Calculate!");
		calculateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		calculateButton.setBounds(247, 174, 99, 23);
		contentPane.add(calculateButton);
		
		JLabel lblAmountOfKeys = new JLabel("Amount of Keys");
		lblAmountOfKeys.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmountOfKeys.setBounds(247, 119, 99, 14);
		contentPane.add(lblAmountOfKeys);
		
		amountOfKeys = new JTextField();
		amountOfKeys.setText("1");
		amountOfKeys.setBounds(259, 143, 76, 20);
		contentPane.add(amountOfKeys);
		amountOfKeys.setColumns(10);
		
		refinedInKeys = new JTextField();
		refinedInKeys.setEditable(false);
		refinedInKeys.setText("8.66");
		refinedInKeys.setColumns(10);
		refinedInKeys.setBounds(102, 253, 99, 20);
		contentPane.add(refinedInKeys);
		
		lblAmountOfRefined = new JLabel("Refined in Keys");
		lblAmountOfRefined.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmountOfRefined.setBounds(73, 228, 150, 14);
		contentPane.add(lblAmountOfRefined);
		
		keysInBuds = new JTextField();
		keysInBuds.setEditable(false);
		keysInBuds.setText(".06");
		keysInBuds.setColumns(10);
		keysInBuds.setBounds(248, 253, 99, 20);
		contentPane.add(keysInBuds);
		
		lblAmountOfBuds = new JLabel("Buds in Keys");
		lblAmountOfBuds.setHorizontalAlignment(SwingConstants.CENTER);
		lblAmountOfBuds.setBounds(234, 228, 122, 14);
		contentPane.add(lblAmountOfBuds);
		
		USDInKeys = new JTextField();
		USDInKeys.setEditable(false);
		USDInKeys.setText("2.12");
		USDInKeys.setColumns(10);
		USDInKeys.setBounds(391, 253, 99, 20);
		contentPane.add(USDInKeys);
		
		lblUsdInKeys = new JLabel("USD in Keys");
		lblUsdInKeys.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsdInKeys.setBounds(381, 228, 115, 14);
		contentPane.add(lblUsdInKeys);
		
		calculateButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
				keysInRef = Float.parseFloat(keysInRefined.getText());
				earbudsInKeys = Float.parseFloat(budsInKeys.getText());
				keysInMoney = Float.parseFloat(keysInUSD.getText());
				keys = Float.parseFloat(amountOfKeys.getText());
				}catch(Exception exception) {
					exception.printStackTrace();
				}
				DecimalFormat df = new DecimalFormat("#.00"); // Format so numbers appear with 2 decimals
				
				float ref = Math.round(keys * keysInRef * 100) / 10; // Weird glitch here, doing Math.round(keys * keysInRef * 100) / 100 makes ref
				ref = ref / 10;										 // have 0's in both decimal points, but having ref / 10 on the next line puts numbers there
				double decimal = Math.round((ref - Math.floor(ref)) * 100) / 10;
				decimal = decimal / 10;
				ref = (float) Math.floor(ref);
				ref = (float) (ref + decimal + (decimal / 10));
				
				if(ref - Math.floor(ref) >= .90) {
					ref = (float) Math.ceil(ref);
				}
				
				float buds = Math.round((keys / earbudsInKeys) * 1000) / 10;
				buds = buds / 100;
				
				float usd = Math.round(keys * keysInMoney * 1000) / 10;
				usd = usd / 100;
				
				refinedInKeys.setText(df.format(ref));
				keysInBuds.setText(df.format(buds));
				USDInKeys.setText(df.format(usd));
			}
		});
	}
}
