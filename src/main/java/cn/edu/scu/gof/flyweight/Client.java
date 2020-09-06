package cn.edu.scu.gof.flyweight;

public class Client {
    public static void main(String[] args) {

        // 取黑色棋子并放入一个位置
        ChessFlyWeight chess1 = ChessFactory.getChess("black");
        System.out.println(chess1);
        chess1.display(new Coordinate(10,10));
        // 取同样的黑色棋子放入令一个位置
        ChessFlyWeight chess2 = ChessFactory.getChess("black");
        System.out.println(chess2);
        chess2.display(new Coordinate(10, 30));


    }
}
