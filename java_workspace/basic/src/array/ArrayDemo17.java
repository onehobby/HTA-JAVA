package array;

import java.util.Arrays;

public class ArrayDemo17 {

	public static void main(String[] args) {
		
		int[] numbers = {10, 29, 1, 5, 23, 75, 31};
		Arrays.sort(numbers);						// 배열의 element를 오름차순으로 정렬
		
		Arrays.toString(numbers);					// numbers배열은 문자열로 변환해서 반환
		
		String text = Arrays.toString(numbers);
		System.out.println(text);

		String[] names = {"이순신", "김유신", "강감찬","류관순","안중근"};
		Arrays.parallelSort(names);
		System.out.println(Arrays.toString(names));
		
		// 배열을 복사하기
//		Arrays.copyOf(원본배열, 복사할값의 갯수);
//		Arrays.copyOfRange(원본배열, 복사시작위치, 복사끝위치)
		
		numbers = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		
		int[] arr1 = Arrays.copyOf(numbers, 10);			// numbers배열에서 순서대로 10개까지만 copy해라
		int[] arr2 = Arrays.copyOf(numbers, 5);				// numbers배열에서 순서대로 5개까지만 copy해라
		System.out.println(Arrays.toString(arr1));
		System.out.println(Arrays.toString(arr2));
		
		int[] arr3 = Arrays.copyOfRange(numbers, 0, 3);		// numbers배열에서 0번째부터 3번째까지 복사, 0,3일때 0,1,2만 가져온다. 3번째 index에 있는 값은 가져오지않음.
		int[] arr4 = Arrays.copyOfRange(numbers, 4, 7);		// numbers배열에서 4번째부터 7번째까지 복사
		int[] arr5 = Arrays.copyOfRange(numbers, 0, numbers.length);		// numbers배열에서 0번째부터 9번째까지 복사
		System.out.println(Arrays.toString(arr3));
		System.out.println(Arrays.toString(arr4));
		System.out.println(Arrays.toString(arr5));
		
		
	}
}
