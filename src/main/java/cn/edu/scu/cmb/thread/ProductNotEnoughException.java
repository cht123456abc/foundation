package cn.edu.scu.cmb.thread;

public class ProductNotEnoughException extends RuntimeException {

    public ProductNotEnoughException(String message) {
        super(message);
    }
}
