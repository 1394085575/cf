package com.dao;
import java.util.List;
import com.entity.Admin;
public interface AdminDao {
    // 新增一条管理员记录
    int insert(Admin admin);

    // 更新一条管理员记录
    int update(Admin admin);

    // 删除一条管理员记录
    int delete(Integer adminId);

    // 查询所有管理员记录
    List<Admin> queryAll();

    // 登录方法
    Admin login(Admin admin);
}