package lab7;
public class Food {
    private int id;
    private String name;
    private String type;
    private int size;
    double price;
    public void showInformation(){
        System.out.printf("[id] %-1d  [type] %-11s[name] %-11s [size] %2d (Inches) %-1.2f $\n",id,type,name,size,price);
    }//注意其中的一些对齐方法。
    public int getId() { return id; }
    public String getName() { return name; }
    public String getType() { return type; }
    public int getSize() { return size; }
    public double getPrice() { return price; }
    public void setId(int id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setPrice(double price) { this.price = price; }
    public void setSize(int size) { this.size = size; }
    public void setType(String type) { this.type = type; }
}
