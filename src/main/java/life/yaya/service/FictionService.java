package life.yaya.service;

import life.yaya.po.Fiction;

import java.io.IOException;
import java.util.List;

/**
 * @author xuan
 */
public interface FictionService {
    /**
     * select all fictions
     *
     * @return the list of fictions
     */
    public List<Fiction> selectAllFictions();

    /**
     * select fiction by filter
     *
     * @param filter
     * @return the list of fictions
     */
    public List<Fiction> selectFictionByFilter(String filter);

    /**
     * search fiction by spider
     *
     * @param filter
     * @return
     * @throws IOException
     */
    public String selectByPython(String filter) throws IOException;

    /**
     * find fiction directory by id, and find chapter by chapter
     *
     * @param id
     * @param chapter
     * @return
     */
    public String read(int id, int chapter) throws IOException;

    /**
     * search fiction by id in database
     * @param id
     * @return
     */
    public Fiction getFictionById(Integer id);

    /**
     * get chapters of the fiction
     * @param id
     * @return
     */
    public String getChapters(Integer id) throws IOException;
}
