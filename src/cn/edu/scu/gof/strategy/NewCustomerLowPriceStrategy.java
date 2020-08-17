package cn.edu.scu.gof.strategy;

public class NewCustomerLowPriceStrategy implements Strategy {

    @Override
    public double getPrice(double standardPrice) {
        System.out.println("不打折");
        return standardPrice;
    }
}
