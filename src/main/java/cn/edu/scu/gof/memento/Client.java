package cn.edu.scu.gof.memento;

public class Client {

    public static void main(String[] args) {

        CareTaker careTaker = new CareTaker();

        EMP emp = new EMP("cht", 17, 2000);
        System.out.println(emp.getName() + "___" + emp.getAge() + "___" + emp.getSalary() + "___");
        careTaker.setMemento(emp.memento());

        emp.setName("hahaha");
        emp.setAge(10);
        emp.setSalary(20000);
        System.out.println(emp.getName() + "___" + emp.getAge() + "___" + emp.getSalary() + "___");

        emp.recovery(careTaker.getMemento());
        System.out.println(emp.getName() + "___" + emp.getAge() + "___" + emp.getSalary() + "___");
    }
}
