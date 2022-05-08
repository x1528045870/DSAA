package lab11;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class ShapeTest {
    public static void main(String[] args) {
//        Shape sa = new Shape(0,0);
        List<Circle> circleList = new ArrayList<>();
        Circle.setScreenSize(14);
        StdDraw.setScale(-Shape.getScreenSize(), Shape.getScreenSize());
        for (int i = 0; i < Shape.getScreenSize(); i += 2) {
            circleList.add(new Circle(i, 0, -Shape.getScreenSize()));
        }
        Collections.sort(circleList);
        for (int i = 0; i < circleList.size(); i++) {
            circleList.get(i).setColor(ShapeColor.values()[i%3]);
            circleList.get(i).draw();
        }

        Collections.sort(circleList);

        for (int i = 0; i < circleList.size(); i++) {
            circleList.get(i).customizedColor(ColorScheme.RAINBOW, i);
       }
    }
}
