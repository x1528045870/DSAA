
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Teacher extends Person {
    private Location preferLocation;

    public Teacher() {

    }

    public Teacher(Location preferLocation) {
        this.preferLocation = preferLocation;
    }

    public Teacher(String id, String name) {
        super(id, name);
    }

    public Location getPreferLocation() {
        return preferLocation;
    }

    public void setPreferLocation(Location preferLocation) {
        this.preferLocation = preferLocation;
    }

    public List<Classroom> getFreeClassroom(CourseTime time, int capacity,
                                            CourseType type) {
        List<Classroom> freeClassrooms=new ArrayList<>();
        for(Building a:Db.buildings){
            if(a.getLocation()==getPreferLocation()){
                for(int i=0;i<a.getRooms().size();i++){
                    Classroom room=a.getRooms().get(i);
                    if(room.getType()==type
                            &&!room.getSchedule().containsKey(time)
                                    &&room.getSeatNum()>=capacity
                    ){
                        freeClassrooms.add(room);
                    }
                }
            }
        }
        if(freeClassrooms.size()==0){
            for(Building a:Db.buildings){
                for(int i=0;i<a.getRooms().size();i++){
                        Classroom room=a.getRooms().get(i);
                        if(room.getType()==type
                                &&!room.getSchedule().containsKey(time)
                                &&room.getSeatNum()>=capacity
                        ){
                            freeClassrooms.add(room);
                        }
                }
            }
        }


        return freeClassrooms;
    }

    boolean createCourse(Course course) {
        if(getSchedule().containsKey(course.getTime())||course.getRoom()==null){
            return false;
        }
        else{
            course.getRoom().addCourse(course);
            schedule.put(course.getTime(),course);
            return true;
        }

    }

    boolean createCourse(String code, String name, String abbrevName, CourseTime
            time, Classroom room, int capacity, CourseType type) {
     Course course=new Course(code,name,abbrevName,this,capacity,type,time,room);
     return createCourse(course);
    }

    @Override
    public boolean dropCourse(Course course) {
        if(!getSchedule().containsValue(course)){
            return false;
        }
        getSchedule().remove(course.getTime());
        course.getRoom().deleteCourse(course);
         return true;
    }

    @Override
    public boolean changeCourse(Course oldCourse1, Course newCourse2) {
        if(!Objects.equals(oldCourse1.getCode(), newCourse2.getCode()) ||oldCourse1.getType()!=newCourse2.getType()||oldCourse1.getTeacher()!=newCourse2.getTeacher()){
        return false;}
        if(dropCourse(oldCourse1)&&createCourse(newCourse2)){
            return true;
        }
        return false;
    }

    public String printSchedule() {
        StringBuilder schedule= new StringBuilder(this.name + "'s Schedule\n");
        for(Day day:Day.values()){
            schedule.append(day).append("\n");
            for (int i=1;i<=5;i++){
                schedule.append(i);
                CourseTime a=new CourseTime(day,i);
                if(getSchedule().containsKey(a)){
                    Course b=getSchedule().get(a);
                    schedule.append(" "+b.getCode()).append(", ").append(b.getAbbrevName()).append(", ").append(b.getRoom().toString());
                }
                schedule.append("\n");

            }

        }
        return schedule.toString();
    }

    public int getScheduleCourseNum() {
        return getSchedule().size();
    }




}
