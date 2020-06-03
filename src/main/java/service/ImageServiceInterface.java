package service;

import model.Image;

import java.util.List;

public interface ImageServiceInterface {
    public Image saveComment(Image image);
    public List<Image> findAll();
}