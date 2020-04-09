package bytestream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.apache.commons.io.IOUtils;

public class FileCopyDemo7 {

	public static void main(String[] args) throws IOException {
		
		URL url = new URL("https://img1.daumcdn.net/thumb/R658x0.q70/?fname=https://t1.daumcdn.net/news/202004/09/newsen/20200409083920721famh.jpg");
		
		InputStream is = url.openStream();
		FileOutputStream fos = new FileOutputStream("c:/files/고수정.jpg");
		
		IOUtils.copy(is, fos);
		
	}
}
