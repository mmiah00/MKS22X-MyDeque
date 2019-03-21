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
    try {
      data[start - 1] = element;
      start --;
      size ++;
    }
    catch (NullPointerException e) {}
  }

  public void addLast(E element){
    try {
      data[end + 1] = element;
      end ++;
      size ++;
    }
    catch (NullPointerException e) { }
  }
  public E removeFirst(){
    try {
      E was = data[start];
      start ++;
      size --;
      return was;
    }
    catch (NoSuchElementException e) { }
  }
  public E removeLast(){
    try {
      E was = data[end];
      end --;
      size --;
      return was;
    }
    catch (NoSuchElementException e) { }
  }
  public E getFirst(){
    try {
      return data[start];
    }
    catch (NoSuchElementException e) {}
  }

  public E getLast(){
    try {
      return data[end];
    }
    catch (NoSuchElementException e) {}
  }
}
