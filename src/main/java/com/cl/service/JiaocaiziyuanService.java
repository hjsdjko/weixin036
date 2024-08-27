package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.JiaocaiziyuanEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiaocaiziyuanView;


/**
 * 教材资源
 *
 * @author 
 * @email 
 * @date 2024-04-01 12:12:07
 */
public interface JiaocaiziyuanService extends IService<JiaocaiziyuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<JiaocaiziyuanView> selectListView(Wrapper<JiaocaiziyuanEntity> wrapper);
   	
   	JiaocaiziyuanView selectView(@Param("ew") Wrapper<JiaocaiziyuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<JiaocaiziyuanEntity> wrapper);
   	
   	PageUtils queryPageGroupBy(Map<String, Object> params,Wrapper<JiaocaiziyuanEntity> wrapper);

}

