package life.majiang.community.community.service;


import life.majiang.community.community.mapper.UserMapper;
import life.majiang.community.community.model.User;
import life.majiang.community.community.model.UserExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    public void createOrUpdate(User user1) {
        UserExample userExample = new UserExample();
        userExample.createCriteria().andAccountIdEqualTo(user1.getAccountId());

        List<User> users = new ArrayList<>();
        users = userMapper.selectByExample(userExample);
        if(users.size() == 0){
            user1.setGmtCreate(System.currentTimeMillis());
            user1.setGmtModified(user1.getGmtCreate());
            userMapper.insert(user1);
        }else {
            User user = users.get(0);
            User user2 = new User();
            user2.setGmtModified(System.currentTimeMillis());
            user2.setAvatarUrl(user1.getAvatarUrl());
            user2.setName(user1.getName());
            user2.setToken(user1.getToken());
            UserExample userExample1 = new UserExample();
            userExample1.createCriteria().andIdEqualTo(user.getId());
            userMapper.updateByExampleSelective(user2,userExample1);
        }
    }
}
