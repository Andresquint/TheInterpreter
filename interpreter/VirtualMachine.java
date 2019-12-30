package interpreter;

import interpreter.bytecode.ByteCode;

import java.util.Stack;

public class VirtualMachine {

    private RunTimeStack runStack;
    private Stack<Integer> returnAddrs;
    private Program program;
    private int pc;
    private boolean isRunning;
    private boolean dump = false;

    protected VirtualMachine(Program program) {
        this.program = program;
    }

    public void executeProgram(){
        pc = 0;
        runStack = new RunTimeStack();
        returnAddrs = new Stack<Integer>();
        isRunning = true;
        while (isRunning) {
            ByteCode code = program.getCode(pc);
            code.execute(this);
            if(dump){
                System.out.println(code.toString());
                runStack.dump();
            }
            pc++;
        }

    }

    public int popReturnAddrs(){
        return returnAddrs.pop();
    }

    public void newFrameAt(int offset){
        runStack.newFrameAt(offset);
    }

    public void popFrameAt(){
        runStack.popFrame();
    }

    public int popRunStack(){
        return runStack.pop();
    }

    public void pushReturnAddrs(){
        returnAddrs.push(pc);
    }

    public int peekRunStack(){
        return runStack.peek();
    }

    public void pushRunStack(Integer i){
        runStack.push(i);

    }

    public void loadRunStack(int i){
        runStack.load(i);
    }

    public void storeRunStack(int i){
        runStack.load(i);
    }

    public void push(int num){
        runStack.push(num);
    }

    public void setPC(int x){
        this.pc = x;
    }

    public int getPC(){
        return returnAddrs.pop();
    }

    public void setDump(boolean dump){
        this.dump = dump;
    }

    public RunTimeStack getRunStack(){
        return runStack;
    }

    public boolean isRunningFalse(){
        isRunning = false;
        return isRunning;
    }

}

