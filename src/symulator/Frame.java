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
import java.awt.geom.Point2D;
import static java.lang.Math.asin;
import static java.lang.Math.sin;
import java.util.ArrayList;
import java.util.Objects;
import javafx.geometry.Point3D;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Albert
 */
public class Frame extends JFrame 
{
   public JButton button = new JButton("set");
   public JTextField textAmp = new JTextField("",15);
   public JTextField textFreq = new JTextField("",15);
   public JTextField textTime = new JTextField("",15);
   public JRadioButton RadSquare = new JRadioButton("Square Signal");
   public JRadioButton RadTriangular = new JRadioButton("Triangular Signal");
   public JRadioButton RadHarmonic = new JRadioButton("Harmonic Signal");
   public JTextField textk = new JTextField("",15);
   public JTextField textT = new JTextField("",15);
   public JTextField texta = new JTextField("",15);
   public JTextField textB = new JTextField("",15);
   public JTextField textb = new JTextField("",15);
   public JTextField textResTime = new JTextField("",15);

  

   public Double Time;
   public Double ResponseTime;
   public Double Amplitude;
   public Double Frequency;
   public  MyPanel panel;
   public Double Kp;
   public Double Tp;
   public Double a;
   public Double B;
   public Double b;
   public  ArrayList <Point2D> Pointslist; // contains points of plot after mapping
   public ArrayList <Point2D> TruePointslist; // contains points of real, unscaled plot
   public ArrayList <Point2D> TrueResponse; //contains points of real, unscaled response plot
   public ArrayList <Point2D> Responselist; // contains points of mapped response
   
