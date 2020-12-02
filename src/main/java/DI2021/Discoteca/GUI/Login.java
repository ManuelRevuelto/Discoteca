package DI2021.Discoteca.GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DI2021.Discoteca.models.Usuario;
import DI2021.Discoteca.services.UsuarioRecoveryService;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.UIManager;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField_Email;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 495, 269);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JTextPane txtpnUsuarioNoExiste = new JTextPane();
		txtpnUsuarioNoExiste.setBackground(UIManager.getColor("Button.light"));
		txtpnUsuarioNoExiste.setVisible(false);
		txtpnUsuarioNoExiste.setForeground(Color.RED);
		txtpnUsuarioNoExiste.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnUsuarioNoExiste.setText("Usuario No Existe");

		JTextPane txtpnErrorEnEl = new JTextPane();
		txtpnErrorEnEl.setVisible(false);
		txtpnErrorEnEl.setForeground(Color.RED);
		txtpnErrorEnEl.setBackground(UIManager.getColor("Button.light"));
		txtpnErrorEnEl.setFont(new Font("Tahoma", Font.PLAIN, 14));
		txtpnErrorEnEl.setText("Error en el password\r\n");

		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel lblPassword = new JLabel("PASSWORD");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JLabel lblTitulo = new JLabel("LOGIN");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 24));

		textField_Email = new JTextField();
		textField_Email.setColumns(10);

		passwordField = new JPasswordField();
		
		int click;
		JButton btnContinuar = new JButton("CONTINUAR");
		btnContinuar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				for (Usuario user : UsuarioRecoveryService.getAllUsuarios()) {
					if (textField_Email.getText().equals(user.getEmail())) {
						if (passwordField.getText().equals(user.getPassword())) {
							System.out.println("Ha funcionado");
							dispose();
						} else {
							txtpnErrorEnEl.setVisible(true);
						}
					} else {
						txtpnUsuarioNoExiste.setVisible(true);
						
						
					}
				}

			}
		});
		


		btnContinuar.setFont(new Font("Tahoma", Font.PLAIN, 16));

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup()
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup().addContainerGap(486, Short.MAX_VALUE)
								.addComponent(btnContinuar))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(27).addGroup(gl_contentPane
								.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createSequentialGroup().addGroup(gl_contentPane
										.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 102,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED).addComponent(passwordField,
														GroupLayout.PREFERRED_SIZE, 144, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPane.createSequentialGroup()
												.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 68,
														GroupLayout.PREFERRED_SIZE)
												.addPreferredGap(ComponentPlacement.RELATED)
												.addComponent(textField_Email, GroupLayout.PREFERRED_SIZE, 169,
														GroupLayout.PREFERRED_SIZE)))
										.addGap(52)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
												.addComponent(txtpnErrorEnEl, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
												.addComponent(txtpnUsuarioNoExiste, GroupLayout.PREFERRED_SIZE,
														GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
								.addComponent(lblTitulo, GroupLayout.PREFERRED_SIZE, 428, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED, 37, Short.MAX_VALUE)))
				.addContainerGap()));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup().addContainerGap()
						.addComponent(lblTitulo, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE).addGap(21)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
										.addComponent(lblEmail, GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
										.addComponent(txtpnUsuarioNoExiste, 0, 0, Short.MAX_VALUE))
								.addComponent(textField_Email, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addGap(47)
						.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 27,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 26,
												GroupLayout.PREFERRED_SIZE))
								.addComponent(txtpnErrorEnEl, GroupLayout.PREFERRED_SIZE, 27,
										GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(ComponentPlacement.RELATED, 21, Short.MAX_VALUE).addComponent(btnContinuar)
						.addContainerGap()));
		contentPane.setLayout(gl_contentPane);
	}
}
