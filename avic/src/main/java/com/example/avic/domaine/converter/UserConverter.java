package com.example.avic.domaine.converter;
import com.example.avic.domaine.vo.UserVo;
import com.example.avic.model.User;
import java.util.ArrayList;
import java.util.List;
public class UserConverter {
public static UserVo toVo(User bo) {
if (bo == null)
return null;
UserVo vo = new UserVo();
vo.setId(bo.getId());
vo.setEmail(bo.getEmail());
vo.setPasseword(bo.getPasseword());
return vo;
}
public static User toBo(UserVo vo) {
if (vo == null)
return null;
User bo = new User();
bo.setId(vo.getId());
bo.setEmail(vo.getEmail());
bo.setPasseword(vo.getPasseword());
return bo;
}
public static List<UserVo> toVoList (List<User> boList) {
if (boList == null || boList.isEmpty())
return null;
List<UserVo> voList = new ArrayList<>();
for (User user : boList) {
voList.add(toVo(user));
}
return voList;
}
public static List<User> toBoList (List<UserVo> voList) {
if (voList == null || voList.isEmpty())
return null;
List<User> boList = new ArrayList<>();
for (UserVo userVo : voList) {
boList.add(toBo(userVo));
}
return boList;
}
}
