package GUI;

import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.text.PlainDocument;

import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.rendering.PDFRenderer;

import service.Parser;

class ViewPanel extends JPanel {
	private List<BufferedImage> images;
	private int imageWidth;
	private int imageHeight;
	private JLabel textField;

    public ViewPanel() {
    	setPreferredSize(new Dimension(Constants.DEFAUT_PANEL_WIDTH, Constants.DEFAUT_PANEL_HEIGHT));
    	textField = new JLabel("No data");
    	add(textField);
    }
    
    public void showText(String content) {
    	textField.setText(content);
    }
    
    public void draw(String path) throws Exception {
		images = Parser.GetPdfComponents(path);
		if (images.size() > 0) {
			imageWidth = images.get(0).getWidth();
			imageHeight = images.get(0).getHeight();
			setPreferredSize(new Dimension(imageWidth, imageHeight * images.size()));
			repaint();
		}
    }
	
	@Override
    protected void paintComponent(Graphics g) {
        if (images != null && images.size() > 0) {
        	super.paintComponent(g);
        	showText("");
        	int widthPosition = (Constants.DEFAUT_PANEL_WIDTH - imageWidth) > 0 ? (Constants.DEFAUT_PANEL_WIDTH - imageWidth)/2 : 0;
            for (int index=0; index<images.size(); index++) {
            	g.drawImage(images.get(index), widthPosition, index * (imageHeight + 10), null);
            }
        }
    }
}