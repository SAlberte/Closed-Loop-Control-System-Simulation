/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symulator;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;

/**
 *
 * @author Albert
 */
public class MyPanel extends JPanel 
{
    public MyPanel()
    {
        setPreferredSize(new Dimension(1000,600));
        
    }
  	
	protected void paintComponent(Graphics g) 
        {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
	}
}
