package net.moetang.nekocore.lang;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class PrintTest {
	@Test
	public void testPrintArray(){
		Print.printArray(new Integer[]{1, 2, 3});
		Print.printArray(new Integer[0]);
		Print.printList(new ArrayList<>());
		Print.printArray(null);
		Print.printList(null);
		List<String> list = new ArrayList<>();
		list.add("hello");
		list.add("no");
		list.add("new");
		Print.printList(list);
	}
}
