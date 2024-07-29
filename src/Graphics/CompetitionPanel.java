package Graphics;

import Animals.Animal;
import Mobility.Point;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;


/**
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
    private static String selectedCompetitionType = null;
    private static String selectedAnimalType;
    private static String selectedAnimal;
    private JLabel animalLabel;
    private JTable infoTable;
    private JScrollPane infoScroller;
    private JDialog infoDialog;
    String[] columnNames = {"Animal", "Category", "Type", "Speed", "energyAmount", "Distance", "Energy consumption"};
    int EnergyConsumption = 0;
    private CompetitionPanel pan;
    private BufferedImage backgroundImg;
    private JPanel backgroundPanel;
    int preferredWidth = 1024;
    int preferredHeight = 768;
    private Timer timer;

    /**
     * Returns the list of animals.
     *
     * @return the list of animals.
     */
    public List<Animal> getAnimalList() {
        return animalList;
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
                        animal.drawObject(g2d);
//                        animal.setPosition(new Point((int)(backgroundImg.getWidth()/8.5), (int)(backgroundImg.getHeight()/8.5)));

//                        animal.move();
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
            }
        });

        JButton AddAnimalButton = new JButton("Add Animal");
        AddAnimalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedCompetitionType != null) {
                    AddAnimalDialog addAnimalDialog = new AddAnimalDialog(selectedCompetitionType, pan);
                    if (addAnimalDialog.getSelectedAnimalType() != null && addAnimalDialog.getSelectedAnimal() != null) {
                        selectedAnimalType = addAnimalDialog.getSelectedAnimalType();
                        selectedAnimal = addAnimalDialog.getSelectedAnimal();
                    }
                    if (selectedAnimal != null) {
                        animalList.add(AddAnimalDialog.selectedAnimalObj);
                        backgroundPanel.revalidate();
                        backgroundPanel.repaint();
                        numOfCreatedAnimals++;
                    } else {
                        JOptionPane.showMessageDialog(AddAnimalButton, "Please Select Competition Type", "Error", JOptionPane.ERROR_MESSAGE);
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
                if (AddAnimalDialog.selectedAnimalObj != null) {
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
                        infoDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                        infoDialog.setLocationRelativeTo(null);

                        Object[][] animalsData = convertListTo2DArray(animalList);
                        infoTable = new JTable(animalsData, columnNames);
                        infoScroller = new JScrollPane(infoTable);
                        infoDialog.add(infoScroller);
                    } else {
                        updateTable();
                    }
                    infoDialog.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(InfoButton, "Please Add Animals, Empty Table", "Error", JOptionPane.ERROR_MESSAGE);
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
                timer = new Timer(100, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        for (Animal animal : animalList) {
                            if (animal != null) {
                                animal.move();
                            }
                        }
                        backgroundPanel.repaint();
                    }
                });
                timer.start();
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
        Object[][] data = new Object[animals.size()][7];
        for (int i = 0; i < animals.size(); i++) {
            Animal animal = animals.get(i);
            data[i][0] = animal.getName();
            data[i][1] = animal.getAnimalType();
            data[i][2] = animal.getSpecificAnimal();
            data[i][3] = animal.getSpeed();
            data[i][4] = animal.getEnergyLevel();
            data[i][5] = animal.getAnimalDistance();
            data[i][6] = animal.getEnergyConsumption();
        }
        return data;
    }

    /**
     * Updates the information table with the latest animal data.
     */
    private void updateTable() {
        if (infoTable != null) {
            Object[][] animalsData = convertListTo2DArray(animalList);
            infoTable.setModel(new javax.swing.table.DefaultTableModel(animalsData, columnNames));
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
            names[i] = animals.get(i - 1).getName();
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
            if (animals.get(i).getName().equals(animalName)) {
                return animals.get(i);
            }
        }
        return null;
    }
}
