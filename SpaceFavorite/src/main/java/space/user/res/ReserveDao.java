package space.user.res;

import java.util.Map;

import org.springframework.stereotype.Repository;

import space.common.dao.AbstractDAO;

@Repository
public class ReserveDao extends AbstractDAO{
	@SuppressWarnings("unchecked")
	public Map<String,Object> getSpaceInfo(Map<String,Object> map){
		return (Map<String,Object>)selectOne("res.getSpaceInfo",map);
	}
	@SuppressWarnings("unchecked")
	public Map<String,Object> getUserInfo(Map<String,Object> map){
		return (Map<String,Object>)selectOne("res.getUserInfo",map);
	}
	public void insertResInfo(Map<String,Object> map){
		insert("res.insertResInfo",map);
	}
}