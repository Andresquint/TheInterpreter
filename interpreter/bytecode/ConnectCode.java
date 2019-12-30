package interpreter.bytecode;

import java.util.ArrayList;

import interpreter.VirtualMachine;

public abstract class ConnectCode extends ByteCode{
    public abstract void init(ArrayList<String> args);
    public abstract void execute(VirtualMachine virtual);
    public abstract int getTargAdd();
    public abstract void setTargAdd(int x);
    public abstract String getLabel();
}
