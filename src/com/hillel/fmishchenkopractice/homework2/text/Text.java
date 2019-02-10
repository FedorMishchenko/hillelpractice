package com.hillel.fmishchenkopractice.homework2.text;

class Text {
    private String headLine;
    private String text;

    Text(String headLine, String text) {
        this.headLine = headLine;
        this.text = text;
    }

    void setHeadline(String headLine) {
        this.headLine = headLine;
    }

    void outText(String text) {
        this.text = text;
        if(headLine != null){
            System.out.println("\t\t\t" + headLine);
        }
        System.out.print(text + '\n');
    }
}
