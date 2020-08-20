package cn.edu.scu.gof.strategy;

public class NewCustomerHighPriceStrategy implements Strategy {

    @Override
    public double getPrice(double standardPrice) {
        System.out.println("打9折");
        return 0.9 * standardPrice;
    }
}
