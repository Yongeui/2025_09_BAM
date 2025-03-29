import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;


public class Main {
	public static void main (String [] args) {
		System.out.println("==프로그램 시작==");
		
		Scanner sc= new Scanner (System.in);
		int PostNumber = 0;
		List<Article> articles = new ArrayList<Article> ();
		
		while (true) {
			System.out.printf("명령어 ) " );
			String command = sc.nextLine();
			
			if (command.length() ==0 ) {
				
				System.out.println("너 명령어 입력 안했어");
				continue;
			}
			
			if (command.equals("exit")) {
				break; //루프 탈출
			}
			if (command.equals("article list")) {
				if (articles.size() == 0) {
				System.out.println("게시글이 없습니다");
				}
				else {
					System.out.println("게시글이 있습니다.");
				}
				
			} else if (command.equals("article write")) {
				int id = PostNumber + 1;
				System.out.printf("제목: " );
				String title = sc.nextLine();
				System.out.printf("내용: " );
				String body = sc.nextLine();
				
				System.out.println("입력된 제목 : " + title);
				System.out.println("입력된 제목 : " + body);
				
				Article article = new Article (id, title, body);
				articles.add(article);
				
				System.out.printf("%d 번글이 생성되었습니다.\n", id);
				PostNumber++;
			} else {
				System.out.println("존재하지 않는 명령어입니다");
				continue; //만나면 skip 맨위로 올라감
			}
		}
		
		System.out.println("==프로그램 종료==");
		
		sc.close();
	}
}

class Article {
	int id;
	String title;
	String body;
	
	Article (int id, String title, String body) {
		this.id = id;
		this.title = title;
		this.body = body;
	}
}