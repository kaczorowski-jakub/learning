package generic;

import java.util.ArrayList;
import java.util.List;

import checker.Test;

public class Main {

	public static void main(String[] args) {
		
		InterImpl<String, Integer> ii1 = new InterImpl<>();
		InterImpl ii2 = ii1;
		
		GenMethod gm = new GenMethod();
		GenMethod.<String,Integer>getValue("ASDSA", 12);
		//GenMethod.<int,byte>getValue(1,012b);
		GenMethod.<Integer,Byte>getValue(1,(byte)12);
		
		gm.<String,Integer>getValue2("SDSAD",12);
		gm.getValue2(12,"SDSAD");
		
		//gm.getValue5(new ArrayList<Integer>()); // blad bo ArrayList<Integer> nie jest podklasa List<Number
		gm.getValue5(new ArrayList<Number>());
		
		GenBound<Test> gb = new GenBound<>();
		gb.test(new Test());
		gb.print();
		
		GenBound<Test> gb2 = new GenBound<>();
		gb2.test(new Test2());
		gb2.print();
		
		//GenBound.test("test");	// K extend Number
		GenBound.test(1221);
		GenBound.test(new Integer(12));
		
		TestInt2<String,Integer> l1 = new TestInt2Impl<String,Integer>();
		List<String> l2 = new TestInt2Impl<String,Integer>();
	}
	
	private static class Test2 extends Test {
		
		@Override
		public String toString() {
			return "DUPA";
		}
	}
}
