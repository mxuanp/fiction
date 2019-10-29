package life.yaya.web.controller;

import life.yaya.po.Fiction;
import life.yaya.service.FictionService;
import life.yaya.util.LogUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * fiction controller, deal with the req about fiction
 */
@Controller
public class FictionController {
    @Autowired
    private FictionService fictionService;

    /**
     * get all fictions in database
     *
     * @return json of all fictions
     */
    @ResponseBody
    @RequestMapping(value = "/all", produces = "application/json;charset=UTF-8")
    public List<Fiction> getAllFiction() {
        LogUtil.i("it is fictionController");
        return fictionService.selectAllFictions();
    }

    /**
     * search fiction by filter in database
     *
     * @param req
     * @return json of fictions
     */
    @ResponseBody
    @RequestMapping(value = "/search", produces = "application/json;charset=utf-8")
    public List<Fiction> searchFictionByFilter(HttpServletRequest req) {
        List<Fiction> fictions = fictionService.selectFictionByFilter(req.getParameter("filter"));
        return fictions;
    }

    /**
     * search fiction by filter online, this is a spider
     *
     * @param req
     * @return json of fictions
     * @throws IOException
     */
    @ResponseBody
    @RequestMapping(value = "/searchOnline", produces = "application/json;charset=utf-8")
    public String searchOnline(HttpServletRequest req) throws IOException {
        return fictionService.selectByPython(req.getParameter("filter"));
    }

    /**
     * read the chapter of fiction
     *
     * @param req
     * @return json of the chapter
     * @throws IOException
     */
    @RequestMapping(value = "/read", produces = "application/json;charset=utf-8")
    @ResponseBody
    public String readFiction(HttpServletRequest req) throws IOException {
        return fictionService.read(Integer.valueOf(req.getParameter("id")), Integer.valueOf(req.getParameter("chapter")));
    }

    /**
     * search fiction by id in database
     *
     * @param req
     * @return fiction
     */
    @RequestMapping(value = "/info", produces = "application/json;charset=utf-8")
    @ResponseBody
    public Fiction info(HttpServletRequest req) {
        System.out.println(req.getParameter("id"));
        return fictionService.getFictionById(Integer.valueOf(req.getParameter("id")));
    }

    /**
     * get chapter list of the fiction
     *
     * @param req
     * @return json of chapters
     */
    @ResponseBody
    @RequestMapping(value = "chapter", produces = "application/json;charset=utf-8")
    public String chapter(HttpServletRequest req) throws IOException {
        return fictionService.getChapters(Integer.valueOf(req.getParameter("id")));
    }
}
