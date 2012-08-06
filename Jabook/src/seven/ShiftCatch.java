package jabook.seven;

import java.net.MalformedURLException;
import java.net.URL;

public class ShiftCatch {
	public URL makeURL(String urlstr) throws MalformedURLException {
		return new URL(urlstr);
	}

	public static void main(String args[]) {
		ShiftCatch p = new ShiftCatch();
		try {
			// 정확한 URL을 입력하지 않았기 때문에 에러발생
			URL url = p.makeURL("htttttp://www.yahoo.co.kr");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("finally: 결국이리로 오는군요");
		}
	}
}
