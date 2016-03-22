package com.payal.roposodemo.parsing;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by payal on 18/3/16.
 */
public class StoryDetails implements Serializable {

    private static final long serialVersionUID = -5423221727488998760L;

    @SerializedName("about")
    private String about;

    @SerializedName("id")
    private String id;

    @SerializedName("username")
    private String username;

    @SerializedName("followers")
    private String followers;

    @SerializedName("following")
    private String following;

    @SerializedName("image")
    private String image;

    @SerializedName("url")
    private String url;

    @SerializedName("handle")
    private String handle;

    @SerializedName("createdOn")
    private String createdOn;

    @SerializedName("is_following")
    private String is_following;

    //////////////////////////////////

    @SerializedName("description")
    private String description;

    @SerializedName("verb")
    private String verb;

    @SerializedName("db")
    private String db;

    @SerializedName("si")
    private String si;

    @SerializedName("comment_count")
    private String comment_count;

    @SerializedName("type")
    private String type;

    @SerializedName("title")
    private String title;

    @SerializedName("like_flag")
    private String like_flag;

    @SerializedName("likes_count")
    private String likes_count;


    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFollowers() {
        return followers;
    }

    public void setFollowers(String followers) {
        this.followers = followers;
    }

    public String getFollowing() {
        return following;
    }

    public void setFollowing(String following) {
        this.following = following;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public String getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(String createdOn) {
        this.createdOn = createdOn;
    }

    public String getIs_following() {
        return is_following;
    }

    public void setIs_following(String is_following) {
        this.is_following = is_following;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVerb() {
        return verb;
    }

    public void setVerb(String verb) {
        this.verb = verb;
    }

    public String getDb() {
        return db;
    }

    public void setDb(String db) {
        this.db = db;
    }

    public String getSi() {
        return si;
    }

    public void setSi(String si) {
        this.si = si;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLike_flag() {
        return like_flag;
    }

    public void setLike_flag(String like_flag) {
        this.like_flag = like_flag;
    }

    public String getLikes_count() {
        return likes_count;
    }

    public void setLikes_count(String likes_count) {
        this.likes_count = likes_count;
    }

    public String getComment_count() {
        return comment_count;
    }

    public void setComment_count(String comment_count) {
        this.comment_count = comment_count;
    }



}
