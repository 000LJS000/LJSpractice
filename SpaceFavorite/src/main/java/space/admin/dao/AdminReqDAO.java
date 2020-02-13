package space.admin.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import space.common.dao.AbstractDAO;

@Repository("AdminReqDAO")
public class AdminReqDAO extends AbstractDAO{

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectreqList(Map<String, Object> map) throws Exception{
		return (List<Map<String, Object>>)selectList("admin.selectreqList", map);
	}
}