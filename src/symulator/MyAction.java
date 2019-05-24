/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symulator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author Albert
 */
public class MyAction implements ActionListener 
{
    private Frame frame;
    
    MyAction(Frame frame)
    {
        this.frame=frame;
        
    }
    public void actionPerformed(ActionEvent e) {
            JButton bt = (JButton)e.getSource();
            if(bt==frame.button)
            {
                System.out.println("ok");
                frame.button.setText("");
            }
            
        }
    
    
    
}
