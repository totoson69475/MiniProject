package classes;

import java.util.ArrayList;
class  StudentDTO extends User
{
    private ArrayList<LectureDTO> lectures = new ArrayList<>();
    LectureDB lectureDb = new LectureDB();

    public StudentDTO(int id, String name, String phoneNumber,
                      String email, String address, String department, String attendance){
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.department = department;
        this.attendance = attendance;
    };
    public StudentDTO(){};

    // ✅ 강의 추가 메서드
    public void addLecture(LectureDTO lecture) {
        lectures.add(lecture);
    }

    // ✅ 강의 삭제 메서드
    public void removeLecture(LectureDTO lecture) {
        lectures.remove(lecture);
    }

    // ✅ 수강 중인 모든 강의 가져오기
    public ArrayList<LectureDTO> getLectures() {
        return lectures;
    }

    // ✅ 수강 중인 강의 출력 (테스트용)
    public void printLectures() {
        if(lectures.isEmpty()){
            System.out.println("수강 중인 강의가 없습니다.");
        } else {
            for (LectureDTO lecture : lectures) {
                System.out.println("- " + lecture.getCoursesName());
            }
        }

    }



    public void setId(int id){
        this.id = id;
    }
    public int getId(){
        return id;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }
    public void setAddress(String address){
        this.address = address;
    }
    public String getAddress(){
        return address;
    }
    public void setDepartment(String department){
        this.department = department;
    }
    public String getDepartment(){
        return department;
    }
    public void setAttendance(String attendance){
        this.attendance = attendance;
    }
    public String getAttendance(){
        return attendance;
    }
}