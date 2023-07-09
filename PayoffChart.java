package Example;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
public class PayoffChart extends JFrame {  
  private static final long serialVersionUID = 1L;  
  PayoffChart(){} 
  public PayoffChart(String title, double s[][], String t[], String o[], double sp) {  
    super(title);  
    DefaultCategoryDataset dataset = createDataset(s, t, o, sp);
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
	public DefaultCategoryDataset createDataset(double strike[][], String type[], String order[],double spot) {  		  
	int pspot = (int)spot-1500;
	String series2 = "Profit";
    String series1 = "Loss"; 
    DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    int i,k;
    int lotsize = 50;
    double pl[];
    pl = new double[3001];
    double payoff[][];
    payoff = new double[3001][4];
    int legs = 0;
    while(strike[legs][0] != 0.0) {
    	legs++;
    }
    spot = pspot;
    System.out.println(legs);
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
    spot = pspot;
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
    spot = pspot;
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
   spot = pspot;
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
    	dataset.addValue(pl[i], series1, ""+(pspot+i));
    else
    	dataset.addValue(pl[i], series2, ""+(pspot+i));
    }
    return dataset;  
  } 
	
	public void cframes(double s[][], String t[], String o[],double sp) {
		SwingUtilities.invokeLater(() -> {  
	        PayoffChart Chartframe = new PayoffChart("Payoff Chart", s, t, o, sp);    
	        Chartframe.pack();  
	        Chartframe.setSize(1000,800);  
	        Chartframe.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);  
	        Chartframe.setVisible(true); 
		});   
	}
	 
}  