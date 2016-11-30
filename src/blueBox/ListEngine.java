package blueBox;

/**
 * Created by Jarred on 11/7/16.
 */

import javax.swing.*;
import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.util.*;
import javax.swing.table.AbstractTableModel;

public class ListEngine extends AbstractTableModel {

    private MyLinkedList<DVD> listDVDs;

    private String[] columns;

    private String line;

    DVD unit;

    /************************************************************
     * Default constructor to initialize instance variables
     ***********************************************************/
    public ListEngine() {
        super();
        unit = null;
        listDVDs = new MyLinkedList<DVD>();
        columns = new String[] {"Name", "Title", "Console", "Rented On", "Due Back"};
        line = "";
    }

    /************************************************************
     * Remove DVD type from the linked list and from the Table
     * @param i Specifies the index
     * @return
     ***********************************************************/
    public DVD remove(int i) {
        unit = listDVDs.remove(i);
        fireTableRowsDeleted(listDVDs.size(), listDVDs.size());
        return unit;
    }

    /*********************************************************
     * Add DVD object to the listDVDs linked list
     * @param a
     ********************************************************/
    public void add (DVD a) {
        listDVDs.add(a);
        fireTableRowsInserted(listDVDs.size() - 1, listDVDs.size() - 1);
    }

    /********************************************************
     * Gets the item of the listDVDs object based on location
     * specified by i
     * @param i Designates where to look
     * @return The entry at point i
     ******************************************************/
    public DVD get (int i) {
        return listDVDs.get(i);
    }

    /*******************************************************
     * Get the size of the listDVDs object
     * @return number representative of the number of entries
     ******************************************************/
    public int size(){
        return listDVDs.size();
    }

    /******************************************************
     * Saves (serializes) the Account objects from a specified
     * file.
     *
     * @param filename name of the file to save to
     ******************************************************/
    public void saveDatabase(String filename) {

        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream os = new ObjectOutputStream(fos);
            os.writeObject(listDVDs);
            os.close();
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null,"Error in saving db");

        }
    }

    /*******************************************************************
     * Loads (deserializes) the Account objects from the specified file.
     *
     * @param filename name of the file to load from.
     *******************************************************************/
    public void loadDatabase(String filename) {
        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream is = new ObjectInputStream(fis);
            listDVDs = (MyLinkedList<DVD>) is.readObject();
            fireTableRowsInserted(listDVDs.size() -1, listDVDs.size() -1);
            is.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Error in loading db");
        }
    }

    /*************************************************
     * Saves the entries as text, can be then loaded
     * back into the GUI later.
     *
     * @param filename stores the file name
     * @return true or false
     ************************************************/
    public boolean saveAsText(String filename) {
        if (filename.equals("")) {
            return false;
        }

        try {
            PrintWriter out = new PrintWriter(new BufferedWriter(
                    new FileWriter(filename)));
            out.println(listDVDs.size());
            for (int i = 0; i < listDVDs.size(); i++) {
                DVD dvdUnit = listDVDs.get(i);
                out.println(dvdUnit.getClass().getName());
                out.println(DateFormat.getDateInstance(DateFormat.SHORT)
                        .format(dvdUnit.getRentedOn().getTime()));
                out.println(DateFormat.getDateInstance(DateFormat.SHORT)
                        .format(dvdUnit.getDueBack().getTime()));
                out.println(dvdUnit.getNameOfRenter());
                out.println(dvdUnit.getTitle());

                if (dvdUnit instanceof Game)
                    out.println(((Game)dvdUnit).getPlayer());

            }
            out.close();
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    public void loadFromText(String filename) {
        DVD unit;
    }

    /*************************************************
     * Overriden method that changes the names of the
     * columns from their usual "A, B, C, D" etc. name
     *
     * @param columnIndex gets the index of the column
     *                    and changes the name to what
     *                    is stored within the array.
     * @return column names
     ************************************************/
    @Override
    public String getColumnName(int columnIndex){ return columns[columnIndex];}

    /*************************************************
     * Return the number of rows in the GUI, which is based
     * on the number of entries in the listDVDs object
     *
     * @return listDVDs.size
     ************************************************/
    @Override
    public int getRowCount() {
        return listDVDs.size();
    }

    /***********************************************
     * This is a static amount because there are only
     * five columns
     *
     * @return 5
     ***********************************************/
    @Override
    public int getColumnCount() {
        return 5;
    }

    /***********************************************
     * Inherited method that gets the value at a specified
     * index for the colunn and row. The column choice
     * is put into a switch statement which does what it
     * needs to based on the value of columnIndex
     *
     * @param rowIndex
     * @param columnIndex
     * @return data added to the DVD constructor, or null
     **********************************************/
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        DVD unit = listDVDs.get(rowIndex);

        switch(columnIndex){

            case 0:
                return unit.getNameOfRenter();
            case 1:
                return unit.getTitle();
            case 2:
                if (unit instanceof Game) {
                    return ((Game) unit).getPlayer();
                } else {
                    return "Movie";
                }
            case 3:
                return DateFormat.getDateInstance(DateFormat.SHORT)
                        .format(unit.getRentedOn().getTime());
            case 4:
                return DateFormat.getDateInstance(DateFormat.SHORT)
                        .format(unit.getDueBack().getTime());
            default:
                return null;
        }
    }
}

