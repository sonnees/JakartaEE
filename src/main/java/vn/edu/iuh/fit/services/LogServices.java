package vn.edu.iuh.fit.services;

import vn.edu.iuh.fit.entities.Log;
import vn.edu.iuh.fit.entities.Role;
import vn.edu.iuh.fit.repositories.LogDao;
import vn.edu.iuh.fit.repositories.RoleDao;

import java.util.List;

public class LogServices {
    private static LogDao logDao = new LogDao();
    public static  void insertLog(Log log){
        logDao.insertLog(log);
    }
    public static List<Log> getLogs(){return logDao.getLogs();}
}
