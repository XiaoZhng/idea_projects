package com.zledu.enum_;

public class EnumDetail {
    public static void main(String[] args) {
        Music.CLASSMUSIC.play();
    }
}

interface IPlay{
    void play();
}
enum Music implements IPlay{
    CLASSMUSIC;
    @Override
    public void play() {
        System.out.println("音乐播放...");
    }
}