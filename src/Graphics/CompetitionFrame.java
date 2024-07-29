package Graphics;
import Animals.Animal;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import javax.imageio.ImageIO;
import javax.swing.*;


/**
 * The {@code CompetitionFrame} class represents the main window for the animal competition.
 * It sets up the frame, menu bar, and the main competition panel where animals are displayed and managed.
 *
 * <p>Attributes:</p>
 * <ul>
 *     <li>{@code backgroundImg} - The background image of the competition.</li>
 *     <li>{@code competitionPanel} - The panel where the competition and animals are displayed.</li>
 * </ul>
 *
 * <p>Methods:</p>
 * <ul>
 *     <li>{@code main(String[] args)} - The main method to run the application.</li>
 * </ul>
 *
 * <p>Constructor:</p>
 * <ul>
 *     <li>{@code CompetitionFrame()} - Constructs the frame and sets up the GUI components.</li>
 * </ul>
 */
public class CompetitionFrame extends JFrame  {
   public BufferedImage backgroundImg;
   private CompetitionPanel competitionPanel;

    /**
     * Constructs a new {@code CompetitionFrame} and sets up the GUI components.
     */
   public CompetitionFrame() {
       super("Competition Frame");
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setSize(500, 500);


       try {
           backgroundImg = ImageIO.read(new File("graphics2/competitionBackground.png"));
       } catch (IOException e) {
           System.out.println("Image not found");
       }

       competitionPanel = new CompetitionPanel(backgroundImg);


       JMenuBar menuBar = new JMenuBar();
       JMenu FileMenu = new JMenu("File");
       JMenu HelpMenu = new JMenu("Help");
       JMenuItem exitItem = new JMenuItem("Exit");
       JMenuItem helpItem = new JMenuItem("Help");

       FileMenu.add(exitItem);
       HelpMenu.add(helpItem);
       menuBar.add(FileMenu);
       menuBar.add(HelpMenu);
       setJMenuBar(menuBar);

       exitItem.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               System.exit(0);
           }
       });

       helpItem.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               JOptionPane.showMessageDialog(competitionPanel, "Home Work 2\nGUI");
           }
       });

       getContentPane().setLayout(new BorderLayout());
       getContentPane().add(competitionPanel, BorderLayout.CENTER);


       setVisible(true);

   }


    /**
     * The main method to run the application.
     *
     * @param args the command line arguments.
     */
   public static void main(String[] args) {
       new CompetitionFrame();

   }
}
