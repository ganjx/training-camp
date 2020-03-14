package com.trining.design.template.course;


public class JavaCourse extends AbastractCourse {
    private boolean needCheckHomework = false;

    public void setNeedCheckHomework(boolean needCheckHomework) {
        this.needCheckHomework = needCheckHomework;
    }

    @Override
    protected boolean needCheckHomework() {
        return this.needCheckHomework;
    }

    protected void checkHomework() {
        System.out.println("检查Java作业");
    }
}
