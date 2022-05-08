

import java.util.Objects;

public class Student extends Person{
    public Student(){}
    public Student( String id , String name ) {
        super(id,name);
    }

    public boolean courseExist( String code , String name , CourseType type ){
        for (Course c:getSchedule().values()){
            if(c.code.equals(code)&&c.name.equals(name)&&c.type.equals(type))return true;
        }
        return false;
    }
    public boolean courseExist( Course course ){
        return courseExist(course.code,course.name,course.type);
    }

    public boolean chooseCourse( Course course){
        if (!courseExist(course)&&!getSchedule().containsKey(course.getTime())&&course.capacity>course.getStudents().size()){
            getSchedule().put(course.getTime(),course);
            course.addStudent(this);
            return true;
        }
        return false;

    }

    @Override
    public boolean dropCourse( Course course ){
        if(!getSchedule().containsKey(course.time)){
            return false;
        }
        schedule.remove(course.getTime());
        course.deleteStudent(this);
        return true;
    }

    @Override
    public boolean changeCourse( Course oldCourse1 , Course newCourse2 ){
        if(!Objects.equals(oldCourse1.getCode(), newCourse2.getCode()) ||!oldCourse1.getType().equals(newCourse2.getType())){
        return false;}
        if((getSchedule().containsKey(newCourse2.getTime())&&!newCourse2.getTime().equals(oldCourse1.getTime()))){
            return false;}
        dropCourse(oldCourse1);
        return chooseCourse(newCourse2);

    }

    public String printSchedule(){
        StringBuilder schedule= new StringBuilder(this.name + "'s Schedule\n");
        for(Day day:Day.values()){
            schedule.append(day).append("\n");
            for (int i=1;i<=5;i++){
                schedule.append(i+" ");
                CourseTime a=new CourseTime(day,i);
                if(getSchedule().containsKey(a)){
                    Course b=getSchedule().get(a);
                    schedule.append(b.getCode()).append(", ").append(b.getAbbrevName()).append(", ").append(b.getTeacher().name).append(", ").append(b.getRoom().toString());
                }
                schedule.append("\n");

            }

        }
        return schedule.toString();
    }

    public int getScheduleCourseNum(){
        return schedule.size();
    }




}
