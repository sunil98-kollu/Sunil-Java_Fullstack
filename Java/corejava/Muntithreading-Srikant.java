multi threading
......................

y mt
 reduce the response time of the application
 
 wt is thread 
    thread is a lightweight process
    t allows a program to perform multiple tasks simultaneously.
    thread isa term came from multitasking

multithreading is  a part of multitaskig 
executing multiple task simultanously concept of multiitasking

    PBM :- process based multi-tasking( os level ex zoom web crome )
    In PBM, multiple independent processes/applications run at the same time.
    Real-Time Example
...........................
While attending a meeting in Zoom:

Music playing in Spotify
Download running in browser
VS Code open for coding

All are separate processes.


    TPM :- thread based multi-tasking ( is programig level ex java)
    In TBM, multiple threads execute inside a single process.
Example 2: Banking Application

Inside one banking app:

Balance check thread
Money transfer thread
SMS notification thread
All run simultaneously.



    min{
        syso( thread.currentThread() );
    }


    2 ways  create 
    extends Thread 
    implements Runnable interface 

    1) create classs extends thread 
    override run method 
    create thread obj 
    m.start 

    implement runable interface 
    override run method
    create obj of class which implements runnable interface
    create thread obj by passing above obj as argument to thread constructor

class MyThread extends Thread {

    @Override
    public void run() {
        System.out.println("Thread class example");
    }
}

public class Main {

    public static void main(String[] args) {

        MyThread t = new MyThread();

        t.start();
    }

class MyTask implements Runnable {

    @Override
    public void run() {
        System.out.println("Runnable example");
    }
}

public class Main {

    public static void main(String[] args) {

        Thread t = new Thread(new MyTask());

        t.start();
    }
}

or 

public static void main(String[] args) {

         MyTask task = new MyTask();
        Thread t = new Thread(task);

        t.start();
    }
//////////////////////
///
    Thread t = new Thread(() -> {
    System.out.println("Thread running");
});

t.start();


thread schedular 
.......................
A Thread Scheduler is a part of the JVM that decides:

Which thread should run
When a thread should run
How long a thread should run
It manages execution of multiple threads.

Java does NOT directly control thread scheduling.

Java uses:

Operating System scheduler
JVM scheduler

So output order is not guaranteed.


class MyThread extends Thread {
    @override
    public void run() {
        for(int i = 1; i <= 5; i++) {
            System.out.println(Thread.currentThread().getName());
        }
    }
}

public class Main {

    public static void main(String[] args) {

        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();

        t1.start();
        t2.start();
    }
}

Possible Output
Thread-0
Thread-1
Thread-0
Thread-1

OR

Thread-1
Thread-1
Thread-0

Types of Thread Scheduling
1. Preemptive Scheduling
JVM pauses one thread and gives CPU to another thread.
Higher priority threads may get CPU first.

Example:

Video call app
Notification thread interrupts background task

Most modern OS use this.

2. Time Slicing / Round Robin
Each thread gets fixed CPU time.
After time expires, next thread executes.

Example:

Multiple browser tabs running simultaneously.

Thread Priority

Java provides priorities from:

1  -> MIN_PRIORITY
5  -> NORM_PRIORITY
10 -> MAX_PRIORITY

Priority	Value	Meaning
MIN_PRIORITY	1	Lowest chance to execute
NORM_PRIORITY	5	Default priority
MAX_PRIORITY	10	Highest chance to execute

Default priority = 5

Real-Time Example
Suppose:
Video rendering thread → priority 10
Background logging thread → priority 1

Scheduler may give more CPU time to video rendering.



    public void run() {

        for(int i = 1; i <= 3; i++) {

            System.out.println(
                Thread.currentThread().getName() +
                " Priority: " +
                Thread.currentThread().getPriority() +
                " Value: " + i
            );
        }
    }
}

public class Main {

