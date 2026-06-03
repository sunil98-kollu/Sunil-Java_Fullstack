

Vm

types of Vm

hard ware based vm 
application based vm


virtual machine 
...............
 i a software simulation of a machine  which cam perfomr operation like physicl machine 

types of virtual machine
1. system / hardware virtual machine
2 application /process based virtual machine

1. system / hardware virtual machine
....................................
provides several logical systems and same computer with strong isolation from each other 
example : vmware , virtual box , hyper v

on one physical machine defie multiple logical machines 

main advantage of hardbased vm is hardware resources sharing and improve utlization of hardware resources 

ex kvm  (kernal based vm) for linex systems 

vmware xen cloud computing etc 

these are taken by admins 

2. application /process based virtual machine
.........................................

these vm acts as ru time engines to run particular applications 

jvm act as run time engine for java application

pvm  parrot based virtual machine for perl language(scripting lang)

clr common language runtime for .net framework


JVm
.........
is a part of JRE 
jre part of jdk

jvm responsible for load class file
and run .ex file 


.class file    class loader subsystem

various memory are of jvm 
.............................................................................

method area         heap area     stact area           pc register      native method static 

...........................................................................................

execution engine     java naitve interface    native method libraries 


 class loader subsystem is resplbe for 
 loading ,linking ,initlization, of class file
loading : reading class file and store binary data in method area 
fully q name of immediate parent class 
method info ,varialbe info ,  ,modifier const pool info etc 


class Student {
p string getName()
{

return null;
}

public int getRoll(){
return 10;

}
}

main(){
    it count=0;
  Class c =  Class.forName("Student")
  Method[] m = c.getDeclaredMethods();
  for(Method m1 : m){
    count ++;
    System.out.println(m1.getName());
  }
   System.out.println(" nof methods "+count);  // 2 methods 

}


for every loaded type oly one class obj is created even using  class multiple time s in our program 

main {
  Student s1= new Student();
  Class c1=s1.getClass();
  Student s2= new Student();
  Class c2=s2.getClass();
  syso(c1.hashcode());
  syso(c2.hashcode());
  syso(c1==c2); // true
}

in above program student class create mult time class class obj got created 
class class obj 


linking:

consist of three steps
1. verify : check the correctness of class file
2. prepare : assign memory for static variable and assign default value to static variable
3. resolve : replace symbolic reference with direct reference

 loading class file into memory
linking : verify , prepare , resolve    
initialization : assign default value to static variable and execute static block of code