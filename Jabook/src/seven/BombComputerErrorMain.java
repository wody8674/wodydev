package jabook.seven;

public class BombComputerErrorMain {
	public static void main(String args[]) {
		BombComputer bc = new BombComputer();
		
		try {
			bc.powerOn();
			bc.process(); // 에러 발생
			bc.powerOff();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
