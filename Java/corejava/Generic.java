Generics allow you to write classes, interfaces, and methods that work with different data types while providing compile-time type safety.

Without Generics:
..............................................
List list = new ArrayList();

list.add("Sunil");
list.add(100);

String name = (String) list.get(0);
Requires type casting.
May cause ClassCastException.

Using Generics
.............................................

List<String> list = new ArrayList<>();

list.add("Sunil");
list.add("Anil");

String name = list.get(0);

System.out.println(name);

Benefits
..............................
Type safety
No explicit casting
Compile-time error checking
Code reusability






//////////////////////////////////

Enum :-

type used to represent a fixed set of constants.


enum PaymentStatus {
    SUCCESS,
    FAILED,
    PENDING
}

public class Main {

    public static void main(String[] args) {

        PaymentStatus status = PaymentStatus.SUCCESS;

        switch (status) {

            case SUCCESS:
                System.out.println("Payment Successful");
                break;

            case FAILED:
                System.out.println("Payment Failed");
                break;

            case PENDING:
                System.out.println("Payment Pending");
                break;
        }
    }
}











///////////////////////////////