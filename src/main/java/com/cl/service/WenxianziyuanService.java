package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.WenxianziyuanEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.WenxianziyuanView;


/**
 * 文献资源
 *
 * @author 
 * @email 
 * @date 2024-04-01 12:12:07
 */
public interface WenxianziyuanService extends IService<WenxianziyuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WenxianziyuanView> selectListView(Wrapper<WenxianziyuanEntity> wrapper);
   	
   	WenxianziyuanView selectView(@Param("ew") Wrapper<WenxianziyuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WenxianziyuanEntity> wrapper);
   	
   	PageUtils queryPageGroupBy(Map<String, Object> params,Wrapper<WenxianziyuanEntity> wrapper);

}

