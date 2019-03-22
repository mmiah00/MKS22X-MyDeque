import java.util.*;
import java.io.*;

public class MyDeque<E>{
  private E[] data;
  private int size, start, end;

  @SuppressWarnings("unchecked")
  public MyDeque(int initialCapacity){
    data = (E[])new Object[initialCapacity];
    int size = 0;
    int start = 0;
    int end = 0;
  }

  public int size(){
    return size;
  }

  public String toString(){
    String ans = "{";
    for (int i = start; i <= end; i ++) {
      ans += data[i] + " ";
    }
    return ans;
  }

  public void addFirst(E element){
    if (element == null) {
      throw new NullPointerException ("Null");
    }
    data[start - 1] = element;
    start --;
    size ++;
  }

  public void addLast(E element){
    if (element == null) {
      throw new NullPointerException ("Null");
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
}
