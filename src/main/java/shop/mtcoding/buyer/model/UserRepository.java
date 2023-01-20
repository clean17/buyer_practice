package shop.mtcoding.buyer.model;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/* 유저의 기능
    회원가입, 로그인, 회원탈퇴, 회원수정 - 기능을 알고 있을때 / 기능을 모르면 CRUD 만 설정해놓는다 ( 초보는 이것부터 연습 )
 */
@Mapper
public interface UserRepository {
    // public int insert(@Param("username") String username, @Param("password") String password, @Param("email") String email);
    // public User login(@Param("username") String username, @Param("password") String password);
    // public int delete(@Param("id") int id);
    // public int updatePassword(@Param("id") int id, @Param("password") String password);

    public int insert(@Param("username") String username, @Param("password") String password, @Param("email") String email);
    public List<User> findAll();
    public User findById(int id);
    public int updateById(@Param("id") int id, @Param("password") String password);
    public int deleteById(@Param("id") int id);
    public User findByUsernameAndPassword(@Param("username")String username, @Param("password")String password);
}
