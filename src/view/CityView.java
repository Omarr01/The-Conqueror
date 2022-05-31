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

public class CityView extends JFrame {
	private JButton defendingArmy;
	private JLabel defendingArmyLabel;
	private JButton armiesInTheCity;
	private JLabel armiesInTheCityLabel;
	private JButton archeryRangeButton;
	private JLabel archeryRangeLabel;
	private JLabel archeryRangeLevelLabel;
	private JButton barracksButton;
	private JLabel barracksLabel;
	private JLabel barracksLevelLabel;
	private JButton farmButton;
	private JLabel farmLabel;
	private JLabel farmLevelLabel;
	private JButton marketButton;
	private JLabel marketLabel;
	private JLabel marketLevelLabel;
	private JButton stableButton;
	private JLabel stableLabel;
	private JLabel stableLevelLabel;
	private JButton returnToWorldMap;
	private JLabel returnToWorldMapLabel;
	private JButton viewGoldButton;
	private JButton viewFoodButton;
	private JButton viewTurnCountButton;
	private JButton viewNameButton;
	private JButton buyButton;
	private JButton upgradeButton;
	private JButton recruitButton;
	private JButton endTurn;
	private JButton relocateUnitsButton;
	private JLabel relocateUnitsLabel;
	private JButton initiateNewArmyButton;
	private JLabel initiateNewArmyLabel;
	private JButton cancelInitiate;
	private JButton initiate;
	private DefaultListModel listModelDefending;
	private JList listDefending;
	private JTextArea unitsInfoArea;
	private JScrollPane unitsInfoAreaScrollable;
	private JScrollPane listScrollPaneUnits;
	private JLabel defendingUnitsLabel;