    public static void main(String[] args) {

        MyThread t1 = new MyThread();
    
       MyThread t2 = new MyThread();

        // Setting priorities
        t1.setPriority(Thread.MAX_PRIORITY); // 10
        t2.setPriority(Thread.MIN_PRIORITY); // 1

        t1.setName("HighPriorityThread");
        t2.setName("LowPriorityThread");

        t1.start();
        t2.start();
    }
}

HighPriorityThread Priority: 10 Value: 1
HighPriorityThread Priority: 10 Value: 2
HighPriorityThread Priority: 10 Value: 3
LowPriorityThread Priority: 1 Value: 1
LowPriorityThread Priority: 1 Value: 2
LowPriorityThread Priority: 1 Value: 3

OR sometimes:

LowPriorityThread Priority: 1 Value: 1
HighPriorityThread Priority: 10 Value: 1
HighPriorityThread Priority: 10 Value: 2
LowPriorityThread Priority: 1 Value: 2
Why Output Changes?

Because:

Thread scheduling depends on JVM + Operating System
Priority is only a hint
Execution order is not guaranteed



Thread class constructors: 
1. Thread t=new Thread(); 
2. Thread t=new Thread(Runnable r); 
3. Thread t=new Thread(String name); 
 
JAVA Means DURGA SIR 
52 DURGASOFT, # 202,2ndFloor,HUDA Maitrivanam,Ameerpet, Hyderabad - 500038,  
 040 – 64 51 27 86, 80 96 96 96 96, 9246212143 | www.durgasoft.com 
 
4. Thread t=new Thread(Runnable r,String name); 
5. Thread t=new Thread(ThreadGroup g,String name); 
6. Thread t=new Thread(ThreadGroup g,Runnable r); 
7. Thread t=new Thread(ThreadGroup g,Runnable r,String name); 
8. Thread t=new Thread(ThreadGroup g,Runnable r,String name,long stackSize);


We can prevent(stop) a Thread execution by using the following methods.  
1. yield(); 
2. join(); 
3. sleep()

 yield() method causes "to pause current executing Thread for giving the chance 
of remaining 

class MyThread extends Thread 
{ 
 public void run() 
 { 
  for(int i=0;i<5;i++) 
  { 
   Thread.yield(); 
   System.out.println("child thread"); 
  } 
 } 
} 
class ThreadYieldDemo 
{ 
 public static void main(String[] args) 
 { 
  MyThread t=new MyThread(); 
  t.start(); 
  for(int i=0;i<5;i++) 
  { 
   System.out.println("main thread"); 
  } 
 }
}

 
Output: 
main thread 
main thread 
main thread 
main thread 
main thread 
child thread 
child thread 
child thread 
child thread 
child thread 
In the above program child Thread always calling yield() method and hence main 
Thread will get the chance more number of times for execution. 
Hence the chance of completing the main Thread first is high.  
 
Note : Some operating systems may not provide proper support for yield() method.  



Join(): 

 
If a Thread wants to wait until completing some other Thread then we should go for 
join() method.  
Example: If a Thread t1 executes t2.join() then t1 should go for waiting state until 
completing t2. 

{ 
 public void run() 
 { 
  for(int i=0;i<5;i++) 
  { 
   System.out.println("Sita Thread"); 
   try 
   { 
    Thread.sleep(2000); 
   } 
   catch (InterruptedException e){} 
  } 
 } 
} 
class ThreadJoinDemo 
{ 
 public static void main(String[] args)throws InterruptedException 
 { 
  MyThread t=new MyThread(); 
  t.start(); 
  //t.join(); //--->1 
  for(int i=0;i<5;i++) 
  { 
   System.out.println("Rama Thread"); 
  } 
 } 
}   

 If we are commenting line 1 then both Threads will be executed simultaneously 
and we can't expect exact execution order. 

 If we are not commenting line 1 then main Thread will wait until completing 
child Thread in this the output is sita Thread 5 times followed by Rama Thread 5 
times.



