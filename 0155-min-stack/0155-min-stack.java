class MinStack {
    class Pair{
        int val;
        int min;
        Pair(int val, int min){
            this.val=val;
            this.min=min;
        }
    }
    Stack<Pair> s;
    public MinStack() {
        s= new Stack<>();
    }
    
    public void push(int val) {
        int minval=  s.isEmpty() ? -1 :s.peek().min;
        if(s.isEmpty() ||val<minval){
            minval=val;
        }
        Pair p= new Pair(val,minval);
         s.push(p);
    }
    
    public void pop() { 
        s.pop();   
    }
    
    public int top() {
        return s.isEmpty() ? -1 :s.peek().val;
    }
    
    public int getMin() {
        return s.isEmpty() ? -1 :s.peek().min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */