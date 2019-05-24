/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package symulator;

import static java.awt.AWTEventMulticaster.add;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Panel;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Albert
 */
public class Frame extends JFrame 
{
   public  JButton button = new JButton("test");
    	public Frame()
        {
                super("Control System");
                      JPanel LeftPanel = new JPanel();
                      JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
                      JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT)); 
                      JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
                      JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
                      

                JPanel panel = new MyPanel();
                LeftPanel.setLayout(new GridLayout(10,1));
                JLabel labelk = new JLabel("k:");
                JTextField textk = new JTextField("",15);
                panel1.add(labelk,BorderLayout.WEST);
                panel1.add(textk,BorderLayout.CENTER);
                labelk.setLabelFor(textk);
                 JLabel labelT = new JLabel("T:");
                JTextField textT = new JTextField("",15);
                panel2.add(labelT,BorderLayout.WEST);
                panel2.add(textT,BorderLayout.CENTER);
                 JLabel labela = new JLabel("a:");
                JTextField texta = new JTextField("",15);
                panel3.add(labela,BorderLayout.WEST);
                panel3.add(texta,BorderLayout.CENTER);
                 JLabel labelB = new JLabel("B:");
                JTextField textB = new JTextField("",15);
                 panel4.add(labelB,BorderLayout.WEST);
                 panel4.add(textB,BorderLayout.CENTER);
                 button.addActionListener(new MyAction(this));
                 
                 LeftPanel.add(panel1);
                 LeftPanel.add(panel2);
                 LeftPanel.add(panel3);
                   LeftPanel.add(panel4);
                   LeftPanel.add(button);
//                labelT.setLabelFor(textT);
//                labelk.setLabelFor(textk);
//                labelB.setLabelFor(textB);
//                labela.setLabelFor(texta);
//                LeftPanel.add(labelk,BorderLayout.WEST);
//                LeftPanel.add(textk,BorderLayout.CENTER);
//               LeftPanel.add(labelT,BorderLayout.WEST);
//               LeftPanel.add(textT,BorderLayout.CENTER);
//                LeftPanel.add(labela,BorderLayout.WEST);
//               LeftPanel.add(texta,BorderLayout.CENTER);
//                LeftPanel.add(labelB,BorderLayout.WEST);
//               LeftPanel.add(textB,BorderLayout.CENTER);
                this.add(LeftPanel,BorderLayout.WEST);
               
            
            add(panel);

            pack();
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setVisible(true);
            
            
                   
        }
        
        
}
