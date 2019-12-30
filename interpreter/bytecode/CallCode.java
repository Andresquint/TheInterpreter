package interpreter.bytecode;

import interpreter.VirtualMachine;
import java.util.ArrayList;

public class CallCode extends ConnectCode{

    private String label = "";
    private int targAdd;

    @Override
    public void init(ArrayList<String> args){
        this.label = args.get(0);
    }

    @Override
    public void execute(VirtualMachine virtual){
        virtual.pushReturnAddrs();
        virtual.setPC(targAdd - 1);
    }

    @Override
    public String toString(){
        return "CALL: " + label;
    }

    public int getTargAdd(){
        return targAdd;
    }

    public void setTargAdd(int x){
        this.targAdd = x;
    }

    public String getLabel(){
        return label;
    }
}
