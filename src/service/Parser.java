package service;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.PDFRenderer;

public class Parser {

   public static ArrayList<BufferedImage> GetPdfComponents(String path) throws Exception {
		PDDocument pDoc;
		ArrayList<BufferedImage> images = new ArrayList<BufferedImage>();
		pDoc = PDDocument.load(new File(path));
		PDFRenderer render = new PDFRenderer(pDoc);
		int pageNum = pDoc.getNumberOfPages();
		images = new ArrayList<BufferedImage>();
		for (int index=0; index<pageNum; index++) {
			images.add(render.renderImage(index));
		}
		pDoc.close();
		return images;
   }
}
