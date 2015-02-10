package firstapp.rest.resources.asm;

import firstapp.core.models.entities.Blog;
import firstapp.rest.mvc.AccountController;
import firstapp.rest.mvc.BlogController;
import firstapp.rest.resources.BlogResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
/**
 * Created by Rhea on 1/24/15.
 */
public class BlogResourceAsm extends ResourceAssemblerSupport<Blog,BlogResource>{

    public BlogResourceAsm(){
        super(BlogController.class, BlogResource.class);
    }

    @Override
    public BlogResource toResource(Blog blog){
        BlogResource resource = new BlogResource();
        resource.setTitle(blog.getTitle());
        resource.add(linkTo(BlogController.class).slash(blog.getId()).withSelfRel());
        resource.add(linkTo(BlogController.class).slash(blog.getId()).slash("blog-entries").withRel("entries"));
        if(blog.getOwner()!=null)
            resource.add(linkTo(AccountController.class).slash(blog.getOwner().getId()).withRel("owner"));
        return resource;
    }
}
