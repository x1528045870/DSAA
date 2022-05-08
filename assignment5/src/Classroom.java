

import java.util.HashMap;
import java.util.Map;

public class Classroom {
    int id;//eg:101
    int seatNum;//eg:50
    CourseType type;// Lecture or Lab
    Building building;
    Map<CourseTime, Course> schedule;
    public Classroom( int id , int seatNum , Building building, CourseType type ){
        this.id = id;
        this.seatNum = seatNum;
        this.type = type;
        this.building = building;
        schedule = new HashMap<>();
    }
    public Classroom(){
        schedule= new HashMap<>();
    }

    @Override
    public String toString() {
        return String.format("%sR%d(%d)%s", type, id, seatNum, building.toString());
    }

    public String addCourse(Course course){

        if(this.getSchedule().containsKey(course.getTime())) return "ERROR: Another course already exists at the time.";
        if(course.getType()!=this.getType())return "ERROR: Course type not same as classroom.";
        if (course.getCapacity()>this.getSeatNum())return "ERROR: Not enough seats in the classroom for this course.";
            schedule.put(course.getTime(),course);
            return "OK: Adding course to classroom success.";
        }

    public boolean deleteCourse(Course course){
        if(this.getSchedule().containsValue(course)){
            schedule.remove(course.getTime());
            return true;
        }
        return false;
    }

    public Course getCourse(CourseTime courseTime){
        return schedule.get(courseTime);
    }

    public String printSchedule(){
        StringBuilder schedule= new StringBuilder(toString() + " Schedule\n");
        for(Day day:Day.values()){
            schedule.append(day).append("\n");
            for (int i=1;i<=5;i++){
                schedule.append(i+" ");
                CourseTime a=new CourseTime(day,i);
                if(getSchedule().containsKey(a)){
                    Course b=getSchedule().get(a);
                    schedule.append(b.getCode()).append(", ").append(b.getAbbrevName()).append(", ").append(b.getTeacher().name);
                }
                schedule.append("\n");

            }

        }
        return schedule.toString();
    }

    public int getScheduleCourseNum(){
        return schedule.size();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSeatNum() {
        return seatNum;
    }

    public void setSeatNum(int seatNum) {
        this.seatNum = seatNum;
    }

    public CourseType getType() {
        return type;
    }

    public void setType(CourseType type) {
        this.type = type;
    }

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public Map<CourseTime, Course> getSchedule() {
        return schedule;
    }

    public void setSchedule(Map<CourseTime, Course> schedule) {
        this.schedule = schedule;
    }
}
