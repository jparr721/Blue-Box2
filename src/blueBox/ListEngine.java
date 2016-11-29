package blueBox;

/**
 * Created by Jarred on 11/7/16.
 */

import javax.swing.*;
import java.io.*;
import java.text.DateFormat;
import java.util.*;
import javax.swing.table.AbstractTableModel;

public class ListEngine extends AbstractTableModel {

    private LinkedList<DVD> listDVDs;

    private String[] columns;

    public ListEngine() {
        super();
        listDVDs = new LinkedList<DVD>();
        columns = new String[] {"Name", "Title", "Console", "Rented On", "Due Back"};
    }

    public DVD remove(int i) {
        DVD unit = listDVDs.remove(i);
        fireTableRowsDeleted(listDVDs.size(), listDVDs.size());
        return unit;
    }

    public void add (DVD a) {
        listDVDs.add(a);
        fireTableRowsInserted(listDVDs.size() - 1, listDVDs.size() - 1);
    }

    public DVD get (int i) {
        return listDVDs.get(i);
    }

    public Object getElementAt(int row, int column) {
        return null;
    }

    public int getSize(){
        return listDVDs.size();
    }


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
            listDVDs = (LinkedList<DVD>) is.readObject();
            fireTableRowsInserted(listDVDs.size() -1, listDVDs.size() -1);
            is.close();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null,"Error in loading db");
        }
    }


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

    public void loadFromText(String filename) {}

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

    @Override
    public int getRowCount() {
        return listDVDs.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

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

