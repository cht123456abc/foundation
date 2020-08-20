package cn.edu.scu.gof.composite;

public class Client {
    public static void main(String[] args) {
        Folder f1,f2;
        AbstractFile f3,f4,f5,f6,f7;

        f1 = new Folder("收藏夹");
        f2 = new Folder("视频");
        f3 = new ImageFile("图片.png");
        f4 = new TextFile("文本.txt");
        f5 = new VideoFile("视频.avi");
        f6 = new VideoFile("独孤求败.avi");
        f7 = new VideoFile("苍老师.avi");
        f1.add(f3);
        f1.add(f4);
        f1.add(f5);
        f1.add(f2);
        f2.add(f6);
        f2.add(f7);

        f1.killVirus();
    }
}
