## Java Generics
Java Generics are used to deal with type-safe objects. Bugs with types can be detected at compile time.

### Advantages of Generics
- Type-safety

``` java

  List list = new ArrayList(); //non generic 
  list.add(10);  
  list.add("10");  
  // With Generics, it is required to specify the type of object we need to store.  
  List<Integer> list = new ArrayList<Integer>(); // ArrayList that only allows Integer values 
  list.add(10);  
  list.add("10");// compile-time error  

```
- Type-casting is not required
``` java

  List list = new ArrayList();    
  list.add("hello");    
  String s = (String) list.get(0); // typecasting    
  // After Generics, we don't need to typecast the object.  
  List<String> list = new ArrayList<String>();    
  list.add("hello");    
  String s = list.get(0);   // no typecasting

```
- Compile-time Checking 
``` java

  List<String> list = new ArrayList<String>();    
  list.add("hello");    
  list.add(32);// compile Time Error  

```

- Programmers can write generic algorithms (code that works for different types - customization)


## Type Parameters
1. T - Type
2. E - Element
3. K - Key
4. N - Number
5. V - Value

``` java

  // example ELEMENT
  public static <E> void printArray(E[] elements) {  
      for ( E element : elements){          
          System.out.println(element );  
      }  
  }  

  // example KEY and VALUE
  public static <K, V> void printGenericMap(Map<K, V> map) {

  }
    
  // example Type Class
  public class Player<T>{
      private T t;    // A type variable can be any non-primitive type you specify: any class type, any interface type, any array type, or even another type variable.
  
      public void set(T t){
          this.t = t;
      }
  
      public T get(){
          return t;
      }
  }   

```


Further Readings:

[Small Generics tutorial](https://devqa.io/java-generics-tutorial/)

[Detailed Generics in Java](https://docs.oracle.com/javase/tutorial/java/generics/why.html)