package Example;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
public class Parameters implements ActionListener{
	double strike[][]= new double[20][20];
	 String type[] = new String[20];
	 String order[]= new String[20];
	 double spot;
	 int temp=0;
	 JButton add_pos = new JButton("Add position");
    public  void tester(){		
    JFrame frame = new JFrame("Chart Parameters");
    JPanel pane = new JPanel(new GridLayout(1,4));
    pane.setVisible(true);
    pane.setBackground(Color.BLACK);
    frame.getContentPane().setBackground(Color.black);
    frame.add(pane, BorderLayout.NORTH);
    JTable table = new JTable(){
        @Override
        public boolean isCellEditable(int row, int column) {
          return false;
        }}; 
    Object[] columns = {"Strike Price","Premium","Type","Order"};
    Object[] row = new Object[4];
    DefaultTableModel model = new DefaultTableModel();
    model.setColumnIdentifiers(columns);
    table.setModel(model);
    table.setBackground(Color.BLACK);
    table.setForeground(Color.WHITE);
    Font font = new Font("ARIAL",Font.BOLD,16);  
    table.setFont(font);
    table.setRowHeight(30);
    table.setShowHorizontalLines(true);
    table.setShowVerticalLines(true);
    JScrollPane panel = new JScrollPane(table);
    panel.setBounds(100, 100, 300, 300);
    frame.add(panel, BorderLayout.CENTER);
    frame.setVisible(true);
    frame.setSize(800,800);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    panel.setBackground(Color.black);
     
    JLabel paramtext1 = new JLabel("Strike price :");
    paramtext1.setFont(new Font("Calibri", Font.BOLD, 16));
    paramtext1.setForeground(Color.WHITE);
    
    JTextField param1 = new JTextField(10);
    param1.setText(String.valueOf(strike[temp][0]));
    param1.setFont(new Font("Calibri", Font.BOLD, 16));
    param1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
      strike[temp][0] = Double.parseDouble(param1.getText()); 
    }
    });  
    pane.add(paramtext1);
    pane.add(param1);
    
    JLabel paramtext2 = new JLabel(" Premium : ");
    paramtext2.setFont(new Font("Calibri", Font.BOLD, 16));
    paramtext2.setForeground(Color.WHITE);
      paramtext2.setVisible(true);
      JTextField param2 = new JTextField(20);
      param2.setFont(new Font("Calibri", Font.BOLD, 16));
      param2.setText(String.valueOf(strike[temp][1]));
      param2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        strike[temp][1] = Double.parseDouble(param2.getText()); 
            }
        });       
        pane.add(paramtext2);
        pane.add(param2);

      JLabel paramtext3 = new JLabel(" Call/Put : ");
      paramtext3.setFont(new Font("Calibri", Font.BOLD, 16));
      paramtext3.setForeground(Color.WHITE);
      paramtext3.setVisible(true);
      /*String[] options1 = {"CALL", "PUT"};
      JComboBox combo1 = new JComboBox(options1);
      combo1.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
          type[temp] = (String) combo1.getItemAt(combo1.getSelectedIndex());
              }
          });
     */ 
      JTextField param3 = new JTextField(20);
      param3.setText(String.valueOf(type[temp]));
      param3.setFont(new Font("Calibri", Font.BOLD, 16));
      param3.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        type[temp] = param3.getText();
            }
        });  
      pane.add(paramtext3);
      pane.add(param3);
      
      JLabel paramtext4 = new JLabel(" Buy/Sell : ");
      paramtext4.setFont(new Font("Calibri", Font.BOLD, 16));
      paramtext4.setForeground(Color.WHITE);
      paramtext4.setVisible(true);
     /* String[] options2 = {"BUY", "SELL"};
      JComboBox combo2 = new JComboBox(options2);
      combo2.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
          type[temp] = (String) combo2.getItemAt(combo2.getSelectedIndex());
              }
          });
      */ 
      JTextField param4 = new JTextField(20);
      param4.setText(String.valueOf(order[temp]));
      param4.setFont(new Font("Calibri", Font.BOLD, 16));
      param4.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        order[temp] = param4.getText();
            }
        }); 
      pane.add(paramtext4);
      pane.add(param4);
      
      JPanel p = new JPanel();
      pane.setVisible(true);
      pane.setBackground(Color.BLACK);
      frame.add(p, BorderLayout.SOUTH);
      
      JLabel paramtext5 = new JLabel("Spot price :");
      paramtext5.setFont(new Font("Calibri", Font.BOLD, 16));
      JTextField param5 = new JTextField(10);
      param5.setText(String.valueOf(spot));
      param5.setFont(new Font("Calibri", Font.BOLD, 16));
      param5.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
          spot = Double.parseDouble(param5.getText()); 
          }
          });  
      p.add(paramtext5);
      p.add(param5);
      
      JButton backButton = new JButton("↩ Back");
      backButton.setVisible(true);
      backButton.setBounds(100, 300, 100, 100);
      backButton.setSize(100,100);
      p.add(backButton);
        
      JButton add = new JButton("Add");
      add.setBounds(100,100,100,100); 
      add.setVisible(true);   
      add.addActionListener( new ActionListener()
      {
    	  public void actionPerformed(ActionEvent e)
          {
    		row[0] = param1.getText();
  	        row[1] = param2.getText();
  	        row[2] = param3.getText();//(String) combo1.getItemAt(combo2.getSelectedIndex());
  	        row[3] = param4.getText();//(String) combo2.getItemAt(combo2.getSelectedIndex()); 
  	    	model.addRow(row); 
          }
   	  });  
      p.add(add);
      add_pos.setBounds(100,100,100,100); 
      add_pos.setVisible(true);   
      add_pos.addActionListener(this);
      p.add(add_pos);        
      JButton ch = new JButton("Chart");
      ch.setBounds(100,100,100,100); 
      ch.setVisible(true);   
      ch.addActionListener( new ActionListener()
      {
    	  public void actionPerformed(ActionEvent e)
          {
    		  PayoffChart pc = new PayoffChart();
  		  	  pc.cframes(strike, type, order,  spot); 
          }
   	  });  
      p.add(ch);
           
      backButton.addActionListener( new ActionListener()
      {
          public void actionPerformed(ActionEvent e)
          {
        	  Op o = new Op();
        	  o.Mainmenu();
        	  frame.dispose();
          }
      });        
}
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== add_pos)
			temp++;		
	}  
}