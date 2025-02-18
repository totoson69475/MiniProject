package classes;
class LectureDTO
{
    String coursesName;
    String classRoom;
    String classTime;
    int enrolledStudent;
    int maxStudent;

    public LectureDTO(String coursesName, String classRoom, String classTime,
                      int enrolledStudent, int maxStudent){
        this.coursesName = coursesName;
        this.classRoom = classRoom;
        this.classTime = classTime;
        this.enrolledStudent = enrolledStudent;
        this.maxStudent = maxStudent;
    }
    public LectureDTO(){}


    public void setCoursesName(String coursesName){
        this.coursesName = coursesName;
    }
    public String getCoursesName(){
        return coursesName;
    }

    public void setClassRoom(String classRoom){
        this.classRoom = classRoom;
    }
    public String getClassRoom(){
        return classRoom;
    }

    public void setClassTime(String classTime){
        this.classTime = classTime;
    }
    public String getClassTime(){
        return classTime;
    }

    public void setEnrolledStudent(int enrolledStudent){
        this.enrolledStudent = enrolledStudent;
    }
    public int getEnrolledStudent(){
        return enrolledStudent;
    }

    public void setMaxStudent(int maxStudent){
        this.maxStudent = maxStudent;
    }
    public int getMaxStudent(){
        return maxStudent;
    }
}
