package net.moetang.nekocore.util.compare;

public interface Compare {
	public <T> boolean compare(T[] array1, T[] array2);
	public <T> boolean compare(T[] array1, int offset1, T[] array2, int offset2, int length);
	public <T> boolean deepCompare(T[] array1, T[] array2);
	public <T> boolean deepCompare(T[] array1, int offset1, T[] array2, int offset2, int length);
	public <T> int compare(int[] array1, int[] array2);
	public <T> int compare(int[] array1, int offset1, int[] array2, int offset2, int length);
	public <T> int compare(long[] array1, long[] array2);
	public <T> int compare(long[] array1, int offset1, long[] array2, int offset2, int length);
	public <T> int compare(byte[] array1, byte[] array2);
	public <T> int compare(byte[] array1, int offset1, byte[] array2, int offset2, int length);
	public <T> int compare(short[] array1, short[] array2);
	public <T> int compare(short[] array1, int offset1, short[] array2, int offset2, int length);
	public <T> int compare(char[] array1, char[] array2);
	public <T> int compare(char[] array1, int offset1, char[] array2, int offset2, int length);
	public <T> int compare(double[] array1, double[] array2);
	public <T> int compare(double[] array1, int offset1, double[] array2, int offset2, int length);
	public <T> int compare(float[] array1, float[] array2);
	public <T> int compare(float[] array1, int offset1, float[] array2, int offset2, int length);
}
