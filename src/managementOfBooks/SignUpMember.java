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
			System.out.println("프로그램이 종료되었습니다. 이용해주셔서 감사합니다.");
		}
	}

	private void MemberJoin() {
		scan.nextLine();
		String id = getInput("        ID        : ");
		String passWord = getInput("     PassWord     : ");
		String passWordComfirm = getInput(" Password Confirm : ");
		String name = getInput("	  이름        : ");

		if (idCheck(id)) {
			System.out.println("이미 사용중인 ID입니다.");
		} else if (passWord.equals(passWordComfirm)) {
			members.add(new SignUp(id, passWord, name));
			System.out.println("<" + name + ">님 가입을 축하드립니다.");
		} else {
			System.out.println("비밀번호를 다시 한번 확인해주세요.");
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
			System.out.println("등록되지 않은 ID입니다.");
		} 
		else if (member.getPW().equals(passWord)) {
			if(member.getName()=="JangHan" || member.getName()=="JeongSeongHun" || member.getName()=="YuJeongHun") {
				System.out.println("관리자 <" + member.getName() + ">님 환영합니다.");
				Manager manager = new Manager();
				manager.run();
			}
			else {
				System.out.println("<" + member.getName() + ">님 환영합니다.");
				
			}
		} 
		else {
			System.out.println("잘못된 비밀번호를 입력하셨습니다.");
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
		System.out.println("OOO's Library에 오신 것을 환영합니다.");
		return getNumInput("<1>로그인 <2>회원가입 <0>종료");
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