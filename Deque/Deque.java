public class Deque { 
  private final int MAX;
  private int deque[]; 
  private int nextFront; //index for inserting the next front item
  private int nextBack; //index for inserting the next back item
  private int size;
    
  public Deque(int maxSize){ 
    MAX = maxSize;
    deque = new int[MAX]; 
    nextFront = convertToIndex(0);
    nextBack = convertToIndex(1);
    this.size = 0;
  } 

  //Converts a number into a valid index in the circular array
  private int convertToIndex(int number){
    number %= MAX;
    if (number < 0) number += MAX;
    return number;
  }

  // Checks whether Deque is full or not. 
  public boolean isFull(){ 
    return (size == MAX);
  } 
  
  // Checks whether Deque is empty or not. 
  public boolean isEmpty(){ 
    return (size == 0);
  } 
  
  // Inserts an item at the front
  public void insertFront(int item) {
    
    if (isFull()) throw new OverflowException();
    
    deque[nextFront] = item;
    nextFront = convertToIndex(nextFront - 1);
    size++;
  } 
  
  // Inserts an item at the back
  public void insertBack(int item) {
    
    if (isFull()) throw new OverflowException();
    
    deque[nextBack] = item;
    nextBack = convertToIndex(nextBack + 1);
    size++;
  } 
  
  // Deletes element at front end of Deque 
  public void removeFront() {
    if (isEmpty()) throw new UnderflowException();
    
    nextFront = convertToIndex(nextFront + 1);
    size--;
  } 
  
  // Delete element at back end of Deque 
  public void removeBack() {
    if (isEmpty()) throw new UnderflowException();
    
    nextBack = convertToIndex(nextBack - 1);
    size--;
  } 
  
  // Returns front element of Deque 
  public int getFront(){ 
    int ind = convertToIndex(nextFront + 1);
    return deque[ind];
  } 
  
  // Returns the last element in the Deque 
  public int getBack(){
    int ind = convertToIndex(nextBack - 1);
    return deque[ind]; 
  } 

  @Override
  public String toString() {
    return ("[" + printDeque() + "]");
  }
  
  public String printDeque() {
    int start = convertToIndex(nextFront + 1);
    int end = convertToIndex(nextBack - 1);
    
    if (size == 0) {
      return "";
      
    } else if (size == 1) {
      return String.valueOf(deque[start]);
      
    } else {
      StringBuilder wordBuilder = new StringBuilder();
    
      for (int i = start; i <= end; i++) {
        wordBuilder.append(deque[i]);
        if (i != (end)) wordBuilder.append(", ");
      }
    
      return wordBuilder.toString();
    }
  }
  
}
