package interpreter.bytecode;

import interpreter.VirtualMachine;

import java.util.ArrayList;

public class LabelCode extends ByteCode{
    private String lbl;

    @Override
    public void init(ArrayList<String> args){
        this.lbl = args.get(0);
    }

    @Override
    public void execute(VirtualMachine virtual){

    }

    @Override
    public String toString(){
        return "LABEL NAME: " + lbl;
    }

    public String getLabel(){
        return lbl;
    }
}
