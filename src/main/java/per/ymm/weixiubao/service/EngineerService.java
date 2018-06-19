package per.ymm.weixiubao.service;

import per.ymm.weixiubao.exception.MessageException;
import per.ymm.weixiubao.pojo.Engineer;

import java.util.List;

/**
 * @Author: ymm
 * @Date: 2018/4/14 21:42
 * @Description:
 */
public interface EngineerService {
    public List<Engineer> findAll();
    //保存一个工程师的信息
    public void save(Engineer engineer) throws MessageException;
    //根据电话查询工程师的信息
    Engineer findInfoByPhoneNumber(String phoneNumber) throws MessageException;
}
