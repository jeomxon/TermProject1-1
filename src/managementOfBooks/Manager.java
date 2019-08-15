package managementOfBooks;

import java.util.*;
import java.io.*;

public class Manager extends SignUpMember {

	public void run() {
		int key = 3;
		while ((key) != 0) {
			System.out.println("어떤 작업을 하시겠습니까?");
			System.out.println("[1]도서 추가(수정) 및 조회 [2]회원 정보 [0]로그아웃");
			key = scan.nextInt();
			switch (key) {
			case 1:
				ArrayList<Book> book = new ArrayList<Book>();
				int bookNum = 0;
				String title_author = null;
				try {
					Scanner sc = new Scanner(new File("Book.txt"));
					while (sc.hasNext()) {
						book.add(new Book(sc.nextInt(), sc.next()));
					}
					sc.close();
				} catch (FileNotFoundException e) {
					System.out.println("*** 입력 파일이 존재하지 않습니다.");
				} catch (Exception e) {
					System.out.println("*** 기타 오류가 발생했습니다.");
				}

				if (book.size() == 0) {
					System.out.println("*** 데이터를 직접 입력 받습니다. (더 이상 입력할 데이터가 없으면 0을 입력)");
					while (true) {
						System.out.print("Book Number: ");
						bookNum = scan.nextInt();

						if (bookNum <= 0)
							break;
						System.out.print("Book Title__Author  :  ");
						title_author = scan.next();
						book.add(new Book(bookNum, title_author));
					}
				}
				System.out.println("텍스트 파일로부터 입력 받거나 생성한 객체(" + book.size() + "개):");
				for (Book books : book) {
					System.out.print(books + " )) ");
				}
				System.out.println();

				System.out.println("*** 데이터를 수정 또는 추가합니다. (더 이상 수정 또는 추가할 데이터가 없으면 0을 입력)");
				while (true) {
					System.out.print("Book Number: ");
					bookNum = scan.nextInt();
					if (bookNum <= 0)
						break;
					if (bookNum > book.size()) {
						System.out.println("Book Title__Author : ");
						title_author = scan.next();
						book.add(new Book(bookNum, title_author));
					} else {
						System.out.println("New Title__Author : ");
						title_author = scan.next();
						book.get(bookNum - 1).setTitleAuthor(title_author);

					}
				}

				System.out.println("저장할 객체들(" + book.size() + "개): ");
				for (Book books : book)
					System.out.print(books + " )) ");
				System.out.println();

				try {
					PrintStream out = new PrintStream(new FileOutputStream("Book.txt"));
					for (Book books : book) {
						out.println(books.getBookNum());
						out.println(books.getTitleAuthor());

					}
					out.flush();
					out.close();
					System.out.println("*** 데이터를 성공적으로 저장했습니다.");
				} catch (IOException e) {
					System.out.println("*** 입출력 오류가 있습니다.");
				}
				break;
			case 2:
				SelectMember();
				break;
			}
		}
		if (key == 0) {
			System.out.println("로그아웃 되었습니다.");
		}
	}
}