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

public class WorldMapView extends JFrame {
	private JLabel worldMapImg;
	private JButton idleArmyButton;
	private JButton marchingArmyButton;
	private JButton besiegingArmyButton;
	private JLabel idleArmyLabel;
	private JLabel marchingArmyLabel;
	private JLabel besiegingArmyLabel;
	private JButton goToBattleViewButton;
	private JLabel viewNameLabel;
	private JButton viewGoldButton;
	private JButton viewFoodButton;
	private JButton viewTurnCountButton;
	private JButton viewNameButton;
	private JButton romeButton;
	private JButton cairoButton;
	private JButton spartaButton;
	private JList chooseArmyTargetList;
	private DefaultListModel listModel;
	private JScrollPane listScrollPane;
	private JTextArea unitsInfoArea;
	private JScrollPane unitsInfoAreaScrollable;
	private JButton attackWithArmy;
	private JButton cancelAttackWithArmy;
	private JButton endTurn;
	private JLabel availableArmiesToFight;
	private JLabel screenTransition;


	public WorldMapView() {
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setUndecorated(true);
		this.setVisible(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setTitle("Empire Building");
		this.setBackground(new Color(8, 24, 76));

		worldMapImg = new JLabel(new ImageIcon("Images/worldMapImage.gif"));
		this.setContentPane(worldMapImg);

		unitsInfoArea = new JTextArea();
		unitsInfoArea.setEditable(false);
		unitsInfoArea.setFont(new Font("Book Antiqua", Font.BOLD, 25));
		unitsInfoArea.setForeground(Color.WHITE);
		unitsInfoAreaScrollable = new JScrollPane(unitsInfoArea);
		unitsInfoAreaScrollable.setBounds(455, 400, 1050, 500);
		unitsInfoArea.setBackground(Color.BLACK);
		unitsInfoArea.setFocusable(false);
		unitsInfoAreaScrollable.setVisible(false);
		this.add(unitsInfoAreaScrollable);

		listModel = new DefaultListModel();
		chooseArmyTargetList = new JList(listModel);
		chooseArmyTargetList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		chooseArmyTargetList.setVisibleRowCount(5);
		chooseArmyTargetList.setBackground(Color.BLACK);
		chooseArmyTargetList.setFont(new Font("Book Antiqua", Font.BOLD, 25));
		chooseArmyTargetList.setForeground(Color.WHITE);
		chooseArmyTargetList.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		listScrollPane = new JScrollPane(chooseArmyTargetList);
		listScrollPane.setBounds(1600, 600, 200, 200);
		listScrollPane.setVisible(false);
		this.add(listScrollPane);

		attackWithArmy = new JButton();
		attackWithArmy.setText("Target City");
		attackWithArmy.setBounds(1200, 905, 150, 50);
		attackWithArmy.setFocusable(false);
		attackWithArmy.setVisible(false);
		attackWithArmy.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.add(attackWithArmy);

		cancelAttackWithArmy = new JButton();
		cancelAttackWithArmy.setText("Cancel");
		cancelAttackWithArmy.setBounds(1355, 905, 150, 50);
		cancelAttackWithArmy.setFocusable(false);
		cancelAttackWithArmy.setVisible(false);
		cancelAttackWithArmy.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.add(cancelAttackWithArmy);

		availableArmiesToFight = new JLabel("Available Armies to Send");
		availableArmiesToFight.setFont(new Font("Book Antiqua", Font.BOLD, 25));
		availableArmiesToFight.setVisible(false);
		availableArmiesToFight.setForeground(Color.WHITE);
		availableArmiesToFight.setBounds(1550, 455, 600, 250);
		this.add(availableArmiesToFight);

		endTurn = new JButton();
		endTurn.setIcon(new ImageIcon("Images/endTurnIcon.png"));
		endTurn.setBounds(110, 180, 160, 70);
		endTurn.setFocusable(false);
		endTurn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.add(endTurn);

		idleArmyButton = new JButton();
		idleArmyButton.setIcon(new ImageIcon("Images/idleArmyImage2.png"));
		idleArmyButton.setBounds(1512, 190, 400, 200);
		idleArmyButton.setFocusable(false);
		// idleArmyButton.setBorderPainted(false);
		idleArmyButton.setContentAreaFilled(false);
		idleArmyButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.add(idleArmyButton);

		marchingArmyButton = new JButton();
		marchingArmyButton.setIcon(new ImageIcon("Images/marchingArmyImage2.png"));
		marchingArmyButton.setBounds(1512, 455, 400, 200);
		marchingArmyButton.setFocusable(false);
//		marchingArmyButton.setOpaque(false);
		// marchingArmyButton.setBorderPainted(false);
		marchingArmyButton.setContentAreaFilled(false);
		marchingArmyButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.add(marchingArmyButton);

		besiegingArmyButton = new JButton();
		besiegingArmyButton.setIcon(new ImageIcon("Images/beseigingButton.png"));
		besiegingArmyButton.setBounds(1512, 725, 400, 200);
		besiegingArmyButton.setFocusable(false);
		// besiegingArmyButton.setBorderPainted(false);
		besiegingArmyButton.setContentAreaFilled(false);
		besiegingArmyButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.add(besiegingArmyButton);

		idleArmyLabel = new JLabel("View Idle Armies");
		idleArmyLabel.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		idleArmyLabel.setForeground(Color.WHITE);
		idleArmyLabel.setBounds(1630, 290, 600, 250);
		this.add(idleArmyLabel);

		marchingArmyLabel = new JLabel("View Marching Armies");
		marchingArmyLabel.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		marchingArmyLabel.setForeground(Color.WHITE);
		marchingArmyLabel.setBounds(1600, 555, 600, 250);
		this.add(marchingArmyLabel);

		besiegingArmyLabel = new JLabel("View Besieging Armies");
		besiegingArmyLabel.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		besiegingArmyLabel.setForeground(Color.WHITE);
		besiegingArmyLabel.setBounds(1600, 825, 600, 250);
		this.add(besiegingArmyLabel);

		viewNameButton = new JButton();
		viewNameButton.setIcon(new ImageIcon("Images/viewNameIcon.png"));
		viewNameButton.setBounds(10, 20, 160, 70);
		viewNameButton.setFocusable(false);
		viewNameButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.add(viewNameButton);

		viewGoldButton = new JButton();
		viewGoldButton.setIcon(new ImageIcon("Images/viewGoldIcon.png"));
		viewGoldButton.setContentAreaFilled(false);
		viewGoldButton.setBounds(10, 100, 160, 70);
		viewGoldButton.setFocusable(false);
		viewGoldButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.add(viewGoldButton);

		viewFoodButton = new JButton();
		viewFoodButton.setIcon(new ImageIcon("Images/viewFoodIcon.png"));
		viewFoodButton.setBounds(200, 100, 160, 70);
		viewFoodButton.setFocusable(false);
		viewFoodButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.add(viewFoodButton);

		viewTurnCountButton = new JButton();
		viewTurnCountButton.setIcon(new ImageIcon("Images/viewTurnCount.png"));
		viewTurnCountButton.setBounds(200, 20, 160, 70);
		viewTurnCountButton.setFocusable(false);
		viewTurnCountButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.add(viewTurnCountButton);

		romeButton = new JButton();
		romeButton.setBounds(752, 228, 170, 60);
		romeButton.setContentAreaFilled(false);
		romeButton.setFocusable(false);
		romeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.add(romeButton);

		cairoButton = new JButton();
		cairoButton.setBounds(930, 510, 185, 60);
		cairoButton.setContentAreaFilled(false);
		cairoButton.setFocusable(false);
		cairoButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.add(cairoButton);

		spartaButton = new JButton();
		spartaButton.setBounds(922, 752, 220, 60);
		spartaButton.setContentAreaFilled(false);
		spartaButton.setFocusable(false);
		spartaButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.add(spartaButton);
		
		screenTransition = new JLabel(new ImageIcon("Images/sceneTrans.gif"));
     	screenTransition.setVisible(true);
		//this.add(screenTransition);

		this.revalidate();
		this.repaint();
	}

	public JLabel getWorldMapImg() {
		return worldMapImg;
	}

	public void setWorldMapImg(JLabel worldMapImg) {
		this.worldMapImg = worldMapImg;
	}

	public JButton getIdleArmyButton() {
		return idleArmyButton;
	}

	public void setIdleArmyButton(JButton idleArmyButton) {
		this.idleArmyButton = idleArmyButton;
	}

	public JButton getMarchingArmyButton() {
		return marchingArmyButton;
	}

	public void setMarchingArmyButton(JButton marchingArmyButton) {
		this.marchingArmyButton = marchingArmyButton;
	}

	public JButton getBesiegingArmyButton() {
		return besiegingArmyButton;
	}

	public void setBesiegingArmyButton(JButton besiegingArmyButton) {
		this.besiegingArmyButton = besiegingArmyButton;
	}

	public JLabel getIdleArmyLabel() {
		return idleArmyLabel;
	}

	public void setIdleArmyLabel(JLabel idleArmyLabel) {
		this.idleArmyLabel = idleArmyLabel;
	}

	public JLabel getMarchingArmyLabel() {
		return marchingArmyLabel;
	}

	public void setMarchingArmyLabel(JLabel marchingArmyLabel) {
		this.marchingArmyLabel = marchingArmyLabel;
	}

	public JLabel getBesiegingArmyLabel() {
		return besiegingArmyLabel;
	}

	public void setBesiegingArmyLabel(JLabel besiegingArmyLabel) {
		this.besiegingArmyLabel = besiegingArmyLabel;
	}

	public JButton getGoToBattleViewButton() {
		return goToBattleViewButton;
	}

	public void setGoToBattleViewButton(JButton goToBattleViewButton) {
		this.goToBattleViewButton = goToBattleViewButton;
	}

	public JLabel getViewNameLabel() {
		return viewNameLabel;
	}

	public void setViewNameLabel(JLabel viewNameLabel) {
		this.viewNameLabel = viewNameLabel;
	}

	public JButton getViewGoldButton() {
		return viewGoldButton;
	}

	public void setViewGoldButton(JButton viewGoldButton) {
		this.viewGoldButton = viewGoldButton;
	}

	public JButton getViewFoodButton() {
		return viewFoodButton;
	}

	public void setViewFoodButton(JButton viewFoodButton) {
		this.viewFoodButton = viewFoodButton;
	}

	public JButton getViewTurnCountButton() {
		return viewTurnCountButton;
	}

	public void setViewTurnCountButton(JButton viewTurnCountButton) {
		this.viewTurnCountButton = viewTurnCountButton;
	}

	public JButton getViewNameButton() {
		return viewNameButton;
	}

	public void setViewNameButton(JButton viewNameButton) {
		this.viewNameButton = viewNameButton;
	}

	public JButton getRomeButton() {
		return romeButton;
	}

	public void setRomeButton(JButton romeButton) {
		this.romeButton = romeButton;
	}

	public JButton getCairoButton() {
		return cairoButton;
	}

	public void setCairoButton(JButton cairoButton) {
		this.cairoButton = cairoButton;
	}

	public JButton getSpartaButton() {
		return spartaButton;
	}

	public void setSpartaButton(JButton spartaButton) {
		this.spartaButton = spartaButton;
	}

	public JList getChooseArmyTargetList() {
		return chooseArmyTargetList;
	}

	public void setChooseArmyTargetList(JList chooseArmyTargetList) {
		this.chooseArmyTargetList = chooseArmyTargetList;
	}

	public DefaultListModel getListModel() {
		return listModel;
	}

	public void setListModel(DefaultListModel listModel) {
		this.listModel = listModel;
	}

	public JScrollPane getListScrollPane() {
		return listScrollPane;
	}

	public void setListScrollPane(JScrollPane listScrollPane) {
		this.listScrollPane = listScrollPane;
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

	public JButton getAttackWithArmy() {
		return attackWithArmy;
	}

	public void setAttackWithArmy(JButton attackWithArmy) {
		this.attackWithArmy = attackWithArmy;
	}

	public JButton getCancelAttackWithArmy() {
		return cancelAttackWithArmy;
	}

	public void setCancelAttackWithArmy(JButton cancelAttackWithArmy) {
		this.cancelAttackWithArmy = cancelAttackWithArmy;
	}

	public JButton getEndTurn() {
		return endTurn;
	}

	public void setEndTurn(JButton endTurn) {
		this.endTurn = endTurn;
	}

	public JLabel getAvailableArmiesToFight() {
		return availableArmiesToFight;
	}

	public void setAvailableArmiesToFight(JLabel availableArmiesToFight) {
		this.availableArmiesToFight = availableArmiesToFight;
	}
	
	public JLabel getScreenTransition() {
		return screenTransition;
	}

	public void setScreenTransition(JLabel screenTransition) {
		this.screenTransition = screenTransition;
	}

}
