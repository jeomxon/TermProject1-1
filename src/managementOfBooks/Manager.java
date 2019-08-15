package managementOfBooks;

import java.util.*;
import java.io.*;

public class Manager extends SignUpMember {

	public void run() {
		int key = 3;
		while ((key) != 0) {
			System.out.println("� �۾��� �Ͻðڽ��ϱ�?");
			System.out.println("[1]���� �߰�(����) �� ��ȸ [2]ȸ�� ���� [0]�α׾ƿ�");
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
					System.out.println("*** �Է� ������ �������� �ʽ��ϴ�.");
				} catch (Exception e) {
					System.out.println("*** ��Ÿ ������ �߻��߽��ϴ�.");
				}

				if (book.size() == 0) {
					System.out.println("*** �����͸� ���� �Է� �޽��ϴ�. (�� �̻� �Է��� �����Ͱ� ������ 0�� �Է�)");
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
				System.out.println("�ؽ�Ʈ ���Ϸκ��� �Է� �ްų� ������ ��ü(" + book.size() + "��):");
				for (Book books : book) {
					System.out.print(books + " )) ");
				}
				System.out.println();

				System.out.println("*** �����͸� ���� �Ǵ� �߰��մϴ�. (�� �̻� ���� �Ǵ� �߰��� �����Ͱ� ������ 0�� �Է�)");
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

				System.out.println("������ ��ü��(" + book.size() + "��): ");
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
					System.out.println("*** �����͸� ���������� �����߽��ϴ�.");
				} catch (IOException e) {
					System.out.println("*** ����� ������ �ֽ��ϴ�.");
				}
				break;
			case 2:
				SelectMember();
				break;
			}
		}
		if (key == 0) {
			System.out.println("�α׾ƿ� �Ǿ����ϴ�.");
		}
	}
}