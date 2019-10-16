package principal;

import java.io.File;  
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;


public class Ler {

	public static void main(String[] args) throws IOException {

        File file = new File("c:\\temp\\fatura.pdf");

        try (PDDocument document = PDDocument.load( file )) {

            if (!document.isEncrypted()) {
			
                PDFTextStripperByArea stripper = new PDFTextStripperByArea();
                stripper.setSortByPosition(true);

                PDFTextStripper tStripper = new PDFTextStripper();

                String pdfFileInText = tStripper.getText(document);

                String lines[] = pdfFileInText.split("\\r?\\n");
                for (String line : lines) {
                    System.out.println(line);
                }
            }
        }
    }
}


/*String caminho = javax.swing.JOptionPane.showInputDialog(“digite o diretorio a ser listado”);
StringBuilder sb = new StringBuilder();

	File raiz = new File(caminho);
	
	for(File f: raiz.listFiles()) {
		if(f.isFile()) {
			System.out.println(f.getName());
			sb.append(f.getName());
			sb.append("\n");
		}
	}
	javax.swing.JOptionPane.showMessageDialog(null, sb.toString());
}*/