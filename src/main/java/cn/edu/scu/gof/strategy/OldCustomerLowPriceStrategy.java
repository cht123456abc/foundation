package cn.edu.scu.gof.strategy;

public class OldCustomerLowPriceStrategy implements Strategy {


    @Override
    public double getPrice(double standardPrice) {
        System.out.println("打8.5折");
        return 0.85 * standardPrice;
    }
}
