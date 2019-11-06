package cn.bysjm.dao.impl;

import cn.bysjm.dao.UserDao;

import java.util.*;

public class UserDaoImpl implements UserDao {

//    private List<Object> list;
//
//    public void setList(List<Object> list) {
//        this.list = list;
//    }

//    private Set<Object> set;
//
//    public void setSet(Set<Object> set) {
//        this.set = set;
//    }

//    private Object[] array;
//
//    public void setArray(Object[] array) {
//        this.array = array;
//    }
//    private Map<String,Object> map;
//
//    public void setMap(Map<String, Object> map) {
//        this.map = map;
//    }
    private Properties properties;

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    @Override
    public void save() {
        System.out.println("dao Save方法执行了");
        //System.out.println(list);
        //System.out.println(set);
        //System.out.println(Arrays.toString(array));
        //System.out.println(map);
        System.out.println(properties);
    }
}
