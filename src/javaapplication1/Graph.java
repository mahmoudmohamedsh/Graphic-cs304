package graph;

import java.awt.*;
import java.awt.event.*;
import javax.media.opengl.*;
import javax.swing.*;

public class Graph extends JFrame implements ActionListener {

    GraphGLEventListener listener = new GraphGLEventListener();
    GLCanvas glcanvas;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
       new Graph();
    }

    public Graph() {
//set the JFrame title
        super("Sine, Cosine and Tangent");
//kill the process when the JFrame is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//Setting up our southern JPanel with JRadioButtons
        JPanel jp = new JPanel();
        ButtonGroup bg = new ButtonGroup();
//setting up the sine JRadioButton
        JRadioButton jrb1 = new JRadioButton("Sine", true);
        jrb1.setActionCommand("sine");
        jrb1.addActionListener(this);
//setting up the cosine JRadioButton
        JRadioButton jrb2 = new JRadioButton("Cosine");
        jrb2.setActionCommand("cosine");
        jrb2.addActionListener(this);
//setting up the tangent JRadioButton
        JRadioButton jrb3 = new JRadioButton("Tangent");
        jrb3.setActionCommand("tangent");
        jrb3.addActionListener(this);
        bg.add(jrb1);
        bg.add(jrb2);
        bg.add(jrb3);
        //bg.add(jrb4);
//adding the buttons to the JPanel
        jp.add(jrb1);
        jp.add(jrb2);
        jp.add(jrb3);
        getContentPane().add("South", jp);
//only three JOGL lines of code ... and here they are
        glcanvas = new GLCanvas();
        GLDrawableFactory.getFactory();
        glcanvas.addGLEventListener(listener);
//glcanvas.addMouseMotionListener(listener);
//add the GLCanvas just like we would any Component
        getContentPane().add(glcanvas, BorderLayout.CENTER);
        setSize(500, 300);
//center the JFrame on the screen
        setLocationRelativeTo(this);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        listener.whatToDraw = ae.getActionCommand();
        glcanvas.repaint();
    }
}
