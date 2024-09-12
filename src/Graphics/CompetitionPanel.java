package Graphics;

import Animals.Animal;
import Competitions.CourierTournament;
import Competitions.RegularTournament;
import Competitions.ScoreKeeper;
import Competitions.Scores;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;


/**
 * Segev Chen 322433400
 * Yinon Alfasi 208810374
 * The {@code CompetitionPanel} class represents a panel for managing and displaying animal competitions.
 * It provides functionalities to add competitions, add animals, clear animals, feed animals, display animal information, and start the competition.
 *
 * <p>Attributes:</p>
 * <ul>
 *     <li>{@code numOfCreatedAnimals} - The number of created animals.</li>
 *     <li>{@code animalList} - The list of animals participating in the competition.</li>
 *     <li>{@code selectedCompetitionType} - The type of competition selected by the user.</li>
 *     <li>{@code selectedAnimalType} - The type of animal selected by the user.</li>
 *     <li>{@code selectedAnimal} - The specific animal selected by the user.</li>
 *     <li>{@code animalLabel} - A label for displaying animal information.</li>
 *     <li>{@code infoTable} - A table for displaying detailed information about the animals.</li>
 *     <li>{@code infoScroller} - A scroll pane for the information table.</li>
 *     <li>{@code infoDialog} - A dialog for displaying the information table.</li>
 *     <li>{@code columnNames} - The column names for the information table.</li>
 *     <li>{@code EnergyConsumption} - The total energy consumption of the animals.</li>
 *     <li>{@code pan} - A reference to the {@code CompetitionPanel} instance.</li>
 *     <li>{@code backgroundImg} - The background image of the panel.</li>
 *     <li>{@code backgroundPanel} - The panel for displaying the background image and animals.</li>
 *     <li>{@code preferredWidth} - The preferred width of the panel.</li>
 *     <li>{@code preferredHeight} - The preferred height of the panel.</li>
 *     <li>{@code timer} - A timer for updating the animation of the animals.</li>
 * </ul>
 *
 * <p>Methods:</p>
 * <ul>
 *     <li>{@code getAnimalList()} - Returns the list of animals.</li>
 *     <li>{@code getInfoPanel()} - Returns the background panel.</li>
 *     <li>{@code getBackgroundImg()} - Returns the background image.</li>
 *     <li>{@code eatValidationInput(JDialog eatDialog, JTextField eatAnimalText, Animal animal)} - Validates the input for feeding animals.</li>
 *     <li>{@code convertListTo2DArray(List<Animal> animals)} - Converts the list of animals to a 2D array for the information table.</li>
 *     <li>{@code updateTable()} - Updates the information table with the latest animal data.</li>
 *     <li>{@code getAnimalNames(List<Animal> animals)} - Returns an array of animal names from the list of animals.</li>
 *     <li>{@code getAnimalFromName(String animalName, List<Animal> animals)} - Returns an animal object from the list based on the animal name.</li>
 * </ul>
 *
 * <p>Constructor:</p>
 * <ul>
 *     <li>{@code CompetitionPanel(BufferedImage backgroundImg)} - Constructs the panel with the specified background image and sets up the GUI components.</li>
 * </ul>
 */
public class CompetitionPanel extends JPanel {
    int numOfCreatedAnimals = 0;
    private List<Animal> animalList = new ArrayList<>();

    private List<List<Animal>> RegularCompetitionsGroupsList = new ArrayList<>();
    private List<List<Animal>> RelayCompetitionsGroupsList = new ArrayList<>();

    private List<Animal> RegularAnimalListAlone;


    private static String selectedCompetitionType = null;
    private static String selectedCompetitionRelayOrRegular = null;
    private static String selectedAnimalType;
    private static String selectedAnimal;
    private JTable infoTable;
    private JScrollPane infoScroller;
    private JDialog infoDialog;
    private JDialog middleAddAnimalDialog;
    String[] columnNames = {"Animal", "Category", "Type", "Speed", "energyAmount", "Distance", "Energy consumption","Group Name", "Finish Time"};
    int EnergyConsumption = 0;
    private CompetitionPanel pan;
    private BufferedImage backgroundImg;
    private JPanel backgroundPanel;
    int preferredWidth;
    int preferredHeight;
    private Timer timer;
    private int numOfAnimalsInGroup;
    private String groupName;


