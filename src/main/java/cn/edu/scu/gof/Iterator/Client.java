package cn.edu.scu.gof.Iterator;

public class Client {
    public static void main(String[] args) {

        MyAggregate aggregate = new MyAggregate();

        aggregate.add("aa");
        aggregate.add("bb");
        aggregate.add("cc");

        MyIterator iterator = aggregate.createIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.getCurrentObj());
            iterator.next();
        }
    }
}
