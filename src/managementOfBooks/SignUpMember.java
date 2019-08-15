package managementOfBooks;

import java.util.*;

public class SignUpMember {
	Scanner scan = new Scanner(System.in);
	List<SignUp> members = new ArrayList<>();
		
	public SignUpMember() {
		members.add(new SignUp("han001112", "1234", "JangHan"));
		members.add(new SignUp("probSH", "1234", "JeongSeongHun"));
		members.add(new SignUp("godjh", "1234", "YuJeongHun"));
	}

	public void Run() {
		int key;
		while ((key = menu()) != 0) {
			switch (key) {
			case 1:
				Login();
				break;
			case 2:
				MemberJoin();
				break;
			}
		}
		if (key == 0) {
			System.out.println("���α׷��� ����Ǿ����ϴ�. �̿����ּż� �����մϴ�.");
		}
	}

	private void MemberJoin() {
		scan.nextLine();
		String id = getInput("        ID        : ");
		String passWord = getInput("     PassWord     : ");
		String passWordComfirm = getInput(" Password Confirm : ");
		String name = getInput("	  �̸�        : ");

		if (idCheck(id)) {
			System.out.println("�̹� ������� ID�Դϴ�.");
		} else if (passWord.equals(passWordComfirm)) {
			members.add(new SignUp(id, passWord, name));
			System.out.println("<" + name + ">�� ������ ���ϵ帳�ϴ�.");
		} else {
			System.out.println("��й�ȣ�� �ٽ� �ѹ� Ȯ�����ּ���.");
		}

	}

	private boolean idCheck(String id) {
		boolean check = true;
		SignUp member = FindById(id);
		if (member == null) {
			check = false;
		}
		return check;
	}

	private void Login() {
		scan.nextLine();
		String id = getInput("    ID   : ");
		String passWord = getInput("PassWord : ");

		SignUp member = FindById(id);
		if (member == null) {
			System.out.println("��ϵ��� ���� ID�Դϴ�.");
		} 
		else if (member.getPW().equals(passWord)) {
			if(member.getName()=="JangHan" || member.getName()=="JeongSeongHun" || member.getName()=="YuJeongHun") {
				System.out.println("������ <" + member.getName() + ">�� ȯ���մϴ�.");
				Manager manager = new Manager();
				manager.run();
			}
			else {
				System.out.println("<" + member.getName() + ">�� ȯ���մϴ�.");
				
			}
		} 
		else {
			System.out.println("�߸��� ��й�ȣ�� �Է��ϼ̽��ϴ�.");
		}
	}

	private SignUp FindById(String id) {
		for (SignUp signUp : members) {
			if (signUp.getID().equals(id)) {
				return signUp;
			}
		}
		return null;
	}

	private String getInput(String input) {
		System.out.println(input);
		return scan.nextLine();
	}

	private int menu() {
		System.out.println("OOO's Library�� ���� ���� ȯ���մϴ�.");
		return getNumInput("<1>�α��� <2>ȸ������ <0>����");
	}

	private int getNumInput(String input) {
		System.out.println(input);
		return scan.nextInt();
	}
	
	protected void SelectMember() {
		Iterator<SignUp> it1 = members.iterator();

		while (it1.hasNext()) {
			System.out.println(it1.next() + " ");
		}

}
}