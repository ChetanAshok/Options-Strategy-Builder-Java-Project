import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.awt.event.WindowEvent; 
package osb;

public class Op {
    public static void main(String[]args){
       Mainmenu(); 
     }
public static void Mainmenu(){
   JFrame frame = new JFrame(); 
   String lb1 = "<html>" + "\tAbout" + "<br>" + "Option stratagies"+"</html>";
   JButton b0 = new JButton(lb1);
   JButton b1 = new JButton("Payoff Chart");
   String lb2 = "<html>" + "Black Scholes" + "<br>" + "Calculator"+"</html>";
   JButton b2 = new JButton(lb2);
   JButton b3 = new JButton(new ImageIcon(((new ImageIcon("portfolio1.jpg")).getImage()).getScaledInstance(300, 500, java.awt.Image.SCALE_SMOOTH)));
   frame.setSize(800,800);
   frame.setTitle("Opstra : The Option Strategy"); 
   frame.setLayout(null);
   frame.setVisible(true);
   frame.setResizable(false);
   b0.setBounds(100,100,200,90);
   b0.setFont(new Font("Arial", Font.BOLD, 18));
   b0.setBackground(Color.BLACK);
   b0.setForeground(Color.CYAN);
   b0.setVisible(true);
   b0.addActionListener( new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
          new launchIntro();
          frame.dispose();
        }
    });
   frame.add(b0);
   b1.setBounds(100,300,200,90);
   b1.setFont(new Font("Arial", Font.BOLD, 18));
   b1.setBackground(Color.BLACK);
   b1.setForeground(Color.CYAN);
   b1.setVisible(true);
   frame.add(b1);
   b2.setBounds(100,500,200,90);
   b2.setFont(new Font("Arial", Font.BOLD, 18));
   b2.setBackground(Color.BLACK);
   b2.setForeground(Color.CYAN);
   b2.setVisible(true);
   frame.add(b2);
   b3.setBounds(400,100,300,500);
   b3.setFont(new Font("Serif", Font.BOLD, 28));
   b3.setBackground(Color.BLACK);
   b3.setForeground(Color.CYAN);
   b3.setVisible(true);
   frame.add(b3);  
   ImageIcon image1 = new ImageIcon("stock.jpg");
   JLabel label1 = new JLabel(image1);
   label1.setVisible(true);
   //label1.setBounds(0, 0, 800, 800);
   label1.setSize(800,800);
   frame.add(label1);
   Image icon = Toolkit.getDefaultToolkit().getImage("stock.jpg");  
   frame.setIconImage(icon); 
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
    Image icon = Toolkit.getDefaultToolkit().getImage("stock.jpg");  
    frameIntro.setIconImage(icon);
    ArrayList<ImageIcon> listIcons = new ArrayList<ImageIcon>();
    listIcons.add(new ImageIcon("Slide01.png"));
    listIcons.add(new ImageIcon("Slide02.png"));
    listIcons.add(new ImageIcon("Slide03.png"));
    listIcons.add(new ImageIcon("Slide04.png"));
    listIcons.add(new ImageIcon("Slide05.png"));
    listIcons.add(new ImageIcon("Slide06.png"));
    listIcons.add(new ImageIcon("Slide07.png"));
    JLabel slide = new JLabel(listIcons.get(0));
    int numberOfSlides = listIcons.size();
    slide.setVisible(true);
    slide.setBounds(120, -15, 800, 600);
    frameIntro.add(slide);
    JLabel pageNumber = new JLabel("1/7");
    pageNumber.setVisible(true);
    pageNumber.setBounds(770, 600, 100, 40);
    frameIntro.add(pageNumber);
    JButton nextButton = new JButton("Next ↪");
    nextButton.setVisible(true);
    nextButton.setBounds(800, 600, 100, 40);
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
    JButton backButton = new JButton("↩ Back");
    backButton.setVisible(true);
    backButton.setBounds(100, 600, 100, 40);
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
    JButton menuButton = new JButton("⌂ Menu");
    menuButton.setVisible(true);
    menuButton.setBounds(400, 600, 100, 40);
    frameIntro.add(menuButton);
    menuButton.addActionListener( new ActionListener()
    {
        public void actionPerformed(ActionEvent e)
        {
            Mainmenu();   
            frameIntro.dispose();
        }
    });
}
}
}

