package sort;

import java.util.ArrayList;
import java.util.Collections;

public class SortDemo4 {

	public static void main(String[] args) {
		
		ArrayList<Contact> contacts = new ArrayList<Contact>();
		
		contacts.add(new Contact(10, "류관순", "010-1111-2222", "ryu@gmail.com"));
		contacts.add(new Contact(7, "강감찬", "010-2244-5755", "kang@gmail.com"));
		contacts.add(new Contact(3, "이순신", "010-2242-2127", "lee@gmail.com"));
		contacts.add(new Contact(2, "김유신", "010-5785-2247", "kim@gmail.com"));
		contacts.add(new Contact(1, "윤봉길", "010-8857-5775", "yun@gmail.com"));
		
		Collections.sort(contacts);
		
		for (Contact c : contacts) {
			System.out.println(c.getNo() + ", " + c.getName() + ", " + c.getTel() + ", " + c.getEmail());
		}
	}
}
