package com.mobile.objectRepository;

import java.util.LinkedHashSet;
import java.util.Set;

public class praveen {
	public static void main(String[] args) {

		int [] a= {12,23,33,43,12,45,33};
		Set<Integer> s=new LinkedHashSet<Integer>();
		for(int i=0;i<a.length;i++) {
			s.add(a[i]);
		}
		System.out.println(s);
			}

		}



