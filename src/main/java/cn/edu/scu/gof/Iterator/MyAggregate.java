package cn.edu.scu.gof.Iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义聚合类
 */
public class MyAggregate {

    private List<Object> list = new ArrayList<>();

    public void add(Object object) {
        this.list.add(object);
    }

    public void remove(Object object) {
        this.list.remove(object);
    }

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }

    public MyIterator createIterator() {
        return new ConcreteIterator(0);
    }

    /**
     * 使用内部类实现迭代器，可以直接访问外部属性
     */
    private class ConcreteIterator implements MyIterator {
        private int cursor;

        public ConcreteIterator(int cursor) {
            this.cursor = cursor;
        }

        @Override
        public void first() {
            this.cursor = 0;
        }

        @Override
        public void next() {
            if (hasNext()) {
                cursor++;
            }
        }

        @Override
        public boolean hasNext() {
            return cursor < list.size();
        }

        @Override
        public boolean isFirst() {
            return this.cursor == 0;
        }

        @Override
        public boolean isLast() {
            return this.cursor == list.size() - 1;
        }

        @Override
        public Object getCurrentObj() {
            return list.get(cursor);
        }
    }
}
