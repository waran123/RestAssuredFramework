package com.qa.api.dunzo.test;

public class Test {

	public static void main(String [] arg)  {

		int[] arr = {9, 14, 3, 2, 43, 11, 58, 22};

		for (int i = 0; i < arr.length; i++) {
			{
				for (int j = i + 1; j < arr.length; j++) {
					
					int temp = 0 ;
					if (arr[i] < arr[j]) {
						//index = j + 1;

						temp = arr[i];
						arr[i] = arr[j];
						arr[j] = temp;
					}
				}
			}
			System.out.println(arr[i]);
		}}}




