package com.qf.pages;

public class webform {

    private String title = "Priya";

    public String getTitle() {
        return title;
    }

    public static void main(String args[]){
        webform wf = new webform();
        System.out.println(wf.getTitle());
    }
}
