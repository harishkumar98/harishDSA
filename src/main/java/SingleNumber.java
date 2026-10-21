class SingleNumber {
    static {
        for(int i=0;i<1;i++){
            //singleNumber(new int[]{1,2,2,3,3,5,6,6,5});
            System.out.println("Single number: "+ singleNumber(new int[]{1,1,2,2,3,5,5}));
        }
    }
    public static int singleNumber(int[] nums) {
        int i,sum=0;
        for(i=0;i<nums.length;i++){
            sum^=nums[i];
            System.out.println(sum);
        }
        return sum;
    }
}