    /**
     * Returns the list of animals.
     *
     * @return the list of animals.
     */
    public List<Animal> getAnimalList() {
        return animalList;
    }


    public List<List<Animal>> getRegularCompetitionsGroupsList() {
        return RegularCompetitionsGroupsList;
    }

    public List<List<Animal>> getRelayCompetitionsGroupsList() {
        return RelayCompetitionsGroupsList;
    }

    public int getNumOfCreatedAnimals(){
        return numOfCreatedAnimals;
    }

    /**
     * Returns the background panel.
     *
     * @return the background panel.
     */
    public JPanel getInfoPanel() {
        return backgroundPanel;
    }

    /**
     * Returns the background image.
     *
     * @return the background image.
     */
    public BufferedImage getBackgroundImg() {
        return backgroundImg;
    }

    /**
     * Constructs a new {@code CompetitionPanel} with the specified background image and sets up the GUI components.
     *
     * @param backgroundImg the background image.
     */
    public CompetitionPanel(BufferedImage backgroundImg) {
        this.pan = this;
        this.backgroundImg = backgroundImg;
        this.preferredWidth = backgroundImg.getWidth();
        this.preferredHeight = backgroundImg.getHeight();

        setLayout(new BorderLayout());

        backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (backgroundImg != null) {
                    g.drawImage(backgroundImg, 0, 0, getWidth(), getHeight(), this);
                }
                Graphics2D g2d = (Graphics2D) g;
                double scaleX = getWidth() / (double)preferredWidth;
                double scaleY = getHeight() / (double)preferredHeight;
                g2d.scale(scaleX, scaleY);
                for (Animal animal : animalList) {
                    if (animal != null) {
                        synchronized (animal){

                            animal.drawObject(g2d);
                        }

                    }
                }
            }
        };
        add(backgroundPanel, BorderLayout.CENTER);

        JPanel toolBarPanel = new JPanel(new FlowLayout());

        JButton AddCompetitionButton = new JButton("Add Competition");
        AddCompetitionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddCompetitionDialog competitionDialog = new AddCompetitionDialog();
                selectedCompetitionType = competitionDialog.getSelectedCompetitionType();
                selectedCompetitionRelayOrRegular = competitionDialog.getSelectedCompetitionRelayOrRegular();

            }
        });



        JButton AddAnimalButton = new JButton("Add Animal");
        AddAnimalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (selectedCompetitionType != null)
                {
                    if (selectedCompetitionRelayOrRegular.equals("Relay"))
                    {
                        addMiddleAddAnimalDialog();
                    }
                    else if (selectedCompetitionRelayOrRegular.equals("Regular"))
                    {
                        RegularAnimalListAlone = new ArrayList<>();
                        AddAnimalDialog addAnimalDialog = new AddAnimalDialog(selectedCompetitionType, pan);
                        if (addAnimalDialog.getSelectedAnimalType() != null && addAnimalDialog.getSelectedAnimal() != null) {
                            selectedAnimalType = addAnimalDialog.getSelectedAnimalType();
                            selectedAnimal = addAnimalDialog.getSelectedAnimal();
                        }
                        if (selectedAnimal != null) {
                            RegularAnimalListAlone.add(addAnimalDialog.getSelectedAnimalObj());
                            setEnabled(false);
                            animalList.add(addAnimalDialog.getSelectedAnimalObj());

                            RegularCompetitionsGroupsList.add(RegularAnimalListAlone);

                            for (List<Animal> group : RegularCompetitionsGroupsList) {
                                new SetAnimalLocationRelay(group, pan);
                            }


                            backgroundPanel.revalidate();
                            backgroundPanel.repaint();
                            numOfCreatedAnimals++;
                        } else {
                            JOptionPane.showMessageDialog(AddAnimalButton, "Please Select Animal", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(AddAnimalButton, "Please Select Competition Type", "Error", JOptionPane.ERROR_MESSAGE);
                }

            }
        });

        JButton ClearButton = new JButton("Clear");

        ClearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel clearPanel = new JPanel();
                clearPanel.setLayout(new BoxLayout(clearPanel, BoxLayout.Y_AXIS));
                clearPanel.setSize(300, 500);

                String[] nameArr = getAnimalNames(animalList);

                JDialog clearDialog = new JDialog();
                clearDialog.setTitle("Clear");
                clearDialog.setSize(300, 200);
                clearDialog.setModal(true);
                clearDialog.setLocationRelativeTo(null);

                JLabel clearLabel = new JLabel("Clear");
                JComboBox clearChooser = new JComboBox(nameArr);

                clearPanel.add(clearLabel);
                clearPanel.add(clearChooser);
                clearDialog.add(clearPanel);

                JButton saveButton = new JButton("Save");
                saveButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if (clearChooser.getSelectedItem() != null) {
                            Animal chosenObj = getAnimalFromName((String)clearChooser.getSelectedItem(), animalList);
                            animalList.remove(chosenObj);
                            backgroundPanel.revalidate();
                            backgroundPanel.repaint();
                            clearDialog.dispose();
                        }
                        else {
                            JOptionPane.showMessageDialog(clearPanel, "Please Choose an animal from the list!", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                });
                clearPanel.add(saveButton);

                clearDialog.setVisible(true);
            }
        });

        JButton EatButton = new JButton("Eat");
        EatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (AddAnimalDialog.getSelectedAnimalObjStatic() != null) {
                    JPanel eatPanel = new JPanel();
                    eatPanel.setLayout(new BoxLayout(eatPanel, BoxLayout.Y_AXIS));
                    eatPanel.setSize(300, 500);

                    String[] nameArr = getAnimalNames(animalList);

                    JDialog eatDialog = new JDialog();
                    eatDialog.setTitle("Eat");
                    eatDialog.setSize(300, 200);
                    eatDialog.setModal(true);
                    eatDialog.setLocationRelativeTo(null);

                    JLabel eatLabel = new JLabel("Eating Animal");
                    JComboBox eatChooser = new JComboBox(nameArr);
                    eatChooser.setSelectedItem(0);

                    JLabel eatAnimalLabel = new JLabel("Feed the animal, enter an integer number:");
                    JTextField eatAnimalText = new JTextField();

                    eatPanel.add(eatLabel);
                    eatPanel.add(eatChooser);
                    eatPanel.add(eatAnimalLabel);
                    eatPanel.add(eatAnimalText);

                    eatDialog.add(eatPanel);


                    JButton saveButton = new JButton("Save");
                    saveButton.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            if (eatChooser.getSelectedItem() != "Choose..") {
                                Animal chosenObj = getAnimalFromName((String)eatChooser.getSelectedItem(), animalList);
                                if (eatValidationInput(eatDialog, eatAnimalText, chosenObj)) {
                                    int eatAnimalInt = Integer.parseInt(eatAnimalText.getText());
                                    EnergyConsumption += eatAnimalInt;
                                    chosenObj.setEnergyLevel(eatAnimalInt);
                                    chosenObj.setEnergyConsumption(eatAnimalInt);

                                    JOptionPane.showMessageDialog(eatDialog, "Animal's energy level has been increased!", "Success", JOptionPane.INFORMATION_MESSAGE);
                                    eatDialog.dispose();
                                }
                            }
                            else {
                                JOptionPane.showMessageDialog(eatDialog, "Please Choose an animal from the list!", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    });

                    eatPanel.add(Box.createVerticalStrut(10)); // Add some space before the save button
                    eatPanel.add(saveButton);

                    eatDialog.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(EatButton, "Please Add Animal First", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton InfoButton = new JButton("Info");
        InfoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (animalList != null && !animalList.isEmpty()) {
                    if (infoDialog == null) {
                        infoDialog = new JDialog();
                        infoDialog.setTitle("Info");
                        infoDialog.setSize(500, 300);
                        infoDialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
                        infoDialog.setLocationRelativeTo(null);

                        Object[][] allAnimalsData = convertListTo2DArray(animalList);
                        infoTable = new JTable(allAnimalsData, columnNames);
                        infoScroller = new JScrollPane(infoTable);
                        infoDialog.add(infoScroller);

                    } else {
                        updateTable();
                    }
                    infoDialog.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(backgroundPanel, "Please Add Animals, Empty Table", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JButton ExitButton = new JButton("Exit");
        ExitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeAll();
                System.exit(0);
            }
        });

        JButton PlayButton = new JButton("Play");
        PlayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddAnimalButton.setEnabled(false);
                AddCompetitionButton.setEnabled(false);
                Scores scores = new Scores();
                if (RelayCompetitionsGroupsList != null || RelayCompetitionsGroupsList.size() > 0) {
                    CourierTournament courierTournament = new CourierTournament(RelayCompetitionsGroupsList, pan, scores);

                }
                if (RegularCompetitionsGroupsList != null || RegularCompetitionsGroupsList.size() > 0) {
                    RegularTournament regularTournament = new RegularTournament(RegularCompetitionsGroupsList, pan, scores);
                }
            }
        });


        toolBarPanel.add(AddCompetitionButton);
        toolBarPanel.add(AddAnimalButton);
        toolBarPanel.add(ClearButton);
        toolBarPanel.add(EatButton);
        toolBarPanel.add(InfoButton);
        toolBarPanel.add(PlayButton);
        toolBarPanel.add(ExitButton);
        add(toolBarPanel, BorderLayout.SOUTH);
    }


    /**
     * Validates the input for feeding animals.
     *
     * @param eatDialog the dialog for feeding animals.
     * @param eatAnimalText the text field for entering the energy amount.
     * @param animal the animal to be fed.
     * @return true if the input is valid, false otherwise.
     */
    private boolean eatValidationInput(JDialog eatDialog, JTextField eatAnimalText, Animal animal) {
        boolean isValid = true;

        if (eatAnimalText.getText().isEmpty()) {
            eatAnimalText.setBackground(Color.PINK);
            isValid = false;
        } else {
            eatAnimalText.setBackground(Color.WHITE);

            try {
                int energyValue = Integer.parseInt(eatAnimalText.getText());

                if (energyValue <= 0) {
                    eatAnimalText.setBackground(Color.PINK);
                    isValid = false;
                } else {
                    eatAnimalText.setBackground(Color.WHITE);
                }
            } catch (NumberFormatException e) {
                eatAnimalText.setBackground(Color.PINK);
                isValid = false;
            }
        }

        return isValid;
    }

    /**
     * Converts the list of animals to a 2D array for the information table.
     *
     * @param animals the list of animals.
     * @return a 2D array representing the animal data.
     */
    private Object[][] convertListTo2DArray(List<Animal> animals) {
        Scores scores = ScoreKeeper.getScores();
        Map<String, Date> scoresMap = scores.getAll();
        Object[][] data = new Object[animals.size()][9];
        for (int i = 0; i < animals.size(); i++) {
            Animal animal = animals.get(i);
            data[i][0] = animal.getAnimalName();
            data[i][1] = animal.getAnimalType();
            data[i][2] = animal.getSpecificAnimal();
            data[i][3] = animal.getSpeed();
            data[i][4] = animal.getEnergyLevel();
            data[i][5] = animal.getAnimalDistance();
            data[i][6] = animal.getEnergyConsumption();
            data[i][7] = animal.getGroupName();
            if (scoresMap.get(animal.getGroupName()) != null)
                data[i][8] = scoresMap.get(animal.getGroupName()).toString();
            else
                data[i][8] = "";
        }
        return data;
    }

    /**
     * Updates the information table with the latest animal data.
     */
    private void updateTable() {
        if (infoTable != null) {
            Object[][] animalsData = convertListTo2DArray(animalList);
            javax.swing.SwingUtilities.invokeLater(() -> {
                infoTable.setModel(new javax.swing.table.DefaultTableModel(animalsData, columnNames));
            });
        }
    }

    /**
     * Returns an array of animal names from the list of animals.
     *
     * @param animals the list of animals.
     * @return an array of animal names.
     */
    public static String[] getAnimalNames(List<Animal> animals) {
        String[] names = new String[animals.size() + 1];
        names[0] = "Choose..";
        for (int i = 1; i < animals.size() + 1; i++) {
            names[i] = animals.get(i - 1).getAnimalName();
        }
        return names;
    }

    /**
     * Returns an animal object from the list based on the animal name.
     *
     * @param animalName the name of the animal.
     * @param animals the list of animals.
     * @return the animal object, or null if not found.
     */
    public static Animal getAnimalFromName(String animalName, List<Animal> animals) {
        for (int i = 0; i < animals.size(); i++) {
            if (animals.get(i).getAnimalName().equals(animalName)) {
                return animals.get(i);
            }
        }
        return null;
    }
    public void addMiddleAddAnimalDialog(){
        numOfAnimalsInGroup = 0;
        groupName = null;
        List<Animal> RelayGroupList = new ArrayList<>();
        middleAddAnimalDialog = new JDialog();
        middleAddAnimalDialog.setTitle("Add Animal");
        middleAddAnimalDialog.setSize(400,400);
        middleAddAnimalDialog.setLayout(new BorderLayout());
        middleAddAnimalDialog.setLocationRelativeTo(null);
        middleAddAnimalDialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        JPanel middleAddAnimalPanel = new JPanel();
        middleAddAnimalPanel.setLayout(new BoxLayout(middleAddAnimalPanel, BoxLayout.Y_AXIS));

        JLabel groupNameLabel = new JLabel("Group Name");
        JTextField groupNameField = new JTextField();


        middleAddAnimalPanel.add(groupNameLabel);
        middleAddAnimalPanel.add(groupNameField);



        JButton AddAnimalButtonMiddle = new JButton("Add Animal");
        AddAnimalButtonMiddle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                groupName = groupNameField.getText();
                groupNameField.setEditable(false);
                if (!groupNameField.getText().isEmpty()) {
                        AddAnimalDialog addAnimalDialog = new AddAnimalDialog(selectedCompetitionType, pan);
                        if (addAnimalDialog.getSelectedAnimalType() != null && addAnimalDialog.getSelectedAnimal() != null) {
                            selectedAnimalType = addAnimalDialog.getSelectedAnimalType();
                            selectedAnimal = addAnimalDialog.getSelectedAnimal();
                        }
                        if (selectedAnimal != null) {
                            RelayGroupList.add(addAnimalDialog.getSelectedAnimalObj());
                            animalList.add(addAnimalDialog.getSelectedAnimalObj());
                            numOfCreatedAnimals++;
                            numOfAnimalsInGroup++;
                        } else {
                            JOptionPane.showMessageDialog(AddAnimalButtonMiddle, "Please Select Animal", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                     if (numOfAnimalsInGroup == 4){
                        if (!selectedAnimalType.equals("Terrestrial")){
                            for (Animal animal : RelayGroupList) {
                                animal.setLocation(RelayGroupList.getFirst().getLocation());
                            }
                        }
                        new SetAnimalLocationRelay(RelayGroupList, pan);
                        RelayCompetitionsGroupsList.add(RelayGroupList);
                        backgroundPanel.revalidate();
                        backgroundPanel.repaint();
                        groupName = null;
                        middleAddAnimalDialog.dispose();
                    }
                }
                else{
                    JOptionPane.showMessageDialog(AddAnimalButtonMiddle, "Please Enter Group Name", "Warning", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        JButton finishAddAnimalsButton = new JButton("Finish Add Animals");
        finishAddAnimalsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (RelayGroupList != null && RelayGroupList.size() > 0) {
                    if (!selectedAnimalType.equals("Terrestrial")){
                        for (Animal animal : RelayGroupList) {
                            animal.setLocation(RelayGroupList.getFirst().getLocation());
                        }
                    }
                    new SetAnimalLocationRelay(RelayGroupList, pan);
                    RelayCompetitionsGroupsList.add(RelayGroupList);
                    backgroundPanel.revalidate();
                    backgroundPanel.repaint();
                    groupName = null;
                }
                else{
                    JOptionPane.showMessageDialog(finishAddAnimalsButton, "Bye, No Group List Created", "Error", JOptionPane.ERROR_MESSAGE);
                    middleAddAnimalDialog.dispose();
                }
                middleAddAnimalDialog.dispose();
            }
        });

        middleAddAnimalPanel.add(AddAnimalButtonMiddle);
        middleAddAnimalPanel.add(finishAddAnimalsButton);
        middleAddAnimalDialog.add(middleAddAnimalPanel, BorderLayout.CENTER);
        middleAddAnimalDialog.pack();
        middleAddAnimalDialog.setVisible(true);
    }
    public String getGroupName(){
        return groupName;
    }

    public String getSelectedCompetitionType(){
        return selectedCompetitionType;
    }
}
