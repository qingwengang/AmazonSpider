package com.ganggang.Util;

import com.ganggang.Dao.LogDao;
import com.ganggang.Entity.Log;

public class LogHelper {
	public static void AddLog(String type,String content){
		LogDao.AddLog(new Log(type,content));
	}
	
	public static void main(String[] args){
		AddLog("fds","fdsfs");
	}
	
}
