package blueBox.GUI;

/**
 * Created by Jarred on 11/7/16.
 */
import blueBox.DVD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class DialogRentGame  extends JDialog implements ActionListener {

    private JTextField titleTxt;
    private JTextField renterTxt;
    private JTextField rentedOnTxt;
    private JTextField DueBackTxt;
    private JComboBox playerJbox;

    private JButton okButton;
    private JButton cancelButton;
    private boolean closeStatus;

    private DVD unit;

    /*********************************************************
     Instantiate a Custom Dialog as 'modal' and wait for the
     user to provide data and click on a button.

     @param parent reference to the JFrame application
     @param d an instantiated object to be filled with data
     *********************************************************/

    public DialogRentGame(JFrame parent, DVD d) {
        // call parent and create a 'modal' dialog
        super(parent, true);

        setTitle("Rent a Game:");
        closeStatus = false;
        setSize(400,200);

        unit = d;
        // prevent user from closing window
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        JPanel textPanel = new JPanel();
        textPanel.setLayout(new GridLayout(6, 2));

        textPanel.add(new JLabel("Your Name: "));
        renterTxt = new JTextField();
    }

    /**************************************************************
     Respond to either button clicks
     @param e the action event that was just fired
     **************************************************************/
    public void actionPerformed(ActionEvent e) {

        JButton button = (JButton) e.getSource();

        // if OK clicked the fill the object
        if (button == okButton) {
            // save the information in the object
            closeStatus = true;

            SimpleDateFormat df = new SimpleDateFormat("MM/dd/yyyy");
        }
    }

    /**************************************************************
     Return a String to let the caller know which button
     was clicked

     @return an int representing the option OK or CANCEL
     **************************************************************/
    public boolean closeOK(){
        return closeStatus;
    }

}
