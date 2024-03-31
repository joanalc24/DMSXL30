/* Abstract Factory- creates an instance of several families of classes
Abstract Factory. Allows the creation of objects without specifying their concrete type.
Factory Method. Creates objects without specifying the exact class to create.
简单工厂模式：一个工厂方法创建所有具体产品
工厂方法模式：一个工厂方法创建一个具体单一的产品. IphoneFactory, SamsungFactory
抽象工厂模式：一个工厂方法可以创建一类具体产品: IphonePro, IphoneX, IphoneS

抽象工厂模式可以确保一系列相关的产品被一起创建，这些产品能够相互配合使用，再举个例子，有一些家具，比如沙发、茶几、椅子，都具有古典风格的和现代风格的，抽象工厂模式可以将生产现代风格的家具放在一个工厂类中，将生产古典风格的家具放在另一个工厂类中，这样每个工厂类就可以生产一系列的家具。

基本结构
抽象工厂模式包含多个抽象产品接口，多个具体产品类，一个抽象工厂接口和多个具体工厂，每个具体工厂负责创建一组相关的产品。

抽象产品接口AbstractProduct: 定义产品的接口，可以定义多个抽象产品接口，比如说沙发、椅子、茶几都是抽象产品。
具体产品类ConcreteProduct: 实现抽象产品接口，产品的具体实现，古典风格和沙发和现代风格的沙发都是具体产品。
抽象工厂接口AbstractFactory: 声明一组用于创建产品的方法，每个方法对应一个产品。
具体工厂类ConcreteFactory： 实现抽象工厂接口，负责创建一组具体产品的对象，在本例中，生产古典风格的工厂和生产现代风格的工厂都是具体实例。
*/

/**
 * 
3
modern
classical
modern
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        for(int i = 0; i < count; i++) {
            String type = scanner.next(); // not nextline
            FurnitureFactory factory = null;
            if(type.equals("modern")) {
                factory = new ModernFurnitureFactory();
            } else {
                factory = new ClassicalFurnitureFactory();
            }
            Chair chair = factory.createChair();
            chair.showInfo();
            Sofa sofa = factory.createSofa();
            sofa.showInfo();
            
        }
    }
}

interface FurnitureFactory {
    Chair createChair();
    Sofa createSofa();
}
class ModernFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {return new ModernChair();}
    @Override
    public Sofa createSofa() {return new ModernSofa();}
}
class ClassicalFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {return new ClassicalChair();}
    @Override
    public Sofa createSofa() {return new ClassicalSofa();}
}

interface Chair { void showInfo(); }
class ModernChair implements Chair {
    @Override
    public void showInfo() {System.out.println("modern chair");}
}
class ClassicalChair implements Chair {
    @Override
    public void showInfo() {System.out.println("classical chair");}
}
interface Sofa { void showInfo(); }
class ModernSofa implements Sofa {
    @Override
    public void showInfo() {System.out.println("modern sofa");}
}
class ClassicalSofa implements Sofa {
    @Override
    public void showInfo() {System.out.println("classical sofa");}
}
