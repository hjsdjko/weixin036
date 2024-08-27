package com.cl.dao;

import com.cl.entity.WenxianziyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.WenxianziyuanView;


/**
 * 文献资源
 * 
 * @author 
 * @email 
 * @date 2024-04-01 12:12:07
 */
public interface WenxianziyuanDao extends BaseMapper<WenxianziyuanEntity> {
	
	List<WenxianziyuanView> selectListView(@Param("ew") Wrapper<WenxianziyuanEntity> wrapper);

	List<WenxianziyuanView> selectListView(Pagination page,@Param("ew") Wrapper<WenxianziyuanEntity> wrapper);
	
	WenxianziyuanView selectView(@Param("ew") Wrapper<WenxianziyuanEntity> wrapper);
	
	List<WenxianziyuanView> selectGroupBy(Pagination page,@Param("ew") Wrapper<WenxianziyuanEntity> wrapper);

}
