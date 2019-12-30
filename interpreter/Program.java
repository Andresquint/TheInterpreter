package interpreter;

import interpreter.bytecode.ByteCode;
import interpreter.bytecode.ConnectCode;
import interpreter.bytecode.*;

import java.util.ArrayList;
import java.util.HashMap;

public class Program {

    static HashMap<String, Integer> codeLabels;
    private ArrayList<ByteCode> program;
    private int i = 1;

    public Program() {
        program = new ArrayList<>();
        codeLabels = new HashMap<String, Integer>();
    }

    public ByteCode getCode(int pc) {
        return this.program.get(pc);
    }

    public void addCode(ByteCode bytecode) {
        if(bytecode instanceof LabelCode) {
            LabelCode branchLabel = (LabelCode)bytecode;
            codeLabels.put(branchLabel.getLabel(), program.size());
        }
        program.add(bytecode);
    }

    public void resolveAddrs() {
        for(ByteCode byteCode : program){
            if(byteCode instanceof ConnectCode){
            String label= ((ConnectCode) byteCode).getLabel();
            int index = codeLabels.get(label);
            ((ConnectCode) byteCode).setTargAdd(index);
            }
        }
    }
}
