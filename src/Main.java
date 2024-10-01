public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
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