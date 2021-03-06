package firstapp.rest.resources.asm;

import firstapp.core.models.entities.BlogEntry;
import firstapp.rest.mvc.BlogController;
import firstapp.rest.mvc.BlogEntryController;
import firstapp.rest.resources.BlogEntryResource;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

/**
 * Created by Rhea on 1/24/15.
 */
public class BlogEntryResourceAsm  extends ResourceAssemblerSupport<BlogEntry,BlogEntryResource>{
    public BlogEntryResourceAsm()
    {
        super(BlogEntryController.class, BlogEntryResource.class);
    }

    @Override
    public BlogEntryResource toResource(BlogEntry blogEntry)
    {
        BlogEntryResource res = new BlogEntryResource();
        res.setTitle(blogEntry.getTitle());
        res.setContent(blogEntry.getContent());
        Link self = linkTo(BlogEntryController.class).slash(blogEntry.getId()).withSelfRel();
        res.add(self);
        if(blogEntry.getBlog()!=null)
        {
            res.add((linkTo(BlogController.class).slash(blogEntry.getBlog().getId()).withRel("blog")));
        }
        return res;
    }
}
