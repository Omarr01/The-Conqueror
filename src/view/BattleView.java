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

public class BattleView extends JFrame {
	private JButton returnToWorld;
	private JList listDefending;
	private DefaultListModel listModelDefending;
	private JList listAttacking;
	private DefaultListModel listModelAttacking;
	private JTextArea battleLogArea;
	private JScrollPane battleLogAreaScrollable;
	private JLabel chooseArmyLabelDefending;
	private JLabel chooseArmyLabelAttacking;
	private JLabel battleLogLabel;
	private JLabel goToWorldMapLabel;
	private JLabel marchingBackground;
	private JButton simulateBattle;
	private JButton attack;
	private JTextArea battleUnitsChosenDefending;
	private JTextArea battleUnitsChosenAttacking;
	private JLabel fightingUnitsLabel;

	public BattleView() {
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setUndecorated(true);
		this.setVisible(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setTitle("Empire Building");

		this.setMarchingBackground(new JLabel(new ImageIcon("Images/battleBackground.jpg")));
		this.setContentPane(this.getMarchingBackground());

		simulateBattle = new JButton();
		simulateBattle.setText("Simulate");
		simulateBattle.setBounds(1010, 915, 150, 50);
		simulateBattle.setFocusable(false);
		simulateBattle.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.add(simulateBattle);

		attack = new JButton();
		attack.setText("Attack");
		attack.setBounds(820, 915, 150, 50);
		attack.setFocusable(false);
		attack.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.add(attack);

		battleLogArea = new JTextArea();
		battleLogArea.setEditable(false);
		battleLogArea.setFont(new Font("Book Antiqua", Font.BOLD, 25));
		battleLogArea.setForeground(Color.WHITE);
		battleLogAreaScrollable = new JScrollPane(battleLogArea);
		battleLogAreaScrollable.setBounds(500, 400, 930, 500);
		battleLogArea.setBackground(Color.BLACK);
		battleLogArea.setFocusable(false);
		this.add(battleLogAreaScrollable);

		battleUnitsChosenDefending = new JTextArea();
		battleUnitsChosenDefending.setEditable(false);
		battleUnitsChosenDefending.setFont(new Font("Book Antiqua", Font.BOLD, 25));
		battleUnitsChosenDefending.setForeground(Color.WHITE);
		battleUnitsChosenDefending.setBounds(500, 290, 930, 32);
		battleUnitsChosenDefending.setBackground(Color.BLACK);
		battleUnitsChosenDefending.setFocusable(false);
		this.add(battleUnitsChosenDefending);

		battleUnitsChosenAttacking = new JTextArea();
		battleUnitsChosenAttacking.setEditable(false);
		battleUnitsChosenAttacking.setFont(new Font("Book Antiqua", Font.BOLD, 25));
		battleUnitsChosenAttacking.setForeground(Color.WHITE);
		battleUnitsChosenAttacking.setBounds(500, 250, 930, 32);
		battleUnitsChosenAttacking.setBackground(Color.BLACK);
		battleUnitsChosenAttacking.setFocusable(false);
		this.add(battleUnitsChosenAttacking);

		listModelDefending = new DefaultListModel();
		listDefending = new JList(listModelDefending);
		listDefending.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listDefending.setVisibleRowCount(5);
		listDefending.setBackground(Color.BLACK);
		listDefending.setFont(new Font("Book Antiqua", Font.BOLD, 25));
		listDefending.setForeground(Color.WHITE);
		listDefending.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		JScrollPane listScrollPaneDefending = new JScrollPane(listDefending);
		listScrollPaneDefending.setBounds(1620, 600, 150, 200);
		this.add(listScrollPaneDefending);

		listModelAttacking = new DefaultListModel();
		listAttacking = new JList(listModelAttacking);
		listAttacking.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listAttacking.setVisibleRowCount(5);
		listAttacking.setBackground(Color.BLACK);
		listAttacking.setFont(new Font("Book Antiqua", Font.BOLD, 25));
		listAttacking.setForeground(Color.WHITE);
		listAttacking.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		JScrollPane listScrollPaneAttacking = new JScrollPane(listAttacking);
		listScrollPaneAttacking.setBounds(180, 600, 150, 200);
		this.add(listScrollPaneAttacking);

		returnToWorld = new JButton();
		returnToWorld.setIcon(new ImageIcon("Images/worldMapIcon2.png"));
		returnToWorld.setContentAreaFilled(false);
		returnToWorld.setBounds(150, 950, 96, 68);
		returnToWorld.setFocusable(false);
		returnToWorld.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.add(returnToWorld);

		chooseArmyLabelDefending = new JLabel("Defending Army Units");
		chooseArmyLabelDefending.setFont(new Font("Book Antiqua", Font.BOLD, 30));
		chooseArmyLabelDefending.setForeground(Color.WHITE);
		chooseArmyLabelDefending.setBounds(1550, 440, 600, 250);
		this.add(chooseArmyLabelDefending);

		chooseArmyLabelAttacking = new JLabel("Attacking Army Units");
		chooseArmyLabelAttacking.setFont(new Font("Book Antiqua", Font.BOLD, 30));
		chooseArmyLabelAttacking.setForeground(Color.WHITE);
		chooseArmyLabelAttacking.setBounds(110, 440, 600, 250);
		this.add(chooseArmyLabelAttacking);

		battleLogLabel = new JLabel("Battle Log:");
		battleLogLabel.setFont(new Font("Book Antiqua", Font.BOLD, 40));
		battleLogLabel.setForeground(Color.WHITE);
		battleLogLabel.setBounds(890, 245, 600, 250);
		this.add(battleLogLabel);

		fightingUnitsLabel = new JLabel("Fighting Units:");
		fightingUnitsLabel.setFont(new Font("Book Antiqua", Font.BOLD, 30));
		fightingUnitsLabel.setForeground(Color.WHITE);
		fightingUnitsLabel.setBounds(880, 90, 600, 250);
		this.add(fightingUnitsLabel);

		goToWorldMapLabel = new JLabel("Return to World Map");
		goToWorldMapLabel.setFont(new Font("Book Antiqua", Font.BOLD, 25));
		goToWorldMapLabel.setForeground(Color.WHITE);
		goToWorldMapLabel.setBounds(90, 930, 600, 220);
		this.add(goToWorldMapLabel);

		this.revalidate();
		this.repaint();
	}

	public JButton getReturnToWorld() {
		return returnToWorld;
	}

	public void setReturnToWorld(JButton returnToWorld) {
		this.returnToWorld = returnToWorld;
	}

	public JList getListDefending() {
		return listDefending;
	}

	public void setListDefending(JList listDefending) {
		this.listDefending = listDefending;
	}

	public DefaultListModel getListModelDefending() {
		return listModelDefending;
	}

	public void setListModelDefending(DefaultListModel listModelDefending) {
		this.listModelDefending = listModelDefending;
	}

	public JList getListAttacking() {
		return listAttacking;
	}

	public void setListAttacking(JList listAttacking) {
		this.listAttacking = listAttacking;
	}

	public DefaultListModel getListModelAttacking() {
		return listModelAttacking;
	}

	public void setListModelAttacking(DefaultListModel listModelAttacking) {
		this.listModelAttacking = listModelAttacking;
	}

	public JTextArea getBattleLogArea() {
		return battleLogArea;
	}

	public void setBattleLogArea(JTextArea battleLogArea) {
		this.battleLogArea = battleLogArea;
	}

	public JScrollPane getBattleLogAreaScrollable() {
		return battleLogAreaScrollable;
	}

	public void setBattleLogAreaScrollable(JScrollPane battleLogAreaScrollable) {
		this.battleLogAreaScrollable = battleLogAreaScrollable;
	}

	public JLabel getChooseArmyLabelDefending() {
		return chooseArmyLabelDefending;
	}

	public void setChooseArmyLabelDefending(JLabel chooseArmyLabelDefending) {
		this.chooseArmyLabelDefending = chooseArmyLabelDefending;
	}

	public JLabel getChooseArmyLabelAttacking() {
		return chooseArmyLabelAttacking;
	}

	public void setChooseArmyLabelAttacking(JLabel chooseArmyLabelAttacking) {
		this.chooseArmyLabelAttacking = chooseArmyLabelAttacking;
	}

	public JLabel getBattleLogLabel() {
		return battleLogLabel;
	}

	public void setBattleLogLabel(JLabel battleLogLabel) {
		this.battleLogLabel = battleLogLabel;
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

	public JButton getSimulateBattle() {
		return simulateBattle;
	}

	public void setSimulateBattle(JButton simulateBattle) {
		this.simulateBattle = simulateBattle;
	}

	public JButton getAttack() {
		return attack;
	}

	public void setAttack(JButton attack) {
		this.attack = attack;
	}

	public JTextArea getBattleUnitsChosenDefending() {
		return battleUnitsChosenDefending;
	}

	public void setBattleUnitsChosenDefending(JTextArea battleUnitsChosenDefending) {
		this.battleUnitsChosenDefending = battleUnitsChosenDefending;
	}

	public JTextArea getBattleUnitsChosenAttacking() {
		return battleUnitsChosenAttacking;
	}

	public void setBattleUnitsChosenAttacking(JTextArea battleUnitsChosenAttacking) {
		this.battleUnitsChosenAttacking = battleUnitsChosenAttacking;
	}

	public JLabel getFightingUnitsLabel() {
		return fightingUnitsLabel;
	}

	public void setFightingUnitsLabel(JLabel fightingUnitsLabel) {
		this.fightingUnitsLabel = fightingUnitsLabel;
	}

}
