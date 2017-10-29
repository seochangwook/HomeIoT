package com.homeiot.application.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.homeiot.application.dao.TipDataDao;
import com.homeiot.application.model.TipModel;

@Service
public class TipDataServiceImpl implements TipDataService{
	@Autowired
	TipDataDao tipDataDao;
	
	@Override
	public List<Map<String, Object>> getTipDataList(Map<String, Object> paramInfo) {
		// TODO Auto-generated method stub
		List<TipModel> tipdatalist = null;
		List<Map<String, Object>> griddatalist = null;
		
		if(paramInfo.get("tip_name") == null){
			tipdatalist = tipDataDao.findAll();
			
			griddatalist = new ArrayList<Map<String, Object>>(); //뿌려줄 데이터 리스트//
			
			Map<String, Object> datasize = new HashMap<String, Object>();
			datasize.put("totcnt", tipdatalist.size());
			
			//전체 리스트 개수 저장//
			griddatalist.add(datasize);
			
			//데이터 저장//
			for(int i=0; i<tipdatalist.size(); i++){
				Map<String, Object> inputdata = new HashMap<String, Object>();
				
				inputdata.put("tip_id", tipdatalist.get(i).getTip_id());
				inputdata.put("tip_name", tipdatalist.get(i).getTip_name());
				inputdata.put("tip_content", tipdatalist.get(i).getTip_content());
				inputdata.put("tip_ref_address", tipdatalist.get(i).getTip_ref_address());
				
				griddatalist.add(inputdata);
			}
			
			for(int i=1; i<griddatalist.size(); i++){
				System.out.println("tip id: " + griddatalist.get(i).get("tip_id").toString());
				System.out.println("tip content: " + griddatalist.get(i).get("tip_content").toString());
			}
		} else if(paramInfo.get("tip_name") != null){
			System.out.println("search tip...(" + paramInfo.get("tip_name"));
		}
		
		return griddatalist;
	}
}
