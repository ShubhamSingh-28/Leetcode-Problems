class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int i =0;i<asteroids.length;i++){

            if(stack.isEmpty() || asteroids[i]>0){
                stack.push(asteroids[i]);
            } else{
                while(!stack.isEmpty()){
                int top= stack.peek();
                if(top<0){
                    stack.push(asteroids[i]);
                    break;
                }
                int a= Math.abs(asteroids[i]);
                if(a==top){
                    stack.pop();
                    break;
                } else if(a<top){
                    break;
                }else{
                    stack.pop();
                    if(stack.isEmpty()){
                        stack.push(asteroids[i]);
                        break;
                    }
                }
                }     
            }
        }
        int arr[]=new int[stack.size()];
        for(int i = stack.size()-1; i>=0;i--){
            arr[i] = stack.pop();
        }
        return arr;
    }
}