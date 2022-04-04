package model;

import java.util.List;

public class PostThreadLogic {

	public void execute(Thread thread,List<Thread> threadList) {
		
		threadList.add(0,thread);
		
	}
	
}
