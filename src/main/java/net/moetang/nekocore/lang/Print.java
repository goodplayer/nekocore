package net.moetang.nekocore.lang;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Print {
	private final static void write(String src, Writer out){
		try {
			out.write(src);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static <T> void printArray(T[] arr){
		printArray(arr, System.out);
	}
	public static <T> void printArray(T[] arr, OutputStream out){
		printArray(arr, new OutputStreamWriter(out));
	}
	public static <T> void printArray(T[] arr, Writer out){
		if(Check.hasElements(arr)){
			StringBuilder sb = new StringBuilder();
			sb.append("[ ");
			sb.append(arr[0]);
			if(arr.length > 1){
				for(int i = 1; i < arr.length; i++){
					sb.append(", "+arr[i]);
				}
			}
			sb.append(" ]"+System.lineSeparator());
			write(sb.toString(), out);
		}else{
			write("[]"+System.lineSeparator(), out);
		}
	}
	public static <T> void printList(List<?> list){
		printList(list, System.out);
	}
	public static <T> void printList(List<?> list, OutputStream out){
		printList(list, new OutputStreamWriter(out));
	}
	public static <T> void printList(List<?> list, Writer out){
		if(Check.hasElements(list)){
			printIterable(list, out);
		}else{
			write("[]"+System.lineSeparator(), out);
		}
	}
	public static <T> void printSet(Set<?> set){
		printSet(set, System.out);
	}
	public static <T> void printSet(Set<?> set, OutputStream out){
		printSet(set, new OutputStreamWriter(out));
	}
	public static <T> void printSet(Set<?> set, Writer out){
		if(Check.hasElements(set)){
			printIterable(set, out);
		}else{
			write("[]"+System.lineSeparator(), out);
		}
	}
	protected static <T> void printIterable(Iterable<?> iterElem, Writer out){
		StringBuilder sb = new StringBuilder();
		sb.append("[ ");
		Iterator<?> iter = iterElem.iterator();
		if(iter.hasNext()){
			sb.append(iter.next());
		}
		while(iter.hasNext()){
			sb.append(", "+iter.next());
		}
		sb.append(" ]"+System.lineSeparator());
		write(sb.toString(), out);
	}
}
