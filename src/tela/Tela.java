package tela;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.AbstractAction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;

import lexico.Lexer;
import javax.swing.JEditorPane;
import javax.swing.SwingConstants;

public class Tela extends JFrame {

	private JPanel contentPane;
	private Lexer lexico = null;
	String texto= null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
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
	public Tela() {
		setBackground(new Color(0, 0, 205));
		setTitle("Compilador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 500, 950, 800);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(211, 211, 211));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblCompiladorDaLinguagem = new JLabel("Compilador da Linguagem de Programação AkiRoda");
		lblCompiladorDaLinguagem.setHorizontalAlignment(SwingConstants.CENTER);
		lblCompiladorDaLinguagem.setLabelFor(lblCompiladorDaLinguagem);
		lblCompiladorDaLinguagem.setForeground(Color.BLACK);
		lblCompiladorDaLinguagem.setToolTipText("");
		lblCompiladorDaLinguagem.setBounds(12, 26, 856, 15);
		contentPane.add(lblCompiladorDaLinguagem);
		
		final JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(54, 89, 814, 208);
		contentPane.add(editorPane);
		
		
		
		
		final JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(54, 387, 357, 290);
		contentPane.add(textArea_1);
		
		JButton btnAnalisadorLexico = new JButton("Analisador Lexico");
		btnAnalisadorLexico.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				
				lexico = new Lexer(editorPane.getText().toString());
				textArea_1.setText(lexico.scan().toString());
				System.out.println(lexico.scan().toString());
				
			}
		});
		
		btnAnalisadorLexico.setBounds(92, 350, 166, 25);
		contentPane.add(btnAnalisadorLexico);
		
		JButton btnAnalisadorSintatico = new JButton("Analisador Sintatico");
		btnAnalisadorSintatico.setBounds(584, 350, 190, 25);
		contentPane.add(btnAnalisadorSintatico);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(0, 0, 50, 788);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBounds(42, 53, 838, 39);
		contentPane.add(panel_1);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(471, 387, 397, 290);
		contentPane.add(textArea);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(192, 192, 192));
		panel_2.setBounds(42, 654, 838, 134);
		contentPane.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(192, 192, 192));
		panel_3.setBounds(867, 0, 71, 788);
		contentPane.add(panel_3);
		
		
		
		
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
