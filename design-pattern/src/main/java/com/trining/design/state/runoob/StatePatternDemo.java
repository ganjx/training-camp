package com.trining.design.state.runoob;

public class StatePatternDemo {


   public static void main(String[] args) {
      Context context = new Context();
 
      StartState startState = new StartState();
      startState.doAction(context);

      //打印当前状态
      System.out.println(context.getState().toString());
 
      StopState stopState = new StopState();
      stopState.doAction(context);

      //打印当前状态
      System.out.println(context.getState().toString());
   }
}