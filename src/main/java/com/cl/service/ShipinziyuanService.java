package com.cl.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.cl.utils.PageUtils;
import com.cl.entity.ShipinziyuanEntity;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShipinziyuanView;


/**
 * 视频资源
 *
 * @author 
 * @email 
 * @date 2024-04-01 12:12:08
 */
public interface ShipinziyuanService extends IService<ShipinziyuanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<ShipinziyuanView> selectListView(Wrapper<ShipinziyuanEntity> wrapper);
   	
   	ShipinziyuanView selectView(@Param("ew") Wrapper<ShipinziyuanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<ShipinziyuanEntity> wrapper);
   	
   	PageUtils queryPageGroupBy(Map<String, Object> params,Wrapper<ShipinziyuanEntity> wrapper);

}

