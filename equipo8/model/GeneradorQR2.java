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

//Librerias para pasar png-blob y blob-png
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
 

public class GeneradorQR2 {
 
    // Propiedades de la imagen
    private static final int ancho = 400;
    private static final int alto = 400;
    private static final String formato = "png";
    private static String path;
    
    //Para pasar a blob
    private static ByteArrayOutputStream bos = new ByteArrayOutputStream();
    	
    //Método al que le pasas el id del lote como parámetro
    public static void generadorQR(int id) throws Exception{
    	
        // URL a la que luego le añadiremos el /id
        String data = "http://www.google.com";
        
        //a dónde escupe el qr
        path = "C:\\Users\\Laura Colomer\\Documents\\qrcode" + id + ".png";
 
        // Pasar la URL a QR
        BitMatrix matrix;
        Writer writer = new QRCodeWriter();
        try {
 
            matrix = writer.encode((data + "/" + id), BarcodeFormat.QR_CODE, ancho, alto);
 
        } catch (WriterException e) {
            e.printStackTrace(System.err);
            return;
        }
 
        // Crea Buffered image en la que pintaremos en el QR
        BufferedImage image = new BufferedImage(ancho, alto, BufferedImage.TYPE_INT_RGB);
 
        // Iterate pixel a pixel (x,y) por la matriz para pintar
        for (int y = 0; y < alto; y++) {
            for (int x = 0; x < ancho; x++) {
                int grayValue = (matrix.get(x, y) ? 0 : 1) & 0xff;
                image.setRGB(x, y, (grayValue == 0 ? 0 : 0xFFFFFF));
            }
        }
 
        // Escupe la imagen a mis documentos
        FileOutputStream qrCode = new FileOutputStream(path);
        ImageIO.write(image, formato, qrCode);
        
        //ESTO escribe los QRs en blob
		ImageIO.write(image, "png",  bos);
	    byte [] binarioURL = bos.toByteArray();
		System.out.println(binarioURL);
		
		// Convertir los blobs a png
		InputStream in = new ByteArrayInputStream(binarioURL);
		BufferedImage bImageFromConvert = ImageIO.read(in);
		ImageIO.write(bImageFromConvert, formato, qrCode);
 
        qrCode.close();
 
    }
 
}
