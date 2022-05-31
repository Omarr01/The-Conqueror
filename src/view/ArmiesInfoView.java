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

public class ArmiesInfoView extends JFrame {
	private JButton returnToWorld;
	private JList list;
	private DefaultListModel listModel;
	private JTextArea unitsInfoArea;
	private JScrollPane unitsInfoAreaScrollable;
	private JLabel chooseArmyLabel;
	private JLabel infoLabel;
	private JLabel goToWorldMapLabel;
	private JLabel marchingBackground;
	private JButton returnToCityView;
	private JLabel returnToCityLabel;
	private JScrollPane listScrollPane;
	private JButton breakSiege;

	public ArmiesInfoView() {
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setUndecorated(true);
		this.setVisible(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setTitle("Empire Building");

		this.setMarchingBackground(new JLabel(new ImageIcon("Images/viewArmyBackground.png")));
		this.setContentPane(this.getMarchingBackground());

		unitsInfoArea = new JTextArea();
		unitsInfoArea.setEditable(false);
		unitsInfoArea.setFont(new Font("Book Antiqua", Font.BOLD, 25));
		unitsInfoArea.setForeground(Color.WHITE);
		unitsInfoAreaScrollable = new JScrollPane(unitsInfoArea);
		unitsInfoAreaScrollable.setBounds(455, 400, 1050, 500);
		unitsInfoArea.setBackground(Color.BLACK);
		unitsInfoArea.setFocusable(false);
		this.add(unitsInfoAreaScrollable);

		listModel = new DefaultListModel();
		list = new JList(listModel);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setVisibleRowCount(5);
		list.setBackground(Color.BLACK);
		list.setFont(new Font("Book Antiqua", Font.BOLD, 25));
		list.setForeground(Color.WHITE);
		list.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		listScrollPane = new JScrollPane(list);
		listScrollPane.setBounds(1600, 600, 200, 200);
		this.add(listScrollPane);

		returnToWorld = new JButton();
		returnToWorld.setIcon(new ImageIcon("Images/worldMapIcon2.png"));
		returnToWorld.setContentAreaFilled(false);
		returnToWorld.setBounds(150, 950, 96, 68);
		returnToWorld.setFocusable(false);
		returnToWorld.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.add(returnToWorld);

		chooseArmyLabel = new JLabel("Choose Army");
		chooseArmyLabel.setFont(new Font("Book Antiqua", Font.BOLD, 30));
		chooseArmyLabel.setForeground(Color.WHITE);
		chooseArmyLabel.setBounds(1600, 440, 600, 250);
		this.add(chooseArmyLabel);

		infoLabel = new JLabel("Army's Information:");
		infoLabel.setFont(new Font("Book Antiqua", Font.BOLD, 40));
		infoLabel.setForeground(Color.WHITE);
		infoLabel.setBounds(790, 225, 600, 250);
		this.add(infoLabel);

		goToWorldMapLabel = new JLabel("Return to World Map");
		goToWorldMapLabel.setFont(new Font("Book Antiqua", Font.BOLD, 25));
		goToWorldMapLabel.setForeground(Color.WHITE);
		goToWorldMapLabel.setBounds(90, 930, 600, 220);
		this.add(goToWorldMapLabel);

		returnToCityView = new JButton();
		returnToCityView.setIcon(new ImageIcon("Images/cityBackgroundIcon.png"));
		returnToCityView.setContentAreaFilled(false);
		returnToCityView.setBounds(150, 940, 120, 80);
		returnToCityView.setFocusable(false);
		returnToCityView.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		returnToCityView.setVisible(false);
		this.add(returnToCityView);

		returnToCityLabel = new JLabel("Return to City");
		returnToCityLabel.setFont(new Font("Book Antiqua", Font.BOLD, 25));
		returnToCityLabel.setForeground(Color.WHITE);
		returnToCityLabel.setBounds(133, 930, 600, 220);
		returnToCityLabel.setVisible(false);
		this.add(returnToCityLabel);
		
		breakSiege = new JButton();
		breakSiege.setText("Break Siege");
		breakSiege.setBounds(900, 915, 150, 50);
		breakSiege.setFocusable(false);
		breakSiege.setVisible(false);
		breakSiege.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.add(breakSiege);
		
		

		this.revalidate();
		this.repaint();
	}

	public JButton getReturnToWorld() {
		return returnToWorld;
	}

	public void setReturnToWorld(JButton returnToWorld) {
		this.returnToWorld = returnToWorld;
	}

	public JList getList() {
		return list;
	}

	public void setList(JList list) {
		this.list = list;
	}

	public DefaultListModel getListModel() {
		return listModel;
	}

	public void setListModel(DefaultListModel listModel) {
		this.listModel = listModel;
	}

	public JTextArea getUnitsInfoArea() {
		return unitsInfoArea;
	}

	public void setUnitsInfoArea(JTextArea unitsInfoArea) {
		this.unitsInfoArea = unitsInfoArea;
	}

	public JScrollPane getUnitsInfoAreaScrollable() {
		return unitsInfoAreaScrollable;
	}

	public void setUnitsInfoAreaScrollable(JScrollPane unitsInfoAreaScrollable) {
		this.unitsInfoAreaScrollable = unitsInfoAreaScrollable;
	}

	public JLabel getChooseArmyLabel() {
		return chooseArmyLabel;
	}

	public void setChooseArmyLabel(JLabel chooseArmyLabel) {
		this.chooseArmyLabel = chooseArmyLabel;
	}

	public JLabel getInfoLabel() {
		return infoLabel;
	}

	public void setInfoLabel(JLabel infoLabel) {
		this.infoLabel = infoLabel;
	}

	public JLabel getGoToWorldMapLabel() {
		return goToWorldMapLabel;
	}

	public void setGoToWorldMapLabel(JLabel goToWorldMapLabel) {
		this.goToWorldMapLabel = goToWorldMapLabel;
	}

	public JLabel getMarchingBackground() {
		return marchingBackground;
	}

	public void setMarchingBackground(JLabel marchingBackground) {
		this.marchingBackground = marchingBackground;
	}

	public JButton getReturnToCityView() {
		return returnToCityView;
	}

	public void setReturnToCityView(JButton returnToCityView) {
		this.returnToCityView = returnToCityView;
	}

	public JLabel getReturnToCityLabel() {
		return returnToCityLabel;
	}

	public void setReturnToCityLabel(JLabel returnToCityLabel) {
		this.returnToCityLabel = returnToCityLabel;
	}

	public JScrollPane getListScrollPane() {
		return listScrollPane;
	}

	public void setListScrollPane(JScrollPane listScrollPane) {
		this.listScrollPane = listScrollPane;
	}

	public JButton getBreakSiege() {
		return breakSiege;
	}

	public void setBreakSiege(JButton breakSiege) {
		this.breakSiege = breakSiege;
	}
	
	

}
