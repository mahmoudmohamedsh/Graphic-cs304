/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLEventListener;

/**
 *
 * @author mahmoud
 */

public class BoxTaskMainLis implements GLEventListener {
   int n=10;
     public static int scaleXValue = 0;
     public static int scaleYValue = 0;

    @Override
    public void init(GLAutoDrawable glAutoDrawable) {
        GL gl = glAutoDrawable.getGL();

        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);

        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();

        gl.glOrtho(0.0, 2000.0, 0.0, 2000, -1.0, 1.0);

    }

    @Override
    public void display(GLAutoDrawable glAutoDrawable) {

        drawGraph(glAutoDrawable.getGL());
        int x=0;
        int y=0;

        GL gl = glAutoDrawable.getGL();


        for ( x=0;x<scaleXValue*100;x+=100){
            for ( y=0;y<scaleYValue*100;y+=100){
                gl.glColor3f(1.0f,1.0f,1.0f);
                gl.glBegin(GL.GL_TRIANGLES);
                gl.glVertex2i(x,y);
                gl.glVertex2i(x,y+100);
                gl.glVertex2i(x+100,y+100);
                gl.glEnd();
                
                gl.glColor3f(0.5f,0.5f,0.5f);
                gl.glBegin(GL.GL_TRIANGLES);
                
                
                gl.glVertex2i(x+100,y+100);
                gl.glVertex2i(x+100,y);
                gl.glVertex2i(x,y);
                
                gl.glEnd();
                gl.glColor3f(0.0f,0.45f,0.45f);
                gl.glBegin(GL.GL_POLYGON);
                gl.glVertex2i(x+10,y+10);
                gl.glVertex2i(x+90,y + 10);
                gl.glVertex2i(x+90,y+90);
                gl.glVertex2i(x+10,y+90);
                gl.glEnd();
            }
        }









    }

    @Override
    public void reshape(GLAutoDrawable glAutoDrawable, int i, int i1, int i2, int i3) {

    }

    @Override
    public void displayChanged(GLAutoDrawable glAutoDrawable, boolean b, boolean b1) {

    }

     private void drawGraph(GL gl) {
         float red;
         float green;
         float blue;
         gl.glClear(GL.GL_COLOR_BUFFER_BIT);
         red = 0.2f;
         green = 0.2f;
         blue = 0.2f;

         gl.glColor3f(red, green, blue);
         gl.glBegin(GL.GL_LINES);
         for (int x = 0; x <= 2000; x += 100) {
             gl.glVertex2d(x, 0);
             gl.glVertex2d(x, 2000);
         }
         for (int y = 0; y <= 2000; y += 100) {
             gl.glVertex2d(0, y);
             gl.glVertex2d(2000, y);
         }

         gl.glEnd();
         
     }


}
