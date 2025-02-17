package classes;

import java.util.ArrayList;
import java.util.Scanner;
class  StudentDAO extends User
{
    UserAPI Liner = new UserAPI();
    LectureDB lectureDB = new LectureDB();
    StudentDB db = new StudentDB();
    StudentDTO stuAry[] = new StudentDTO[db.id.length];
    StudentDTO stuDto = new StudentDTO();
    ArrayList<LectureDTO> lectureAry = new ArrayList<LectureDTO>();
    Scanner input = new Scanner(System.in);

    int stuCnt;
    int lectureCnt;
    boolean stuIdChk = false;
    int stuIdx = -1;

    public void stuSet(){
        stuCnt = stuAry.length;
        for(int idx = 0; idx < stuCnt; idx++){
            // stuAry[idx] = StudentDTO 객체 생성
            stuAry[idx] = new StudentDTO(db.id[idx], db.name[idx],
                    db.phoneNumber[idx], db.email[idx], db.address[idx],
                    db.department[idx], db.attendance[idx]);
        }
    }

    public void lectureSet(){
        for(int i = 0; i < lectureDB.coursesName.length; i++){
            lectureAry.add(new LectureDTO(lectureDB.coursesName[i], lectureDB.classRoom[i],
                    lectureDB.classTime[i], lectureDB.enrolledStudent[i],
                    lectureDB.maxStudent[i]));
        }
    }

    void viewCurrentLecture(int studentId){		// 현재 수강 강좌 조회 메서드
        System.out.println("현재 수강 강의 메서드");
        System.out.println("학생 학번: " + studentId);
        /*
        for(int i = 0; i < stuCnt; i++){
            System.out.printf("%d\n%s\n%s\n%s\n%s\n%s\n%s\n",
                    stuAry[i].getId(), stuAry[i].getName(), stuAry[i].getPhoneNumber(),
                    stuAry[i].getEmail(), stuAry[i].getAddress(), stuAry[i].getDepartment(),
                    stuAry[i].getAttendance());
        }
         */
        // 지금 되는 건 학생 개인정보 출력. 학생이 듣고 있는 강의를 담을 배열이나 변수 추가해서
        // 해당 변수를 출력하면 됨
    }

    void signUpLecture(int studentId){			// 강의 수강 신청 메서드
        int findIndex = -1;
        Liner.mLine('-', 31);
        System.out.println("수강 신청 화면");
        Liner.mLine('-', 31);
        // System.out.println("학생 학번: " + studentId);
        for(int i = 0; i < stuCnt; i++){
            if(stuAry[i].getId() == studentId){
                findIndex = i;
                break;
            }
        }
        System.out.println(stuAry[findIndex].getName() + "의 현재 수강 중인 강의: ");
        stuDto.printLectures();
        Liner.mLine('-', 31);
        System.out.println("수강하고자 하는 강의 번호를 고르세요.[뒤로가기: Q]");
        System.out.println("현재 강의 목록");
        lectureCnt = lectureDB.coursesName.length;
        for (int i = 0; i < lectureAry.size(); i++) {
            System.out.println("강의 번호" + (i + 1) + ": " + lectureAry.get(i).getCoursesName());
        }
        System.out.printf("선택한 강의: ");
        while(true){
            String userInput = input.nextLine();
            if(userInput.equalsIgnoreCase("Q")){
                System.out.println("이전 화면으로 돌아갑니다.");
            }  try {
                Integer.parseInt(userInput); // 입력이 숫자가 아니면 예외 발생
                // System.out.println("입력된 숫자: " + userInput);
                int tempInt = Integer.parseInt(userInput) - 1;                                  // 선택한 번호에서 1을 감소하여 index값 추출
                LectureDTO selectLecture = lectureAry.get(tempInt);                             // selectLecture에 선택한 index값 강의 정보 저장
                stuDto.addLecture(selectLecture);                                               // StudentDTO의 수강 강의 정보(Lectures) 배열에 추가
                selectLecture.setEnrolledStudent(selectLecture.getEnrolledStudent() + 1);       // 선택한 강의 수강 학생 수 1 증가
                /*
                for(LectureDTO lecture : lectureAry){   // 학생 수 증가 정상 작동 여부 확인
                    System.out.println(lecture.getCoursesName() + " 강의의 현재 학생 수: " + lecture.getEnrolledStudent());
                }
                 */
                break;
            } catch (NumberFormatException e) {
                System.out.println("숫자가 아닌 문자가 입력되었습니다.");
                System.out.printf("다시 입력하세요[뒤로가기 :Q] : ");
            }
        }
        // 듣고 싶은 강의의 번호(index)를 눌렀을 시 학생이 듣는 강의 list에 들어가도록 할 것
    }

    void viewGrade(int studentId){				// 성적 조회 메서드
        System.out.println("성적 조회 메서드");
        System.out.println("학생 학번: " + studentId);
        // 학생 정보 중에서 선생님이 입력해준 성적을 출력해야 함
    }

    void viewAttendance(int studentId){			// 출결 조회 메서드
        System.out.println("출결 조회 메서드");
        System.out.println("학생 학번: " + studentId);


        // + 현재 수강하는 수업 별 출결 결과를 출력?

    }

}
