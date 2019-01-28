package com.hillel.fmishchenkopractice.homework2.text;

public class Text {
    private String headLine;
    private String text;

    public Text(String headLine,String text) {
        this.headLine = headLine;
        this.text = text;
    }

    public void setHeadline(String headLine) {
        this.headLine = headLine;
    }

    public void outText(String text) {
        this.text = text;
        if(headLine != null){
            System.out.println("\t\t\t" + headLine);
        }
        System.out.print(text + '\n');
    }
}
