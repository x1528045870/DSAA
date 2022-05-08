package lab7;
import java.util.Scanner;
public class FoodTest {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int id[]={1,2,3,4};
        String food[]=new String[4];
        String type[]={"Seafood","Beef","Seafood","Beef"};
        String name[]={"pizza","pizza","fried rice","noodles"};
        int size[]={11,9,5,6};
        double price[]={12,10,12,14};
        System.out.print("Generate a user,please input name:");

        Food menu=new Food();
        for(int i=0;i<4;i++) {
            menu.setId(id[i]);
            menu.setName(name[i]);
            menu.setPrice(price[i]);
            menu.setSize(size[i]);
            menu.setType(type[i]);
            menu.showInformation();
        }
        in.close();}}