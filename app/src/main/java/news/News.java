package news;

/**
 * Created by Administrator on 2017/9/5.
 */

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class News {
    private String langType;
    private String classTag;
    private int classTagId;
    private String author;
    private String id;
    private ArrayList<String> pictures;
    private String source;
    private String time;
    private String title;
    private String url;
    private String video;
    private String intro;
    private static HashMap<String, Integer> classTagIdMap = null;
    private void classTagIdMapInit() {
        if (classTagIdMap == null) {
            classTagIdMap = new HashMap<String, Integer>();
            classTagIdMap.put("科技", 1);
            classTagIdMap.put("教育", 2);
            classTagIdMap.put("军事", 3);
            classTagIdMap.put("国内", 4);
            classTagIdMap.put("社会", 5);
            classTagIdMap.put("文化", 6);
            classTagIdMap.put("汽车", 7);
            classTagIdMap.put("国际", 8);
            classTagIdMap.put("体育", 9);
            classTagIdMap.put("财经", 10);
            classTagIdMap.put("健康", 11);
            classTagIdMap.put("娱乐", 12);
        }
    }
    public String getLangType() {return langType;}
    public String getClassTag() {return classTag;}
    public int getClassTagId() {return classTagId;}
    public String getAuthor() {return author;}
    public String getId() {return id;}
    public ArrayList<String> getPictures() {return pictures;}
    public String getSource() {return source;}
    public String getTime() {return time;}
    public String getTitle() {return title;}
    public String getUrl() {return  url;}
    public String getVideo() {return video;}
    public String getIntro() {return intro;}
    public void setLangType(final String langType_) {langType = langType_;}
    public void setClassTag(final String classTag_) {
        classTagIdMapInit();
        classTag = classTag_;
        if (classTagIdMap.containsKey(classTag))
            classTagId = classTagIdMap.get(classTag);
        else
            classTagId = 0;
    }
    public void setAuthor(String author_) {author = author_;}
    public void setId(String id_) {id = id_;}
    public void setPictures(ArrayList<String> pictures_) {pictures = pictures_;}
    public void setSource(String source_) {source = source_;}
    public void setTime(String time_) {time = time_;}
    public void setTitle(String title_) {title = title_;}
    public void setUrl(String url_) {url = url_;}
    public void setVideo(String video_) {video = video_;}
    public void setIntro(String intro_) {intro = intro_;}
    public News() {}
    public News(JSONObject jsonObject){
        classTagIdMapInit();
        try {
            langType = jsonObject.getString("lang_Type");
            classTag = jsonObject.getString("newsClassTag");
            //System.out.println("classTagIdMap : " + classTagIdMap);
            //System.out.println("classTag : " + classTag);
            if (classTagIdMap.containsKey(classTag))
                classTagId = classTagIdMap.get(classTag);
            else
                classTagId = 0;
            author = jsonObject.getString("news_Author");
            id = jsonObject.getString("news_ID");
            String pics = jsonObject.getString("news_Pictures");
            String[] picses = pics.split(";");
            pictures = new ArrayList<String>();
            for (String pic : picses) {
                pictures.add(pic);
            }// It's too complicated
            source = jsonObject.getString("news_Source");
            time = jsonObject.getString("news_Time");
            title = jsonObject.getString("news_Title");
            url = jsonObject.getString("news_URL");
            video = jsonObject.getString("news_Video");
            if (video == "")
                video = null;
            intro = jsonObject.getString("news_Intro");
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public String toString() {
        String out = new String();
        //out = out +
        return "News_toString()";
    }
}
/*
public class NewsDetail extends News {

}
*/