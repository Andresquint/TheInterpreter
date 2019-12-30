package interpreter.bytecode;

import java.util.ArrayList;
import interpreter.VirtualMachine;
public class ReturnCode extends ByteCode{

    private String function="";
    private int var;

    @Override
    public void init(ArrayList<String> args){
            if(!args.isEmpty()){
                function = args.get(0);
            }
    }

    @Override
    public void execute(VirtualMachine virtual){
        var = virtual.peekRunStack();
        virtual.popFrameAt();
        virtual.setPC(virtual.popReturnAddrs());
        virtual.pushRunStack(var);
    }

    @Override
    public String toString(){
        return "RETURN: " + var;
    }
}
