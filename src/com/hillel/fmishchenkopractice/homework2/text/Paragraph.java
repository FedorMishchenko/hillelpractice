package com.hillel.fmishchenkopractice.homework2.text;

public class Paragraph extends Text {
    private String headLine;
    private String text;
    private String addText;

    @Override
    public void setHeadline(String headLine) {
        this.headLine = headLine;
    }
    @Override
    public void outText(String text) {
        this.text = text;
        if(headLine != null){
            System.out.println("       " + headLine);
        }
        System.out.print(text + '\n');
    }
    @Override
    public void addText(String addText) {
        this.addText = addText;
    }
}
