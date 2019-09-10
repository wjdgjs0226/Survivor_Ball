import javax.swing.*;
public class Runner 
{
	
	
	   public static void main(String[] args){
	       JFrame frame = new JFrame("Survivor Ball");
	       Game one = new Game();
	       frame.add(one);
	       
	       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	       frame.setVisible(true);
	       frame.setSize(700+frame.getInsets().left + frame.getInsets().right, 600+frame.getInsets().top + frame.getInsets().bottom);
	 
	       long currentTime = System.currentTimeMillis();
	       while (true)
	       {
	            long frameStart = System.currentTimeMillis();
	            one.update(frameStart - currentTime);
	            one.GameisWon();
	            frame.repaint();
	            currentTime = frameStart;
	       }
	   }
	}

