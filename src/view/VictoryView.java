package view;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;

import java.awt.*;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class VictoryView extends JFrame {
	private JButton exitButton;
	private JLabel sceneImage;

	public VictoryView() {
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setUndecorated(true);
		this.setVisible(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setTitle("Empire Building");
		this.setBackground(new Color(8, 24, 76));

		sceneImage = new JLabel(new ImageIcon("Images/victoryScene.gif"));
		this.setContentPane(sceneImage);

		exitButton = new JButton();
		exitButton.setIcon(new ImageIcon("Images/exitButton.png"));
		exitButton.setBounds(1300, 45, 150, 150);
		exitButton.setFocusable(false);
		exitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.add(exitButton);
	}

	public JButton getExitButton() {
		return exitButton;
	}

	public void setExitButton(JButton exitButton) {
		this.exitButton = exitButton;
	}

	public JLabel getSceneImage() {
		return sceneImage;
	}

	public void setSceneImage(JLabel sceneImage) {
		this.sceneImage = sceneImage;
	}

}