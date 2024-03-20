/**
 * Factory Method - creates an instance of several derived classes
VS Abstract Factory. Allows the creation of objects without specifying their concrete type.
Factory Method. Creates objects without specifying the exact class to create.

引入了抽象工厂和具体工厂的概念，每个具体工厂只负责创建一个具体产品，添加新的产品只需要添加新的工厂类而无需修改原来的代码，这样就使得产品的生产更加灵活，支持扩展，符合开闭原则。
“手机Phone”这个产品举例，手机是一个抽象产品，小米手机、华为手机、苹果手机是具体的产品实现，而不同品牌的手机在各自的生产厂家生产。
抽象工厂：一个接口，包含一个抽象的工厂方法（用于创建产品对象 Phone）。
具体工厂：实现抽象工厂接口，创建具体的产品。(Iphone, SamsungPhone)
抽象产品：定义产品的接口。PhoneFactory
具体产品：实现抽象产品接口，是工厂创建的对象。IPhoneFactory, SamsungPhoneFactory

 * 小明家有两个工厂，一个用于生产Iphone，一个用于SamsungPhone
    设计一个Phone工厂系统，记录Phone生产的信息。
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
// https://kamacoder.com/problempage.php?pid=1076
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PhoneFactorySystem phoneFactorySystem = new PhoneFactorySystem();
        
        int count = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < count; i++) {
            String[] inputLine = scanner.nextLine().split(" ");
            String type = inputLine[0];
            int quantity = Integer.parseInt(inputLine[1]);
            if(type.equals("Circle")) {
                phoneFactorySystem.producePhones(new IPhoneFactory(), quantity);
            } else if(type.equals("Square")) {
                phoneFactorySystem.producePhones(new SamsungPhoneFactory(), quantity);
            }
        }
    }
}
interface Phone {
    void produce();
} 
class IPhone implements Phone {
    @Override
    public void produce(){
        System.out.println("Circle Block");
    }
}
class Samsung implements Phone {
    @Override
    public void produce(){
        System.out.println("Square Block");
    }
}
interface PhoneFactory {
    Phone createPhone();
}
class IPhoneFactory implements PhoneFactory {
    @Override
    public Phone createPhone() {
        return new IPhone();
    }
}
class SamsungPhoneFactory implements PhoneFactory {
    @Override
    public Phone createPhone() {
        return new Samsung();
    }

}
class PhoneFactorySystem {
    List<Phone> phones = new ArrayList<>();
    public void producePhones(PhoneFactory phoneFactory, int quantity) {
        for(int i = 0; i < quantity; i++) {
            Phone phone = phoneFactory.createPhone();
            phone.produce();
            phones.add(phone);
        }
    }
    public List<Phone> getPhones() {
        return phones;
    }
}

// ****************************************************************************
// 抽象产品
interface Shape {
    void draw();
}

// 具体产品 - 圆形
class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Circle");
    }
}

// 具体产品 - 正方形
class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Square");
    }
}

// 抽象工厂
interface ShapeFactory {
    Shape createShape();
}

// 具体工厂 - 创建圆形
class CircleFactory implements ShapeFactory {
    @Override
    public Shape createShape() {
        return new Circle();
    }
}

// 具体工厂 - 创建正方形
class SquareFactory implements ShapeFactory {
    @Override
    public Shape createShape() {
        return new Square();
    }
}

public class Client {
    public static void main(String[] args) {
        ShapeFactory circleFactory = new CircleFactory();
        Shape circle = circleFactory.createShape();
        circle.draw();  // 输出：Circle

        ShapeFactory squareFactory = new SquareFactory();
        Shape square = squareFactory.createShape();
        square.draw();  // 输出：Square
    }
}

/**
 * 小明家有两个工厂，一个用于生产Iphone，一个用于SamsungPhone，请你帮他设计一个Phone工厂系统，记录Phone生产的信息。
In:
```
3 // 生产次数
Circle 1
Square 2
Circle 1
```
Out: 
```
Circle Lego
Square Lego
Square Lego
Circle Lego
```
 */