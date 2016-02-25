
package simplegui;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author shakeel
 */
public class SimpleGui {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> { // lambda expression :)
            BaseJFrame gui = new BaseJFrame();
            gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            gui.setResizable(false);
            gui.pack();
            gui.setVisible(true);
            //To change body of generated methods, choose Tools | Templates.
        });
    }
    
}
