package qtb.eks.tg;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 
 * @author lalverma
 *
 * 
 */

@RestController
public class ThumbnailGenerationService {
	
	private static Logger logger = 
			LoggerFactory.getLogger(ThumbnailGeneratorV1Application.class);

	/**
	 * 
	 * @param file
	 * @return
	 * @throws IOException

	 * 					   access it locally	
	 *                     curl -F 'file=$filepath' http://localhost:8080/thumbnail/generate/v1
	 *                                          
	 */

	@PostMapping(value = "/thumbnail/generate/basic/v1", produces = MediaType.IMAGE_JPEG_VALUE)
	public @ResponseBody byte[] generateThumbnail(@RequestParam("file") MultipartFile file) {
		byte[] thumbnailBytes = null;
		if (file == null) {
			logger.error("input image not found");
			return null;
		}

		try {
			logger.info("thumbnail generation started - name:" + file.getOriginalFilename()
			+ ", type:" + file.getContentType());

			ThumbnailCreator tc = new ThumbnailCreator();
			thumbnailBytes = tc.createThumbnail(file.getInputStream());

		} catch (IOException e) {
			logger.error("error occurred while processing thumbnail generation for " + file.getOriginalFilename(),e);
		}
		logger.info("thumbnail generation stopped - name:" + file.getOriginalFilename()
				+ ", type:" + file.getContentType());
		return thumbnailBytes;
	}


}

