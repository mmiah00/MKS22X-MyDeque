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
      /*
      else {
        ans += "_ ";
      }*/
    }
    return ans + "}";
  }

  /*
  @SuppressWarnings("unchecked")
  private void resize () {
    E[] a = (E[]) new Object [size * 2 + data.length];
    int half = a.length/2;
    int i = start;
    int x = start + half;
    while (i < size) {
      a[x] = data[i];
      x ++;
      i ++;
    }
    data = a;
  }
  */
  @SuppressWarnings("unchecked")
  private void resizeLeft () {
    E[] a = (E[]) new Object [5 + data.length];
    int x = 5;
    int i = start;
    //int b = 0 ;
    while (i <= end) {
      a[x] = data[i];
      x ++;
      i ++;
    }
    start = 5;
    data = a;
  }

  @SuppressWarnings("unchecked")
  private void resizeRight () {
    E[] a = (E[]) new Object [5 + data.length];
    int x = start;
    int i = 0;
    while (i < size) {
      a[x] = data[x];
      i ++;
      x ++;
    }
    end += 4;
    data = a;
  }

  public void addFirst(E element){
    if (element == null) {
      throw new NullPointerException ("Null");
    }
    if (size == 0) {
      data[start] = element;
      size ++;
    }
    else {
      if (start - 1 < 0) {
        resizeLeft ();
      }
      data[start - 1] = element;
      start --;
      size ++;
    }
  }

  public void addLast(E element){
    if (element == null) {
      throw new NullPointerException ("Null");
    }
    if (size == 0) {
      data[end] = element;
      size ++;
    }
    else {
      if (end + 1 >= data.length) {
        resizeRight ();
      }
      data[end + 1] = element;
      end ++;
      size ++;
    }
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
    MyDeque <Integer> test = new MyDeque <> (5);
    for (int i = 0; i <= 10; i ++) {
      if (i % 2 == 0) {
        test.addFirst (i);
      }
      else {
        test.addLast (i);
      }
    }
    System.out.println (test.toString ());
    for (int i = 0; i < test.size (); i ++) {
      if (i % 2 == 0) {
        test.removeFirst ();
      }
      else {
        test.removeLast ();
      }
    }
    System.out.println (test.toString ());
    /*
    test.addFirst (1);
    test.addLast (2);
    test.addFirst (3);
    test.addLast (4);
    System.out.println (test.toString ());
    test.removeFirst ();
    System.out.println (test.toString ());
    test.removeLast ();
    System.out.println (test.toString ());
    System.out.println (test.getFirst ());
    System.out.println (test.getLast());
    System.out.println (test.size ());
    */
  }
}
