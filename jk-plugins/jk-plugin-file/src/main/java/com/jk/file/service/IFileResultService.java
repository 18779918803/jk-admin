package com.jk.file.service;

import com.jk.common.base.IBaseService;
import com.jk.file.entity.FileResult;


/**
 * 文件服务接口层
 *
 * @author 缪隽峰
 * @version 1.0
 * @date 2018年09月11日
 */
public interface IFileResultService extends IBaseService<FileResult> {

    /**
     * 保存上传记录
     * @param entity 文件
     */
    void insertAsync(FileResult entity);

    /**
     * 根据md5查询文件
     * @param md5
     * @return 文件
     */
    FileResult selectByMd5(String md5);
}