Waiting of child Thread untill completing main Thread : 
Example: 
class MyThread extends Thread 
{ 
 static Thread mt; 
 public void run() 
 { 
         try 
         { 
   mt.join();  
  } 
  catch (InterruptedException e){} 
  
 
  for(int i=0;i<5;i++) 
  { 
   System.out.println("Child Thread"); 
  } 
 } 
} 
class ThreadJoinDemo 
{ 
 public static void main(String[] args)throws InterruptedException 
 { 
  MyThread mt=Thread.currentThread(); 
  MyThread t=new MyThread(); 
  t.start(); 
 
  for(int i=0;i<5;i++) 
  { 
   Thread.sleep(2000); 
   System.out.println("Main Thread"); 
  } 
 } 
} 

Output : 
 
Main Thread 
Main Thread 
Main Thread 
 
 
 
Main Thread 
Main Thread 
Child Thread 
Child Thread 
Child Thread 
Child Thread 
Child Thread 
 
Note : 
If main thread calls join() on child thread object and child thread called join() on main 
thread object then both threads will wait for each other forever and the program will be 
hanged(like deadlock if a Thread class join() method on the same thread itself then the 
program will be hanged ).  

Sleep() method: 
If a Thread don't want to perform any operation for a particular amount of time then 
we should go for sleep() method.  
1. public static native void sleep(long ms) throws InterruptedException 
2. public static void sleep(long ms,int ns)throws InterruptedException 

{ 
 public static void main(String[] args)throws InterruptedException 
 { 
  System.out.println("M"); 
  Thread.sleep(3000); 
  System.out.println("E"); 
  Thread.sleep(3000); 
  System.out.println("G"); 
  Thread.sleep(3000); 
  System.out.println("A"); 
 } 
} 
Output: 
M 
E 
G 
A

Synchronization 
1. Synchronized is the keyword applicable for methods and blocks but not for 
classes and variables. 
2. If a method or block declared as the synchronized then at a time only one 
Thread is allow to execute that method or block on the given object. 
3. The main advantage of synchronized keyword is we can resolve date 
inconsistency problems. 
4. But the main disadvantage of synchronized keyword is it increases waiting time 
of the Thread and effects performance of the system. 
5. Hence if there is no specific requirement then never recommended to use 
synchronized keyword. 
6. Internally synchronization concept is implemented by using lock concept. 
7. Every object in java has a unique lock. Whenever we are using synchronized 
keyword then only lock concept will come into the picture. 
8. If a Thread wants to execute any synchronized method on the given object 1st it 
has to get the lock of that object. Once a Thread got the lock of that object then 
it's allow to execute any synchronized method on that object. If the synchronized 
method execution completes then automatically Thread releases lock. 
9. While a Thread executing any synchronized method the remaining Threads are 
not allowed execute any synchronized method on that object simultaneously. But 
remaining Threads are allowed to execute any non-synchronized method 
simultaneously. [lock concept is implemented based on object but not based on 
method]. 



Example: 
class Display 
{ 
 public synchronized void wish(String name) 
 { 
  for(int i=0;i<5;i++) 
  { 
   System.out.print("good morning:"); 
   try 
   { 
    Thread.sleep(1000);  
   } 
   catch (InterruptedException e) 
   {} 
   System.out.println(name); 
  } 
 } 
} 
class MyThread extends Thread 
{ 
 Display d; 
 String name; 
 MyThread(Display d,String name) 
 
 { 
  this.d=d; 
  this.name=name; 
 } 
 public void run() 
 { 
  d.wish(name); 
 } 
} 
class SynchronizedDemo 
{ 
 public static void main(String[] args) 
 { 
  Display d1=new Display(); 
  MyThread t1=new MyThread(d1,"dhoni"); 
  MyThread t2=new MyThread(d1,"yuvaraj"); 
  t1.start(); 
  t2.start(); 
 } 
} 

