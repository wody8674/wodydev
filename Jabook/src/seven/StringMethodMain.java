package jabook.seven;

import static java.lang.System.out;

public class StringMethodMain {
	public static void main(String[] args) {
		String str1 = new String("www.jabook.org");
		String str2 = new String("www.jabook.org");
		
		System.out.println("str1의 길이:" + str1.length());
		System.out.println("str2의 길이:" + str2.length());
		System.out.println("str1.equals(str2):" + str1.equals(str2));
		System.out.println("str1.compareTo(str2):" + str1.compareTo(str2));
		
		out.println("str1.concat(str2):" + str1.concat(str2));
		out.println("str1+str2:" + str1 + str2);
		out.println("str1.indexOf(\"jabook\"):" + str1.indexOf("jabook"));
		out.println("str1.lastIndexOf(\"o\"):" + str1.lastIndexOf("o"));
		out.println("str1.substring(4,10):" + str1.substring(4, 10));
		out.println("str1.replace(\"o\", \"t\"):" + str1.replace("o", "t"));
	}
}
