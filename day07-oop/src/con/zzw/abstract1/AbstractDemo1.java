package con.zzw.abstract1;

public class AbstractDemo1 {
    // 认识抽象类和抽象方法 abstract
    // 抽象类：包含抽象方法的类必须是抽象类
    // 抽象方法：只有方法声明，没有方法体，以分号结尾
    // 抽象类最主要的d作用是被继承，抽象方法必须被子类重写,为了更好的支持多态
    public static void main(String[] args) {
        // 抽象类不能实例化
        // Animal a = new Animal(); // 错误写法
        Animal dog = new Dog();
        dog.eat(); // 狗吃骨头
        dog.sleep();
    }


}
