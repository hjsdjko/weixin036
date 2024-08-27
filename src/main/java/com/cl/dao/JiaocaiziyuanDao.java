package com.cl.dao;

import com.cl.entity.JiaocaiziyuanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.JiaocaiziyuanView;


/**
 * 教材资源
 * 
 * @author 
 * @email 
 * @date 2024-04-01 12:12:07
 */
public interface JiaocaiziyuanDao extends BaseMapper<JiaocaiziyuanEntity> {
	
	List<JiaocaiziyuanView> selectListView(@Param("ew") Wrapper<JiaocaiziyuanEntity> wrapper);

	List<JiaocaiziyuanView> selectListView(Pagination page,@Param("ew") Wrapper<JiaocaiziyuanEntity> wrapper);
	
	JiaocaiziyuanView selectView(@Param("ew") Wrapper<JiaocaiziyuanEntity> wrapper);
	
	List<JiaocaiziyuanView> selectGroupBy(Pagination page,@Param("ew") Wrapper<JiaocaiziyuanEntity> wrapper);

}
