package com.english.actionfactory;

public class ActionResult {

    private Direction direction;
    private String page;

    public ActionResult(Direction direction, String page) {
        this.direction = direction;
        this.page = page;
    }

    public ActionResult(Direction direction){
        this.direction = direction;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }
}
