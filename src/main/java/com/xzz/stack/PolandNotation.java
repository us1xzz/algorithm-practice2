package com.xzz.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//逆波兰计算器
public class PolandNotation {
    public static void main(String[] args) {
        //完成将一个中缀表达式转成后缀表达式的功能
        //说明
        //1. 1+((2+3)×4)-5 => 转成  1 2 3 + 4 × + 5 –
        //2. 因为直接对str 进行 操作，不方便，因此 先将  "1+((2+3)×4)-5" =》 中缀的表达式对应的List
        //   即 "1+((2+3)×4)-5" => ArrayList [1,+,(,(,2,+,3,),*,4,),-,5]
        //3. 将得到的中缀表达式对应的List => 后缀表达式对应的List
        //   即 ArrayList [1,+,(,(,2,+,3,),*,4,),-,5]  =》 ArrayList [1,2,3,+,4,*,+,5,–]

        String suffixExpression = "3 4 + 5 * 6 -";//注意表达式
        List<String> listString = getListString(suffixExpression);
        System.out.println(listString);
        int res = calculate(listString);
        System.out.println("计算的结果="+res);
    }
    public static List<String> getListString(String suffixExpression){
        //字符串分割
        String[] split = suffixExpression.split(" ");
        ArrayList<String> list = new ArrayList<>();
        for (String ele : split) {
            list.add(ele);
        }
        return list;
    }
    //完成对逆波兰表达式的运算
    public static int calculate(List<String> ls){
        Stack<String> stack = new Stack<>();
        //遍历 ls
        for (String item : ls) {
            //这里使用正则表达式来取出数
            if (item.matches("\\d+")){ //匹配的是多位数
                //入栈
                stack.push(item);
            }else{
                //pop出两个数，并运算,再入栈
                int num2 =Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")){
                    res = num1 +num2;
                }else if (item.equals("-")){
                    res = num1-num2;
                }else if (item.equals("/")){
                    res = num1/num2;
                }else if (item.equals("*")){
                    res = num1*num2;
                }else {
                    throw new RuntimeException("运算符有误");
                }
                //把res入栈
                stack.push(""+res);


            }

        }
        //最后留在stack中的数据就是运算结果
        return Integer.parseInt(stack.pop());

    }

}
