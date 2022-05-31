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

public class RelocateView extends JFrame {
	private JList listFrom;
	private DefaultListModel listModelFrom;
	private JList listTo;
	private DefaultListModel listModelTo;
	private JList listUnits;
	private DefaultListModel listModelUnits;
	private JTextArea unitInfo;
	private JScrollPane unitInfoScrollable;
	private JLabel chooseArmyLabelFrom;
	private JLabel chooseArmyLabelTo;
	private JLabel unitInfoLabel;
	private JButton returnToCityView;
	private JLabel returnToCityLabel;
	private JLabel marchingBackground;
	private JButton createArmy;
	private JButton relocate;
	private JButton relocateAll;
	private JScrollPane listFromScrollPane;
	private JScrollPane listToScrollPane;
	private JScrollPane listUnitsScrollUnits;
	private JLabel chooseUnitLabel;

	public RelocateView() {
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setUndecorated(true);
		this.setVisible(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setTitle("Empire Building");

		this.setMarchingBackground(new JLabel(new ImageIcon("Images/relocateUnitsBackground.png")));
		this.setContentPane(this.getMarchingBackground());

		relocate = new JButton();
		relocate.setText("Relocate");
		relocate.setBounds(830, 915, 150, 50);
		relocate.setFocusable(false);
		relocate.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.add(relocate);

		relocateAll = new JButton();
		relocateAll.setText("Relocate All");
		relocateAll.setBounds(1040, 915, 150, 50);
		relocateAll.setFocusable(false);
		relocateAll.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.add(relocateAll);

		unitInfo = new JTextArea();
		unitInfo.setEditable(false);
		unitInfo.setFont(new Font("Book Antiqua", Font.BOLD, 25));
		unitInfo.setForeground(Color.WHITE);
		unitInfoScrollable = new JScrollPane(unitInfo);
		unitInfoScrollable.setBounds(490, 400, 1040, 500);
		unitInfo.setBackground(Color.BLACK);
		unitInfo.setFocusable(false);
		this.add(unitInfoScrollable);

		listModelFrom = new DefaultListModel();
		listFrom = new JList(listModelFrom);
		listFrom.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listFrom.setVisibleRowCount(5);
		listFrom.setBackground(Color.BLACK);
		listFrom.setFont(new Font("Book Antiqua", Font.BOLD, 25));
		listFrom.setForeground(Color.WHITE);
		listFrom.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		listFromScrollPane = new JScrollPane(listFrom);
		listFromScrollPane.setBounds(80, 600, 150, 200);
		this.add(listFromScrollPane);

		listModelUnits = new DefaultListModel();
		listUnits = new JList(listModelUnits);
		listUnits.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listUnits.setVisibleRowCount(5);
		listUnits.setBackground(Color.BLACK);
		listUnits.setFont(new Font("Book Antiqua", Font.BOLD, 25));
		listUnits.setForeground(Color.WHITE);
		listUnits.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		listUnitsScrollUnits = new JScrollPane(listUnits);
		listUnitsScrollUnits.setBounds(280, 600, 150, 200);
		this.add(listUnitsScrollUnits);

		listModelTo = new DefaultListModel();
		listTo = new JList(listModelTo);
		listTo.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listTo.setVisibleRowCount(5);
		listTo.setBackground(Color.BLACK);
		listTo.setFont(new Font("Book Antiqua", Font.BOLD, 25));
		listTo.setForeground(Color.WHITE);
		listTo.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		listToScrollPane = new JScrollPane(listTo);
		listToScrollPane.setBounds(1560, 600, 150, 200);
		this.add(listToScrollPane);

		chooseArmyLabelTo = new JLabel("Relocate To");
		chooseArmyLabelTo.setFont(new Font("Book Antiqua", Font.BOLD, 30));
		chooseArmyLabelTo.setForeground(Color.WHITE);
		chooseArmyLabelTo.setBounds(1550, 440, 600, 250);
		this.add(chooseArmyLabelTo);

		chooseUnitLabel = new JLabel("Choose Unit");
		chooseUnitLabel.setFont(new Font("Book Antiqua", Font.BOLD, 30));
		chooseUnitLabel.setForeground(Color.WHITE);
		chooseUnitLabel.setBounds(280, 440, 600, 250);
		this.add(chooseUnitLabel);

		chooseArmyLabelFrom = new JLabel("Relocate From");
		chooseArmyLabelFrom.setFont(new Font("Book Antiqua", Font.BOLD, 30));
		chooseArmyLabelFrom.setForeground(Color.WHITE);
		chooseArmyLabelFrom.setBounds(50, 440, 600, 250);
		this.add(chooseArmyLabelFrom);

		unitInfoLabel = new JLabel("Unit Info:");
		unitInfoLabel.setFont(new Font("Book Antiqua", Font.BOLD, 40));
		unitInfoLabel.setForeground(Color.WHITE);
		unitInfoLabel.setBounds(910, 245, 600, 250);
		this.add(unitInfoLabel);

		returnToCityView = new JButton();
		returnToCityView.setIcon(new ImageIcon("Images/cityBackgroundIcon.png"));
		returnToCityView.setContentAreaFilled(false);
		returnToCityView.setBounds(150, 940, 120, 80);
		returnToCityView.setFocusable(false);
		returnToCityView.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		this.add(returnToCityView);

		returnToCityLabel = new JLabel("Return to City");
		returnToCityLabel.setFont(new Font("Book Antiqua", Font.BOLD, 25));
		returnToCityLabel.setForeground(Color.WHITE);
		returnToCityLabel.setBounds(133, 930, 600, 220);
		this.add(returnToCityLabel);

		this.revalidate();
		this.repaint();
	}

	public JList getListFrom() {
		return listFrom;
	}

	public void setListFrom(JList listFrom) {
		this.listFrom = listFrom;
	}

	public DefaultListModel getListModelFrom() {
		return listModelFrom;
	}

	public void setListModelFrom(DefaultListModel listModelFrom) {
		this.listModelFrom = listModelFrom;
	}

	public JList getListTo() {
		return listTo;
	}

	public void setListTo(JList listTo) {
		this.listTo = listTo;
	}

	public DefaultListModel getListModelTo() {
		return listModelTo;
	}

	public void setListModelTo(DefaultListModel listModelTo) {
		this.listModelTo = listModelTo;
	}

	public JTextArea getUnitInfo() {
		return unitInfo;
	}

	public void setUnitInfo(JTextArea unitInfo) {
		this.unitInfo = unitInfo;
	}

	public JScrollPane getUnitInfoScrollable() {
		return unitInfoScrollable;
	}

	public void setUnitInfoScrollable(JScrollPane unitInfoScrollable) {
		this.unitInfoScrollable = unitInfoScrollable;
	}

	public JLabel getChooseArmyLabelFrom() {
		return chooseArmyLabelFrom;
	}

	public void setChooseArmyLabelFrom(JLabel chooseArmyLabelFrom) {
		this.chooseArmyLabelFrom = chooseArmyLabelFrom;
	}

	public JLabel getChooseArmyLabelTo() {
		return chooseArmyLabelTo;
	}

	public void setChooseArmyLabelTo(JLabel chooseArmyLabelTo) {
		this.chooseArmyLabelTo = chooseArmyLabelTo;
	}

	public JLabel getUnitInfoLabel() {
		return unitInfoLabel;
	}

	public void setUnitInfoLabel(JLabel unitInfoLabel) {
		this.unitInfoLabel = unitInfoLabel;
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

	public JLabel getMarchingBackground() {
		return marchingBackground;
	}

	public void setMarchingBackground(JLabel marchingBackground) {
		this.marchingBackground = marchingBackground;
	}

	public JButton getCreateArmy() {
		return createArmy;
	}

	public void setCreateArmy(JButton createArmy) {
		this.createArmy = createArmy;
	}

	public JButton getRelocate() {
		return relocate;
	}

	public void setRelocate(JButton relocate) {
		this.relocate = relocate;
	}

	public JScrollPane getListFromScrollPane() {
		return listFromScrollPane;
	}

	public void setListFromScrollPane(JScrollPane listFromScrollPane) {
		this.listFromScrollPane = listFromScrollPane;
	}

	public JScrollPane getListToScrollPane() {
		return listToScrollPane;
	}

	public void setListToScrollPane(JScrollPane listToScrollPane) {
		this.listToScrollPane = listToScrollPane;
	}

	public JList getListUnits() {
		return listUnits;
	}

	public void setListUnits(JList listUnits) {
		this.listUnits = listUnits;
	}

	public DefaultListModel getListModelUnits() {
		return listModelUnits;
	}

	public void setListModelUnits(DefaultListModel listModelUnits) {
		this.listModelUnits = listModelUnits;
	}

	public JScrollPane getListUnitsScrollUnits() {
		return listUnitsScrollUnits;
	}

	public void setListUnitsScrollUnits(JScrollPane listUnitsScrollUnits) {
		this.listUnitsScrollUnits = listUnitsScrollUnits;
	}

	public JLabel getChooseUnitLabel() {
		return chooseUnitLabel;
	}

	public void setChooseUnitLabel(JLabel chooseUnitLabel) {
		this.chooseUnitLabel = chooseUnitLabel;
	}

	public JButton getRelocateAll() {
		return relocateAll;
	}

	public void setRelocateAll(JButton relocateAll) {
		this.relocateAll = relocateAll;
	}

}
