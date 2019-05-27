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
                     value = Double.parseDouble(frame.textk.getText());
                    frame.Kp=value;
                    value = Double.parseDouble(frame.textT.getText());
                    frame.Tp= value;
                     value = Double.parseDouble(frame.texta.getText());
                    frame.a=value;
                    value = Double.parseDouble(frame.textB.getText());
                    frame.B= value;
                    value = Double.parseDouble(frame.textb.getText());
                    frame.b= value;
                    value = Double.parseDouble(frame.textResTime.getText());
                    frame.ResponseTime= value;

                }
                catch (Exception s)
                {
                    System.out.println("Must be a number");
                }
            
                frame.TrueResponse.clear();
                frame.Responselist.clear();
                frame.Pointslist.clear();
                frame.TruePointslist.clear();
                
                if(frame.RadSquare.isSelected())
                {
                    frame.panel.getPoints(frame.Pointslist,frame.Amplitude,frame.Time,frame.Responselist);
                    frame.getRectangularPlot();
                    frame.plotMapping();
                    frame.getResponse(1);
                    frame.ResponseplotMapping();
                    frame.repaint();
                }
                else if(frame.RadTriangular.isSelected())
                {
                    frame.panel.getPoints(frame.Pointslist,frame.Amplitude,frame.Time,frame.Responselist);
                    frame.getTriangularPlot();
                    frame.plotMapping();
                    frame.getResponse(2);
                    frame.ResponseplotMapping();
                    frame.repaint();
                }
                else if(frame.RadHarmonic.isSelected())
                {
                    frame.panel.getPoints(frame.Pointslist,frame.Amplitude,frame.Time,frame.Responselist);
                    frame.getHarmonicPlot();
                    frame.plotMapping();
                    frame.getResponse(3);
                    frame.ResponseplotMapping();
                    frame.repaint();
                }
               
            }
            
        }
    
    
    
}
