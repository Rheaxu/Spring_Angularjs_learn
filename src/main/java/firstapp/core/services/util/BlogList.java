package firstapp.core.services.util;

import firstapp.core.models.entities.Blog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rhea on 1/24/15.
 */
public class BlogList {
    private List<Blog> blogs = new ArrayList<Blog>();

    public List<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(List<Blog> blogs) {
        this.blogs = blogs;
    }
}
