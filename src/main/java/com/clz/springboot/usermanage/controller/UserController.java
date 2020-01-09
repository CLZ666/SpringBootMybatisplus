package com.clz.springboot.usermanage.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.clz.springboot.usermanage.entity.User;
import com.clz.springboot.usermanage.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author clz
 * @since 2020-01-08
 */
@RestController
@RequestMapping("/usermanage/user")
public class UserController {
    @Autowired
    private IUserService userService;

    @GetMapping("/getById")
    public User getUserById() {
        User user = userService.getById(1);
        userService.list();
        return user;
    }

    @GetMapping("/addUser")
    public User addUser() {
        User user = new User();
        user.setName("小明");
        user.setAge(12);
        user.setEmail("2326525@qq.com");
        userService.save(user);
        return user;
    }

    @GetMapping("/update")
    public User updateUser() {
        User user = new User();
        user.setId(6);
        user.setName("小红");
        user.setAge(15);
        user.setEmail("192165@qq.com");
        userService.updateById(user);
        return user;
    }

    @GetMapping("/saveUpdate")
    public User saveUpdateUser() {
        User user = new User();
        user.setId(6);
        user.setName("笑死");
        user.setAge(54);
        user.setEmail("295812@qq.com");
        userService.saveOrUpdate(user);
        return user;
    }

    @GetMapping("/list")
    public List<User> list() {
        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(4);
        ids.add(6);
        List<User> users = null;
        // 查询（根据ID 批量查询）
        users = userService.listByIds(ids);
        List<Map<String, Object>> maps = userService.listMaps();
        System.out.println(maps);
        return users;
    }

    @GetMapping("/page")
    public IPage<User> listPage() {
        Page<User> page = new Page<User>(3, 2);
        IPage<User> pageList = userService.page(page);
        return pageList;
    }

    @GetMapping("/count")
    public int count() {
        int count = userService.count();
        return count;
    }

    /**
     * 条件构造器
     *
     * @return
     */
    @GetMapping("/wrapper")
    public List<User> wrapper() {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        Map<String, Object> wrapperMap;
        wrapperMap = new HashMap<>();
//        wrapperMap.put("id", 3);
        wrapperMap.put("name", "Tom");
        /**
         * allEq(Map<R, V> params)
         * allEq(Map<R, V> params, boolean null2IsNull)
         * allEq(boolean condition, Map<R, V> params, boolean null2IsNull)
         * 例1: allEq({id:1,name:"老王",age:null})--->id = 1 and name = '老王' and age is null
         * 例2: allEq({id:1,name:"老王",age:null}, false)--->id = 1 and name = '老王'
         * */
        // queryWrapper.allEq(wrapperMap, false);
        /**
         * allEq(BiPredicate<R, V> filter, Map<R, V> params)
         * allEq(BiPredicate<R, V> filter, Map<R, V> params, boolean null2IsNull)
         * allEq(boolean condition, BiPredicate<R, V> filter, Map<R, V> params, boolean null2IsNull)
         */
        //queryWrapper.allEq((k, v) -> v == "Tom", wrapperMap);
        //eq("name", "老王")--->name = '老王'
        //queryWrapper.eq("name", "笑死");
        //不等于 <>
        //例: ne("name", "老王")--->name <> '老王'
        //queryWrapper.ne("name","Tom");
        //BETWEEN 值1 AND 值2
        //例: between("age", 18, 30)--->age between 18 and 30
        //queryWrapper.between("age",24,28);
        //NOT BETWEEN 值1 AND 值2
        //例: notBetween("age", 18, 30)--->age not between 18 and 30
        //queryWrapper.notBetween("age", 18, 24);
        //LIKE '%值%'
        //例: like("name", "王")--->name like '%王%'
        //queryWrapper.like("name","J");
        //LIKE '%值'
        //例: likeLeft("name", "王")--->name like '%王'
        //LIKE '值%'
        //例: likeRight("name", "王")--->name like '王%'
        //queryWrapper.likeRight("name", "m");
        //字段 IN (value.get(0), value.get(1), ...)
        //例: in("age",{1,2,3})--->age in (1,2,3)
        //queryWrapper.in("age", 16, 24, 54);
        //例: inSql("age", "1,2,3,4,5,6")--->age in (1,2,3,4,5,6)
        //例: inSql("id", "select id from table where id < 3")--->id in (select id from table where id < 3)
        //queryWrapper.inSql("id","select id from user where id >5");
        //分组：GROUP BY 字段, ...
        //例: groupBy("id", "name")--->group by id,name
        //queryWrapper.groupBy("id","name");
        //orderByAsc(R... columns)
        //orderByAsc(boolean condition, R... columns)
        queryWrapper.orderBy(true,true,"age");
        List<User> users = userService.list(queryWrapper);

        return users;
    }
}
