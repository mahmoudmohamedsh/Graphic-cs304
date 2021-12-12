/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;

/**
 *
 * @author mahmoud
 */


public class EventListenerSectionCodeLis implements GLEventListener , KeyListener , MouseListener,MouseMotionListener{
    GLCanvas glc = null;
    int out_of_canvas = -500;
    double x_start_position = out_of_canvas;
    double y_start_position = out_of_canvas;
    double x_end_position = out_of_canvas;
    double y_end_position = out_of_canvas;

    
    public void setGLCanvas(GLCanvas glc){//use to get the glc to call repaint function
        this.glc = glc ;
    }
    @Override
    public void init(GLAutoDrawable gld) {
        GL gl = gld.getGL();
        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        gl.glViewport(0, 0, 500, 300);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glOrtho(0.0, 500.0, 0.0, 300.0, -1.0, 1.0);
    }

    @Override
    public void display(GLAutoDrawable drawable) {
       GL gl = drawable.getGL();
       gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        float red = 0.5f;
        float green = 0.0f;
        float blue = 0.5f;
        gl.glColor3f(red, green, blue);
        if(x_start_position != out_of_canvas && x_end_position != out_of_canvas){
                gl.glBegin(GL.GL_LINES);
                gl.glVertex2d(x_start_position, y_start_position);
                gl.glVertex2d(x_end_position,y_end_position);
                gl.glEnd();
                
                gl.glBegin(GL.GL_LINES);
                //left
                gl.glVertex2d(x_start_position, y_start_position);
                gl.glVertex2d(x_start_position,y_end_position);
                //down
                gl.glVertex2d(x_end_position, y_end_position);
                gl.glVertex2d(x_start_position,y_end_position);
                //left
                gl.glVertex2d(x_end_position, y_end_position);
                gl.glVertex2d(x_end_position,y_start_position);
                
                //top
                gl.glVertex2d(x_end_position, y_start_position);
                gl.glVertex2d(x_start_position,y_start_position);
                gl.glEnd();
                double x = Math.abs((x_end_position - x_start_position)/2) + Double.min(x_start_position, x_end_position);
                double y = Math.abs((y_end_position - y_start_position)/2) + Double.min(y_start_position, y_end_position);
                //((y_end_position - y_start_position)/2)
                //((x_end_position - x_start_position)/2)
                double radius = Double.min(Math.abs(((y_end_position - y_start_position)/2)),Math.abs(((x_end_position - x_start_position)/2))  );
                drawCircle(gl,x,y,radius);
                System.out.println(radius);
        }
        
    }
    public void drawCircle(GL gl,double x1,double y1 , double radius){
        final double ONE_DEGREE = (Math.PI / 180);
        final double THREE_SIXTY = 2 * Math.PI;
        double x = 0 , y = 0;
        
        gl.glBegin(GL.GL_LINES);
        for (double a = 0;
                a < THREE_SIXTY;
                a += ONE_DEGREE) {
            x = radius * (Math.cos(a));
            y = radius * (Math.sin(a));
            gl.glVertex2d(x + x1, y +y1);
        }
        gl.glEnd();
    }
    @Override
    public void reshape(GLAutoDrawable glad, int i, int i1, int i2, int i3) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void displayChanged(GLAutoDrawable glad, boolean bln, boolean bln1) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        System.out.println("click");
    }

    @Override
    public void mousePressed(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        x_start_position = out_of_canvas;
        x_end_position = out_of_canvas;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseDragged(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       double x = e.getX();
       double y = e.getY();
       Component c = e.getComponent();
       double width = c.getWidth();
       double height = c.getHeight();
       if(x_start_position < 0){
           x_start_position = (int) ( (x/width) * 500 );
           y_start_position = (int)(300 -  ( (y/height) * 300 ) );
       }
       x_end_position = (int) ( (x/width) * 500 );
       y_end_position = (int)(300 -  ( (y/height) * 300 ) );
       glc.repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}