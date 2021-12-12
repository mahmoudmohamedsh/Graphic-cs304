/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;



public class squaretaskeventlist implements GLEventListener{

    @Override
    public void init(GLAutoDrawable gld) {
       GL gl = gld.getGL();
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
//        gl.glLineWidth(2.0f);
        gl.glPointSize(2.0f);
        gl.glViewport(-250, -250, 250, 250);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glOrtho(-250.0, 250.0, -250.0, 250.0, -1.0, 1.0);
    }

    @Override
    public void display(GLAutoDrawable gld) {
        GL gl = gld.getGL();
        float red;
        float green;
        float blue;

        red = 1.0f;
        green = 0.2f;
        blue = 0.2f;
        
        gl.glColor3f(red, green, blue);
        red = 0.2f;
        green = 0.2f;
        blue = 0.2f;
        gl.glColor3f(red, green, blue);
        
        this.drawrec(gl, -250, 250, 100, 100);
        
       
    }
    public void drawrec(GL gl,int x, int y ,int width , int height){
        float red = 0.2f;
        float green = 0.2f;
        float blue = 0.2f;
        gl.glColor3f(red, green, blue);
        gl.glBegin(GL.GL_LINES);
     for(int j = 0 ; j  < height ; j++){
         System.out.println("x" + x +" y " +j);
         gl.glVertex2d(x, y -j);
         gl.glVertex2d(x+width, y -j);
     }   
     gl.glEnd();
    }
    @Override
    public void reshape(GLAutoDrawable glad, int i, int i1, int i2, int i3) {
        }

    @Override
    public void displayChanged(GLAutoDrawable glad, boolean bln, boolean bln1) {
        }
    
}
