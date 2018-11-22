package net.wanho.dto;

import java.util.Date;

public class FileDto {

    private String name;
    private String absPath;
    private Date lastModifyTime;
    private int size;  //单位为M
    private boolean isFile;//true:文件；false：文件夹

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbsPath() {
        return absPath;
    }

    public void setAbsPath(String absPath) {
        this.absPath = absPath;
    }

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean getIsFile() {
        return isFile;
    }

    public void setIsFile(boolean file) {
        isFile = file;
    }

    public FileDto(String name, String absPath, Date lastModifyTime, int size, boolean isFile) {
        this.name = name;
        this.absPath = absPath;
        this.lastModifyTime = lastModifyTime;
        this.size = size;
        this.isFile = isFile;
    }

    public FileDto(String name, Date lastModifyTime, int size, boolean isFile) {
        this.name = name;
        this.lastModifyTime = lastModifyTime;
        this.size = size;
        this.isFile = isFile;
    }

    public FileDto() {
    }
}
