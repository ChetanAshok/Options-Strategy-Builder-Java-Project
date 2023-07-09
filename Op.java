package Example;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.WindowEvent;    
public class Op {
    public static void main(String[]args){
       Mainmenu(); 
     }
public static void Mainmenu(){
   JFrame frame = new JFrame("JFrame Example");
   ImageIcon image1 = new ImageIcon("D:\\4th Sem\\Mini Project\\src\\mini\\project\\graph.png");
   JLabel label1 = new JLabel(image1);
   label1.setVisible(true);
   //label1.setBounds(0, 0, 800, 800);
   label1.setSize(1200,800);
   frame.add(label1);
   String lb1 = "<html>" + "\tAbout" + "<br>" + "Options"+"</html>";
   JButton b0 = new JButton(lb1);
   JButton b1 = new JButton("Compute Greeks");
   String lb2 = "<html>" + "Black Scholes" + "<br>" + "Calculator"+"</html>";
   JButton b2 = new JButton(lb2);
   JButton b3 = new JButton("Payoff Chart");
   //JButton b4 = new JButton("Portfolio Tracker");
   JButton b4 = new JButton(new ImageIcon(((new ImageIcon("D:\\4th Sem\\Mini Project\\src\\mini\\project\\portfolio1.jpg")).getImage()).getScaledInstance(300, 500, java.awt.Image.SCALE_SMOOTH)));
   frame.setSize(800,800);
   frame.setTitle("Opstra : The Option Strategy"); 
   frame.setLayout(null);
   frame.setVisible(true);
   frame.setResizable(false);
   b0.setBounds(140,100,200,90);
   b0.setFont(new Font("Arial", Font.BOLD, 18));
   //b0.setBackground(Color.BLACK);
   //b0.setForeground(Color.CYAN);
   frame.getContentPane().setBackground(Color.BLACK);
   b0.setVisible(true);
   frame.add(b0);
   b0.addActionListener( new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
          new launchIntro();
          frame.dispose();
        }
    });
   b1.setBounds(140,230,200,90);
   b1.setFont(new Font("Arial", Font.BOLD, 18));
   b1.setVisible(true);
   //b1.setBackground(Color.BLACK);
   //b1.setForeground(Color.CYAN);S
   frame.add(b1);
   b1.addActionListener( new ActionListener()
   {
	   public void actionPerformed(ActionEvent e)
	        {
	              JFrame f = new ComputeGreeks(120, 100, 5, 0.005, 0.001, 0.1);
	        }
	    });
   b2.setBounds(140,360,200,90);
   b2.setFont(new Font("Arial", Font.BOLD, 18));
   b2.setVisible(true);
   //b2.setBackground(Color.BLACK);
   //b2.setForeground(Color.CYAN);
   frame.add(b2);
   b2.addActionListener( new ActionListener()
   {
       public void actionPerformed(ActionEvent e)
       {
             JFrame f = new ComputeOptionPrice(120, 100, 5, 0.005, 0.001, 0.1);
       }
   });
   b3.setBounds(140,490,200,90);
   b3.setFont(new Font("Arial", Font.BOLD, 18));
   b3.setVisible(true);
   //b3.setBackground(Color.BLACK);
   //b3.setForeground(Color.CYAN);
   frame.add(b3);
   b3.setVisible(true);
   
   b3.addActionListener( new ActionListener()
   {
       private double a[][] = new double[][] {{12000,300}};

	public void actionPerformed(ActionEvent e)
       {
             Parameters para = new Parameters();
             para.tester();
             frame.dispose();
       }
   });
   b4.setBounds(440,130,250,400);
   b4.setFont(new Font("Serif", Font.BOLD, 28));
   b4.setVisible(true);
   //b2.setBackground(Color.BLACK);
   //b2.setForeground(Color.CYAN);
   frame.add(b4);
   b4.addActionListener( new ActionListener()
   {
       public void actionPerformed(ActionEvent e)
       {
             JFrame f = new Portfolio();
             java.awt.EventQueue.invokeLater(new Runnable() {
                 public void run() {
                     new Portfolio().setVisible(true);
                 }
             });
       }
   });
    frame.addWindowListener (new WindowAdapter(){    
        public void windowClosing (WindowEvent e) {    
            frame.dispose();    
        }
    });  
}
public static class launchIntro extends JFrame{
    JFrame frameIntro;
    int indexSlide;
    int numberOfSlides;
    launchIntro() {
    frameIntro = new JFrame("Introduction to Options");
    indexSlide = 0;
    frameIntro.setLayout(null);
    frameIntro.setSize(1000, 800);
    frameIntro.setResizable(false);
    frameIntro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frameIntro.setLocationRelativeTo(null);
    frameIntro.setVisible(true);
    //frameIntro.getContentPane().setBackground(Color.white);
    Image icon = Toolkit.getDefaultToolkit().getImage("stock.jpg");  
    frameIntro.setIconImage(icon);
    ArrayList<ImageIcon> listIcons = new ArrayList<ImageIcon>();
    listIcons.add(new ImageIcon("D:\\4th Sem\\Mini Project\\src\\mini\\project\\Slide01.png"));
    listIcons.add(new ImageIcon("D:\\4th Sem\\Mini Project\\src\\mini\\project\\Slide02.png"));
    listIcons.add(new ImageIcon("D:\\4th Sem\\Mini Project\\src\\mini\\project\\Slide03.png"));
    listIcons.add(new ImageIcon("D:\\4th Sem\\Mini Project\\src\\mini\\project\\Slide04.png"));
    listIcons.add(new ImageIcon("D:\\4th Sem\\Mini Project\\src\\mini\\project\\Slide05.png"));
    listIcons.add(new ImageIcon("D:\\4th Sem\\Mini Project\\src\\mini\\project\\Slide06.png"));
    listIcons.add(new ImageIcon("D:\\4th Sem\\Mini Project\\src\\mini\\project\\Slide07.png"));
    JLabel slide = new JLabel(listIcons.get(0));
    int numberOfSlides = listIcons.size();
    slide.setVisible(true);
    slide.setBounds(100, 35, 800, 600);
    frameIntro.add(slide);
    JLabel pageNumber = new JLabel("1/7");
    pageNumber.setVisible(true);
    pageNumber.setForeground(Color.white);
    pageNumber.setFont(new Font("Calibri", Font.BOLD, 17));
    pageNumber.setBounds(930, 600, 100, 40);
    frameIntro.add(pageNumber);
    JButton nextButton = new JButton("Next ->");
    nextButton.setVisible(true);
    nextButton.setBounds(800, 680, 100, 40);
    frameIntro.add(nextButton);
    nextButton.addActionListener( new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
          indexSlide++;
          if (indexSlide >= numberOfSlides) indexSlide = 0;
          slide.setIcon(listIcons.get(indexSlide));
          pageNumber.setText(String.format("%d/7",indexSlide+1));
        }
    });
    JButton backButton = new JButton("<- Back");
    backButton.setVisible(true);
    backButton.setBounds(100, 680, 100, 40);
    frameIntro.add(backButton);
    backButton.setMnemonic(KeyEvent.VK_LEFT);
    backButton.addActionListener( new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
          indexSlide--;
          if (indexSlide < 0) indexSlide = numberOfSlides-1; 
          slide.setIcon(listIcons.get(indexSlide));
          pageNumber.setText(String.format("%d/7",indexSlide+1));
        }
    });
    JButton menuButton = new JButton("HOME");
    menuButton.setVisible(true);
    menuButton.setBounds(450, 680, 100, 40);
    frameIntro.add(menuButton);
    menuButton.addActionListener( new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
            Mainmenu();   
            frameIntro.dispose();
        }
    });
}}}