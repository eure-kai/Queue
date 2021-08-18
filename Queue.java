public class Queue {
  private final int MAX;	// maximum capacity of the queue
	private int[] queue; // array to store queue elements
	private int front; // the start of the queue
	private int nextBack;	// where to insert the next item in the back
	private int size;		// current size of the queue

	// Constructor to initialize queue
	public Queue(){
    MAX = 1000;
    queue = new int[MAX];
		front = 0;
		nextBack = 0;
		size = 0;
	}

  // Returns whether the queue is empty or not
	public Boolean isEmpty(){
		return (size == 0);
	}

	// Returns whether the queue is full or not
	public Boolean isFull(){
		return (size == MAX);
	}

	// Remove front element from the queue
	public int dequeue() {
	  
	  if (isEmpty()) throw new UnderflowException();
	  
	  int temp = queue[front];
	  front = (front + 1) % MAX;
	  size--;
	  
	  return temp;
	}

	// Add an item to the back of the queue
	public void enqueue(int item) {
	  if (isFull()) throw new OverflowException();
	  
	  queue[nextBack] = item;
	  nextBack = (nextBack + 1) % MAX;
	  size++;
	}

	// Returns the front element in the queue
	public int front() {
	  if (isEmpty()) throw new UnderflowException();
    return queue[front];
	}

	// Returns the size of the queue
	public int size() {
		return size;
	}

  @Override
  public String toString() {
    return ("[" + printQueue() + "]");
  }
  
  public String printQueue() {
    if (size == 0) {
      return "";
      
    } else if (size == 1) {
      return String.valueOf(queue[front]);
      
    } else {
      
      StringBuilder wordBuilder = new StringBuilder();
    
      for (int i = 0; i < size; i++) {
        int index = (front + i) % MAX;
        wordBuilder.append(queue[index]);
        if (i != (size - 1)) wordBuilder.append(", ");
      }
    
      return wordBuilder.toString();
    }
  }
  
}
