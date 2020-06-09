package zero.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zero.mapper.ArticleMapper;
import zero.model.Article;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    public List<Article> queryArticles() {
        return articleMapper.selectAll();
    }
}