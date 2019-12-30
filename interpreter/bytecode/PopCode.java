package interpreter.bytecode;

import java.util.ArrayList;
import interpreter.VirtualMachine;

public class PopCode extends ByteCode {

    private int i;

    @Override
    public void init(ArrayList<String> args){
         i = Integer.parseInt(args.get(0));
    }

    @Override
    public void execute(VirtualMachine virtual){
        for(int j = 0; j < i; i++){
            virtual.popReturnAddrs();
        }
    }

    @Override
    public String toString(){
        return "POP: " + i;
    }
}
