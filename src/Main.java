import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
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

        //Посчитать, сколько роботов смотрят в каждом направлении
        Map<Directions, Integer> directionCount = new HashMap<>();
        for (Robot rob: robots){
            Directions dir = rob.direction;
            int count = directionCount.getOrDefault(dir, 0);
            directionCount.put(dir, count+1);
        }

        System.out.println("directionCount = " + directionCount);
        
        List<Robot> robots2 = loadRobots("input");
        System.out.println("robots2 = " + robots2);
    }

    public static List<Robot> loadRobots(String filePath) {
        List<Robot> robots = new LinkedList<>();
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                int x = Integer.parseInt(parts[0].trim());
                int y = Integer.parseInt(parts[1].trim());
                Directions direction = Directions.valueOf(parts[2].trim());
                robots.add(new Robot(x, y, direction));
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + e.getMessage());
        } return robots;
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