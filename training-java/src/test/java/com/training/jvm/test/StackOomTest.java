package com.training.jvm.test;

public class StackOomTest {
    private static int index = 1;
 
    public void call(){
        index++;
        call();
    }

    /**
     * 栈溢出
     * @param args
     */
    public static void main(String[] args) {
        StackOomTest mock = new StackOomTest();
        try {
            mock.call();
        }catch (Throwable e){
            System.out.println("Stack deep : "+index);
            e.printStackTrace();
        }
    }
}