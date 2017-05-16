package manage.util;

public class countNumber {
	
	/**
	 * 计算字符串str中包含s的个数
	 * @param str
	 * @param s
	 * @return
	 */
	private int count = 0;
	public int countNum(String str,String s){
		if(str != null && str.indexOf(s) != -1){
			count ++;
			countNum(str.substring(str.indexOf(s)+1,str.length()),s);
			return count;
		}
		return 0;
	}
}
