package com.chen.tool;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 分页数据模型
 * Created by chen on 16-11-15.
 */
public class Page {

    public static int pageSize=10;

    private String pageNum;
    private String url;
    private String HtmlClass;

    //页面总数
    private Long allCount;

    private List<Page> list=new ArrayList<Page>();

    public Page(Long allCount) {
        this.allCount=allCount;
    }

    public Page(String pageNum, String url, String HtmlClass) {
        this.pageNum = pageNum;
        this.url = url;
        this.HtmlClass = HtmlClass;
    }

    public String getPageNum() {
        return pageNum;
    }

    public void setPageNum(String pageNum) {
        this.pageNum = pageNum;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHtmlClass() {
        return HtmlClass;
    }

    public void setHtmlClass(String htmlClass) {
        HtmlClass = htmlClass;
    }

    public List<Page> getList() {
        return list;
    }

    public void setList(List<Page> list) {
        this.list = list;
    }

    public Long getAllCount() {
        return allCount;
    }

    public void setAllCount(Long allCount) {
        this.allCount = allCount;
    }


    public void push(List<String[]> list,int now){
        String baseUrl=list.remove(0)[0];
        String param="";
        for (String[] str:list){
                param+=str[0]+"="+str[1]+"&";
        }

        int start=0;
        int end=0;
        if(allCount>0){
            if(allCount<4){
                start=1;
                end=allCount.intValue();
            }else{
                start=now-4;
                if(now+5>allCount){
                    end=allCount.intValue();
                }else{
                    end=now+5;
                }
            }
        }else{
            start=1;
            end=1;
        }

        this.list.clear();
        if(now==1){
            this.list.add(new Page("Previous",baseUrl+"?page=1&"+param,"disable"));
        }
        for (int i=start;i<=end;i++){
            String isActive="";
            if(i==now){
                isActive="active";
            }
            this.list.add(new Page(i+"",baseUrl+"?page="+i+"&"+param,isActive));
        }
        if(now==allCount){
            this.list.add(new Page("Previous",baseUrl+"?page="+allCount+"&","disable"));
        }
    }
    /**
     * 插入数据到页面列表模型
     * @param baseUrl
     * @param now
     */
    public void push(String baseUrl,int now){
        List<String[]> list=new ArrayList<String[]>();
        String[] base={baseUrl};
        list.add(base);
        this.push(list,now);
    }
}
