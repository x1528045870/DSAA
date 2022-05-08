import javax.swing.*;
import java.util.ArrayList;

public class Room {
    private String rid;
    private Library location = Library.Lynn;
    private int capacity = 3;
    private boolean hasDisplay = true;
    private boolean hasWhiteboard = true;
    private String[] applicants = new String[15];
    public Room(String rid) {
        this.rid = rid;
    }
    public Room(String rid, Library location, int capacity) {
        this.rid = rid;
        this.location = location;
        this.capacity = capacity;
    }
    public Room(String rid, Library library, int capacity, boolean hasDisplay, boolean hasWhiteboard) {
        this.rid = rid;
        this.location = library;
        this.capacity = capacity;
        this.hasDisplay = hasDisplay;
        this.hasWhiteboard = hasWhiteboard;
    }
    public String toString() {
       return toString(8,22);
    }
    public String toString(int start, int end) {
        if (start < 8 || end > 22 || end < 9 || end <= start) {
            return null;
        } else {
            StringBuilder toString = new StringBuilder(location + " " + rid + ", capacity=" + capacity + ", hasDisplay=" + hasDisplay + ", hasWhiteboard=" + hasWhiteboard + "\n");
            for (int i = start; i <= end - 1; i++) {
                if (i < 10)
                    toString.append("|").append("0").append(i).append(":00   ");
                else toString.append("|").append(i).append(":00   ");
            }
            toString.append("|").append("\n");
            for (int i = start - 8; i < end - 8; i++) {
                 if (applicants[i] == null) {
                    toString.append("|EMPTY   ");
                } else if ( applicants[i].equals(applicants[i + 1]) ) {
                     toString.append("|").append(applicants[i]).append("         ");
                     i++;}
                 else {
                    toString.append("|").append(applicants[i]);
                }
            }
            toString.append("|").append("\n");
            return toString.toString();
        }
    }
    public boolean setApplicant(int start, int end, String SID, int numberOfTeammates) {
        int time = end - start;
        if (start < 8 || end > 22 || time <=0 || time > 2||SID==null|| numberOfTeammates > capacity - 1 ||numberOfTeammates < 0) {
            return false;
        }
        for(int i=0;i<=14;i++){
            if(SID.equals(applicants[i]))return false;
        }
        if (applicants[start - 8] != null || applicants[end - 9] != null) {return false;}
            else {
                applicants[start - 8] = SID;
                applicants[end - 9] = SID;return  true;
            }
        }
    public boolean removeApplicant(String SID) {
        boolean b = false;
        if(SID==null){
            return false;
        }
        for (int i = 0; i < applicants.length; i++) {
            if (SID.equals(applicants[i]) ) {
                applicants[i] = null;
                b = true;
            }
        }
        return b;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public void setLocation(Library location) {
        this.location = location;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setHasDisplay(boolean hasDisplay) {
        this.hasDisplay = hasDisplay;
    }

    public void setHasWhiteboard(boolean hasWhiteboard) {
        this.hasWhiteboard = hasWhiteboard;
    }

    public void setApplicants(String[] applicants) {
        this.applicants = applicants;
    }

    public String getRid() {
        return rid;
    }

    public Library getLocation() {
        return location;
    }

    public int getCapacity() {
        return capacity;
    }

    public boolean isHasDisplay() {
        return hasDisplay;
    }

    public boolean isHasWhiteboard() {
        return hasWhiteboard;
    }

    public String[] getApplicants() {
        return applicants;
    }

    public boolean checkApplicants(String SID){//判断这个room有没有被预定过
        for(int i=0;i<=14;i++){
            if(SID.equals(applicants[i]))return false;
        }
        return true;
    }
    public boolean checkTA(int start,int end){//判断时间段room有没有预定过
        int time = end - start;
        if (start < 8 || end > 22 || time <=0||time>2 ) {
            return false;
        }
        if (applicants[start - 8] != null || applicants[end - 9] != null) {return false;}
        return true;
    }

}