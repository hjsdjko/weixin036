package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.JiaocaiziyuanDao;
import com.cl.entity.JiaocaiziyuanEntity;
import com.cl.service.JiaocaiziyuanService;
import com.cl.entity.view.JiaocaiziyuanView;

@Service("jiaocaiziyuanService")
public class JiaocaiziyuanServiceImpl extends ServiceImpl<JiaocaiziyuanDao, JiaocaiziyuanEntity> implements JiaocaiziyuanService {
	
	@Override
	public PageUtils queryPageGroupBy(Map<String, Object> params, Wrapper<JiaocaiziyuanEntity> wrapper) {
		Page<JiaocaiziyuanView> page =new Query<JiaocaiziyuanView>(params).getPage();
        page.setRecords(baseMapper.selectGroupBy(page,wrapper));
    	PageUtils pageUtil = new PageUtils(page);
    	return pageUtil;
	}
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<JiaocaiziyuanEntity> page = this.selectPage(
                new Query<JiaocaiziyuanEntity>(params).getPage(),
                new EntityWrapper<JiaocaiziyuanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<JiaocaiziyuanEntity> wrapper) {
		  Page<JiaocaiziyuanView> page =new Query<JiaocaiziyuanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<JiaocaiziyuanView> selectListView(Wrapper<JiaocaiziyuanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public JiaocaiziyuanView selectView(Wrapper<JiaocaiziyuanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
