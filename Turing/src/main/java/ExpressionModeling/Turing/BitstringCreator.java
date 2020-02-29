package ExpressionModeling.Turing;

import javax.swing.DefaultCellEditor;  
import javax.swing.JComboBox;  
import javax.swing.JFrame;  
import javax.swing.JScrollPane;  
import javax.swing.JTable;  
import javax.swing.table.AbstractTableModel;  
import javax.swing.table.TableModel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;  
public class BitstringCreator  
{
	private static JTextField textField;  
	private static EditableTableModel model;
	private static JTable table;
    public static void main(String[] a)  
    {  
        JFrame frame = new JFrame();  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        String[] columnTitles = {"1","2","3","4","5","6","7","8"};  
        Object[][] dataEntries = {  
        		{0,0,0,0,0,0,0,0},
        		{0,0,0,0,0,0,0,0},
        		{0,0,0,0,0,0,0,0},
        		{0,0,0,0,0,0,0,0},
        		{0,0,0,0,0,0,0,0},
        		{0,0,0,0,0,0,0,0},
        		{0,0,0,0,0,0,0,0},
        		{0,0,0,0,0,0,0,0},
        };  
        model = new EditableTableModel(columnTitles, dataEntries);  
        table = new JTable(model);  
        table.createDefaultColumnsFromModel();  
        frame.getContentPane().add(new JScrollPane(table));  
        
        textField = new JTextField();
        frame.getContentPane().add(textField, BorderLayout.SOUTH);
        textField.setColumns(10);

        JButton btnConvert = new JButton("Convert");
        btnConvert.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e)
			  {
				  assembleBitstring(model, textField);
			  }
        });
        
        frame.getContentPane().add(btnConvert, BorderLayout.EAST);
        
        JButton btnCopy = new JButton("Copy");
        btnCopy.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e)
			  {
				  String bitString = textField.getText();
				  StringSelection stringSelection = new StringSelection(bitString);
				  Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
				  clipboard.setContents(stringSelection, null);
			  }
        });
        
        
        frame.getContentPane().add(btnCopy, BorderLayout.WEST);
        
        JButton reset = new JButton("Reset");
        frame.getContentPane().add(reset, BorderLayout.NORTH);
        reset.addActionListener(new ActionListener() {
			  public void actionPerformed(ActionEvent e)
			  {
				  for(int col = 7; col >= 0; col--) {
						for(int row = 0; row < 8; row++) {
							model.setValueAt(0, row, col);
						}
				  }
				  table.repaint();
			  }
        });
        
        frame.setSize(500, 300);  
        frame.setVisible(true);
    }

    	
		public static void assembleBitstring(EditableTableModel model, JTextField feild) {
			String translation = "0b";
			for(int row = 7; row >= 0; row--) {
				for(int col = 0; col < 8; col++) {
					translation += model.getValueAt(row, col);
				}
				translation += "_";
			}
			translation = translation.substring(0, translation.length() - 1);
			translation += "L";
			feild.setText(translation);
		}
    }  

     class EditableTableModel extends AbstractTableModel  
    {  
        String[] columnTitles;  
        Object[][] dataEntries;  
        int rowCount;  
        public EditableTableModel(String[] columnTitles, Object[][] dataEntries)  
        {  
            this.columnTitles = columnTitles;  
            this.dataEntries = dataEntries;  
        }  
        public int getRowCount()  
        {  
            return dataEntries.length;  
        }  
        public int getColumnCount()  
        {  
            return columnTitles.length;  
        }  
        public Object getValueAt(int row, int column)  
        {  
            return dataEntries[row][column];  
        }  
        public String getColumnName(int column)  
        {  
            return columnTitles[column];  
        }  
        public Class getColumnClass(int column)  
        {  
            return getValueAt(0, column).getClass();  
        }  
        public boolean isCellEditable(int row, int column)  
        {  
            return true;  
        }  
        public void setValueAt(Object value, int row, int column)  
        {  
             dataEntries[row][column] = value;  
        }  
    }  