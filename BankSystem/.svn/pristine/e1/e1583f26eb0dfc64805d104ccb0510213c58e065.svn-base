package com.web.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.web.biz.TrainBiz;
import com.web.dao.TrainDao;
import com.web.entity.Train;

@Service
public class TrainBizImpl implements TrainBiz {
	
	@Resource
	TrainDao tdao;

	@Override
	public int insertTrain(Train train) {
		return tdao.insertTrain(train);
	}

	@Override
	public int updateTrain(Train train) {
		return tdao.updateTrain(train);
	}

	@Override
	public int deleteTrain(int trainId) {
		return tdao.deleteTrain(trainId);
	}

	@Override
	public List<Train> findAllTrain() {
		return tdao.findAllTrain();
	}

}
