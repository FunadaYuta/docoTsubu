package model;
import java.io.Serializable;
import java.util.List;
public class Thread implements Serializable{
	
	private String threadName;
	private List<Mutter> mutterList;
	
	public Thread(String threadName,List<Mutter> mutterList) {
		this.threadName = threadName;
		this.mutterList = mutterList;
	}

	public String getThreadName() {
		return threadName;
	}

	public List<Mutter> getMutterList() {
		return mutterList;
	}
	
	
	
}
