
package MyCustom;

import java.awt.LayoutManager;
import javax.swing.JPanel;

/**
 *
 * @author Admin
 */
public class TransparentPanel extends JPanel {
    public TransparentPanel() {
        this.setOpaque(false);
    }
    
    public TransparentPanel(LayoutManager layout) {
        this.setLayout(layout);
    }
}
