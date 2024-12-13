package ro.emanuel.cantece.helper;

import java.util.ArrayList;
import java.util.List;

public class TestDebugging {

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>();
		for (Integer i = 0; i < 10; i++) {
			numbers.add(i);
		}

		showAll(numbers);
	}

	public static void showAll(List<Integer> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}
}
