package etc;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo {
	
	public static void main(String[] args) throws IOException {
		
		Properties prop = new Properties();
		prop.load(new FileReader("src/config.properties"));
		
		String url = prop.getProperty("host.url");
		String port = prop.getProperty("host.port");
		String username = prop.getProperty("host.username");
		String password = prop.getProperty("host.password");
		
		System.out.println("URL    : " + url );
		System.out.println("PORT번호: " + port );
		System.out.println("아  이  디: " + username);
		System.out.println("비밀 번호 : " + password);
		
	}
}
