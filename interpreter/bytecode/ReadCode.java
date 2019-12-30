package interpreter.bytecode;

import  interpreter.VirtualMachine;

import java.util.ArrayList;

import java.util.Scanner;

public class ReadCode extends ByteCode {

    Scanner in = new Scanner(System.in);

    @Override
    public void init(ArrayList<String> args){

    }
    @Override
    public void execute(VirtualMachine virtual){
        System.out.println("Enter a number: ");
        int input = in.nextInt();
        System.out.println("READ: " + input);
    }

    @Override
    public String toString(){
        return "READ";
    }
}