     	public Frame()
        {
                super("Control System");

                Pointslist = new ArrayList <Point2D>();
                TruePointslist = new ArrayList<Point2D>();
                TrueResponse = new ArrayList<Point2D>();
                Responselist = new ArrayList<Point2D>();
                panel = new MyPanel();
                      JPanel LeftPanel = new JPanel();
                      JPanel panel1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
                      JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.LEFT)); 
                      JPanel panel3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
                      JPanel panel4 = new JPanel(new FlowLayout(FlowLayout.LEFT));
                      JPanel panel5 = new JPanel(new FlowLayout(FlowLayout.LEFT));
                      JPanel panel6 = new JPanel(new FlowLayout(FlowLayout.LEFT));
                      JPanel panel7 = new JPanel(new FlowLayout(FlowLayout.LEFT));
                      JPanel panel8 = new JPanel(new FlowLayout(FlowLayout.LEFT));
                      JPanel panel9 = new JPanel(new FlowLayout(FlowLayout.LEFT));
                      

                LeftPanel.setLayout(new GridLayout(20,1));
                JLabel labelk = new JLabel("k:");
                panel1.add(labelk,BorderLayout.WEST);
                panel1.add(textk,BorderLayout.CENTER);
                labelk.setLabelFor(textk);
                 JLabel labelT = new JLabel("T:");
                panel2.add(labelT,BorderLayout.WEST);
                panel2.add(textT,BorderLayout.CENTER);
                 JLabel labela = new JLabel("a:");
                panel3.add(labela,BorderLayout.WEST);
                panel3.add(texta,BorderLayout.CENTER);
                 JLabel labelB = new JLabel("B:");
                 panel4.add(labelB,BorderLayout.WEST);
                 panel4.add(textB,BorderLayout.CENTER);
                 JLabel labelAmp = new JLabel("Amplitude:");               
                 panel5.add(labelAmp,BorderLayout.WEST);
                 panel5.add(textAmp,BorderLayout.CENTER);
                 JLabel labelFreq = new JLabel("Frequency:");
                 panel6.add(labelFreq,BorderLayout.WEST);
                 panel6.add(textFreq,BorderLayout.CENTER);
                 JLabel labelTime = new JLabel("Time:");
                 panel7.add(labelTime,BorderLayout.WEST);
                 panel7.add(textTime,BorderLayout.CENTER);
                 JLabel labelTimeResponse=new JLabel("Response Time");
                 panel8.add(labelTimeResponse,BorderLayout.WEST);
                 panel8.add(textResTime,BorderLayout.CENTER);
                 JLabel labelb = new JLabel("b");
                 panel9.add(labelb,BorderLayout.WEST);
                 panel9.add(textb,BorderLayout.CENTER);
                 
                 button.addActionListener(new MyAction(this));
                 
                 LeftPanel.add(panel1);
                 LeftPanel.add(panel2);
                 LeftPanel.add(panel3);
                 LeftPanel.add(panel4);
                 LeftPanel.add(panel5);
                 LeftPanel.add(panel6);
                 LeftPanel.add(panel7);
                 LeftPanel.add(panel8);
                 LeftPanel.add(panel9);
                 LeftPanel.add(RadSquare);
                 LeftPanel.add(RadTriangular);
                 LeftPanel.add(RadHarmonic);
                
                 
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
        public void getTriangularPlot()
        {
            Double CurrentTime=0.d;
            Double DeltaTime=Time/500.d;
            for(int t=0;t<500;t+=1)
            {
               double T=(double)t+400.d;
               Double F=((Amplitude*Math.abs(2*Math.PI*Math.asin((Math.sin(2*Math.PI*0.5d*Frequency*CurrentTime))))/10));
               Point2D buffPoint = new Point2D.Double(T,F);
               TruePointslist.add(buffPoint);
               CurrentTime+=DeltaTime;
            }
            
        }
        
        public void getRectangularPlot()
        {
            Double CurrentTime=0.d;
            Double DeltaTime = Time/500.d;
            for(int t=0;t<500;t++)
            {
                double T=(double) t+400.d;
                Double F=(Amplitude*Math.signum(Math.sin(2*Math.PI*Frequency*CurrentTime)));
                Point2D buffPoint = new Point2D.Double(T,F);
                TruePointslist.add(buffPoint);
                CurrentTime+=DeltaTime;
            }
            
            
        }
        public void getHarmonicPlot()
        {
            Double CurrentTime=0.d;
            Double DeltaTime = Time/500.d;
            for(int t=0;t<500;t++)
            {
                double T=(double) t+400.d;
                Double F=(Amplitude*Math.cos(2*Math.PI*Frequency*CurrentTime));
                Point2D buffPoint = new Point2D.Double(T,F);
                TruePointslist.add(buffPoint);
                CurrentTime+=DeltaTime;
            }
        }
        public void plotMapping()
        {
            
            for(int i=0;i<TruePointslist.size();i++)
            {
                Double T= TruePointslist.get(i).getX();
                Double F= 130-TruePointslist.get(i).getY()/Amplitude*100;
                Point2D buffPoint = new Point2D.Double(T,F);
                Pointslist.add(buffPoint);
            }
            
        }
        public void ResponseplotMapping()
        {
            for(int i=0;i<TrueResponse.size();i++)
            {
                Double T= TrueResponse.get(i).getX()+150;
                Double F= 400-TrueResponse.get(i).getY();
                Point2D buffPoint = new Point2D.Double(T,F);
                Responselist.add(buffPoint);
            }
        }
        public void getResponse(int InputType)
        {
            // InputType = 1 square wave
            // InputType = 2 triangular wave
            // InputType = 3 harmonic wave
            Double CurrentTime=0.d;
            Double deltaTime=ResponseTime/750.d;
            Double Prev_e=0.d;
            Double Prev_x=0.d;
            Double Prev_U=0.d;
            Double Y=0.d;
            Double X=0.d;
            Point2D buffPoint = new Point2D.Double(Y,Y);
            Prev_e=FunctionValue(InputType,CurrentTime);
            TrueResponse.add(buffPoint);
           for(int i=1;i<=750;i++)
           {
               CurrentTime+=deltaTime;
               Double U = NonlinearElement(Prev_e,FunctionValue(InputType,CurrentTime),Y,Prev_U);
                Prev_U=U;
               Prev_e=FunctionValue(InputType,CurrentTime)-Y;
               Y+=X*deltaTime;
               X+=(1/Tp)*(Kp*U-X)*deltaTime;
               Point2D bufferPoint = new Point2D.Double(i,Y);
               TrueResponse.add(bufferPoint);
               
               
               
           }
             
        }
        
        public Double FunctionValue(int InputType,Double CurrentTime)
        {
            if(CurrentTime>Time) return 0.d;
            if(InputType==1) return (Amplitude*Math.signum(Math.sin(2*Math.PI*Frequency*CurrentTime)));
            
            else if(InputType==2) return (((Amplitude*Math.abs(2*Math.PI*Math.asin((Math.sin(2*Math.PI*0.5d*Frequency*CurrentTime))))/10)));
            
            else return (Amplitude*Math.cos(2*Math.PI*Frequency*CurrentTime));
        }
        
        public Double NonlinearElement(Double prev_e,Double r,Double Y,Double Prev_B)
        {
            Double e = r-Y;
            if(Objects.equals(prev_e, e)) return Prev_B;
            if(e>=-a&&e<=a) return 0.d;
            else if(e>a && e <= b && e<prev_e  ) return B;
            else if(e>a && e<=b && e>=prev_e) return 0.d;
            else if(e>b) return B;
            else if(e<-b) return -B;
            else if(e<-a&&e>-b && e>prev_e) return -B;
            else if(e<-a && e>-b && e<prev_e) return 0.d;
            else return 0.d;
            
            
        }
        
}
