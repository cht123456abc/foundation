package cn.edu.scu.gof.composite;

// 抽象节点，相当于树根
public interface Component {

    void operation();
}

// 叶子节点
interface Leaf extends Component {


}

// 容器节点
interface Composite extends Component {

    void add(Component C);

    void remove(Component C);

    Component getChild(int index);

}
