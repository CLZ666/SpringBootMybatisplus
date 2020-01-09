package com.clz.springboot.usermanage.service.impl;

import com.clz.springboot.usermanage.entity.User;
import com.clz.springboot.usermanage.mapper.UserMapper;
import com.clz.springboot.usermanage.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author clz
 * @since 2020-01-08
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