	public CityView() {
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setUndecorated(true);
		this.setVisible(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setTitle("Empire Building");

		this.setContentPane(new JLabel(new ImageIcon("Images/cityBackgroundImage2.png")));

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

		listModelDefending = new DefaultListModel();
		listDefending = new JList(listModelDefending);
		listDefending.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listDefending.setVisibleRowCount(5);
		listDefending.setBackground(Color.BLACK);
		listDefending.setFont(new Font("Book Antiqua", Font.BOLD, 25));
		listDefending.setForeground(Color.WHITE);
		listDefending.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		listScrollPaneUnits = new JScrollPane(listDefending);
		listScrollPaneUnits.setBounds(1600, 600, 200, 200);
		listScrollPaneUnits.setVisible(false);
		this.add(listScrollPaneUnits);

		initiate = new JButton();
		initiate.setText("Initiate Army");
		initiate.setBounds(1200, 905, 150, 50);
		initiate.setFocusable(false);
		initiate.setVisible(false);
		initiate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.add(initiate);

		cancelInitiate = new JButton();
		cancelInitiate.setText("Cancel");
		cancelInitiate.setBounds(1355, 905, 150, 50);
		cancelInitiate.setFocusable(false);
		cancelInitiate.setVisible(false);
		cancelInitiate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.add(cancelInitiate);

		defendingUnitsLabel = new JLabel("Choose a Unit");
		defendingUnitsLabel.setFont(new Font("Book Antiqua", Font.BOLD, 25));
		defendingUnitsLabel.setVisible(false);
		defendingUnitsLabel.setForeground(Color.WHITE);
		defendingUnitsLabel.setBounds(1620, 455, 600, 250);
		this.add(defendingUnitsLabel);

		defendingArmy = new JButton();
		defendingArmy.setIcon(new ImageIcon("Images/defendingArmyImage.png"));
		defendingArmy.setBounds(470, 875, 180, 150);
		defendingArmy.setFocusable(false);
		defendingArmy.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.add(defendingArmy);

		relocateUnitsButton = new JButton();
		relocateUnitsButton.setIcon(new ImageIcon("Images/relocateUnitsImage.png"));
		relocateUnitsButton.setBounds(1000, 875, 180, 150);
		relocateUnitsButton.setFocusable(false);
		relocateUnitsButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.add(relocateUnitsButton);

		initiateNewArmyButton = new JButton();
		initiateNewArmyButton.setIcon(new ImageIcon("Images/newArmyImage2.png"));
		initiateNewArmyButton.setBounds(1230, 875, 180, 150);
		initiateNewArmyButton.setFocusable(false);
		initiateNewArmyButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.add(initiateNewArmyButton);

		defendingArmyLabel = new JLabel("View Defending Army");
		defendingArmyLabel.setFont(new Font("Book Antiqua", Font.BOLD, 18));
		defendingArmyLabel.setForeground(Color.WHITE);
		defendingArmyLabel.setBounds(460, 910, 500, 281);
		this.add(defendingArmyLabel);

		armiesInTheCity = new JButton();
		armiesInTheCity.setIcon(new ImageIcon("Images/armyInCityImage.png"));
		armiesInTheCity.setBounds(720, 875, 180, 150);
		armiesInTheCity.setFocusable(false);
		armiesInTheCity.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.add(armiesInTheCity);

		armiesInTheCityLabel = new JLabel("View Armies");
		armiesInTheCityLabel.setFont(new Font("Book Antiqua", Font.BOLD, 18));
		armiesInTheCityLabel.setForeground(Color.WHITE);
		armiesInTheCityLabel.setBounds(763, 910, 500, 281);
		this.add(armiesInTheCityLabel);

		relocateUnitsLabel = new JLabel("Relocate Units");
		relocateUnitsLabel.setFont(new Font("Book Antiqua", Font.BOLD, 18));
		relocateUnitsLabel.setForeground(Color.WHITE);
		relocateUnitsLabel.setBounds(1030, 910, 500, 281);
		this.add(relocateUnitsLabel);

		initiateNewArmyLabel = new JLabel("Initiate New Army");
		initiateNewArmyLabel.setFont(new Font("Book Antiqua", Font.BOLD, 18));
		initiateNewArmyLabel.setForeground(Color.WHITE);
		initiateNewArmyLabel.setBounds(1240, 910, 500, 281);
		this.add(initiateNewArmyLabel);

		archeryRangeButton = new JButton();
		archeryRangeButton.setIcon(new ImageIcon("Images/archeryRangeImage.png"));
		archeryRangeButton.setBounds(140, 500, 500, 281);
		archeryRangeButton.setFocusable(false);
		archeryRangeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.add(archeryRangeButton);

		archeryRangeLabel = new JLabel("Archery Range");
		archeryRangeLabel.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		archeryRangeLabel.setForeground(Color.WHITE);
		archeryRangeLabel.setBounds(320, 657, 500, 281);
		this.add(archeryRangeLabel);

		archeryRangeLevelLabel = new JLabel();
		archeryRangeLevelLabel.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		archeryRangeLevelLabel.setForeground(Color.WHITE);
		archeryRangeLevelLabel.setBounds(353, 682, 500, 281);
		archeryRangeLevelLabel.setVisible(false);
		this.add(archeryRangeLevelLabel);

		barracksButton = new JButton();
		barracksButton.setIcon(new ImageIcon("Images/barracksImage.png"));
		barracksButton.setBounds(720, 500, 500, 281);
		barracksButton.setFocusable(false);
		barracksButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.add(barracksButton);

		barracksLabel = new JLabel("Barracks");
		barracksLabel.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		barracksLabel.setForeground(Color.WHITE);
		barracksLabel.setBounds(925, 657, 500, 281);
		this.add(barracksLabel);

		barracksLevelLabel = new JLabel();
		barracksLevelLabel.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		barracksLevelLabel.setForeground(Color.WHITE);
		barracksLevelLabel.setBounds(928, 681, 500, 281);
		barracksLevelLabel.setVisible(false);
		this.add(barracksLevelLabel);

		stableButton = new JButton();
		stableButton.setIcon(new ImageIcon("Images/stableImage.png"));
		stableButton.setBounds(1300, 500, 500, 281);
		stableButton.setFocusable(false);
		stableButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.add(stableButton);

		stableLabel = new JLabel("Stable");
		stableLabel.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		stableLabel.setForeground(Color.WHITE);
		stableLabel.setBounds(1526, 657, 500, 281);
		this.add(stableLabel);

		stableLevelLabel = new JLabel();
		stableLevelLabel.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		stableLevelLabel.setForeground(Color.WHITE);
		stableLevelLabel.setBounds(1522, 681, 500, 281);
		stableLevelLabel.setVisible(false);
		this.add(stableLevelLabel);

		farmButton = new JButton();
		farmButton.setIcon(new ImageIcon("Images/farmImage.png"));
		farmButton.setBounds(450, 70, 465, 349);
		farmButton.setContentAreaFilled(false);
		farmButton.setFocusable(false);
		farmButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.add(farmButton);

		farmLabel = new JLabel("Farm");
		farmLabel.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		farmLabel.setForeground(Color.WHITE);
		farmLabel.setBounds(666, 300, 500, 281);
		this.add(farmLabel);

		farmLevelLabel = new JLabel();
		farmLevelLabel.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		farmLevelLabel.setForeground(Color.WHITE);
		farmLevelLabel.setBounds(658, 325, 500, 281);
		farmLevelLabel.setVisible(false);
		this.add(farmLevelLabel);

		marketButton = new JButton();
		marketButton.setIcon(new ImageIcon("Images/marketImage.png"));
		marketButton.setBounds(1000, 70, 465, 349);
		marketButton.setContentAreaFilled(false);
		marketButton.setFocusable(false);
		marketButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.add(marketButton);

		marketLabel = new JLabel("Market");
		marketLabel.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		marketLabel.setForeground(Color.WHITE);
		marketLabel.setBounds(1210, 300, 100, 281);
		this.add(marketLabel);

		marketLevelLabel = new JLabel();
		marketLevelLabel.setFont(new Font("Book Antiqua", Font.BOLD, 20));
		marketLevelLabel.setForeground(Color.WHITE);
		marketLevelLabel.setBounds(1208, 325, 100, 281);
		marketLevelLabel.setVisible(false);
		this.add(marketLevelLabel);

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

		endTurn = new JButton();
		endTurn.setIcon(new ImageIcon("Images/endTurnIcon.png"));
		endTurn.setBounds(110, 180, 160, 70);
		endTurn.setFocusable(false);
		endTurn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.add(endTurn);

		buyButton = new JButton();
		buyButton.setIcon(new ImageIcon("Images/buyIcon.png"));
		buyButton.setBounds(1600, 100, 160, 70);
		buyButton.setFocusable(false);
		buyButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.add(buyButton);

		upgradeButton = new JButton();
		upgradeButton.setIcon(new ImageIcon("Images/upgradeIcon.png"));
		upgradeButton.setBounds(1600, 200, 160, 70);
		upgradeButton.setFocusable(false);
		upgradeButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.add(upgradeButton);

		recruitButton = new JButton();
		recruitButton.setIcon(new ImageIcon("Images/recruitIcon.png"));
		recruitButton.setBounds(1600, 300, 160, 70);
		recruitButton.setFocusable(false);
		recruitButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.add(recruitButton);

		returnToWorldMap = new JButton();
		returnToWorldMap.setIcon(new ImageIcon("Images/worldMapIcon2.png"));
		returnToWorldMap.setContentAreaFilled(false);
		returnToWorldMap.setBounds(150, 950, 96, 68);
		returnToWorldMap.setFocusable(false);
		returnToWorldMap.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.add(returnToWorldMap);

		returnToWorldMapLabel = new JLabel("Return to World Map");
		returnToWorldMapLabel.setFont(new Font("Book Antiqua", Font.BOLD, 25));
		returnToWorldMapLabel.setForeground(Color.WHITE);
		returnToWorldMapLabel.setBounds(90, 930, 600, 220);
		this.add(returnToWorldMapLabel);

		this.revalidate();
		this.repaint();
	}

	public JButton getDefendingArmy() {
		return defendingArmy;
	}

	public void setDefendingArmy(JButton defendingArmy) {
		this.defendingArmy = defendingArmy;
	}

	public JButton getArmiesInTheCity() {
		return armiesInTheCity;
	}

	public void setArmiesInTheCity(JButton armiesInTheCity) {
		this.armiesInTheCity = armiesInTheCity;
	}

	public JButton getArcheryRangeButton() {
		return archeryRangeButton;
	}

	public void setArcheryRangeButton(JButton archeryRangeButton) {
		this.archeryRangeButton = archeryRangeButton;
	}

	public JButton getBarracksButton() {
		return barracksButton;
	}

	public void setBarracksButton(JButton barracksButton) {
		this.barracksButton = barracksButton;
	}

	public JButton getFarmButton() {
		return farmButton;
	}

	public void setFarmButton(JButton farmButton) {
		this.farmButton = farmButton;
	}

	public JButton getMarketButton() {
		return marketButton;
	}

	public void setMarketButton(JButton marketButton) {
		this.marketButton = marketButton;
	}

	public JButton getStableButton() {
		return stableButton;
	}

	public void setStableButton(JButton stableButton) {
		this.stableButton = stableButton;
	}

	public JButton getReturnToWorldMap() {
		return returnToWorldMap;
	}

	public void setReturnToWorldMap(JButton returnToWorldMap) {
		this.returnToWorldMap = returnToWorldMap;
	}

	public JLabel getReturnToWorldMapLabel() {
		return returnToWorldMapLabel;
	}

	public void setReturnToWorldMapLabel(JLabel returnToWorldMapLabel) {
		this.returnToWorldMapLabel = returnToWorldMapLabel;
	}

	public JLabel getArcheryRangeLabel() {
		return archeryRangeLabel;
	}

	public void setArcheryRangeLabel(JLabel archeryRangeLabel) {
		this.archeryRangeLabel = archeryRangeLabel;
	}

	public JLabel getBarracksLabel() {
		return barracksLabel;
	}

	public void setBarracksLabel(JLabel barracksLabel) {
		this.barracksLabel = barracksLabel;
	}

	public JLabel getFarmLabel() {
		return farmLabel;
	}

	public void setFarmLabel(JLabel farmLabel) {
		this.farmLabel = farmLabel;
	}

	public JLabel getMarketLabel() {
		return marketLabel;
	}

	public void setMarketLabel(JLabel marketLabel) {
		this.marketLabel = marketLabel;
	}

	public JLabel getStableLabel() {
		return stableLabel;
	}

	public void setStableLabel(JLabel stableLabel) {
		this.stableLabel = stableLabel;
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

	public JLabel getDefendingArmyLabel() {
		return defendingArmyLabel;
	}

	public void setDefendingArmyLabel(JLabel defendingArmyLabel) {
		this.defendingArmyLabel = defendingArmyLabel;
	}

	public JLabel getArmiesInTheCityLabel() {
		return armiesInTheCityLabel;
	}

	public void setArmiesInTheCityLabel(JLabel armiesInTheCityLabel) {
		this.armiesInTheCityLabel = armiesInTheCityLabel;
	}

	public JButton getBuyButton() {
		return buyButton;
	}

	public void setBuyButton(JButton buyButton) {
		this.buyButton = buyButton;
	}

	public JButton getUpgradeButton() {
		return upgradeButton;
	}

	public void setUpgradeButton(JButton upgradeButton) {
		this.upgradeButton = upgradeButton;
	}

	public JButton getRecruitButton() {
		return recruitButton;
	}

	public void setRecruitButton(JButton recruitButton) {
		this.recruitButton = recruitButton;
	}

	public JButton getEndTurn() {
		return endTurn;
	}

	public void setEndTurn(JButton endTurn) {
		this.endTurn = endTurn;
	}

	public JButton getrelocateUnitsButton() {
		return relocateUnitsButton;
	}

	public void setrelocateUnitsButton(JButton relocateUnitsButton) {
		this.relocateUnitsButton = relocateUnitsButton;
	}

	public JButton getInitiateNewArmyButton() {
		return initiateNewArmyButton;
	}

	public void setInitiateNewArmyButton(JButton initiateNewArmyButton) {
		this.initiateNewArmyButton = initiateNewArmyButton;
	}

	public JButton getRelocateUnitsButton() {
		return relocateUnitsButton;
	}

	public void setRelocateUnitsButton(JButton relocateUnitsButton) {
		this.relocateUnitsButton = relocateUnitsButton;
	}

	public JLabel getRelocateUnitsLabel() {
		return relocateUnitsLabel;
	}

	public void setRelocateUnitsLabel(JLabel relocateUnitsLabel) {
		this.relocateUnitsLabel = relocateUnitsLabel;
	}

	public JLabel getInitiateNewArmyLabel() {
		return initiateNewArmyLabel;
	}

	public void setInitiateNewArmyLabel(JLabel initiateNewArmyLabel) {
		this.initiateNewArmyLabel = initiateNewArmyLabel;
	}

	public JButton getCancelInitiate() {
		return cancelInitiate;
	}

	public void setCancelInitiate(JButton cancelInitiate) {
		this.cancelInitiate = cancelInitiate;
	}

	public JButton getInitiate() {
		return initiate;
	}

	public void setInitiate(JButton initiate) {
		this.initiate = initiate;
	}

	public DefaultListModel getListModelDefending() {
		return listModelDefending;
	}

	public void setListModelDefending(DefaultListModel listModelDefending) {
		this.listModelDefending = listModelDefending;
	}

	public JList getListDefending() {
		return listDefending;
	}

	public void setListDefending(JList listDefending) {
		this.listDefending = listDefending;
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

	public JScrollPane getListScrollPaneUnits() {
		return listScrollPaneUnits;
	}

	public void setListScrollPaneUnits(JScrollPane listScrollPaneUnits) {
		this.listScrollPaneUnits = listScrollPaneUnits;
	}

	public JLabel getDefendingUnitsLabel() {
		return defendingUnitsLabel;
	}

	public void setDefendingUnitsLabel(JLabel defendingUnitsLabel) {
		this.defendingUnitsLabel = defendingUnitsLabel;
	}

	public JLabel getArcheryRangeLevelLabel() {
		return archeryRangeLevelLabel;
	}

	public void setArcheryRangeLevelLabel(JLabel archeryRangeLevelLabel) {
		this.archeryRangeLevelLabel = archeryRangeLevelLabel;
	}

	public JLabel getBarracksLevelLabel() {
		return barracksLevelLabel;
	}

	public void setBarracksLevelLabel(JLabel barracksLevelLabel) {
		this.barracksLevelLabel = barracksLevelLabel;
	}

	public JLabel getFarmLevelLabel() {
		return farmLevelLabel;
	}

	public void setFarmLevelLabel(JLabel farmLevelLabel) {
		this.farmLevelLabel = farmLevelLabel;
	}

	public JLabel getMarketLevelLabel() {
		return marketLevelLabel;
	}

	public void setMarketLevelLabel(JLabel marketLevelLabel) {
		this.marketLevelLabel = marketLevelLabel;
	}

	public JLabel getStableLevelLabel() {
		return stableLevelLabel;
	}

	public void setStableLevelLabel(JLabel stableLevelLabel) {
		this.stableLevelLabel = stableLevelLabel;
	}

}