If we are not declaring wish() method as synchronized then both Threads will be 
executed simultaneously and we will get irregular output.  
Output: 
good morning:good morning:yuvaraj 
good morning:dhoni 
good morning:yuvaraj 
good morning:dhoni 
good morning:yuvaraj 
good morning:dhoni 
good morning:yuvaraj 
good morning:dhoni 
good morning:yuvaraj 
dhoni 
If we declare wish()method as synchronized then the Threads will be executed one by 
one that is until completing the 1st Thread the 2nd Thread will wait in this case we will 
get regular output which is nothing but  
Output: 
good morning:dhoni 
good morning:dhoni 
good morning:dhoni 
good morning:dhoni 
good morning:dhoni 
good morning:yuvaraj 
good morning:yuvaraj 
good morning:yuvaraj 
good morning:yuvaraj 
good morning:yuvaraj

Case study: 
Case 1: 
Display d1=new Display(); 
Display d2=new Display(); 
MyThread t1=new MyThread(d1,"dhoni"); 
MyThread t2=new MyThread(d2,"yuvaraj"); 
t1.start(); 
t2.start()
.........
.

class BankAccount {

    private int balance = 10000;

    public synchronized void withdraw(int amount) {

        if (balance >= amount) {

            balance -= amount;

            System.out.println(Thread.currentThread().getName()
                    + " withdrew " + amount);

            System.out.println("Remaining Balance: " + balance);

        } else {

            System.out.println(Thread.currentThread().getName()
                    + " : Insufficient Balance");
        }
    }
}

public class Main {

    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        Thread t1 = new Thread(() -> {
            account.withdraw(7000);
        }, "User1");

        Thread t2 = new Thread(() -> {
            account.withdraw(5000);
        }, "User2");

        t1.start();
        t2.start();
    }
}

Possible Output
User1 withdrew 7000
Remaining Balance: 3000
User2 : Insufficient Balance

OR

User2 withdrew 5000
Remaining Balance: 5000
User1 : Insufficient Ba

Synchronized block: 
1. If very few lines of the code required synchronization then it's never 
recommended to declare entire method as synchronized we have to enclose those 
few lines of the code with in synchronized block. 
2. The main advantage of synchronized block over synchronized method is it 
reduces waiting time of Thread and improves performance of the system. 


Locks only the required code.
Better performance.
More commonly used in real applications.

class BankAccount {

    private int balance = 1000;

    public void withdraw(int amount) {

        synchronized(this) {

            if(balance >= amount) {

                System.out.println(Thread.currentThread().getName()
                                   + " withdrawing " + amount);

                balance -= amount;

                System.out.println("Remaining Balance: " + balance);
            }
        }
    }
}

public class Main {

    public static void main(String[] args) {

        BankAccount account = new BankAccount();

        Thread t1 = new Thread(() -> account.withdraw(700), "User1");
        Thread t2 = new Thread(() -> account.withdraw(700), "User2");

        t1.start();
        t2.start();
    }
}
Why Synchronization?

Without synchronization:

User1 withdraws 700
User2 withdraws 700
Balance = -400

With synchronization:

User1 withdraws 700
Remaining Balance = 300
User2 cannot withdraw




RACE condition: 
.............
Executing multiple Threads simultaneously and causing data inconsistency problems is 
nothing but Race condition 
we can resolve race condition by using synchronized keyword. 


Example Without Synchronization
class Counter {

    int count = 0;

    public void increment() {
        count++;
    }
}

public class Main {

