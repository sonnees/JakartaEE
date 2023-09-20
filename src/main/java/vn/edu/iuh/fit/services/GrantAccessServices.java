package vn.edu.iuh.fit.services;

import vn.edu.iuh.fit.entities.GrantAccess;
import vn.edu.iuh.fit.repositories.GrantAccessDao;

import java.util.List;

public class GrantAccessServices {
    private static GrantAccessDao grantAccessDao = new GrantAccessDao();
    public static void insertGrantAccess(GrantAccess grantAccess){grantAccessDao.insertGrantAccess(grantAccess);}
    public static GrantAccess searchGrantAccessByAccountId(String id){return grantAccessDao.searchGrantAccessByAccountId(id);}
    public static List<GrantAccess> getListGrantAccess(){return grantAccessDao.getListGrantAccess();}
}
