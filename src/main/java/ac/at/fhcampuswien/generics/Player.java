package ac.at.fhcampuswien.generics;

public class Player<T>{
    private T t;    // A type variable can be any non-primitive type you specify: any class type, any interface type, any array type, or even another type variable.

    public void set(T t){
        this.t = t;
    }

    public T get(){
        return t;
    }
}
