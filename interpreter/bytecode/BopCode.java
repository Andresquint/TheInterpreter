package interpreter.bytecode;

import java.util.ArrayList;
import interpreter.VirtualMachine;

public class BopCode extends ByteCode {

    private String operator;
    @Override
    public void init(ArrayList<String> args){
        operator = args.get(0);
    }
    @Override
    public void execute(VirtualMachine virtual){
        int operator1 = virtual.popRunStack();
        int operator2 = virtual.popRunStack();

        switch(operator){
            case "+":
                virtual.pushRunStack(operator1 + operator2);
                break;
            case "-":
                virtual.pushRunStack(operator1 - operator2);
                break;
            case "*":
                virtual.pushRunStack(operator1 * operator2);
                break;
            case "/":
                virtual.pushRunStack(operator1 / operator2);
                break;
            case "==":
                if(operator1 == operator2){
                    virtual.pushRunStack(1);
                }else{
                    virtual.pushRunStack(0);
                }
                break;
            case "!=":
                if (operator1 != operator2){
                    virtual.pushRunStack(1);
                }else{
                    virtual.pushRunStack(0);
                }
                break;
            case "<=":
                if (operator1 <= operator2){
                    virtual.pushRunStack(1);
                }else{
                    virtual.pushRunStack(0);
                }
                break;
            case ">=":
                if (operator1 >= operator2){
                    virtual.pushRunStack(1);
                }else {
                    virtual.pushRunStack(0);
                }
                break;
            case ">":
                if (operator1 > operator2){
                    virtual.pushRunStack(1);
                }else{
                    virtual.pushRunStack(0);
                }
                break;
            case "<":
                if (operator1 < operator2){
                    virtual.pushRunStack(1);
                }else{
                    virtual.pushRunStack(0);
                }
                break;
            default:
                virtual.pushRunStack(0);
        }
    }
    @Override
    public String toString() {
        return "BOP: " + operator;
    }
}
