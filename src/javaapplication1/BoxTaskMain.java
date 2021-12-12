/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.media.opengl.GLCanvas;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author mahmoud
 */

public class BoxTaskMain extends JFrame implements ActionListener {
    GLCanvas glcanvas;
    private BoxTaskMainLis listener = new BoxTaskMainLis();
    private JButton n = new JButton("create");

    private JTextField no_x = new JTextField(3);
    private JTextField no_y = new JTextField(3);

    public static void main(String[] args) {


        new BoxTaskMain();
}
    public  BoxTaskMain(){
        super("boxes");
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout());
        jPanel.add(no_x);
        jPanel.add(no_y);
        jPanel.add(n);


        glcanvas = new GLCanvas();
        glcanvas.addGLEventListener(new BoxTaskMainLis());
        add(glcanvas, BorderLayout.CENTER);
        add(jPanel,BorderLayout.NORTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 800);
        setLocationRelativeTo(this);
        setVisible(true);
        n.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource().equals(n)){
                listener.scaleXValue = Integer.parseInt(no_x.getText());
                listener.scaleYValue = Integer.parseInt(no_y.getText());
                glcanvas.repaint();
                
            }

        }catch (Exception ex){
            System.err.println(ex.getMessage());
        }


    }

    
}