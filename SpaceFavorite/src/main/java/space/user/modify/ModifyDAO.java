package space.user.modify;

import java.util.Map;

import org.springframework.stereotype.Repository;

import space.common.dao.AbstractDAO;

@Repository
public class ModifyDAO extends AbstractDAO{
//?��보수?�� pwd ?��?��
public String pwdcheck(Map<String,Object> map,String id) {
		return (String) selectOne("select.selectMyLogin",map);
	}

//?��보수?�� ?���? ?��?��?��?��?�� 고객?���? 불러?���? 
public Map<String,Object> selectInfo(String id) {
	return (Map<String,Object>) selectOne("select.selectMyInfo",id);
}

}
 