package cn.edu.scu.gof.state;

public class Client {
    public static void main(String[] args) {
        HomeContext context = new HomeContext();

        context.setState(new FreeState());
        context.setState(new BookedState());
        context.setState(new CheckedInState());
    }
}
