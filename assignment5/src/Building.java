

import java.util.ArrayList;
import java.util.List;

public class Building {
    private List<Classroom> rooms;
    private Location location;
    private int id;


    public Building(Location location, int id) {
        this.location = location;
        this.id = id;
        rooms = new ArrayList<>();
    }

    public Building() {
        rooms = new ArrayList<>();
    }

    public List<Classroom> getRooms() {
        return rooms;
    }

    public void setRooms(List<Classroom> rooms) {
        this.rooms = rooms;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public boolean addRoom( Classroom room ) {
        for(Classroom r:rooms){
            if(room.getId()==r.getId()||room.getBuilding()!=r.getBuilding()){
                return false;
            }
        }
        this.rooms.add(room);
        return true;
    }
    public boolean deleteRoom( Classroom room ) {
        for (Classroom r:rooms){
            if(r==room){
                rooms.remove(r);
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {

        return this.location.getName()+"#"+this.id ;
    }
}
