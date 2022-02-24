package qtb.eks.tg;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestThumbnailCreator {

	private static InputStream validImageStream;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		File file = new File("/Users/lalverma/Documents/soni/anhad/birthday/anhad_2/1.jpg");
		validImageStream = new FileInputStream(file);
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() throws IOException {
		ThumbnailCreator tc = new ThumbnailCreator();
		byte[] imageBytes = tc.createThumbnail(validImageStream);				
		assertNotNull(imageBytes);	
		assertTrue(imageBytes.length>0);	
	}

}
