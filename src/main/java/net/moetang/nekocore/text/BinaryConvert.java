package net.moetang.nekocore.text;

import net.moetang.nekocore.lang.BytesUtil;
import net.moetang.nekocore.lang.Chars;


public class BinaryConvert {
	/**
	 * NOTE: 结果顺序为字节数组第一个字节的最低位在字符串的开头，其他依次转换<br />
	 * 即little-endian
	 * @param src 字节数组
	 * @return 二进制数字字符串,中间以空格分隔各个字节
	 */
	public final static String toBinary(byte[] src){
		return toLittleEndianBinary(src);
	}
	
	protected final static String toBigEndianBinary(byte[] src) {
		if(src.length == 1){
			return Chars.BYTE_BIG_ENDIAN[src[0]&0xff];
		}else{
			StringBuffer sb = new StringBuffer(src.length*9-1);
			sb.append(Chars.BYTE_BIG_ENDIAN[src[0]&0xff]);
			for(int i = 1; i < src.length; i++){
				sb.append(" "+Chars.BYTE_BIG_ENDIAN[src[i]&0xff]);
			}
			return sb.toString();
		}
	}
	protected final static String toLittleEndianBinary(byte[] src) {
		if(src.length == 1){
			return Chars.BYTE_LITTLE_ENDIAN[src[0]&0xff];
		}else{
			StringBuffer sb = new StringBuffer(src.length*9-1);
			sb.append(Chars.BYTE_LITTLE_ENDIAN[src[0]&0xff]);
			for(int i = 1; i < src.length; i++){
				sb.append(" "+Chars.BYTE_LITTLE_ENDIAN[src[i]&0xff]);
			}
			return sb.toString();
		}
	}
	
	/**
	 * NOTE: 低位在字符串最后一位
	 * @param src
	 * @return
	 */
	public final static String toBinary(byte src){
		return Chars.BYTE_BIG_ENDIAN[src&0xff];
	}
	/**
	 * NOTE: 低位在字符串最后一位
	 * @param src
	 * @return
	 */
	public final static String toBinary(short src){
		return toBigEndianBinary(BytesUtil.shortToBytes(src, true));
	}
	/**
	 * NOTE: 低位在字符串最后一位
	 * @param src
	 * @return
	 */
	public final static String toBinary(int src){
		return toBigEndianBinary(BytesUtil.intToBytes(src, true));
	}
	/**
	 * NOTE: 低位在字符串最后一位
	 * @param src
	 * @return
	 */
	public final static String toBinary(long src){
		return toBigEndianBinary(BytesUtil.longToBytes(src, true));
	}
}
