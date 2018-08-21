package net.pubnative.openrtb.api.request.models;

import java.util.List;

public class Content {
    public String id;
    public int episode;
    public String title;
    public String series;
    public String season;
    public String artist;
    public String genre;
    public String album;
    public String isrc;
    public Producer producer;
    public String url;
    public List<String> cat;
    public int prodq;
    @Deprecated
    public int videoquality;
    public int context;
    public String contentrating;
    public String userrating;
    public int qagmediarating;
    public String keywords;
    public int livestream;
    public int sourcerelationship;
    public int len;
    public String language;
    public int embeddable;
    public List<Data> data;
    //public Object ext;
}
