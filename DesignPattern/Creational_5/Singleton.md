# Singleton
1. Create only one single instance of a class // Singleton()
2. Provide provide only one global access point to that object. // getInstance()
eg: Calendar

## Usage scenario
1. 资源共享
多个模块共享某个资源的时候，比如说应用程序需要一个global配置管理器来store and manage配置信息、或manage DB connection pool。
2. 只有一个实例
当系统中某个类只需要一个实例来协调行为的时候， 比如说管理应用程序中的缓存，确保只有一个缓存实例，避免重复的缓存创建和管理，或者使用单例模式来创建和管理thread pool。
3. 懒加载
如果对象创建本身就比较消耗资源，而且可能在整个程序中都不一定会使用，可以使用单例模式实现懒加载。

在许多流行的工具和库中，也都使用到了单例设计模式，比如Java中的Runtime类就是一个经典的单例，表示程序的运行时环境。此外 Spring 框架中的应用上下文 (ApplicationContext) 也被设计为单例，以提供对应用程序中所有 bean 的集中式访问点。

## Initialization
Initialization with Double Lock
- A private static variable, holding the only instance of the class.
- A private constructor, so it cannot be instantiated anywhere else.
- A public static method, to return the single instance of the class.
```
// double locking is used to reduce the overhead of the synchronized method
public static ThreadSafeSingleton getInstanceDoubleLocking() {
	if (instance == null) {
		synchronized (ThreadSafeSingleton.class) {
			if (instance == null) {
				instance = new ThreadSafeSingleton();
			}
		}
	}
	return instance;
}
```
## Example
https://kamacoder.com/problempage.php?pid=1074
Description: 小明去了一家大型商场，拿到了一个购物车，并开始购物。请你设计一个购物车管理器，记录商品添加到购物车的信息（商品名称和购买数量），并在购买结束后打印出商品清单。（在整个购物过程中，小明只有一个购物车实例存在）。
输入
- 包含若干行，每行包含两部分信息，分别是商品名称和购买数量。商品名称和购买数量之间用空格隔开。
```
Apple 3
Banana 2
Orange 5
```
输出
- 包含小明购物车中的所有商品及其购买数量。每行输出一种商品的信息，格式为 "商品名称 购买数量"。
```
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        // get the instance 
        ShoppingCartManager cart = ShoppingCartManager.getInstance();
        
        while(scanner.hasNext()) {
            String name = scanner.next();
            int quantity = scanner.nextInt();
            cart.addToCart(name, quantity);
            
        }
        cart.viewCart();
    }
}
class ShoppingCartManager {
    // private, static, final
    private static final ShoppingCartManager instance = new ShoppingCartManager();
    
    public static ShoppingCartManager getInstance() { // must be static
        return instance;
    }
    
    private Map<String, Integer> cart;
    private ShoppingCartManager() {
        cart = new LinkedHashMap<>(); 
    }
    
    public void addToCart(String name, Integer quantity) {
        cart.put(name, cart.getOrDefault(name, 0) + quantity);
    }
    public void viewCart() {
        for(Map.Entry<String, Integer> entry : cart.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
    
}
```


----
## Notes
Derived from 3 kinds of initiations
### A: Eager； 先建再说
饿汉式指的是在类加载时就已经完成了实例的创建，不管后面创建的实例有没有使用，先创建再说
Initialized outside 
```
public class EagerSingleton {
    // A private static variable, holding the only instance of the class.
    private static EagerSingleton instance = new EagerSingleton();

    // private constructor, so it cannot be instantiated anywhere else
	private EagerSingleton() {  }

	// public static method, get the only instance of the object created.
	public static EagerSingleton getInstance() {
		return instance;
	}
}
```
### B: Lazy;需要再建
Initialize as null, and initialized within the LazySingleton class; Create 2 instance if both access to milli-seconds. 
懒汉式指的是只有在请求实例时才会创建，如果在首次请求时还没有创建，就创建一个新的实例，如果已经创建，就返回已有的实例，意思就是需要使用了再创建
```
public class LazySingleton {
	// initialize the instance as null.
	private static LazySingleton instance = null;

	// private constructor, so it cannot be instantiated outside this class.
	private LazySingleton() {  }

	// check if the instance is null, and if so, create the object.
	public static LazySingleton getInstance() {
		if (instance == null) {
			instance = new LazySingleton();
		}
		return instance;
	}
}
```
### C: Thread-safe
Thread-safe but only used on the first time, overhead
```
public class ThreadSafeSingleton {
	// initialize the instance as null.
	private static ThreadSafeSingleton instance = null;

	// private constructor, so it cannot be instantiated outside this class.
	private ThreadSafeSingleton() {  }

	// check if the instance is null, within a synchronized block. If so, create the object
	public static ThreadSafeSingleton getInstance() {
		synchronized (ThreadSafeSingleton.class) {
			if (instance == null) {
				instance = new ThreadSafeSingleton();
			}
		}
		return instance;
	}
}
```