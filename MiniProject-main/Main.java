package classes;

import java.util.Scanner;

class  Main
{
    StudentDAO dao = new StudentDAO();
	// User user = new StudentDAO();
    int studentId;	// 학번(StudentDAO에 학생 정보 전달용)

    boolean validateChk = false;
    boolean studentIdChk = false;
    boolean professorIdChk = false;
    int studentIdx = -1;
    int professorIdx = -1;

    UserAPI Liner = new UserAPI();
    Scanner input = new Scanner(System.in);

    void startMenu(){
        while(true){
            Liner.mLine('=',31);
            System.out.println("## 인덕대 종합 학사 관리 시스템 ##");
            Liner.mLine('=',31);
            System.out.println("1. 학생 로그인");
            System.out.println("2. 교수 로그인");
            System.out.println("\n\nQ.종료");
            Liner.mLine('-',31);
            System.out.print("\t ^ 메뉴를 선택 하세요 : ");

            String vRead1;
            validateChk = false;

            vRead1 = input.nextLine();

            inputValidate(vRead1);

            if(validateChk) continue;

            if(vRead1.equals("1")){
                studentLogin();
            }

            if(vRead1.equals("2")){
                professorLogin();
            }

            if(vRead1.equalsIgnoreCase("q")){
                System.out.println("시스템을 종료합니다.");
                System.exit(0);
            }


        }
    }

    void studentLogin(){
        System.out.println("\t ^ 학생 로그인 진행");
        while(true){
            System.out.print("학번을 입력해주세요 [Q : 취소] : ");

            String ID;
            validateChk = false;

            ID = input.nextLine();

            if(ID.equalsIgnoreCase("q")){
                System.out.println("로그인을 취소합니다.");
                return;
            }

			/*
			inputValidate(vRead1);

			if(validateChk) continue;
			*/

            System.out.print("비밀번호를 입력해주세요 : ");
            String PWD;
            PWD = input.nextLine();

            // 조건 분기
            System.out.println("로그인 성공!");
            studentId = Integer.parseInt(ID);		// 로그인 성공 시 입력한 학번 int형으로 저장
            studentMenu();
        }
    }

    void professorLogin(){
        System.out.println("\t ^ 교수 로그인 진행");
        while(true){
            System.out.print("사번을 입력해주세요 [Q : 취소] : ");

            String ID;
            validateChk = false;

            ID = input.nextLine();

            if(ID.equalsIgnoreCase("q")){
                System.out.println("로그인을 취소합니다.");
                return;
            }

			/*
			inputValidate(vRead1);

			if(validateChk) continue;
			*/

            System.out.print("비밀번호를 입력해주세요 : ");
            String PWD;
            PWD = input.nextLine();

            // 조건 분기
            System.out.println("로그인 성공!");
            professorMenu();
        }
    }

    void studentMenu(){
        while(true){
            Liner.mLine('=',31);
            System.out.println("  ## 학생 학사 관리 시스템 ##  ");
            Liner.mLine('=',31);
            System.out.println("1. 수강 신청");
            System.out.println("2. 성적 조회");
            System.out.println("3. 출결 조회");
            System.out.println("4. 개인정보 조회");
            System.out.println("5. 개인정보 수정");
			System.out.println("6. 강의성적 추가");				// 과목 - 성적 입력 확인을 위한 Test
			System.out.println("7. 강의출결 추가");				// 과목 - 출결 입력 확인을 위한 Test
            System.out.println("\n\nQ.로그아웃");
            Liner.mLine('-',31);
            System.out.print("\t ^ 메뉴를 선택 하세요 : ");

            String vRead1;
            validateChk = false;

            vRead1 = input.nextLine();

            if(vRead1.equalsIgnoreCase("q")){
                System.out.println("로그아웃 합니다.");
                startMenu();
            }

            inputValidate(vRead1);

            if(validateChk) continue;

            if(vRead1.equals("1")){
                System.out.println("수강 신청 시스템 실행");
                dao.signUpLecture(studentId);
            }

            if(vRead1.equals("2")){
                dao.viewGrade(studentId);
            }
            if(vRead1.equals("3")){
                dao.viewAttendance(studentId);
            }
            if(vRead1.equals("4")){
				dao.viewUserInfo(studentId);
            }
            if(vRead1.equals("5")){
				dao.editUserInfo(studentId);
            }
			if(vRead1.equals("6")){							// 과목 - 성적 입력 확인을 위한 Test
				dao.test11(studentId);
            }
			if(vRead1.equals("7")){							// 과목 - 성적 입력 확인을 위한 Test
				dao.test22(studentId);
            }
        }
    }

    void professorMenu(){
        while(true){
            Liner.mLine('=',31);
            System.out.println(" ## 인덕대 학사 관리 시스템 ##  ");
            Liner.mLine('=',31);
            System.out.println("1. 강의 관리");
            System.out.println("2. 성적 관리");
            System.out.println("3. 출결 관리");
            System.out.println("4. 개인정보 조회");
            System.out.println("5. 개인정보 수정");
            System.out.println("\n\nQ.로그아웃");
            Liner.mLine('-',31);
            System.out.print("\t ^ 메뉴를 선택 하세요 : ");

            String vRead1;
            validateChk = false;

            vRead1 = input.nextLine();

            if(vRead1.equalsIgnoreCase("q")){
                System.out.println("로그아웃 합니다.");
                startMenu();
            }

            inputValidate(vRead1);

            if(validateChk) continue;

            if(vRead1.equals("1")){
                System.out.println("강의 관리 시스템 실행");
                System.out.println("1. 강의 생성");
                System.out.println("2. 강의 수정");
                System.out.println("3. 강의 삭제");
            }

            if(vRead1.equals("2")){
                System.out.println("성적 관리 실행");
                System.out.println("성적을 관리할 과목을 선택하십시오.");
                System.out.println("성적을 관리할 학생을 선택하십시오.");
                System.out.println("01. 성적 입력");
                System.out.println("02. 성적 수정");
                System.out.println("03. 성적 삭제");
            }
            if(vRead1.equals("3")){
                System.out.println("출결 조회 실행");
                System.out.println("출결을 관리할 과목을 선택하십시오.");
                System.out.println("출결을 관리할 학생을 선택하십시오.");
                System.out.println("01. 출결 입력");
                System.out.println("02. 출결 수정");
                System.out.println("03. 출결 삭제");
            }
            if(vRead1.equals("4")){
                System.out.println("개인정보 조회 실행");
            }
            if(vRead1.equals("5")){
                System.out.println("개인정보 수정 실행");
            }
        }
    }

    void inputValidate(String _userInput){

        if(_userInput.isEmpty()){
            System.out.println("\t ^ 값을 입력하신 후 엔터를 눌러 주세요.");
            validateChk = true;
            return;
        }

        if(1 < _userInput.length()){
            System.out.println("^ 하나만 입력 하세요\n\n\n");
            validateChk = true;
            return;
        }

		/*
		if(_userInput.charAt(0) < 49 || 52 < _userInput.charAt(0)){
			System.out.println("^ 1 ~ 4 사이의 메뉴번호 선택 하세요\n\n\n");
			validateChk = true;
			return;
		}
		*/

    }
    public static void main(String[] args)
    {
        Main obj = new Main();
        obj.dao.stuSet();
        obj.dao.lectureSet();
        obj.startMenu();
    }
}
