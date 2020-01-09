
import java.util.Stack;

public class singleLinkedListTest {
    public static void main(String[] args) {
        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(3, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(4, "林冲", "豹子头");

        //创建要给链表
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        //加入
//        singleLinkedList.add(hero1);
//        singleLinkedList.add(hero4);
//        singleLinkedList.add(hero2);
//        singleLinkedList.add(hero3);


        //1.加入按照编号的顺序
        singleLinkedList.addByOder(hero1);
        singleLinkedList.addByOder(hero4);
        singleLinkedList.addByOder(hero2);
        singleLinkedList.addByOder(hero3);

        System.out.println("原来链表的情况~~");
        singleLinkedList.list();
        //5.链表反转
        System.out.println("链表反转");
        reverseList(singleLinkedList.getHead());
        singleLinkedList.list();
        //逆序打印单链表
        System.out.println("逆序打印单链表");
        reversePrint(singleLinkedList.getHead());


        HeroNode newheroNode = new HeroNode(2, "xioafu", "枸杞领");
        singleLinkedList.updata(newheroNode);
        singleLinkedList.list();
        //2.链表删除
        singleLinkedList.delete(1);
        singleLinkedList.delete(2);
        singleLinkedList.list();
        //3.链表长度返回
        System.out.println("返回链表长度");
        System.out.println(getLength(singleLinkedList.getHead()));
        //4.测试链表倒数第K个节点
        HeroNode lastIndexNode = findLastIndexNode(singleLinkedList.getHead(), 2);
        System.out.println(lastIndexNode.name);
    }

    //逆序打印单链表
    public static void reversePrint(HeroNode head) {
        if (head.next == null) {
            return;
        }
        //创建一个栈
        Stack<HeroNode> stack = new Stack<>();
        HeroNode cur = head.next;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }

    }

    //5.单链表反转
    public static void reverseList(HeroNode head) {
        if (head.next == null || head.next.next == null) {
            return;
        }
        HeroNode reverseHeroNode = new HeroNode(0, "", "");
        HeroNode cur = head.next;
        HeroNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = reverseHeroNode.next;
            reverseHeroNode.next = cur;
            cur = next;
        }
        head.next = reverseHeroNode.next;

    }

    //4.查找单链表中的倒数第K个节点
    public static HeroNode findLastIndexNode(HeroNode head, int index) {
        if (head.next == null) {
            return null;
        }
        int size = getLength(head);
        if (index <= 0 || index > size) {
            return null;
        }
        HeroNode cur = head.next;
        for (int i = 0; i < size - index; i++) {
            cur = cur.next;
        }
        return cur;
    }

    //获取单链表中节点的个数（带头结点则去掉）
    public static int getLength(HeroNode head) {

        if (head.next == null) {
            return 0;
        }
        int length = 0;
        HeroNode cur = head.next;
        while (!(cur == null)) {
            length++;
            cur = cur.next;
        }
        return length;

    }

}

class SingleLinkedList {
    //先初始化一个头结点
    private HeroNode head = new HeroNode(0, "", "");

    //返回头结点
    public HeroNode getHead() {
        return head;
    }

    //添加节点到单向链表
    //思路，当不考虑编号顺序时
    //1. 找到当前链表的最后节点
    //2. 将最后这个节点的next 指向 新的节点
    public void add(HeroNode heroNode) {
        //因为head节点不能动，因此我们需要一个辅助遍历 temp
        HeroNode temp = head;
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
        //将最后这个节点的next 指向 新的节点
        temp.next = heroNode;
    }

    //第二种添加节点的方式
    public void addByOder(HeroNode heroNode) {
        HeroNode temp = head;
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > heroNode.no) { //位置找到，就在temp的后面插入
                break;
            } else if (temp.next.no == heroNode.no) {//添加的节点已经存在
                flag = true;
                break;
            }
            temp = temp.next;
        }

        if (flag) {//不能添加，说明编号存在
            System.out.printf("准备插入的英雄的编号 %d 已经存在了, 不能加入\n", heroNode.no);
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;

        }

    }

    //修改节点的信息，根据编号来修改，即no不能改
    public void updata(HeroNode newHeroNode) {
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //找到编号为no的节点并修改
        HeroNode temp = head;
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

    //删除节点
    public void delete(int no) {
        HeroNode temp = head;
        boolean flag = false;//标志是否找到
        while (true) {
            if (temp.next == null) {//链表已经结束
                break;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.printf("未找到编号%d的节点\n", no);
        }

    }


    //遍历列表
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        //辅助变量来遍历
        HeroNode temp = head.next;
        while (true) {
            //判断链表是否到最后
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }


}

class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next; //指向下一个

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}