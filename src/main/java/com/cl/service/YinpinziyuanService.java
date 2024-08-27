package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.YinpinziyuanEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YinpinziyuanView;


/**
 * 音频资源
 *
 * @author 
 * @email 
 * @date 2024-04-01 12:12:08
 */
public interface YinpinziyuanService extends IService<YinpinziyuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YinpinziyuanView> selectListView(Wrapper<YinpinziyuanEntity> wrapper);
   	
   	YinpinziyuanView selectView(@Param("ew") Wrapper<YinpinziyuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YinpinziyuanEntity> wrapper);
   	
   	PageUtils queryPageGroupBy(Map<String, Object> params,Wrapper<YinpinziyuanEntity> wrapper);

}

