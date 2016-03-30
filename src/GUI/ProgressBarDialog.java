package GUI;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class ProgressBarDialog extends JDialog {
	private JFrame parent;
    private JLabel label;

    public ProgressBarDialog(JFrame frame) {
    	parent = frame;
    	label = new JLabel("Loading ...");
    }
    
    public void createUI() {
    	setLayout(new GridBagLayout());
        add(label);
    	setSize(new Dimension(160, 100));
        setAlwaysOnTop(true);
        setLocationRelativeTo(parent);
        setUndecorated(true);
        setVisible(true);
        paint(this.getGraphics());
    }
    
    public void close() {
        setVisible(false);
    }
}