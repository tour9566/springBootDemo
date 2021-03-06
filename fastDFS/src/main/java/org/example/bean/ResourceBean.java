package org.example.bean;

import java.io.Serializable;

public class ResourceBean implements Serializable {
    private static final long serialVersionUID = -2788538880352897307L;

    /**
     * 文件的访问路径
     */
    private String fileUrl;

    /**
     * 文件名称
     */
    private String fileName;

    public ResourceBean() {
        super();
    }

    public ResourceBean(String fileUrl, String fileName) {
        super();
        this.fileUrl = fileUrl;
        this.fileName = fileName;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

}