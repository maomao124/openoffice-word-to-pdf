package mao.openofficewordtopdf.service.impl;

import lombok.extern.slf4j.Slf4j;
import mao.openofficewordtopdf.service.DocumentConverterService;
import org.jodconverter.core.DocumentConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Project name(项目名称)：openoffice-word-to-pdf
 * Package(包名): mao.openofficewordtopdf.service.impl
 * Class(类名): DocumentConverterServiceImpl
 * Author(作者）: mao
 * Author QQ：1296193245
 * GitHub：https://github.com/maomao124/
 * Date(创建日期)： 2023/11/23
 * Time(创建时间)： 8:50
 * Version(版本): 1.0
 * Description(描述)： 文档转换服务实现
 */

@Slf4j
@Service
public class DocumentConverterServiceImpl implements DocumentConverterService
{

    @Autowired
    private DocumentConverter documentConverter;

    @Override
    public void converter(String sourcePath, String targetPath)
    {

    }

    @Override
    public void converter(File sourcePath, File targetPath)
    {

    }

    @Override
    public void converter(InputStream inputStream, OutputStream outputStream, String sourceFileSuffix, String targetFileSuffix)
    {

    }
}
