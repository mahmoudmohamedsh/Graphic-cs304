/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quiz2;

/**
 *
 * @author mahmoud
 */
import com.sun.opengl.util.Animator;
import com.sun.opengl.util.FPSAnimator;
import java.awt.BorderLayout;
import javax.media.opengl.GLCanvas;
import javax.swing.JFrame;

public class WaveApp extends JFrame {

  private Animator animator;
  private GLCanvas glcanvas;
  private WaveGLEventListener listener = new WaveGLEventListener();

  public static void main(String[] args) {
    new WaveApp().animator.start();
  }

  public WaveApp() {
    super("Wave Application");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    glcanvas = new GLCanvas();
    glcanvas.addGLEventListener(listener);
    animator = new FPSAnimator(10);
    animator.add(glcanvas);

    add(glcanvas, BorderLayout.CENTER);
    setSize(700, 500);
    setLocationRelativeTo(this);
    setVisible(true);
  }

}