    public static void main(String[] args) throws Exception {

        Counter c = new Counter();

        Thread t1 = new Thread(() -> {
            for(int i = 0; i < 1000; i++) {
                c.increment();
            }
        });

        Thread t2 = new Thread(() -> {
            for(int i = 0; i < 1000; i++) {
                c.increment();
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(c.count);
    }
}
Expected Output
2000
Actual Output (May Vary)
1845
1967
1992

Why?

Because count++ is not a single operation:


wait() vs notify() vs notifyAll() in Java
................................................
These methods are used for inter-thread communication and belong to the Object class.

wait() makes a thread release the lock and wait. 
notify() wakes up one waiting thread, while 
notifyAll() wakes up all waiting threads.
These methods are used for thread communication and must be called from synchronized code.

wait notify 

Scenario: Online Food Delivery
Customer places an order.
Customer waits for the food.
Restaurant prepares the food.
Restaurant notifies the customer
class FoodOrder {

    private boolean foodReady = false;

    public synchronized void waitForFood() {

        while (!foodReady) {
            try {
                System.out.println("Customer: Waiting for food...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Customer: Food received!");
    }

    public synchronized void prepareFood() {

        System.out.println("Chef: Preparing food...");
        foodReady = true;

        notify();

        System.out.println("Chef: Food is ready.");
    }
}

public class Main {

    public static void main(String[] args) {

        FoodOrder order = new FoodOrder();

        Thread customer = new Thread(() -> {
            order.waitForFood();
        });

        Thread chef = new Thread(() -> {

            try {
                Thread.sleep(3000);
            } catch (Exception e) {
            }

            order.prepareFood();
        });

        customer.start();
        chef.start();
    }
}

Customer: Waiting for food...
Chef: Preparing food...
Chef: Food is ready.
Customer: Food received!


Using notifyAll()

Scenario: Movie Ticket Booking

Three users are waiting for tickets.

class TicketBooking {

    private boolean ticketsAvailable = false;

    public synchronized void bookTicket() {

        while (!ticketsAvailable) {

            try {
                System.out.println(Thread.currentThread().getName()
                        + " waiting for tickets");

                wait();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(Thread.currentThread().getName()
                + " booked ticket");
    }

    public synchronized void releaseTickets() {

        ticketsAvailable = true;

        System.out.println("Admin released tickets");

        notifyAll();
    }
}
Main Method
public class Main {

    public static void main(String[] args) {

        TicketBooking booking = new TicketBooking();

        new Thread(() -> booking.bookTicket(), "User1").start();
        new Thread(() -> booking.bookTicket(), "User2").start();
        new Thread(() -> booking.bookTicket(), "User3").start();

        new Thread(() -> {

            try {
                Thread.sleep(3000);
            } catch (Exception e) {}

            booking.releaseTickets();

        }).start();
    }
}
Output
User1 waiting for tickets
User2 waiting for tickets
User3 waiting for tickets

Admin released tickets

User1 booked ticket
User2 booked ticket
User3 booked ticket




Demon thread
.................

The Threads which are executing in the background are called daemon Threads. 
The main objective of daemon Threads is to provide support for non-daemon Threads 
like main Thread


Real-Time Example
Log Monitoring Service

Imagine an application that processes customer orders.

Main threads handle orders.
A daemon thread monitors logs and system health.
class LogMonitor extends Thread {

    public void run() {

        while (true) {

            System.out.println("Checking application logs...");

            try {
                Thread.sleep(5000);
            } catch (Exception e) {
            }
        }
    }
}
public class Main {

    public static void main(String[] args) {

        LogMonitor monitor = new LogMonitor();

        monitor.setDaemon(true);

        monitor.start();

        System.out.println("Processing Orders...");
    }
}


Why Daemon?

Because log monitoring is a supporting/background task. When the application shuts down, we don't need to keep the JVM alive just for log monitoring.


class MyDaemon extends Thread {

    public void run() {

        while (true) {

            System.out.println("Daemon Thread Running...");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Main {

    public static void main(String[] args) {

        MyDaemon daemon = new MyDaemon();

        daemon.setDaemon(true); // Make it daemon thread

        daemon.start();

        System.out.println("Main Thread Started");

        try {
            Thread.sleep(3000);
        } catch (Exception e) {
        }

        System.out.println("Main Thread Finished");
    }
}
Output
Main Thread Started
Daemon Thread Running...
Daemon Thread Running...
Daemon Thread Running...
Main Thread Finished

After the main thread finishes, the JVM exits and the daemon thread stops automatically.


What is ExecutorService?
.............................................
ExecutorService is a thread pool framework in Java used to manage and execute asynchronous tasks efficiently. It reuses threads instead of creating new ones for every task, improving performance and resource utilization.

Real-time usage:

Order processing systems
Payment processing
Email notifications
Background jobs
Microservices and Spring Boot applications

Key methods: