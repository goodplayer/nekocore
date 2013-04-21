package net.moetang.nekocore.lang;

public class BatchCondition {
	public static boolean allFalse(boolean... args){
		for(boolean i : args){
			if(i)
				return false;
		}
		return true;
	}
	
	public static boolean allTrue(boolean... args){
		for(boolean i : args){
			if(!i)
				return false;
		}
		return true;
	}
	
	public static boolean containsTrue(boolean... args){
		for(boolean i: args){
			if(i)
				return true;
		}
		return false;
	}
	
	public static boolean containsFalse(boolean... args){
		for(boolean i : args){
			if(!i)
				return true;
		}
		return false;
	}

}
