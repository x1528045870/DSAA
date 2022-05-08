package lab7;
public class CircleTest {
    public static void main(String[] args) {
        Circle c1=new Circle();//通过new的方法生成对象c1
        Circle []circleList=new Circle[5];
        circleList[0]=c1;
        c1.setRadius(5);
        for(int i=1;i<5;i++) {
            circleList[i] = new Circle();//因为存放的是对象的地址，因此需要生成一个对象。
            circleList[i].setRadius(i);
            circleList[i].setX(Math.random()*5);
            circleList[i].setY(Math.random()*5);
        }
        System.out.println("---Begin to print the circle list---");
        System.out.printf("Radius of %d circle is %.2f: \n",1,circleList[0].getRadius());
        for(int i=0;i<5;i++) {
            System.out.printf("The area of %d circle is %.2f\n",
                    i+1, circleList[i].area());
            System.out.printf("The perimeter is %.2f\n",
                    circleList[i].perimeter());
        }
        c1.position();
    }
}

