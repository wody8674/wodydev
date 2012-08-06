package seven;

import java.net.MalformedURLException;
import java.net.URL;

public class ShiftError {
	// throws를 이용해서 에러 처리를 미무는 메서드
	public URL makeURL(String urlstr) throws MalformedURLException {
		return new URL(urlstr);
	}

	public static void main(String args[]) {
		ShiftError s = new ShiftError();
		// 에러처리 루틴 필요
		try {
			URL url = s.makeURL("http://www.yahoo.co.kr");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
