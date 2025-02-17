package classes;

import java.util.Scanner;
class  SchoolMain
{
    public static void main(String[] args)
    {
        StudentDAO dao = new StudentDAO();
        dao.stuSet();
        dao.lectureSet();
        System.out.println("학생: 1, 교수: 2 입력");
        Scanner sc = new Scanner(System.in);
        int userInput = sc.nextInt();
        if (userInput == 1)
        {
            System.out.println("메뉴 선택");
            System.out.println("1. 수강 강좌 조회");
            System.out.println("2. 강의 수강 신청");
            System.out.println("3. 성적 조회");
            System.out.println("4. 출결 조회");
            System.out.print("입력: ");
            int userInput2 = sc.nextInt();
            switch(userInput2){
                case 1:
                    dao.viewCurrentLecture(userInput2);
                    break;
                case 2:
                    dao.signUpLecture(userInput2);
                    break;
                case 3:
                    dao.viewGrade(userInput2);
                    break;
                case 4:
                    dao.viewAttendance(userInput2);
                    break;
            }
        } else if(userInput == 2){
            System.out.println("교수는 아직");
        } else{
            System.out.println("나가!");
        }

    }
}
