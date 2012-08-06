package jabook.seven;

public class StringBufferMain {
	public static void main(String[] args) {
		
		// 1. String Ŭ������ ������ �Ұ�����(Immutable) Ŭ�����̴�.
		String str1 = "www.";
		String str2 = "jabook.";
		String str3 = "org";
		String str4 = str1 + str2 + str3;
		
		System.out.println(str4);
		
		String str5 = str4.replace("org", "net");
		
		System.out.println(str5);
		
		// 2. StringBuffer Ŭ������ ������ ������ Ŭ�����̴�.
		StringBuffer sb = new StringBuffer();
		sb.append("www.");
		sb.append("jabook.");
		sb.append("org");
		sb.replace(11, 14, "net");
		
		String str = sb.toString();
		
		System.out.println(str);
	}
}
