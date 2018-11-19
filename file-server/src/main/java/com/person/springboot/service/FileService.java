/**
 *
 */
package com.person.springboot.service;

import java.util.List;

import com.person.springboot.domain.File;


/**
 * File 鏈嶅姟鎺ュ彛.
 *
 * @author <a href="https://waylau.com">Way Lau</a>
 * @since 1.0.0 2017骞�3鏈�28鏃�
 */
public interface FileService {
    /**
     * 淇濆瓨鏂囦欢
     *
     * @param File
     * @return
     */
    File saveFile(File file);

    /**
     * 鍒犻櫎鏂囦欢
     *
     * @param File
     * @return
     */
    void removeFile(String id);

    /**
     * 鏍规嵁id鑾峰彇鏂囦欢
     *
     * @param File
     * @return
     */
    File getFileById(String id);

    /**
     * 鑾峰彇鏂囦欢鍒楄〃
     *
     * @param File
     * @return
     */
    List<File> listFiles();
}
