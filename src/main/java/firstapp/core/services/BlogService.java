package firstapp.core.services;

import firstapp.core.models.entities.Blog;
import firstapp.core.models.entities.BlogEntry;
import firstapp.core.services.util.BlogEntryList;
import firstapp.core.services.util.BlogList;

/**
 * Created by Rhea on 1/24/15.
 */
public interface BlogService {

    /**
     *
     * @param blogId the id of the blog to add this BlogEntry to
     * @param data the BlogEntry containing the data to be used for creating the new entity
     * @return the created BlogEntry with a generated ID
     * @throws firstapp.core.services.exceptions.BlogNotFoundException if the blog the add to connot be found
     */
    public BlogEntry createBlogEntry(Long blogId, BlogEntry data);

    public BlogList findAllBlogs();

    public BlogEntryList findAllBlogEntries(Long blogId);   // findBlog all associated blog entries

    public Blog findBlog(Long id);
}
