package genericclass;

import java.awt.Component;
import java.util.Dictionary;
import java.util.Hashtable;

import javax.swing.JLabel;
import javax.swing.JSlider;

/**
 * CallOldCore
 */
public class CallOldCore {

    public static void main(String[] args) {
     
        test01();
    }
    public static void genericArray(){
        //
        //Pair<String>[] aa = new Pair<String>[10];
    }
    public static void test01(){
        Dictionary<Integer, Component> labelTable = new Hashtable<>();
        labelTable.put(0, new JLabel("nine.gif"));
        labelTable.put(20, new JLabel("ten.gif"));

        JSlider jSlider =new JSlider();
        jSlider.setLabelTable(labelTable);

        @SuppressWarnings("unchecked")
        Dictionary<Integer, Component> labelTables = jSlider.getLabelTable();
        
    }
}