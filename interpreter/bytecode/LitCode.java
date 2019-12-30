package interpreter.bytecode;
import interpreter.VirtualMachine;

import java.util.ArrayList;

public class LitCode extends ByteCode {

    int val;
    String id;

    @Override
    public void init(ArrayList<String> args) {
        val = Integer.parseInt(args.get(0));
        if (args.size() > 1) {
            id = args.get(1);
        } else {
            id = "";
        }
    }

    @Override
    public void execute(VirtualMachine virtual) {
        if (id == "") {
            virtual.pushRunStack(val);
        } else {
            virtual.push(0);
        }
    }

    @Override
    public String toString(){
        return "LIT: " + val;
    }
}
