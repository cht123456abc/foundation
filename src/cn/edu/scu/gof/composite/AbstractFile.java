package cn.edu.scu.gof.composite;

import java.util.ArrayList;
import java.util.List;

public interface AbstractFile {

    void killVirus();
}

class ImageFile implements AbstractFile {
    private String name;

    public ImageFile(String name) {
        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println("图像文件：{" +  name + " }，进行查杀");
    }
}

class TextFile implements AbstractFile {
    private String name;

    public TextFile(String name) {
        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println("文本文件：{" +  name + " }，进行查杀");
    }
}

class VideoFile implements AbstractFile {
    private String name;

    public VideoFile(String name) {
        this.name = name;
    }

    @Override
    public void killVirus() {
        System.out.println("视频文件：{" +  name + " }，进行查杀");
    }
}

class Folder implements AbstractFile {
    private String name;
    private List<AbstractFile> list = new ArrayList<>();


    public Folder(String name) {
        this.name = name;
    }

    public void add(AbstractFile abstractFile) {
        list.add(abstractFile);
    }

    public void remove(AbstractFile abstractFile) {
        list.remove(abstractFile);
    }

    public AbstractFile getChild(int index) {
        return list.get(index);
    }

    @Override
    public void killVirus() {
        System.out.println("文件夹：{" +  name + " }，进行查杀");


        if (!list.isEmpty()) {
            System.out.println("--");
            for (AbstractFile child : list) {
                child.killVirus();
            }
        }
    }
}