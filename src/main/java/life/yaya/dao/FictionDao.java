package life.yaya.dao;

import life.yaya.po.Fiction;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Fiction DAO
 */
@Mapper
@Repository("FictionDao")
public interface FictionDao {
    /**
     * select all fictions in database
     * @return a list of all fictions
     */
    public List<Fiction> selectAllFictions();

    /**
     * select fictions by filter in database
     * @param filter a part of author's name or fiction's name
     * @return fiction list
     */
    public List<Fiction> selectFictionByFilter(String filter);

    /**
     * select fiction by id
     * @param id
     * @return fiction
     */
    public Fiction selectFictionById(Integer id);
}
