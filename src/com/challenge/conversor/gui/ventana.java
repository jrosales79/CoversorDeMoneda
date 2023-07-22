package com.challenge.conversor.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.UIManager;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class ventana extends JFrame {

	private JPanel contentPane;
	private JTextField textDivisaInicial;
	private JTextField textDivisaFinal;
	private JComboBox comboBoxInicial;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventana frame = new ventana();
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
	public ventana() {
		setBackground(UIManager.getColor("ToolBar.dockingForeground"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 300);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.text);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblConversorDeMoneda = new JLabel("Conversor de Moneda");
		lblConversorDeMoneda.setHorizontalAlignment(SwingConstants.CENTER);
		lblConversorDeMoneda.setFont(new Font("Noto Sans Mono", Font.BOLD, 12));
		lblConversorDeMoneda.setBounds(226, 0, 163, 15);
		contentPane.add(lblConversorDeMoneda);
		
		textDivisaInicial = new JTextField();
		textDivisaInicial.setText("1");
		textDivisaInicial.setBounds(44, 56, 114, 24);
		contentPane.add(textDivisaInicial);
		textDivisaInicial.setColumns(10);
		
		textDivisaFinal = new JTextField();
		textDivisaFinal.setBounds(44, 92, 114, 24);
		contentPane.add(textDivisaFinal);
		textDivisaFinal.setColumns(10);
		
		String[] elementos = {"Soles", "Dolares", "Euros", "Libras Esterlinas", "Yen Japonés", "Won sul-coreano"};
		
		JComboBox<String> comboBoxInicial = new JComboBox<>(elementos);
		//comboBoxInicial.setModel(new DefaultComboBoxModel(new String[] {"Soles", "Dolares", "Euros", "Libras Esterlinas", "Yen Japonés", "Won sul-coreano"}));
		comboBoxInicial.setBackground(SystemColor.text);
		comboBoxInicial.setBounds(158, 56, 157, 24);
		contentPane.add(comboBoxInicial);
				
		JComboBox<String> comboBoxFinal = new JComboBox<>(elementos);
		//comboBoxFinal.setModel(new DefaultComboBoxModel(new String[] {"Soles", "Dolares", "Euros", "Libras Esterlinas", "Yen Japonés", "Won sul-coreano"}));
		comboBoxFinal.setSelectedIndex(1); // Establecer el segundo elemento como seleccionado al iniciar
		comboBoxFinal.setBackground(SystemColor.text);
		comboBoxFinal.setBounds(158, 92, 157, 24);
		contentPane.add(comboBoxFinal);
		comboBoxInicial.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// Obtiene el elemento seleccionado en JcomboBoxInicial
				String selectedItem = (String) comboBoxInicial.getSelectedItem();
				if (selectedItem != null) {
                    if (selectedItem.equals(comboBoxFinal.getSelectedItem())) {
                        
                    	// Obtener el índice actual del elemento seleccionado en JComboBoxFinal
                        int selectedIndex = comboBoxFinal.getSelectedIndex();

                        // Calcular el índice del siguiente elemento en la lista de JComboBoxFinal
                        int nextIndex = (selectedIndex + 1) % comboBoxFinal.getItemCount();
                        
                        // Seleccionar el siguiente elemento en JComboBoxFinal
                        comboBoxFinal.setSelectedIndex(nextIndex);
                    }
                }
            }
        });
			
		
		
	}
}
