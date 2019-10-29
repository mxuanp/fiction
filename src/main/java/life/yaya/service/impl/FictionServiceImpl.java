package life.yaya.service.impl;

import life.yaya.conf.GlobalConf;
import life.yaya.dao.FictionDao;
import life.yaya.po.Fiction;
import life.yaya.service.FictionService;
import life.yaya.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;

/**
 * @author xuan
 * a service for fiction, implement FictionService
 */
@Service("FictionService")
public class FictionServiceImpl implements FictionService {
    @Autowired
    private FictionDao fictionDao;

    /**
     * get all fiction in database
     *
     * @return the list of fictions
     */
    @Override
    public List<Fiction> selectAllFictions() {
        return fictionDao.selectAllFictions();
    }

    /**
     * 在数据库中根据filter检索， 如果数据库中没有， 调用searchByPython进行爬虫的查询
     *
     * @param filter
     * @return the list of fictions
     */
    @Override
    public List<Fiction> selectFictionByFilter(String filter) {
        List<Fiction> fictions = fictionDao.selectFictionByFilter(filter);
        return fictions;
    }

    /**
     * search fiction by spider
     *
     * @param filter
     * @return
     * @throws IOException
     */
    @Override
    public String selectByPython(String filter) throws IOException {
        Process exec = Runtime.getRuntime().exec(new String[]{"python3", GlobalConf.downloaderDir + "search.py", filter});
        BufferedInputStream bins = new BufferedInputStream(exec.getInputStream());
        BufferedReader reader = new BufferedReader(new InputStreamReader(bins));
        StringBuilder stringBuilder = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            stringBuilder.append(line);
        }
        return stringBuilder.toString();
    }

    /**
     * @param id      fiction's id
     * @param chapter
     * @return a string of this chapter's content, and the format is json
     * @throws IOException
     */
    @Override
    public String read(int id, int chapter) throws IOException {
        File currentChapter = new File(StringUtil.splicingString(GlobalConf.fictionDir + id + "/" + chapter + ".json"));
        return getFileContent(currentChapter);
    }

    /**
     * search fiction by id in database, and update fiction
     *
     * @param id
     * @return
     */
    @Override
    public Fiction getFictionById(Integer id){
        return fictionDao.selectFictionById(id);
    }

    /**
     * get chapters of the fiction
     *
     * @param id
     * @return
     */
    @Override
    public String getChapters(Integer id) throws IOException {
        File chapters = new File(StringUtil.splicingString(GlobalConf.fictionDir + id + "/" + "list.json"));
        return getFileContent(chapters);
    }

    /**
     * read content of file
     * @param file
     * @return
     */
    private String getFileContent(File file) throws IOException {
        Long length = file.length();
        byte[] content = new byte[length.intValue()];
        FileInputStream fis = new FileInputStream(file);
        fis.read(content);
        fis.close();
        return new String(content, GlobalConf.charset);
    }
}
