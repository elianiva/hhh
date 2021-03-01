/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package kasir.ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.formdev.flatlaf.FlatLightLaf;

import kasir.controllers.UserSource;
import kasir.models.User;

/**
*
* @author elianiva
*/
public class Login extends javax.swing.JFrame {
	/**
	 * Creates new form login
	 */
	public Login() {
		initComponents();
	}

	/**
	 * Execute user login
	 */
	private void executeLogin() {
		String username = usernameField.getText();
		String password = String.valueOf(passwordField.getPassword());

		if (username.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Username tidak boleh kosong!");
			usernameField.requestFocus();
			return;
		}

		if (password.isEmpty()) {
			JOptionPane.showMessageDialog(this, "Password tidak boleh kosong!");
			passwordField.requestFocus();
			return;
		}

		try {
			UserSource userSource = new UserSource();
			User user = new User();
			user.setUsername(username);
			user.setPassword(password);
			User currentUser = userSource.find(user);

			if (currentUser == null) {
				JOptionPane.showMessageDialog(this, "User tidak terdaftar!");
				return;
			}

			int userLevel = (int)currentUser.getLevelID();
			if (userLevel == 1) {
				Admin adminWindow = new Admin();
				adminWindow.setVisible(true);
				adminWindow.setTitle("Halaman Admin");
				adminWindow.setResizable(false);
				adminWindow.setLocationRelativeTo(null); // center the window
			} else if (userLevel == 2) {
				Kasir orderWindow = new Kasir();
				orderWindow.setVisible(true);
				orderWindow.setTitle("Halaman Kasir");
				orderWindow.setResizable(false);
				orderWindow.setLocationRelativeTo(null); // center the window
				this.dispose();
			} else if (userLevel == 5) {

			}
		} catch (SQLException ex) {
			System.out.println(ex);
		}
	}

	/**
	* This method is called from within the constructor to initialize the
	* form. WARNING: Do NOT modify this code. The content of this method is
	* always regenerated by the Form Editor.
	*/
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		windowTitle = new javax.swing.JLabel();
		usernameField = new javax.swing.JTextField();
		usernameLabel = new javax.swing.JLabel();
		passwordLabel = new javax.swing.JLabel();
		passwordField = new javax.swing.JPasswordField();
		passwordToggle = new javax.swing.JCheckBox();
		loginButton = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		windowTitle.setFont(new java.awt.Font("Inter", 1, 24)); // NOI18N
		windowTitle.setText("Login");

		usernameField.setFont(new java.awt.Font("Inter", 0, 16)); // NOI18N
		usernameField.setToolTipText("Username");

		usernameLabel.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
		usernameLabel.setText("Username");

		passwordLabel.setFont(new java.awt.Font("Inter", 0, 14)); // NOI18N
		passwordLabel.setText("Password");

		passwordField.setFont(new java.awt.Font("Inter", 0, 16)); // NOI18N

		passwordToggle.setText("Show Password");
		passwordToggle.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		passwordToggle.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				passwordToggleActionPerformed(evt);
			}
		});

		loginButton.setFont(new java.awt.Font("Inter", 0, 16)); // NOI18N
		loginButton.setText("Login");
		loginButton.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				executeLogin();
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
			layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(layout.createSequentialGroup()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
					.addGroup(layout.createSequentialGroup()
						.addGap(162, 162, 162)
						.addComponent(windowTitle))
					.addGroup(layout.createSequentialGroup()
						.addGap(35, 35, 35)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
							.addComponent(passwordToggle)
							.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(usernameLabel)
								.addComponent(usernameField)
								.addComponent(passwordLabel)
								.addComponent(passwordField, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE))))
					.addGroup(layout.createSequentialGroup()
						.addGap(160, 160, 160)
						.addComponent(loginButton)))
				.addContainerGap(41, Short.MAX_VALUE))
		);
		layout.setVerticalGroup(
			layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
			.addGroup(layout.createSequentialGroup()
				.addGap(22, 22, 22)
				.addComponent(windowTitle)
				.addGap(17, 17, 17)
				.addComponent(usernameLabel)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
				.addComponent(usernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addGap(17, 17, 17)
				.addComponent(passwordLabel)
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
				.addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
				.addGap(18, 18, 18)
				.addComponent(passwordToggle)
				.addGap(18, 18, 18)
				.addComponent(loginButton)
				.addContainerGap(30, Short.MAX_VALUE))
		);

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void passwordToggleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordToggleActionPerformed
		if (passwordToggle.isSelected()) {
			passwordField.setEchoChar((char)0);
		} else {
			passwordField.setEchoChar('\u2022'); // this is a circle unicode
		}
	}//GEN-LAST:event_passwordToggleActionPerformed

	/**
	* @param args the command line arguments
	*/
	public static void main(String args[]) {
		// use better look and feel
		try {
			UIManager.setLookAndFeel(new FlatLightLaf());
		} catch (UnsupportedLookAndFeelException e){
			System.out.println(e);
		}

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Login().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton loginButton;
	private javax.swing.JPasswordField passwordField;
	private javax.swing.JLabel passwordLabel;
	private javax.swing.JCheckBox passwordToggle;
	private javax.swing.JTextField usernameField;
	private javax.swing.JLabel usernameLabel;
	private javax.swing.JLabel windowTitle;
	// End of variables declaration//GEN-END:variables
}
