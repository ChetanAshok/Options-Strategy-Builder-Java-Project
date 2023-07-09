package Example;
import java.awt.Color;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
public class Portfolio extends javax.swing.JFrame {
   /* public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Portfolio().setVisible(true);
            }
        });
    } */
    public Portfolio() {
        initComponents();
        table_load();
    }
    
    public void table_load()
    {   
     try
     {
        Connection con;
        PreparedStatement pst;
        ResultSet rs;
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/port", "root","1234");
        pst = con.prepareStatement("select *from Portfolio");
        rs = pst.executeQuery();
        jTable1.setModel(DbUtils.resultSetToTableModel(rs));
     }
      catch (ClassNotFoundException ex)
        {
          ex.printStackTrace();
        }
      catch (SQLException e)
        {
          e.printStackTrace();
        }
    }
    @SuppressWarnings("unchecked")
                  
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTable jTable1 = new JTable(){
            @Override
            public boolean isCellEditable(int row, int column) {
              return false;
            }}; 

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setBackground(new java.awt.Color(0, 255, 0));
        jButton1.setFont(new java.awt.Font("Arial", 1, 14)); //NOI18N
        jButton1.setText("BUY");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jButton2.setBackground(new java.awt.Color(255, 0, 0));
        jButton2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton2.setText("SELL");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setText("Stock");

        jLabel2.setText("Market Price");

        jLabel3.setText("Quantity");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Stock", "Breakeven Price", "Quantity", "Total"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addComponent(jButton2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(31, 31, 31))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(55, 55, 55))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 373, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                          
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    try {
            
            String stock;
            double price,quantity,total;
            stock = jTextField1.getText();
            price = Double.parseDouble(jTextField2.getText());
            quantity=Double.parseDouble(jTextField3.getText());
            total=price*quantity;
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/port", "root","1234");
            Statement st = con.createStatement();
            rs=st.executeQuery("select *from Portfolio where Stock='"+stock+"'");
            if(rs.next())
            {
            	double temp_price,temp_quantity,temp_total,u_price,u_quantity,u_total;
            	temp_price=rs.getDouble("Breakeven_Price");
            	temp_quantity=rs.getDouble("Quantity");
            	u_price=Double.parseDouble(jTextField2.getText());
            	u_quantity=Double.parseDouble(jTextField3.getText());
            	u_total=u_price*u_quantity;
            	quantity=(temp_quantity+u_quantity);
            	price=(((temp_price*temp_quantity)+u_total)/quantity);
            	total=price*quantity;
            	System.out.println(price);
            	System.out.println(quantity);
                String del="delete from Portfolio where Stock='"+stock+"'";
                Statement st1 = con.createStatement();
                st1.executeUpdate(del);
                pst = con.prepareStatement("insert into Portfolio(Stock,Breakeven_Price,Quantity,Total)values(?,?,?,?)");
                pst.setString(1, stock);
                pst.setDouble(2, price);
                pst.setDouble(3, quantity);
                pst.setDouble(4, total);
                pst.executeUpdate();
                table_load();
                JOptionPane.showMessageDialog(null, "Buyed Successfully!!");          
            }
            else {
            pst = con.prepareStatement("insert into Portfolio(Stock,Breakeven_Price,Quantity,Total)values(?,?,?,?)");
            pst.setString(1, stock);
            pst.setDouble(2, price);
            pst.setDouble(3, quantity);
            pst.setDouble(4, total);
            pst.executeUpdate();
            table_load();
            JOptionPane.showMessageDialog(null, "Buyed Successfully!!");
        }}
        catch (ClassNotFoundException ex)
        {
          ex.printStackTrace();
        }
        catch (SQLException ex)
        {
          JOptionPane.showMessageDialog(null, "Error Buying");  
        }    
        
    }                                        

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {                                            
        // TODO add your handling code here:
    }                                           

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
      jButton2.setBackground(Color.RED);
      Connection con;
      PreparedStatement pst;
      ResultSet rs;
        try{
          String stock;
          double price,quantity,total;
          stock = jTextField1.getText();
          price = Double.parseDouble(jTextField2.getText());
          quantity=Double.parseDouble(jTextField3.getText()); 
          Class.forName("com.mysql.cj.jdbc.Driver");
          con = DriverManager.getConnection("jdbc:mysql://localhost:3306/port", "root","1234");
          Statement st1 = con.createStatement();  
          rs=st1.executeQuery("select *from Portfolio where Stock='"+stock+"'");
          if(rs.next())
          {
          	double temp_price,temp_quantity,temp_total,u_price,u_quantity,u_total;
          	temp_price=rs.getDouble("Breakeven_Price");
          	temp_quantity=rs.getDouble("Quantity");
          	u_price=Double.parseDouble(jTextField2.getText());
          	u_quantity=Double.parseDouble(jTextField3.getText());
          	u_total=u_price*u_quantity;
          	if(temp_quantity>u_quantity) {
          	quantity=(temp_quantity-u_quantity);
          	price=(((temp_price*temp_quantity)-u_total)/quantity);
          	total=price*quantity;
              String del="delete from Portfolio where Stock='"+stock+"'";
              st1.executeUpdate(del);
              pst = con.prepareStatement("insert into Portfolio(Stock,Breakeven_Price,Quantity,Total)values(?,?,?,?)");
              pst.setString(1, stock);
              pst.setDouble(2, price);
              pst.setDouble(3, quantity);
              pst.setDouble(4, total);
              pst.executeUpdate();
              table_load();
              JOptionPane.showMessageDialog(null, "Sell order Executed!!"); 
          	}
          	else if(temp_quantity<u_quantity){
          		JOptionPane.showMessageDialog(null, "Sell order not Executed!!"); 	
          	}
          	else {
          		 String del="delete from Portfolio where Stock='"+stock+"'";
                 st1.executeUpdate(del);
                 JOptionPane.showMessageDialog(null, "Sell order Executed!!");
          	}
          }
          table_load();
        }   
        catch (ClassNotFoundException ex)
        {
          ex.printStackTrace();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Sell order not Executed");
        }
        
    }                                        

    
    // Variables declaration - do not modify                     
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration                   
}