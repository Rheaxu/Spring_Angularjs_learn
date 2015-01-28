package firstapp.rest.resources.asm;

import firstapp.core.services.util.BlogEntryList;
import firstapp.rest.mvc.BlogController;
import firstapp.rest.resources.BlogEntryListResource;
import firstapp.rest.resources.BlogEntryResource;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

import java.util.List;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

/**
 * Created by Rhea on 1/24/15.
 */
public class BlogEntryListResourceAsm extends ResourceAssemblerSupport<BlogEntryList,BlogEntryListResource>{
    public BlogEntryListResourceAsm(){
        super(BlogController.class, BlogEntryListResource.class);
    }

    @Override
    public BlogEntryListResource toResource(BlogEntryList list)
    {
        List<BlogEntryResource> resources = new BlogEntryResourceAsm().toResources(list.getEntries());
        BlogEntryListResource listResource = new BlogEntryListResource();
        listResource.setEntries(resources);
        listResource.add(linkTo(methodOn(BlogController.class).findAllBlogEntries(list.getBlogId())).withSelfRel());
        return listResource;
    }
}
