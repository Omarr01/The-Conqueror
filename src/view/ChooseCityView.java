package view;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;

public class ChooseCityView extends JFrame {

	private JLabel introImg;
	private JButton city1Button;
	private JButton city2Button;
	private JButton city3Button;
	private JLabel city1Label;
	private JLabel city2Label;
	private JLabel city3Label;
	private JLabel chooseCityLabel;
	private JLabel gameLabel;
	private JLabel chooseCity;
	private Font customFont;

	public ChooseCityView() {
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setUndecorated(true);
		this.setVisible(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setTitle("Empire Building");

		introImg = new JLabel(new ImageIcon("Images/Backgroundver2.png"));
		this.setContentPane(introImg);

		try {
			customFont = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts//EvilEmpire-4BBVK.ttf")).deriveFont(20f);
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(customFont);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (FontFormatException e) {
			e.printStackTrace();
		}

//		gameLabel = new JLabel("THE CONQUERER");
//		gameLabel.setFont(customFont);
//		gameLabel.setForeground(Color.WHITE);
//		gameLabel.setBounds(1020, 315, 200, 30);
//		this.add(gameLabel);

		city1Button = new JButton();
		city1Button.setIcon(new ImageIcon("Images/cityRomeImage.jpg"));
		city1Button.setBounds(120, 460, 500, 500);
		city1Button.setFocusable(false);
		city1Button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.add(city1Button);

		city2Button = new JButton();
		city2Button.setIcon(new ImageIcon("Images/cityCairoImage.jpg"));
		city2Button.setBounds(715, 460, 500, 500);
		city2Button.setFocusable(false);
		city2Button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.add(city2Button);

		city3Button = new JButton();
		city3Button.setIcon(new ImageIcon("Images/citySpartaImage.jpg"));
		city3Button.setBounds(1300, 460, 500, 500);
		city3Button.setFocusable(false);
		city3Button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.add(city3Button);

		chooseCityLabel = new JLabel();
		chooseCityLabel.setFont(new Font("Book Antiqua", Font.BOLD, 40));
		chooseCityLabel.setForeground(Color.WHITE);
		chooseCityLabel.setBounds(0, 200, 2000, 50);
		chooseCityLabel.setHorizontalAlignment(JLabel.CENTER);
		this.add(chooseCityLabel);

		chooseCity = new JLabel("Choose A City");
		chooseCity.setFont(new Font("Book Antiqua", Font.BOLD, 40));
		chooseCity.setForeground(Color.WHITE);
		chooseCity.setBounds(835, 355, 400, 100);
		this.add(chooseCity);

		city1Label = new JLabel("Rome");
		city1Label.setFont(new Font("Book Antiqua", Font.BOLD, 30));
		city1Label.setForeground(Color.WHITE);
		city1Label.setBounds(330, 1000, 200, 30);
		this.add(city1Label);

		city2Label = new JLabel("Cairo");
		city2Label.setFont(new Font("Book Antiqua", Font.BOLD, 30));
		city2Label.setForeground(Color.WHITE);
		city2Label.setBounds(930, 1000, 200, 30);
		this.add(city2Label);

		city3Label = new JLabel("Sparta");
		city3Label.setFont(new Font("Book Antiqua", Font.BOLD, 30));
		city3Label.setForeground(Color.WHITE);
		city3Label.setBounds(1510, 1000, 200, 30);
		this.add(city3Label);

		Icon icon = new ImageIcon("Images/descirptionAnimated.gif");
		try {
			JLabel logoLabel = new JLabel(icon);
			logoLabel.setVisible(true);
			logoLabel.setBounds(280, 85, 1080, 300);
			this.add(logoLabel);
		} catch (Exception e) {
		}

		Icon icon2 = new ImageIcon("Images/logoConquerer.gif");
		try {
			JLabel logoLabel2 = new JLabel(icon2);
			logoLabel2.setVisible(true);
			logoLabel2.setBounds(1080, 68, 400, 400);
			this.add(logoLabel2);
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

	public JButton getCity1Button() {
		return city1Button;
	}

	public void setCity1Button(JButton city1Button) {
		this.city1Button = city1Button;
	}

	public JButton getCity2Button() {
		return city2Button;
	}

	public void setCity2Button(JButton city2Button) {
		this.city2Button = city2Button;
	}

	public JButton getCity3Button() {
		return city3Button;
	}

	public void setCity3Button(JButton city3Button) {
		this.city3Button = city3Button;
	}

	public JLabel getCity1Label() {
		return city1Label;
	}

	public void setCity1Label(JLabel city1Label) {
		this.city1Label = city1Label;
	}

	public JLabel getCity2Label() {
		return city2Label;
	}

	public void setCity2Label(JLabel city2Label) {
		this.city2Label = city2Label;
	}

	public JLabel getCity3Label() {
		return city3Label;
	}

	public void setCity3Label(JLabel city3Label) {
		this.city3Label = city3Label;
	}

	public JLabel getChooseCityLabel() {
		return chooseCityLabel;
	}

	public void setChooseCityLabel(JLabel chooseCityLabel) {
		this.chooseCityLabel = chooseCityLabel;
	}

	public JLabel getGameLabel() {
		return gameLabel;
	}

	public void setGameLabel(JLabel gameLabel) {
		this.gameLabel = gameLabel;
	}

}
