package engine;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import buildings.*;
import exceptions.*;
import units.*;
import view.*;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@SuppressWarnings("unchecked")
public class GameController implements ActionListener, ListSelectionListener {

	private Game game;
	private ChooseNameView chooseNameView;
	private ChooseCityView chooseCityView;
	private WorldMapView worldMapView;
	private ArmiesInfoView armiesInfoView;
	private CityView cityView;
	private BattleView battleView;
	private RelocateView relocateView;
	private VictoryView victoryView;
	private String playerName = "";
	private String cityViewChoice = "";
	private String buildingChoice = "";
	private Army attacking;
	private Army defending;

	public GameController() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		chooseNameView = new ChooseNameView();
		chooseNameView.getNameButton().addActionListener(this);
		chooseCityView = new ChooseCityView();
		chooseCityView.getCity1Button().addActionListener(this);
		chooseCityView.getCity2Button().addActionListener(this);
		chooseCityView.getCity3Button().addActionListener(this);
		worldMapView = new WorldMapView();
		worldMapView.getIdleArmyButton().addActionListener(this);
		worldMapView.getBesiegingArmyButton().addActionListener(this);
		worldMapView.getMarchingArmyButton().addActionListener(this);
		worldMapView.getViewFoodButton().addActionListener(this);
		worldMapView.getViewGoldButton().addActionListener(this);
		worldMapView.getViewTurnCountButton().addActionListener(this);
		worldMapView.getViewNameButton().addActionListener(this);
		worldMapView.getRomeButton().addActionListener(this);
		worldMapView.getCairoButton().addActionListener(this);
		worldMapView.getSpartaButton().addActionListener(this);
		worldMapView.getChooseArmyTargetList().addListSelectionListener(this);
		worldMapView.getAttackWithArmy().addActionListener(this);
		worldMapView.getCancelAttackWithArmy().addActionListener(this);
		worldMapView.getEndTurn().addActionListener(this);
		armiesInfoView = new ArmiesInfoView();
		armiesInfoView.getReturnToWorld().addActionListener(this);
		armiesInfoView.getList().addListSelectionListener(this);
		armiesInfoView.getReturnToCityView().addActionListener(this);
		armiesInfoView.getBreakSiege().addActionListener(this);
		cityView = new CityView();
		cityView.getDefendingArmy().addActionListener(this);
		cityView.getArmiesInTheCity().addActionListener(this);
		cityView.getArcheryRangeButton().addActionListener(this);
		cityView.getBarracksButton().addActionListener(this);
		cityView.getStableButton().addActionListener(this);
		cityView.getFarmButton().addActionListener(this);
		cityView.getMarketButton().addActionListener(this);
		cityView.getReturnToWorldMap().addActionListener(this);
		cityView.getViewFoodButton().addActionListener(this);
		cityView.getViewGoldButton().addActionListener(this);
		cityView.getViewTurnCountButton().addActionListener(this);
		cityView.getViewNameButton().addActionListener(this);
		cityView.getBuyButton().addActionListener(this);
		cityView.getUpgradeButton().addActionListener(this);
		cityView.getRecruitButton().addActionListener(this);
		cityView.getEndTurn().addActionListener(this);
		cityView.getInitiateNewArmyButton().addActionListener(this);
		cityView.getrelocateUnitsButton().addActionListener(this);
		cityView.getInitiate().addActionListener(this);
		cityView.getCancelInitiate().addActionListener(this);
		cityView.getListDefending().addListSelectionListener(this);
		battleView = new BattleView();
		battleView.getReturnToWorld().addActionListener(this);
		battleView.getListAttacking().addListSelectionListener(this);
		battleView.getListDefending().addListSelectionListener(this);
		battleView.getAttack().addActionListener(this);
		battleView.getSimulateBattle().addActionListener(this);
		relocateView = new RelocateView();
		relocateView.getReturnToCityView().addActionListener(this);
		relocateView.getListUnits().addListSelectionListener(this);
		relocateView.getListFrom().addListSelectionListener(this);
		relocateView.getListTo().addListSelectionListener(this);
		relocateView.getRelocate().addActionListener(this);
		relocateView.getRelocateAll().addActionListener(this);
		victoryView = new VictoryView();
		victoryView.getExitButton().addActionListener(this);

		ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(1);
		exec.scheduleAtFixedRate(new Runnable() {
			public void run() {
				try {
					playSound();
				} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
					e.printStackTrace();
				}
			}
		}, 0, 237, TimeUnit.SECONDS);

	}

	public void playSound() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("Sounds/soundtrack.wav").getAbsoluteFile());
		Clip clip = AudioSystem.getClip();
		clip.open(audioInputStream);
		clip.start();
	}

	public void playSound2() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("Sounds/buttonPress.wav").getAbsoluteFile());
		Clip clip = AudioSystem.getClip();
		clip.open(audioInputStream);
		clip.start();
	}

	public void playSound3() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("Sounds/victorySound.wav").getAbsoluteFile());
		Clip clip = AudioSystem.getClip();
		clip.open(audioInputStream);
		clip.start();
	}

	public void refresher() {
		chooseNameView.revalidate();
		chooseNameView.repaint();
		chooseCityView.revalidate();
		chooseCityView.repaint();
		worldMapView.revalidate();
		worldMapView.repaint();
		armiesInfoView.revalidate();
		armiesInfoView.repaint();
		cityView.revalidate();
		cityView.repaint();
		battleView.revalidate();
		battleView.repaint();
		relocateView.revalidate();
		victoryView.revalidate();
		victoryView.repaint();
	}

	public void actionPerformed(ActionEvent e) {
		try {
			this.playSound2();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
		}
		if (e.getSource() == chooseNameView.getNameButton()) {
			this.playerName = chooseNameView.getNameArea().getText();
			if (playerName.length() == 0) {
				JOptionPane.showMessageDialog(chooseNameView, "Please Enter a Valid Name!", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				chooseNameView.setVisible(false);
				// chooseCityView.getChooseCityLabel().setText(("Hello " + playerName + ",
				// Choose a city"));
				chooseCityView.setVisible(true);
			}
		}
		if (e.getSource() == chooseCityView.getCity1Button()) {

			try {
				game = new Game(this.playerName, "Rome");
			} catch (Exception x) {
			}
			chooseCityView.setVisible(false);
			worldMapView.setVisible(true);
		}

		if (e.getSource() == chooseCityView.getCity2Button()) {
			try {
				game = new Game(this.playerName, "Cairo");

			} catch (Exception x) {
			}
			chooseCityView.setVisible(false);
			worldMapView.setVisible(true);
		}

		if (e.getSource() == chooseCityView.getCity3Button()) {
			try {
				game = new Game(this.playerName, "Sparta");

			} catch (Exception x) {
			}
			chooseCityView.setVisible(false);
			worldMapView.setVisible(true);
		}

		if (e.getSource() == worldMapView.getIdleArmyButton()) {
			boolean found = false;
			for (int i = 0; i < game.getPlayer().getControlledArmies().size(); i++) {
				if (game.getPlayer().getControlledArmies().get(i).getCurrentStatus() == Status.IDLE) {
					found = true;
				}
			}
			if (!found) {
				JOptionPane.showMessageDialog(worldMapView, "You Have No Idle Armies!", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				worldMapView.setVisible(false);
				armiesInfoView.setVisible(true);
				loadListIdle();
			}
		}

		if (e.getSource() == worldMapView.getMarchingArmyButton()) {
			boolean found = false;
			for (int i = 0; i < game.getPlayer().getControlledArmies().size(); i++) {
				if (game.getPlayer().getControlledArmies().get(i).getCurrentStatus() == Status.MARCHING) {
					found = true;
				}
			}
			if (!found) {
				JOptionPane.showMessageDialog(worldMapView, "You Have No Marching Armies!", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				worldMapView.setVisible(false);
				armiesInfoView.setVisible(true);
				loadListMarching();
			}
		}

		if (e.getSource() == worldMapView.getBesiegingArmyButton()) {
			boolean found = false;
			for (int i = 0; i < game.getPlayer().getControlledArmies().size(); i++) {
				if (game.getPlayer().getControlledArmies().get(i).getCurrentStatus() == Status.BESIEGING) {
					found = true;
				}
			}
			if (!found) {
				JOptionPane.showMessageDialog(worldMapView, "You Have No Besieging Armies!", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				this.armiesInfoView.getBreakSiege().setVisible(true);
				worldMapView.setVisible(false);
				armiesInfoView.setVisible(true);
				loadListBesieging();
			}
		}

		if (e.getSource() == armiesInfoView.getBreakSiege()) {
			if (armiesInfoView.getList().getSelectedIndex() == -1) {
				JOptionPane.showMessageDialog(null, "You Have to Choose the Army First!", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				String[] buttons = { "Attack", "Target the Other City" };
				int rc = JOptionPane.showOptionDialog(null, "Do You Want to Attack This City or Target The Other One?", "Attack Or Leave?", JOptionPane.YES_NO_OPTION, 0, null, buttons, buttons[1]);
				if (rc == JOptionPane.YES_OPTION) {

					String currentLoc = game.getPlayer().getControlledArmies().get((Integer.parseInt((armiesInfoView.getList().getSelectedValue() + "").substring(5)) - 1)).getCurrentLocation();
					for (int j = 0; j < game.getAvailableCities().size(); j++) {
						if (game.getAvailableCities().get(j).getName().equalsIgnoreCase(currentLoc)) {
							defending = game.getAvailableCities().get(j).getDefendingArmy();
						}
					}

					attacking = game.getPlayer().getControlledArmies().get((Integer.parseInt((armiesInfoView.getList().getSelectedValue() + "").substring(5)) - 1));
					loadListAttacking();
					loadListDefending();
					battleView.getSimulateBattle().setEnabled(true);
					battleView.getAttack().setEnabled(true);
					battleView.getReturnToWorld().setEnabled(false);
					chooseNameView.setVisible(false);
					chooseCityView.setVisible(false);
					worldMapView.setVisible(false);
					armiesInfoView.setVisible(false);
					cityView.setVisible(false);
					relocateView.setVisible(false);
					battleView.setVisible(true);

				} else if (rc == JOptionPane.NO_OPTION) {
					if (game.getPlayer().getControlledCities().size() == 2) {
						String[] buttons2 = { "Attack", "Leave Them Besieging" };
						int rc2 = JOptionPane.showOptionDialog(null, "All Other Cities are Already Conquered and Under Our Control", "No Other Cities to Attack", JOptionPane.YES_NO_OPTION, 0, null,
								buttons2, buttons2[1]);
						if (rc2 == JOptionPane.YES_OPTION) {
							String currentLoc = game.getPlayer().getControlledArmies().get((Integer.parseInt((armiesInfoView.getList().getSelectedValue() + "").substring(5)) - 1))
									.getCurrentLocation();
							for (int j = 0; j < game.getAvailableCities().size(); j++) {
								if (game.getAvailableCities().get(j).getName().equalsIgnoreCase(currentLoc)) {
									defending = game.getAvailableCities().get(j).getDefendingArmy();
								}
							}

							attacking = game.getPlayer().getControlledArmies().get((Integer.parseInt((armiesInfoView.getList().getSelectedValue() + "").substring(5)) - 1));
							loadListAttacking();
							loadListDefending();
							battleView.getSimulateBattle().setEnabled(true);
							battleView.getAttack().setEnabled(true);
							battleView.getReturnToWorld().setEnabled(false);
							chooseNameView.setVisible(false);
							chooseCityView.setVisible(false);
							worldMapView.setVisible(false);
							armiesInfoView.setVisible(false);
							cityView.setVisible(false);
							relocateView.setVisible(false);
							battleView.setVisible(true);
						}
					} else {
						String currentLoc = game.getPlayer().getControlledArmies().get((Integer.parseInt((armiesInfoView.getList().getSelectedValue() + "").substring(5)) - 1)).getCurrentLocation();
						City c = null;
						for (int j = 0; j < game.getAvailableCities().size(); j++) {
							if (game.getAvailableCities().get(j).getName().equalsIgnoreCase(currentLoc)) {
								c = game.getAvailableCities().get(j);
								break;
							}
						}
						c.setUnderSiege(false);
						c.setTurnsUnderSiege(-1);
						String attackTheOther = "";
						if (c.getName().equalsIgnoreCase("Rome")) {
							for (int i = 0; i < game.getPlayer().getControlledCities().size(); i++) {
								if (!game.getPlayer().getControlledCities().get(i).getName().equalsIgnoreCase("Rome")) {
									attackTheOther = game.getPlayer().getControlledCities().get(i).getName();
									break;
								}
							}
							for (int j = 0; j < game.getAvailableCities().size(); j++) {
								if (!game.getAvailableCities().get(j).getName().equalsIgnoreCase("Rome") && !game.getAvailableCities().get(j).getName().equalsIgnoreCase(attackTheOther)) {
									game.targetCity(attacking, game.getAvailableCities().get(j).getName());
									attacking.setCurrentStatus(Status.IDLE);
									armiesInfoView.getListModel().removeAllElements();
									armiesInfoView.getUnitsInfoArea().setText("");
									loadListBesieging();
									break;
								}
							}
						} else if (c.getName().equalsIgnoreCase("Cairo")) {
							for (int i = 0; i < game.getPlayer().getControlledCities().size(); i++) {
								if (!game.getPlayer().getControlledCities().get(i).getName().equalsIgnoreCase("Cairo")) {
									attackTheOther = game.getPlayer().getControlledCities().get(i).getName();
									break;
								}
							}
							for (int j = 0; j < game.getAvailableCities().size(); j++) {
								if (!game.getAvailableCities().get(j).getName().equalsIgnoreCase("Cairo") && !game.getAvailableCities().get(j).getName().equalsIgnoreCase(attackTheOther)) {
									game.targetCity(attacking, game.getAvailableCities().get(j).getName());
									attacking.setCurrentStatus(Status.IDLE);
									armiesInfoView.getListModel().removeAllElements();
									armiesInfoView.getUnitsInfoArea().setText("");
									loadListBesieging();
									break;
								}
							}
						} else {
							for (int i = 0; i < game.getPlayer().getControlledCities().size(); i++) {
								if (!game.getPlayer().getControlledCities().get(i).getName().equalsIgnoreCase("Sparta")) {
									attackTheOther = game.getPlayer().getControlledCities().get(i).getName();
									break;
								}
							}
							for (int j = 0; j < game.getAvailableCities().size(); j++) {
								if (!game.getAvailableCities().get(j).getName().equalsIgnoreCase("Sparta") && !game.getAvailableCities().get(j).getName().equalsIgnoreCase(attackTheOther)) {
									game.targetCity(attacking, game.getAvailableCities().get(j).getName());
									attacking.setCurrentStatus(Status.IDLE);
									armiesInfoView.getListModel().removeAllElements();
									armiesInfoView.getUnitsInfoArea().setText("");
									loadListBesieging();
									break;
								}
							}
						}
						JOptionPane.showMessageDialog(null, "Army was Sent Successfully!");

					}
				}

			}
		}

		if (e.getSource() == armiesInfoView.getReturnToWorld()) {
			armiesInfoView.setVisible(false);
			worldMapView.setVisible(true);
			armiesInfoView.getListModel().removeAllElements();
			armiesInfoView.getUnitsInfoArea().setText("");
			armiesInfoView.getChooseArmyLabel().setVisible(true);
		}

		if (e.getSource() == worldMapView.getViewFoodButton() || e.getSource() == cityView.getViewFoodButton()) {
			JOptionPane.showMessageDialog(worldMapView, "You Have: " + game.getPlayer().getFood() + " Food");
		}

		if (e.getSource() == worldMapView.getViewGoldButton() || e.getSource() == cityView.getViewGoldButton()) {
			JOptionPane.showMessageDialog(worldMapView, "You Have: " + game.getPlayer().getTreasury() + " Gold");
		}

		if (e.getSource() == worldMapView.getViewNameButton() || e.getSource() == cityView.getViewNameButton()) {
			JOptionPane.showMessageDialog(worldMapView, "Your Name is: " + game.getPlayer().getName());
		}

		if (e.getSource() == worldMapView.getViewTurnCountButton() || e.getSource() == cityView.getViewTurnCountButton()) {
			JOptionPane.showMessageDialog(worldMapView, "Current Turn: " + game.getCurrentTurnCount());
		}

		if (e.getSource() == worldMapView.getRomeButton()) {
			cityViewChoice = "rome";
			boolean found = false;
			for (int i = 0; i < game.getPlayer().getControlledCities().size(); i++) {
				if (game.getPlayer().getControlledCities().get(i).getName().equalsIgnoreCase("Rome")) {
					found = true;
				}
			}
			if (!found) {
				int reply = JOptionPane.showConfirmDialog(null, "You Can't View An Uncontrolled City!" + "\n" + "Do You Want to Send an Army to Conquer This City?", "Target City Message",
						JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					boolean alreadyTargeted = false;
					for (int i = 0; i < game.getPlayer().getControlledArmies().size(); i++) {
						if (game.getPlayer().getControlledArmies().get(i).getTarget().equalsIgnoreCase(cityViewChoice)) {
							alreadyTargeted = true;
						}
					}
					if (alreadyTargeted) {
						JOptionPane.showMessageDialog(cityView, "You Already Targeted This City!", "Error", JOptionPane.ERROR_MESSAGE);
					} else if (game.getPlayer().getControlledArmies().size() == 0) {
						JOptionPane.showMessageDialog(cityView, "You have No Armies Available To Send!", "Error", JOptionPane.ERROR_MESSAGE);
					} else {
						worldMapView.getIdleArmyButton().setVisible(false);
						worldMapView.getMarchingArmyButton().setVisible(false);
						worldMapView.getBesiegingArmyButton().setVisible(false);
						worldMapView.getIdleArmyLabel().setVisible(false);
						worldMapView.getMarchingArmyLabel().setVisible(false);
						worldMapView.getBesiegingArmyLabel().setVisible(false);
						LoadListSetTarget();
						worldMapView.getAvailableArmiesToFight().setVisible(true);
						worldMapView.getListScrollPane().setVisible(true);
						worldMapView.getUnitsInfoAreaScrollable().setVisible(true);
						worldMapView.getCancelAttackWithArmy().setVisible(true);
						worldMapView.getAttackWithArmy().setVisible(true);
					}
				}
			} else {
				worldMapView.setVisible(false);
				cityView.setVisible(true);
				armiesInfoView.getReturnToCityLabel().setVisible(true);
				armiesInfoView.getReturnToWorld().setVisible(false);
				armiesInfoView.getReturnToCityView().setVisible(true);
				armiesInfoView.getGoToWorldMapLabel().setVisible(false);

			}

		}

		if (e.getSource() == worldMapView.getCairoButton()) {
			cityViewChoice = "cairo";
			boolean found = false;
			for (int i = 0; i < game.getPlayer().getControlledCities().size(); i++) {
				if (game.getPlayer().getControlledCities().get(i).getName().equalsIgnoreCase("Cairo")) {
					found = true;
				}
			}
			if (!found) {
				int reply = JOptionPane.showConfirmDialog(null, "You Can't View An Uncontrolled City!" + "\n" + "Do You Want to Send an Army to Conquer This City?", "Target City Message",
						JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					boolean alreadyTargeted = false;
					for (int i = 0; i < game.getPlayer().getControlledArmies().size(); i++) {
						if (game.getPlayer().getControlledArmies().get(i).getTarget().equalsIgnoreCase(cityViewChoice)) {
							alreadyTargeted = true;
						}
					}
					if (alreadyTargeted) {
						JOptionPane.showMessageDialog(cityView, "You Already Targeted This City!", "Error", JOptionPane.ERROR_MESSAGE);
					} else if (game.getPlayer().getControlledArmies().size() == 0) {
						JOptionPane.showMessageDialog(cityView, "You have No Armies Available To Send!", "Error", JOptionPane.ERROR_MESSAGE);
					} else {
						LoadListSetTarget();
						worldMapView.getIdleArmyButton().setVisible(false);
						worldMapView.getMarchingArmyButton().setVisible(false);
						worldMapView.getBesiegingArmyButton().setVisible(false);
						worldMapView.getIdleArmyLabel().setVisible(false);
						worldMapView.getMarchingArmyLabel().setVisible(false);
						worldMapView.getBesiegingArmyLabel().setVisible(false);
						worldMapView.getAvailableArmiesToFight().setVisible(true);
						worldMapView.getListScrollPane().setVisible(true);
						worldMapView.getUnitsInfoAreaScrollable().setVisible(true);
						worldMapView.getCancelAttackWithArmy().setVisible(true);
						worldMapView.getAttackWithArmy().setVisible(true);
					}
				}
			} else {
				worldMapView.setVisible(false);
				cityView.setVisible(true);
				armiesInfoView.getReturnToCityLabel().setVisible(true);
				armiesInfoView.getReturnToWorld().setVisible(false);
				armiesInfoView.getReturnToCityView().setVisible(true);
				armiesInfoView.getGoToWorldMapLabel().setVisible(false);
			}

		}

		if (e.getSource() == worldMapView.getSpartaButton()) {
			cityViewChoice = "sparta";
			boolean found = false;
			for (int i = 0; i < game.getPlayer().getControlledCities().size(); i++) {
				if (game.getPlayer().getControlledCities().get(i).getName().equalsIgnoreCase("Sparta")) {
					found = true;
				}
			}
			if (!found) {
				int reply = JOptionPane.showConfirmDialog(null, "You Can't View An Uncontrolled City!" + "\n" + "Do You Want to Send an Army to Conquer This City?", "Target City Message",
						JOptionPane.YES_NO_OPTION);
				if (reply == JOptionPane.YES_OPTION) {
					boolean alreadyTargeted = false;
					for (int i = 0; i < game.getPlayer().getControlledArmies().size(); i++) {
						if (game.getPlayer().getControlledArmies().get(i).getTarget().equalsIgnoreCase(cityViewChoice)) {
							alreadyTargeted = true;
						}
					}
					if (alreadyTargeted) {
						JOptionPane.showMessageDialog(cityView, "You Already Targeted This City!", "Error", JOptionPane.ERROR_MESSAGE);
					} else if (game.getPlayer().getControlledArmies().size() == 0) {
						JOptionPane.showMessageDialog(cityView, "You have No Armies Available To Send!", "Error", JOptionPane.ERROR_MESSAGE);
					} else {
						worldMapView.getIdleArmyButton().setVisible(false);
						worldMapView.getMarchingArmyButton().setVisible(false);
						worldMapView.getBesiegingArmyButton().setVisible(false);
						worldMapView.getIdleArmyLabel().setVisible(false);
						worldMapView.getMarchingArmyLabel().setVisible(false);
						worldMapView.getBesiegingArmyLabel().setVisible(false);
						LoadListSetTarget();
						worldMapView.getAvailableArmiesToFight().setVisible(true);
						worldMapView.getListScrollPane().setVisible(true);
						worldMapView.getUnitsInfoAreaScrollable().setVisible(true);
						worldMapView.getCancelAttackWithArmy().setVisible(true);
						worldMapView.getAttackWithArmy().setVisible(true);
					}
				}
			} else {
				worldMapView.setVisible(false);
				cityView.setVisible(true);
				armiesInfoView.getReturnToWorld().setVisible(false);
				armiesInfoView.getReturnToCityView().setVisible(true);
				armiesInfoView.getGoToWorldMapLabel().setVisible(false);
				armiesInfoView.getReturnToCityLabel().setVisible(true);
			}

		}

		if (e.getSource() == cityView.getDefendingArmy()) {
			cityView.getArcheryRangeLabel().setForeground(Color.WHITE);
			cityView.getMarketLabel().setForeground(Color.WHITE);
			cityView.getFarmLabel().setForeground(Color.WHITE);
			cityView.getBarracksLabel().setForeground(Color.WHITE);
			cityView.getStableLabel().setForeground(Color.WHITE);
			buildingChoice = "";
			Army a = null;
			if (cityViewChoice.equalsIgnoreCase("rome")) {
				for (City c : game.getPlayer().getControlledCities()) {
					if (c.getName().equalsIgnoreCase("Rome")) {
						a = c.getDefendingArmy();
					}
				}
			}

			if (cityViewChoice.equalsIgnoreCase("cairo")) {
				for (City c : game.getPlayer().getControlledCities()) {
					if (c.getName().equalsIgnoreCase("cairo")) {
						a = c.getDefendingArmy();
					}
				}
			}

			if (cityViewChoice.equalsIgnoreCase("sparta")) {
				for (City c : game.getPlayer().getControlledCities()) {
					if (c.getName().equalsIgnoreCase("sparta")) {
						a = c.getDefendingArmy();
					}
				}
			}
			cityView.setVisible(false);
			armiesInfoView.setVisible(true);
			String info = getArmyInfo(a);
			armiesInfoView.getUnitsInfoArea().setText(info);
			armiesInfoView.getChooseArmyLabel().setVisible(false);
			armiesInfoView.getListScrollPane().setVisible(false);
			armiesInfoView.getBreakSiege().setVisible(false);
		}

		if (e.getSource() == cityView.getArmiesInTheCity()) {
			cityView.getArcheryRangeLabel().setForeground(Color.WHITE);
			cityView.getMarketLabel().setForeground(Color.WHITE);
			cityView.getFarmLabel().setForeground(Color.WHITE);
			cityView.getBarracksLabel().setForeground(Color.WHITE);
			cityView.getStableLabel().setForeground(Color.WHITE);
			buildingChoice = "";
			boolean found = false;
			for (int i = 0; i < game.getPlayer().getControlledArmies().size(); i++) {
				if (game.getPlayer().getControlledArmies().get(i).getCurrentLocation().equalsIgnoreCase(cityViewChoice)) {
					found = true;
				}
			}
			if (!found) {
				JOptionPane.showMessageDialog(worldMapView, "You Have No Controlled Armies In This City!", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				cityView.setVisible(false);
				armiesInfoView.setVisible(true);
				LoadListInTheCity(cityViewChoice);
			}
		}

		if (e.getSource() == armiesInfoView.getReturnToCityView()) {
			armiesInfoView.setVisible(false);
			cityView.setVisible(true);
			armiesInfoView.getListModel().removeAllElements();
			armiesInfoView.getUnitsInfoArea().setText("");
			armiesInfoView.getChooseArmyLabel().setVisible(true);
			armiesInfoView.getListScrollPane().setVisible(true);
		}

		if (e.getSource() == cityView.getReturnToWorldMap()) {
			cityView.getArcheryRangeLabel().setForeground(Color.WHITE);
			cityView.getMarketLabel().setForeground(Color.WHITE);
			cityView.getFarmLabel().setForeground(Color.WHITE);
			cityView.getBarracksLabel().setForeground(Color.WHITE);
			cityView.getStableLabel().setForeground(Color.WHITE);
			buildingChoice = "";
			cityView.setVisible(false);
			worldMapView.setVisible(true);
			armiesInfoView.getListModel().removeAllElements();
			armiesInfoView.getUnitsInfoArea().setText("");
			armiesInfoView.getChooseArmyLabel().setVisible(true);
			armiesInfoView.getReturnToWorld().setVisible(true);
			armiesInfoView.getReturnToCityView().setVisible(false);
			armiesInfoView.getReturnToCityLabel().setVisible(false);
			armiesInfoView.getGoToWorldMapLabel().setVisible(true);

		}

		if (e.getSource() == cityView.getArcheryRangeButton()) {

			cityView.getArcheryRangeLabel().setForeground(Color.GREEN);
			cityView.getMarketLabel().setForeground(Color.WHITE);
			cityView.getFarmLabel().setForeground(Color.WHITE);
			cityView.getBarracksLabel().setForeground(Color.WHITE);
			cityView.getStableLabel().setForeground(Color.WHITE);
			int index = -1;
			for (int i = 0; i < game.getPlayer().getControlledCities().size(); i++) {
				if (game.getPlayer().getControlledCities().get(i).getName().equalsIgnoreCase(cityViewChoice)) {
					index = i;
				}
			}
			int level = 0;

			for (int i = 0; i < game.getPlayer().getControlledCities().get(index).getMilitaryBuildings().size(); i++) {
				if (game.getPlayer().getControlledCities().get(index).getMilitaryBuildings().get(i) instanceof ArcheryRange) {
					level = game.getPlayer().getControlledCities().get(index).getMilitaryBuildings().get(i).getLevel();
				}
			}
			if (level != 0) {
				cityView.getArcheryRangeLevelLabel().setText("Level: " + level);
				cityView.getArcheryRangeLevelLabel().setVisible(true);
			}
			cityView.getRecruitButton().setEnabled(true);
			buildingChoice = "ArcheryRange";
		}

		if (e.getSource() == cityView.getBarracksButton()) {
			cityView.getArcheryRangeLabel().setForeground(Color.WHITE);
			cityView.getMarketLabel().setForeground(Color.WHITE);
			cityView.getFarmLabel().setForeground(Color.WHITE);
			cityView.getBarracksLabel().setForeground(Color.GREEN);
			cityView.getStableLabel().setForeground(Color.WHITE);
			int index = -1;
			for (int i = 0; i < game.getPlayer().getControlledCities().size(); i++) {
				if (game.getPlayer().getControlledCities().get(i).getName().equalsIgnoreCase(cityViewChoice)) {
					index = i;
				}
			}
			int level = 0;

			for (int i = 0; i < game.getPlayer().getControlledCities().get(index).getMilitaryBuildings().size(); i++) {
				if (game.getPlayer().getControlledCities().get(index).getMilitaryBuildings().get(i) instanceof Barracks) {
					level = game.getPlayer().getControlledCities().get(index).getMilitaryBuildings().get(i).getLevel();
				}
			}
			if (level != 0) {
				cityView.getBarracksLevelLabel().setText("Level: " + level);
				cityView.getBarracksLevelLabel().setVisible(true);
			}
			cityView.getRecruitButton().setEnabled(true);
			buildingChoice = "Barracks";
		}

		if (e.getSource() == cityView.getStableButton()) {
			cityView.getArcheryRangeLabel().setForeground(Color.WHITE);
			cityView.getMarketLabel().setForeground(Color.WHITE);
			cityView.getFarmLabel().setForeground(Color.WHITE);
			cityView.getBarracksLabel().setForeground(Color.WHITE);
			cityView.getStableLabel().setForeground(Color.GREEN);
			int index = -1;
			for (int i = 0; i < game.getPlayer().getControlledCities().size(); i++) {
				if (game.getPlayer().getControlledCities().get(i).getName().equalsIgnoreCase(cityViewChoice)) {
					index = i;
				}
			}
			int level = 0;

			for (int i = 0; i < game.getPlayer().getControlledCities().get(index).getMilitaryBuildings().size(); i++) {
				if (game.getPlayer().getControlledCities().get(index).getMilitaryBuildings().get(i) instanceof Stable) {
					level = game.getPlayer().getControlledCities().get(index).getMilitaryBuildings().get(i).getLevel();
				}
			}
			if (level != 0) {
				cityView.getStableLevelLabel().setText("Level: " + level);
				cityView.getStableLevelLabel().setVisible(true);
			}
			cityView.getRecruitButton().setEnabled(true);
			buildingChoice = "Stable";
		}

		if (e.getSource() == cityView.getFarmButton()) {
			cityView.getArcheryRangeLabel().setForeground(Color.WHITE);
			cityView.getMarketLabel().setForeground(Color.WHITE);
			cityView.getFarmLabel().setForeground(Color.GREEN);
			cityView.getBarracksLabel().setForeground(Color.WHITE);
			cityView.getStableLabel().setForeground(Color.WHITE);
			int index = -1;
			for (int i = 0; i < game.getPlayer().getControlledCities().size(); i++) {
				if (game.getPlayer().getControlledCities().get(i).getName().equalsIgnoreCase(cityViewChoice)) {
					index = i;
				}
			}
			int level = 0;

			for (int i = 0; i < game.getPlayer().getControlledCities().get(index).getEconomicalBuildings().size(); i++) {
				if (game.getPlayer().getControlledCities().get(index).getEconomicalBuildings().get(i) instanceof Farm) {
					level = game.getPlayer().getControlledCities().get(index).getEconomicalBuildings().get(i).getLevel();
				}
			}
			if (level != 0) {
				cityView.getFarmLevelLabel().setText("Level: " + level);
				cityView.getFarmLevelLabel().setVisible(true);
			}
			cityView.getRecruitButton().setEnabled(false);
			buildingChoice = "Farm";
		}

		if (e.getSource() == cityView.getMarketButton()) {
			cityView.getArcheryRangeLabel().setForeground(Color.WHITE);
			cityView.getMarketLabel().setForeground(Color.GREEN);
			cityView.getFarmLabel().setForeground(Color.WHITE);
			cityView.getBarracksLabel().setForeground(Color.WHITE);
			cityView.getStableLabel().setForeground(Color.WHITE);
			int index = -1;
			for (int i = 0; i < game.getPlayer().getControlledCities().size(); i++) {
				if (game.getPlayer().getControlledCities().get(i).getName().equalsIgnoreCase(cityViewChoice)) {
					index = i;
				}
			}
			int level = 0;

			for (int i = 0; i < game.getPlayer().getControlledCities().get(index).getEconomicalBuildings().size(); i++) {
				if (game.getPlayer().getControlledCities().get(index).getEconomicalBuildings().get(i) instanceof Market) {
					level = game.getPlayer().getControlledCities().get(index).getEconomicalBuildings().get(i).getLevel();
				}
			}
			if (level != 0) {
				cityView.getMarketLevelLabel().setText("Level: " + level);
				cityView.getMarketLevelLabel().setVisible(true);
			}
			cityView.getRecruitButton().setEnabled(false);
			buildingChoice = "Market";
		}

		if ((e.getSource() == cityView.getBuyButton() || e.getSource() == cityView.getUpgradeButton() || e.getSource() == cityView.getRecruitButton()) && buildingChoice == "") {
			cityView.getArcheryRangeLabel().setForeground(Color.WHITE);
			cityView.getMarketLabel().setForeground(Color.WHITE);
			cityView.getFarmLabel().setForeground(Color.WHITE);
			cityView.getBarracksLabel().setForeground(Color.WHITE);
			cityView.getStableLabel().setForeground(Color.WHITE);
			buildingChoice = "";
			JOptionPane.showMessageDialog(cityView, "Choose A Building First!", "Error", JOptionPane.ERROR_MESSAGE);
		} else if (e.getSource() == cityView.getBuyButton() && !(buildingChoice.equalsIgnoreCase("Market") || buildingChoice.equalsIgnoreCase("Farm"))) {
			int cost = 0;
			if (buildingChoice.equalsIgnoreCase("ArcheryRange")) {
				cost = new ArcheryRange().getCost();
			} else if (buildingChoice.equalsIgnoreCase("Barracks")) {
				cost = new Barracks().getCost();
			} else {
				cost = new Stable().getCost();
			}
			int reply = JOptionPane.showConfirmDialog(null, "Cost: " + cost + " Gold" + "\n" + "Are You Sure You Want To Buy " + buildingChoice + "?", "Buy Message", JOptionPane.YES_NO_OPTION);
			if (reply == JOptionPane.YES_OPTION) {
				int index = -1;
				for (int i = 0; i < game.getPlayer().getControlledCities().size(); i++) {
					if (game.getPlayer().getControlledCities().get(i).getName().equalsIgnoreCase(cityViewChoice)) {
						index = i;
					}
				}
				int before = game.getPlayer().getControlledCities().get(index).getMilitaryBuildings().size();
				boolean exceptionBuy = false;
				try {
					game.getPlayer().build(buildingChoice, cityViewChoice);
				} catch (NotEnoughGoldException x) {
					JOptionPane.showMessageDialog(cityView, x.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					exceptionBuy = true;
				}
				if (game.getPlayer().getControlledCities().get(index).getMilitaryBuildings().size() == before && !exceptionBuy) {
					JOptionPane.showMessageDialog(cityView, "You Already Bought This Building!", "Error", JOptionPane.ERROR_MESSAGE);
				} else if (!exceptionBuy) {
					JOptionPane.showMessageDialog(cityView, "You Now Have: " + game.getPlayer().getTreasury() + " Gold");
				}
			}
			cityView.getArcheryRangeLabel().setForeground(Color.WHITE);
			cityView.getMarketLabel().setForeground(Color.WHITE);
			cityView.getFarmLabel().setForeground(Color.WHITE);
			cityView.getBarracksLabel().setForeground(Color.WHITE);
			cityView.getStableLabel().setForeground(Color.WHITE);
			buildingChoice = "";
		} else if (e.getSource() == cityView.getBuyButton() && (buildingChoice.equalsIgnoreCase("Market") || buildingChoice.equalsIgnoreCase("Farm"))) {
			int cost = 0;
			if (buildingChoice.equalsIgnoreCase("Market")) {
				cost = new Market().getCost();
			} else {
				cost = new Farm().getCost();
			}
			int reply = JOptionPane.showConfirmDialog(null, "Cost: " + cost + " Gold" + "\n" + "Are You Sure You Want To Buy " + buildingChoice + "?", "Buy Message", JOptionPane.YES_NO_OPTION);
			if (reply == JOptionPane.YES_OPTION) {
				int index = -1;
				for (int i = 0; i < game.getPlayer().getControlledCities().size(); i++) {
					if (game.getPlayer().getControlledCities().get(i).getName().equalsIgnoreCase(cityViewChoice)) {
						index = i;
					}
				}
				int before = game.getPlayer().getControlledCities().get(index).getEconomicalBuildings().size();
				boolean exceptionBuy = false;
				try {
					game.getPlayer().build(buildingChoice, cityViewChoice);
				} catch (NotEnoughGoldException x) {
					JOptionPane.showMessageDialog(cityView, x.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					exceptionBuy = true;
				}
				if (game.getPlayer().getControlledCities().get(index).getEconomicalBuildings().size() == before && !exceptionBuy) {
					JOptionPane.showMessageDialog(cityView, "You Already Bought This Building!", "Error", JOptionPane.ERROR_MESSAGE);
				} else if (!exceptionBuy) {
					JOptionPane.showMessageDialog(cityView, "You Now Have: " + game.getPlayer().getTreasury() + " Gold");
				}
			}
			cityView.getArcheryRangeLabel().setForeground(Color.WHITE);
			cityView.getMarketLabel().setForeground(Color.WHITE);
			cityView.getFarmLabel().setForeground(Color.WHITE);
			cityView.getBarracksLabel().setForeground(Color.WHITE);
			cityView.getStableLabel().setForeground(Color.WHITE);
			buildingChoice = "";
		} else if (e.getSource() == cityView.getUpgradeButton() && (buildingChoice.equalsIgnoreCase("Market") || buildingChoice.equalsIgnoreCase("Farm"))) {

			int index = -1;
			for (int i = 0; i < game.getPlayer().getControlledCities().size(); i++) {
				if (game.getPlayer().getControlledCities().get(i).getName().equalsIgnoreCase(cityViewChoice)) {
					index = i;
				}
			}
			boolean buidlingExists = false;
			for (int i = 0; i < game.getPlayer().getControlledCities().get(index).getEconomicalBuildings().size(); i++) {
				if (game.getPlayer().getControlledCities().get(index).getEconomicalBuildings().get(i) instanceof Market && buildingChoice.equalsIgnoreCase("Market")
						|| game.getPlayer().getControlledCities().get(index).getEconomicalBuildings().get(i) instanceof Farm && buildingChoice.equalsIgnoreCase("Farm")) {
					buidlingExists = true;
					int reply = JOptionPane.showConfirmDialog(null, "Upgrade Cost: " + game.getPlayer().getControlledCities().get(index).getEconomicalBuildings().get(i).getUpgradeCost() + " Gold"
							+ "\n" + "Are You Sure You Want To Upgrade Your " + buildingChoice + " ?", "Upgrade Message", JOptionPane.YES_NO_OPTION);
					if (reply == JOptionPane.YES_OPTION) {
						boolean exceptionUpgrade = false;
						try {
							game.getPlayer().upgradeBuilding(game.getPlayer().getControlledCities().get(index).getEconomicalBuildings().get(i));
						} catch (NotEnoughGoldException e1) {
							JOptionPane.showMessageDialog(cityView, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
							exceptionUpgrade = true;
						} catch (BuildingInCoolDownException e1) {
							JOptionPane.showMessageDialog(cityView, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
							exceptionUpgrade = true;
						} catch (MaxLevelException e1) {
							JOptionPane.showMessageDialog(cityView, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
							exceptionUpgrade = true;
						}
						if (!exceptionUpgrade) {
							JOptionPane.showMessageDialog(cityView, "You Now Have: " + game.getPlayer().getTreasury() + " Gold");
						}
					}

				}
			}
			if (!buidlingExists) {
				JOptionPane.showMessageDialog(cityView, "You Didn't Buy This Building Yet!", "Error", JOptionPane.ERROR_MESSAGE);
			}
			cityView.getArcheryRangeLabel().setForeground(Color.WHITE);
			cityView.getMarketLabel().setForeground(Color.WHITE);
			cityView.getFarmLabel().setForeground(Color.WHITE);
			cityView.getBarracksLabel().setForeground(Color.WHITE);
			cityView.getStableLabel().setForeground(Color.WHITE);
			buildingChoice = "";
		} else if (e.getSource() == cityView.getUpgradeButton() && !(buildingChoice.equalsIgnoreCase("Market") || buildingChoice.equalsIgnoreCase("Farm"))) {
			int index = -1;
			for (int i = 0; i < game.getPlayer().getControlledCities().size(); i++) {
				if (game.getPlayer().getControlledCities().get(i).getName().equalsIgnoreCase(cityViewChoice)) {
					index = i;
				}
			}
			boolean buidlingExists = false;
			for (int i = 0; i < game.getPlayer().getControlledCities().get(index).getMilitaryBuildings().size(); i++) {
				if (game.getPlayer().getControlledCities().get(index).getMilitaryBuildings().get(i) instanceof Stable && buildingChoice.equalsIgnoreCase("Stable")
						|| game.getPlayer().getControlledCities().get(index).getMilitaryBuildings().get(i) instanceof Barracks && buildingChoice.equalsIgnoreCase("Barracks")
						|| game.getPlayer().getControlledCities().get(index).getMilitaryBuildings().get(i) instanceof ArcheryRange && buildingChoice.equalsIgnoreCase("ArcheryRange")) {
					buidlingExists = true;
					int reply = JOptionPane.showConfirmDialog(null, "Upgrade Cost: " + game.getPlayer().getControlledCities().get(index).getMilitaryBuildings().get(i).getUpgradeCost() + " Gold" + "\n"
							+ "Are You Sure You Want To Upgrade Your " + buildingChoice + " ?", "Upgrade Message", JOptionPane.YES_NO_OPTION);
					if (reply == JOptionPane.YES_OPTION) {
						boolean exceptionUpgrade = false;
						try {
							game.getPlayer().upgradeBuilding(game.getPlayer().getControlledCities().get(index).getMilitaryBuildings().get(i));
						} catch (NotEnoughGoldException e1) {
							JOptionPane.showMessageDialog(cityView, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
							exceptionUpgrade = true;
						} catch (BuildingInCoolDownException e1) {
							JOptionPane.showMessageDialog(cityView, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
							exceptionUpgrade = true;
						} catch (MaxLevelException e1) {
							JOptionPane.showMessageDialog(cityView, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
							exceptionUpgrade = true;
						}
						if (!exceptionUpgrade) {
							JOptionPane.showMessageDialog(cityView, "You Now Have: " + game.getPlayer().getTreasury() + " Gold");
						}
					}

				}
			}
			if (!buidlingExists) {
				JOptionPane.showMessageDialog(cityView, "You Didn't Buy This Building Yet!", "Error", JOptionPane.ERROR_MESSAGE);
			}
			cityView.getArcheryRangeLabel().setForeground(Color.WHITE);
			cityView.getMarketLabel().setForeground(Color.WHITE);
			cityView.getFarmLabel().setForeground(Color.WHITE);
			cityView.getBarracksLabel().setForeground(Color.WHITE);
			cityView.getStableLabel().setForeground(Color.WHITE);
			buildingChoice = "";
		} else if (e.getSource() == cityView.getRecruitButton()) {

			int index = -1;
			for (int i = 0; i < game.getPlayer().getControlledCities().size(); i++) {
				if (game.getPlayer().getControlledCities().get(i).getName().equalsIgnoreCase(cityViewChoice)) {
					index = i;
				}
			}
			boolean buidlingExists = false;
			for (int i = 0; i < game.getPlayer().getControlledCities().get(index).getMilitaryBuildings().size(); i++) {
				if (game.getPlayer().getControlledCities().get(index).getMilitaryBuildings().get(i) instanceof Stable && buildingChoice.equalsIgnoreCase("Stable")
						|| game.getPlayer().getControlledCities().get(index).getMilitaryBuildings().get(i) instanceof Barracks && buildingChoice.equalsIgnoreCase("Barracks")
						|| game.getPlayer().getControlledCities().get(index).getMilitaryBuildings().get(i) instanceof ArcheryRange && buildingChoice.equalsIgnoreCase("ArcheryRange")) {
					buidlingExists = true;
					int reply = JOptionPane.showConfirmDialog(null, "Recruitment Cost: " + game.getPlayer().getControlledCities().get(index).getMilitaryBuildings().get(i).getRecruitmentCost()
							+ " Gold" + "\n" + "Are You Sure You Want To Recruit a Unit From Your " + buildingChoice + " ?", "Recruit Message", JOptionPane.YES_NO_OPTION);
					if (reply == JOptionPane.YES_OPTION) {
						boolean exceptionRecruit = false;
						try {
							String unitType = "";
							if (buildingChoice.equalsIgnoreCase("ArcheryRange")) {
								unitType = "archer";
							} else if (buildingChoice.equalsIgnoreCase("Barracks")) {
								unitType = "infantry";
							} else {
								unitType = "cavalry";
							}
							game.getPlayer().recruitUnit(unitType, cityViewChoice);
						} catch (BuildingInCoolDownException e1) {
							JOptionPane.showMessageDialog(cityView, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
							exceptionRecruit = true;
						} catch (MaxRecruitedException e1) {
							JOptionPane.showMessageDialog(cityView, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
							exceptionRecruit = true;
						} catch (NotEnoughGoldException e1) {
							JOptionPane.showMessageDialog(cityView, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
							exceptionRecruit = true;
						}
						if (!exceptionRecruit) {
							JOptionPane.showMessageDialog(cityView, "You Now Have: " + game.getPlayer().getTreasury() + " Gold");
						}
					}
				}
			}
			if (!buidlingExists) {
				JOptionPane.showMessageDialog(cityView, "You Didn't Buy This Building Yet!", "Error", JOptionPane.ERROR_MESSAGE);
			}
			cityView.getArcheryRangeLabel().setForeground(Color.WHITE);
			cityView.getMarketLabel().setForeground(Color.WHITE);
			cityView.getFarmLabel().setForeground(Color.WHITE);
			cityView.getBarracksLabel().setForeground(Color.WHITE);
			cityView.getStableLabel().setForeground(Color.WHITE);
			buildingChoice = "";
		}

		if (e.getSource() == worldMapView.getCancelAttackWithArmy()) {
			worldMapView.getListScrollPane().setVisible(false);
			worldMapView.getUnitsInfoAreaScrollable().setVisible(false);
			worldMapView.getCancelAttackWithArmy().setVisible(false);
			worldMapView.getAttackWithArmy().setVisible(false);
			worldMapView.getAvailableArmiesToFight().setVisible(false);
			worldMapView.getIdleArmyButton().setVisible(true);
			worldMapView.getMarchingArmyButton().setVisible(true);
			worldMapView.getBesiegingArmyButton().setVisible(true);
			worldMapView.getIdleArmyLabel().setVisible(true);
			worldMapView.getMarchingArmyLabel().setVisible(true);
			worldMapView.getBesiegingArmyLabel().setVisible(true);
			worldMapView.getListModel().removeAllElements();
			worldMapView.getUnitsInfoArea().setText("");
		}

		if (e.getSource() == worldMapView.getAttackWithArmy()) {
			if (worldMapView.getChooseArmyTargetList().getSelectedIndex() == -1) {
				JOptionPane.showMessageDialog(null, "You Have to Choose an Army First!", "Error", JOptionPane.ERROR_MESSAGE);
			} else if (game.getPlayer().getControlledArmies().get((Integer.parseInt((worldMapView.getChooseArmyTargetList().getSelectedValue() + "").substring(5)) - 1)).getUnits().size() != 0) {
				game.targetCity(game.getPlayer().getControlledArmies().get((Integer.parseInt((worldMapView.getChooseArmyTargetList().getSelectedValue() + "").substring(5)) - 1)), cityViewChoice);
				worldMapView.getListScrollPane().setVisible(false);
				worldMapView.getUnitsInfoAreaScrollable().setVisible(false);
				worldMapView.getCancelAttackWithArmy().setVisible(false);
				worldMapView.getAttackWithArmy().setVisible(false);
				worldMapView.getAvailableArmiesToFight().setVisible(false);
				worldMapView.getListModel().removeAllElements();
				worldMapView.getUnitsInfoArea().setText("");
				worldMapView.getIdleArmyButton().setVisible(true);
				worldMapView.getMarchingArmyButton().setVisible(true);
				worldMapView.getBesiegingArmyButton().setVisible(true);
				worldMapView.getIdleArmyLabel().setVisible(true);
				worldMapView.getMarchingArmyLabel().setVisible(true);
				worldMapView.getBesiegingArmyLabel().setVisible(true);
				JOptionPane.showMessageDialog(null, "Army was Sent Successfully!");

			} else {
				JOptionPane.showMessageDialog(null, "You Have to Choose an Army With Atleast One Unit!", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}

		if (e.getSource() == battleView.getAttack()) {
			if (battleView.getListDefending().getSelectedIndex() == -1 || battleView.getListAttacking().getSelectedIndex() == -1) {
				JOptionPane.showMessageDialog(null, "You Have to Choose Both Units!", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				Unit attack = this.attacking.getUnits().get((Integer.parseInt((battleView.getListAttacking().getSelectedValue() + "").substring(5)) - 1));
				Unit defend = this.defending.getUnits().get((Integer.parseInt((battleView.getListDefending().getSelectedValue() + "").substring(5)) - 1));
				String cityName = defend.getParentArmy().getCurrentLocation();
				String attackType = attack.getClass().getSimpleName();
				String defendType = defend.getClass().getSimpleName();
				try {
					attack.attack(defend);
				} catch (FriendlyFireException e1) {
				}
				battleView.getBattleUnitsChosenAttacking().setText("");
				battleView.getBattleUnitsChosenDefending().setText("");
				battleView.getListModelAttacking().clear();
				battleView.getListModelDefending().clear();
				loadListAttacking();
				loadListDefending();
				int defendSizeAfter = defend.getCurrentSoldierCount();
				if (defendSizeAfter == 0) {
					battleView.getBattleLogArea().setText(battleView.getBattleLogArea().getText() + "Your " + attackType + " Killed All the Soldiers in this " + defendType + " Unit" + "\n");
				} else {
					battleView.getBattleLogArea().setText(battleView.getBattleLogArea().getText() + "Your " + attackType + " Reduced the Enemy's Soldiers in this " + defendType + " Unit to: "
							+ defendSizeAfter + " Soldiers" + "\n");
				}
				if (this.defending.getUnits().size() == 0) {
					game.occupy(attack.getParentArmy(), cityName);
					battleView.getBattleLogArea().setText(battleView.getBattleLogArea().getText() + "--------------------------------------------" + "\n" + "Your Army Won The Battle And Conquered "
							+ attack.getParentArmy().getCurrentLocation());
					battleView.getSimulateBattle().setEnabled(false);
					battleView.getAttack().setEnabled(false);
					battleView.getReturnToWorld().setEnabled(true);
				} else {

					Unit attackReact = this.attacking.getUnits().get((int) (Math.random() * this.attacking.getUnits().size()));
					Unit defendReact = this.defending.getUnits().get((int) (Math.random() * this.defending.getUnits().size()));

					String attackReactType = attack.getClass().getSimpleName();
					String defendReactType = defend.getClass().getSimpleName();

					try {
						defendReact.attack(attackReact);
					} catch (FriendlyFireException e1) {
					}
					battleView.getBattleUnitsChosenAttacking().setText("");
					battleView.getBattleUnitsChosenDefending().setText("");
					battleView.getListModelAttacking().clear();
					battleView.getListModelDefending().clear();
					loadListAttacking();
					loadListDefending();
					int attackSizeAfter = attackReact.getCurrentSoldierCount();
					String harfGar = "an";
					if (attackType.equalsIgnoreCase("Cavalry")) {
						harfGar = "a";
					}
					if (attackSizeAfter == 0) {
						battleView.getBattleLogArea()
								.setText(battleView.getBattleLogArea().getText() + "Computer " + defendReactType + " Killed All your Soldiers in " + harfGar + " " + attackReactType + " Unit" + "\n");
					} else {
						battleView.getBattleLogArea().setText(battleView.getBattleLogArea().getText() + "Computer " + defendReactType + " Reduced your Soldiers in " + harfGar + " " + attackReactType
								+ " Unit to: " + attackSizeAfter + " Soldiers" + "\n");
					}

					if (this.attacking.getUnits().size() == 0) {
						battleView.getBattleLogArea()
								.setText(battleView.getBattleLogArea().getText() + "--------------------------------------------" + "\n" + "Your Army Lost The Fight and Failed to Conquer This City ");
						battleView.getSimulateBattle().setEnabled(false);
						battleView.getAttack().setEnabled(false);
						battleView.getReturnToWorld().setEnabled(true);
					}

				}
			}
		}

		if (e.getSource() == battleView.getSimulateBattle()) {
			Army attack = this.attacking;
			Army defend = this.defending;
			try {
				game.autoResolve(attack, defend);
			} catch (FriendlyFireException e1) {
			}
			int defendSizeAfter = defend.getUnits().size();
			battleView.getListModelAttacking().removeAllElements();
			battleView.getListModelDefending().removeAllElements();
			if (defendSizeAfter == 0) {
				battleView.getBattleLogArea().setText(
						battleView.getBattleLogArea().getText() + "--------------------------------------------" + "\n" + "Your Army Won The Battle And Conquered " + attack.getCurrentLocation());
				loadListAttacking();
			} else {
				battleView.getBattleLogArea()
						.setText(battleView.getBattleLogArea().getText() + "--------------------------------------------" + "\n" + "Your Army Lost The Fight and Failed to Conquer This City  ");
				loadListDefending();
			}
			battleView.getBattleUnitsChosenAttacking().setText("");
			battleView.getBattleUnitsChosenDefending().setText("");
			battleView.getSimulateBattle().setEnabled(false);
			battleView.getAttack().setEnabled(false);
			battleView.getReturnToWorld().setEnabled(true);
		}

		if (e.getSource() == battleView.getReturnToWorld()) {
			battleView.setVisible(false);
			worldMapView.setVisible(true);
			battleView.getBattleUnitsChosenAttacking().setText("");
			battleView.getBattleUnitsChosenDefending().setText("");
			battleView.getListModelAttacking().removeAllElements();
			battleView.getListModelDefending().removeAllElements();
			battleView.getBattleLogArea().setText("");
		}

		if (e.getSource() == cityView.getrelocateUnitsButton()) {
			cityView.getArcheryRangeLabel().setForeground(Color.WHITE);
			cityView.getMarketLabel().setForeground(Color.WHITE);
			cityView.getFarmLabel().setForeground(Color.WHITE);
			cityView.getBarracksLabel().setForeground(Color.WHITE);
			cityView.getStableLabel().setForeground(Color.WHITE);
			buildingChoice = "";
			loadListArmiesRelocateUnits();
			cityView.setVisible(false);
			relocateView.setVisible(true);
		}
		if (e.getSource() == relocateView.getReturnToCityView()) {
			relocateView.getListModelFrom().removeAllElements();
			relocateView.getListModelTo().removeAllElements();
			relocateView.getListModelUnits().removeAllElements();
			relocateView.getUnitInfo().setText("");
			relocateView.setVisible(false);
			cityView.setVisible(true);

		}
		if (e.getSource() == relocateView.getRelocate()) {
			if (relocateView.getListFrom().getSelectedIndex() == -1 || relocateView.getListTo().getSelectedIndex() == -1 || relocateView.getListUnits().getSelectedIndex() == -1) {
				JOptionPane.showMessageDialog(worldMapView, "You Must Select Both Armies and Unit!", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				Army info = null;
				try {
					info = game.getPlayer().getControlledArmies().get((Integer.parseInt((relocateView.getListTo().getSelectedValue() + "").substring(5)) - 1));
				} catch (Exception e1) {
					for (int i = 0; i < game.getPlayer().getControlledCities().size(); i++) {
						if (cityViewChoice.equalsIgnoreCase(game.getPlayer().getControlledCities().get(i).getName())) {
							info = game.getPlayer().getControlledCities().get(i).getDefendingArmy();
							break;
						}
					}
				}
				int numberOfIdle = 0;
				Unit u = null;
				Army a = null;
				for (int i = 0; i < game.getPlayer().getControlledArmies().size(); i++) {
					if (game.getPlayer().getControlledArmies().get(i).getCurrentStatus() == Status.IDLE
							&& game.getPlayer().getControlledArmies().get(i).getCurrentLocation().equalsIgnoreCase(cityViewChoice)
							&& game.getPlayer().getControlledArmies().get(i).getUnits().size() != 0) {
						numberOfIdle++;
					}
				}
				if (relocateView.getListFrom().getSelectedIndex() < numberOfIdle) {
					u = game.getPlayer().getControlledArmies().get((Integer.parseInt((relocateView.getListFrom().getSelectedValue() + "").substring(5)) - 1)).getUnits()
							.get((Integer.parseInt((relocateView.getListUnits().getSelectedValue() + "").substring(5)) - 1));
				} else {
					for (int i = 0; i < game.getPlayer().getControlledCities().size(); i++) {
						if (cityViewChoice.equalsIgnoreCase(game.getPlayer().getControlledCities().get(i).getName())) {
							a = game.getPlayer().getControlledCities().get(i).getDefendingArmy();
							break;
						}
					}
					u = a.getUnits().get((Integer.parseInt((relocateView.getListUnits().getSelectedValue() + "").substring(5)) - 1));
				}
				boolean exceptionRelocate = false;
				try {
					info.relocateUnit(u);
				} catch (MaxCapacityException e1) {
					exceptionRelocate = true;
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
				}
				if (!exceptionRelocate) {
					relocateView.getListModelFrom().removeAllElements();
					relocateView.getListModelTo().removeAllElements();
					loadListArmiesRelocateUnits();
					relocateView.getListModelUnits().removeAllElements();
					relocateView.getUnitInfo().setText("");
					JOptionPane.showMessageDialog(null, "You Relocated This Unit Successfuly");

				}
			}
		}

		if (e.getSource() == relocateView.getRelocateAll()) {
			if (relocateView.getListFrom().getSelectedIndex() == -1 || relocateView.getListTo().getSelectedIndex() == -1) {
				JOptionPane.showMessageDialog(worldMapView, "You Must Select Both Armies", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				Army info = null;
				try {
					info = game.getPlayer().getControlledArmies().get((Integer.parseInt((relocateView.getListTo().getSelectedValue() + "").substring(5)) - 1));
				} catch (Exception e1) {
					for (int i = 0; i < game.getPlayer().getControlledCities().size(); i++) {
						if (cityViewChoice.equalsIgnoreCase(game.getPlayer().getControlledCities().get(i).getName())) {
							info = game.getPlayer().getControlledCities().get(i).getDefendingArmy();
							break;
						}
					}
				}
				int numberOfIdle = 0;
				Unit u = null;
				Army a = null;
				for (int i = 0; i < game.getPlayer().getControlledArmies().size(); i++) {
					if (game.getPlayer().getControlledArmies().get(i).getCurrentStatus() == Status.IDLE
							&& game.getPlayer().getControlledArmies().get(i).getCurrentLocation().equalsIgnoreCase(cityViewChoice)
							&& game.getPlayer().getControlledArmies().get(i).getUnits().size() != 0) {
						numberOfIdle++;
					}
				}
				if (relocateView.getListFrom().getSelectedIndex() < numberOfIdle) {
					a = game.getPlayer().getControlledArmies().get((Integer.parseInt((relocateView.getListFrom().getSelectedValue() + "").substring(5)) - 1));
				} else {
					for (int i = 0; i < game.getPlayer().getControlledCities().size(); i++) {
						if (cityViewChoice.equalsIgnoreCase(game.getPlayer().getControlledCities().get(i).getName())) {
							a = game.getPlayer().getControlledCities().get(i).getDefendingArmy();
							break;
						}
					}
				}
				if (info.getUnits().size() == info.getMaxToHold()) {
					JOptionPane.showMessageDialog(null, "Max Capacity Reached!", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					boolean exceptionRelocate = false;
					try {
						int loop = a.getUnits().size();
						for (int i = 0; i < loop; i++) {
							u = a.getUnits().get(0);
							info.relocateUnit(u);
						}
					} catch (MaxCapacityException e1) {
						exceptionRelocate = true;
						relocateView.getListModelFrom().removeAllElements();
						relocateView.getListModelTo().removeAllElements();
						loadListArmiesRelocateUnits();
						relocateView.getListModelUnits().removeAllElements();
						relocateView.getUnitInfo().setText("");
						JOptionPane.showMessageDialog(null, "Relocated Till Army Capacity is at Max!");
					}
					if (!exceptionRelocate) {
						relocateView.getListModelFrom().removeAllElements();
						relocateView.getListModelTo().removeAllElements();
						loadListArmiesRelocateUnits();
						relocateView.getListModelUnits().removeAllElements();
						relocateView.getUnitInfo().setText("");
						JOptionPane.showMessageDialog(null, "You Relocated All Units Successfully");

					}
				}
			}
		}

		if (e.getSource() == cityView.getInitiateNewArmyButton()) {
			cityView.getArcheryRangeLabel().setForeground(Color.WHITE);
			cityView.getMarketLabel().setForeground(Color.WHITE);
			cityView.getFarmLabel().setForeground(Color.WHITE);
			cityView.getBarracksLabel().setForeground(Color.WHITE);
			cityView.getStableLabel().setForeground(Color.WHITE);
			buildingChoice = "";
			Army a = null;
			for (int i = 0; i < game.getPlayer().getControlledCities().size(); i++) {
				if (cityViewChoice.equalsIgnoreCase(game.getPlayer().getControlledCities().get(i).getName())) {
					a = game.getPlayer().getControlledCities().get(i).getDefendingArmy();
					break;
				}
			}
			if (a.getUnits().size() == 0) {
				JOptionPane.showMessageDialog(null, "Your Defending Army Is Empty" + "\n" + "You Must Recruit Units First!", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				LoadListDefendingArmyUnits(a);
				cityView.getDefendingUnitsLabel().setVisible(true);
				cityView.getListScrollPaneUnits().setVisible(true);
				cityView.getUnitsInfoAreaScrollable().setVisible(true);
				cityView.getCancelInitiate().setVisible(true);
				cityView.getInitiate().setVisible(true);
				cityView.getFarmButton().setVisible(false);
				cityView.getMarketButton().setVisible(false);
				cityView.getArcheryRangeButton().setVisible(false);
				cityView.getBarracksButton().setVisible(false);
				cityView.getStableButton().setVisible(false);
				cityView.getInitiateNewArmyButton().setVisible(false);
				cityView.getDefendingArmy().setVisible(false);
				cityView.getRelocateUnitsButton().setVisible(false);
				cityView.getArmiesInTheCity().setVisible(false);
				cityView.getUpgradeButton().setVisible(false);
				cityView.getBuyButton().setVisible(false);
				cityView.getRecruitButton().setVisible(false);
				cityView.getFarmLabel().setVisible(false);
				cityView.getMarketLabel().setVisible(false);
				cityView.getArcheryRangeLabel().setVisible(false);
				cityView.getBarracksLabel().setVisible(false);
				cityView.getStableLabel().setVisible(false);
				cityView.getInitiateNewArmyLabel().setVisible(false);
				cityView.getDefendingArmyLabel().setVisible(false);
				cityView.getRelocateUnitsLabel().setVisible(false);
				cityView.getArmiesInTheCityLabel().setVisible(false);
				cityView.getReturnToWorldMap().setEnabled(false);
				cityView.getArcheryRangeLevelLabel().setVisible(false);
				cityView.getStableLevelLabel().setVisible(false);

			}
		}
		if (e.getSource() == cityView.getCancelInitiate()) {
			cityView.getReturnToWorldMap().setEnabled(true);
			cityView.getFarmButton().setVisible(true);
			cityView.getMarketButton().setVisible(true);
			cityView.getArcheryRangeButton().setVisible(true);
			cityView.getBarracksButton().setVisible(true);
			cityView.getStableButton().setVisible(true);
			cityView.getInitiateNewArmyButton().setVisible(true);
			cityView.getDefendingArmy().setVisible(true);
			cityView.getRelocateUnitsButton().setVisible(true);
			cityView.getArmiesInTheCity().setVisible(true);
			cityView.getUpgradeButton().setVisible(true);
			cityView.getBuyButton().setVisible(true);
			cityView.getRecruitButton().setVisible(true);
			cityView.getFarmLabel().setVisible(true);
			cityView.getMarketLabel().setVisible(true);
			cityView.getArcheryRangeLabel().setVisible(true);
			cityView.getBarracksLabel().setVisible(true);
			cityView.getStableLabel().setVisible(true);
			cityView.getInitiateNewArmyLabel().setVisible(true);
			cityView.getDefendingArmyLabel().setVisible(true);
			cityView.getRelocateUnitsLabel().setVisible(true);
			cityView.getArmiesInTheCityLabel().setVisible(true);
			cityView.getDefendingUnitsLabel().setVisible(false);
			cityView.getListScrollPaneUnits().setVisible(false);
			cityView.getUnitsInfoAreaScrollable().setVisible(false);
			cityView.getCancelInitiate().setVisible(false);
			cityView.getInitiate().setVisible(false);
			cityView.getListModelDefending().removeAllElements();
			cityView.getUnitsInfoArea().setText("");
		}
		if (e.getSource() == cityView.getInitiate()) {
			if (cityView.getListDefending().getSelectedIndex() == -1) {
				JOptionPane.showMessageDialog(null, "You Have to Choose a Unit First!", "Error", JOptionPane.ERROR_MESSAGE);
			} else {
				cityView.getReturnToWorldMap().setEnabled(true);
				cityView.getFarmButton().setVisible(true);
				cityView.getMarketButton().setVisible(true);
				cityView.getArcheryRangeButton().setVisible(true);
				cityView.getBarracksButton().setVisible(true);
				cityView.getStableButton().setVisible(true);
				cityView.getInitiateNewArmyButton().setVisible(true);
				cityView.getDefendingArmy().setVisible(true);
				cityView.getRelocateUnitsButton().setVisible(true);
				cityView.getArmiesInTheCity().setVisible(true);
				cityView.getUpgradeButton().setVisible(true);
				cityView.getBuyButton().setVisible(true);
				cityView.getRecruitButton().setVisible(true);
				cityView.getFarmLabel().setVisible(true);
				cityView.getMarketLabel().setVisible(true);
				cityView.getArcheryRangeLabel().setVisible(true);
				cityView.getBarracksLabel().setVisible(true);
				cityView.getStableLabel().setVisible(true);
				cityView.getInitiateNewArmyLabel().setVisible(true);
				cityView.getDefendingArmyLabel().setVisible(true);
				cityView.getRelocateUnitsLabel().setVisible(true);
				cityView.getArmiesInTheCityLabel().setVisible(true);
				cityView.getDefendingUnitsLabel().setVisible(false);
				cityView.getListScrollPaneUnits().setVisible(false);
				cityView.getUnitsInfoAreaScrollable().setVisible(false);
				cityView.getCancelInitiate().setVisible(false);
				cityView.getInitiate().setVisible(false);

				Army a = null;
				for (int i = 0; i < game.getPlayer().getControlledCities().size(); i++) {
					if (cityViewChoice.equalsIgnoreCase(game.getPlayer().getControlledCities().get(i).getName())) {
						a = game.getPlayer().getControlledCities().get(i).getDefendingArmy();
						break;
					}
				}
				City c = null;
				for (int i = 0; i < game.getPlayer().getControlledCities().size(); i++) {
					if (cityViewChoice.equalsIgnoreCase(game.getPlayer().getControlledCities().get(i).getName())) {
						c = game.getPlayer().getControlledCities().get(i);
						break;
					}
				}
				Unit u = a.getUnits().get((Integer.parseInt((cityView.getListDefending().getSelectedValue() + "").substring(5)) - 1));
				game.getPlayer().initiateArmy(c, u);
				JOptionPane.showMessageDialog(null, "You Successfully Initiated a New Army!");
				cityView.getListModelDefending().removeAllElements();
				cityView.getUnitsInfoArea().setText("");

			}
		}
		if (e.getSource() == victoryView.getExitButton()) {
			System.exit(0);
		}
		if (e.getSource() == cityView.getEndTurn() || e.getSource() == worldMapView.getEndTurn()) {
			cityView.getArcheryRangeLabel().setForeground(Color.WHITE);
			cityView.getMarketLabel().setForeground(Color.WHITE);
			cityView.getFarmLabel().setForeground(Color.WHITE);
			cityView.getBarracksLabel().setForeground(Color.WHITE);
			cityView.getStableLabel().setForeground(Color.WHITE);
			buildingChoice = "";
			game.endTurn();
			if (game.isGameOver()) {
				JOptionPane.showMessageDialog(null, "You Lost :(");
				System.exit(0);
			}
			JOptionPane.showMessageDialog(null, "Current Turn Now is: " + game.getCurrentTurnCount() + "\n" + "Turns Left: " + ((game.getMaxTurnCount() - game.getCurrentTurnCount()) + 1));
			for (int i = 0; i < game.getPlayer().getControlledArmies().size(); i++) {
				if (game.getPlayer().getControlledArmies().get(i).getDistancetoTarget() == 0 && !game.getPlayer().getControlledArmies().get(i).getCurrentStatus().equals(Status.BESIEGING)
						&& game.getPlayer().getControlledArmies().get(i).getUnits().size() != 0) {
					String[] buttons = { "Attack", "Beseige" };
					int rc = JOptionPane.showOptionDialog(null, "Your Army Arrived to Target City!", "Attack Or Beseige?", JOptionPane.YES_NO_OPTION, 0, null, buttons, buttons[1]);
					while (rc != JOptionPane.YES_OPTION && rc != JOptionPane.NO_OPTION) {
						rc = JOptionPane.showOptionDialog(null, "Your Army Arrived to Target City!", "Attack Or Beseige?", JOptionPane.YES_NO_OPTION, 0, null, buttons, buttons[1]);
					}
					if (rc == JOptionPane.YES_OPTION) {
						String targetLocation = game.getPlayer().getControlledArmies().get(i).getCurrentLocation();
						for (int j = 0; j < game.getAvailableCities().size(); j++) {
							if (game.getAvailableCities().get(j).getName().equalsIgnoreCase(targetLocation)) {
								defending = game.getAvailableCities().get(j).getDefendingArmy();
							}
						}
						attacking = game.getPlayer().getControlledArmies().get(i);
						loadListAttacking();
						loadListDefending();
						battleView.getSimulateBattle().setEnabled(true);
						battleView.getAttack().setEnabled(true);
						battleView.getReturnToWorld().setEnabled(false);
						chooseNameView.setVisible(false);
						chooseCityView.setVisible(false);
						worldMapView.setVisible(false);
						armiesInfoView.setVisible(false);
						cityView.setVisible(false);
						relocateView.setVisible(false);
						battleView.setVisible(true);
					} else if (rc == JOptionPane.NO_OPTION) {
						City c = null;
						String targetLocation = game.getPlayer().getControlledArmies().get(i).getCurrentLocation();
						for (int j = 0; j < game.getAvailableCities().size(); j++) {
							if (game.getAvailableCities().get(j).getName().equalsIgnoreCase(targetLocation)) {
								defending = game.getAvailableCities().get(j).getDefendingArmy();
							}
						}
						attacking = game.getPlayer().getControlledArmies().get(i);
						for (int j = 0; j < game.getAvailableCities().size(); j++) {
							if (game.getAvailableCities().get(j).getName().equalsIgnoreCase(targetLocation)) {
								c = game.getAvailableCities().get(j);
							}
						}
						try {
							game.getPlayer().laySiege(attacking, c);
						} catch (TargetNotReachedException e1) {
						} catch (FriendlyCityException e1) {
						}
					}
				} else if (game.getPlayer().getControlledArmies().get(i).getDistancetoTarget() == -1) {
					City c = null;
					String targetLocation = game.getPlayer().getControlledArmies().get(i).getCurrentLocation();
					for (int j = 0; j < game.getAvailableCities().size(); j++) {
						if (game.getAvailableCities().get(j).getName().equalsIgnoreCase(targetLocation)) {
							c = game.getAvailableCities().get(j);
						}
					}
					if (c.getTurnsUnderSiege() == 3) {
						for (int j = 0; j < game.getAvailableCities().size(); j++) {
							if (game.getAvailableCities().get(j).getName().equalsIgnoreCase(targetLocation)) {
								defending = game.getAvailableCities().get(j).getDefendingArmy();
							}
						}
						game.getPlayer().getControlledArmies().get(i).setDistancetoTarget(0);
						attacking = game.getPlayer().getControlledArmies().get(i);
						JOptionPane.showMessageDialog(null, "Your Army Has been Besieging For 3 Turns" + "\n" + "You Must Fight Now!!");
						loadListAttacking();
						loadListDefending();
						battleView.getSimulateBattle().setEnabled(true);
						battleView.getAttack().setEnabled(true);
						battleView.getReturnToWorld().setEnabled(false);
						chooseNameView.setVisible(false);
						chooseCityView.setVisible(false);
						worldMapView.setVisible(false);
						armiesInfoView.setVisible(false);
						cityView.setVisible(false);
						relocateView.setVisible(false);
						battleView.setVisible(true);
					}

				}
			}
		}

		if (game != null && game.isGameOver()) {
			chooseNameView.setVisible(false);
			chooseCityView.setVisible(false);
			worldMapView.setVisible(false);
			armiesInfoView.setVisible(false);
			cityView.setVisible(false);
			relocateView.setVisible(false);
			battleView.setVisible(false);
			victoryView.setVisible(true);
			try {
				playSound3();
			} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e1) {
			}
		}
		if (game != null) {
			for (int i = 0; i < game.getPlayer().getControlledArmies().size(); i++) {
				if (game.getPlayer().getControlledArmies().get(i).getUnits().size() == 0) {
					game.getPlayer().getControlledArmies().remove(game.getPlayer().getControlledArmies().get(i));
				}
			}
			if (e.getSource() != cityView.getInitiateNewArmyButton()) {
				boolean foundFarm = false;
				boolean foundMarket = false;
				boolean foundArchery = false;
				boolean foundStable = false;
				boolean foundBarracks = false;

				for (int i = 0; i < game.getPlayer().getControlledCities().size(); i++) {
					City c = game.getPlayer().getControlledCities().get(i);
					for (int j = 0; j < game.getPlayer().getControlledCities().get(i).getEconomicalBuildings().size(); j++) {
						if (game.getPlayer().getControlledCities().get(i).getEconomicalBuildings().get(j).getClass().getSimpleName().equalsIgnoreCase("Farm")
								&& c.getName().equalsIgnoreCase(cityViewChoice)) {
							cityView.getFarmLevelLabel().setVisible(true);
							cityView.getFarmLevelLabel().setText("Level: " + game.getPlayer().getControlledCities().get(i).getEconomicalBuildings().get(j).getLevel());
							foundFarm = true;
						} else if (c.getName().equalsIgnoreCase(cityViewChoice)) {
							cityView.getMarketLevelLabel().setVisible(true);
							cityView.getMarketLevelLabel().setText("Level: " + game.getPlayer().getControlledCities().get(i).getEconomicalBuildings().get(j).getLevel());
							foundMarket = true;
						}
					}
					for (int j = 0; j < game.getPlayer().getControlledCities().get(i).getMilitaryBuildings().size(); j++) {
						if (game.getPlayer().getControlledCities().get(i).getMilitaryBuildings().get(j).getClass().getSimpleName().equalsIgnoreCase("Barracks")
								&& c.getName().equalsIgnoreCase(cityViewChoice)) {
							cityView.getBarracksLevelLabel().setVisible(true);
							cityView.getBarracksLevelLabel().setText("Level: " + game.getPlayer().getControlledCities().get(i).getMilitaryBuildings().get(j).getLevel());
							foundBarracks = true;
						} else if (game.getPlayer().getControlledCities().get(i).getMilitaryBuildings().get(j).getClass().getSimpleName().equalsIgnoreCase("Stable")
								&& c.getName().equalsIgnoreCase(cityViewChoice)) {
							cityView.getStableLevelLabel().setVisible(true);
							cityView.getStableLevelLabel().setText("Level: " + game.getPlayer().getControlledCities().get(i).getMilitaryBuildings().get(j).getLevel());
							foundStable = true;
						} else if (c.getName().equalsIgnoreCase(cityViewChoice)) {
							cityView.getArcheryRangeLevelLabel().setVisible(true);
							cityView.getArcheryRangeLevelLabel().setText("Level: " + game.getPlayer().getControlledCities().get(i).getMilitaryBuildings().get(j).getLevel());
							foundArchery = true;
						}
					}
					if (!foundFarm) {
						cityView.getFarmLevelLabel().setVisible(false);
					}
					if (!foundBarracks) {
						cityView.getBarracksLevelLabel().setVisible(false);
					}
					if (!foundArchery) {
						cityView.getArcheryRangeLevelLabel().setVisible(false);
					}
					if (!foundMarket) {
						cityView.getMarketLevelLabel().setVisible(false);
					}
					if (!foundStable) {
						cityView.getStableLevelLabel().setVisible(false);
					}
				}
			}
		}
		refresher();
	}

	public void valueChanged(ListSelectionEvent e) {

		if (!armiesInfoView.getList().getValueIsAdjusting() && armiesInfoView.getList().getSelectedIndex() != -1 && game.getPlayer().getControlledArmies().size() != 0) {
			String info = getArmyInfo(game.getPlayer().getControlledArmies().get((Integer.parseInt((armiesInfoView.getList().getSelectedValue() + "").substring(5)) - 1)));
			armiesInfoView.getUnitsInfoArea().setText(info);
		}
		if (!worldMapView.getChooseArmyTargetList().getValueIsAdjusting() && worldMapView.getChooseArmyTargetList().getSelectedIndex() != -1) {
			String info = getArmyInfo(game.getPlayer().getControlledArmies().get((Integer.parseInt((worldMapView.getChooseArmyTargetList().getSelectedValue() + "").substring(5)) - 1)));
			worldMapView.getUnitsInfoArea().setText(info);
		}
		if (!battleView.getListAttacking().getValueIsAdjusting() && battleView.getListAttacking().getSelectedIndex() != -1 && this.attacking.getUnits().size() != 0) {
			String info = getUnitInfo(this.attacking.getUnits().get((Integer.parseInt((battleView.getListAttacking().getSelectedValue() + "").substring(5)) - 1)));
			battleView.getBattleUnitsChosenAttacking().setText(info);
		}

		if (!battleView.getListDefending().getValueIsAdjusting() && battleView.getListDefending().getSelectedIndex() != -1 && this.defending.getUnits().size() != 0) {
			String info = getUnitInfo(this.defending.getUnits().get((Integer.parseInt((battleView.getListDefending().getSelectedValue() + "").substring(5)) - 1)));
			battleView.getBattleUnitsChosenDefending().setText(info);
		}
		if (!relocateView.getListUnits().getValueIsAdjusting() && relocateView.getListUnits().getSelectedIndex() != -1) {
			relocateView.getListUnits().setValueIsAdjusting(true);
			int numberOfIdle = 0;
			String info = "";
			Army a = null;
			for (int i = 0; i < game.getPlayer().getControlledArmies().size(); i++) {
				if (game.getPlayer().getControlledArmies().get(i).getCurrentStatus() == Status.IDLE
						&& game.getPlayer().getControlledArmies().get(i).getCurrentLocation().equalsIgnoreCase(cityViewChoice)
						&& game.getPlayer().getControlledArmies().get(i).getUnits().size() != 0) {
					numberOfIdle++;
				}
			}
			if (relocateView.getListFrom().getSelectedIndex() < numberOfIdle) {
				info = getUnitInfo(game.getPlayer().getControlledArmies().get((Integer.parseInt((relocateView.getListFrom().getSelectedValue() + "").substring(5)) - 1)).getUnits()
						.get((Integer.parseInt((relocateView.getListUnits().getSelectedValue() + "").substring(5)) - 1)));
			} else {
				for (int i = 0; i < game.getPlayer().getControlledCities().size(); i++) {
					if (cityViewChoice.equalsIgnoreCase(game.getPlayer().getControlledCities().get(i).getName())) {
						a = game.getPlayer().getControlledCities().get(i).getDefendingArmy();
						break;
					}
				}
				info = getUnitInfo(a.getUnits().get((Integer.parseInt((relocateView.getListUnits().getSelectedValue() + "").substring(5)) - 1)));
			}
			relocateView.getUnitInfo().setText(info);
		}
		if (!relocateView.getListFrom().getValueIsAdjusting() && relocateView.getListFrom().getSelectedIndex() != -1) {
			relocateView.getListFrom().setValueIsAdjusting(true);
			Army info = null;
			relocateView.getListModelUnits().removeAllElements();
			relocateView.getUnitInfo().setText("");
			try {
				info = game.getPlayer().getControlledArmies().get((Integer.parseInt((relocateView.getListFrom().getSelectedValue() + "").substring(5)) - 1));
			} catch (Exception e1) {
				for (int i = 0; i < game.getPlayer().getControlledCities().size(); i++) {
					if (cityViewChoice.equalsIgnoreCase(game.getPlayer().getControlledCities().get(i).getName())) {
						info = game.getPlayer().getControlledCities().get(i).getDefendingArmy();
						break;
					}
				}
			}

			loadListUnitsRelocateUnits(info);
		}
		if (!cityView.getListDefending().getValueIsAdjusting() && cityView.getListDefending().getSelectedIndex() != -1) {
			Army a = null;
			String info = "";
			for (int i = 0; i < game.getPlayer().getControlledCities().size(); i++) {
				if (cityViewChoice.equalsIgnoreCase(game.getPlayer().getControlledCities().get(i).getName())) {
					a = game.getPlayer().getControlledCities().get(i).getDefendingArmy();
					break;
				}
			}
			info = getUnitInfo(a.getUnits().get((Integer.parseInt((cityView.getListDefending().getSelectedValue() + "").substring(5)) - 1)));
			cityView.getUnitsInfoArea().setText(info);
		}

	}

	public void loadListIdle() {
		for (int i = 0; i < game.getPlayer().getControlledArmies().size(); i++) {
			if (game.getPlayer().getControlledArmies().get(i).getCurrentStatus() == Status.IDLE) {
				armiesInfoView.getListModel().addElement("Army " + (i + 1) + "");
			}
		}
	}

	public void LoadListSetTarget() {
		for (int i = 0; i < game.getPlayer().getControlledArmies().size(); i++) {
			if (game.getPlayer().getControlledArmies().get(i).getCurrentStatus() == Status.IDLE) {
				worldMapView.getListModel().addElement("Army " + (i + 1) + "");
			}
		}
	}

	public void loadListAttacking() {
		for (int i = 0; i < this.attacking.getUnits().size(); i++) {
			battleView.getListModelAttacking().addElement("Unit " + (i + 1) + "");
		}
	}

	public void loadListDefending() {
		for (int i = 0; i < this.defending.getUnits().size(); i++) {
			battleView.getListModelDefending().addElement("Unit " + (i + 1) + "");
		}
	}

	public void loadListMarching() {
		for (int i = 0; i < game.getPlayer().getControlledArmies().size(); i++) {
			if (game.getPlayer().getControlledArmies().get(i).getCurrentStatus() == Status.MARCHING) {
				armiesInfoView.getListModel().addElement("Army " + (i + 1) + "");
			}
		}
	}

	public void loadListBesieging() {
		for (int i = 0; i < game.getPlayer().getControlledArmies().size(); i++) {
			if (game.getPlayer().getControlledArmies().get(i).getCurrentStatus() == Status.BESIEGING) {
				armiesInfoView.getListModel().addElement("Army " + (i + 1) + "");
			}
		}
	}

	public void loadListArmiesRelocateUnits() {
		for (int i = 0; i < game.getPlayer().getControlledArmies().size(); i++) {
			if (game.getPlayer().getControlledArmies().get(i).getCurrentStatus() == Status.IDLE && game.getPlayer().getControlledArmies().get(i).getCurrentLocation().equalsIgnoreCase(cityViewChoice)
					&& game.getPlayer().getControlledArmies().get(i).getUnits().size() != 0) {
				relocateView.getListModelFrom().addElement("Army " + (i + 1) + "");
			}
			if (game.getPlayer().getControlledArmies().get(i).getCurrentStatus() == Status.IDLE
					&& game.getPlayer().getControlledArmies().get(i).getCurrentLocation().equalsIgnoreCase(cityViewChoice)) {
				relocateView.getListModelTo().addElement("Army " + (i + 1) + "");
			}

		}
		relocateView.getListModelFrom().addElement("Defending");
		relocateView.getListModelTo().addElement("Defending");
	}

	public void loadListUnitsRelocateUnits(Army a) {
		for (int i = 0; i < a.getUnits().size(); i++) {
			relocateView.getListModelUnits().addElement("Unit " + (i + 1) + "");
		}
	}

	public void LoadListInTheCity(String c) {
		for (int i = 0; i < game.getPlayer().getControlledArmies().size(); i++) {
			if (game.getPlayer().getControlledArmies().get(i).getCurrentLocation().equalsIgnoreCase(c)) {
				armiesInfoView.getListModel().addElement("Army " + (i + 1) + "");
			}
		}
	}

	public void LoadListDefendingArmyUnits(Army a) {
		for (int i = 0; i < a.getUnits().size(); i++) {
			cityView.getListModelDefending().addElement("Unit " + (i + 1) + "");
		}
	}

	public String getArmyInfo(Army a) {
		String temp = "";
		if (a.getUnits().size() == 0) {
			temp += "No Units" + "\n";
		}
		for (int i = 0; i < a.getUnits().size(); i++) {
			temp += "Unit " + (i + 1) + " : " + " | Type: " + a.getUnits().get(i).getClass().getSimpleName() + " | Level: " + a.getUnits().get(i).getLevel() + " | Current Soldier Count: "
					+ a.getUnits().get(i).getCurrentSoldierCount() + " | Max Soldier Count: " + a.getUnits().get(i).getMaxSoldierCount() + "\n";
		}
		temp += "----------------------------------------------------------------------" + "\n";
		if (a.getCurrentStatus() == Status.MARCHING) {
			temp += "Target City: " + a.getTarget() + "\n" + "Turns Till Target: " + a.getDistancetoTarget();
		}
		if (a.getCurrentStatus() == Status.BESIEGING) {
			int turnsUnderSeige = 0;
			for (City c : game.getAvailableCities()) {
				if (c.getName().equalsIgnoreCase(a.getCurrentLocation())) {
					turnsUnderSeige = c.getTurnsUnderSiege();
				}
			}
			temp += "Besieging City: " + a.getCurrentLocation() + "\n" + "Turns Under Siege: " + turnsUnderSeige;
		}
		return temp;
	}

	public String getUnitInfo(Unit u) {
		String temp = "";
		temp += "Type: " + u.getClass().getSimpleName() + " | Level: " + u.getLevel() + " | Current Soldier Count: " + u.getCurrentSoldierCount() + " | Max Soldier Count: " + u.getMaxSoldierCount()
				+ "\n";
		return temp;
	}

	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		new GameController();
	}

}
