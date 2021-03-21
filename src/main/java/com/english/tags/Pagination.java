package com.english.tags;

import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

public class Pagination extends TagSupport {

    private boolean hasNext;
    private int page;
    private String url;

    @Override
    public int doStartTag() {
        try {
            if(page > 1){
                pageContext.getOut().write("<a href='" + url + (page - 1) + "'>" + (page - 1) + "</a>");
            }
            pageContext.getOut().write("<a href='" + url + (page) + "'>" + (page) + "</a>");
            if(hasNext){
                pageContext.getOut().write("<a href='" + url + (page + 1) + "'>" + (page + 1) + "</a>");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return SKIP_BODY;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    public void setPage(int page) {
        this.page = page > 0 ? page : 1;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
