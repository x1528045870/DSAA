import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Objects;
public class RoomManager {
    private static ArrayList<Room> roomInfoLynn= new ArrayList<>();
    private static ArrayList<Room> roomInfoYidan= new ArrayList<>();
    private static ArrayList<Room> roomInfoLearningNexus= new ArrayList<>();
    //记录三个图书馆房间的信息
    //创建房间(判断前面是否有相同房间，以及房间名是否正确）

    public static boolean addRoom (String rid, Library location, int capacity){
        Room room = new Room(rid, location, capacity);
        if(checkRid(rid, location))return false;
        if(checkRidName(rid))return false;
        if(capacity<=0)return false;
        loc(location).add(room);
        return true;
    }
    public static boolean addRoom (String rid, Library library, int capacity,
                                   boolean hasDisplay, boolean hasWhiteboard){
        Room room = new Room(rid, library, capacity,hasDisplay,hasWhiteboard);
        if(checkRid(rid, library))return false;
        if(checkRidName(rid))return false;
        if(capacity<=0)return false;
        loc(library).add(room);
        return true;//暂时return一下
    }
    //点一个房间
    public static boolean orderRoom (Library library, String rid, String SID, int
            start, int end, int numberOfTeammates){
           if(!checkRoomRid(rid,library))return false;
           if(!checkOrder(SID,library))return false;
           else{for(Room room3:loc(library))
               if(rid.equals(room3.getRid())){
           return room3.setApplicant(start,end,SID,numberOfTeammates);
                }}
           return false;
    }
    //取消所有方间
    public static boolean cancelOrder (String SID){
        int t=0;
        for (Room room4:loc(Library.Lynn))
        {if(room4.removeApplicant(SID))t++;}
        for (Room room5:loc(Library.Yidan))
        {if(room5.removeApplicant(SID))t++;}
        for (Room room6:loc(Library.LearningNexus))
        {if(room6.removeApplicant(SID))t++;}
        if(t>0)return true;
        return false;
    }
    public static boolean cancelOrder (String SID, Library location){
        int t=0;
        for (Room room4:loc(location))
        {if(room4.removeApplicant(SID))t++;}
        if (t>0)return true;
        return false;
    }
    //找房间
    public static ArrayList<Room> searchRoom (Library location, int start, int end,
                                            boolean needDisplay, boolean needWhiteboard){
        ArrayList<Room> searchRoom1= new ArrayList<>();
        for(Room room6:loc(location)) {
            if (checkDB(needDisplay, needWhiteboard, room6) && room6.checkTA(start, end)) {
                searchRoom1.add(room6);
            }
        }
        return sort(searchRoom1);
    }
    public static ArrayList<Room> searchRoom (int start, int end){
        ArrayList<Room> searchRoom2= new ArrayList<>();
        for(Room room7:loc(Library.Yidan)){
            if(room7.checkTA(start,end)){
                searchRoom2.add(room7);
            }
        }
        sort(searchRoom2);
        ArrayList<Room>bala=new ArrayList<>();
        for(Room room8:loc(Library.Lynn)){
            if(room8.checkTA(start,end)){
                bala.add(room8);
            }
        }
        searchRoom2.addAll(sort(bala));
        bala.clear();
        for(Room room9:loc(Library.LearningNexus)){
            if(room9.checkTA(start,end)){
                bala.add(room9);
            }
        }
        searchRoom2.addAll(sort(bala));
        bala.clear();
        return searchRoom2;
    }
    public static ArrayList<Room> searchRoom (int start, int end, Landmark landmark){
        ArrayList<Room> searchRoom3= new ArrayList<>();
        for(Room room10:loc(landmark.getPriority()[0])){
            if(room10.checkTA(start,end)){
                searchRoom3.add(room10);
            }
        }
        sort(searchRoom3);
        ArrayList<Room>bala=new ArrayList<>();
        for(Room room11:loc(landmark.getPriority()[1])){
            if(room11.checkTA(start,end)){
                bala.add(room11);
            }
        }searchRoom3.addAll(sort(bala));
        bala.clear();
        for(Room room12:loc(landmark.getPriority()[2])){
            if(room12.checkTA(start,end)){
                bala.add(room12);
            }
        }searchRoom3.addAll(sort(bala));
        bala.clear();
        return searchRoom3;
    }
    public static String showOrder (ArrayList<Room> list){
        StringBuilder order = new StringBuilder("");
        if (list.size() == 0) order = new StringBuilder("No room to show.");
        for (Room room : list) {
            order.append(room.toString());
        }
        return order.toString();
    }
    public static ArrayList<Room> loc(Library location){
        if(location==Library.Lynn){
            return roomInfoLynn;
        }
        else if(location==Library.Yidan){
            return roomInfoYidan;
        }
        else return roomInfoLearningNexus;
    }
    public static boolean checkRid(String rid,Library location){
        if (rid==null)return true;
        if(loc(location)==null)return false;
        for(Room room1 : loc(location)){
            if (rid.equals(room1.getRid())){
              return true;
            }
        }
        return false;
    }
    public static boolean checkRidName(String rid){
        return rid.charAt(0) != 'R' || Integer.parseInt(rid.substring(1,4)) <=100||rid.length()!=4;
    }
    public static boolean checkOrder(String SID,Library library){
        for(Room room2:loc(library)){
            if (!room2.checkApplicants(SID))return false;
        }
        return true;
    }
    public static boolean checkRoomRid(String rid,Library library){
        if (rid==null)return false;
        for (Room room3:loc(library)){
            if (rid.equals(room3.getRid()))return true;
        }return false;
    }//看看有没有这个房间
    public static boolean checkDB(boolean Display,boolean Whiteboard,Room room){
        return (room.isHasDisplay() || !Display) && (!Whiteboard || room.isHasWhiteboard());
    }
    public static ArrayList<Room>sort(ArrayList<Room> bala){
        boolean f=false;
        while (!f){
            f=true;
            for (int i=0;i<bala.size()-1;i++){
                if(Integer.parseInt(bala.get(i).getRid().substring(1))>Integer.parseInt(bala.get(i+1).getRid().substring(1))){
                    Room r=bala.get(i);
                    bala.set(i,bala.get(i+1));
                    bala.set(i+1,r);
                    f=false;
                }
            }
        }
        return bala;
    }

}
