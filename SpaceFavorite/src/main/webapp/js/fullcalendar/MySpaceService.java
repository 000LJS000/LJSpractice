package space.main.service;

import java.util.List;
import java.util.Map;

interface MySpaceService {
	List<Map<String,Object>> selectMySpaceList(Map<String,Object> map);
	void deleteApplyBoard(Map<String,Object> map);
	void deleteSpaceBoard(Map<String,Object> map);
	void holdSpaceBoard(Map<String,Object> map);
	void modifySpaceBoard(Map<String,Object> map);
	
}
