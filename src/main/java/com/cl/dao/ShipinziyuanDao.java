package com.cl.dao;

import com.cl.entity.ShipinziyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.ShipinziyuanView;


/**
 * 视频资源
 * 
 * @author 
 * @email 
 * @date 2024-04-01 12:12:08
 */
public interface ShipinziyuanDao extends BaseMapper<ShipinziyuanEntity> {
	
	List<ShipinziyuanView> selectListView(@Param("ew") Wrapper<ShipinziyuanEntity> wrapper);

	List<ShipinziyuanView> selectListView(Pagination page,@Param("ew") Wrapper<ShipinziyuanEntity> wrapper);
	
	ShipinziyuanView selectView(@Param("ew") Wrapper<ShipinziyuanEntity> wrapper);
	
	List<ShipinziyuanView> selectGroupBy(Pagination page,@Param("ew") Wrapper<ShipinziyuanEntity> wrapper);

}
