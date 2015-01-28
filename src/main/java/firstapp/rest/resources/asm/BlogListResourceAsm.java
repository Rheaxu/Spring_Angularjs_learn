package firstapp.rest.resources.asm;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import firstapp.core.services.util.BlogList;
import firstapp.rest.mvc.BlogController;
import firstapp.rest.resources.BlogListResource;



/**
 * Created by Rhea on 1/24/15.
 */
public class BlogListResourceAsm extends ResourceAssemblerSupport<BlogList, BlogListResource> {

    public BlogListResourceAsm()
    {
        super(BlogController.class, BlogListResource.class);
    }

    @Override
    public BlogListResource toResource(BlogList blogList) {
        BlogListResource res = new BlogListResource();
        res.setBlogs(new BlogResourceAsm().toResources(blogList.getBlogs()));
        return res;
    }
}