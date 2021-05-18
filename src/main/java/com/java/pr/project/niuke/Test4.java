package com.java.pr.project.niuke;

public class Test4 {
    /**
     * Java和C++的区别：
     * 1. Java是解释型语言，所谓的解释型语言，就是源码会先经过一次编译，成为中间码，中间码再被解释器解释成机器码。
     * 对于Java而言，中间码就是字节码(.class)，而解释器在JVM中内置了。
     * 2. C++是编译型语言，所谓编译型语言，就是源码一次编译，直接在编译的过程中链接了，形成了机器码。
     * 3. C++比Java执行速度快，但是Java可以利用JVM跨平台。
     * 4. Java是纯面向对象的语言，所有代码（包括函数、变量）都必须在类中定义。而C++中还有面向过程的东西，比如是全局变量和全局函数。
     * 5. C++中有指针，Java中没有，但是有引用。
     * 6. C++支持多继承，Java中类都是单继承的。但是继承都有传递性，同时Java中的接口是多继承，类对接口的实现也是多实现。
     * 7. C++中，开发需要自己去管理内存，但是Java中JVM有自己的GC机制，虽然有自己的GC机制，但是也会出现OOM和内存泄漏的问题。
     * C++中有析构函数，Java中Object的finalize方法
     * 8. C++运算符可以重载，但是Java中不可以。同时C++中支持强制自动转型，Java中不行，会出现ClassCastException（类型不匹配）。
     */


    /**
     * 程序设计六大原则
     * 1、开闭原则（Open Close Principle）
     * 开闭原则的意思是：对扩展开放，对修改关闭。在程序需要进行拓展的时候，不能去修改原有的代码，实现一个热插拔的效果。简言之，是为了使程序的扩展性好，易于维护和升级。
     *
     * 2、里氏代换原则（Liskov Substitution Principle）
     * 里氏代换原则是面向对象设计的基本原则之一。 里氏代换原则中说，任何基类可以出现的地方，子类一定可以出现。LSP 是继承复用的基石，只有当派生类可以替换掉基类，且软件单位的功能不受到影响时，基类才能真正被复用，而派生类也能够在基类的基础上增加新的行为。里氏代换原则是对开闭原则的补充。实现开闭原则的关键步骤就是抽象化，而基类与子类的继承关系就是抽象化的具体实现，所以里氏代换原则是对实现抽象化的具体步骤的规范。
     *
     * 3、依赖倒转原则（Dependence Inversion Principle）
     * 这个原则是开闭原则的基础，具体内容：针对接口编程，依赖于抽象而不依赖于具体。
     *
     * 4、接口隔离原则（Interface Segregation Principle）
     * 这个原则的意思是：使用多个隔离的接口，比使用单个接口要好。它还有另外一个意思是：降低类之间的耦合度。由此可见，其实设计模式就是从大型软件架构出发、便于升级和维护的软件设计思想，它强调降低依赖，降低耦合。
     *
     * 5、迪米特法则，又称最少知道原则（Demeter Principle）
     * 最少知道原则是指：一个实体应当尽量少地与其他实体之间发生相互作用，使得系统功能模块相对独立。
     *
     * 6、合成复用原则（Composite Reuse Principle）
     * 合成复用原则是指：尽量使用合成/聚合的方式，而不是使用继承
     */
}
