// Builder -  create complex objects.separates object construction from its representation

// 产品Product：被构建的复杂对象, 包含多个组成部分。
// 抽象建造者Builder: 定义构建产品各个部分的抽象接口和一个返回复杂产品的方法getResult
// 具体建造者Concrete Builder：实现抽象建造者接口，构建产品的各个组成部分，并提供一个方法返回最终的产品。
// 指导者Director：调用具体建造者的方法，按照一定的顺序或逻辑来构建产品。
// TestBuilder Junit 

class product{

}
interface Builder {

}
class ConcreteBuilder implements Builder{

}
class Director {}
public class Main{
    public static void main(String[] args) {
        
    }
}