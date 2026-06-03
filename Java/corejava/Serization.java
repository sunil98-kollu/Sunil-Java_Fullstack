serilization 
 writing state of an object to a file is called serialization 

  By using FileOutputStream and ObjectOutputStream classes we can achieve 
serialization process. 
4. Ex: big ballon

e-Serialization: 
1. The process of reading state of an object from a file is called DeSerialization 

. By using FileInputStream and ObjectInputStream classes we can achieve 
DeSerialization. 


import java.io.*; 
class Dog implements Serializable 
{ 
int i=10; 
int j=20; 
} 
classSerializableDemo 
{ 
public static void main(String args[])throws Exception{ 

Dog d1=new Dog(); 

System.out.println("Serialization started"); 

FileOutputStream fos=new FileOutputStream("abc.ser"); 
ObjectOutputStreamoos=new ObjectOutputStream(fos); 
oos.writeObject(d1); 
System.out.println("Serialization ended"); 

System.out.println("Deserialization started"); 
FileInputStreamfis=new FileInputStream("abc.ser"); 
ObjectInputStreamois=new ObjectInputStream(fis); 

Dog d2=(Dog)ois.readObject(); 

System.out.println("Deserialization ended"); 
System.out.println(d2.i+"................"+d2.j); 
} 
} 
 Output: 
Serialization started 
Serialization ended 
Deserialization started 
Deserialization ended 
10................20 


Transient keyword: 
1. transient is the modifier applicable only for variables. 
2. If you declare a variable as transient, it will not be serialized.

Static VsTransient : 
1. static variable is not part of object state hence they won't participate in 
serialization because of this declaring a static variable as transient there is no 
use. 
 
Transient Vs Final: 
1. final variables will be participated into serialization directly by their values. 
Hence declaring a final variable as transient there is no use.  
//the compiler assign the value to final variable

