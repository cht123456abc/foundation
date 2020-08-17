package cn.edu.scu.gof.flyweight;

/**
 * 享元类
 */
public interface ChessFlyWeight {

    void setColor(String color);

    String getColor();

    void display(Coordinate coordinate);



}

class ConcreteChess implements ChessFlyWeight {
    private String color;

    public ConcreteChess(String color) {
        this.color = color;
    }

    @Override
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public void display(Coordinate coordinate) {
        System.out.println("棋子的颜色:" + color);
        System.out.println("棋子的位置:" + coordinate.getX() + "," + coordinate.getY());
    }
}
