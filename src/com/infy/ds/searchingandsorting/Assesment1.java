package com.infy.ds.searchingandsorting;

import java.util.Scanner;

public class Assesment1 {

	public static void main (String[] args) throws java.lang.Exception
    {
        
        Scanner s = new Scanner(System.in);
        String inputString = s.nextLine();
        String[] str = inputString.split(",");
        int[] nums = new int[str.length];
        for(int i=0; i<str.length; i++) {
            nums[i]  = Integer.parseInt(str[i].trim());
        }
        
        int lsum = 0, rsum = 0;
        for(int i=0; i<nums.length; i++) {
            lsum += nums[i];
        }
        boolean flag = false; 
        int res = 0;
 
        for(int i=0; i<nums.length; i++) {
            rsum += nums[i];
            lsum = lsum - nums[i]-nums[i+1];
            if(rsum == lsum) {
                res = i;
                flag = true;
                break;
            }
        }
        if(flag) {
            System.out.println(res);
        }
        else{
            System.out.println(-1);
        }
    }
}
