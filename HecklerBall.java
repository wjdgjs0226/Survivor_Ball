import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.lang.Math;
import java.util.Random;
import java.io.*;
import java.util.*;
import javax.imageio.*;
import java.awt.image.*;

public class HecklerBall{
    double xposition;//position of center
    double yposition;//position of center
    double xvelocity;//x velocity
    double yvelocity;//y velocity
    int radius;
    int number;
    boolean valid;
    Graphics a;
    public HecklerBall(int xpos, int ypos, int vx, int vy, int size)
    {
        
        valid=true;
        xposition=xpos;
        yposition=ypos;
        xvelocity=vx;
        yvelocity=vy;
        radius=size;
        number = 100;
         
        }
    
    public void Movement(long time, PlayerBall player)
    {
        
        if(!valid) 
        {
        	return;
        }
        xposition+=time*xvelocity/1000.0;
        yposition+=time*yvelocity/1000.0;
        
        if(xposition<radius && xvelocity<0)
        {
            xvelocity=-xvelocity;
            xposition = radius+1;
        }
        else if(xposition>600-radius && xvelocity>0)
        {
            xvelocity=-xvelocity;
            xposition=600-radius-1;
        }
        else if(yposition<15 && yvelocity<0)
        {
            yvelocity=-yvelocity;
            yposition=radius+1;
        }
        else if(yposition>600-radius && yvelocity>0)
        {
            yvelocity=-yvelocity;
            yposition=600-radius-1;
        }
    }
    
    public void CreateBall (Graphics a)
    {
    	Color c = new Color(102, 255, 51);
        a.setColor(c);
        a.fillOval((int)(xposition-radius),(int)(yposition-radius), 2*radius, 2*radius);
    }
    
    public void setNumber(HecklerBall[] h, int number, double level, int level1)
    {
    	//if game over or cleared, do nothing
        for(int i=0;i<number;i++)
        {
        	
                Random rng=new Random();
                
                int xdirection=(rng.nextInt(2)*2)-1;
                int ydirection=(rng.nextInt(2)*2)-1;
                int velocityxRand=xdirection*(rng.nextInt(level1)+50);
                int velocityyRand=ydirection*(rng.nextInt(level1)+50);
                h[i]= new HecklerBall(250,250,(int)(level*velocityxRand),(int)(level*velocityyRand),10);
        }
        for(int j=number; j<120; j++)
        {
        	h[j] = new HecklerBall(1000,1000,0,0,10);
        }
        
               
                
                
               
        
        
        
}

}





