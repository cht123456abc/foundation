package cn.edu.scu.gof.memento;

public class EMP {
    private String name;
    private Integer age;
    private Integer salary;

    public EMP(String name, Integer age, Integer salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    // 备份，并返回备忘录对象
    public EMPMemento memento() {
        return new EMPMemento(this);
    }

    // 恢复
    public void recovery(EMPMemento memento) {
        this.name = memento.getName();
        this.age = memento.getAge();
        this.salary = memento.getSalary();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }
}
