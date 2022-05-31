package view;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.swing.*;

public class ChooseNameView extends JFrame {

	private JLabel introImg;
	private JButton nameButton;
	private JLabel nameLabel;
	private JLabel gameLabel;
	private JTextArea nameArea;
	private Font customFont;

	public ChooseNameView() {

		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setUndecorated(true);
		this.setVisible(true);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setTitle("Empire Building");

		introImg = new JLabel(new ImageIcon("Images/Backgroundver2.png"));
		this.setContentPane(introImg);

		nameButton = new JButton();
		nameButton.setText("Start");
		nameButton.setBounds(910, 660, 100, 30);
		nameButton.setFocusable(false);
		nameButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.add(nameButton);

		nameLabel = new JLabel("Enter Your Name");
		nameLabel.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		nameLabel.setForeground(Color.WHITE);
		nameLabel.setBounds(880, 550, 200, 20);
		this.add(nameLabel);

		try {
		    customFont = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts//EvilEmpire-4BBVK.ttf")).deriveFont(60f);
		    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		    ge.registerFont(customFont);
		} catch (IOException e) {
		    e.printStackTrace();
		} catch(FontFormatException e) {
		    e.printStackTrace();
		}

		gameLabel = new JLabel("THE CONQUERER");
		gameLabel.setFont(customFont);
		gameLabel.setForeground(Color.WHITE);
		gameLabel.setBounds(795, 450, 1000, 50);
		this.add(gameLabel);

		nameArea = new JTextArea();
		nameArea.setBounds(860, 600, 200, 30);
		nameArea.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		nameArea.setForeground(Color.BLACK);
		this.add(nameArea);
		
		
		Icon icon = new ImageIcon("Images/logoConquerer.gif");
        try {
        	JLabel logoLabel = new JLabel(icon);
            logoLabel.setVisible(true);
            logoLabel.setBounds(712, 60, 500, 500);
        	this.add(logoLabel);
        } catch (Exception e) {
        }

		this.revalidate();
		this.repaint();
	}

	public JLabel getIntroImg() {
		return introImg;
	}

	public void setIntroImg(JLabel introImg) {
		this.introImg = introImg;
	}

	public JButton getNameButton() {
		return nameButton;
	}

	public void setNameButton(JButton nameButton) {
		this.nameButton = nameButton;
	}

	public JLabel getNameLabel() {
		return nameLabel;
	}

	public void setNameLabel(JLabel nameLabel) {
		this.nameLabel = nameLabel;
	}

	public JLabel getGameLabel() {
		return gameLabel;
	}

	public void setGameLabel(JLabel gameLabel) {
		this.gameLabel = gameLabel;
	}

	public JTextArea getNameArea() {
		return nameArea;
	}

	public void setNameArea(JTextArea nameArea) {
		this.nameArea = nameArea;
	}

}
