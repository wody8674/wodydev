package jabook.seven;

public class BombComputer {
	boolean power = false;

	public void powerOn() {
		power = true;
		System.out.println("���߹� ó�� ��ǻ�� ���� ON!");
	}

	public void powerOff() {
		power = false;
		System.out.println("���߹� ó�� ��ǻ�� ���� OFF!");
	}

	public void process() throws Exception {
		System.out.println("�۾�ó�� 1");
		System.out.println("�۾�ó�� 2");
		// ������ ������ �߻��ϵ��� ������
		throw new Exception("�۾�ó�� 3 �����߻� �� �����մϴ�.!@#$");
	}
}
