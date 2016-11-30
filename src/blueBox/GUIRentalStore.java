package blueBox;

/**
 * Created by Jarred on 11/24/16.
 */

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.GregorianCalendar;
import javax.swing.table.TableColumn;

public class GUIRentalStore implements ActionListener {

    /** JFrame object for adding things to the GUI **/
    private JFrame frame;

    /** JMenuBar and JMenu declarations **/
    private JMenuBar menus;
    private JMenu fileMenu;
    private JMenu actionMenu;

    /** File Menu Items **/
    private JMenuItem openSerItem;
    private JMenuItem exitItem;
    private JMenuItem saveSerItem;
    private JMenuItem openTextItem;
    private JMenuItem saveTextItem;

    /** Actions Menu **/
    private JMenuItem rentDvdItem;
    private JMenuItem rentGameItem;
    private JMenuItem returnItem;

    /** JTable object **/
    private JTable table;

    /** List Engine Object **/
    private ListEngine dList;

    /***********************************************************
     * Default constructor to initialize instance variables
     **********************************************************/
    public GUIRentalStore() {

        frame = new JFrame();

        fileMenu = new JMenu("File");
        openSerItem = new JMenuItem("Open Serial...");
        saveSerItem = new JMenuItem("Save Serial...");
        exitItem = new JMenuItem("Exit!");
        openTextItem = new JMenuItem("Open Text...");
        saveTextItem = new JMenuItem("Save Text...");
        actionMenu = new JMenu("Action");
        rentDvdItem = new JMenuItem("Rent DVD");
        rentGameItem = new JMenuItem("Rent Game");
        returnItem = new JMenuItem("Return");

        dList = new ListEngine();

        menus = new JMenuBar();

        table = new JTable(dList);

    }

    /***********************************************************
     * Method to initialize menu objects before the GUI launches
     **********************************************************/
    public void init() {

        fileMenu.add(openSerItem);
        fileMenu.add(saveSerItem);
        fileMenu.addSeparator();
        fileMenu.add(openTextItem);
        fileMenu.add(saveTextItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);

        openSerItem.addActionListener(this);
        exitItem.addActionListener(this);
        saveSerItem.addActionListener(this);
        openTextItem.addActionListener(this);
        saveTextItem.addActionListener(this);



        actionMenu.add(rentDvdItem);
        actionMenu.add(rentGameItem);
        actionMenu.addSeparator();
        actionMenu.add(returnItem);
        actionMenu.addSeparator();

        rentDvdItem.addActionListener(this);
        rentGameItem.addActionListener(this);
        returnItem.addActionListener(this);



        menus.add(fileMenu);
        menus.add(actionMenu);


        frame.setJMenuBar(menus);
        frame.add(new JScrollPane(table));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(800, 400));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        frame.setSize(800, 400);

    }

    /***********************************************************
     * Main method to launch the GUI
     * @param args Method accepts String arguments
     **********************************************************/
    public static void main(String[] args) {
        GUIRentalStore g = new GUIRentalStore();
        g.init();
    }

    /***********************************************************
     * Read action events based on selection and perform
     * the necessary actions
     * @param e reads the event
     **********************************************************/
    public void actionPerformed(ActionEvent e) {

        JComponent comp = (JComponent) e.getSource();

        //Exit GUI
        if (exitItem == comp)
            System.exit(0);

        //Open previous saves
        if (openSerItem == comp || openTextItem == comp) {
            JFileChooser chooser = new JFileChooser();
            int status = chooser.showOpenDialog(null);
            if (status == JFileChooser.APPROVE_OPTION) {
                String filename = chooser.getSelectedFile().getAbsolutePath();
                if (openSerItem == comp)
                    dList.loadDatabase(filename);
                if (openTextItem == e.getSource())
                    dList.loadFromText(filename);
            }
        }

        //Save state
        if (saveSerItem == comp || saveTextItem == comp) {
            JFileChooser chooser = new JFileChooser();
            int status = chooser.showSaveDialog(null);
            if (status == JFileChooser.APPROVE_OPTION) {
                String filename = chooser.getSelectedFile().getAbsolutePath();
                if (saveSerItem == e.getSource())
                    dList.saveDatabase(filename);
                if (saveTextItem == e.getSource())
                    dList.saveAsText(filename);
            }
        }

        //Rent DVD
        if (rentDvdItem == comp) {
            DVD dvd = new DVD();
            DialogRentDvd x = new DialogRentDvd(frame, dvd);
            if (x.closeOK())
                dList.add(dvd);
        }

        //Rent Game
        if (rentGameItem == comp) {
            Game game = new Game();
            DialogRentGame x = new DialogRentGame(frame, game);
            if (x.closeOK())
                dList.add(game);
        }

        //Return Game/DVD
        if (returnItem == e.getSource()) {
            int index = table.getSelectedRow();
            if (index != -1) {
                GregorianCalendar dat = new GregorianCalendar();

                DVD unit = dList.remove(index);
                JOptionPane.showMessageDialog(null, "Thanks " + unit.getNameOfRenter() +
                        "\n for returning " + unit.getTitle() + ", you owe: " + unit.getCost(dat) +
                        " dollars");


            }
        }
    }
}