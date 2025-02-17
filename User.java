package classes;
public abstract class User {

    protected int id;
    protected String name;
    protected String phoneNumber;
    protected String email;
    protected String address;
    protected String department;
    protected String attendance;

    // 생성자
    public User(int id, String name, String phoneNumber,
                String email, String address, String department, String attendance) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;
        this.department = department;
        this.attendance = attendance;
    }
    public User(){};

    // 개인정보 조회
    public void viewUserInfo(int id){}
    // 개인정보 수정
    public void editUserInfo(int id){}
}