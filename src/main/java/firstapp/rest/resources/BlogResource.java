package firstapp.rest.resources;

import firstapp.core.models.entities.Blog;
import org.springframework.hateoas.ResourceSupport;

/**
 * Created by Rhea on 1/24/15.
 */
public class BlogResource extends ResourceSupport{
    private String title;

    public String getTitle(){
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Blog toBlog(){
        Blog blog = new Blog();
        blog.setTitle(title);
        return blog;
    }
}
