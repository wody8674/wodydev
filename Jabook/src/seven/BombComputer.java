package jabook.seven;

public class BombComputer {
	boolean power = false;

	public void powerOn() {
		power = true;
		System.out.println("폭발물 처리 컴퓨터 전원 ON!");
	}

	public void powerOff() {
		power = false;
		System.out.println("폭발물 처리 컴퓨터 전원 OFF!");
	}

	public void process() throws Exception {
		System.out.println("작업처리 1");
		System.out.println("작업처리 2");
		// 무조건 에러가 발생하도록 디자인
		throw new Exception("작업처리 3 오류발생 곧 폭발합니다.!@#$");
	}
}
