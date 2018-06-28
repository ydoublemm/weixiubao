package per.ymm.weixiubao.service;

import per.ymm.weixiubao.exception.MessageException;
import per.ymm.weixiubao.pojo.Engineer;
import per.ymm.weixiubao.dto.PageDTO;

import java.util.List;
import java.util.Map;

/**
 * @Author: ymm
 * @Date: 2018/4/14 21:42
 * @Description:
 */
public interface EngineerService {
    //查询所有工程师信息
    List<Engineer> findAll();

    //保存一个工程师的信息
    void save(Engineer engineer) throws MessageException;

    //根据电话查询工程师的信息
    Engineer findInfoByPhoneNumber(String phoneNumber) throws MessageException;

    //分页查询工程师信息
    Map getInfoByPage(PageDTO page);

    //通过id修改工程师信息
    boolean updateInfoById(Engineer engineer) throws MessageException;
    //通过id删除工程师信息
    boolean deleteEngineerByid(Integer id);



}
