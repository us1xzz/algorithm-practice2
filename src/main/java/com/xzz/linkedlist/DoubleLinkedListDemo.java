package com.xzz.linkedlist;
//双向链表的操作

public class DoubleLinkedListDemo {
    public static void main(String[] args) {
        //双向链表的测试
        System.out.println("双向链表的测试");
        //先创建节点
        HeroNode2 hero1 = new HeroNode2(1, "宋江", "及时雨");
        HeroNode2 hero2 = new HeroNode2(2, "卢俊义", "玉麒麟");
        HeroNode2 hero3 = new HeroNode2(3, "吴用", "智多星");
        HeroNode2 hero4 = new HeroNode2(4, "林冲", "豹子头");
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        doubleLinkedList.add(hero1);
        doubleLinkedList.add(hero2);
        doubleLinkedList.add(hero3);
        doubleLinkedList.add(hero4);
        doubleLinkedList.list();
        //修改
        HeroNode2 newHeroNode = new HeroNode2(4, "公孙胜", "入云龙");
        doubleLinkedList.updata(newHeroNode);
        System.out.println("修改后的链表");
        doubleLinkedList.list();
        //删除测试
        System.out.println("删除后的链表");
        doubleLinkedList.delete(3);
        doubleLinkedList.list();
    }



}
class DoubleLinkedList{
    //初始化头结点
    private HeroNode2 head = new HeroNode2(0, "", "");
    public HeroNode2 getHead() {
        return head;
    }
    //遍历双向链表
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //辅助变量来遍历
        HeroNode2 temp = head.next;
        while (true) {
            //判断链表是否到最后
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }
    public void add(HeroNode2 heroNode) {
        //因为head节点不能动，因此我们需要一个辅助遍历 temp
        HeroNode2 temp = head;
        //遍历链表，找到最后
        while (true) {
            //找到链表的最后
            if (temp.next == null) {//
                break;
            }
            //如果没有找到最后, 将将temp后移
            temp = temp.next;
        }
        //当退出while循环时，temp就指向了链表的最后
        //形成一个双向链表
        temp.next = heroNode;
        heroNode.pre = temp;
    }
    //修改一个节点的内容，双向链表的节点内容修改和单向链表一样，只是类型改了一下
    public void updata(HeroNode2 newHeroNode) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //找到编号为no的节点并修改
        HeroNode2 temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {//遍历完链表
                break;
            }
            if (temp.next.no == newHeroNode.no) {//找到节点
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next.nickname = newHeroNode.nickname;
            temp.next.name = newHeroNode.name;
        } else {
            System.out.printf("没有找到编号为%d这个节点\n", newHeroNode.no);
        }
    }
    //删除一个节点
    //说明：对于双向链表，我们可以直接找到要删除的这个节点。找到后删除即可
    public void delete(int no) {
        //判断当前链表是否为空
        if (head.next == null){
            System.out.println("链表为空，无法删除");
            return;
        }
        HeroNode2 temp = head.next;//辅助变量（指针）
        boolean flag = false;//标志是否找到
        while (true) {
            if (temp == null) {//链表已经结束
                break;
            }
            if (temp.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.pre.next = temp.next;
            //如果是最后一个节点就不需要执行下面这句代码。否则会出现空指针异常
            if(temp.next != null){
                temp.next.pre = temp.pre;
            }
        } else {
            System.out.printf("未找到编号%d的节点\n", no);
        }

    }
}


class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    public HeroNode2 next; //指向下一个。默认均为NUll；
    public HeroNode2 pre; //指向前一个。默认均为NUll

    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}