class StockSpanner {
    List<Integer> ls;
    Stack<Integer> s;
    public StockSpanner() {
        s=new Stack<>();
        ls= new ArrayList<>();
    }
    
    public int next(int price) {
        ls.add(price);
        while(!s.isEmpty() && ls.get(s.peek())<=price){
            s.pop();
        }
        int low= (s.isEmpty())? -1:s.peek();
        int up = ls.size()-1;
        s.push(up);
        int ans= up-low;
        return ans;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */