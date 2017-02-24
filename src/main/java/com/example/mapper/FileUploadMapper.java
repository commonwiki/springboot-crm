package com.example.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.domain.FileUpload;

public interface FileUploadMapper {

	public FileUpload findByFilename(@Param("filename") String filename);

	public void insert(FileUpload fileUpload);

	public List<FileUpload> getList();

	public int update(@Param("id") int id);
}
