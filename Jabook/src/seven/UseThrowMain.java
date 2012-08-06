package seven;

public class UseThrowMain {
	public static void main(String args[]) {
		try {
			throw new Exception("이것이 에러 메시지");
		} catch (Exception e) {
			System.out.println("--Exception 발생구문--");
			System.out.println("정보:e.getMessage(): " + e.getMessage());
			System.out.println("정보:e.toString(): " + e.toString());
			e.printStackTrace();
			return;
		} finally {
			System.out.println("finally: 결국이리로 오는군요");
		}
	}
}
