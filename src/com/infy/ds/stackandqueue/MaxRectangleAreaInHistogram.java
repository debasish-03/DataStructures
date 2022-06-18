package com.infy.ds.stackandqueue;
import java.util.Stack;

public class MaxRectangleAreaInHistogram {
	public static void main(String[] args) {
		int[] arr= {2,3};
		System.out.println(rectangleArea(arr));
	}
	private static int rectangleArea(int[] heights) {
		int maxArea = Integer.MIN_VALUE;
		
		for(int i=0; i<heights.length; i++) {
			int left = 0, right = heights.length-1;
			for(int j=i-1; j>=0; j--) {
				if(heights[j] < heights[i]) {
					left = j+1;
					break;
				}
			}
			for(int j=i+1; j<heights.length; j++) {
				if(heights[j] < heights[i]) {
					right = j-1;
					break;
				}
			}
			System.out.println(left+" "+right+"=>"+heights[i]);
			maxArea = Math.max(maxArea, (right-left+1)*heights[i]);
		}
		
		return maxArea;
	}
    private static int largestRectangleArea(int[] heights) {
        int[] leftSmallElement = new int[heights.length];
        int[] rightSmallElement = new int[heights.length];
        Stack<Integer> stL = new Stack<>();
        
        // leftSmallElement[0] = 0;
        // stL.push(0);
        for(int i=0; i<heights.length; i++) {
            while(!stL.isEmpty() && heights[stL.peek()] >= heights[i]) {
                stL.pop();
            }
            if(stL.isEmpty()) {
                leftSmallElement[i] = 0;
            } else {
            	System.out.println(stL.isEmpty());
                leftSmallElement[i] = stL.peek()+1;
            }
            stL.push(i);
        }
        
        
        Stack<Integer> stR = new Stack<>();
        for(int i=heights.length-1; i>=0; i--) {
            while(!stR.isEmpty() && heights[stR.peek()] >= heights[i]) {
                stR.pop();   
            }
            if(stR.isEmpty()) {
                 rightSmallElement[i] = heights.length-1;
            }else {
                rightSmallElement[i] = stR.peek()-1;
            }
            stR.push(i);
        }
        int max = Integer.MIN_VALUE;
        for(int i=0; i<heights.length; i++) {
            //if()
            int curr = (rightSmallElement[i]-leftSmallElement[i]+1)*heights[i];
            max = Math.max(max, curr);
        }
        for(int i:leftSmallElement) {
        	System.out.print(i+" ");
        }
        System.out.println();
        for(int i:rightSmallElement) {
        	System.out.print(i+" ");
        }
        return max;
        
    }
}
