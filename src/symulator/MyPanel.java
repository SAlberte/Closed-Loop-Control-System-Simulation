/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symulator;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Albert
 */
public class MyPanel extends JPanel 
{   
    public ArrayList <Point2D> list;
    public Double Amp;
    public Double Time;
    public MyPanel()
    {
        super();
        setPreferredSize(new Dimension(1000,600));
               
    }
  	@Override
	protected void paintComponent(Graphics g) 
        {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
                
                if(list!=null)
                {
                    this.removeAll();
                    g2d.setColor(Color.red);
                    g2d.drawLine((int)list.get(0).getX(), (int)list.get(0).getY(),(int)list.get(0).getX(),(int)list.get(0).getY());
                    for(int i=1;i<list.size();i++)
                    {
                        g2d.drawLine((int)list.get(i-1).getX(), (int)list.get(i-1).getY(),(int)list.get(i).getX(),(int)list.get(i).getY());
                        
                    }
                    g2d.drawString(Double.toString(Amp),350,30);
                    g2d.drawString(Double.toString(Time),905,130);
                }
                g2d.setColor(Color.black);
                g2d.drawLine(400, 10, 400, 230);
                g2d.drawLine(400, 130, 900, 130);
                g2d.drawLine(395,30,400,30);
                g2d.drawLine(900,125,900,135);
                Font font = new Font("Serif", Font.PLAIN, 12);
 
                g2d.setFont(font);
                

                    
                
	}
        public void getPoints(ArrayList <Point2D> list,Double Amp,Double Time)
        {
            this.list=list;
            this.Amp=Amp;
            this.Time=Time;
            
        }
        
}
