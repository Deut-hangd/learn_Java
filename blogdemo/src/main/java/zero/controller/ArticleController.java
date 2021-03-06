package zero.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import zero.model.Article;
import zero.service.ArticleService;

import java.util.List;

@Controller
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @RequestMapping("/")
    public String index(Model model){
        List<Article> articles = articleService.queryArticles();
        model.addAttribute("articleList", articles);
        return "index";
    }


}
