package ec.edu.espe.evsustore.view;

import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Joan Cobeña, KillChain, DCCO-ESPE
 */
public class SearchBarListener implements DocumentListener {
    
    JTable tableToFilter;
    JTextField textBar;

    public SearchBarListener(JTable tableToFilter, JTextField textBar) {
        this.tableToFilter = tableToFilter;
        this.textBar = textBar;
       
    }
    
    @Override
    public void insertUpdate(DocumentEvent e) {
        sortTable(tableToFilter , textBar.getText());
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        sortTable(tableToFilter , textBar.getText());
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        sortTable(tableToFilter , textBar.getText());
    }
    
    public static void sortTable(JTable table, String text) {
        
        ArrayList<RowFilter<Object,Object>> filters = new ArrayList<RowFilter<Object,Object>>();
        TableRowSorter rowSorter = (TableRowSorter) table.getRowSorter();
        
        for(int i=0; i<table.getColumnCount(); i++){
            filters.add(RowFilter.regexFilter(text, i));
        }
        
        RowFilter<Object,Object> filter = RowFilter.orFilter(filters);
        
        rowSorter.setRowFilter(filter);
    }
}
