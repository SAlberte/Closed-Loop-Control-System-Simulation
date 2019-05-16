/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symulator;

import static java.awt.AWTEventMulticaster.add;
import java.awt.Panel;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Albert
 */
public class Frame extends JFrame 
{
    	public Frame()
        {
            super("Control System");
            JPanel panel = new MyPanel();
            add(panel);

            pack();
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            
            
                   
        }
        
        
}
