package life.majiang.community.community.model;

public class Question {

    private Long id;

    private String title;

    private Long gmtCreate;

    private Long gmtModified;

    private Long creator;

    private Integer commentCount;

    private Integer viewCount;

    private Integer likeCount;

    private String tag;

    private String description;
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column QUESTION.TITLE
     *
     * @param title the value for QUESTION.TITLE
     *
     * @mbg.generated Thu Oct 10 20:47:47 CST 2019
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column QUESTION.GMT_CREATE
     *
     * @return the value of QUESTION.GMT_CREATE
     *
     * @mbg.generated Thu Oct 10 20:47:47 CST 2019
     */
    public Long getGmtCreate() {
        return gmtCreate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column QUESTION.GMT_CREATE
     *
     * @param gmtCreate the value for QUESTION.GMT_CREATE
     *
     * @mbg.generated Thu Oct 10 20:47:47 CST 2019
     */
    public void setGmtCreate(Long gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Long getGmtModified() {
        return gmtModified;
    }


    public void setGmtModified(Long gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Long getCreator() {
        return creator;
    }

    public void setCreator(Long creator) {
        this.creator = creator;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column QUESTION.VIEW_COUNT
     *
     * @return the value of QUESTION.VIEW_COUNT
     *
     * @mbg.generated Thu Oct 10 20:47:47 CST 2019
     */
    public Integer getViewCount() {
        return viewCount;
    }

    public void setViewCount(Integer viewCount) {
        this.viewCount = viewCount;
    }


    public Integer getLikeCount() {
        return likeCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column QUESTION.LIKE_COUNT
     *
     * @param likeCount the value for QUESTION.LIKE_COUNT
     *
     * @mbg.generated Thu Oct 10 20:47:47 CST 2019
     */
    public void setLikeCount(Integer likeCount) {
        this.likeCount = likeCount;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column QUESTION.TAG
     *
     * @return the value of QUESTION.TAG
     *
     * @mbg.generated Thu Oct 10 20:47:47 CST 2019
     */
    public String getTag() {
        return tag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column QUESTION.TAG
     *
     * @param tag the value for QUESTION.TAG
     *
     * @mbg.generated Thu Oct 10 20:47:47 CST 2019
     */
    public void setTag(String tag) {
        this.tag = tag == null ? null : tag.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column QUESTION.DESCRIPTION
     *
     * @return the value of QUESTION.DESCRIPTION
     *
     * @mbg.generated Thu Oct 10 20:47:47 CST 2019
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column QUESTION.DESCRIPTION
     *
     * @param description the value for QUESTION.DESCRIPTION
     *
     * @mbg.generated Thu Oct 10 20:47:47 CST 2019
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                ", creator=" + creator +
                ", commentCount=" + commentCount +
                ", viewCount=" + viewCount +
                ", likeCount=" + likeCount +
                ", tag='" + tag + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}