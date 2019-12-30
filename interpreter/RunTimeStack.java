package interpreter;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;

public class RunTimeStack {

    private ArrayList<Integer> runTimeStack;
    private Stack<Integer>     framePointer;

    public RunTimeStack() {
        runTimeStack = new ArrayList<>();
        framePointer = new Stack<>();
        framePointer.add(0);
    }

    public void dump(){
        Iterator itr = framePointer.iterator();
        int next;
        int current = (Integer) itr.next();
        String output = "";

        for(int i = 0; i < framePointer.size(); i++){
            if(itr.hasNext()){
                next = (Integer)itr.next();
            }else{
                next = runTimeStack.size();
            }
            output+=("[");
            for(int j = current; j < next; j++){
                System.out.print(runTimeStack.get(j));
                if(j != next - 1){
                    System.out.print(",");
                }
            }
            output+=("]");
            current = next;
        }
        System.out.println(output);
    }

   public int pop(){
        if(!runTimeStack.isEmpty()) {
            return runTimeStack.remove(runTimeStack.size() - 1);
        }
        return 0;
   }

   public int push(int x){
        runTimeStack.add(x);
        return x;
   }

   public void newFrameAt(int offset){
        framePointer.push(runTimeStack.size() - offset);
   }

   public void popFrame(){
        int temp = peek();
        int frameP = framePointer.pop();
        while(runTimeStack.size() >= frameP){
            pop();
        }
        this.push(temp);
   }

   public int peek() {
        if(!runTimeStack.isEmpty()) {
            runTimeStack.get(runTimeStack.size() - 1);
        }
        return 0;

    }

    public int load(int offset){
        int x = runTimeStack.get(framePointer.peek()-offset);
        push(x);
        return x;
    }

    public int store(int offset){
        int i = pop();
        runTimeStack.add(framePointer.peek() - offset, i);
        return i;
    }
}
