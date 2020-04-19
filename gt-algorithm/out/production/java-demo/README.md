# java-demo
## design-pattern 设计模式
### builder 建造者模式
建造者模式一定存在两个部分，一个是构件构造，一个是整体构建的算法
#### b1 一个简单的构造者模式demo
- product 产品类
一个产品可能会有多个零件
- builder 组装者
用于定义如果构建各个部件
- director 导演者
director用于控制如果构建产品，也就是负责整体的算法，通常是分步骤执行

#### b2 一个邮件自动发送工厂
- AutomMessage 邮件抽象类，部件类并不一定要抽象
## multit thread 多线程
- exception:
    在线程中抛出异常和对异常的捕获
    - 如果线程没有专有的uncaughtException方法，则会调用defaultUncaughtExceptionHandler
- executor:
    几种线程池的创建方式
- inner:
    通过内部类的形式，展示创建线程的几种方式。
     
- sync:
    线程资源共享
    synchronized
    原子性和易变性
    volatile
    
    