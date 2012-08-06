package jabook.seven;

public class BasicException {
	public static void main(String args[]) {
		try {
			int[] ar = new int[] { 0, 100, 200, 300 };

			// 고의로 에러유발 : 배열의 범위를 벗어나도록 한다.
			for (int i = 0; i < ar.length + 1; i++) {
				System.out.println("ar[" + i + "]=" + ar[i]);
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("e.getMessage(): " + e.getMessage());
			System.out.println("e.toString(): " + e.toString());
			e.printStackTrace();
			return;
		} finally {
			System.out.println("finally: 결국이리로 오는군요");
		}
	}
}
