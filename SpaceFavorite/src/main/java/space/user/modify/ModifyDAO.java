package space.user.modify;

import java.util.Map;

import org.springframework.stereotype.Repository;

import space.common.dao.AbstractDAO;

@Repository
public class ModifyDAO extends AbstractDAO{
//? •ë³´ìˆ˜? • pwd ?™•?¸
public String pwdcheck(Map<String,Object> map,String id) {
		return (String) selectOne("select.selectMyLogin",map);
	}

//? •ë³´ìˆ˜? • ?™”ë©? ?„˜?–´?™”?„?•Œ ê³ ê°? •ë³? ë¶ˆëŸ¬?˜¤ê¸? 
public Map<String,Object> selectInfo(String id) {
	return (Map<String,Object>) selectOne("select.selectMyInfo",id);
}

}
 