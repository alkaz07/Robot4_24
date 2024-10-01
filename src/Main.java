import java.util.LinkedList;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        //Сделать список из нескольких роботов с  разными исходными координатами и направлениями
        List<Robot> robots = new LinkedList<>();
        robots.add(new Robot(1, 2, Directions.North));
        robots.add(new Robot(22, 3, Directions.North));
        robots.add(new Robot(4, 44, Directions.North));
        robots.add(new Robot(0, 12, Directions.East));
        robots.add(new Robot(3, 22, Directions.West));
        robots.add(new Robot(200, 2, Directions.South));
        robots.add(new Robot(100, 12, Directions.South));
        //Отфильтровать в новый список тех кто смотрит на Юг
       /* List<Robot> southWatchers = robots.stream()
                                        .filter(rob -> rob.direction == Directions.South)
                                        .toList();*/
        List<Robot> southWatchers = new LinkedList<>();
        for (Robot rob: robots)
            if(rob.direction  == Directions.South)
                southWatchers.add(rob);

        System.out.println("southWatchers = " + southWatchers);
    }
}

enum Directions{
    North, East, South, West;
}

class Robot{
    int x, y;
    Directions direction;
    public Robot(int x, int y, Directions direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "Robot{" +
                "x=" + x +
                ", y=" + y +
                ", direction=" + direction +
                '}';
    }

    public void turnLeft(){
        switch (direction){
            case Directions.East : direction = Directions.North;    break;
            case Directions.North: direction = Directions.West;     break;
            case Directions.South: direction = Directions.East;     break;
            case Directions.West:  direction = Directions.South;    break;
        }
    }
    public void turnRight(){
        switch (direction){
            case Directions.East : direction = Directions.South;    break;
            case Directions.North: direction = Directions.East;     break;
            case Directions.South: direction = Directions.West;     break;
            case Directions.West:  direction = Directions.North;    break;
        }
    }
}