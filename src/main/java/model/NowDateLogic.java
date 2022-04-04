package model;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class NowDateLogic {
	//現在の時間を取得
	public String execute() {
		Calendar c = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd(E) a hh:mm:ss SSS");
		String date = sdf.format(c.getTime());
		return date;
	}
	 
}
