package space.user.modify;

import java.util.Map;

import org.springframework.stereotype.Repository;

import space.common.dao.AbstractDAO;

@Repository
public class ModifyDAO extends AbstractDAO{
//? λ³΄μ?  pwd ??Έ
public String pwdcheck(Map<String,Object> map,String id) {
		return (String) selectOne("select.selectMyLogin",map);
	}

//? λ³΄μ?  ?λ©? ??΄??? κ³ κ°? λ³? λΆλ¬?€κΈ? 
public Map<String,Object> selectInfo(String id) {
	return (Map<String,Object>) selectOne("select.selectMyInfo",id);
}

}
 