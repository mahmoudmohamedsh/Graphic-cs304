/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import static javaapplication1.paintTask.UnxList;
import static javaapplication1.paintTask.UnyList;
import static javaapplication1.paintTask.glcanvas;
import static javaapplication1.paintTask.xList;
import static javaapplication1.paintTask.yList;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;

/**
 *
 * @author mahmoud
 */



public class paintTaskLis
        implements GLEventListener, MouseMotionListener, ActionListener  {
   
    String g = "";
    int xPosition = 50;
    int yPosition = 50;
    float red = 0.0f;
    float green = 0.5f;
    float blue = 0.5f;
    GLCanvas glc;
    

    public void setGLCanvas(GLCanvas glc) {
        this.glc = glc;
    }

    /**
     * Take care of initialization here.
     */
    public void init(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        xList = new ArrayList<Integer>();
        yList = new ArrayList<Integer>();
        UnxList = new  ArrayList<Integer>();
        UnyList = new  ArrayList<Integer>();
        red = 0.5f;
        green = 0.0f;
        blue = 1.0f;
        gl.glClearColor(red, green, blue, 0.0f);
        gl.glViewport(0, 0, 100, 100);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glOrtho(0.0, 100, 0, 100, -1, 1);
    }

    /**
     * Take care of drawing here.
     */
    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        
        
        for(int i = 0; i < xList.size(); i++){
            gl.glPointSize(6.0f);
            red = 1.0f;
            green = 1.0f;
            blue = 1.0f;
            gl.glColor3f(red, green, blue);
            gl.glBegin(GL.GL_POINTS);
            gl.glVertex2i((int)xList.get(i),(int)yList.get(i));
            gl.glEnd();
        
        }
        
        
    }

    /**
     * Called when the GLDrawable (GLCanvas or GLJPanel) has changed in size. We
     * won't need this, but you may eventually need it -- just not yet.
     */
    public void reshape(
            GLAutoDrawable drawable,
            int x,
            int y,
            int width,
            int height
    ) {
    }

    /**
     * If the display depth is changed while the program is running this method
     * is called. Nowadays this doesn't happen much, unless a programmer has his
     * program do it.
     */
    public void displayChanged(
            GLAutoDrawable drawable,
            boolean modeChanged,
            boolean deviceChanged
    ) {
    }
////////////////////////////////////////////
// MouseMotionListener implementation below

    public void mouseDragged(MouseEvent e) {
        double x = e.getX();
        double y = e.getY();
        Component c = e.getComponent();
        double width = c.getWidth();
        double height = c.getHeight();
        
        
        xPosition = (int) ((x / width) * 100);
        yPosition = ((int) ((y / height) * 100));
        
        //reversing direction of y axis
        yPosition = 100 - yPosition;
        xList.add(xPosition);
        yList.add(yPosition);
        glc.repaint();
    }

    public void mouseMoved(MouseEvent e) {
        
    }

  

    @Override
    public void actionPerformed(ActionEvent e) {
        System.err.println(e.getActionCommand());
        
        if(e.getActionCommand().equals("Clear")){
                xList.clear();
                yList.clear();
                UnxList.clear();
                UnyList.clear();
                glc.repaint();
            
        }else if(e.getActionCommand().equals("Undo")){
            if (xList.size() > 10 ){
                    int count = 10;
                    while(count > 0){
                       UnxList.add(xList.remove(xList.size()-count));
                       UnyList.add(yList.remove(yList.size()-count));
                       count-- ;
                    }
                }else{
                    int count = xList.size();
                    while(count > 0){
                        UnxList.add(xList.remove(xList.size()-count));
                        UnyList.add(yList.remove(yList.size()-count));
                        count-- ;
                    }
                }
                glcanvas.repaint();
                
        
        }else if(e.getActionCommand().equals("redo")){
        if (UnxList.size() > 10 ){
                    int count = 10;
                    while(count > 0){
                        xList.add(UnxList.remove(UnxList.size()-count));
                        yList.add(UnyList.remove(UnyList.size()-count));
                        count-- ;
                    }
                }else{
                    
                    int count = UnxList.size();
                    while(count > 0){
                        xList.add(UnxList.remove(UnxList.size()-count));
                        yList.add(UnyList.remove(UnyList.size()-count));
                        count-- ;
                    }
                }
                glcanvas.repaint();
             
        }else if (e.getActionCommand().equals("color")){
            
        }
    }

   
}

