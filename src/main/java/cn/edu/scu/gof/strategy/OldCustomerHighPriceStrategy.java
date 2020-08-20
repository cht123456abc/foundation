package cn.edu.scu.gof.strategy;

public class OldCustomerHighPriceStrategy implements Strategy {

    @Override
    public double getPrice(double standardPrice) {
        System.out.println("打8折");
        return 0.8 * standardPrice;
    }
}
