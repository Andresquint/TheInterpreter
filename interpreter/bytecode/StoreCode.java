package interpreter.bytecode;

import java.util.ArrayList;
import interpreter.VirtualMachine;

public class StoreCode extends ByteCode{

    private int offset;

    @Override
    public void init(ArrayList<String> args){
        this.offset = Integer.parseInt(args.get(0));
    }

    @Override
    public void execute(VirtualMachine virtual){
        virtual.storeRunStack(offset);
    }

    @Override
    public String toString(){
        return "STORE: " + offset;
    }

}
