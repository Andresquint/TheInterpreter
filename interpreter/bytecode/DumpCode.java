package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class DumpCode extends ByteCode{

    private boolean status;
    String label;

    @Override
    public void init(ArrayList<String> args){
        this.label = args.get(0);
    }

    @Override
    public void execute(VirtualMachine virtual){
        if(label.equals("ON")){
            status = true;
            virtual.setDump(status);
        }else {
            status = false;
            virtual.setDump(status);
        }
        virtual.setDump(status);
    }

    @Override
    public String toString(){
        return "DUMP: " + label;
    }
}
