package generarQR;

import java.awt.image.BufferedImage;
import java.io.FileOutputStream;

import javax.imageio.ImageIO;

//librerias de google para generar QRs
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class GeneradorQR {
	 
    // Propiedades de la imagen QR
    private static final int qrAncho = 400;
    private static final int qrAltura = 400;
    //Formato en el escupe el QR, en este caso es una foto, en .txt no se lee una mierda
    private static final String formato = "png";
    //URL completa para cada lote
    private static String path;
 
    //Prueba con un array de lotes (hay que cambiarlo por los lotes buenos)
    private static String[] lotes={"accounts", "device", "search?q=cars"};
    
    //Metemos a dónde te lleva el QR, metemos en él el path
    private static FileOutputStream qrCode;
    
	public static void main(String[] args) throws Exception {
 
        // URL que vamos a transformar al que le añadimos /IDlote
        String URL = "http://www.google.com";
        
 
        // Pasar de URL a formato QR
        BitMatrix[] matrix = new BitMatrix[lotes.length];
        Writer writer = new QRCodeWriter();
        try {
        	//Va haciendo una matriz para cada lote y lo almacena en un array de matrices
        	for(int i = 0; i < lotes.length; i++){
        		matrix[i] = writer.encode((URL + "/" + lotes[i]), BarcodeFormat.QR_CODE, qrAncho, qrAltura);
        	}
 
        } catch (WriterException e) {
            e.printStackTrace(System.err);
            return;
        }
 
        // BufferedImage en la que vamos a pintar
        BufferedImage image = new BufferedImage(qrAncho, qrAltura, BufferedImage.TYPE_INT_RGB);
        
        
        // Iteramos sobre la matriz para dibujar los pixeles de la imagen (x,y)
		for (int i = 0; i < lotes.length; i++) {
			for (int y = 0; y < qrAltura; y++) {
				for (int x = 0; x < qrAncho; x++) {
					int grayValue = (matrix[i].get(x, y) ? 0 : 1) & 0xff;
					image.setRGB(x, y, (grayValue == 0 ? 0 : 0xFFFFFF));
				}
			}
			
			path = "C:\\Users\\Laura Colomer\\Documents\\qrcode" + i + ".png";
			qrCode = new FileOutputStream(path);
			
			//ESTO es lo que escupe los QRs
			ImageIO.write(image, formato, qrCode);
		}
        
        qrCode.close();
    }
}
