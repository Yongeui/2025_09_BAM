import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		System.out.println("==프로그램 시작==");

		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int cmd = sc.nextInt();
		
		
		System.out.println("입력한 문자열 :" + str);
		System.out.println("입력한 정수형 :" + cmd);
		System.out.println("==프로그램 끝==");

	}

}
//git init (local에서 git파일 만들기)
//git remote add origin (origin 옆에 띄어쓰기하고 깃주소입력 [깃과 프로젝트를 연결])
//vim .gitignore 후에 a를 눌러서 text에 입력환경 만들고
//입력환경이 만들어졌으면 제외할 파일명단 작성
// .classpath, .project, .settings, bin, build 입력 후 esc 누르고 후에 :wq! 하고 enter