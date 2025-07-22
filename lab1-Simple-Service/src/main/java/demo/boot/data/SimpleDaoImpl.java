package demo.boot.data;

import org.springframework.stereotype.Repository;

@Repository
public class SimpleDaoImpl implements SimpleDao {

	
	public String getMessageData() {
	
		return "Data Tier...";
	}

}
