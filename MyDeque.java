import java.util.*;
import java.io.*;

public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity){
    data = (E[])new Object[initialCapacity];
    size = 0;
    start = data.length / 2;
    end = data.length / 2;
  }

  public int size(){
    return size;
  }

  public String toString(){
    String ans = "{";
    for (int i = start; i <= end; i ++) {
      if (data[i] != null) {
        ans += data[i] + " ";
      }
      else {
        ans += "_ ";
      }
    }
    return ans + "}";
  }

  @SuppressWarnings("unchecked")
  private void resize () {
    E[] a = (E[]) new Object [size * 2 + data.length];
    int half = a.length/2;
    int i = half;
    int x = start;
    while (i <= size) {
      a[i] = data[x];
      x ++;
      i ++;
    }
    data = a;
  }

  public void addFirst(E element){
    if (element == null) {
      throw new NullPointerException ("Null");
    }
    if (start - 1 < 0) {
      resize ();
    }
    if (size == 0) {
      data[start] = element;
      size ++;
    }
    else {
      data[start - 1] = element;
      start --;
      size ++;
    }
  }

  public void addLast(E element){
    if (element == null) {
      throw new NullPointerException ("Null");
    }
    if (end + 1 > data.length) {
      resize ();
    }
    data[end + 1] = element;
    end ++;
    size ++;
  }

  public E removeFirst(){
    if (size == 0) {
      throw new NoSuchElementException ("Empty");
    }
    E was = data[start];
    start ++;
    size --;
    return was;
  }

  public E removeLast(){
    if (size == 0) {
      throw new NoSuchElementException ("Empty");
    }
    E was = data[end];
    end --;
    size --;
    return was;
  }

  public E getFirst(){
    if (size == 0) {
      throw new NoSuchElementException ("Empty");
    }
    return data[start];
  }

  public E getLast(){
    if (size == 0) {
      throw new NoSuchElementException ("Empty");
    }
    return data[end];
  }

  public static void main (String[] args) {
    MyDeque <Integer> test = new MyDeque <> (10);
    test.addFirst (1);
    test.addLast (2);
    test.addFirst (3);
    test.addLast (4);
    System.out.println (test.toString ());
  }
}
