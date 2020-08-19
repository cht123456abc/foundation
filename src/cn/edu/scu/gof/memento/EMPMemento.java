package cn.edu.scu.gof.memento;

public class EMPMemento {

    private String name;
    private Integer age;
    private Integer salary;

    public EMPMemento(EMP emp) {
        this.name = emp.getName();
        this.age = emp.getAge();
        this.salary = emp.getSalary();
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
