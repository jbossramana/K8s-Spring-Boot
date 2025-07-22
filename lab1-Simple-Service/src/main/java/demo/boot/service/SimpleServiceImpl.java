package demo.boot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import demo.boot.data.SimpleDao;

@Service
public class SimpleServiceImpl implements SimpleService {

	@Autowired
	SimpleDao simpleDao;
	
	public String getMessageInfo()
	{
		String msg = simpleDao.getMessageData();
		return "business tier..." + msg;
	}
}
