import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

//2025_06_04 (D-day마다 git update)
public class Main {
	public static void main(String[] args) {
		System.out.println("==프로그램 시작==");
		
		//makeTestDate(); 사용예정의 메서드

		Scanner sc = new Scanner(System.in);
		int PostNumber = 0;
		List<Article> articles = new ArrayList<Article>();

		while (true) {
			System.out.printf("명령어 ) ");
			String command = sc.nextLine().trim();

			if (command.length() == 0) {

				System.out.println("입력된 명령어가 없습니다.");
				continue;
			}

			if (command.equals("exit")) {
				break; // 루프 탈출
			}
			if (command.equals("article list")) {
				if (articles.size() == 0) {
					System.out.println("게시글이 없습니다");
				} else {
					System.out.println("번호 	/	제목	/	조회	");
					for (int i = articles.size() -1; i >= 0; i--) {
						Article article = articles.get(i);
						System.out.printf(" %4d	/	%5s	/	%4d	\n", article.id, article.title);
					}
				}

			} else if (command.equals("article write")) {

				int id = PostNumber + 1;
				String regDate = Util.getNow();
				System.out.printf("제목: "); 
				String title = sc.nextLine();
				System.out.printf("내용: ");
				String body = sc.nextLine();

				System.out.println("입력된 제목 : " + title);
				System.out.println("입력된 제목 : " + body);

				//updateDate부분 수정 해야함 2025-05-20 commit-m
				/*
				 * task12. ★조회수 조회 기능 추가구현★ https://www.youtube.com/watch?v=N7tzjnIn53U&list=
				 * PLF9oUe1QH64t_LDHUlpN3GyLMhJB9uQ15&index=15 7분 5초
				 */
				//action check~
				String updateDate = null;
				
				Article article = new Article(id, regDate, updateDate, title, body);
				articles.add(article);

				System.out.printf("%d 번글이 생성되었습니다.\n", id);
				PostNumber++;

			} else if (command.startsWith("article detail")) {

				String[] commandDiv = command.split(" "); // article detail 1
				
				int id = Integer.parseInt(commandDiv[2]);

				Article foundArticle = null;

				for (int i = 0; i < articles.size(); i++) {
					Article article = articles.get(i);
					if (article.id == id) {
						foundArticle = article;
						break;
					}
					
				}
				
				if (foundArticle == null) {
					System.out.printf("%d번 게시물은 없습니다", id);
					continue;
					} 
					
					foundArticle.hit++;
					
					System.out.println(" 번호 :  " + foundArticle.id );
					System.out.println(" 작성날짜 :  " + foundArticle.regDate);
					System.out.println(" 수정날짜 :  " + foundArticle.updateDate);
					System.out.println(" 제목 :  " + foundArticle.title );
					System.out.println(" 내용 :  " + foundArticle.body );
					System.out.println(" 조회수 : " + foundArticle.hit);
					
					} else if (command.startsWith("article modify")) {
					String[] commandDiv = command.split(" ");
					
					int id = Integer.parseInt(commandDiv[2]);
					
					Article foundArticle = null;
					
					for (int i = 0; i < articles.size(); i++) {
						Article article = articles.get(i);
						if (article.id ==id) {
							foundArticle = article;
							break;
					}
				}
				
				if (foundArticle == null) {
					System.out.printf(" %d번 게시물은 없습니다. \n", id);
					continue;
				}
				
				System.out.printf("제목 : ");
				String newTitle = sc.nextLine();
				System.out.printf("내용 : ");
				String newBody = sc.nextLine();
				
				String updateDate = Util.getNow();
				foundArticle.title = newTitle;
				foundArticle.body = newBody;
				foundArticle.updateDate = updateDate;
				
				} else if (command.startsWith("article delete")) {
					
					String[] commandDiv = command.split(" ");
					
					int id = Integer.parseInt(commandDiv[2]);
					
					int foundIndex = -1;
					
					for (int i =0; i < articles.size(); i++) {
					Article article = articles.get(i);
					if (article.id == id) {
						foundIndex = i;
						break;
					}
				}
				
				if (foundIndex == -1) {
					System.out.printf("%d번 게시물은 없습니다\n" , id);
					continue;
				}
				
				articles.remove(foundIndex);
				System.out.println(id + "번 글을 삭제했습니다");
 
			} else {
				System.out.println("존재하지 않는 명령어입니다");
				continue; // 만나면 skip 맨위로 올라감
			}
		}

		System.out.println("==프로그램 종료==");

		sc.close();
	}
}

class Article {
	int id;
	String regDate;
	String updateDate;
	String title;
	String body;
	int hit;


	Article(int id, String regDate, String updateDate,  String title, String body) {
		this.id = id;
		this.regDate = regDate;
		this.updateDate = updateDate;
		this.title = title;
		this.body = body;
		this.hit = 0;
	}
}