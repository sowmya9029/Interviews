package com.datastructure.array;

import java.util.Iterator;

public class MyIterable<T> implements Iterable<T> {

    public T[] a= null;

    public MyIterable(T[] array){
        this.a = array;
    }

    @Overrid
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int count=0;

            public boolean hasNext(){
                return count < a.length;
            }
            public T next(){
                System.out.println("Invoking next()");
                return a[count++];
            }

            public void remove(){
                throw new UnsupportedOperationException();
            }
        };
    }
}