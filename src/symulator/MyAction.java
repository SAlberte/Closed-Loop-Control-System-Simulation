/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symulator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;

/**
 *
 * @author Albert
 */
public class MyAction implements ActionListener 
{
    public Frame frame;
    
    
    MyAction(Frame frame)
    {
        this.frame=frame;
        
    }
    public void actionPerformed(ActionEvent e)
    {
            JButton bt = (JButton)e.getSource();
            if(bt==frame.button)
            {
                System.out.println("ok");
                try{
                    double value = Double.parseDouble(frame.textAmp.getText());
                    frame.Amplitude=value;
                     value = Double.parseDouble(frame.textFreq.getText());
                    frame.Frequency=value;
                    value = Double.parseDouble(frame.textTime.getText());
                    frame.Time= value;
                }
                catch (Exception s)
                {
                    System.out.println("Must be a number");
                }
            
                        
                frame.Pointslist.clear();
                frame.panel.getPoints(frame.Pointslist,frame.Amplitude);
                frame.getRectangularPlot();
                frame.repaint();
            }
            
        }
    
    
    
}
