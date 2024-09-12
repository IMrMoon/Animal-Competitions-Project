package Graphics;
import Animals.*;
import Mobility.Point;
import Olympics.Medal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


/**
 * The {@code AddAnimalDialog} class is a dialog for adding new animals to the competition panel.
 * It allows the user to select the type and specific animal, input details, and save the animal.
 *
 * <p>Attributes:</p>
 * <ul>
 *     <li>{@code selectedAnimalType} - The type of animal selected.</li>
 *     <li>{@code selectedAnimal} - The specific animal selected.</li>
 *     <li>{@code selectedAnimalObj} - The selected animal object.</li>
 *     <li>{@code terrestrialPoint} - The point for terrestrial animals.</li>
 *     <li>{@code AirOrWaterPoint} - The point for air or water animals.</li>
 * </ul>
 *
 * <p>Methods:</p>
 * <ul>
 *     <li>{@code getSelectedAnimalType()} - Returns the selected animal type.</li>
 *     <li>{@code getSelectedAnimal()} - Returns the selected animal.</li>
 * </ul>
 *
 * <p>Constructor:</p>
 * <ul>
 *     <li>{@code AddAnimalDialog(String selectedCompetitionType, CompetitionPanel pan)} - Constructs the dialog with the specified competition type and panel.</li>
 * </ul>
 */
public class AddAnimalDialog extends JDialog {
    private String selectedAnimalType = null, selectedAnimal = null;
    private static Animal selectedAnimalObj = null;
    private Point terrestrialPoint = new Point(0, 0);
    private Point AirOrWaterPoint = new Point(0,0);
    private String groupName;

    /**
     * Returns the selected animal type.
     *
     * @return the selected animal type.
     */
    public String getSelectedAnimalType() {
        return selectedAnimalType;
    }

    /**
     * Returns the selected animal.
     *
     * @return the selected animal.
     */
    public String getSelectedAnimal() {
        return selectedAnimal;
    }

    public static Animal getSelectedAnimalObjStatic() {
        return selectedAnimalObj;
    }

    public Animal getSelectedAnimalObj() {
        return selectedAnimalObj;
    }

    /**
     * Constructs a new {@code AddAnimalDialog} with the specified competition type and competition panel.
     *
     * @param selectedCompetitionType the selected competition type.
     * @param pan the competition panel.
     */
    public AddAnimalDialog(String selectedCompetitionType, CompetitionPanel pan) {
        groupName = pan.getGroupName();
        JDialog addAnimalDialog = new JDialog((Frame) null, "Add Animal", true);
        addAnimalDialog.setTitle("Add Animal");
        addAnimalDialog.setSize(600, 500);
        addAnimalDialog.setLayout(new BorderLayout());
        addAnimalDialog.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        addAnimalDialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                selectedAnimalType = null;
                selectedAnimal = null;
                System.out.println("Window closed without saving. Values reset to null.");
            }
        });

        JPanel animalAddPanel = new JPanel();
        animalAddPanel.setLayout(new BoxLayout(animalAddPanel, BoxLayout.Y_AXIS));

        JLabel selectAnimalTypeLabel = new JLabel("Select Animal Type:");
        animalAddPanel.add(selectAnimalTypeLabel);

        String[] animalTypes = {"Choose..", "Water", "Air", "Terrestrial"};
        JComboBox<String> animalTypeComboBox = new JComboBox<>(animalTypes);
        animalAddPanel.add(animalTypeComboBox);

        JPanel animalTypePanel = new JPanel(new CardLayout());
        animalAddPanel.add(animalTypePanel);

        // Water Animals Panel
        String[] waterAnimals = {"Dolphin", "Whale", "Alligator"};
        JPanel waterAnimalsPanel = new JPanel();
        waterAnimalsPanel.add(new JLabel("Choose Water animal:"));
        JComboBox<String> waterAnimalTypeComboBox = new JComboBox<>(waterAnimals);
        waterAnimalsPanel.add(waterAnimalTypeComboBox);

        // Air Animals Panel
        String[] airAnimals = {"Eagle", "Pigeon"};
        JPanel airAnimalsPanel = new JPanel();
        airAnimalsPanel.add(new JLabel("Choose Air animal:"));
        JComboBox<String> airAnimalTypeComboBox = new JComboBox<>(airAnimals);
        airAnimalsPanel.add(airAnimalTypeComboBox);

        // Terrestrial Animals Panel
        String[] terrestrialAnimals = {"Dog", "Cat", "Alligator", "Snake"};
        JPanel terrestrialAnimalsPanel = new JPanel();
        terrestrialAnimalsPanel.add(new JLabel("Choose Terrestrial animal:"));
        JComboBox<String> terrestrialAnimalTypeComboBox = new JComboBox<>(terrestrialAnimals);
        terrestrialAnimalsPanel.add(terrestrialAnimalTypeComboBox);

        animalTypePanel.add(waterAnimalsPanel, "Water");
        animalTypePanel.add(airAnimalsPanel, "Air");
        animalTypePanel.add(terrestrialAnimalsPanel, "Terrestrial");

        // Panel to hold specific animal fields
        JPanel specificAnimalPanel = new JPanel();
        specificAnimalPanel.setLayout(new BoxLayout(specificAnimalPanel, BoxLayout.Y_AXIS));
        animalAddPanel.add(specificAnimalPanel);

        // Panel to hold combobox fields
        JPanel comboBoxPanel = new JPanel();
        comboBoxPanel.setLayout(new BoxLayout(comboBoxPanel, BoxLayout.Y_AXIS));
        animalAddPanel.add(comboBoxPanel);

        // Action Listener for animal type selection
        animalTypeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                specificAnimalPanel.removeAll();
                comboBoxPanel.removeAll();
