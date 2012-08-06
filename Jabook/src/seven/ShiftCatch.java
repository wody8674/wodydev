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
			// ��Ȯ�� URL�� �Է����� �ʾұ� ������ �����߻�
			URL url = p.makeURL("htttttp://www.yahoo.co.kr");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("finally: �ᱹ�̸��� ���±���");
		}
	}
}
