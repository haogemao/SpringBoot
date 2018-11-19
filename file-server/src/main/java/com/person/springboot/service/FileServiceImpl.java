package com.person.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.person.springboot.domain.File;
import com.person.springboot.repository.FileRepository;


/**
 * File 鏈嶅姟.
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 1.0.0 2017骞�3鏈�28鏃�
 */
@Service
public class FileServiceImpl implements FileService {

    @Autowired
    public FileRepository fileRepository;

    /* (non-Javadoc)
     * @see com.waylau.spring.boot.fileserver.service.FileService#saveFile(com.waylau.spring.boot.fileserver.domain.File)
     */
    @Override
    public File saveFile(File file) {
        return fileRepository.save(file);
    }

    /* (non-Javadoc)
     * @see com.waylau.spring.boot.fileserver.service.FileService#removeFile(java.lang.Long)
     */
    @Override
    public void removeFile(String id) {
        fileRepository.deleteById(id);
        ;
    }

    /* (non-Javadoc)
     * @see com.waylau.spring.boot.fileserver.service.FileService#getFileById(java.lang.Long)
     */
    @Override
    public File getFileById(String id) {
        return fileRepository.findById(id).get();
    }

    /* (non-Javadoc)
     * @see com.waylau.spring.boot.fileserver.service.FileService#listFiles()
     */
    @Override
    public List<File> listFiles() {
        return fileRepository.findAll();
    }

}
