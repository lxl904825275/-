package com.service;

import com.dao.UserDao;
import com.entity.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author : liuxulong
 * date : 18:48 2019/4/15
 */
@Service
public class UserService {
    @Resource
    private UserDao dao=new UserDao();

    public List<User> queryPage(int pageIndex, int pageCopunt){return dao.queryPage(pageIndex,pageCopunt);}
    public int Page(int pageCount){return  dao.Page(pageCount);}
    public int add(User user){return  dao.add(user);}
    public int update(User user){return dao.update(user);}
    public int delete(int id){return dao.delete(id);}
    public User queryOne(int id){return dao.queryOne(id);}

}
