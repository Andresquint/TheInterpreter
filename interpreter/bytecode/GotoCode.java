package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class GotoCode extends ConnectCode{

    private String label="";
    private int targAdd;

    @Override
    public void init(ArrayList<String> args){
        label = args.get(0);
    }

    @Override
    public void execute(VirtualMachine virtual){
        virtual.setPC(targAdd-1);
    }

    @Override
    public String toString(){
        return "GOTO: " + label + targAdd;
    }

    public int getTargAdd(){
        return targAdd;
    }

    public void setTargAdd(int x){
        targAdd = x;
    }

    public String getLabel(){
        return label;
    }
}
