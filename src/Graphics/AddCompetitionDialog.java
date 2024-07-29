package Graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The {@code AddCompetitionDialog} class provides a dialog for selecting the type of competition.
 * It allows the user to choose from Water, Air, or Terrestrial competition types.
 *
 * <p>Attributes:</p>
 * <ul>
 *     <li>{@code selectedCompetitionType} - The type of competition selected by the user.</li>
 * </ul>
 *
 * <p>Methods:</p>
 * <ul>
 *     <li>{@code getSelectedCompetitionType()} - Returns the selected competition type.</li>
 * </ul>
 *
 * <p>Constructor:</p>
 * <ul>
 *     <li>{@code AddCompetitionDialog()} - Constructs the dialog and sets up the GUI components.</li>
 * </ul>
 */
public class AddCompetitionDialog {
    private String selectedCompetitionType = null;

    /**
     * Returns the selected competition type.
     *
     * @return the selected competition type.
     */
    public String getSelectedCompetitionType() {
        return selectedCompetitionType;
    }

    /**
     * Constructs a new {@code AddCompetitionDialog} and sets up the GUI components.
     */
    public AddCompetitionDialog() {
        JDialog CompetitionDialog = new JDialog((Frame) null, "Add Competition", true);
        CompetitionDialog.setTitle("Add Competition");
        CompetitionDialog.setSize(300,200);
        CompetitionDialog.setLocationRelativeTo(null);
        CompetitionDialog.setLayout(new BorderLayout());

        JPanel competitionAddPanel = new JPanel(new GridLayout(2,1));

        String[] CompetitionTypes = {"Choose..", "Water", "Air", "Terrestrial"};
        JComboBox<String> competitionTypeComboBox = new JComboBox<>(CompetitionTypes);
        competitionTypeComboBox.setSelectedIndex(0);

        competitionTypeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        competitionAddPanel.add(new JLabel("Choose type of Competition"));
        competitionAddPanel.add(competitionTypeComboBox);
        competitionAddPanel.setSize(100,20);
        competitionAddPanel.setLayout(new FlowLayout());

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                selectedCompetitionType = (String)competitionTypeComboBox.getSelectedItem();
                if (selectedCompetitionType.equals("Choose..")){
                    JOptionPane.showMessageDialog(CompetitionDialog, "Choose a Competition Type", "WARNING", JOptionPane.WARNING_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(CompetitionDialog, "Selected competition type: " + selectedCompetitionType, "Success", JOptionPane.INFORMATION_MESSAGE);
                    CompetitionDialog.dispose();
                }
            }
        });

        CompetitionDialog.add(competitionAddPanel);
        competitionAddPanel.add(saveButton);

        CompetitionDialog.setLocationRelativeTo(null);
        CompetitionDialog.setVisible(true);
    }
}