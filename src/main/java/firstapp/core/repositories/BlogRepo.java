package firstapp.core.repositories;

import firstapp.core.models.entities.BlogEntry;
import firstapp.core.models.entities.Blog;
import firstapp.core.services.util.BlogList;
import firstapp.core.services.util.BlogEntryList;

import java.util.List;

/**
 * Created by Rhea on 2/9/15.
 */
public interface BlogRepo {
    public Blog createBlog(Blog data);
    public List<Blog> findAllBlogs();
    public Blog findBlog(Long id);
    public Blog findBlogByTitle(String title);
    public List<Blog> findBlogsByAccount(Long accountId);
}
