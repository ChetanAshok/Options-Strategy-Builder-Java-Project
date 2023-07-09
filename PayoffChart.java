
import javax.swing.JFrame;  
import javax.swing.SwingUtilities;  
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.WindowEvent;

public class PayoffChart extends JFrame {  
  
  private static final long serialVersionUID = 1L;  
  
  public PayoffChart(String title) {  
    super(title);    
    DefaultCategoryDataset dataset = createDataset();    
    JFreeChart chart = ChartFactory.createLineChart(  
        "Payoff Chart", 
        "Spot price",
        "P&L", 
        dataset,
        PlotOrientation.VERTICAL,
        true,
        true,
        false
        );                       
    ChartPanel panel = new ChartPanel(chart);  
    setContentPane(panel);  
  }  
  
  	private DefaultCategoryDataset createDataset() {  
	
	String series2 = "Profit";
    String series1 = "Loss"; 
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
   /* double strike[][]= {{12300,95.95},{12100,141.05},{10900,113.2}};//{10700,84.5}
    Scanner sc = new Scanner(System.in);
    //strike = new double[2][4] ;
    int legs = 3;
    String type[] = new String[] {"call","Call","Put"};//PUT
    String order[]= new String[] {"BUY","sell","sell"};//BUY
    */
    int i,k;
    int lotsize = 50;
    int spot = 10000;
    int new_spot = spot;
    double pl[];
    pl = new double[3001];
    double payoff[][];
    payoff = new double[3001][4];
    int temp=0;
    /*for( i=0;i<legs;i++) {
        for(int j=0;j<1;j++) {
    	System.out.println("Enter the"+i+"leg");
    	strike[i][j]=sc.nextInt();
    	}
        System.out.println(" Call/Put :");
        type[i]=sc.nextLine();
        System.out.println(" Buy/Sell :");
        order[i]=sc.nextLine();
    }*/
    for(k=0;k<legs;k++) {
    if(type[k].equalsIgnoreCase("Call") && order[k].equalsIgnoreCase("Buy")) {	
    for(i=0;i<=3000;i++){
    	if(spot<=strike[k][0]){
        	payoff[i][k] = -strike[k][1];
    	}
    	else{
    	payoff[i][k]=spot-strike[k][0]-strike[k][1];
    	}
    	spot=spot+1;
    }
    }
    spot = 10000;
    if(type[k].equalsIgnoreCase("Call") && order[k].equalsIgnoreCase("Sell")) {
    for(i=0;i<=3000;i++){
    	if(spot<=strike[k][0]){
      	payoff[i][k] = strike[k][1];
    	}
    	else{
    	payoff[i][k]=strike[k][0]+strike[k][1]-spot;
    	}
    	spot+= 1;
    }
    }
    spot = 10000;
    if(type[k].equalsIgnoreCase("Put") && order[k].equalsIgnoreCase("Sell")) {
    for(i=0;i<=3000;i++){
    	if(spot>=strike[k][0]){
        	payoff[i][k] = strike[k][1];
    	}
    	else{
    	payoff[i][k]=spot-strike[k][0]+strike[k][1];
    	}
    	spot+=1;
    }
    }
   spot = 10000;
   if(type[k].equalsIgnoreCase("Put") && order[k].equalsIgnoreCase("Buy")) {
    for(i=0;i<=3000;i++){
    	if(spot>=strike[k][0]){
        	payoff[i][k] = -strike[k][1];
    	}
    	else{
    	payoff[i][k]=strike[k][0]-strike[k][1]-spot;
    	}
    	spot += 1;
    }
   }
    }
    for(i=0;i<=3000;i++){
    	for( k=0;k<legs;k++) {
    	pl[i] += payoff[i][k]*lotsize;
    	}
    }
    for(i=0;i<=3000;i+=2){
    if(pl[i]<0)
    	dataset.addValue(pl[i], series1, ""+(10000+i));
    else
    	dataset.addValue(pl[i], series2, ""+(10000+i));
    }
    return dataset;  
  } 
  public static void main(String[] args){  
    SwingUtilities.invokeLater(() -> {  
      PayoffChart Chartframe = new PayoffChart("Payoff Chart");  
      //Chartframe.setAlwaysOnTop(true);  
      Chartframe.pack();  
      Chartframe.setSize(1000,800);  
      Chartframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
      Chartframe.setVisible(true); 
      
    });  
  }  
}  
