package qtb.eks.tg;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThumbnailCreator {
	private static Logger logger = LoggerFactory.getLogger(ThumbnailCreator.class);	

	public byte[] createThumbnail(InputStream is) throws IOException {
		BufferedImage inputImage = ImageIO.read(is);
		logger.info("input image dimensions - w:"+inputImage.getWidth()+",h:"+inputImage.getHeight());
				
		Image scaledImg = inputImage.getScaledInstance(100, 100, BufferedImage.SCALE_SMOOTH);
		BufferedImage thumbnailbi = new BufferedImage(100, 100, BufferedImage.TYPE_INT_RGB);
		thumbnailbi.createGraphics().drawImage(scaledImg,0,0,null);
                
		logger.info("output image size - w:"+thumbnailbi.getWidth()+",h:"+thumbnailbi.getHeight());
		
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		ImageIO.write(thumbnailbi, "jpg", baos);
		return baos.toByteArray();
	}

}
