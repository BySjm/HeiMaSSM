package cn.bysjm.domain;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class QueryVo {

    private String keyword;
    private User user;
    private List<User> list;
    private Map<String, User> map;
}
