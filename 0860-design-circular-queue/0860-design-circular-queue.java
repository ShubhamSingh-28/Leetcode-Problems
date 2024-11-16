class MyCircularQueue {
    int [] q;
    int front;
    int rear;
    int capicity;
    public MyCircularQueue(int k) {
        q=new int[k];
        front=-1;
        rear=-1;
        capicity=k;
    }
    
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        if(isEmpty()){
            front=0;
            rear=0;
        } else if(rear==capicity-1 && front!=0){
            rear=0;
        } else{
            rear++;
        }
        q[rear]=value;
        return true;
    }
    
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        if(front==rear){
            front=-1;
            rear=-1;
        } else if(front ==capicity-1){
            front=0;
        } else{
            front++;
        }

        return true;
    }
    
    public int Front() {
        return front==-1?-1: q[front];
    }
    
    public int Rear() {
        return rear==-1?-1: q[rear];
    }
    
    public boolean isEmpty() {
        if(rear==-1){
            return true;
        }
        return false;
    }
    
    public boolean isFull() {
         if(rear==capicity-1 && front==0 || front !=0 && rear == (front-1)%capicity){
            return true;
        }
        return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */