package com.english.actionfactory;

public class ActionResult {

    private Direction direction;
    private String page;

    public static final ActionResult SKIP = new ActionResult(Direction.SKIP);

    public ActionResult(Direction direction, String page) {
        this.direction = direction;
        this.page = page;
    }

    private ActionResult(Direction direction){
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
