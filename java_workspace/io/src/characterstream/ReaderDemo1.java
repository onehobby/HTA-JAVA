package characterstream;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReaderDemo1 {

	public static void main(String[] args) throws IOException, FileNotFoundException {
		FileReader fr = new FileReader("c:/files/data.txt");
		// 텍스트파일의 내용을 읽어오는건 BufferedReader을 사용한다
		// 텍스트파일을 한줄씩 읽어들어온다 > BufferedReader의 readline을 사용해서 읽어온다.
		BufferedReader br = new BufferedReader(fr);
		
		int totalOrderPrice = 0;
		String text = null;
		while ((text=br.readLine()) != null) {
			if (!text.isEmpty()) {
				String[] items = text.split(",");
				int price = Integer.parseInt(items[4]);
				totalOrderPrice += price;
			}
		}
		System.out.println("총 구매금액: " + totalOrderPrice);
		
		br.close();
		
	}
}
