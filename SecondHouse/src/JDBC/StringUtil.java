package JDBC;
/*
 * �����ж��Ƿ�Ϊ��
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
