package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class ArgsCode extends ByteCode {

    private int num;

    @Override
    public void init(ArrayList<String> args) {
        num = Integer.parseInt((args.get(0)));
    }

    @Override
    public void execute(VirtualMachine virtual){
        virtual.newFrameAt(num);
    }

    @Override
    public String toString(){
        return "ARGS: " + num;
    }
}