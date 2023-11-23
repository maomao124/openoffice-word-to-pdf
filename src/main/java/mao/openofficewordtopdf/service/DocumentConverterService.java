package mao.openofficewordtopdf.service;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Project name(项目名称)：openoffice-word-to-pdf
 * Package(包名): mao.openofficewordtopdf.service
 * Interface(接口名): DocumentConverterService
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/11/23
 * Time(创建时间)： 8:49
 * Version(版本): 1.0
 * Description(描述)： 文档转换服务
 */

public interface DocumentConverterService
{

    /**
     * 文档转换
     *
     * @param sourcePath 来源路径字符串
     * @param targetPath 目标路径字符串
     */
    void converter(String sourcePath, String targetPath);

    /**
     * 文档转换
     *
     * @param sourcePath 来源路径
     * @param targetPath 目标路径
     */
    void converter(File sourcePath, File targetPath);

    /**
     * 文档转换
     *
     * @param inputStream      输入流
     * @param outputStream     输出流
     * @param sourceFileSuffix 源文件后缀
     * @param targetFileSuffix 目标文件后缀
     */
    void converter(InputStream inputStream, OutputStream outputStream,
                   String sourceFileSuffix, String targetFileSuffix);
}
