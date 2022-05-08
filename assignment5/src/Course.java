

import java.util.ArrayList;
import java.util.List;

public class Course {
    static int idCnt = 0;// number of courses created
    int id;//generated automatically from 1
    String name; // Introduction to Computer Programming A
    String abbrevName;// JavaA
    String code; // CS102A
    CourseTime time;
    Teacher teacher;
    Classroom room;
    List<Student> students=new ArrayList<>();// who selected this course
    int capacity;// maximum number of students
    CourseType type;//Lecture, Lab

    public Course(String code, String name, String abbrevName, Teacher
            teacher, int capacity, CourseType type) {
        this.code = code;
        this.name = name;
        this.abbrevName = abbrevName;
        this.teacher = teacher;
        this.capacity = capacity;
        this.type = type;
        setIdCnt(getIdCnt()+1);
        this.id=idCnt;
    }

    public Course(String code, String name, String abbrevName, Teacher
            teacher, int capacity, CourseType type, CourseTime time, Classroom room) {
        this.code = code;
        this.name = name;
        this.abbrevName = abbrevName;
        this.teacher = teacher;
        this.capacity = capacity;
        this.type = type;
        this.time = time;
        this.room = room;
    }

    public static int getIdCnt() {
        return idCnt;
    }

    public static void setIdCnt(int idCnt) {
        Course.idCnt = idCnt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbbrevName() {
        if(this.abbrevName.equals("")){
            StringBuilder a=new StringBuilder();
            for (int i=0;i<getName().length();i++){
                if(getName().charAt(i)>=65&&getName().charAt(i)<=90)a.append(getName().charAt(i));
            }
            abbrevName=String.valueOf(a);
        }

        return abbrevName;
    }

    public void setAbbrevName(String abbrevName) {
        this.abbrevName = abbrevName;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public CourseTime getTime() {
        return time;
    }

    public void setTime(CourseTime time) {
        this.time = time;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Classroom getRoom() {
        return room;
    }

    public void setRoom(Classroom room) {
        this.room = room;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public CourseType getType() {
        return type;
    }

    public void setType(CourseType type) {
        this.type = type;
    }

    public boolean addStudent(Student student) {
        if(students!=null&&students.contains(student)){return false;}
        students.add(student);return true;
    }

    public boolean deleteStudent(Student student) {
        if(!students.contains(student)){
        return false;}
        students.remove(student);
        return true;
    }

    public void setRoomTime(Classroom room, CourseTime time) {
         this.room=room;this.time=time;
         room.getSchedule().put(time,this);
    }


}
