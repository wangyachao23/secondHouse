package JDBC;
/*
 * 用于判断是否为空
 */

public class StringUtil {
	public static boolean isEmpty(String str) {
		if("".equals(str)||str==null) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static boolean isNotEmpty(String st) {
		if("".equals(st)||st==null) {
			return false;
		}
		else {
			return true;
		}
	}
}
