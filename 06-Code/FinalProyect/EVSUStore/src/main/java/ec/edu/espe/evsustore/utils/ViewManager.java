
package ec.edu.espe.evsustore.utils;

import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Joan Cobeña, KillChain, DCCO-ESPE
 */
public class ViewManager {    
    
    public static void displayTable(JTable table, ArrayList<HashMap<Object, Object>> mapedsData){
        table.removeAll();
        DefaultTableModel inventoryTableModel = writeTable(table, mapedsData);
        table.setModel(inventoryTableModel);
        table.setDefaultEditor(Object.class, null);
    }
    
    public static DefaultTableModel writeTable(JTable table, ArrayList<HashMap<Object, Object>> mapedsData) {

        DefaultTableModel tableModel = new DefaultTableModel();
        
        if(mapedsData.isEmpty()){
            return tableModel;
        }
        
        HashMap<Object, Object> referenceMap = mapedsData.get(0);
        
        ArrayList<String> header = new ArrayList<>();
        
        ArrayList<Object> mapKeys = HashMapManger.getKeys(referenceMap);
        int initialIdIndex = HashMapManger.getIdIndex(referenceMap);
        HashMapManger.reorderkeys(mapKeys);
        
        for(Object key: mapKeys){
            header.add(translateText(key.toString()).toUpperCase());
        }
        
        tableModel.setColumnIdentifiers(header.toArray());
        
        Object[] tableData = new Object[header.size()];
        
        for(HashMap<Object, Object> mapedData: mapedsData){
            int i = 0;
            ArrayList<Object> values = HashMapManger.getValues(mapedData);
            HashMapManger.reorderValues(values, initialIdIndex);
            for(Object value: values){
                tableData[i] = value;
                i++;
            }
            
            tableModel.addRow(tableData);
            
        }
        
        return tableModel;
    }
    
    public static void displayTableWithoutIds(JTable table, ArrayList<HashMap<Object, Object>> mapedsData){
        
        DefaultTableModel inventoryTableModel = writeTableWithoutIds(table, mapedsData);
        table.setModel(inventoryTableModel);
        table.setDefaultEditor(Object.class, null);
    }
    
    public static DefaultTableModel writeTableWithoutIds(JTable table, ArrayList<HashMap<Object, Object>> mapedsData) {
        DefaultTableModel tableModel = new DefaultTableModel();
        
        HashMap<Object, Object> referenceMap = mapedsData.get(0);
        
        ArrayList<String> header = new ArrayList<>();
        
        ArrayList<Object> mapKeys = HashMapManger.getKeys(referenceMap);
        
        for(Object key: mapKeys){
            header.add(translateText(key.toString()).toUpperCase());
        }
        
        tableModel.setColumnIdentifiers(header.toArray());
        
        Object[] tableData = new Object[header.size()];
        
        for(HashMap<Object, Object> mapedData: mapedsData){
            int i = 0;
            ArrayList<Object> values = HashMapManger.getValues(mapedData);
            for(Object value: values){
                tableData[i] = value;
                i++;
            }
            
            tableModel.addRow(tableData);
            
        }
        
        return tableModel;
    }
    
    public static String translateText(String text) {
        String translatedText = HeaderTranslator.translateEN_ES(text);
        if (translatedText != null) {
            return translatedText;
        } else {
            return text; 
        }
    }

    
    public static void showPanel(JPanel pnelContent, JPanel panelUI) {
        panelUI.setSize(900, 675);
        panelUI.setLocation(1, 0);
        pnelContent.removeAll();
        pnelContent.add(panelUI, BorderLayout.CENTER);
        pnelContent.revalidate();
        pnelContent.repaint();
    }
    
    public static void showPanel(JPanel pnelContent, JScrollPane panelUI) {
        panelUI.setSize(900, 675);
        panelUI.setLocation(1, 0);
        pnelContent.removeAll();
        pnelContent.add(panelUI, BorderLayout.CENTER);
        pnelContent.revalidate();
        pnelContent.repaint();
    }
    
}
