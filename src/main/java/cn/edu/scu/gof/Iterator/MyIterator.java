package cn.edu.scu.gof.Iterator;

public interface MyIterator {

    void first();

    void next();

    boolean hasNext();

    boolean isFirst();

    boolean isLast();

    Object getCurrentObj();

}