//                selectedAnimal = null;
//                selectedAnimalType = null;
                CardLayout cl = (CardLayout) (animalTypePanel.getLayout());
                selectedAnimalType = (String) animalTypeComboBox.getSelectedItem();
                if (selectedAnimalType != null && !"Choose..".equals(selectedAnimalType)) {
                    cl.show(animalTypePanel, selectedAnimalType);

                    switch (selectedAnimalType) {
                        case "Water":
                            addWaterAnimalFields(specificAnimalPanel);
                            break;
                        case "Air":
                            addAirAnimalFields(specificAnimalPanel);
                            break;
                        case "Terrestrial":
                            addTerrestrialAnimalFields(specificAnimalPanel);
                            break;
                    }
                }
                addAnimalDialog.pack();
            }
        });


        // Action Listener for specific animal selection
        ActionListener animalSelectionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                specificAnimalPanel.removeAll();
                comboBoxPanel.removeAll();
                if (selectedAnimalType.equals("Water")) {
                    addWaterAnimalFields(specificAnimalPanel);
                } else if (selectedAnimalType.equals("Air")) {
                    addAirAnimalFields(specificAnimalPanel);
                } else if (selectedAnimalType.equals("Terrestrial")) {
                    addTerrestrialAnimalFields(specificAnimalPanel);
                }
                JComboBox<String> sourceComboBox = (JComboBox<String>) e.getSource();
                selectedAnimal = (String) sourceComboBox.getSelectedItem();

                if (selectedAnimal == null || "Choose..".equals(selectedAnimal)) {
                    addAnimalDialog.pack();
                    return;
                }

                switch (selectedAnimal) {
                    case "Dolphin":
                        addDolphinFields(comboBoxPanel);
                        break;
                    case "Whale":
                        addWhaleFields(specificAnimalPanel);
                        break;
                    case "Alligator":
                        addAlligatorFields(specificAnimalPanel);
                        break;
                    case "Eagle":
                        addEagleFields(specificAnimalPanel);
                        break;
                    case "Pigeon":
                        addPigeonFields(specificAnimalPanel);
                        break;
                    case "Dog":
                        addDogFields(specificAnimalPanel);
                        break;
                    case "Cat":
                        addCatFields(comboBoxPanel);
                        break;
                    case "Snake":
                        addSnakeFields(comboBoxPanel, specificAnimalPanel);
                        break;
                }

                addAnimalDialog.pack();
            }
        };

        waterAnimalTypeComboBox.addActionListener(animalSelectionListener);
        airAnimalTypeComboBox.addActionListener(animalSelectionListener);
        terrestrialAnimalTypeComboBox.addActionListener(animalSelectionListener);

        JLabel animalNameLabel = new JLabel("Animal Name:");
        JTextField animalNameTextField = new JTextField();
        animalAddPanel.add(animalNameLabel);
        animalAddPanel.add(animalNameTextField);

        JLabel animalGenderLabel = new JLabel("Animal Gender:");
        JComboBox<Animal.gender> animalGenderComboBox = new JComboBox<>(Animal.gender.values());
        animalAddPanel.add(animalGenderLabel);
        animalAddPanel.add(animalGenderComboBox);

        JLabel animalWeightLabel = new JLabel("Animal Weight:");
        JTextField animalWeightTextField = new JTextField();
        animalAddPanel.add(animalWeightLabel);
        animalAddPanel.add(animalWeightTextField);

        JLabel animalSpeedLabel = new JLabel("Animal Speed:");
        JTextField animalSpeedTextField = new JTextField();
        animalAddPanel.add(animalSpeedLabel);
        animalAddPanel.add(animalSpeedTextField);

        JLabel energyPerMeter = new JLabel("Energy Per Meter:");
        JTextField energyPerMeterTextField = new JTextField();
        animalAddPanel.add(energyPerMeter);
        animalAddPanel.add(energyPerMeterTextField);

        JLabel maxEnergy = new JLabel("Max Energy :");
        JTextField maxEnergyTextField = new JTextField();
        animalAddPanel.add(maxEnergy);
        animalAddPanel.add(maxEnergyTextField);


        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validateInputs(specificAnimalPanel, animalNameTextField, animalWeightTextField)) {
                    selectedAnimalType = (String) animalTypeComboBox.getSelectedItem();
                    if (selectedAnimalType == null || "Choose..".equals(selectedAnimalType) || selectedAnimal == null) {
                        JOptionPane.showMessageDialog(addAnimalDialog, "Please select a valid animal type and animal.", "Info", JOptionPane.INFORMATION_MESSAGE);
                        return;
                    }
                    if (!selectedAnimalType.equals(selectedCompetitionType)) {
                        selectedAnimalType = null;
                        selectedAnimal = null;
                        JOptionPane.showMessageDialog(addAnimalDialog, "Selected Animal Type: " + selectedAnimalType + "\nDoes Not Match Selected Competition Type: " + selectedCompetitionType, "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    // Gather input values
                    String animalName = animalNameTextField.getText();
                    Animal.gender animalGender = (Animal.gender) animalGenderComboBox.getSelectedItem();
                    double animalWeight = Double.parseDouble(animalWeightTextField.getText());
                    double animalSpeed = Double.parseDouble(animalSpeedTextField.getText());
                    double length = 0, wingspan = 0, waterDept = 0, EagleAltitudeFlight = 0;
                    String CatCastrated = null, pigeonFamily = null, WhaleFoodType = null, dogBreed = null, AlligatorArea = null;
                    int numberOfLegs = 0;
                    Dolphin.WaterType DolphinWaterType = null;
                    Snake.poisonous poisonous = null;
                    int waterRout = 0, airRout = 0;
                    int energyPerMeter = Integer.parseInt(energyPerMeterTextField.getText());
                    int maxEnergy = Integer.parseInt(maxEnergyTextField.getText());
                    if (groupName == null || "".equals(groupName)) {
                        groupName = animalName;
                    }


                    for (Component comp : specificAnimalPanel.getComponents()) {
                        if (comp instanceof JPanel) {
                            JPanel panel = (JPanel) comp;
                            JLabel label = (JLabel) panel.getComponent(0);
                            JTextField textField = (JTextField) panel.getComponent(1);
                            String labelText = label.getText();
                            String text = textField.getText();

                            switch (labelText) {
                                case "Water Animal Dept:":
                                    waterDept = Double.parseDouble(text);
                                    break;
                                case "Wingspan:":
                                    wingspan = Double.parseDouble(text);
                                    break;
                                case "Number of Legs:":
                                    numberOfLegs = Integer.parseInt(text);
                                    break;
                                case "Food Type:":
                                    WhaleFoodType = text;
                                    break;
                                case "Area of Living:":
                                    AlligatorArea = text;
                                    break;
                                case "Altitude of Flight:":
                                    EagleAltitudeFlight = Double.parseDouble(text);
                                    break;
                                case "Family:":
                                    pigeonFamily = text;
                                    break;
                                case "Breed:":
                                    dogBreed = text;
                                    break;
                                case "Length:":
                                    length = Double.parseDouble(text);
                                    break;
                                case "Choose Rout:":
                                    double backgroundWidth = pan.getBackgroundImg().getWidth();
                                    double backgroundHeight = pan.getBackgroundImg().getHeight();
                                    if (selectedAnimalType.equals("Water")) {
                                        waterRout = Integer.parseInt(text);
                                        switch (waterRout){
                                            case 1: {
                                                AirOrWaterPoint = new Point((int)(backgroundWidth/12), (int)(backgroundHeight/12 + backgroundHeight / 16));
                                                break;
                                            }
                                            case 2: {
                                                AirOrWaterPoint = new Point((int)(backgroundWidth/12), (int)(backgroundHeight/4 + backgroundHeight / 10));
                                                break;
                                            }
                                            case 3: {
                                                AirOrWaterPoint = new Point((int)(backgroundWidth/12), (int)(backgroundHeight/2+backgroundHeight/15));
                                                break;
                                            }
                                            case 4: {
                                                AirOrWaterPoint = new Point((int)(backgroundWidth/12), (int)(backgroundHeight/3+backgroundHeight/3+backgroundHeight/8));
                                                break;
                                            }
                                            default: {
                                                AirOrWaterPoint = null;
                                                break;
                                            }
                                        }
                                    } else if (selectedAnimalType.equals("Air")) {
                                        airRout = Integer.parseInt(text);
                                        switch (airRout) {
                                            case 1: {
                                                AirOrWaterPoint = new Point((0),(0));
                                                break;
                                            }
                                            case 2: {
                                                AirOrWaterPoint = new Point(0, (int) (backgroundHeight/8+backgroundHeight/9));
                                                break;
                                            }
                                            case 3: {
                                                AirOrWaterPoint = new Point(0, (int) (backgroundHeight/3+backgroundHeight/14+backgroundHeight/15));
                                                break;
                                            }
                                            case 4: {
                                                AirOrWaterPoint = new Point(0, (int) (backgroundHeight/2+backgroundHeight/11+backgroundHeight/10));
                                                break;
                                            }
                                            case 5 :{
                                                AirOrWaterPoint = new Point(0, (int) (backgroundHeight/2+backgroundHeight/3+backgroundHeight/13));
                                                break;
                                            }

                                            default: {
                                                AirOrWaterPoint = null;
                                                break;
                                            }
                                        }
                                    }
                                    break;
                            }
                        }
                    }

                    for (Component comp : comboBoxPanel.getComponents()) {
                        if (comp instanceof JPanel) {
                            JPanel panel = (JPanel) comp;
                            JLabel label = (JLabel) panel.getComponent(0);
                            JComboBox comboBox = (JComboBox) panel.getComponent(1);
                            String labelText = label.getText();

                            switch (labelText) {
                                case "Water Type:":
                                    DolphinWaterType = (Dolphin.WaterType) comboBox.getSelectedItem();
                                    break;
                                case "Poisonous Level:":
                                    poisonous = (Snake.poisonous) comboBox.getSelectedItem();
                                    break;
                                case "Castrated:":
                                    CatCastrated = (String) comboBox.getSelectedItem();
                                    break;
                            }
                        }
                    }

                    //create the appropriate animal object using the collected data
                    switch (selectedAnimal) {
                        case "Dolphin":
                            selectedAnimalObj = new Dolphin(animalName, animalGender, animalWeight, animalSpeed, new Medal[]{}, AirOrWaterPoint, waterDept, pan, DolphinWaterType, selectedAnimal, groupName, maxEnergy, energyPerMeter);
                            break;
                        case "Whale":
                            selectedAnimalObj = new Whale(animalName, animalGender, animalWeight, animalSpeed, new Medal[]{}, AirOrWaterPoint, waterDept, pan, WhaleFoodType, selectedAnimal, groupName, maxEnergy, energyPerMeter);
                            break;
                        case "Alligator":
                            if (selectedAnimalType.equals("Water")) {
                                selectedAnimalObj = new Alligator(animalName, animalGender, animalWeight, animalSpeed, new Medal[]{}, AirOrWaterPoint, waterDept, pan, AlligatorArea, selectedAnimal, groupName, maxEnergy, energyPerMeter);
                            }
                            if (selectedAnimalType.equals("Terrestrial")) {
                                selectedAnimalObj = new Alligator(animalName, animalGender, animalWeight, animalSpeed, new Medal[]{}, terrestrialPoint, 0, pan, AlligatorArea, selectedAnimal, groupName, maxEnergy, energyPerMeter);
                            }
                            break;
                        case "Eagle":
                            selectedAnimalObj = new Eagle(animalName, animalGender, animalWeight, animalSpeed, new Medal[]{}, AirOrWaterPoint, wingspan, pan, EagleAltitudeFlight, selectedAnimal, groupName, maxEnergy, energyPerMeter);
                            break;
                        case "Pigeon":
                            selectedAnimalObj = new Pigeon(animalName, animalGender, animalWeight, animalSpeed, new Medal[]{}, AirOrWaterPoint, wingspan, pan, pigeonFamily, selectedAnimal, groupName, maxEnergy, energyPerMeter);
                            break;
                        case "Dog":

                            selectedAnimalObj = new Dog(animalName, animalGender, animalWeight, animalSpeed, new Medal[]{}, terrestrialPoint, numberOfLegs, pan, dogBreed, selectedAnimal, groupName, maxEnergy, energyPerMeter);
                            break;
                        case "Cat": {
                            boolean ifCastrated = CatCastrated.equals("Yes");
                            selectedAnimalObj = new Cat(animalName, animalGender, animalWeight, animalSpeed, new Medal[]{}, terrestrialPoint, numberOfLegs, pan, ifCastrated, selectedAnimal, groupName, maxEnergy, energyPerMeter);
                            break;
                        }
                        case "Snake":
                            selectedAnimalObj = new Snake(animalName, animalGender, animalWeight, animalSpeed, new Medal[]{}, terrestrialPoint, pan, poisonous, length, selectedAnimal, groupName, maxEnergy, energyPerMeter);
                            break;
                    }

                    JOptionPane.showMessageDialog(addAnimalDialog, "Selected Animal Type: " + selectedAnimalType + "\nMatches Selected Competition Type: " + selectedCompetitionType + "\nSelected Animal: " + selectedAnimal, "Success", JOptionPane.INFORMATION_MESSAGE);
                    addAnimalDialog.dispose();
                }
            }
        });

        animalAddPanel.add(Box.createVerticalStrut(10)); // Add some space before the save button
        animalAddPanel.add(saveButton);

        addAnimalDialog.add(animalAddPanel, BorderLayout.CENTER);
        addAnimalDialog.setLocationRelativeTo(this);
        addAnimalDialog.setVisible(true);
    }

    private void addWaterAnimalFields(JPanel panel) {
        addField(panel, "Water Animal Dept:");
        addField(panel, "Choose Rout:");
    }

    private void addAirAnimalFields(JPanel panel) {
        addField(panel, "Wingspan:");
        addField(panel, "Choose Rout:");
    }

    private void addTerrestrialAnimalFields(JPanel panel) {
        addField(panel, "Number of Legs:");
    }

    private void addDolphinFields(JPanel panel) {
        addComboBox(panel, "Water Type:", Dolphin.WaterType.values());
    }

    private void addWhaleFields(JPanel panel) {
        addField(panel, "Food Type:");
    }

    private void addAlligatorFields(JPanel panel) {
        addField(panel, "Area of Living:");
    }

    private void addEagleFields(JPanel panel) {
        addField(panel, "Altitude of Flight:");
    }

    private void addPigeonFields(JPanel panel) {
        addField(panel, "Family:");
    }

    private void addDogFields(JPanel panel) {
        addField(panel, "Breed:");
    }

    private void addCatFields(JPanel panel) {
        addComboBox(panel, "Castrated:", new String[]{"Yes", "No"});
    }

    private void addSnakeFields(JPanel comboBoxPanel, JPanel fieldPanel) {
        addComboBox(comboBoxPanel, "Poisonous Level:", Snake.poisonous.values());
        addField(fieldPanel, "Length:");
    }

    private void addField(JPanel panel, String label) {
        JPanel fieldPanel = new JPanel(new BorderLayout());
        JLabel jLabel = new JLabel(label);
        JTextField jTextField = new JTextField();
        fieldPanel.add(jLabel, BorderLayout.WEST);
        fieldPanel.add(jTextField, BorderLayout.CENTER);
        panel.add(fieldPanel);
    }

    private <T> void addComboBox(JPanel panel, String label, T[] items) {
        JPanel fieldPanel = new JPanel(new BorderLayout());
        JLabel jLabel = new JLabel(label);
        JComboBox<T> jComboBox = new JComboBox<>(items);
        fieldPanel.add(jLabel, BorderLayout.WEST);
        fieldPanel.add(jComboBox, BorderLayout.CENTER);
        panel.add(fieldPanel);
    }

    private boolean validateInputs(JPanel specificAnimalPanel, JTextField animalNameTextField, JTextField animalWeightTextField) {
        boolean isValid = true;

        // Validate animal name
        if (animalNameTextField.getText().isEmpty()) {
            animalNameTextField.setBackground(Color.PINK);
            isValid = false;
        } else {
            animalNameTextField.setBackground(Color.WHITE);
        }

        // Validate animal weight
        try {
            double weight = Double.parseDouble(animalWeightTextField.getText());
            if (weight <= 0) {
                animalWeightTextField.setBackground(Color.PINK);
                isValid = false;
            } else {
                animalWeightTextField.setBackground(Color.WHITE);
            }
        } catch (NumberFormatException e) {
            animalWeightTextField.setBackground(Color.PINK);
            isValid = false;
        }

        // Validate fields in specificAnimalPanel
        for (Component comp : specificAnimalPanel.getComponents()) {
            if (comp instanceof JPanel) {
                JPanel panel = (JPanel) comp;
                JLabel label = (JLabel) panel.getComponent(0);

                Component secondComp = panel.getComponent(1);
                if (secondComp instanceof JTextField) {
                    JTextField textField = (JTextField) secondComp;
                    String text = textField.getText();
                    String labelText = label.getText();

                    // Check if text field is empty
                    if (text.isEmpty()) {
                        textField.setBackground(Color.PINK);
                        isValid = false;
                        continue;
                    } else {
                        textField.setBackground(Color.WHITE);
                    }

                    // Validate specific fields based on their label
                    try {
                        switch (labelText) {
                            case "Water Animal Dept:":
                            case "Wingspan:":
                            case "Altitude of Flight:":
                            case "Animal Speed:":
                            case "Length:":
                                double doubleValue = Double.parseDouble(text);
                                if (doubleValue <= 0) {
                                    textField.setBackground(Color.PINK);
                                    isValid = false;
                                }
                                break;

                            case "Number of Legs:":
                                int intValue = Integer.parseInt(text);

                                if (selectedAnimal.equals("Snake")) {
                                    if (intValue == 0) {
                                        textField.setBackground(Color.WHITE);
                                        isValid = true;
                                    } else {
                                        textField.setBackground(Color.PINK);
                                        isValid = false;
                                    }
                                } else {
                                    if (intValue > 1) {
                                        textField.setBackground(Color.WHITE);
                                        isValid = true;
                                    } else {
                                        textField.setBackground(Color.PINK);
                                        isValid = false;
                                    }
                                }
                                break;

                            case "Choose Rout:":
                                int routeValue = Integer.parseInt(text);
                                if ((selectedAnimalType.equals("Water") && (routeValue < 1 || routeValue > 4)) ||
                                        (selectedAnimalType.equals("Air") && (routeValue < 1 || routeValue > 5))) {
                                textField.setBackground(Color.PINK);
                                isValid = false;
                            }
                            break;

                            case "Breed:":
                                if (text.trim().isEmpty()) {
                                    textField.setBackground(Color.PINK);
                                    isValid = false;
                                }
                                break;
                        }
                    } catch (NumberFormatException e) {
                        if (!labelText.equals("Breed:")) {
                            textField.setBackground(Color.PINK);
                            isValid = false;
                        }
                    }
                }
            }
        }

        return isValid;
    }

}
