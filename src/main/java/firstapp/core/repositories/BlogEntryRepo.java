package firstapp.core.repositories;

import firstapp.core.models.entities.Blog;
import firstapp.core.models.entities.BlogEntry;

import java.util.List;

/**
 * Created by Rhea on 2/9/15.
 */
public interface BlogEntryRepo {

    public BlogEntry findBlogEntry(Long id);    // Returns the BlogEntry or null if it can't be found
    public BlogEntry deleteBlogEntry(Long id);  // Deletes the found BlogEntry or returns null if it can't be found

    /**
     *
     * @param id: the id of the BlogEntry to update BlogEntry
     * @param data: the BlogEntry containing the data to be used for the updateBlogEntry
     * @return the updated BlogEntry or null if the BlogEntry with the id cannot be found
     */
    public BlogEntry updateBlogEntry(Long id,BlogEntry data);

    public BlogEntry createBlogEntry(BlogEntry data);

    public List<BlogEntry> findByBlogId(Long blogId);
}
