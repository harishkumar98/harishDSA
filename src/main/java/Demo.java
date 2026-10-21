import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Demo {
    public static void main(String[] args) {
        System.out.println("Harish Demo");

        /*MergeAlternately m = new MergeAlternately();
        String merged = m.mergeAlternately("abc", "def");
        System.out.println(merged);

        System.out.println(merged.substring(3));

        DivisorStr dsr = new DivisorStr();
        String dsresult = dsr.gcdOfStrings("ABCABC", "ABC");
        System.out.println(dsresult);

        System.out.println("GCD of 81 and 27: "+ dsr.getGCD(81,6) );

        SingleNumber s = new SingleNumber();
        HappyNumber happy = new HappyNumber();
        System.out.println("Given Number is Happy: "+ happy.isHappy(19));
        System.out.println("Given Number is Happy: "+ happy.isHappy(82));

        System.out.println("Maximum subArray: "+ maxSubArray(new int[]{-1, -2, 4, 3,-5,2}));
        ListNode abc = new ListNode();
        ListNode xyz = new ListNode();
        abc.val = 0;
        xyz.val = 1;
        xyz.next = null;
        abc.next = xyz;
        System.out.println("getDecimalValue() of 0,1: "+getDecimalValue(abc));
        ArrayList<Integer> al1 = new ArrayList<>(Arrays.asList(1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1));
        ArrayList<Integer> al2 = new ArrayList<>(Arrays.asList(5,6,4));
        System.out.println(Arrays.toString(al1.toArray()));
        ListNode l1 = new ListNode();
        l1.val = al1.get(0);
        al1.remove(0);
        l1.next = null;
        ListNode l2 = new ListNode();
        l2.val = al2.get(0);
        l2.next = null;
        al2.remove(0);
        ListNode hr = l1;
        for(int x: al1){
            ListNode tmp = new ListNode();
            tmp.val = x;
            System.out.println(tmp.val);
            tmp.next = null;
            hr.next = tmp;
            hr = hr.next;
        }

        hr = l2;
        for(int x: al2){
            ListNode tmp = new ListNode();
            tmp.val = x;
            tmp.next = null;
            hr.next = tmp;
            hr = hr.next;
        }

        System.out.println("Ready List1");
        hr = l1;
        while(hr != null){
            System.out.print(l1.val+ "->");
            hr = hr.next;
        }
        System.out.print("null");

        System.out.println("Ready List2");
        hr = l2;
        while(hr != null){
            System.out.print(hr.val+ "->");
            hr = hr.next;
        }
        System.out.print("null");

        System.out.println("Resulted LinkedList: ");
        ListNode resu = addTwoNumbers(l1,l2);
        while(resu != null){
            System.out.print(resu.val + "->");
            resu = resu.next;
        }
        System.out.print("null");*/

        Arr ar = new Arr();
        ar.add(1);
        ar.add(10);
        ar.add(15);
        ar.add(7);

        System.out.println(ar.toString());
        ar.remove(15);
        System.out.println(ar.toString());
        ar.add(15);
        Iterator itr = ar.iterator();
        while(itr.hasNext())
            System.out.println(itr.next());

    }

    public static int maxSubArray(int[] nums) {
        int  sum=0;
        int maxSum=nums[0];
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            maxSum=(sum>maxSum)?sum:maxSum;
            if(sum<0){
                sum=0;
            }
        }
        return maxSum;
    }

    public static int  getDecimalValue(ListNode head) {
        ListNode temp=head;
        int len=0,num=0;
        while(temp.next!=null){
            len++;
            temp=temp.next;
        }
        temp=head;
        while(len>=0){
            num+= (int) (temp.val*(Math.pow(2,len)));
            temp=temp.next;
            len--;
        }
        return num;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        long x1 = reverseNodeValue(l1);
        long x2 = reverseNodeValue(l2);
        System.out.println("x1: "+x1+", x2: "+x2);
        long res = x1+x2;
        System.out.println("res: "+ res);
        ListNode result = new ListNode();
        result.val = (int) (res%10);
        System.out.println("result val:"+(int)(res%10));
        result.next = null;
        ListNode head = result;
        res/=10;
        while(res > 0){
            ListNode tmp = new ListNode();
            tmp.val = (int) res % 10;
            tmp.next = null;
            head.next = tmp;
            head = head.next;
            res /= 10;
        }
        return result;
    }
    public static long reverseNodeValue(ListNode list){
        ArrayList<Integer> nums = new ArrayList<>();
        long sum = 0;
        while(list != null){
            nums.add(list.val);
            list = list.next;
        }
        System.out.println(nums.toString());
        for(int i = nums.size()-1; i>=0; i--){
            sum = sum * 10 + nums.get(i);
        }
        return sum;
    }
}
