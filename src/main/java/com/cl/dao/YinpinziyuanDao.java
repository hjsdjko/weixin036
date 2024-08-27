package com.cl.dao;

import com.cl.entity.YinpinziyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.YinpinziyuanView;


/**
 * 音频资源
 * 
 * @author 
 * @email 
 * @date 2024-04-01 12:12:08
 */
public interface YinpinziyuanDao extends BaseMapper<YinpinziyuanEntity> {
	
	List<YinpinziyuanView> selectListView(@Param("ew") Wrapper<YinpinziyuanEntity> wrapper);

	List<YinpinziyuanView> selectListView(Pagination page,@Param("ew") Wrapper<YinpinziyuanEntity> wrapper);
	
	YinpinziyuanView selectView(@Param("ew") Wrapper<YinpinziyuanEntity> wrapper);
	
	List<YinpinziyuanView> selectGroupBy(Pagination page,@Param("ew") Wrapper<YinpinziyuanEntity> wrapper);

}
