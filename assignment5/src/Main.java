

public class Main {
    String name ;
    String abbrevName;// JavaA

    public Main(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAbbrevName(String abbrevName) {
        this.abbrevName = abbrevName;
    }

    public static void main(String[] args) {
        Main a=new Main( "Introduction to Computer Programming A");
      System.out.println(a.getAbbrevName());
    }

    public String getAbbrevName() {
        if (this.abbrevName.equals("")) {
            StringBuilder a = new StringBuilder();
            for (int i = 0; i < getName().length(); i++) {
                if (getName().charAt(i) >= 65 && getName().charAt(i) <= 90) a.append(getName().charAt(i));
            }
            abbrevName = String.valueOf(a);
        }

        return abbrevName;
    }
}