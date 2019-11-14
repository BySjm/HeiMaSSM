package cn.bysjm.dao;

import cn.bysjm.domain.User;
import org.springframework.stereotype.Component;

@Component
public interface UserDao {
    User login(User user);
}
