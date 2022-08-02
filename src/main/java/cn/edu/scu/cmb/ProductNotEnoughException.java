package cn.edu.scu.cmb;

public class ProductNotEnoughException extends RuntimeException {

    public ProductNotEnoughException(String message) {
        super(message);
    }
}
