package com.chen.tool;

import java.util.List;

/**
 * 分页数据模型
 * Created by chen on 16-11-15.
 */
public class Page {
    private String pageNum;
    private String url;
    private String HtmlClass;

    private Long allCount;

    private List<Page> list;

    public Page() {
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

    /**
     * 插入数据到页面列表模型
     * @param baseUrl
     * @param now
     */
    public void push(String baseUrl,int now){
        int start=now-4;
        int end=now+5;
        this.list.clear();
        if(now==1){
            this.list.add(new Page("Previous",baseUrl+"&page=1","disable"));
        }
        for (int i=start;i<end;i++){
            String isActive="";
            if(i==now){
                isActive="active";
            }
            this.list.add(new Page(i+"",baseUrl+"&page="+i,isActive));
        }
        if(now==allCount){
            this.list.add(new Page("Previous",baseUrl+"&page="+allCount,"disable"));
        }
    }
}
