package seven;

import java.net.MalformedURLException;
import java.net.URL;

public class ShiftError {
	// throws�� �̿��ؼ� ���� ó���� �̹��� �޼���
	public URL makeURL(String urlstr) throws MalformedURLException {
		return new URL(urlstr);
	}

	public static void main(String args[]) {
		ShiftError s = new ShiftError();
		// ����ó�� ��ƾ �ʿ�
		try {
			URL url = s.makeURL("http://www.yahoo.co.kr");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
	}
}
