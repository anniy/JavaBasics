package intro;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Font;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class GeneratePDF {
	public static void main(String[] args) throws DocumentException, IOException {
		Document document = new Document();
		
		BaseFont baseFont = BaseFont.createFont("lib/Serif.ttf", BaseFont.IDENTITY_H, true);
		Font redFont = new Font(baseFont, 20, Font.NORMAL, BaseColor.RED);
		Font blackFont = new Font(baseFont, 20, Font.NORMAL, BaseColor.BLACK);
		Font baseColor;
		
		Object[] card = new Object[] {2, 3, 4, 5, 6, 7, 8, 9, 10, 'Q', 'J', 'K', 'A'};
		char[] cardSuit = {'\u2663', '\u2666', '\u2665', '\u2660'};

		try {
			PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("Deck-of-Cards.pdf"));
			document.open();
			
			for (int i = 0; i < card.length; i++) {
				
				PdfPTable table = new PdfPTable(7);
				table.setWidthPercentage(50f);
				table.setWidths(new float[] { 5, 2, 5, 2, 5, 2, 5 });
				
				PdfPCell cell;
				
				for (int j = 0; j < cardSuit.length; j++) {
					if (j == 1 || j == 2) {
						baseColor = redFont;	
					}
					else {
						baseColor = blackFont;			
					}
					
					cell = new PdfPCell(new Phrase(card[i].toString() + cardSuit[j], baseColor));
					cell.setFixedHeight(100f);
					cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
					cell.setHorizontalAlignment(Element.ALIGN_CENTER);
					table.addCell(cell);
					
					cell = new PdfPCell();
					cell.setBorder(0);
					table.addCell(cell);
				} 
				table.setSpacingBefore(20);
				table.setSpacingAfter(10);
				document.add(table);
			}
		    document.close();
		    writer.close();
			} catch (DocumentException e)
			{
				e.printStackTrace();
			} catch (FileNotFoundException e)
			{
				e.printStackTrace();
			}
	}
}
