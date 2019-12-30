package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;


public class LoadCode extends ByteCode {

    int val;
    String variable;

    @Override
    public void init(ArrayList<String> args){
        this.val = Integer.parseInt(args.get(0));
        variable = args.get(1);

    }

    @Override
    public void execute(VirtualMachine virtual) {
        virtual.loadRunStack(val);
    }

    @Override
    public String toString(){
        return "LOAD: " + val + " " + variable;
    }
}
