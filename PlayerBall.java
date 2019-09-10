import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PlayerBall
{
    public double xposition;
    public double yposition;
    public double xvelocity;
    public double yvelocity;
    public double velocity;//standard velocity
    public int radius;
    
    public PlayerBall(int xpos, int ypos, int rad, int vel)
    {
        xposition=xpos;
        yposition=ypos;
        xvelocity=0;
        yvelocity=0;
        radius=rad;
        velocity=vel;
        
    }
    
    public void ChangeDirection(int xdirection, int ydirection)
    {
    
    if(xdirection==1)
    {
        xvelocity=velocity;
        yvelocity=0;
    }
    else if(xdirection==-1)
    {
        xvelocity=-velocity;
        yvelocity=0;
    }
    if(ydirection==1)
    {
        yvelocity=velocity;
        xvelocity=0;
    }
    else if(ydirection==-1)
    {
        yvelocity=-velocity;
        xvelocity=0;
    }
    }
    //change direction according to input
    
    public void Movement(long time)
    {//change directions according to keyboard input
        
        if(xposition<radius && xvelocity<0)
        {
            xvelocity=-xvelocity;
            xposition=radius+1;
            
        }
        else if(xposition>600-radius && xvelocity>0)
        {
            xvelocity=-xvelocity;
            xposition=600-radius-1;
            
        }
        if(yposition<15 && yvelocity<0){
            yvelocity=-yvelocity;
            yposition=radius+1;
           
        }
        else if(yposition>600-radius && yvelocity>0){
            yvelocity=-yvelocity;
            yposition=600-radius-1;
            
        }
        
        xposition+=xvelocity*time/1000.0;
        yposition+=yvelocity*time/1000.0;
    }
    
    public void CreateBallImage(Graphics g){
        Color k=new Color(255,255,255);
        g.setColor(k);
        g.fillOval((int)xposition-radius,(int)yposition-radius,2*radius,2*radius);//draw Student
        
    }
}