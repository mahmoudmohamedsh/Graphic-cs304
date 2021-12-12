/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package graph;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLEventListener;

/**
 *
 * @author H S
 */
class GraphGLEventListener implements GLEventListener {

    public String whatToDraw = "sine";
    GLCanvas glc;
    int xPosition = 50;
    int yPosition = 50;

    public void setGLCanvas(GLCanvas glc) {
        this.glc = glc;
    }

    public void init(GLAutoDrawable gld) {
        GL gl = gld.getGL();
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
//        gl.glLineWidth(2.0f);
        gl.glPointSize(2.0f);
        gl.glViewport(-250, -150, 250, 150);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        gl.glOrtho(-250.0, 250.0, -150.0, 150.0, -1.0, 1.0);
    }

    /**
     * Take care of drawing here.
     */
    public void display(GLAutoDrawable gld) {
        GL gl = gld.getGL();
        drawGraph(gl);
//This is the new code. We find out
//which trig function is selected,
//then we draw a scaled up version of
//the function.
        float red;
        float green;
        float blue;
////////////////////
//drawing the grid
        red = 1.0f;
        green = 0.2f;
        blue = 0.2f;
        gl.glColor3f(red, green, blue);
        gl.glBegin(GL.GL_POINTS);
        if (whatToDraw.equals("sine")) {
//draw enlarged sine function
            for (int x = -250; x < 250; x++) {
                gl.glVertex2d(x, (Math.sin(x / 60.0) * 100.0));
            }
        } else if (whatToDraw.equals("cosine")) {
//draw enlarged cosine function
            for (int x = -250; x < 250; x++) {
                gl.glVertex2d(x, (Math.cos(x / 60.0) * 100.0));
            }
        } else if (whatToDraw.equals("tangent")) {
//draw enlarged tangent function
            for (int x = -250; x < 250; x++) {
                gl.glVertex2d(x, (Math.tan(x / 60.0) * 30.0));
            }
        }
        gl.glEnd();
    }

    public void reshape(
            GLAutoDrawable drawable,
            int x,
            int y,
            int width,
            int height
    ) {
    }

    public void displayChanged(
            GLAutoDrawable drawable,
            boolean modeChanged,
            boolean deviceChanged
    ) {
    }

    private void drawGraph(GL gl) {
        float red;
        float green;
        float blue;
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
////////////////////
//drawing the grid
        red = 0.2f;
        green = 0.2f;
        blue = 0.2f;
        gl.glColor3f(red, green, blue);
//You may notice I'm using GL_LINES here.
//Details of glBegin() will be discussed latter.
        gl.glBegin(GL.GL_LINES);
//draw the vertical lines
        for (int x = -250; x <= 250; x += 10) {
            gl.glVertex2d(x, -150);
            gl.glVertex2d(x, 150);
        }
//draw the horizontal lines
        for (int y = -150; y <= 150; y += 10) {
            gl.glVertex2d(-250, y);
            gl.glVertex2d(250, y);
        }
        gl.glEnd();
//////////////////////////////
// draw the x-axis and y-axis
        red = 0.0f;
        green = 0.2f;
        blue = 0.4f;
        gl.glColor3f(red, green, blue);
        gl.glBegin(GL.GL_LINES);
//line for y-axis
        gl.glVertex2d(0, 140);
        gl.glVertex2d(0, -140);
//line for x-axis
        gl.glVertex2d(240, 0);
        gl.glVertex2d(-240, 0);
        gl.glEnd();
/////////////////////
// draw arrow heads
        gl.glBegin(GL.GL_TRIANGLES);
        gl.glVertex2d(0, 150);
        gl.glVertex2d(-5, 140);
        gl.glVertex2d(5, 140);
        gl.glVertex2d(0, -150);
        gl.glVertex2d(-5, -140);
        gl.glVertex2d(5, -140);
        gl.glVertex2d(250, 0);
        gl.glVertex2d(240, -5);
        gl.glVertex2d(240, 5);
        gl.glVertex2d(-250, 0);
        gl.glVertex2d(-240, -5);
        gl.glVertex2d(-240, 5);
        gl.glEnd();
    }

}
