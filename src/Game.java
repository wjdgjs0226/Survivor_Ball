import java.awt.*;
import java.util.Timer;
import java.awt.event.*;
import javax.swing.*;
import java.lang.Math;
import java.util.Random;
import java.io.*;
import java.util.*;
import javax.imageio.*;
import java.awt.image.*;
public class Game extends JPanel implements KeyListener
{    
    BufferedImage fail;
    BufferedImage done;
    BufferedImage complete;
    PlayerBall player;
    int num; //number of Hecks created
    double level; //level corresponds to speed of ball
    HecklerBall Heckler = new HecklerBall(350, 350, 30, 30, 10);
    int Stage;
    HecklerBall[] h = new HecklerBall[120];
    StopWatch clock = new StopWatch();
    int xd;
    int yd;
    boolean changestage;
    
    
    
    public Game()
    {
    	
        this.addKeyListener(this);
        stage1();
        try{
            fail=ImageIO.read(new File ("fail.jpg"));
            done=ImageIO.read(new File ("pass.jpg"));
            complete = ImageIO.read(new File ("complete.jpg"));
        }
        catch (Exception e){
            System.out.println("error");
        }

    }
    //stage x method resets/initiates stage
 
    public void stage1()
    {	
    	clock.reset();
    	clock.start();
        player=new PlayerBall(50,50,10,330);
        num=20;
        level=1.3;
        Heckler.setNumber(h, num,level, 10);
        Stage=1;
        
    }
    public void stage2()
    {
    	clock.reset();
    	clock.start();
    	
    	player=new PlayerBall(50,50,10,330);
        num=25;
        level=1.5;
        Heckler.setNumber(h, num,level,20);
        ;
        Stage=2;
        
    }
    public void stage3()
    {
    	clock.reset();
    	clock.start();
    	player=new PlayerBall(50,50,10,330);
        num=30;
        level=1.9;
        Heckler.setNumber(h, num,level,25);
        Stage=3;
    }
    public void stage4()
    {
    	clock.reset();
    	clock.start();
    	player=new PlayerBall(50,50,10,330);
        num=35;
        level=2.1;
        Heckler.setNumber(h, num,level,25);
        Stage=4;
    }
    public void stage5()
    {
    	clock.reset();
    	clock.start();
    	player=new PlayerBall(50,50,10,330);
        num=37;
        level=2.2;
        Heckler.setNumber(h, num,level,30);
        Stage=5;
    }
    public void stage6()
    {
    	clock.reset();
    	clock.start();
    	player=new PlayerBall(50,50,10,330);
        num=40;
        level=2.4;
        Heckler.setNumber(h, num,level,30);
        Stage=6;
    }
    public void stage7()
    {
    	clock.reset();
    	clock.start();
    	player=new PlayerBall(50,50,10,330);
        num=45;
        level=2.6;
        Heckler.setNumber(h, num,level,40);
        Stage=7;
    }
    public void stage8()
    {
    	clock.reset();
    	clock.start();
    	player=new PlayerBall(50,50,10,330);
        num=50;
        level=2.8;
        Heckler.setNumber(h, num,level,40);
        Stage=8;
    }
    
    public void update(long time)
    {
        this.requestFocus();
        player.Movement(time);
        for(int i =0; i < num; i++)
        {
        	h[i].Movement(time, player);
        }
    }
    
    
    
    
    
    public void paint(Graphics g){
        Color k=new Color(0,0,0);
        g.setColor(k);
        g.fillRect(0, 0, 600, 600);//black background
        if(changestage == false & player.velocity == 0){g.drawImage(fail,0,0,null);}//fail message
        if(changestage == true & player.velocity == 0) {g.drawImage(done, 0, 0, null);}
        if(Stage == 9) {g.drawImage(complete, 0, 0, null);}
        
        
        for(int i =0; i < h.length; i++)
        {
        	h[i].CreateBall(g);
        }
        player.CreateBallImage(g);
        
        
        
    }
    
    public void keyTyped(KeyEvent e){
        
        //variables for indicating new direction
        xd=0;
        yd=0;
        
        if(e.getKeyChar()=='w') yd=-1; //up
        if(e.getKeyChar()=='s') yd=1; //down
        if(e.getKeyChar()=='a') xd=-1; //left
        if(e.getKeyChar()=='d')  xd=1; //right
        player.ChangeDirection(xd,yd);
        
        //stage selection
        
    		if(changestage == true & e.getKeyChar()=='n')
            {
                if(Stage==1) stage2();
                else if(Stage==2) stage3();
                else if(Stage==3) stage4();
                else if(Stage==4) stage5();
                else if(Stage==5) stage6();
                else if(Stage==6) stage7();
                else if(Stage==7) stage8();
                else if(Stage==8) Stage = 9;
                
            }
        
        
        
        	if(changestage == false & player.velocity == 0 & e.getKeyChar()=='r')
        	{
            if(Stage==1) stage1();
            else if(Stage==2) stage2();
            else if(Stage==3) stage3();
            else if(Stage==4) stage4();
            else if(Stage==5) stage5();
            else if(Stage==6) stage6();
            else if(Stage==7) stage7();
            else if(Stage==8) stage8();
        	}
        
        
        
    }
	@Override
	public void keyPressed(KeyEvent e) 
	{	
	}
	@Override
	public void keyReleased(KeyEvent e) 
	{
	}
	
	public void GameisWon()
    {
		
    	
    	for(int i =0; i <num; i++)
    	{
    	if((h[i].xposition-player.xposition)*(h[i].xposition-player.xposition)+(h[i].yposition-player.yposition)*(h[i].yposition-player.yposition)<(h[i].radius+player.radius)*(h[i].radius+player.radius))
    	{
    		clock.stop();
    		
    		player.xvelocity = 0;
    		player.velocity =0;
    		player.velocity =0;
    		player.Movement(0);
    		player.ChangeDirection(0, 0);
    		
    		for(i =0; i < num; i++)
    		{
    		
    		
    		h[i].xvelocity = 0;
    		h[i].yvelocity = 0;
    		
    		}
          changestage = false;  
    	}
    	}
    	
    	
        if(clock.getElapsedTime() / 1000.0 == 15.0)
          {
        	player.velocity =0;
        	for(int i =0; i < h.length; i++)
        	{
        		h[i].xvelocity=0;
        		h[i].yvelocity=0;
        	}
            changestage = true; 
          }
    	}
    	
    	{
    		
    	}
    	
    	
    	
    	
    	
    	
    }
    
